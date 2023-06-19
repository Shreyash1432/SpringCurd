package com.Project.SpringAngular.EmployeeController;

import com.Project.SpringAngular.DTO.EmployeeDTO;
import com.Project.SpringAngular.DTO.EmployeeSaveDTO;
import com.Project.SpringAngular.DTO.EmployeeUpdateDTO;
import com.Project.SpringAngular.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:4200")
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/")
    public String saveEmployee(@RequestBody EmployeeSaveDTO employeeSaveDTO){
    String id = employeeService.addEmployee(employeeSaveDTO);
    return id;
    }

    @GetMapping("/get")
    public List<EmployeeDTO> getAllEmployee(){
        List<EmployeeDTO>allEmployees = employeeService.getAllEmployee();
        return allEmployees;
    }

    @PutMapping("/update")
    public String updateEmployee(@RequestBody EmployeeUpdateDTO employeeUpdateDTO){
        String id = employeeService.updateEmployees(employeeUpdateDTO);
        return id;
    }

    @DeleteMapping("/delete")
    public String deleteEmployee(@PathVariable(value = "id") int id){
        boolean deleteemployee = employeeService.deleteEmployee(id);
        return "deleted";
    }
}
