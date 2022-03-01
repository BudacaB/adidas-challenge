package com.adidas.publicservice;

import com.adidas.publicservice.exceptions.InvalidEmailException;
import com.adidas.publicservice.model.Subscription;
import com.adidas.publicservice.validation.SubscriptionValidator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class SubscriptionValidatorTest {

    @Autowired
    private SubscriptionValidator subscriptionValidator;

    @Test
    void throwsInvalidEmailException() throws InvalidEmailException {
        Subscription subscription = new Subscription();
        subscription.setEmail(null);
        assertThrows(InvalidEmailException.class, () -> subscriptionValidator.isSubscriptionValid(subscription));
    }
}
