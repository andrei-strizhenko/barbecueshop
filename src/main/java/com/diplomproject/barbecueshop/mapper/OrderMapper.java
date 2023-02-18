package com.diplomproject.barbecueshop.mapper;

import com.diplomproject.barbecueshop.dto.OrderDto;
import com.diplomproject.barbecueshop.model.GenericModel;
import com.diplomproject.barbecueshop.model.Order;
import com.diplomproject.barbecueshop.repository.ProductRepository;
import com.diplomproject.barbecueshop.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
    public class OrderMapper extends GenericMapper<Order, OrderDto> {

        private final ModelMapper mapper;
        private final ProductRepository productRepository;
        private final UserRepository userRepository;  //пока не использовать

        protected OrderMapper(ModelMapper mapper, ProductRepository productRepository, UserRepository userRepository) {
            super(mapper, Order.class, OrderDto.class);
            this.mapper = mapper;
            this.userRepository = userRepository;
            this.productRepository = productRepository;
        }

        @PostConstruct
        public void setupMapper() {
            mapper.createTypeMap(Order.class, OrderDto.class)
                    .addMappings(m -> m.skip(OrderDto::setProductsIds)).setPostConverter(toDtoConverter());
            mapper.createTypeMap(OrderDto.class, Order.class)
                    .addMappings(m -> m.skip(Order::setProducts)).setPostConverter(toEntityConverter());
        }

        @Override
        void mapSpecificFields(OrderDto source, Order destination) {
            if (!Objects.isNull(source.getProductsIds())) {
                destination.setProducts(productRepository.findAllByIdIn(source.getProductsIds()));
        }else{
            destination.setProducts(null);
    }
        }

        @Override
        void mapSpecificFields(Order source, OrderDto destination) {
            destination.setProductsIds(getIds(source));

        }

    private Set<Long> getIds(Order order) {
            return Objects.isNull(order) || Objects.isNull((order.getId()))
                    ? null
                    : order.getProducts().stream()
                    .map(GenericModel::getId)
                    .collect(Collectors.toSet());
    }


}
