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
    public boolean registerEmployee(Employee employee) {

        boolean result = false;
        if(employee.getClass() != EmployeeByCommission.class)
        {
           if(!isEmployeeRegistered(employee.getId()))
           {
               registeredEmployees.put(employee.getId(),employee);
               result = true;
           }
        }
        return result;
    }
    /**
     * Elimina un empleado con un id dado
     * @param id
     * @return True si puede eliminar el empleado - False si no
     */
    @Override
    public boolean deleteEmployee(UUID id) {

        boolean result = false;

        if(isEmployeeRegistered(id))
        {
            registeredEmployees.remove(id);
            result = true;
        }
        return result;
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
