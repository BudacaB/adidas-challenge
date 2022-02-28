package com.adidas.subscriptionservice.assembly;

import com.adidas.subscriptionservice.model.Subscription;
import com.adidas.subscriptionservice.model.SubscriptionEntity;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionAssembler {

    public SubscriptionEntity toSubscriptionEntity(Subscription subscription) {
        SubscriptionEntity subscriptionEntity = new SubscriptionEntity();
        subscriptionEntity.setEmail(subscription.getEmail());
        subscriptionEntity.setFirstName(subscription.getFirstName());
        subscriptionEntity.setGender(subscription.getGender());
        subscriptionEntity.setDateOfBirth(subscription.getDateOfBirth());
        subscriptionEntity.setConsent(subscription.getConsent());
        subscriptionEntity.setNewsletterId(subscription.getNewsletterId());
        return subscriptionEntity;
    }
}
