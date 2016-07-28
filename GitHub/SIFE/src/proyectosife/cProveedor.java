package proyectosife;

public class cProveedor extends cPersona {

    int idJuridica;
    String nombreCompañia;

    public cProveedor(int idJuridica, String nombreCompañia, String nombre, String apellido, String correoElectronico, String direccion, int idPersona, int telefono, int tipoPersona) {
        super(nombre, apellido, correoElectronico, direccion, idPersona, telefono, tipoPersona);
        this.idJuridica = idJuridica;
        this.nombreCompañia = nombreCompañia;
    }

   

    public int getIdJuridica() {
        return idJuridica;
    }

    public void setIdJuridica(int idJuridica) {
        this.idJuridica = idJuridica;
    }

    public String getNombreCompañia() {
        return nombreCompañia;
    }

    public void setNombreCompañia(String nombreCompañia) {
        this.nombreCompañia = nombreCompañia;
    }

}
