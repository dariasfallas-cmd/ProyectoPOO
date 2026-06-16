package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controladora {
    private static Controladora instancia;
    private List<Persona> listaPersonas;
    private List<Item> listaItems;
    private List<Prestamo> listaPrestamos;
    private List<Categoria> listaCategorias;
    private List<Tipo> listaTipos;

    private Controladora() {
        this.listaPersonas = new ArrayList<>();
        this.listaItems = new ArrayList<>();
        this.listaPrestamos = new ArrayList<>();
        this.listaCategorias = new ArrayList<>();
        this.listaTipos = new ArrayList<>();
    } 

    public static Controladora getInstancia() {
        if (instancia == null) {
            instancia = new Controladora();
        }
        return instancia;
    }

    public Persona buscarPersonaPorCorreo(String correo) {
        for (Persona p : listaPersonas) {
            if (p.getCorreo().equalsIgnoreCase(correo)) {
                return p;
            }
        }
        return null;
    }

    public Item buscarItemPorCodigo(String codigo) {
        for (Item i : listaItems) {
            if (i.getCodigo().equalsIgnoreCase(codigo)) {
                return i;
            }
        }
        return null;
    }

    public Prestamo buscarPrestamoPorId(String id) {
        for (Prestamo p : listaPrestamos) {
            if (p.getIdPrestamo().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }

    public void registrarPersona(String nombre, String telefono, String correo) {
        if (buscarPersonaPorCorreo(correo) == null) {
            Persona nuevaPersona = new Persona(nombre, telefono, correo);
            listaPersonas.add(nuevaPersona);
        }
    }

    public void eliminarPersona(String correo) {
        Persona p = buscarPersonaPorCorreo(correo);
        if (p != null) {
            listaPersonas.remove(p);
        }
    }

    public void agregarItem(String codigo, String nombre, String descripcion, String descTipo) {
        Tipo elTipo = null;
        for (Tipo t : listaTipos) {
            if (t.getDescripcion().equalsIgnoreCase(descTipo)) {
                elTipo = t;
            }
        }
        
        if (elTipo == null) {
            elTipo = new Tipo(descTipo);
            listaTipos.add(elTipo);
        }
        
        Item nuevoItem = new Item(codigo, nombre, descripcion, elTipo);
        listaItems.add(nuevoItem);
    }

    public void eliminarItem(String codigo) {
        Item item = buscarItemPorCodigo(codigo);
        if (item != null) {
            listaItems.remove(item);
        }
    }

    public void registrarPrestamo(String idPrestamo, String correoPersona, String codigoItem, Date fechaDevolucion) {
        Persona persona = buscarPersonaPorCorreo(correoPersona);
        Item item = buscarItemPorCodigo(codigoItem);

        if (persona != null && item != null && item.getPrestamoActual() == null) {
            Prestamo nuevoPrestamo = new Prestamo(idPrestamo, persona, item, fechaDevolucion);
            
            listaPrestamos.add(nuevoPrestamo);
            persona.agregarPrestamo(nuevoPrestamo); 
            item.setPrestamoActual(nuevoPrestamo);   
        }
    }

    
    public void registrarDevolucion(String idPrestamo) {
        Prestamo prestamo = buscarPrestamoPorId(idPrestamo);
        if (prestamo != null) {
            prestamo.getSolicitante().eliminarPrestamo(prestamo);
            prestamo.getItemPrestado().setPrestamoActual(null);
            
            listaPrestamos.remove(prestamo); 
        }
    }

    public List<Persona> getListaPersonas() { return listaPersonas; }
    public List<Item> getListaItems() { return listaItems; }
    public List<Prestamo> getListaPrestamos() { return listaPrestamos; }
}