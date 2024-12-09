package com.uyunicode.pizza.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Integer customerId;
    @Column(nullable = false, length = 60, unique = true)
    private String name;
    @Column(length = 100)
    private String address;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(name = "phone_number", length = 20)
    private String phoneNumber;
}
