package com.platzi.pizza.persistence.repository;

import com.platzi.pizza.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

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

    /*
     * @Query -> Sentence SQL Native, consult orders of user specific
     */
    @Query(value = "SELECT * FROM pizza_order WHERE id_customer = :id", nativeQuery = true)
    List<OrderEntity> findCustomerOrders(@Param("id") String idCustomer);
}
