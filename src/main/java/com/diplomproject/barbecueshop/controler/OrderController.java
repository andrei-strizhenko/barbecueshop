package com.diplomproject.barbecueshop.controler;

import com.diplomproject.barbecueshop.dto.*;
import com.diplomproject.barbecueshop.mapper.OrderMapper;
import com.diplomproject.barbecueshop.mapper.OrderWithProductMapper;
import com.diplomproject.barbecueshop.mapper.OrderWithUserMapper;
import com.diplomproject.barbecueshop.model.Order;
import com.diplomproject.barbecueshop.services.DeliveryOrderService;
import com.diplomproject.barbecueshop.services.OrderService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@SecurityRequirement(name = "Bearer Authentication")
@RequestMapping("/rest/order")
public class OrderController extends GenericController<Order, OrderDto> {

    private final OrderService service;
    private final DeliveryOrderService deliveryOrderService;
    private final OrderWithProductMapper orderWithProductMapper;
    private final OrderWithUserMapper orderWithUserMapper;


    protected OrderController(OrderService service, OrderMapper mapper, DeliveryOrderService deliveryOrderService, OrderWithProductMapper orderWithProductMapper, OrderWithUserMapper orderWithUserMapper) {
        super(service, mapper);
        this.service = service;
        this.deliveryOrderService = deliveryOrderService;
        this.orderWithProductMapper = orderWithProductMapper;
        this.orderWithUserMapper = orderWithUserMapper;
    }

    //показать список заказов с продуктами
    @GetMapping("/list-order-with-products")
    public List<OrderWithProductDto> getOrderWithProducts() {
        return service.listAll().stream().map(orderWithProductMapper::toDto).collect(Collectors.toList());
    }

    // создаем новый заказ(в заказе только Id и время создания):
    @PostMapping("/create-new-order")
    public Order createNewOrder(@RequestBody Order order) {
     //   return mapper.toDto(service.createNewOrder(createNewOrderDto));
        return service.createNewOrder(order);
    }

    //добавляем продукт в заказ
    @PostMapping("/add-product-in-order")
    public OrderDto addProductInOrder(@RequestBody AddProductsToTheOrderDto addProductsToTheOrderDto ) {
        return orderWithProductMapper.toDto(service.addProductInOrder(addProductsToTheOrderDto));
    }

    //добавляем заказ в доставку
    @PostMapping("/add-order-in-delivery")
    public Order addOrderInDelivery(@RequestBody AddOrderToTheDeliveryOrderDto addOrderToTheDeliveryOrderDto ) {
        return deliveryOrderService.addOrderInDeliveryOrder(addOrderToTheDeliveryOrderDto);
    }


    //добавляем пользователя в заказ
    @PostMapping("add-user-in-order")
     public AddUserInOrderDto addUserInOrder(@RequestBody AddUserInOrderDto addUserInOrderDto) {
       return orderWithUserMapper.toDto(service.addUserInOrder(addUserInOrderDto));
       }


}