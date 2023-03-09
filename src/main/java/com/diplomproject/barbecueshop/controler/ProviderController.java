package com.diplomproject.barbecueshop.controler;

import com.diplomproject.barbecueshop.dto.ProviderDto;
import com.diplomproject.barbecueshop.mapper.ProviderMapper;
import com.diplomproject.barbecueshop.model.Provider;
import com.diplomproject.barbecueshop.services.ProviderService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@SecurityRequirement(name = "Bearer Authentication")
@RequestMapping("/rest/provider")
public class ProviderController extends GenericController<Provider, ProviderDto> {
    private final ProviderService providerService;
    private final ProviderMapper providerMapper;


    protected ProviderController( ProviderService providerService, ProviderMapper providerMapper) {
        super(providerService, providerMapper);
        this.providerService = providerService;
        this.providerMapper = providerMapper;
    }
}


