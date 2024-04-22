package com.platzi.pizza.service;

import com.platzi.pizza.persistence.entity.PizzaEntity;
import com.platzi.pizza.persistence.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    /*
    private final JdbcTemplate jdbcTemplate;
     */
    private final PizzaRepository pizzaRepository;

    @Autowired
    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }
    /*
    public PizzaService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PizzaEntity> getAll() {
        return this.jdbcTemplate.query(
                "SELECT * FROM pizza",
                new BeanPropertyRowMapper<>(PizzaEntity.class)
        );
    }

    public List<PizzaEntity> getAllInactive() {
        return this.jdbcTemplate.query(
                "SELECT * FROM pizza WHERE available = 0",
                new BeanPropertyRowMapper<>(PizzaEntity.class)
        );
    }
     */

    public List<PizzaEntity> getAll() {
        return this.pizzaRepository.findAll();
    }

    public List<PizzaEntity> getAvailable() {
        return this.pizzaRepository.findAllByAvailableTrueOrderByPrice();
    }

    public List<PizzaEntity> getByName(String name) {
        return this.pizzaRepository.findAllByAvailableTrueAndNameIgnoreCase(name);
    }

    public List<PizzaEntity> getWith(String ingredient) {
        return this.pizzaRepository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(ingredient);
    }

    public List<PizzaEntity> getWithout(String ingredient) {
        return this.pizzaRepository.findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(ingredient);
    }

    public PizzaEntity get(int idPizza) {
        return this.pizzaRepository.findById(idPizza).orElse(null);
    }

    public PizzaEntity save(PizzaEntity pizza) {
        return this.pizzaRepository.save(pizza);
    }

    public void delete(int idPizza) {
        this.pizzaRepository.deleteById(idPizza);
    }

    public boolean exists(int idPizza) {
        return this.pizzaRepository.existsById(idPizza);
    }
}
