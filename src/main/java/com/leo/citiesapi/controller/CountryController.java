package com.leo.citiesapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leo.citiesapi.models.Country;
import com.leo.citiesapi.repository.CountryRepository;

@RestController
@RequestMapping("/countries")
public class CountryController {

	@Autowired
	public CountryRepository countryRepository;
		
	@GetMapping
	public Page<Country> countries(Pageable page){
		Page<Country> countries = countryRepository.findAll(page);
		return countries;
	}
	
	@GetMapping("{id}")
	public ResponseEntity getOne(@PathVariable Long id) {
		Optional<Country> country = countryRepository.findById(id);
		
		if(country.isPresent()) {
			return ResponseEntity.ok().body(country.get());
		}
		
		return ResponseEntity.badRequest().build();
		
	}
}

