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
//
//    @PostConstruct
//    public void setupMapper() {
//        mapper.createTypeMap(Provider.class, ProviderDto.class)
//                .addMappings(m -> m.skip(ProviderDto::setProductsIds)).setPostConverter(toDtoConverter());
//        mapper.createTypeMap(ProviderDto.class, Provider.class)
//                .addMappings(m -> m.skip(Provider::setProducts)).setPostConverter(toEntityConverter());
//
//    }
//
//    @Override
//    void mapSpecificFields(ProviderDto source, Provider destination) {
//        if (!Objects.isNull(source.getProductsIds())) {
//
//            destination.setProducts(productRepository.findAllByIdIn(source.getProductsIds()));
//        } else {
//            destination.setProducts(null);
//        }
//    }
//
//
//    @Override
//    void mapSpecificFields(Provider source, ProviderDto destination) {
//        //     destination.setProductId(source.getProduct().getId());
//        //      destination.setUserId(source.getUser().getId());
//
//    destination.setProductsIds(getIds(source));
//
//    }
//
//    private List<Long> getIds(Provider provider) {
//        return Objects.isNull(provider) || Objects.isNull(provider.getId())
//                ? null
//                : provider.getProducts().stream()
//                .map(GenericModel::getId)
//                .collect(Collectors.toList());
//    }
//
//}