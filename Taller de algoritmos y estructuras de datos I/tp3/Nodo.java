public class Nodo {
    private Producto valor;
    private Nodo nodoAnterior, nodoSiguiente;

    //Constructor
    public Nodo() {

    }

    //Constructor con argumentos
    public Nodo(Producto valor, Nodo nodoAnterior, Nodo nodoSiguiente) {
        this.valor = valor;
        this.nodoAnterior = nodoAnterior;
        this.nodoSiguiente = nodoSiguiente;
    }

    //Setters
    public void setValor(Producto valor) {
        this.valor = valor;
    }

    public void setNodoAnterior(Nodo nodoAnterior) {
        this.nodoAnterior = nodoAnterior;
    }

    public void setNodoSiguiente(Nodo nodoSiguiente) {
        this.nodoSiguiente = nodoSiguiente;
    }

    //Getters
    public Producto getValor() {
        return valor;
    }

    public Nodo getNodoAnterior() {
        return nodoAnterior;
    }

    public Nodo getNodoSiguiente() {
        return nodoSiguiente;
    }
}
