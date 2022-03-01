package com.adidas.publicservice.service;

import com.adidas.publicservice.exceptions.SubscriptionNotFoundException;
import com.adidas.publicservice.model.Subscription;

public interface IPublicService {

    Subscription getSubscriptionById(Long id) throws SubscriptionNotFoundException;
    Long createSubscription(Subscription subscription);
    Subscription[] getSubscriptions();
    void cancelSubscription(Long id) throws SubscriptionNotFoundException;
}
