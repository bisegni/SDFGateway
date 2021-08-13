package it.deas.sdfgateway.service;

import it.deas.sdfgateway.exception.AppAlreadyRegisteredException;
import it.deas.sdfgateway.model.Application;
import it.deas.sdfgateway.model.Stream;
import it.deas.sdfgateway.model.StreamApplication;
import it.deas.sdfgateway.repository.ApplicationRepository;
import it.deas.sdfgateway.repository.SDFRepository;
import it.deas.sdfgateway.repository.StreamApplicationRepository;
import it.deas.sdfgateway.repository.StreamRepository;
import it.deas.sdfgateway.v1.dto.*;
import it.deas.sdfgateway.v1.mapper.ApplicationInfoMapper;
import it.deas.sdfgateway.v1.mapper.StreamMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Optional;

@Service
public class SDFService {
    private final SDFRepository sdfRepository;
    private final TransactionTemplate transactionTemplate;
    private final ApplicationRepository applicationRepository;
    private final StreamRepository streamRepository;
    private final StreamApplicationRepository streamApplicationRepository;

    public SDFService(SDFRepository sdfRepository, TransactionTemplate transactionTemplate, ApplicationRepository applicationRepository, StreamRepository streamRepository, StreamApplicationRepository streamApplicationRepository) {
        this.sdfRepository = sdfRepository;
        this.transactionTemplate = transactionTemplate;
        this.applicationRepository = applicationRepository;
        this.streamRepository = streamRepository;
        this.streamApplicationRepository = streamApplicationRepository;
    }

    /**
     * @param appRegistration
     * @return
     */
    public ApplicationDTO registerApplication(RegisterAppDTO appRegistration) {
        //save application
        Optional<Application> foundApp = applicationRepository.findByName(
                appRegistration.getName()
        );
        if (foundApp.isPresent()) {
            throw new AppAlreadyRegisteredException(foundApp.get().getName());
        }
        //save and register in single transaction
        Application newApp = transactionTemplate.execute(transactionStatus -> {
            Application app = applicationRepository.save(ApplicationInfoMapper.instance.registerAppFromDTO(appRegistration));
            sdfRepository.registerApplication(app);
            return app;
        });
        return ApplicationInfoMapper.instance.toDTO(newApp);
    }

    /**
     * @param deployStreamDTO
     */
    public StreamDTO deployStream(NewStreamDTO streamDTO) {
        Stream s = StreamMapper.instance.fromDTO(streamDTO);
        s = transactionTemplate.execute(transactionStatus -> {
            Stream s = streamRepository.save(s);
            for (StreamApplicationDTO saDTO :
                    streamDTO.getApplications()) {
                StreamApplication sa = StreamMapper.instance.fromDTO(saDTO);
                sa.setStream(s);
                streamApplicationRepository.save(sa);
            }
            return s;
        }
        );
        return null;
    }
}
