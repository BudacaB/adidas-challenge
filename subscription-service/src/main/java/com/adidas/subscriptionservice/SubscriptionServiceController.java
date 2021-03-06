package com.adidas.subscriptionservice;

import com.adidas.subscriptionservice.exceptions.SubscriptionNotFoundException;
import com.adidas.subscriptionservice.model.Subscription;
import com.adidas.subscriptionservice.model.SubscriptionEntity;
import com.adidas.subscriptionservice.service.ISubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("getSubscriptions")
    List<SubscriptionEntity> getSubscriptions() {
        return subscriptionService.getSubscriptions();
    }

    @DeleteMapping("cancelSubscription/{id}")
    ResponseEntity<?> cancelSubscription(@PathVariable Long id) throws SubscriptionNotFoundException {
        subscriptionService.cancelSubscription(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
