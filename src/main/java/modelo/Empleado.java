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
public class Empleado  implements Serializable, Comparable<Empleado>{

    private String cedula;
    private String nombre;
    private String telefono;
    private String email;
    private boolean estado;
    

    public Empleado(String cedula, String nombre, String telefono, String email, boolean estado) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.estado = estado;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getEstado() {
        return estado?"Activo":"Inactivo";
    }
    
     @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.cedula);
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
        final Empleado other = (Empleado) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        return true;
    }
    
       @Override
    public int compareTo(Empleado e) {
        
        return cedula.compareToIgnoreCase(e.cedula);
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
    