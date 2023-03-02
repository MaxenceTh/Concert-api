package com.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.entities.Concert;
import com.dtos.ConcertDto;
public interface ConcertMapper {
    ConcertMapper INSTANCE = Mappers.getMapper(ConcertMapper.class);

    @Mapping(source="Id", target="Id")
    ConcertDto concertEntityToDto(Concert concert);
}
/*A voir comment ça fonctionne*/