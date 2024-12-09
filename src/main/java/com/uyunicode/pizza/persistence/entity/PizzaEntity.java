package com.uyunicode.pizza.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "pizza")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PizzaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pizza_id", nullable = false)
    private Integer pizzaId;
    @Column(nullable = false, length = 30, unique = true)
    private String name;
    @Column(nullable = false, length = 150)
    private String description;
    @Column(nullable = false, columnDefinition = "DECIMAL(5,2)")
    private BigDecimal price;
    @Column(columnDefinition = "SMALLINT")
    private Boolean vegetarian;
    @Column(columnDefinition = "SMALLINT")
    private Boolean vegan;
    @Column(columnDefinition = "SMALLINT", nullable = false)
    private Boolean available;
}
