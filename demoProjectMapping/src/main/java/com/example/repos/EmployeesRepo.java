package com.example.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entities.Employees;


@Repository
public interface EmployeesRepo extends CrudRepository<Employees, Integer> {

}
