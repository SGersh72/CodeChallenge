package com.mindex.challenge.data;

import com.mindex.challenge.data.Employee;
import org.springframework.data.annotation.Transient;

import java.util.List;
import java.util.Set;

public class ReportingStructure {

    @Transient
    private int numberOfReports;
    private String employeeId;


    public ReportingStructure() {
    }


    public int getNumberOfReports() {
        return this.numberOfReports;
    }

    public void setNumberOfReports(int numberOfReports) {
        this.numberOfReports = numberOfReports;
    }

    public String getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(Employee employee) {
        this.employeeId = employeeId;
    }
}





