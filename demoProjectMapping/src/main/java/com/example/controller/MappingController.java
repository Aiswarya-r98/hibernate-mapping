package com.example.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Countries;
import com.example.entities.Departments;
import com.example.entities.Employees;
import com.example.entities.JobHistory;
import com.example.entities.Jobs;
import com.example.entities.Locations;
import com.example.entities.Regions;
import com.example.repos.CountriesRepo;
import com.example.repos.DepartmentsRepo;
import com.example.repos.EmployeesRepo;
import com.example.repos.JobHistoryRepo;
import com.example.repos.JobsRepo;
import com.example.repos.LocationsRepo;
import com.example.repos.RegionsRepo;

@RestController
@RequestMapping("/api")
public class MappingController {

	@Autowired
	private RegionsRepo regionsRepo;

	@Autowired
	private CountriesRepo countriesRepo;

	@Autowired
	private LocationsRepo locationsRepo;
	
	@Autowired
	private JobsRepo jobsRepo;
	
	@Autowired
	private DepartmentsRepo depRepo;
	
	@Autowired
	private EmployeesRepo employeesRepo;
	
	@Autowired
	private JobHistoryRepo jobHistoryRepo;
	
	@PostMapping("/regions")
	public Regions saveRegion() {

		Regions region = new Regions();
		region.setRegionName("South Asia");
		regionsRepo.save(region);

		return region;
	}

	@GetMapping("/regions")
	public List<Regions> getRegion() {
		return (List<Regions>) regionsRepo.findAll();
	}

	@PostMapping("/country")
	public Countries saveCountry() {

		Optional<Regions> region = regionsRepo.findById(1);

		Countries country = new Countries();
		country.setCountryName("India");
		country.setRegions(region.get());
		countriesRepo.save(country);

		return country;
	}

	@GetMapping("/country")
	public List<Countries> getCountry() {
		return (List<Countries>) countriesRepo.findAll();
	}

	@PostMapping("/location")
	public Locations saveLocation() {
		Optional<Countries> country = countriesRepo.findById(1);

		Locations locations = new Locations();
		locations.setStreetAddress("street1");
		locations.setCity("city1");
		locations.setStateProvince("State Provice1");
		locations.setPostalCode("123456");
		locations.setCountries(country.get());
		locationsRepo.save(locations);

		return locations;
	}

	@GetMapping("/location")
	public List<Locations> getLocation() {
		return (List<Locations>) locationsRepo.findAll();
	}
	
	@PostMapping("/job")
	public Jobs savejobs() {
		com.example.entities.Jobs job = new Jobs();
		job.setJobTitle("Java Developer");
		job.setMinSalary(21000.0);
		job.setMaxSalary(50000.0);
		jobsRepo.save(job);
		return job;
	}

	@GetMapping("/job")
	public List<Jobs> getjobs() {
		return (List<Jobs>) jobsRepo.findAll();
	}
	
	@PostMapping("/dept")
	public Departments savedept() {
		
		
		
//		Employees emp = new Employees();
//		emp.setFirstName("fname");
//		emp.setLastName("lastname");
//		emp.setEmail("aaa@gmail.com");
//		emp.setHireDate(LocalDate.parse("12/12/1974"));
//		emp.setCommissionPct(0.2);
//		emp.setSalary(30000.0);
//		emp.setJob(null);
//		emp.setManager(emp);
//		
		
		Departments dept = new Departments();
		dept.setDepartmentName("department1");
		dept.setLocation(locationsRepo.findById(1).get());
		dept.setManager(null);
		depRepo.save(dept);
		return dept;
	}

	@GetMapping("/dept")
	public List<Departments> getdept() {
		return (List<Departments>) depRepo.findAll();
	}
	
	@PostMapping("/employee")
	public Employees saveEmp() {
		
		
		
		Employees emp = new Employees();
		emp.setFirstName("fname");
		emp.setLastName("lastname");
		emp.setEmail("aaa@gmail.com");
		emp.setHireDate(LocalDate.now());
		emp.setCommissionPct(0.2);
		emp.setSalary(30000.0);
		emp.setJob(jobsRepo.findById(1).get());
		emp.setPhoneNumber("9876543210");
		emp.setManager(emp);
		emp.setDepartment(depRepo.findById(1).get());
		
		employeesRepo.save(emp);
		return emp;
	}
	
	@GetMapping("/employee")
	public List<Employees> getEmp() {
		return (List<Employees>) employeesRepo.findAll();
	}
	
	@PostMapping("/jobHistory")
	public JobHistory saveJobHistory() {
		
		JobHistory jobHistory = new JobHistory();
		jobHistory.setEmployees(employeesRepo.findById(1).get());
		jobHistory.setStartDate(LocalDate.parse("2019-01-01"));
		jobHistory.setEndDate(LocalDate.parse("2020-01-01"));
		jobHistory.setDetartments(depRepo.findById(1).get());
		jobHistoryRepo.save(jobHistory);
		return jobHistory;
	}
	
	@GetMapping("/jobHistory")
	public List<JobHistory> getJobHistory() {
		return (List<JobHistory>) jobHistoryRepo.findAll();
	}
}
