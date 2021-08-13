package it.deas.sdfgateway.v1.controller;

import it.deas.sdfgateway.service.SDFService;
import it.deas.sdfgateway.v1.dto.ApplicationDTO;
import it.deas.sdfgateway.v1.dto.NewStreamDTO;
import it.deas.sdfgateway.v1.dto.RegisterAppDTO;
import it.deas.sdfgateway.v1.dto.StreamDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController("/management")
public class ManagementController {
    SDFService sdfService;

    public ManagementController(SDFService sdfService) {
        this.sdfService = sdfService;
    }

    @PostMapping("/app/register")
    public ApplicationDTO registerApplication(@RequestBody @Valid RegisterAppDTO appRegistration) {
        return sdfService.registerApplication(appRegistration);
    }

    @PostMapping("/app/deploy")
    public StreamDTO deployStream(@RequestBody @Valid NewStreamDTO deployStream) {
        return sdfService.deployStream(deployStream);
    }
}
