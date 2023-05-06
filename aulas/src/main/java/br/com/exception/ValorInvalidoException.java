package br.com.exception;

public class ValorInvalidoException extends RuntimeException{
    public ValorInvalidoException(String errorMessage){
        super(errorMessage);
    }
}
