package logica;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;

    private List<Item> listaItems;
    public Categoria(String nombre) {
        this.nombre = nombre;
        this.listaItems = new ArrayList<>();
    }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public List<Item> getListaItems() { return listaItems; }

    public void agregarItem(Item item) {
        if (!listaItems.contains(item)) {
            listaItems.add(item);
        }
    }

    public void eliminarItem(Item item) {
        listaItems.remove(item);
    }
}