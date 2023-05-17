package com.example.employeesmanagement.Controller;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Employees {

    @NotNull(message = "Cannot be null")
    @Size(min=2,message = "Length more than 2")
    private int Id;     //

    @NotNull(message = "Cannot be null")
    @Size(min = 4,message = "Length more than 4")
    private String name; //

    @NotNull(message = "Cannot be null")
    @Min(value = 25,message = "It must be more than 25")
    private int age;

    @NotNull(message = "Cannot be null")
    @NotEmpty(message = "must be supervisor or coordinator only")
    private String role;

    @AssertFalse( message = "must be false")   //"annualLeave":"2"
    private boolean onLeave;

    @NotNull(message = "Cannot be null")
    @NotEmpty(message = "must be a valid year")
    private String employmentYear;

    @NotNull(message = "Cannot be null")
    @NotEmpty(message = "it has to be number")
    private int annualLeave;



}
