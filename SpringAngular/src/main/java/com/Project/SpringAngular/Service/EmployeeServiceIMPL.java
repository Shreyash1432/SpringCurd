package com.Project.SpringAngular.Service;

import com.Project.SpringAngular.DTO.EmployeeDTO;
import com.Project.SpringAngular.DTO.EmployeeSaveDTO;
import com.Project.SpringAngular.DTO.EmployeeUpdateDTO;
import com.Project.SpringAngular.EmployeeRepo.EmployeeRepo;
import com.Project.SpringAngular.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceIMPL implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;


    @Override
    public String addEmployee(EmployeeSaveDTO employeeDTO) {
        Employee employee = new Employee(
                EmployeeSaveDTO.getEmployeename(),
                EmployeeSaveDTO.getEmployeeaddress(),
                EmployeeSaveDTO.getMobile()
        );
        employeeRepo.save(employee);
        return employee.getEmployeename();
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> getEmployees = employeeRepo.findAll();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        for (Employee a:getEmployees)
        {
            EmployeeDTO employeeDTO = new EmployeeDTO(
                    a.getEmployeeid(),
                    a.getEmployeename(),
                    a.getEmployeeaddress(),
                    a.getMobile()
            );
            employeeDTOList.add(employeeDTO);
        }
            return employeeDTOList;
    }

    @Override
    public String updateEmployees(EmployeeUpdateDTO employeeUpdateDTO) {
        if(employeeRepo.existsById(employeeUpdateDTO.getEmployeeid())){
            Employee employee = employeeRepo.getById(employeeUpdateDTO.getEmployeeid());

            employee.setEmployeename(employeeUpdateDTO.getEmployeename());
            employee.setEmployeeaddress(employeeUpdateDTO.getEmployeeaddress());
            employee.setMobile(employeeUpdateDTO.getMobile());
            employeeRepo.save(employee);

        }
        else{
            System.out.println("Employee ID Does Not Exist");
        }
        return null;
    }

    @Override
    public boolean deleteEmployee(int id) {

        if(employeeRepo.existsById(id))
        {
            employeeRepo.deleteById(id);
        }
        else
        {
            System.out.println("Employee Id Not Found");
        }

        return true;
    }

}
