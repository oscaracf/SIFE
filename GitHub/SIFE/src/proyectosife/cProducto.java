
package proyectosife;

public class cProducto {
    int idProducto;
    double precio;
    String nombre;

    public cProducto(int idProducto, double precio, String nombre) {
        this.idProducto = idProducto;
        this.precio = precio;
        this.nombre = nombre;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
