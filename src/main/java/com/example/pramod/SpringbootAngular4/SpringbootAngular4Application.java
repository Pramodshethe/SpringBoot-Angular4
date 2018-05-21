package com.example.pramod.SpringbootAngular4;

import com.example.pramod.SpringbootAngular4.model.User;
import com.example.pramod.SpringbootAngular4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootAngular4Application{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAngular4Application.class, args);
	}

}
