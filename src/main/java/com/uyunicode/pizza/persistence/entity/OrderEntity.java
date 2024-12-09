package com.uyunicode.pizza.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pizza_order")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Integer orderId;
    @Column(name = "customer_id", nullable = false)
    private Integer customerId;
    @Column(nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime date;
    @Column(nullable = false, columnDefinition = "DECIMAL(6,2)")
    private BigDecimal total;
    @Column(nullable = false, columnDefinition = "CHAR(1)")
    private String method;
    @Column(name = "additional_notes", length = 200)
    private String additionalNotes;

    @OneToOne // una order esta relacionado a un consumidor
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
    private CustomerEntity customer;

    @OneToMany(mappedBy = "order") // una orden puede tener muchos items
    private List<OrderItemEntity> items;
}
