public class Pedido {
    private String nombre, apellido;
    private int codigo, ladrillos;

    public Pedido(){
        //Constructor por defecto
    }
    //Constructor con argumentos
    public Pedido(String name, String surname, int code, int bricks){
        nombre = name;
        apellido = surname;
        codigo = code;
        ladrillos = bricks;
    }
    //Metodo que devuelve nombre
    public String getNombre(){
        return nombre;
    }
    //Metodo que devuelve apellido
    public String getApellido(){
        return apellido;
    }
    //Metodo que devuelve codigo
    public int getCodigo(){
        return codigo;
    }
    //Metodo que devuelve ladrillos
    public int getLadrillos(){
        return ladrillos;
    }
    //Metodo que setea el nombre
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    //Metodo que setea el apellido
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    //Metodo que setea el codigo
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    //Metodo que setea los ladrillos
    public void setLadrillos(int ladrillos){
        this.ladrillos = ladrillos;
    }
    //Metodo que devuelve el pedido completo
    public String toString(){
        return "Cliente: "+this.nombre.toUpperCase() + " " + this.apellido.toUpperCase() + "\nCodigo numerico: " + this.codigo + "\nCantidad de ladrillos: " + this.ladrillos + "\n";
    }
}
