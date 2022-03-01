package com.adidas.subscriptionservice.service;

import com.adidas.subscriptionservice.SubscriptionRepository;
import com.adidas.subscriptionservice.assembly.SubscriptionAssembler;
import com.adidas.subscriptionservice.exceptions.SubscriptionNotFoundException;
import com.adidas.subscriptionservice.model.Subscription;
import com.adidas.subscriptionservice.model.SubscriptionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService implements ISubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private SubscriptionAssembler subscriptionAssembler;

    @Override
    public SubscriptionEntity getSubscriptionById(Long id) throws SubscriptionNotFoundException {
        Optional<SubscriptionEntity> subscriptionById = subscriptionRepository.findById(id);
        if (subscriptionById.isPresent()) {
            return subscriptionById.get();
        } else {
            throw new SubscriptionNotFoundException();
        }
    }

    @Override
    public Long createSubscription(Subscription subscription) {
        SubscriptionEntity subscriptionEntity = subscriptionAssembler.toSubscriptionEntity(subscription);
        subscriptionRepository.save(subscriptionEntity);
        return subscriptionEntity.getId();
    }

    @Override
    public List<SubscriptionEntity> getSubscriptions() {
        return subscriptionRepository.findAll();
    }

    @Override
    public void cancelSubscription(Long id) throws SubscriptionNotFoundException {
        try {
            subscriptionRepository.deleteById(id);
        } catch (Exception e) {
            throw new SubscriptionNotFoundException();
        }
    }
}
