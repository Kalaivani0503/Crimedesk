package com.crime.crime_system.repository;

import com.crime.crime_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    List<User> findByRole(String role);
}