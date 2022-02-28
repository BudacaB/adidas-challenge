package com.adidas.subscriptionservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name= "subscriptions")
@Getter
@Setter
public class SubscriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="email")
    private String email;

    @Column(name="first_name")
    private String firstName;

    @Column(name="gender")
    private String gender;

    @Column(name="date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name="consent")
    private Boolean consent;

    @Column(name="newsletter_id")
    private Long newsletterId;
}
