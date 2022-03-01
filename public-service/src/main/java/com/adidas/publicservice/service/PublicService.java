package com.adidas.publicservice.service;

import com.adidas.publicservice.exceptions.SubscriptionNotFoundException;
import com.adidas.publicservice.integration.SubscriptionClient;
import com.adidas.publicservice.model.Subscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicService implements IPublicService {

    @Autowired
    private SubscriptionClient subscriptionClient;

    @Override
    public Subscription getSubscriptionById(Long id) throws SubscriptionNotFoundException {
        return subscriptionClient.getSubscriptionById(id);
    }

    @Override
    public Long createSubscription(Subscription subscription) {
        return subscriptionClient.createSubscription(subscription);
    }

    @Override
    public Subscription[] getSubscriptions() {
        return subscriptionClient.getSubscriptions();
    }
}
