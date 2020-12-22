package com.example.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Locations;



@Repository
public interface LocationsRepo extends CrudRepository<Locations, Integer> {

}
