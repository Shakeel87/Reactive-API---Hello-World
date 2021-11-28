package com.sa.reactive.reactivebasic.controller;

import com.sa.reactive.reactivebasic.dao.EmployeeRepository;
import com.sa.reactive.reactivebasic.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;


@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;


    @PostMapping("/employees/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<ResponseEntity> addEmployee( @RequestBody Employee employee) {
        Mono<Employee> employeeMono = employeeRepository.save(employee);

        return employeeMono
                .map(value -> ResponseEntity.status(HttpStatus.CREATED)
                        .body(value));
    }

    @GetMapping("/employees")
    public Flux<Employee> getAllEmployees() {
        return employeeRepository.findAll();

    }

    @GetMapping("/employees/{lastName}")
    public Flux<Employee>
    getEmployeeByLastName(@PathVariable(value = "lastName") String lastName) {

        return employeeRepository.findEmployeeByLastName(lastName);
    }
}
