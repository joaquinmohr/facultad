public class Producto {
    private int codigo, precio;
    private String descripcion;

    public Producto(){

    }
    public Producto(int cod, int pre, String des){
        this.codigo = cod;
        this.precio = pre;
        this.descripcion = des;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    @Override
    public String toString(){
        return "Codigo: "+this.codigo+" | Descripcion: "+this.descripcion+" | Precio: "+this.precio;
    }
}
