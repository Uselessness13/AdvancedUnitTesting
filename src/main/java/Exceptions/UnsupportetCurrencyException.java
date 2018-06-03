package Exceptions;

public class UnsupportetCurrencyException extends Exception {
    private static String message = "Unsupported currency given";

    public UnsupportetCurrencyException() {
        super(message);
    }
}
