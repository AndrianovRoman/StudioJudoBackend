package com.example.studioJudo.service.mapper;

public interface Mapper<DTO, ENTITY> {

    DTO toDto(ENTITY entity);

    ENTITY toEntity(DTO dto);

}