/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Julio
 */
public class Atencion implements Serializable, Comparable<Atencion> {
    private Servicio servicio;
    private Cliente cliente;
    private Empleado empleado;
    private Cita cita;
    private int duracion;

    public Atencion(Servicio servicio, Cliente cliente, Empleado empleado, Cita cita, int duracion) {
        this.servicio = servicio;
        this.cliente = cliente;
        this.empleado = empleado;
        this.cita = cita;
        this.duracion = duracion;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Cita getCita() {
        return cita;
    }

    public int getDuracion() {
        return duracion;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.cita);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Atencion other = (Atencion) obj;
        if (!Objects.equals(this.cita, other.cita)) {
            return false;
        }
        return true;
    }
    
    @Override
    public int compareTo(Atencion a) {
        
        return cita.toString().compareToIgnoreCase(a.cita.toString());
    }
    
    
    
    public static ArrayList<Atencion> cargarAtenciones(String ruta) {
        ArrayList<Atencion> atenciones = new ArrayList<>();
        System.out.println("xxxxxxxxxxxxx");
       //leer la lista de empleados del archivo serializado
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(ruta))) {
            atenciones = (ArrayList<Atencion>) oi.readObject();
            System.out.println("=============");
            // System.out.println(empleados);
        } catch (FileNotFoundException ex) {
            System.out.println("archivo no existe");
        } catch (IOException   ex) {
            System.out.println("error io:"+ex.getMessage());
        } catch (ClassNotFoundException  ex) {
            System.out.println("error class:"+ex.getMessage());
        } 
        return atenciones;
    }
    
}
