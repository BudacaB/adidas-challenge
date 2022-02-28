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

}
