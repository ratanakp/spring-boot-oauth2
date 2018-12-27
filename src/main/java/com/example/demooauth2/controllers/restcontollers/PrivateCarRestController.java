package com.example.demooauth2.controllers.restcontollers;

import com.example.demooauth2.entities.Car;
import com.example.demooauth2.repositories.CarRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/private/cars")
public class PrivateCarRestController {


    private CarRepository carRepository;

    public PrivateCarRestController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @PostMapping("")
    @PreAuthorize("#oauth2.hasScope('write')")
    public Car save(@RequestBody Car car) {
        return this.carRepository.save(car);
    }

    @DeleteMapping("/{id}")
    public String getOne(@PathVariable Integer id) {
        this.carRepository.deleteById(id);
        return "ok";
    }

}
