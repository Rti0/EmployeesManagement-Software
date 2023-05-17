package com.example.employeesmanagement.Controller;


import com.example.employeesmanagement.ApiResponse.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/Employee")
public class EmployeesController {
    ArrayList<Employees> employee = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList getEmployees() {
        return employee;

    }

    //add-post
    @PostMapping("/add")
    public ResponseEntity addEmployees(@Valid @RequestBody Employees employees, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(message));
        }
        employee.add(employees);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Employee is Added");
    }

    //update-put
    @PutMapping("/update/{index}")
    public ResponseEntity updateEmployees(@Valid @RequestBody Employees employees, Errors errors, @PathVariable int index) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(message));
        }
        employee.set(index, employees);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(" Employee is Updated");
    }

    //Delete
    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteEmployee(@Valid @RequestBody @PathVariable int index, Errors errors) {
        employee.remove(index);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Employee is deleted"));
    }

    @PutMapping("/leave/{index}")
    public ResponseEntity requestLeave(@Valid int annualLeave, Errors errors, @PathVariable String index) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(message));
        }
        for (int i = 0; i < employee.size(); i++) {
            if (employee.get(i).getId()-1 == annualLeave) {
                employee.get(i).setOnLeave(true);
                System.out.println("request successfully.");
            }else{
        System.out.println("Employee not found!");
                }
            }
        return null;
    }}