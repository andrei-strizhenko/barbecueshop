package com.diplomproject.barbecueshop.mapper;

import com.diplomproject.barbecueshop.dto.OrderWithProductDto;
import com.diplomproject.barbecueshop.model.GenericModel;
import com.diplomproject.barbecueshop.model.Order;
import com.diplomproject.barbecueshop.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class OrderWithProductMapper extends GenericMapper<Order, OrderWithProductDto>{
    private final ModelMapper mapper;
    private final ProductRepository productRepository;
    //   private final UserRepository userRepository;

    protected OrderWithProductMapper(ModelMapper mapper, ProductRepository productRepository) {
        super(mapper, Order.class, OrderWithProductDto.class);
        this.mapper = mapper;
        // this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Order.class,  OrderWithProductDto.class)
                .addMappings(m -> m.skip( OrderWithProductDto::setProductsIds)).setPostConverter(toDtoConverter());
        mapper.createTypeMap( OrderWithProductDto.class, Order.class)
                .addMappings(m -> m.skip(Order::setProducts)).setPostConverter(toEntityConverter());

    }

    @Override
    void mapSpecificFields( OrderWithProductDto source, Order destination) {
                  destination.setProducts(productRepository.findAllByIdIn(source.getProductsIds()));
    }


    @Override
    void mapSpecificFields(Order source,  OrderWithProductDto destination) {
        //     destination.setProductId(source.getProduct().getId());
        //      destination.setUserId(source.getUser().getId());
             destination.setProductsIds(getIds(source));

    }

    private List<Long> getIds(Order order) {
        return Objects.isNull(order) || Objects.isNull(order.getId())
                ? null
                : order.getProducts().stream()
                .map(GenericModel::getId)
                .collect(Collectors.toList());
    }
}
