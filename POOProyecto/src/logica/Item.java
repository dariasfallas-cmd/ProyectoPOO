package logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    private String codigo;
    private String nombre;
    private String descripcion;
    
    private Tipo tipo; 
    private List<Categoria> listaCategorias;
    private Prestamo prestamoActual; 

    public Item(String codigo, String nombre, String descripcion, Tipo tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.listaCategorias = new ArrayList<>();
        this.prestamoActual = null; 
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void asignarTipo(Tipo nuevoTipo) {
        this.tipo = nuevoTipo;
    }

    public void agregarCategoria(Categoria categoria) {
        if (!listaCategorias.contains(categoria)) {
            this.listaCategorias.add(categoria);
        }
    }

    public void eliminarCategoria(Categoria categoria) {
        this.listaCategorias.remove(categoria);
    }

    public List<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public Prestamo getPrestamoActual() { 
        return prestamoActual; 
    }
    
    public void setPrestamoActual(Prestamo prestamo) { 
        this.prestamoActual = prestamo; 
    }
}