package com.diplomproject.barbecueshop.services;

import com.diplomproject.barbecueshop.dto.AddUserInOrderDto;
import com.diplomproject.barbecueshop.dto.BuyProductDto;
import com.diplomproject.barbecueshop.dto.CreateNewOrderDto;
import com.diplomproject.barbecueshop.dto.OrderDto;
import com.diplomproject.barbecueshop.model.Order;
import com.diplomproject.barbecueshop.model.Product;
import com.diplomproject.barbecueshop.model.User;
import com.diplomproject.barbecueshop.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
                .product(product)
                .build();
        return orderRepository.save(order);
    }

    public List<Order> getUserOrdering(Long userId) {
        return (List<Order>) userService.getOne(userId).getDeliveryOrder();
    }

    // создаем новый заказ(в заказе только Id и время создания):
    public Order createNewOrder(CreateNewOrderDto createNewOrderDto) {

        // User user = userService.getOne(rentBookDto.getUserId());
        // Product product = bookService.getOne(rentBookDto.getBookId());
        //  Order order = orderService.getOne(OrderDto);

        Order order = Order.builder()
                .orderDateTime(LocalDateTime.now())
                .build();
        return orderRepository.save(order);

    }

    //добавляем пользователя в заказ
    public Order addUserInOrder(AddUserInOrderDto addUserInOrderDto) {
        User user = userService.getOne(addUserInOrderDto.getUserId());
        //   Product product = productService.getOne(buyProductDto.getProductId());
        Order order = getOne(addUserInOrderDto.getOrderId());

         Order.builder()
                //          .rentDate(LocalDateTime.now())
                //         .returned(false)
                //         .returnDate(LocalDateTime.now().plusMonths(rentBookDto.getRentPeriod()))
                //        .rentPeriod(rentBookDto.getRentPeriod())
                //         .amount(rentBookDto.getAmount())
                .user(user)
                //  .product(product)
                .build();

        return orderRepository.save(order);
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