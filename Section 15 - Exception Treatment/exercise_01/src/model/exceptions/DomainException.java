package model.exceptions;

public class DomainException extends RuntimeException{
    //Exception obriga a tratar ou propagar as exceções, RuntimeException não
    public DomainException(String msg) {
        super(msg);
    }
}
