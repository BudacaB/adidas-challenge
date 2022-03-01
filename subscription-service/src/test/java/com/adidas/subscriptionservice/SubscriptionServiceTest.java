package com.adidas.subscriptionservice;

import com.adidas.subscriptionservice.data.SubscriptionRepository;
import com.adidas.subscriptionservice.exceptions.SubscriptionNotFoundException;
import com.adidas.subscriptionservice.model.SubscriptionEntity;
import com.adidas.subscriptionservice.service.ISubscriptionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
class SubscriptionServiceTest {

	@Autowired
	private ISubscriptionService subscriptionService;

	@MockBean
	private SubscriptionRepository subscriptionRepository;

	@Test
	void getsSubscriptionById() throws SubscriptionNotFoundException {
		SubscriptionEntity subscriptionEntity = new SubscriptionEntity();
		subscriptionEntity.setFirstName("Bob");
		doReturn(Optional.of(subscriptionEntity)).when(subscriptionRepository).findById(1L);
		assertThat(subscriptionService.getSubscriptionById(1L).getFirstName()).isEqualTo("Bob");
	}

	@Test
	void getsSubscriptionByIdNotFound() throws SubscriptionNotFoundException {
		given(subscriptionRepository.findById(1L)).willAnswer( invocation -> { throw new SubscriptionNotFoundException(); });
		assertThrows(SubscriptionNotFoundException.class, () -> subscriptionService.getSubscriptionById(1L));
	}

//	--- other checks ---

}
