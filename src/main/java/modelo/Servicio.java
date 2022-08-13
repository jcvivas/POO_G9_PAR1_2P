package modelo;

/**
 *
 * @author Julio
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author DELL
 */
public class Servicio implements Serializable, Comparable<Servicio>{
    private String nombre;
    private int duracion;
    private double precio;
    private boolean estado;

    public String getNombre() {
        return nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public double getPrecio() {
        return precio;
    }

    public String getEstado() {
        return estado?"Activo":"Inactivo";
    }
    

    
     @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.nombre);
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
        final Servicio other = (Servicio) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
    @Override
    public int compareTo(Servicio s) {
        
        return nombre.compareToIgnoreCase(s.nombre);
    }
    
    
    
    public static ArrayList<Servicio> cargarServicios(String ruta) {
        ArrayList<Servicio> servicios = new ArrayList<>();
        System.out.println("xxxxxxxxxxxxx");
       //leer la lista de empleados del archivo serializado
        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream(ruta))) {
            servicios = (ArrayList<Servicio>) oi.readObject();
            System.out.println("=============");
            // System.out.println(empleados);
        } catch (FileNotFoundException ex) {
            System.out.println("archivo no existe");
        } catch (IOException   ex) {
            System.out.println("error io:"+ex.getMessage());
        } catch (ClassNotFoundException  ex) {
            System.out.println("error class:"+ex.getMessage());
        } 
        return servicios;
    }
}