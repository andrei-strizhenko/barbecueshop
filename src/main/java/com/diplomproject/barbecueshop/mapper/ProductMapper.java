package com.diplomproject.barbecueshop.mapper;

import com.diplomproject.barbecueshop.dto.ProductDto;
import com.diplomproject.barbecueshop.model.Product;
import com.diplomproject.barbecueshop.repository.ProviderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper extends GenericMapper<Product, ProductDto> {

    private final ModelMapper mapper;
    private final ProviderRepository providerRepository;
    protected ProductMapper(ModelMapper mapper, ProviderRepository providerRepository) {
        super(mapper, Product.class, ProductDto.class);
        this.mapper = mapper;
        this.providerRepository = providerRepository;
    }

/*    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Product.class, ProductDto.class)
                .addMappings(m -> m.skip(ProductDto::setProvidersIds)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(ProductDto.class, Product.class)
                .addMappings(m -> m.skip(Product::setProviders)).setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFields(ProductDto source, Product destination) {
        if (!Objects.isNull(source.getProvidersIds())) {
            destination.setProviders(providerRepository.findAllByIdIn(source.getProvidersIds()));
        } else {
            destination.setProviders(null);

        }
    }

    @Override
    void mapSpecificFields(Product source, ProductDto destination) {
        destination.setProvidersIds(getIds(source));
    }

    private Set<Long> getIds(Product Product) {
        return Objects.isNull(Product) || Objects.isNull(Product.getId())
                ? null
                : Product.getProviders().stream()
                .map(GenericModel::getId)
                .collect(Collectors.toSet());
    }*/
}