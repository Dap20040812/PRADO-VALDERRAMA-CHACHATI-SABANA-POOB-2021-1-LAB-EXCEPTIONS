package edu.sabana.poob.sabanapayroll;

/**
 * Represents a Employee. <br><br>
 * Invariants:
 * 1. VALOR_HORA = 3.5
 * 2. horas_trabajadas <=0 . <br><br>
 *
 */

public class EmployeeByHours extends Employee {

    public final static double VALOR_HORA = 60000;
    private double horas_trabajadas;

    public EmployeeByHours(String name, String lastname, Department department, double horas_trabajadas,String tipodeCuenta) {
        super(name, lastname, department, tipodeCuenta);
        this.horas_trabajadas = horas_trabajadas;
    }
    /**
     * Este metodo soreescribe el metodo calculateSalary y agrega el de empleado por hora.
     * @return double Salario del empleado
     */
    @Override
    public double calculateSalary(){
        return this.horas_trabajadas*EmployeeByHours.VALOR_HORA;
    }
    /**
     * Este metodo imprime al empleado por horas y sus caracteristicas.
     * @return String caracteristicas de un empleado
     */
    @Override
    public String toString() {return super.toString()+" payment by hours";}
}
