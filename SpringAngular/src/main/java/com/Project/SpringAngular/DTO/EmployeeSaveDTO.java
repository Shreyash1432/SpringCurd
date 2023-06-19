package com.Project.SpringAngular.DTO;

public class EmployeeSaveDTO {


    private static String employeename;
    private static String employeeaddress;
    private static long mobile;

    public EmployeeSaveDTO(String employeename, String employeeaddress, long mobile) {
        this.employeename = employeename;
        this.employeeaddress = employeeaddress;
        this.mobile = mobile;
    }


    public static String getEmployeename() {
        return employeename;
    }

    public static void setEmployeename(String employeename) {
        EmployeeSaveDTO.employeename = employeename;
    }

    public static String getEmployeeaddress() {
        return employeeaddress;
    }

    public static void setEmployeeaddress(String employeeaddress) {
        EmployeeSaveDTO.employeeaddress = employeeaddress;
    }

    public static long getMobile() {
        return mobile;
    }

    public static void setMobile(long mobile) {
        EmployeeSaveDTO.mobile = mobile;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                ", employeename='" + employeename + '\'' +
                ", employeeaddress='" + employeeaddress + '\'' +
                ", mobile=" + mobile +
                '}';
    }
}
