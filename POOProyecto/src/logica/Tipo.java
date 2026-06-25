package logica;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Tipo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String descripcion;
    private List<Item> listaItems;
    public Tipo(String descripcion) {
        this.descripcion = descripcion;
        this.listaItems = new ArrayList<>();
    }

    public String getDescripcion() { 
        return descripcion; 
    }

    public void setDescripcion(String descripcion) { 
        this.descripcion = descripcion; 
    }
    public List<Item> getListaItems() { 
        return listaItems; 
    }

    public void agregarItem(Item item) {
        if (!listaItems.contains(item)) {
            listaItems.add(item);
        }
    }

    public void eliminarItem(Item item) {
        listaItems.remove(item);
    }
}