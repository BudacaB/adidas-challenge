package com.adidas.publicservice.service;

import com.adidas.publicservice.integration.ISubscriptionClient;
import com.adidas.publicservice.model.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicService implements IPublicService {

    @Autowired
    ISubscriptionClient subscriptionClient;

    @Override
    public Subscription getSubscriptionById(Long id) {
        return subscriptionClient.getSubscriptionById(id);
    }
}
