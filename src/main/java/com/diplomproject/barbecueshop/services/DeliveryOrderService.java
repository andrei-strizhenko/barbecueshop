package com.diplomproject.barbecueshop.services;

import com.diplomproject.barbecueshop.dto.ApplyOrderToDeliveryDto;
import com.diplomproject.barbecueshop.model.DeliveryOrder;
import com.diplomproject.barbecueshop.model.Order;
import com.diplomproject.barbecueshop.repository.DeliveryOrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DeliveryOrderService extends GenericService<DeliveryOrder> {
    private final DeliveryOrderRepository deliveryOrderRepository;
    private final UserService userService;
    private final ProductService productService;
    private final OrderService orderService;

    public DeliveryOrderService(DeliveryOrderRepository deliveryOrderRepository, UserService userService, ProductService productService, OrderService orderService) {
        super(deliveryOrderRepository);
        this.deliveryOrderRepository = deliveryOrderRepository;
        this.userService = userService;
        this.productService = productService;
        this.orderService = orderService;
    }


    //отправляем заказ на доставку
    public DeliveryOrder applyToDelivery(ApplyOrderToDeliveryDto applyOrderToDeliveryDto) {
        DeliveryOrder deliveryOrder;  // = deliveryOrderService.getOne(applyOrderToDeliveryDto.getDeliveryOrderId());
        Order order = orderService.getOne(applyOrderToDeliveryDto.getOrderId());
        deliveryOrder = DeliveryOrder.builder()
                .costOfDelivery(0.0)
                .costOfOrder(0.0)
                .status("Заказ на доставку создан.")
                .deliveryOrderDateTime(LocalDateTime.now())
                .deliveryDateTime(LocalDateTime.now().plusDays(1L))
                .createdBy(order.getUserSurname())
                //  .quantity(0)
                //  .user(null)

                //   .orderDateTime(LocalDateTime.now())
                .build();
        return create(deliveryOrder);
    }
}
