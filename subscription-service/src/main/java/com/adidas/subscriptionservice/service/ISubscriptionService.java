package com.adidas.subscriptionservice.service;

import com.adidas.subscriptionservice.exceptions.SubscriptionNotFoundException;
import com.adidas.subscriptionservice.model.Subscription;
import com.adidas.subscriptionservice.model.SubscriptionEntity;

public interface ISubscriptionService {

    SubscriptionEntity getSubscriptionById(Long id) throws SubscriptionNotFoundException;
    Long createSubscription(Subscription subscription);
}
