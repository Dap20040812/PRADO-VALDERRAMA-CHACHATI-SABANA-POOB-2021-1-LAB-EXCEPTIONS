package edu.sabana.poob.sabanapayroll;

/**
 * Represents a Employee. <br><br>
 * Invariants:
 * 1. VALOR_COMISION = 3.5
 * 2. productos_vendidos <=0 . <br><br>
 *
 */

public class EmployeeByCommission extends Employee {

    private static final double VALOR_COMISION = 8000;
    private double productos_vendidos;

    public EmployeeByCommission(String name, String lastname, Department department, double productos_vendidos, String tipodeCuenta) {
        super(name,lastname,department,tipodeCuenta);
        this.productos_vendidos = productos_vendidos;
    }

    /**
     * Este metodo soreescribe el metodo calculateSalary y agrega el de empleado por comision.
     * @return double Salario del empleado
     */

    @Override
    public double calculateSalary(){
        return this.productos_vendidos*EmployeeByCommission.VALOR_COMISION;
    }
    /**
     * Este metodo soreescribe el metodo calculateSalary y agrega el de empleado por comision.
     * @return double Salario del empleado
     */
    @Override
    public String toString() {return super.toString()+" payment by commission";}
}

