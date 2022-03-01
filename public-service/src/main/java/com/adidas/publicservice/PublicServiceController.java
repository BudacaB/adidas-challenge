package com.adidas.publicservice;

import com.adidas.publicservice.exceptions.InvalidEmailException;
import com.adidas.publicservice.exceptions.SubscriptionNotFoundException;
import com.adidas.publicservice.model.Subscription;
import com.adidas.publicservice.service.IPublicService;
import com.adidas.publicservice.validation.SubscriptionValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("public/v1/api/")
public class PublicServiceController {

    @Autowired
    private IPublicService publicService;

    @Autowired
    private SubscriptionValidator subscriptionValidator;

    @GetMapping
    Subscription getSubscriptionById(@RequestParam Long id) throws SubscriptionNotFoundException {
        return publicService.getSubscriptionById(id);
    }

    @PostMapping
    Long createSubscription(@RequestBody Subscription subscription) throws InvalidEmailException {
        subscriptionValidator.isSubscriptionValid(subscription);
        return publicService.createSubscription(subscription);
    }

    @GetMapping("/all")
    Subscription[] getSubscriptions() {
        return publicService.getSubscriptions();
    }

    @DeleteMapping()
    ResponseEntity<?> cancelSubscription(@RequestParam Long id) throws SubscriptionNotFoundException {
        publicService.cancelSubscription(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
