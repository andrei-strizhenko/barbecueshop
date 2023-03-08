package com.diplomproject.barbecueshop.services;

import com.diplomproject.barbecueshop.dto.AddOrderToTheDeliveryOrderDto;
import com.diplomproject.barbecueshop.model.DeliveryOrder;
import com.diplomproject.barbecueshop.model.Order;
import com.diplomproject.barbecueshop.repository.DeliveryOrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DeliveryOrderService extends GenericService<DeliveryOrder> {
    private final DeliveryOrderRepository deliveryOrderRepository;
    private final OrderService orderService;
    private final UserService userService;

    protected DeliveryOrderService(DeliveryOrderRepository deliveryOrderRepository, OrderService orderService, UserService userService) {
        super(deliveryOrderRepository);
        this.deliveryOrderRepository = deliveryOrderRepository;
        this.orderService = orderService;
        this.userService = userService;
    }


    //добавляем ордер в доставку
    public Order addOrderInDeliveryOrder(AddOrderToTheDeliveryOrderDto addOrderToTheDeliveryOrderDto) {
        DeliveryOrder deliveryOrder;  //= getOne(addOrderToTheDeliveryOrderDto.getDeliveryOrderId());
        Order order = orderService.getOne(addOrderToTheDeliveryOrderDto.getOrderId());
      //  deliveryOrder.setOrder(order);
        if(order.getDeliveryOrder() == null) {
            deliveryOrder = DeliveryOrder.builder()
                 //   .id(order.getId())
                    .createdBy(order.getUserSurname())
                    .deliveryOrderDateTime(LocalDateTime.now())
                    .deliveryDateTime(LocalDateTime.now().plusDays(1L))
                    .status("Заказ на доставку создан.")
                    .costOfDelivery(0.0)
                    .costOfOrder(order.getTotal())
                    .build();
            deliveryOrder.setOrder(order);
            order.setDeliveryOrder(deliveryOrder);
            update(deliveryOrder);
            orderService.update(order);
        }else{
            System.out.println("Для этого заказа уже есть заказ на доставку");
        }

        return order;
    }
}