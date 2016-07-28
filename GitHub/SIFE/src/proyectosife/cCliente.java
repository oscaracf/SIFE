
package proyectosife;
import javax.swing.table.DefaultTableModel;
public class cCliente extends cPersona {
    private int tipoCliente;
    
    public int getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(int tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    
    public cCliente(int tipoCliente, String nombre, String apellido, String correoElectronico, String direccion, int idPersona, int telefono, int tipoPersona) {
        super(nombre, apellido, correoElectronico, direccion, idPersona, telefono, tipoPersona);
        this.tipoCliente = tipoCliente;
    }

}
// hacer la tabla .....

