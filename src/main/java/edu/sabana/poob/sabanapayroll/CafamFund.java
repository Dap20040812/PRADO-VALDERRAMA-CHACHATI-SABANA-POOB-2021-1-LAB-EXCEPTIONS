package edu.sabana.poob.sabanapayroll;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

public class CafamFund implements IFamilyCompensationFund {

    private static Set<Employee> registeredEmployees = new HashSet<>();
    /**
     * Registra un empleado
     * @param employee
     * @return True si puede registrar al empleado - False si no
     */
    @Override
    public boolean registerEmployee(Employee employee) {

        return registeredEmployees.add(employee);
    }
    /**
     * Elimina un empleado con un id dado
     * @param id
     * @return True si puede eliminar el empleado - False si no
     */
    @Override
    public boolean deleteEmployee(UUID id) {

        boolean result = false;
        Iterator<Employee> it = registeredEmployees.iterator();

        while (!result && it.hasNext()) {
            Employee employee1 = it.next();
            if (employee1.getId() == id) {
                registeredEmployees.remove(employee1);
                result = true;
            }
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
        Iterator<Employee> it = registeredEmployees.iterator();

        while (!result && it.hasNext()) {
            Employee employee1 = it.next();
            if (employee1.getId() == id) {
                result = true;
            }
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
