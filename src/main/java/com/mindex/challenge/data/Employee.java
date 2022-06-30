package com.mindex.challenge.data;
import org.springframework.data.annotation.Id;
//import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;


//An Employee has a "Compensation" and has a "Reporting Structure". Neither class seem to be a db collection.
//My understanding is that since compensation should persist, I add a field type Compensation in
//Employee. (I base that on the fact that in the employee_database not all employee documents
// have a list of directReports).

// The type ReportingStructure should not persist. It produces the numberOfReports, derived from the directReports List
//in Employee. I think that the @Transient annotation would prevent the mapping of reportingStructure into the database.

@Document
public class Employee {
    @Id
    private String employeeId;
    private String firstName;
    private String lastName;
    private String position;
    private String department;
    private List<Employee> directReports;

    // private Compensation compensation;

    // @Transient
    // private ReportingStructure reportingStructure;

    public Employee() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Employee> getDirectReports() {
        return directReports;
    }

    public void setDirectReports(List<Employee> directReports) {
        this.directReports = directReports;
    }
}
