package com.example.pramod.SpringbootAngular4.repository;

import com.example.pramod.SpringbootAngular4.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
