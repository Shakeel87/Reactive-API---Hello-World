package com.sa.reactive.reactivebasic.model;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Employee {

    @Id
    private  Long id;
    private String firstName;
    private String lastName;
    private String email;


    public Employee(String firstName, String lastName, String email) {
        this.firstName =firstName;
        this.lastName =lastName;
        this.email=email;
    }
}
