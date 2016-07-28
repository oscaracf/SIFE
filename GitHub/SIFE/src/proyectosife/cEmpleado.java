
package proyectosife;

public class cEmpleado extends cPersona {
    String contrasenna;

    public cEmpleado(String contrasenna, String nombre, String apellido, String correoElectronico, String direccion, int idPersona, int telefono, int tipoPersona) {
        super(nombre, apellido, correoElectronico, direccion, idPersona, telefono, tipoPersona);
        this.contrasenna = contrasenna;
    }
    

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }
    
}
