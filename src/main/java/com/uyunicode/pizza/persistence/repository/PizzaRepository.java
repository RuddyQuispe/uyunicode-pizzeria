package com.uyunicode.pizza.persistence.repository;

import com.uyunicode.pizza.persistence.entity.PizzaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository<PizzaEntity, Integer> {
}
