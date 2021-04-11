package edu.sabana.poob.sabanapayroll;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ColsubsidioFund implements IFamilyCompensationFund {

    private static Map<UUID, Employee> registeredEmployees = new HashMap<>();

    public ColsubsidioFund() {

    }
    /**
     * Registra un empleado por salario y por horas
     * @param employee
     * @return True si puede registrar al empleado - False si no
     */
    @Override
    public boolean registerEmployee(Employee employee) throws FamilyCompensationFundException{

        if(employee.getClass() == EmployeeByCommission.class)
        {
            throw new FamilyCompensationFundException(FamilyCompensationFundException.EMPLOYEE_NOT_ALLOWED);
        }
        if(isEmployeeRegistered(employee.getId()))
        {
            throw new FamilyCompensationFundException(FamilyCompensationFundException.EMPLOYEE_REGISTERED);
        }
        registeredEmployees.put(employee.getId(),employee);
        return true;

    }
    /**
     * Elimina un empleado con un id dado
     * @param id
     * @return True si puede eliminar el empleado - False si no
     */
    @Override
    public boolean deleteEmployee(UUID id) throws FamilyCompensationFundException {

        if(!isEmployeeRegistered(id))
        {
            throw new FamilyCompensationFundException(FamilyCompensationFundException.EMPLOYEE_IS_NOT_REGISTERED);
        }
        registeredEmployees.remove(id);
        return true;
    }
    /**
     * Verifica que un empleado de un id dado este registrado
     * @param id
     * @return True si el empleado esta registrado - False si no
     */
    @Override
    public boolean isEmployeeRegistered(UUID id) {

        boolean result = false;
        if(registeredEmployees.containsKey(id))
        {
            result = true;
        }
        return result;
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
