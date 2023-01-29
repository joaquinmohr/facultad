public class Cola<T> {
    
    private Nodo<T> primerNodo, ultimoNodo;     //Para saber donde esta el inicio y el fin
    private int tamano;
    public Cola(){
        primerNodo = null;
        ultimoNodo = null;
        tamano = 0;
    }
    //Metodo para encolar
    public void encolar(T valor){
        Nodo<T> nuevoNodo = new Nodo<>(valor, null);
        if (primerNodo == null){
            primerNodo = nuevoNodo;
            ultimoNodo = nuevoNodo;
        }else {
            ultimoNodo.setNodoSiguiente(nuevoNodo);
            ultimoNodo = nuevoNodo;
        }
        tamano++;
    }
    //Metodo para desencolar
    public Nodo<T> desencolar(){
        if(primerNodo == null){
            return null;
        }else{
            Nodo<T> retorno = primerNodo;               //Guardo en retorno el primerNodo que existe actualmente para retornarlo
            primerNodo = primerNodo.getNodoSiguiente();     //Actualizo primerNodo, ahora es el siguiente del que ya existe y guardamos en retorno
            tamano--;
            return retorno;
        }
    }
   //Metodo para saber si la cola esta vacia
    public boolean esVacia(){
        return (tamano == 0);
    }
	//Metodo para mostrar la cola (Suena raro si)
    public void imprimirCola() {
        if (!esVacia()) {
            Nodo<T> nodoTemporal = primerNodo;
            while (nodoTemporal != null) {
                System.out.println(nodoTemporal.getInfo() + "\n");
                nodoTemporal = nodoTemporal.getNodoSiguiente();
            }
        }
    }
}
