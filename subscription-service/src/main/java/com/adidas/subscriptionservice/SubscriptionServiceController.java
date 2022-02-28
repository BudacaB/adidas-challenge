package com.adidas.subscriptionservice;

import com.adidas.subscriptionservice.exceptions.SubscriptionNotFoundException;
import com.adidas.subscriptionservice.model.Subscription;
import com.adidas.subscriptionservice.model.SubscriptionEntity;
import com.adidas.subscriptionservice.service.ISubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("subscription/v1/api/")
public class SubscriptionServiceController {

    @Autowired
    private ISubscriptionService subscriptionService;

    @GetMapping("getSubscriptionById/{id}")
    SubscriptionEntity getSubscriptionById(@PathVariable Long id) throws SubscriptionNotFoundException {
        return subscriptionService.getSubscriptionById(id);
    }

    @PostMapping("createSubscription")
    Long createSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.createSubscription(subscription);
    }
}
