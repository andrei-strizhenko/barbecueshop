package com.diplomproject.barbecueshop.services;

import com.diplomproject.barbecueshop.dto.AddProductsToTheOrderDto;
import com.diplomproject.barbecueshop.model.Order;
import com.diplomproject.barbecueshop.model.Product;
import com.diplomproject.barbecueshop.repository.OrderRepository;
import org.springframework.stereotype.Service;

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


  //  public Set<Order> getUserOrdering(Long userId) {
  //     return (Set<Order>) userService.getOne(userId).getDeliveryOrder();
  //  }

    // создаем новый заказ(в заказе только Id и время создания):
    public Order createNewOrder(Order order) {


         order = Order.builder()
                .products(null)
              //  .deliveryDateTime(LocalDateTime.now())
              //  .deliveryOrder(null)
              //  .purchase(false)
              //  .userSurname(null)
              //  .quantity(0)
              //  .user(null)
                .total(0.0)
             //   .orderDateTime(LocalDateTime.now())
                .build();
        return orderRepository.save(order);

    }

    //добавляем продукт в заказ
    public Order addProductInOrder(AddProductsToTheOrderDto addProductsToTheOrderDto) {
        Product product = productService.getOne(addProductsToTheOrderDto.getProductId());
       // User user = userService.getOne(addProductsToTheOrderDto.getUserId());
        Order order = getOne(addProductsToTheOrderDto.getOrderId());

   //     if (order.getOrderDateTime() != null) {
    //        order.setOrderDateTime(order.getOrderDateTime());
   //     } else {
   //         order.setOrderDateTime(LocalDateTime.now());
    //    }
   /*     order.setUserSurname(user.getSurname());
        order.setUser(user);
        order.setProduct(product);
        order.setTotal(order.getTotal() + product.getCost());
        if(order.getProduct().getId().equals(product.getId())){
            order.setQuantity(order.getQuantity()+1);
            order.setTotal(order.getTotal()+product.getCost());
        }else{
            order.setProduct(product);
        }*/
        //      order.getProducts().add(product);                                                   /выкл
        //    order.getListIdOrderedProducts().add(product);
        //   addProductInOrderDto.getTotal(order.getTotal() + product.getCost());

        order.setTotal(order.getTotal() + product.getCost());


        return update(order);
    }

    //добавляем пользователя в заказ
   /* public Order addUserInOrder(AddUserInOrderDto addUserInOrderDto) {
        User user = userService.getOne(addUserInOrderDto.getUserId());
        Order order = getOne(addUserInOrderDto.getOrderId());
      //  order.setUser(user);
     //   order.setUserSurname(user.getSurname());


        return update(order);
    }*/


    /* public Film addDirector(AddFilmsDto addFilmsDto) {
        Director director = directorService.getOne(addFilmsDto.getDirectorId());
        Film film = getOne(addFilmsDto.getFilmId());
        film.getDirectors().add(director);
      //  director.getFilms().add(film);
      //  directorService.update(director);
        return update(film);
    }*/
}