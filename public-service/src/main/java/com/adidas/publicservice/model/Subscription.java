package com.adidas.publicservice.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Subscription {

    private Long id;
    private String firstName;
    private String gender;
    private LocalDate dateOfBirth;
    private Boolean consent;
    private Long newsletterId;
}
