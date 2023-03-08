package com.diplomproject.barbecueshop.mapper;

import com.diplomproject.barbecueshop.dto.DeliveryOrderDto;
import com.diplomproject.barbecueshop.model.DeliveryOrder;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DeliveryOrderMapper extends GenericMapper<DeliveryOrder, DeliveryOrderDto>{


    protected DeliveryOrderMapper(ModelMapper mapper) {
        super(mapper, DeliveryOrder.class, DeliveryOrderDto.class);

    }
}
