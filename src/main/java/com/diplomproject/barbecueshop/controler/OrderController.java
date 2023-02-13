package com.diplomproject.barbecueshop.controler;

import com.diplomproject.barbecueshop.dto.AddUserInOrderDto;
import com.diplomproject.barbecueshop.dto.BuyProductDto;
import com.diplomproject.barbecueshop.dto.CreateNewOrderDto;

import com.diplomproject.barbecueshop.dto.OrderDto;
import com.diplomproject.barbecueshop.mapper.OrderMapper;
import com.diplomproject.barbecueshop.model.Order;
import com.diplomproject.barbecueshop.services.OrderService;
import org.springframework.web.bind.annotation.*;

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

    //  @PostMapping("buy-product")
    //  public OrderDto buyProduct(@RequestBody BuyProductDto buyProductDto) {
//        return mapper.toDto(service.buyProduct(buyProductDto));
    //   }

    //   @GetMapping("user-ordering/{userId}")
    //   public List<OrderDto> getUserOrdering(@PathVariable Long userId) {
    //       return mapper.toDtos(service.getUserOrdering(userId));
//    }

    // создаем новый заказ(в заказе только Id и время создания):
    @PostMapping("create-new-order")
    public Order createNewOrder(@RequestBody CreateNewOrderDto createNewOrderDto) {
     //   return mapper.toDto(service.createNewOrder(createNewOrderDto));
        return service.createNewOrder(createNewOrderDto);
    }

    //добавляем пользователя в заказ
    @PostMapping("add-user-in-order")
     public OrderDto addUserInOrder(@RequestBody AddUserInOrderDto addUserInOrderDto) {
       return mapper.toDto(service.addUserInOrder(addUserInOrderDto));
       }
}