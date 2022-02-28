package com.adidas.publicservice;

import com.adidas.publicservice.integration.ISubscriptionClient;
import com.adidas.publicservice.model.Subscription;
import com.adidas.publicservice.service.IPublicService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.doReturn;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PublicServiceTest {

	@Autowired
	IPublicService publicService;

	@MockBean
	ISubscriptionClient subscriptionClient;

	@Test
	void getsSubscriptionById() {
		Subscription subscription = new Subscription();
		subscription.setId(1L);
		subscription.setFirstName("John");
		doReturn(subscription).when(subscriptionClient).getSubscriptionById(1L);
		assertThat(publicService.getSubscriptionById(1L).getFirstName()).isEqualTo("John");
	}

}
