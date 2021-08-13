package it.deas.sdfgateway.v1.mapper;

import it.deas.sdfgateway.model.Application;
import it.deas.sdfgateway.v1.dto.ApplicationDTO;
import it.deas.sdfgateway.v1.dto.RegisterAppDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface ApplicationInfoMapper {
    ApplicationInfoMapper instance = Mappers.getMapper( ApplicationInfoMapper.class );

    @Mapping(target = "id", ignore = true)
    Application registerAppFromDTO(RegisterAppDTO appRegistration);

    ApplicationDTO toDTO(Application newApp);
}
