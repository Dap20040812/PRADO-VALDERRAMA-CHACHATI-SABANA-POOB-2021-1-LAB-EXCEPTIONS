package edu.sabana.poob.sabanapayroll;

import java.util.ArrayList;
import java.util.UUID;

public class Department {

    private String name;
    private UUID id;
    private ArrayList<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.id = UUID.randomUUID();
        this.employees = new ArrayList<>();
    }

    public String getName(){return name;}

    public UUID getId() {
        return id;
    }
    /**
     * Este metodo calcula la suma de los salarios de los empleados.
     * @return double el salario del departamento
     */
    public double calculateDepartmentSalaries() {

        double Totalsalary = 0;
        for(Employee e: this.employees){

            Totalsalary += e.calculateSalary();
        }

        return Totalsalary;
    }
    /**
     * Este metodo busca a un empleado especifico.
     * @param idEmployee
     * @return double el salario de un empleado
     */
    public double findSalaryEmployee(UUID idEmployee) {
        double EmployeeSalary=0;
        boolean isEmployee = false;

        for(int i=0;i<employees.size() && !isEmployee; i++ ) {
            if (employees.get(i).getId() == idEmployee) {
                EmployeeSalary = employees.get(i).calculateSalary();
                isEmployee = true;
            }
        }
        return EmployeeSalary;
    }
    /**
     * Este metodo guarda a los empleados de un departamento en un ArrayList.
     * @return ArrayList</String>
     */
    public ArrayList<String> printEmployees() {

        ArrayList<String> employees = new ArrayList<>();
        for (Employee e: this.employees)
        {
            employees.add(e.toString());
        }

        return employees;
    }
    /**
     * Este metodo agrega a un empleado a un departamento.
     * @param employee
     */
    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    /**
     * Este metodo encuentra la cuenta de un empleado espesifico
     * @param idEmployee
     * @return BankAccount del empleado
     */
    public BankAccount findEmployeeAccount(UUID idEmployee) {

        boolean isEmployee = false;
        BankAccount a = null;

        for(int i=0;i<employees.size() && !isEmployee; i++ ) {
            if (employees.get(i).getId() == idEmployee) {
                a=employees.get(i).getAccount();
                isEmployee = true;
            }
        }
        return a;
    }

    public double findEmployeeBalance() {

        double a = 0;

        for (Employee e: this.employees)
        {
            a += e.getAccount().getBalance();
        }
        return a;
    }
}
