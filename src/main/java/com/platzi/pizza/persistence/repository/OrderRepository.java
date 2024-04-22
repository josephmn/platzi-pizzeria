package com.platzi.pizza.persistence.repository;

import com.platzi.pizza.persistence.entity.OrderEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer> {
    /*
     * Query Method -> Search Orders with date today
     */
    List<OrderEntity> findAllByDateAfter(LocalDateTime date);

    /*
     * Query Method -> Search Orders by methods
     */
    List<OrderEntity> findAllByMethodIn(List<String> methods);
}
