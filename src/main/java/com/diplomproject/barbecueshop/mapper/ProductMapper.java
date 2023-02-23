package com.diplomproject.barbecueshop.mapper;

import com.diplomproject.barbecueshop.dto.ProductDto;
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
public class ProductMapper extends GenericMapper<Product, ProductDto> {

    private final ModelMapper mapper;
    private final OrderRepository orderRepository;
    protected ProductMapper(ModelMapper mapper, OrderRepository orderRepository) {
        super(mapper, Product.class, ProductDto.class);
        this.mapper = mapper;
        this.orderRepository = orderRepository;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Product.class, ProductDto.class)
                .addMappings(m -> m.skip(ProductDto::setOrdersIds)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(ProductDto.class, Product.class)
                .addMappings(m -> m.skip(Product::setOrders)).setPostConverter(toEntityConverter());
    }

    @Override
    void mapSpecificFields(ProductDto source, Product destination) {
        if (!Objects.isNull(source.getOrdersIds())) {
            destination.setOrders(orderRepository.findAllByIdIn(source.getOrdersIds()));
        } else {
            destination.setOrders(null);

        }
    }

    @Override
    void mapSpecificFields(Product source, ProductDto destination) {
        destination.setOrdersIds(getIds(source));
    }

    private List<Long> getIds(Product Product) {
        return Objects.isNull(Product) || Objects.isNull(Product.getId())
                ? null
                : Product.getOrders().stream()
                .map(GenericModel::getId)
                .collect(Collectors.toList());
    }
}