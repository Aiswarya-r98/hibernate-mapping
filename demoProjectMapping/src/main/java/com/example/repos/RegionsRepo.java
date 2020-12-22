package com.example.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Regions;


@Repository
public interface RegionsRepo extends CrudRepository<Regions, Integer> {

}
