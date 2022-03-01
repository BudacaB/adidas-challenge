package com.adidas.subscriptionservice.service;

import com.adidas.subscriptionservice.exceptions.SubscriptionNotFoundException;
import com.adidas.subscriptionservice.model.Subscription;
import com.adidas.subscriptionservice.model.SubscriptionEntity;

import java.util.List;

public interface ISubscriptionService {

    SubscriptionEntity getSubscriptionById(Long id) throws SubscriptionNotFoundException;
    Long createSubscription(Subscription subscription);
    List<SubscriptionEntity> getSubscriptions();
}
