package com.adidas.subscriptionservice;

import com.adidas.subscriptionservice.assembly.SubscriptionAssembler;
import com.adidas.subscriptionservice.model.Subscription;
import com.adidas.subscriptionservice.model.SubscriptionEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AssemblyTest {

    @Autowired
    private SubscriptionAssembler subscriptionAssembler;

    @Test
    void assemblesToSubscriptionEntity() {
        Subscription subscription = new Subscription();
        subscription.setEmail("a@b.com");
        subscription.setFirstName("Bob");
        subscription.setGender("M");
        subscription.setDateOfBirth(LocalDate.of(2019, 04, 05));
        subscription.setConsent(TRUE);
        subscription.setNewsletterId(123L);
        SubscriptionEntity subscriptionEntity = subscriptionAssembler.toSubscriptionEntity(subscription);
        assertThat(subscriptionEntity.getEmail()).isEqualTo("a@b.com");
        assertThat(subscriptionEntity.getFirstName()).isEqualTo("Bob");
        assertThat(subscriptionEntity.getGender()).isEqualTo("M");
        assertThat(subscriptionEntity.getDateOfBirth()).isEqualTo("2019-04-05");
        assertThat(subscriptionEntity.getConsent()).isEqualTo(TRUE);
        assertThat(subscriptionEntity.getNewsletterId()).isEqualTo(123L);
    }
}
