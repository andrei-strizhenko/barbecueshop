package com.diplomproject.barbecueshop.controler;

import com.diplomproject.barbecueshop.dto.DeliveryOrderDto;
import com.diplomproject.barbecueshop.mapper.DeliveryOrderMapper;
import com.diplomproject.barbecueshop.model.DeliveryOrder;
import com.diplomproject.barbecueshop.services.DeliveryOrderService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SecurityRequirement(name = "Bearer Authentication")
@RequestMapping("/rest/delivery-order")
public class DeliveryOrderController extends GenericController<DeliveryOrder, DeliveryOrderDto> {

    private final DeliveryOrderService service;

    public DeliveryOrderController(DeliveryOrderService service, DeliveryOrderMapper mapper) {
        super(service, mapper);
        this.service = service;
    }
}