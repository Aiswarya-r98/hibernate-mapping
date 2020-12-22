package com.example.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Departments;



@Repository
public interface DepartmentsRepo extends CrudRepository<Departments, Integer> {

}
