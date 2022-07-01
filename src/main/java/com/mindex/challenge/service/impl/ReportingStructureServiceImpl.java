package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    private Map<String, ReportingStructure> reportingStructureMap = new HashMap<>();
    ReportingStructure reportingStructure;
    public ReportingStructure save(String id) {
        LOG.debug("Creating reporting structure with employee id [{}]", id);

        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        reportingStructure.setEmployeeId(employeeRepository.findByEmployeeId(id));

        Set<Employee> distinctDR = (Set<Employee>) employee.getDirectReports();

        for (Employee report : employee.getDirectReports()) {
            if (report.getDirectReports() != null) {
                distinctDR.addAll(report.getDirectReports());
            }
        }
        reportingStructure.setNumberOfReports(distinctDR.size());

        reportingStructureMap.put(reportingStructure.getEmployeeId(), reportingStructure);
        return reportingStructureMap.get(reportingStructure.getEmployeeId());
    }

    @Override
    public ReportingStructure read(String id) {
        LOG.debug("Creating reporting structure with employee id [{}]", id);

        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }
        return save(id);
    }

}
