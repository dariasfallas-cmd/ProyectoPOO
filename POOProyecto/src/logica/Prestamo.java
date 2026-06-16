package logica;

import java.io.Serializable;
import java.util.Date;

public class Prestamo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String idPrestamo;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private Persona solicitante;
    private Item itemPrestado;
    private Alerta alertaAsociada; 

    public Prestamo(String idPrestamo, Persona solicitante, Item itemPrestado, Date fechaDevolucion) {
        this.idPrestamo = idPrestamo;
        this.fechaPrestamo = new Date(); 
        this.fechaDevolucion = fechaDevolucion;
        this.solicitante = solicitante;
        this.itemPrestado = itemPrestado;
        this.alertaAsociada = null; 
    }

    public String getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Persona getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Persona solicitante) {
        this.solicitante = solicitante;
    }

    public Item getItemPrestado() {
        return itemPrestado;
    }

    public void setItemPrestado(Item itemPrestado) {
        this.itemPrestado = itemPrestado;
    }


    public Alerta getAlertaAsociada() { 
        return alertaAsociada; 
    }
    
    public void asociarAlerta(Alerta alerta) {
        this.alertaAsociada = alerta;
    }

    public void removerAlerta() {
        this.alertaAsociada = null;
    }
}