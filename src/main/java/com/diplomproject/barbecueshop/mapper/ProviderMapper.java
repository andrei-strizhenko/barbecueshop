package com.diplomproject.barbecueshop.mapper;

import com.diplomproject.barbecueshop.dto.ProviderDto;
import com.diplomproject.barbecueshop.model.Provider;
import com.diplomproject.barbecueshop.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;



@Component
    public class ProviderMapper extends GenericMapper<Provider, ProviderDto> {
    private final ModelMapper mapper;
    private final ProductRepository productRepository;


    protected ProviderMapper(ModelMapper mapper, ProductRepository productRepository) {
        super(mapper, Provider.class, ProviderDto.class);
        this.mapper = mapper;
        this.productRepository = productRepository;

    }}

