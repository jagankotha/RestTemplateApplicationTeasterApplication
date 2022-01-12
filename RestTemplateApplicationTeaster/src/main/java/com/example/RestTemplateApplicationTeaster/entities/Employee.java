package com.example.RestTemplateApplicationTeaster.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Employee {
    private int empId;
    private String empCode;
    private String empName;
    private String empAddr;

}
