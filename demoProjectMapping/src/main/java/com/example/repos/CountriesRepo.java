package com.example.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Countries;


@Repository
public interface CountriesRepo extends CrudRepository<Countries, Integer> {

}
