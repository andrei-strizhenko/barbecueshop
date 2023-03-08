package com.diplomproject.barbecueshop.mapper;

import com.diplomproject.barbecueshop.dto.ProviderDto;
<<<<<<< HEAD
import com.diplomproject.barbecueshop.model.GenericModel;
import com.diplomproject.barbecueshop.model.Provider;
import com.diplomproject.barbecueshop.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Component
    public class ProviderMapper extends GenericMapper<Provider, ProviderDto> {

        private final ModelMapper mapper;
        private final OrderRepository orderRepository;


        protected ProviderMapper(ModelMapper mapper, OrderRepository orderRepository) {
            super(mapper, Provider.class, ProviderDto.class);
            this.mapper = mapper;
            this.orderRepository = orderRepository;
        }


    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Provider.class, ProviderDto.class)
                .addMappings(m -> m.skip(ProviderDto::setOrdersIds)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(ProviderDto.class, Provider.class)
                .addMappings(m -> m.skip(Provider::setOrders)).setPostConverter(toEntityConverter());

    }

    @Override
    void mapSpecificFields(ProviderDto source, Provider destination) {
        if (!Objects.isNull(source.getOrdersIds())) {

 //           destination.setOrders(orderRepository.findAllByIdIn(source.getOrdersIds()));
        } else {
            destination.setOrders(null);
        }
    }


    @Override
    void mapSpecificFields(Provider source, ProviderDto destination) {
        //     destination.setProductId(source.getProduct().getId());
        //      destination.setUserId(source.getUser().getId());

    destination.setOrdersIds(getIds(source));

    }

    private List<Long> getIds(Provider provider) {
        return Objects.isNull(provider) || Objects.isNull(provider.getId())
                ? null
                : provider.getOrders().stream()
                .map(GenericModel::getId)
                .collect(Collectors.toList());
    }

}


=======
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
>>>>>>> origin/main
