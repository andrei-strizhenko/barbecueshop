package com.diplomproject.barbecueshop.mapper;


import com.diplomproject.barbecueshop.dto.OrderDto;
import com.diplomproject.barbecueshop.model.Order;
import com.diplomproject.barbecueshop.repository.ProductRepository;
import com.diplomproject.barbecueshop.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class OrderMapper extends GenericMapper<Order, OrderDto> {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    protected OrderMapper(ModelMapper mapper, ProductRepository productRepository, UserRepository userRepository) {
        super(mapper, Order.class, OrderDto.class);
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void setupMapper() {
        super.mapper.createTypeMap(Order.class, OrderDto.class)
                .addMappings(m -> m.skip(OrderDto::setUserId)).setPostConverter(toDtoConverter())
                .addMappings(m -> m.skip(OrderDto::setProductId)).setPostConverter(toDtoConverter());
    }

    @Override
    void mapSpecificFields(OrderDto source, Order destination) {
        destination.setProduct(productRepository.findById(source.getProductId()).orElseThrow());
        destination.setUser(userRepository.findById(source.getUserId()).orElseThrow());
    }

    @Override
    void mapSpecificFields(Order source, OrderDto destination) {
        destination.setUserId(source.getUser().getId());
        destination.setProductId(source.getProduct().getId());
    }

}
