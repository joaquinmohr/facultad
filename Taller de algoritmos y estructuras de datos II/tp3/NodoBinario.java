public class NodoBinario implements Comparable<Object> {

    private Dato dato;
    private NodoBinario izquierdo;
    private NodoBinario derecho;

    public NodoBinario(Dato dato){
        this.dato = dato;
    }

    public NodoBinario(Dato dato, NodoBinario izquierdo, NodoBinario derecho) {
        this.dato = dato;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    public Dato getDato() {
        return dato;
    }

    public NodoBinario getIzquierdo() {
        return izquierdo;
    }

    public NodoBinario getDerecho() {
        return derecho;
    }

    @Override
    public int compareTo(Object o){
        NodoBinario nuevoNodo = (NodoBinario) o;
        if (this.dato.getFrecuencia() > nuevoNodo.getDato().getFrecuencia()){
            return 1;
        } else if (this.dato.getFrecuencia() < nuevoNodo.getDato().getFrecuencia()) {
            return -1;
        } else if (this.dato.getSimbolo() > nuevoNodo.getDato().getSimbolo()) {
            return 1;
        } else if (this.dato.getSimbolo() < nuevoNodo.getDato().getSimbolo()) {
            return -1;
        }else {
            return 0;
        }
    }
}
