package edu.sabana.poob.sabanapayroll;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class CompensarFundTest {

    private static Faker faker;

    private static List<Employee> employees;
    private static Department department;

    private static EmployeeBySalary employeeBySalary;
    private static EmployeeBySalary employeeBySalary1;

    private static EmployeeByHours employeeByHours;
    private static EmployeeByCommission employeeByCommission;

    private static IFamilyCompensationFund compensarFund;

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

        compensarFund = new CompensarFund();
    }

    @Test
    @DisplayName("GIVEN a employee by salary WHEN try to register THEN success")
    public void shouldRegisterEmployee() throws FamilyCompensationFundException {

        assertTrue(compensarFund.registerEmployee(employeeBySalary1));
    }

    @Test
    @DisplayName("GIVEN a employee by commission WHEN try to register THEN fails")
    public void shouldNotRegisterEmployeeWhenByHours() throws FamilyCompensationFundException {

        Exception e = assertThrows(FamilyCompensationFundException.class, () -> compensarFund.registerEmployee(employeeByHours));
        assertEquals(FamilyCompensationFundException.EMPLOYEE_NOT_ALLOWED, e.getMessage());
    }

    @Test
    @DisplayName("GIVEN a employee by salary registered WHEN try to register again THEN fails")
    public void shouldNotRegisterEmployeeWhenDuplicated() throws FamilyCompensationFundException {

        assertTrue(compensarFund.registerEmployee(employeeByCommission));

        Exception e = assertThrows(FamilyCompensationFundException.class, () -> compensarFund.registerEmployee(employeeByCommission));
        assertEquals(FamilyCompensationFundException.EMPLOYEE_REGISTERED, e.getMessage());
    }

    @Test
    @DisplayName("GIVEN a employee by salary registered WHEN try to delete THEN success")
    public void shouldDeleteEmployee() throws FamilyCompensationFundException {

        assertTrue(compensarFund.registerEmployee(employeeBySalary));
        assertTrue(compensarFund.deleteEmployee(employeeBySalary.getId()));
    }

    @Test
    @DisplayName("GIVEN a employee by salary not registered WHEN try to delete THEN fails")
    public void shouldNotDeleteEmployee() throws FamilyCompensationFundException {

        Exception e = assertThrows(FamilyCompensationFundException.class, () -> compensarFund.deleteEmployee(employeeBySalary.getId()));
        assertEquals(FamilyCompensationFundException.EMPLOYEE_IS_NOT_REGISTERED, e.getMessage());
    }

    @Test
    @DisplayName("GIVEN a employee by salary registered WHEN try to validate is registered THEN success")
    public void shouldValidateEmployeeIsRegistered() throws FamilyCompensationFundException {

        assertTrue(compensarFund.registerEmployee(employeeBySalary));
        assertTrue(compensarFund.isEmployeeRegistered(employeeBySalary.getId()));
    }

    @Test
    @DisplayName("GIVEN a employee by salary not registered WHEN try to validate is registered THEN fails")
    public void shouldNotValidateEmployeeIsRegistered() {

        assertFalse(compensarFund.isEmployeeRegistered(employeeBySalary.getId()));
    }

    @Test
    public void shouldPrintBenefits() {

        String benefits = compensarFund.printBenefits();
        assertNotNull(benefits);
    }
}
