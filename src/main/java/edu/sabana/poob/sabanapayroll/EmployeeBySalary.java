package edu.sabana.poob.sabanapayroll;
/**
 * Represents a Employee. <br><br>
 * Invariants:
 * 1. HEALTH_DISCOUNT = 0.04
 * 2. SOCIAL_EQUITY_DISCOUNT = 0.04.
 * 3. salary>0 <br><br>
 *
 */

public class EmployeeBySalary extends Employee {

    private static final double HEALTH_DISCOUNT = 0.04;
    private static final double SOCIAL_EQUITY_DISCOUNT = 0.04;
    private double salary;

    public EmployeeBySalary(String name, String lastname, Department department, double salary, String tipodeCuenta){
        super(name, lastname, department,tipodeCuenta);
        this.salary = salary;
    }
    /**
     * Este metodo soreescribe el metodo calculateSalary y agrega el de empleado por salario.
     * @return double Salario del empleado
     */
    @Override
    public double calculateSalary(){
        return this.salary*(1-(EmployeeBySalary.HEALTH_DISCOUNT+EmployeeBySalary.SOCIAL_EQUITY_DISCOUNT));
    }
    /**
     * Este metodo soreescribe el metodo calculateSalary y agrega el de empleado por salario.
     * @return double Salario del empleado
     */
    @Override

    public String toString() {return super.toString()+" payment by salary";}
}

