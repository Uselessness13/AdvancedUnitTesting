package Exceptions;

public class NotEnoughMoneyException extends Exception{
    private static String message = "Insufficient funds in this currency";

    public NotEnoughMoneyException() {
        super(message);
    }
}
