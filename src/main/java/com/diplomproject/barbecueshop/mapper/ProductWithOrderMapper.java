package com.diplomproject.barbecueshop.mapper;

import com.diplomproject.barbecueshop.dto.ProductWithOrderDto;

import com.diplomproject.barbecueshop.model.GenericModel;
import com.diplomproject.barbecueshop.model.Product;
import com.diplomproject.barbecueshop.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Component
public class ProductWithOrderMapper extends GenericMapper<Product, ProductWithOrderDto> {

    private final ModelMapper mapper;
    private final OrderRepository orderRepository;

    protected ProductWithOrderMapper(ModelMapper mapper, OrderRepository orderRepository) {
        super(mapper, Product.class, ProductWithOrderDto.class);
        this.mapper = mapper;
        this.orderRepository = orderRepository;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Product.class,  ProductWithOrderDto.class)
                .addMappings(m -> m.skip( ProductWithOrderDto::setOrdersIds)).setPostConverter(toDtoConverter());
        mapper.createTypeMap( ProductWithOrderDto.class, Product.class)
                .addMappings(m -> m.skip(Product::setOrders)).setPostConverter(toEntityConverter());

    }

    @Override
    void mapSpecificFields( ProductWithOrderDto source, Product destination) {
                  destination.setOrders(orderRepository.findAllByIdIn(source.getOrdersIds()));
    }


    @Override
    void mapSpecificFields(Product source,  ProductWithOrderDto destination) {
        //     destination.setProductId(source.getProduct().getId());
        //      destination.setUserId(source.getUser().getId());
             destination.setOrdersIds(getIds(source));

    }

    private List<Long> getIds(Product product) {
        return Objects.isNull(product) || Objects.isNull(product.getId())
                ? null
                : product.getOrders().stream()
                .map(GenericModel::getId)
                .collect(Collectors.toList());
    }
}
