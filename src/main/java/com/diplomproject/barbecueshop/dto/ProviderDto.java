package com.diplomproject.barbecueshop.dto;

<<<<<<< HEAD
import lombok.*;

import java.util.List;

=======
import com.diplomproject.barbecueshop.model.Product;
import lombok.*;

import java.util.List;
>>>>>>> origin/main
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProviderDto extends GenericDto {
    private String title;
    private String description;
    private String phone;
    private String productName;
    private Long amount;
    private Double cost;
<<<<<<< HEAD
    private List<Long> ordersIds;
}

=======
    private List<Product> productsIds;
}
>>>>>>> origin/main
