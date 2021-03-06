package edu.sabana.poob.sabanapayroll;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class CafamFundTest {

    private static Faker faker;

    private static List<Employee> employees;
    private static Department department;

    private static EmployeeBySalary employeeBySalary;
    private static EmployeeBySalary employeeBySalary1;

    private static EmployeeByHours employeeByHours;
    private static EmployeeByCommission employeeByCommission;

    private static IFamilyCompensationFund cafamFund;

    @BeforeAll
    public static void setUp() {
        faker = new Faker(new Locale("en-US"));

        department = new Department("Engineering");

        employeeBySalary = new EmployeeBySalary(faker.name().firstName(), faker.name().lastName(), department, 1000000,"Saving");
        employeeBySalary1 = new EmployeeBySalary(faker.name().firstName(), faker.name().lastName(), department, 1000000,"Saving");
        employeeByHours = new EmployeeByHours(faker.name().firstName(), faker.name().lastName(), department, 40,"Checking");
        employeeByCommission = new EmployeeByCommission(faker.name().firstName(), faker.name().lastName(), department, 100,"checking");

        employees = new ArrayList<>();
        employees.add(employeeBySalary);
        employees.add(employeeBySalary1);
        employees.add(employeeByHours);
        employees.add(employeeByCommission);

        cafamFund = new CafamFund();
    }

    @Test
    @DisplayName("GIVEN a employee by salary WHEN try to register THEN success")
    public void shouldRegisterEmployee() throws FamilyCompensationFundException {

        assertTrue(cafamFund.registerEmployee(employeeByCommission));
    }

    @Test
    @DisplayName("GIVEN a employee by salary registered WHEN try to register again THEN fails")
    public void shouldNotRegisterEmployeeWhenDuplicated() throws FamilyCompensationFundException {

        assertTrue(cafamFund.registerEmployee(employeeByHours));

        Exception e = assertThrows(FamilyCompensationFundException.class, () -> cafamFund.registerEmployee(employeeByHours));
        assertEquals(FamilyCompensationFundException.EMPLOYEE_REGISTERED, e.getMessage());
    }

    @Test
    @DisplayName("GIVEN a employee by salary registered WHEN try to delete THEN success")
    public void shouldDeleteEmployee() throws FamilyCompensationFundException {

        assertTrue(cafamFund.registerEmployee(employeeBySalary));
        assertTrue(cafamFund.deleteEmployee(employeeBySalary.getId()));
    }

    @Test
    @DisplayName("GIVEN a employee by salary not registered WHEN try to delete THEN fails")
    public void shouldNotDeleteEmployee() throws FamilyCompensationFundException {

        Exception e = assertThrows(FamilyCompensationFundException.class, () -> cafamFund.deleteEmployee(employeeBySalary.getId()));
        assertEquals(FamilyCompensationFundException.EMPLOYEE_IS_NOT_REGISTERED, e.getMessage());
    }

    @Test
    @DisplayName("GIVEN a employee by salary registered WHEN try to validate is registered THEN success")
    public void shouldValidateEmployeeIsRegistered() throws FamilyCompensationFundException {

        assertTrue(cafamFund.registerEmployee(employeeBySalary1));
        assertTrue(cafamFund.isEmployeeRegistered(employeeBySalary1.getId()));
    }

    @Test
    @DisplayName("GIVEN a employee by salary not registered WHEN try to validate is registered THEN fails")
    public void shouldNotValidateEmployeeIsRegistered() {

        assertFalse(cafamFund.isEmployeeRegistered(employeeBySalary.getId()));
    }

    @Test
    public void shouldPrintBenefits() {

        String benefits = cafamFund.printBenefits();
        assertNotNull(benefits);
    }
}
