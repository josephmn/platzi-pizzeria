package com.platzi.pizza.persistence.repository;

import com.platzi.pizza.persistence.entity.PizzaEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {
    /*
     * Query Method -> Pizza Available True and Order By Price
     */
    List<PizzaEntity> findAllByAvailableTrueOrderByPrice();

    /*
     * Query Method -> Pizza by Name
     */
    List<PizzaEntity> findAllByAvailableTrueAndNameIgnoreCase(String name);

    /*
     * Query Method -> Search Ingredient in Pizza
     */
    List<PizzaEntity> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String description);

    /*
     * Query Method -> Search Ingredient not in Pizza
     */
    List<PizzaEntity> findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description);

    /*
     * Query Method -> Count Pizza Vegan
     */
    int countByVeganTrue();
}
