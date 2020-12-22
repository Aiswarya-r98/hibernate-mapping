package com.example.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.JobHistory;


@Repository
public interface JobHistoryRepo extends CrudRepository<JobHistory, Integer> {

}
