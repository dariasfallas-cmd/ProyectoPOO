package util;

public class PersonanNoEncontradaException extends Exception {
    private static final long serialVersionUID = 1L;

    public PersonanNoEncontradaException(String correo) {
        super("Error: No se encontró ninguna persona con el correo: " + correo);
    }
}