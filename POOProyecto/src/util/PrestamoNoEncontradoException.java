package util;

public class PrestamoNoEncontradoException extends Exception {
    private static final long serialVersionUID = 1L;

    public PrestamoNoEncontradoException(String idPrestamo) {
        super("Error: La orden de préstamo # '" + idPrestamo + "' no fue encontrada.");
    }
}