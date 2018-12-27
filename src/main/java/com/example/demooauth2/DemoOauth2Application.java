package com.example.demooauth2;

import com.example.demooauth2.entities.Car;
import com.example.demooauth2.entities.Role;
import com.example.demooauth2.entities.User;
import com.example.demooauth2.entities.enums.RoleName;
import com.example.demooauth2.repositories.CarRepository;
import com.example.demooauth2.repositories.RoleRepository;
import com.example.demooauth2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoOauth2Application implements ApplicationRunner {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoOauth2Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Car> cars = Arrays.asList(new Car("blue", 4), new Car("red", 16));

        this.carRepository.saveAll(cars);


        List<Role> roles = Arrays.asList(new Role(RoleName.ROLE_USER), new Role(RoleName.ROLE_ADMIN));

        List<Role> addedRoles = this.roleRepository.saveAll(roles);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        List<User> users = Arrays
                .asList(new User("virak",
                                "virak_killer",
                                "virak_killer@gmail.com",
                                passwordEncoder.encode("123456789"),
                                Arrays.asList(addedRoles.get(0))),

                        new User("thonn",
                                "thonn_msi",
                                "thonn_msi@gmail.com",
                                passwordEncoder.encode("009900"),
                                addedRoles)
                );

        this.userRepository.saveAll(users);

    }
}