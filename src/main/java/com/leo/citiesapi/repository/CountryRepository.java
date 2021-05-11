package com.leo.citiesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.leo.citiesapi.models.Country;

public interface CountryRepository extends JpaRepository<Country, Long>{

}
