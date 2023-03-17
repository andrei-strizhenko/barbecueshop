package com.diplomproject.barbecueshop.controler;

import com.diplomproject.barbecueshop.dto.ProductDto;
import com.diplomproject.barbecueshop.mapper.ProductMapper;
import com.diplomproject.barbecueshop.model.Product;
import com.diplomproject.barbecueshop.services.ProductService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/rest/product")
@SecurityRequirement(name = "Bearer Authentication")
public class ProductController extends GenericController<Product, ProductDto>{
    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        super(productService, productMapper);
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping("/search")
    public List<ProductDto> list(
            @RequestParam(value = "title", required = false)String title,
            @RequestParam(value = "description", required = false)String country
    ) {
        return productMapper.toDtos(productService.searchByTitle(title));
    }

  /*  @PostMapping("/director-films")
    public Film addDirector(@RequestBody AddFilmsDto addFilmsDto) {
        return filmService.addDirector(addFilmsDto);
    }*/

//return mapper.toDtos(service.search(title, genre));
}