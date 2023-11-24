package com.csi.service.test;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepo;
import com.csi.service.EmployeeServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeeServiceImplTest {

    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;

    @MockBean
    private EmployeeRepo employeeRepoImpl;

    @org.junit.jupiter.api.Test
    public void findAllTest() {
        Mockito.when(employeeRepoImpl.findAll()).thenReturn(Stream.of(new Employee(121, "SWARA", "PUNE", 56757677768L, 5468455.56, new Date()),
                new Employee(122, "LAKSHMI", "PUNE", 56757677768L, 5468455.56, new Date()),
                new Employee(125, "RAM", "PUNE", 56757677768L, 5468455.56, new Date())).collect(Collectors.toList()));

        Assertions.assertEquals(3, employeeServiceImpl.findAll().size());
    }

    @org.junit.jupiter.api.Test
    public void saveTest() {

        Employee employee = new Employee(121, "SWARA", "PUNE", 56757677768L, 5468455.56, new Date());

        employeeServiceImpl.save(employee);

        Mockito.verify(employeeRepoImpl, Mockito.times(1)).save(employee);


    }

    @org.junit.jupiter.api.Test
    public void updateTest() {
        Employee employee = new Employee(121, "SWARA", "PUNE", 56757677768L, 5468455.56, new Date());

        employeeServiceImpl.update(employee);

        Mockito.verify(employeeRepoImpl, Mockito.times(1)).save(employee);
    }

    @Test
    public void deleteByIdTest() {
        Employee employee = new Employee(121, "SWARA", "PUNE", 56757677768L, 5468455.56, new Date());

        employeeServiceImpl.deleteById(employee.getEmpId());

        Mockito.verify(employeeRepoImpl, Mockito.times(1)).deleteById(employee.getEmpId());
    }
}
