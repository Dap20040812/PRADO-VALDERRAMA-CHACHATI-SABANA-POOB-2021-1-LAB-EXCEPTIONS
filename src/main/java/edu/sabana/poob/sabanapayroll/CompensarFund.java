package edu.sabana.poob.sabanapayroll;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CompensarFund implements IFamilyCompensationFund{

    private static List<Employee> registeredEmployees = new ArrayList<>();

    /**
     * Registra un empleado po salario y por comision
     * @param employee
     * @return True si puede registrar al empleado - False si no
     */
    @Override
    public boolean registerEmployee(Employee employee) throws FamilyCompensationFundException{

        if(employee.getClass() == EmployeeByHours.class)
        {
            throw new FamilyCompensationFundException(FamilyCompensationFundException.EMPLOYEE_NOT_ALLOWED);
        }
        if(isEmployeeRegistered(employee.getId()))
        {
            throw new FamilyCompensationFundException(FamilyCompensationFundException.EMPLOYEE_REGISTERED);
        }
        registeredEmployees.add(employee);

        return true;
    }

    /**
     * Elimina un empleado con un id dado
     * @param id
     * @return True si puede eliminar el empleado - False si no
     */
    @Override
    public boolean deleteEmployee(UUID id) throws FamilyCompensationFundException {

        boolean isEmployee = false;

        for(int i=0;i< registeredEmployees.size() && !isEmployee;i++)
        {
            if(registeredEmployees.get(i).getId() == id)
            {
                registeredEmployees.remove(registeredEmployees.get(i));
                isEmployee = true;
            }
        }
        if(!isEmployee)
        {
            throw new FamilyCompensationFundException(FamilyCompensationFundException.EMPLOYEE_IS_NOT_REGISTERED);
        }
        return true;
    }

    /**
     * Verifica que un empleado de un id dado este registrado
     * @param id
     * @return True si el empleado esta registrado - False si no
     */
    @Override
    public boolean isEmployeeRegistered(UUID id) {

        boolean isEmployee = false;
        for(int i=0;i< registeredEmployees.size() && !isEmployee;i++)
        {
            if(registeredEmployees.get(i).getId() == id)
            {
                isEmployee = true;
            }
        }
        return isEmployee;
    }

    /**
     * Imprime los beneficios de la caja
     * @return los beneficios
     */
    @Override
    public String printBenefits() {

        return "\n"+("- Salud" + "- Sedes");
    }
}
