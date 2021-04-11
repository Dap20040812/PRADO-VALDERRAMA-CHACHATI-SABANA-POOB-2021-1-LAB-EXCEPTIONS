package edu.sabana.poob.sabanapayroll;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SabanaPayrollTest {

    private static Faker faker;

    private static List<Employee> employees;
    private static Department department;

    private static EmployeeBySalary employeeBySalary;
    private static EmployeeByHours employeeByHours;
    private static EmployeeByCommission employeeByCommission;

    private static SabanaPayroll s;

    @BeforeAll
    public static void setUp() {
        faker = new Faker(new Locale("en-US"));

        department = new Department("Engineering");

        employeeBySalary = new EmployeeBySalary(faker.name().firstName(), faker.name().lastName(), department, 1000000,"Saving");
        employeeByHours = new EmployeeByHours(faker.name().firstName(), faker.name().lastName(), department, 40,"Checking");
        employeeByCommission = new EmployeeByCommission(faker.name().firstName(), faker.name().lastName(), department, 100,"Checking");

        employees = new ArrayList<>();
        employees.add(employeeBySalary);
        employees.add(employeeByHours);
        employees.add(employeeByCommission);
        department.addEmployee(employeeBySalary);
        department.addEmployee(employeeByHours);
        department.addEmployee(employeeByCommission);
        s = new SabanaPayroll(employees);
        s.addDepartment(department);

    }
    @Test
    public void ShouldCalculateEmployeeSalary(){

        assertEquals(920000,s.calculateEmployeeSalary(employeeBySalary.getId()));
        assertEquals(2400000,s.calculateEmployeeSalary(employeeByHours.getId()));
        assertEquals(800000,s.calculateEmployeeSalary(employeeByCommission.getId()));

    }
    @Test
    public void ShouldCalculateDepartmentSalaries(){

        assertEquals(4120000,s.calculateDepartmentSalaries(department.getId()));
    }
    @Test
    public void ShouldCalculateUSalaries(){

        assertEquals(4120000,s.calculateUniversitySalaries());

    }

    @Test
    public void ShouldPrintEmployees(){

        assertTrue(employeeBySalary.toString().contains("Engineering"));
        assertTrue(employeeByHours.toString().contains("Engineering"));
        assertTrue(employeeByCommission.toString().contains("Engineering"));

    }


    @Test
    public void ShouldDepositToEmployee(){

        assertTrue(s.depositToEmployee(employeeBySalary.getId(),10000));
        assertTrue(Double.compare(8000,employeeBySalary.getAccount().getBalance())== 0);
        assertFalse(s.depositToEmployee(employeeByHours.getId(),5000));
        assertTrue(Double.compare(0,employeeByHours.getAccount().getBalance())== 0);
        assertTrue(s.depositToEmployee(employeeByCommission.getId(),6000));
        assertTrue(Double.compare(1000,employeeByCommission.getAccount().getBalance())== 0);

    }

    @Test
    public void ShouldCalculateEmployeeBalance(){

        double a = s.calculateEmployeeBalance(employeeBySalary.getId());
        double b = s.calculateEmployeeBalance(employeeByHours.getId());
        double c = s.calculateEmployeeBalance(employeeByCommission.getId());

        assertTrue(s.depositToEmployee(employeeBySalary.getId(),10000));
        assertTrue(Double.compare(8000+a,s.calculateEmployeeBalance(employeeBySalary.getId()))== 0);
        assertFalse(s.depositToEmployee(employeeByHours.getId(),5000));
        assertTrue(Double.compare(0+b,s.calculateEmployeeBalance(employeeByHours.getId()))== 0);
        assertTrue(s.depositToEmployee(employeeByCommission.getId(),6000));
        assertTrue(Double.compare(1000+c,s.calculateEmployeeBalance(employeeByCommission.getId()))== 0);

    }

    @Test
    public void ShouldCalculateAllEmployeeBalance(){

        double a = s.calculateEmployeeBalance(employeeBySalary.getId());
        double b = s.calculateEmployeeBalance(employeeByHours.getId());
        double c = s.calculateEmployeeBalance(employeeByCommission.getId());
        assertTrue(s.depositToEmployee(employeeBySalary.getId(),10000));
        assertTrue(Double.compare(8000+a,s.calculateEmployeeBalance(employeeBySalary.getId()))== 0);
        assertFalse(s.depositToEmployee(employeeByHours.getId(),5000));
        assertTrue(Double.compare(0+b,s.calculateEmployeeBalance(employeeByHours.getId()))== 0);
        assertTrue(s.depositToEmployee(employeeByCommission.getId(),6000));
        assertTrue(Double.compare(1000+c,s.calculateEmployeeBalance(employeeByCommission.getId()))== 0);
        assertTrue(Double.compare(9000+a+b+c,s.calculateAllEmployeeBalance())== 0);

    }

    @Test
    public void assigneColsubsidioFamilyCompensation() {

        boolean result = s.assigneFamilyCompensation(ColsubsidioFund.class.getSimpleName(), employeeBySalary);
        assertTrue(result);
    }
    @Test
    public void NotassigneColsubsidioFamilyCompensation() {

        boolean result = s.assigneFamilyCompensation(ColsubsidioFund.class.getSimpleName(), employeeByCommission);
        assertFalse(result);
    }

    @Test
    public void assigneCompensarFamilyCompensation() {

        boolean result = s.assigneFamilyCompensation(CompensarFund.class.getSimpleName(), employeeBySalary);
        assertTrue(result);
    }
    @Test
    public void NotassigneCompensarFamilyCompensation() {

        boolean result = s.assigneFamilyCompensation(CompensarFund.class.getSimpleName(), employeeByHours);
        assertFalse(result);
    }
    @Test
    public void assigneCafamFamilyCompensation() {

        boolean result = s.assigneFamilyCompensation(CafamFund.class.getSimpleName(), employeeBySalary);
        assertTrue(result);
    }
}
