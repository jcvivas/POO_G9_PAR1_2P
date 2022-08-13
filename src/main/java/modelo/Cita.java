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
import java.time.LocalTime;
import java.time.LocalDate;
/**
 *
 * @author DELL
 */
public class Cita implements Serializable, Comparable<Cita>{
    private Cliente cliente;
    private Empleado empleado;
    private Servicio servicio;
    private LocalTime hora;
    private LocalDate Fecha;

    public Cliente getCliente() {
        return cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public LocalTime getHora() {
        return hora;
    }

    public LocalDate getFecha() {
        return Fecha;
    }
    

    
     @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.hora);
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
        final Cita other = (Cita) obj;
        if (!Objects.equals(this.hora, other.hora)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cita{" + "cliente=" + cliente + ", empleado=" + empleado + ", servicio=" + servicio + ", hora=" + hora + ", Fecha=" + Fecha + '}';
    }
    
       @Override
    public int compareTo(Cita c) {
        
        return empleado.getCedula().compareToIgnoreCase(c.empleado.getCedula());
    }
    
    
    
    public static ArrayList<Empleado> cargarEmpleado(String ruta) {
        ArrayList<Empleado> empleados = new ArrayList<>();
        System.out.println("xxxxxxxxxxxxx");
       //leer la lista de empleados del archivo serializado
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(ruta))) {
            empleados = (ArrayList<Empleado>) oi.readObject();
            System.out.println("=============");
            // System.out.println(empleados);
        } catch (FileNotFoundException ex) {
            System.out.println("archivo no existe");
        } catch (IOException   ex) {
            System.out.println("error io:"+ex.getMessage());
        } catch (ClassNotFoundException  ex) {
            System.out.println("error class:"+ex.getMessage());
        } 
        return empleados;
    }
}
