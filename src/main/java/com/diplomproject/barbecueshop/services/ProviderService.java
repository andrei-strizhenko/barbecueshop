package com.diplomproject.barbecueshop.services;


import com.diplomproject.barbecueshop.model.Provider;
import com.diplomproject.barbecueshop.repository.ProviderRepository;
import org.springframework.stereotype.Service;

@Service
public class ProviderService extends GenericService<Provider> {
    private final ProviderRepository providerRepository;

    public ProviderService(ProviderRepository providerRepository) {
        super(providerRepository);
        this.providerRepository = providerRepository;
    }
}

