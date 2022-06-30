package com.mindex.challenge.service.impl;


import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CompensationServiceImplTest {

    private String compensationUrl;
    private String compensationIdUrl;

    @Autowired
    private CompensationService compensationService;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setUp() {
        compensationUrl = "http://localhost:" + port + "/compensation";
        compensationIdUrl = "http://localhost:" + port + "/compensation/{id}";
    }


    @Test
    public void testCreateRead() {
        Compensation compensationTest = new Compensation();

//        Employee testEmployee = new Employee();
//        testEmployee.setFirstName("John");
//        testEmployee.setLastName("Doe");
//        testEmployee.setDepartment("Engineering");
//        testEmployee.setPosition("Developer");

        compensationTest.setEmployeeId("03aa9999-ffa9-4978-901b-7c001562cf6f");

        compensationTest.setSalary(70000.00d);
        compensationTest.setEffectiveDate(new Date(20220701));

        Compensation createdCompensation = restTemplate.postForEntity(compensationUrl, compensationTest, Compensation.class).getBody();
        assertEquals(compensationTest, createdCompensation);
        assertNotNull(compensationTest.getSalary());

        Compensation readCompensation = restTemplate.getForEntity(compensationIdUrl, Compensation.class, createdCompensation.getEmployeeId()).getBody();
        assertEquals(createdCompensation, readCompensation);
        assertEquals(createdCompensation.getEmployeeId(), readCompensation.getEmployeeId());
    }


}