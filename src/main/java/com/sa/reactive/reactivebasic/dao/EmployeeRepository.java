package com.sa.reactive.reactivebasic.dao;

import com.sa.reactive.reactivebasic.model.Employee;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface EmployeeRepository  extends ReactiveCrudRepository<Employee,Long> {

    @Query("SELECT * FROM  Employee where last_name= :lastName")
    Flux<Employee> findEmployeeByLastName(String lastName);
}
