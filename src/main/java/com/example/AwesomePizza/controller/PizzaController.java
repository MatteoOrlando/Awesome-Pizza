package com.example.AwesomePizza.controller;

import com.example.AwesomePizza.entities.Pizza;
import com.example.AwesomePizza.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {
    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping("/")
    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<Pizza> createPizza(@RequestBody Pizza pizza) {
        Pizza savedPizza = pizzaRepository.save(pizza);
        return new ResponseEntity<>(savedPizza, HttpStatus.CREATED);
    }
}