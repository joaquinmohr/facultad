public class Nodo<T> {
    private T valor;
    private Nodo<T> nodoSiguiente;  //Enlace

    public Nodo(){
        valor = null;
        nodoSiguiente = null;
    }
    public Nodo(T v, Nodo<T> s){
        setInfo(v);
        setNodoSiguiente(s);
    }
    public void setInfo(T valor){
        this.valor = valor;
    }
    public T getInfo(){
        return valor;
    }
    public void setNodoSiguiente(Nodo<T> nodoSiguiente){
        this.nodoSiguiente = nodoSiguiente;
    }
    public Nodo<T> getNodoSiguiente(){
        return nodoSiguiente;
    }
}