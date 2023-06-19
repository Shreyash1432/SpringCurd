package com.Project.SpringAngular.Service;

import com.Project.SpringAngular.DTO.EmployeeDTO;
import com.Project.SpringAngular.DTO.EmployeeSaveDTO;
import com.Project.SpringAngular.DTO.EmployeeUpdateDTO;

import java.util.List;

public interface EmployeeService {
    String addEmployee(EmployeeSaveDTO employeeSaveDTO);

    List<EmployeeDTO> getAllEmployee();

    String updateEmployees(EmployeeUpdateDTO employeeUpdateDTO);

    boolean deleteEmployee(int id);
}
