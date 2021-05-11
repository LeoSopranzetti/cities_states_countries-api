package com.leo.citiesapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leo.citiesapi.models.State;
import com.leo.citiesapi.repository.StateRepository;

@RestController
@RequestMapping("/states")
public class StateController {

  private final StateRepository repository;

  public StateController(final StateRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public List<State> states() {
    return repository.findAll();
  }
}

