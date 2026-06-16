package util;

public class ItemNoEncontradoException extends Exception {
    private static final long serialVersionUID = 1L;

    public ItemNoEncontradoException(String codigo) {
        super("Error: El ítem con código '" + codigo + "' no existe en el sistema.");
    }
}