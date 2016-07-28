
package proyectosife;

public class cFactura {
    int idFacura, catidadProducto, total;
    String Fecha;// el formato de la fecha sera xx/xx/xxxx;

    public cFactura(int idFacura, int catidadProducto, int total, String Fecha) {
        this.idFacura = idFacura;
        this.catidadProducto = catidadProducto;
        this.total = total;
        this.Fecha = Fecha;
    }

    public int getIdFacura() {
        return idFacura;
    }

    public void setIdFacura(int idFacura) {
        this.idFacura = idFacura;
    }

    public int getCatidadProducto() {
        return catidadProducto;
    }

    public void setCatidadProducto(int catidadProducto) {
        this.catidadProducto = catidadProducto;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    
}
