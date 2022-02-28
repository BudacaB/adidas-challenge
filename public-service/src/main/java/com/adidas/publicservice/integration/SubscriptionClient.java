package com.adidas.publicservice.integration;

import com.adidas.publicservice.model.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionClient {

    @Autowired
    ISubscriptionClient subscriptionClient;

    public Subscription getSubscriptionById(Long id) {
        return subscriptionClient.getSubscriptionById(id);
    }
}
