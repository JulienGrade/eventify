package com.eventify.eventify.seed;

import com.eventify.eventify.model.User;
import com.eventify.eventify.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Profile("dev")
public class DevUserSeeder {

    @Bean
    CommandLineRunner seedUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {

            if (userRepository.count() == 0) {

                User admin = new User(
                        "admin",
                        passwordEncoder.encode("admin123"),
                        "ROLE_ADMIN"
                );

                User user = new User(
                        "user",
                        passwordEncoder.encode("user123"),
                        "ROLE_USER"
                );

                userRepository.save(admin);
                userRepository.save(user);
            }
        };
    }
}