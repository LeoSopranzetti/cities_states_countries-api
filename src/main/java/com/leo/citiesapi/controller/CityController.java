package com.leo.citiesapi.controller;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leo.citiesapi.models.City;
import com.leo.citiesapi.repository.CityRepository;

@RestController
@RequestMapping("/cities")
public class CityController {

	@Autowired
	public CityRepository repository;

  
  @GetMapping
  public Page<City> cities( Pageable page) {
    return repository.findAll(page);
  }
  
  @GetMapping("/{name}")
  @Transactional
  public ResponseEntity<Optional<City>> citiesByName(@PathVariable String name) {
	  Optional<City> city = repository.findByname(name);
	  
	  if(city.isEmpty()) {
		  return ResponseEntity.notFound().build();
	  }
	  return ResponseEntity.ok().body(city);
  }


}
