package com.adidas.emailservice.service;

import org.springframework.stereotype.Service;

@Service
public class EmailDispatchService {

    public void dispatchEmail(String details) {
        System.out.println("Email sent with details: " + details);
    }
}
