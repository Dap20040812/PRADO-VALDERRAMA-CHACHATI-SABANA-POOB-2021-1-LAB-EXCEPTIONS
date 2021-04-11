package edu.sabana.poob.sabanapayroll;

import java.lang.reflect.Executable;

public class BankAccountException extends Exception {

    public static final String ILEGAL_VALUE = "No se puede depositar un valor menor al descuento del deposito";


    public BankAccountException(String message) {
        super(message);
    }

}
