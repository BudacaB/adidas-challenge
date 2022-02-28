package com.adidas.publicservice.integration;

import com.adidas.publicservice.exceptions.SubscriptionNotFoundException;
import com.adidas.publicservice.model.Subscription;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SubscriptionClient {

    private final String subscriptionServiceUrl = "http://localhost:8081/subscription/v1/api";
    private final RestTemplate restTemplate = new RestTemplate();

    public Subscription getSubscriptionById(Long id) throws SubscriptionNotFoundException {
        try {
            return restTemplate.getForObject(subscriptionServiceUrl + "/getSubscriptionById/" + id, Subscription.class);
        } catch (Exception e) {
            throw new SubscriptionNotFoundException();
        }
    }

    public Long createSubscription(Subscription subscription) {
        HttpEntity<Subscription> request = new HttpEntity<>(subscription);
        return restTemplate.postForObject(subscriptionServiceUrl + "/createSubscription", request, Long.class);
    }
}
