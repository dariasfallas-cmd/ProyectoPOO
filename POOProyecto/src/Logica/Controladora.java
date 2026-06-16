package Logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Controladora {
    private static Controladora instancia;
    private Controladora() {} 
    public static Controladora getInstancia() {
        if (instancia == null) {
            instancia = new Controladora();
        }
        return instancia;
    }
    
    public void registrarPersona(String nombre, String telefono, String correo) { /* ... */ }
    public void elimiarPersona(String correo) { /* ... */ } 
    public void modificarPersona(String correo, String nuevoNombre, String nuevoTelefono) { /* ... */ }
 
    
    public void agregarItem(String codigo, String nombre, String descripcion, String tipo, List<Categoria> categoria) { /* ... */ }
    public void eliminarItem(Item nuevoItem) { /* ... */ }

    public void registrarCategoria(String nuevaCategoria) { /* ... */ }
    public void eliminarCategoria(String nombre) { /* ... */ }

    public void registrarTipo(String nuevoTipo) { /* ... */ }
    public void elimibarTipo(Tipo descripcion) { /* ... */ } 

    public void registrarPrestamo(Personas persona, List<Item> items, Date fechaDevolucion) { /* ... */ }
    public void registrarDevolucionj(String idPrestamo) { /* ... */ } 
    public void verificarGenerarAlertas() { /* ... */ }
    
    public List<Prestamo> obetenerPrestamosAlerta() { return new ArrayList<>(); } 
    public List<Prestamo> getlistaPrestaoms() { return new ArrayList<>(); } 
}