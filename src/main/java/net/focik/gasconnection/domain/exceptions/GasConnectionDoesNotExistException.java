package net.focik.gasconnection.domain.exceptions;

public class GasConnectionDoesNotExistException extends ObjectDoesNotExistException {
    public GasConnectionDoesNotExistException(Integer id) {
        super("GasConnection with id = " + id + " does not exist");
    }

}
