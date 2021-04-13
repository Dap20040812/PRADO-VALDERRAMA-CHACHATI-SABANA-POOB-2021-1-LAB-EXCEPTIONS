package edu.sabana.poob.sabanapayroll;

import java.util.*;
import java.util.stream.Collectors;

public class SabanaPayroll {

    private Collection<Employee> employees;
    private ArrayList<Department> departments;
    private Map<String, IFamilyCompensationFund> compensationFunds;

    public SabanaPayroll(Collection<Employee> employees) {
        this.employees = employees;
        this.departments = new ArrayList<>();
        this.compensationFunds = new HashMap<>();
        this.compensationFunds.put(ColsubsidioFund.class.getSimpleName(), new ColsubsidioFund());
        this.compensationFunds.put(CompensarFund.class.getSimpleName(), new CompensarFund());
        this.compensationFunds.put(CafamFund.class.getSimpleName(), new CafamFund());

    }

    /**
     * Asigna a un emplado una caja de compensacion especifica
     * @param IFamilyCompensationFund
     * @param employeeId
     * @return True si puede registrar al empleado - False si no
     */
    public boolean assigneFamilyCompensation(String IFamilyCompensationFund, UUID employeeId) {

        boolean result = true;
        boolean result1 = false;
        Employee employee = null;
        Iterator<Employee> it = employees.iterator();
        while (!result1 && it.hasNext()) {
            Employee employee1 = it.next();
            if (employee1.getId() == employeeId) {
                employee = employee1;
                result1 = true;
            }
        }
        try {
            compensationFunds.get(IFamilyCompensationFund).registerEmployee(employee);
        }
        catch (FamilyCompensationFundException e)
        {
            result = false;
        }
        return result;
    }

    /**
     * Este metod suma todos los salarios de todos los empleados de un deprtaento.
     * @param idDepartment
     * @return double Salarios de un departamento especifico
     */
    public double calculateDepartmentSalaries(UUID idDepartment){

        double DepartmentSalary = 0;
        for(Department d:this.departments){

            if (d.getId()==idDepartment){
                DepartmentSalary = d.calculateDepartmentSalaries();
            }
        }
        return DepartmentSalary;
    }
    /**
     * Este metodo calcula el salario de un empleado en especifico.
     * @param idEmployee
     * @return double salario de un empleado
     */
    public double calculateEmployeeSalary(UUID idEmployee){

        double EmploySalary = 0;
        for(Department d:this.departments){
            EmploySalary+=d.findSalaryEmployee(idEmployee);
        }
        return EmploySalary;
    }
    /**
     * Este metodo suma todos los salarios de todos los departamentos.
     * @return double Salario de toda la universidad
     */
    public double calculateUniversitySalaries(){

        double USalary = 0;
        for(Department d:this.departments){

            USalary += d.calculateDepartmentSalaries();
        }
        return USalary;
    }
    /**
     * Imprime la lista de todos los empeados en la nomina de la universidad.
     */
    public void printPayroll(){

        List<String> names = departments.stream().map(department -> department.printEmployees()).flatMap(List::stream).collect(Collectors.toList());
        for(int i=0;i< names.size();i++)
        {
            System.out.println("\t"+names.get(i));
        }

    }
    /**
     * Añade un departamento a la lista de departamentos de la universidad.
     * @param department
     */
    public void addDepartment(Department department)
    {
        departments.add(department);
    }

    /**
     * Deposita a un empleado en especifico.
     * @param idEmployee
     * @param amount
     * @return si la transacción.
     */
    public boolean depositToEmployee(UUID idEmployee,double amount)
    {
        BankAccount a = null;
        boolean isEmployee = false;
        boolean result = true;
        for (int i=0;i<this.departments.size() && !isEmployee; i++)
        {
            a = departments.get(i).findEmployeeAccount(idEmployee);
            if(a != null)
            {
                isEmployee = true;
            }

        }
        try {
            a.deposit(amount);
        }
        catch (BankAccountException e)
        {
            result=false;
        }
        return result;
    }
    public double calculateEmployeeBalance(UUID idEmployee)
    {
        BankAccount a = null;
        boolean isEmployee = false;

        for (int i=0;i<this.departments.size() && !isEmployee; i++)
        {
            a = departments.get(i).findEmployeeAccount(idEmployee);
            if(a != null)
            {
                isEmployee = true;
            }

        }
        return a.getBalance();
    }
    public double calculateAllEmployeeBalance()
    {
        double AllEmployeeBalance = 0;
        for (int i=0;i<this.departments.size(); i++)
        {
            AllEmployeeBalance += departments.get(i).findEmployeeBalance();
        }
        return AllEmployeeBalance;
    }


}
