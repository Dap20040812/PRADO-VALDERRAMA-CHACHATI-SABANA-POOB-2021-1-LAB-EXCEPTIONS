package edu.sabana.poob.sabanapayroll;

import java.time.LocalDate;

public class Checking extends BankAccount {

    public final double DEPOSIT_DISCOUNT = 5000;

    @Override
    public double getDepositDiscount() {
        return DEPOSIT_DISCOUNT;
    }

    /**
     * Calcula el porcentaje de intereses y los deposita en la cuenta sin ningñun descuento.
     * <br><br>
     * @return el porcentaje depositado en la cuenta.
     */
    public boolean processCheck(Check check){
        boolean result = false;

        if(check.getAmount() > DEPOSIT_DISCOUNT && LocalDate.now().isBefore(check.getExpirationDate()))
        {
            deposit(check.getAmount());
            result = true;
        }
        return result;
    }
}
