package com.example.demo.service;

import com.example.demo.model.Dog;
import com.example.demo.repository.DogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class DogServiceImpl implements DogService {
    @Autowired
    DogRepo dogRepo;
    @Override
    public Iterable<Dog> findAll() {
        return dogRepo.findAll();
    }

    @Override
    public Optional<Dog> findById(Long id) {
        return dogRepo.findById(id);
    }

    @Override
    public Dog save(Dog dog) {
        return dogRepo.save(dog);
    }

    @Override
    public void delete(Long id) {
        dogRepo.deleteById(id);
    }
}
