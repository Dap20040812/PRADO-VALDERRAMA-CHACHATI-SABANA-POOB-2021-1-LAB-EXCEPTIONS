package edu.sabana.poob.sabanapayroll;

public class Savings extends BankAccount {

    public final double DEPOSIT_DISCOUNT = 2000;
    public final double ANNUAL_INTEREST_RATE = 0.01;


    @Override
    public double getDepositDiscount() {
        return DEPOSIT_DISCOUNT;
    }

    /**
     * Calcula el porcentaje de intereses y los deposita en la cuenta sin ningñun descuento.
     * <br><br>
     * @return el porcentaje depositado en la cuenta.
     */
    public double depositMontlyInterest(){

        deposit(getBalance()*ANNUAL_INTEREST_RATE/12 + DEPOSIT_DISCOUNT);
        return getBalance()*ANNUAL_INTEREST_RATE/12;

    }

}
