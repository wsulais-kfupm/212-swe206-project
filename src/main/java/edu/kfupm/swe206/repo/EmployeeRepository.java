package edu.kfupm.swe206.repo;


import edu.kfupm.swe206.model.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {}
