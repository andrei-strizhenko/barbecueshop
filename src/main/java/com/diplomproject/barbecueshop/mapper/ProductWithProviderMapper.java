package com.diplomproject.barbecueshop.mapper;

import com.diplomproject.barbecueshop.dto.ProductWithProviderDto;
import com.diplomproject.barbecueshop.model.GenericModel;
import com.diplomproject.barbecueshop.model.Product;
import com.diplomproject.barbecueshop.repository.ProviderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ProductWithProviderMapper extends GenericMapper<Product, ProductWithProviderDto> {

    private final ModelMapper mapper;
    private final ProviderRepository providerRepository;

    protected ProductWithProviderMapper(ModelMapper mapper, ProviderRepository providerRepository) {
        super(mapper, Product.class, ProductWithProviderDto.class);
        this.mapper = mapper;
        this.providerRepository = providerRepository;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Product.class, ProductWithProviderDto.class)
                .addMappings(m -> m.skip(ProductWithProviderDto::setProvidersIds)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(ProductWithProviderDto.class, Product.class)
                .addMappings(m -> m.skip(Product::setProviders)).setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFields(ProductWithProviderDto source, Product destination) {
        destination.setProviders(providerRepository.findAllByIdIn(source.getProvidersIds()));
    }

    @Override
    void mapSpecificFields(Product source, ProductWithProviderDto destination) {
        destination.setProvidersIds(getIds(source));
    }

    private Set<Long> getIds(Product product) {
        return Objects.isNull(product) || Objects.isNull(product.getId())
                ? null
                : product.getProviders().stream()
                .map(GenericModel::getId)
                .collect(Collectors.toSet());
    }
}
