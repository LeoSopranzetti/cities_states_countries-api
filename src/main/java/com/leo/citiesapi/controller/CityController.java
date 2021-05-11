package com.leo.citiesapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
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


}
