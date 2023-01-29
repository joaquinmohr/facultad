public class Pila {

    private int[] arrPila;
    private int tope;
    private int tamano;

    //Constructor sin argumentos
    public Pila(){
        tope = 0;
        tamano = 5;
        arrPila = new int[tamano];
    }
    //Constructor con argumentos
    public Pila(int datoDelTamano){
        tope = 0;
        tamano = datoDelTamano;
        arrPila = new int[tamano];
    }
    public boolean esVacia(){
        boolean pregunta = tope == 0 ?  true : false;
        return pregunta;
    }
    public boolean esLlena(){
        boolean pregunta = tope == tamano ? true : false;
        return pregunta;
    }
    public boolean apilarDato(int dato){
        boolean pregunta;
        if(!esLlena()){
            arrPila[tope] = dato;
            tope++;
            System.out.println("\n\tSe apilo el elemento "+dato+" en la pila\n");
            pregunta = true;
        }else {
            pregunta = false;
        }
        return pregunta;
    }
    public int desapilarDato(){
        int dato = -1;
        if(!esVacia()){
            tope--;
            dato = arrPila[tope];
        }else{
            System.out.println("\n\tLa pila esta vacia, no hay nada que desapilar\n");
        }
        return dato;
    }
    public int tamanoPila(){
        return tope;
    }

}
