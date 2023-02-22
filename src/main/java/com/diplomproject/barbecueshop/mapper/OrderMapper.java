package com.diplomproject.barbecueshop.mapper;

import com.diplomproject.barbecueshop.dto.OrderDto;
import com.diplomproject.barbecueshop.model.Order;
import com.diplomproject.barbecueshop.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
    public class OrderMapper extends GenericMapper<Order, OrderDto> {

        private final ModelMapper mapper;
        private final ProductRepository productRepository;
     //   private final UserRepository userRepository;

        protected OrderMapper(ModelMapper mapper, ProductRepository productRepository) {
            super(mapper, Order.class, OrderDto.class);
            this.mapper = mapper;
           // this.userRepository = userRepository;
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
     //           destination.setProduct(productRepository.findById(source.getProductId()).orElseThrow());
     //           destination.setUser(userRepository.findById(source.getUserId()).orElseThrow());
    }


        @Override
        void mapSpecificFields(Order source, OrderDto destination) {
       //     destination.setProductId(source.getProduct().getId());
      //      destination.setUserId(source.getUser().getId());

        }


}
