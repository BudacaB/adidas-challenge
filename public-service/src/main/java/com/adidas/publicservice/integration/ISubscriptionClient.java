package com.adidas.publicservice.integration;

import com.adidas.publicservice.model.Subscription;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient(value = "subscriptionClient", url = "localhost:8082/subscription/api/v1")
public interface ISubscriptionClient {

    @RequestMapping(method = GET, value = "getSubscriptionById")
    Subscription getSubscriptionById(Long id);
}
