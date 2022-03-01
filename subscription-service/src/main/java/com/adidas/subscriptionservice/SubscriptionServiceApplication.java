package com.adidas.subscriptionservice;

import com.adidas.subscriptionservice.MessagingIntegration.SubscriptionMessagingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SubscriptionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubscriptionServiceApplication.class, args);

		String topic = "email";
		String broker = "tcp://127.0.0.1:1883";

		SubscriptionMessagingService messageService = new SubscriptionMessagingService(topic, broker);
		messageService.publish("New Message");
	}

}
