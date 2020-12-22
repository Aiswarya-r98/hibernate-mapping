package com.example.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Jobs;

@Repository
public interface JobsRepo extends CrudRepository<Jobs, Integer> {

}
