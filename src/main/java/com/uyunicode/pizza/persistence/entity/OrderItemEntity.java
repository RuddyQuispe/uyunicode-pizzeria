package com.uyunicode.pizza.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "order_item")
@IdClass(OrderItemId.class) // proceso para mas de 1PK
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderItemEntity {
    @Id
    @Column(name = "item_id", nullable = false)
    private Integer itemId;
    @Id
    @Column(name = "order_id", nullable = false)
    private Integer orderId;

    @Column(name = "pizza_id", nullable = false)
    private Integer pizzaId;
    @Column(nullable = false, columnDefinition = "DECIMAL(2,1)")
    private BigDecimal quantity;
    @Column(nullable = false, columnDefinition = "DECIMAL(5,1)")
    private BigDecimal price;

    @OneToOne // un order item solo puede tener una pizza
    @JoinColumn(name = "pizza_id", referencedColumnName = "pizza_id", insertable = false, updatable = false)
    private PizzaEntity pizza;

    @ManyToOne // una orden puede tener muchos items
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", updatable = false, insertable = false)
    private OrderEntity order;
}
