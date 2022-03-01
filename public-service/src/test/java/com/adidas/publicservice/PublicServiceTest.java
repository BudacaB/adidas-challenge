package com.adidas.publicservice;

import com.adidas.publicservice.exceptions.SubscriptionNotFoundException;
import com.adidas.publicservice.integration.SubscriptionClient;
import com.adidas.publicservice.model.Subscription;
import com.adidas.publicservice.service.IPublicService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

@SpringBootTest
class PublicServiceTest {

	@Autowired
	private IPublicService publicService;

	@MockBean
	private SubscriptionClient subscriptionClient;

	@Test
	void getsSubscriptionById() throws SubscriptionNotFoundException {
		Subscription subscription = new Subscription();
		subscription.setId(1L);
		subscription.setFirstName("John");
		doReturn(subscription).when(subscriptionClient).getSubscriptionById(1L);
		assertThat(publicService.getSubscriptionById(1L).getFirstName()).isEqualTo("John");
	}

	@Test
	void getsSubscriptionByIdNotFound() throws SubscriptionNotFoundException {
		given(subscriptionClient.getSubscriptionById(1L)).willAnswer( invocation -> { throw new SubscriptionNotFoundException(); });
		assertThrows(SubscriptionNotFoundException.class, () -> publicService.getSubscriptionById(1L));
	}

	@Test
	void getsSubscriptions() {
		Subscription subscription1 = new Subscription();
		subscription1.setId(1L);
		subscription1.setFirstName("John");
		Subscription subscription2 = new Subscription();
		subscription2.setId(2L);
		subscription2.setFirstName("Bob");
		Subscription[] subscriptions = new Subscription[2];
		subscriptions[0] = subscription1;
		subscriptions[1] = subscription2;
		doReturn(subscriptions).when(subscriptionClient).getSubscriptions();
		assertThat(publicService.getSubscriptions()[0].getFirstName()).isEqualTo("John");
		assertThat(publicService.getSubscriptions()[1].getFirstName()).isEqualTo("Bob");
		assertThat(publicService.getSubscriptions()[0].getId()).isEqualTo(1L);
		assertThat(publicService.getSubscriptions()[1].getId()).isEqualTo(2L);
	}

	@Test
	void cancelSubscriptionNotFound() throws SubscriptionNotFoundException {
		doThrow(new SubscriptionNotFoundException()).when(subscriptionClient).cancelSubscription(1L);
		assertThrows(SubscriptionNotFoundException.class, () -> publicService.cancelSubscription(1L));
	}
}
