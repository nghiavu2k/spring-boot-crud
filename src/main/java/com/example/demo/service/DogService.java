package com.example.demo.service;

import com.example.demo.model.Dog;

import java.util.Optional;

public interface DogService {
    Iterable<Dog> findAll();
    Optional<Dog> findById(Long id);
    Dog save(Dog dog);
    void delete(Long id);
}
