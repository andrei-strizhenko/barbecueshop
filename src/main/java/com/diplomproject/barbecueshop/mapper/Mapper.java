package com.diplomproject.barbecueshop.mapper;

import com.diplomproject.barbecueshop.dto.GenericDto;
import com.diplomproject.barbecueshop.model.GenericModel;
import org.springframework.stereotype.Component;

import java.util.List;

public interface Mapper<E extends GenericModel, D extends GenericDto> {

    E toEntity(D dto);
    List<E> toEntities(List<D> dtos);

    D toDto(E entity);
    List<D> toDtos(List<E> entities);



}

