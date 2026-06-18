package util;

public class ItemNoencontradoException extends Exception {
    private static final long serialVersionUID = 1L;

    public ItemNoencontradoException(String codigo) {
        super("Error: El ítem con código '" + codigo + "' no existe en el sistema.");
    }
}