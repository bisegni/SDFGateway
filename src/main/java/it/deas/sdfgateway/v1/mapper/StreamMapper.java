package it.deas.sdfgateway.v1.mapper;

import it.deas.sdfgateway.model.Stream;
import it.deas.sdfgateway.model.StreamApplication;
import it.deas.sdfgateway.v1.dto.NewStreamDTO;
import it.deas.sdfgateway.v1.dto.StreamApplicationDTO;
import it.deas.sdfgateway.v1.dto.StreamDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface StreamMapper {
    StreamMapper instance = Mappers.getMapper( StreamMapper.class );

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "applications", ignore = true)
    Stream fromDTO(NewStreamDTO streamDTO);
    @Mapping(target = "stream", ignore = true)
    @Mapping(target = "id", ignore = true)
    StreamApplication fromDTO(StreamApplicationDTO streamDTO);

    StreamDTO toDTO(Stream stream);
}
