package com.diplomproject.barbecueshop.services;

import com.diplomproject.barbecueshop.dto.AddProductInOrderDto;
import com.diplomproject.barbecueshop.dto.AddUserInOrderDto;
import com.diplomproject.barbecueshop.dto.BuyProductDto;
import com.diplomproject.barbecueshop.dto.CreateNewOrderDto;
import com.diplomproject.barbecueshop.model.Order;
import com.diplomproject.barbecueshop.model.Product;
import com.diplomproject.barbecueshop.model.User;
import com.diplomproject.barbecueshop.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

@Service
public class OrderService extends GenericService<Order> {
    private final OrderRepository orderRepository;
    private final UserService userService;
    private final ProductService productService;


    public OrderService(OrderRepository orderRepository, UserService userService, ProductService productService) {
        super(orderRepository);
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.productService = productService;
    }

    public Order buyProduct(BuyProductDto buyProductDto) {
        User user = userService.getOne(buyProductDto.getUserId());
        Product product = productService.getOne(buyProductDto.getProductId());

        Order order = Order.builder()
                //          .rentDate(LocalDateTime.now())
                //         .returned(false)
                //         .returnDate(LocalDateTime.now().plusMonths(rentBookDto.getRentPeriod()))
                //        .rentPeriod(rentBookDto.getRentPeriod())
                //         .amount(rentBookDto.getAmount())
                .user(user)
               // .product(product)
                .build();
        return orderRepository.save(order);
    }

    public Set<Order> getUserOrdering(Long userId) {
        return (Set<Order>) userService.getOne(userId).getDeliveryOrder();
    }

    // создаем новый заказ(в заказе только Id и время создания):
    public Order createNewOrder(CreateNewOrderDto createNewOrderDto) {

        Order order = Order.builder()
                .total(0.0)
                .orderDateTime(LocalDateTime.now())
                .build();
        return orderRepository.save(order);

    }
    //добавляем продукт в заказ
    public Order addProductInOrder(AddProductInOrderDto addProductInOrderDto) {
        Product product = productService.getOne(addProductInOrderDto.getProductId());
        Order order = getOne(addProductInOrderDto.getOrderId());
        if(order.getOrderDateTime() != null) {
            order.setOrderDateTime(order.getOrderDateTime());
        } else{
            order.setOrderDateTime(LocalDateTime.now());
        }
        order.getProducts().add(product);
        System.out.println(addProductInOrderDto.getTotal());
        System.out.println(order.getTotal());
        System.out.println(product.getCost());

    //   addProductInOrderDto.getTotal(order.getTotal() + product.getCost());
        order.setTotal(order.getTotal() + product.getCost());


        Order.builder()
                //          .rentDate(LocalDateTime.now())
                //         .returned(false)
                //         .returnDate(LocalDateTime.now().plusMonths(rentBookDto.getRentPeriod()))
                //        .rentPeriod(rentBookDto.getRentPeriod())
                //         .amount(rentBookDto.getAmount())
               // .products(products)
                //  .product(product)
               .orderDateTime(addProductInOrderDto.getDeliveryDateTime())
         //      .total(addProductInOrderDto.getTotal() - product.getCost())           //product.getCost())

                //   .userId(addUserInOrderDto.getUserId())

                .build();

        return update(order);
    }

    //добавляем пользователя в заказ
    public Order addUserInOrder(AddUserInOrderDto addUserInOrderDto) {
        User user = userService.getOne(addUserInOrderDto.getUserId());
        Order order = getOne(addUserInOrderDto.getOrderId());
        order.setUser(user);
        order.setUserSurname(user.getSurname());


        return update(order);
    }


    /* public Film addDirector(AddFilmsDto addFilmsDto) {
        Director director = directorService.getOne(addFilmsDto.getDirectorId());
        Film film = getOne(addFilmsDto.getFilmId());
        film.getDirectors().add(director);
      //  director.getFilms().add(film);
      //  directorService.update(director);
        return update(film);
    }*/
}