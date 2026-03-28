package com.crime.crime_system.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/crime")
public class CrimeController {

	@GetMapping("/test")
	public String test() {
		return "Crime Controller Working";
	}
}