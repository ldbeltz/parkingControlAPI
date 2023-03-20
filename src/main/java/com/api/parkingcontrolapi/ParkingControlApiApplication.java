package com.api.parkingcontrolapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@SpringBootApplication
@RestController
public class ParkingControlApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkingControlApiApplication.class, args);
        System.out.println(new BCryptPasswordEncoder().encode("password"));
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        System.out.println(uuid.version());
    }

    @GetMapping("/")
    public String index(){
        return "Hello World";
    }
}
