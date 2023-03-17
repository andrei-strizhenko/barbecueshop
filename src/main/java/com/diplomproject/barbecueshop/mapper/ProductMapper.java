package com.diplomproject.barbecueshop.mapper;

import com.diplomproject.barbecueshop.dto.ProductDto;
import com.diplomproject.barbecueshop.model.GenericModel;
import com.diplomproject.barbecueshop.model.Product;
import com.diplomproject.barbecueshop.repository.OrderRepository;
import com.diplomproject.barbecueshop.repository.ProviderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ProductMapper extends GenericMapper<Product, ProductDto> {

    private final ModelMapper mapper;
    private final OrderRepository orderRepository;
    private final ProviderRepository providerRepository;
    protected ProductMapper(ModelMapper mapper, OrderRepository orderRepository, ProviderRepository providerRepository) {
        super(mapper, Product.class, ProductDto.class);
        this.mapper = mapper;
        this.orderRepository = orderRepository;
        this.providerRepository = providerRepository;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Product.class, ProductDto.class)
                .addMappings(m -> m.skip(ProductDto::setOrdersIds)).setPostConverter(toDtoConverter())
                .addMappings(m -> m.skip(ProductDto::setProvidersIds)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(ProductDto.class, Product.class)
                .addMappings(m -> m.skip(Product::setOrders)).setPostConverter(toEntityConverter())
                .addMappings(m -> m.skip(Product::setProviders)).setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFields(ProductDto source, Product destination) {
        if (!Objects.isNull(source.getOrdersIds())) {
            destination.setOrders(orderRepository.findAllByIdIn(source.getOrdersIds()));
            destination.setProviders(providerRepository.findAllByIdIn(source.getProvidersIds()));
        } else {
            destination.setOrders(null);
            destination.setProviders(null);
        }
    }

    // показывает List ids orders  и Set ids providers
    @Override
    void mapSpecificFields(Product source, ProductDto destination) {
        destination.setOrdersIds(getIds(source));        //  нужно закомментировать при запуске тестов
        destination.setProvidersIds(getIds2(source));    //  нужно закомментировать при запуске тестов
    }

    private List<Long> getIds(Product Product) {
        return Objects.isNull(Product) || Objects.isNull(Product.getId())
                ? null
                : Product.getOrders().stream()
                .map(GenericModel::getId)
                .collect(Collectors.toList());
    }

    private Set<Long> getIds2(Product Product) {
        return Objects.isNull(Product) || Objects.isNull(Product.getId())
                ? null
                : Product.getProviders().stream()
                .map(GenericModel::getId)
                .collect(Collectors.toSet());
    }

}