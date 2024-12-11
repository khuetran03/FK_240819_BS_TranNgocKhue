package ra.HR;

import java.util.Date;
import java.util.Scanner;

public class Employee implements IHR {
    private int employeeId;
    private String employeeName;
    private String employeePosition;
    private double employeeSalary;
    private Date employeeHireDate;
    private int empDepartmentId;

    public Employee() {
    }

    public Employee(int employeeId, String employeeName, String employeePosition, double employeeSalary, Date employeeHireDate, int empDepartmentId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeePosition = employeePosition;
        this.employeeSalary = employeeSalary;
        this.employeeHireDate = employeeHireDate;
        this.empDepartmentId = empDepartmentId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public Date getEmployeeHireDate() {
        return employeeHireDate;
    }

    public void setEmployeeHireDate(Date employeeHireDate) {
        this.employeeHireDate = employeeHireDate;
    }

    public int getEmpDepartmentId() {
        return empDepartmentId;
    }

    public void setEmpDepartmentId(int empDepartmentId) {
        this.empDepartmentId = empDepartmentId;
    }

    @Override
    public void inputData(Scanner sc) {

    }

    @Override
    public void displayData() {

    }
}
