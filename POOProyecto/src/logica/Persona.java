package logica;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private String telefono;
    private String correo;

    private List<Prestamo> listaPrestamos; 
    public Persona(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.listaPrestamos = new ArrayList<>(); 
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public List<Prestamo> getListaPrestamos() {
        return listaPrestamos;
    }
    public void agregarPrestamo(Prestamo prestamo) {
        if (!listaPrestamos.contains(prestamo)) {
            listaPrestamos.add(prestamo);
        }
    }
    public void eliminarPrestamo(Prestamo prestamo) {
        if (this.listaPrestamos != null) {
            this.listaPrestamos.remove(prestamo);
        }
    }
 }