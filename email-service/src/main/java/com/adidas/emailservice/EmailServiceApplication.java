package com.adidas.emailservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailServiceApplication.class, args);

		String topic = "email";
		String broker = "tcp://127.0.0.1:1883";

		SubscriptionMessagingService messageService = new SubscriptionMessagingService(topic, broker);
		messageService.subscribe();
	}

}
