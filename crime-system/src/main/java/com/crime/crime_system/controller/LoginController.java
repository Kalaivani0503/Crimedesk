package com.crime.crime_system.controller;

import com.crime.crime_system.dto.LoginRequest;
import com.crime.crime_system.entity.User;
import com.crime.crime_system.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class LoginController {

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public String login(@RequestBody LoginRequest req) {
		try {
			if (req == null) return "Request is null";

			String email = req.getEmail();
			String password = req.getPassword();
			String role = req.getRole();

			if (email == null || password == null || role == null) {
				return "Missing fields";
			}

			User user = userService.authenticate(email, password, role);

			if (user == null) {
				return "Invalid credentials";
			}

			return user.getRole();
		} catch (Exception e) {
			return "Server error: " + e.getMessage();
		}
	}
}