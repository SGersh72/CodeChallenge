package com.mindex.challenge.data;

import com.mindex.challenge.data.Employee;
import org.springframework.data.annotation.Transient;

import java.util.List;

public class ReportingStructure {


    @Transient
    private int numberOfReports;
    private String employeeId;

//    public ReportingStructure(Employee employee) {
//        this.employee = employee;
//    }

    public void setNumberOfReports(int numberOfReports) {
        this.numberOfReports = numberOfReports;
    }

    public ReportingStructure(String employeeId) {
        this.employeeId = employeeId;
    }

    //    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }

    public int getNumberOfReports() {
        return this.numberOfReports;
    }

    public String getEmployeeId() {
        return this.employeeId;
    }
}





