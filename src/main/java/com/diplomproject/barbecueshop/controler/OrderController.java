package com.diplomproject.barbecueshop.controler;

import com.diplomproject.barbecueshop.dto.AddProductsToTheOrderDto;
import com.diplomproject.barbecueshop.dto.OrderDto;
import com.diplomproject.barbecueshop.mapper.OrderMapper;
import com.diplomproject.barbecueshop.model.Order;
import com.diplomproject.barbecueshop.services.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/order")
public class OrderController extends GenericController<Order, OrderDto> {

    private final OrderService service;
    private final OrderMapper mapper;

    protected OrderController(OrderService service, OrderMapper mapper) {
        super(service, mapper);
        this.service = service;
        this.mapper = mapper;
    }

    // создаем новый заказ(в заказе только Id и время создания):
    @PostMapping("create-new-order")
    public Order createNewOrder(@RequestBody Order order) {
     //   return mapper.toDto(service.createNewOrder(createNewOrderDto));
        return service.createNewOrder(order);
    }

    //добавляем продукт в заказ
    @PostMapping("add-product-in-order")
    public OrderDto addProductInOrder(@RequestBody AddProductsToTheOrderDto addProductsToTheOrderDto ) {
        return mapper.toDto(service.addProductInOrder(addProductsToTheOrderDto));
    }


 /*   //добавляем пользователя в заказ
    @PostMapping("add-user-in-order")
     public OrderDto addUserInOrder(@RequestBody AddProductsToTheOrderDto addProductsToTheOrderDto) {
       return mapper.toDto(service.addUserInOrder(addProductsToTheOrderDto));
       }*/


}