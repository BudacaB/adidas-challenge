package com.adidas.publicservice.validation;

import com.adidas.publicservice.exceptions.InvalidEmailException;
import com.adidas.publicservice.model.Subscription;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionValidator {

    public void isSubscriptionValid(Subscription subscription) throws InvalidEmailException {
        if (subscription.getEmail() == null || subscription.getEmail().trim().isEmpty()) {
            throw new InvalidEmailException();
        }
        //    --- other checks ---
    }

//    --- other fields checks ---
}
