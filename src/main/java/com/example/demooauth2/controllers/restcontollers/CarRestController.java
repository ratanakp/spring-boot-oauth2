package com.example.demooauth2.controllers.restcontollers;

import com.example.demooauth2.entities.Car;
import com.example.demooauth2.repositories.CarRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/public/cars")
public class CarRestController {

    private CarRepository carRepository;

    public CarRestController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("")
    public List<Car> getAll() {
        return this.carRepository.findAll();
    }

    @GetMapping("/{id}")
    public Car getOne(@PathVariable Integer id) {
        return this.carRepository.getOne(id);
    }
}
