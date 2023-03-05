package com.diplomproject.barbecueshop.mapper;


import com.diplomproject.barbecueshop.dto.ProviderWithProductDto;
import com.diplomproject.barbecueshop.model.Provider;
import com.diplomproject.barbecueshop.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProviderWithProductMapper extends GenericMapper<Provider, ProviderWithProductDto> {

    private final ModelMapper mapper;
    private final ProductRepository productRepository;

    protected ProviderWithProductMapper(ModelMapper mapper, ProductRepository productRepository) {
        super(mapper, Provider.class, ProviderWithProductDto.class);
        this.mapper = mapper;
        this.productRepository = productRepository;
    }}
//
//
//
//    @PostConstruct
//    public void setupMapper() {
//        mapper.createTypeMap(Provider.class, ProviderWithProductDto.class)
//                .addMappings(m -> m.skip(ProviderWithProductDto::setProductsIds).setPostConverter(toDtoConverter()));
//        mapper.createTypeMap(ProviderWithProductDto.class, Provider.class)
//                .addMappings(m -> m.skip(Product::setProducts)).setPostConverter(toEntityConverter());
//    }
//
//    @Override
//    void mapSpecificFields(ProviderWithProductDto source, Provider destination) {
//        destination.setProducts(productRepository.findAllByIdIn(source.getProductsIds()));
//    }
//
//    @Override
//    void mapSpecificFields(Provider source, ProviderWithProductDto destination) {
//        destination.setProductsIds(getIds(source));
//    }
//
//    private Set<Long> getIds(Product product) {
//        return Objects.isNull(product) || Objects.isNull(product.getId())
//                ? null
//                : product.getProviders().stream()
//                .map(GenericModel::getId)
//                .collect(Collectors.toSet());
//    }
//}