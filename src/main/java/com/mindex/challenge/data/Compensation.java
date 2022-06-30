package com.mindex.challenge.data;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Compensation {

    //private Employee employee;
    private String employeeId;
    private double salary;

    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date effectiveDate;

    public Compensation() {
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setEffectiveDate(Date date) {
        this.effectiveDate = date;
    }

    public String getEmployeeId() {
        return this.employeeId;
    }

    public double getSalary() {
        return this.salary;
    }

    public Date getEffectiveDate() {
        return this.effectiveDate;
    }


}
