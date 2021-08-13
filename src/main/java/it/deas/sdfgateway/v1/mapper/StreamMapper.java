package it.deas.sdfgateway.v1.mapper;

import it.deas.sdfgateway.model.Stream;
import it.deas.sdfgateway.v1.dto.NewStreamDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper()
public interface StreamMapper {
    StreamMapper instance = Mappers.getMapper( StreamMapper.class );

    Stream fromDTO(NewStreamDTO streamDTO);
}
