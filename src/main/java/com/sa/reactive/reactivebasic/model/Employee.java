package com.sa.reactive.reactivebasic.model;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Employee {

    @Id
    private  Long id;
    private String first_name;
    private String last_name;
    private String email;

    public Employee(String first_name, String last_name, String email) {
        this.first_name =first_name;
        this.last_name =last_name;
        this.email =email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(first_name, employee.first_name) && Objects.equals(last_name, employee.last_name) && Objects.equals(email, employee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, email);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
