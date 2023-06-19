package com.Project.SpringAngular.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "employeetab")
public class Employee {

    @Id
//    @Column(name = "employee_id", length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeid;

    //@Column(name = "employee_name", length = 50)
    private String employeename;

   // @Column(name = "employee_address", length = 60)
    private String employeeaddress;

    //@Column(name = "mobile", length = 12)
    private long mobile;


    public Employee(String employeename, String employeeaddress, long mobile) {
        //this.employeeid = employeeid;
        this.employeename = employeename;
        this.employeeaddress = employeeaddress;
        this.mobile = mobile;
    }

    public Employee() {
    }

    public int getEmployeeid() {

        return employeeid;
    }

    public void setEmployeeid(int employeeid) {

        this.employeeid = employeeid;
    }

    public String getEmployeename() {

        return employeename;
    }

    public void setEmployeename(String employeename) {

        this.employeename = employeename;
    }

    public String getEmployeeaddress() {

        return employeeaddress;
    }

    public void setEmployeeaddress(String employeeaddress) {

        this.employeeaddress = employeeaddress;
    }

    public long getMobile() {

        return mobile;
    }

    public void setMobile(long mobile) {

        this.mobile = mobile;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "employeeid=" + employeeid +
                ", employeename='" + employeename + '\'' +
                ", employeeaddress='" + employeeaddress + '\'' +
                ", mobile=" + mobile +
                '}';
    }
}
