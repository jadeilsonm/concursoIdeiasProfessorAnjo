package br.edu.ifpe.concursoideiasprofessoranjo.Shared.Exception;

public class PasswordInvalidException extends RuntimeException{

    public PasswordInvalidException() {
        super("Password Invalid");
    }

}
