package proyectosife;

public class cInventario extends cProducto {

    String descripcion;
    int cantidadExistente;

    public cInventario(int idProducto, double precio, String nombre, String descripcion, int cantidadExistente) {
        super(idProducto, precio, nombre);
        this.descripcion = descripcion;
        this.cantidadExistente = cantidadExistente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidadExistente() {
        return cantidadExistente;
    }

    public void setCantidadExistente(int cantidadExistente) {
        this.cantidadExistente = cantidadExistente;
    }

}
