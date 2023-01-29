/*
Enunciado de la actividad
Durante la implementación de un sistema embebido con una máquina JVM
se codifica como base el manejo de árboles binarios para que luego se pueda heredar de esta y codificar los árboles ABB.
*/

//Definición de la clase NodoBinario
class NodoBinario {
    int dato;
    NodoBinario hIzq, hDer;

    // Constructor
    NodoBinario(int elem) {
        // Dato a almacenar
        dato = elem;
        // Definición de hijos
        NodoBinario Hizq = null;
        NodoBinario Hder = null;
    }
}

// Definición de la clase Arbol
class Arbol {
    NodoBinario Padre;
    public NodoBinario raiz;

    // Constructor
    public Arbol() {
        raiz = null;
    }

    // Se codificaron 2 métodos y en caso de que el nodo padre de referencia sea
    // nulo se asume que es la raíz
    // Inserción de un hijo izquierdo
    public NodoBinario insertaNodoHIzq(NodoBinario nodo, int elem) {
        NodoBinario result = null;
        if (nodo == null) {
            NodoBinario NodoAux = new NodoBinario(elem);
            result = NodoAux;
            raiz = NodoAux;
        } else {
            if (nodo.hIzq == null) {
                NodoBinario NodoAux = new NodoBinario(elem);
                nodo.hIzq = NodoAux;
                result = NodoAux;
            } else
                System.out.print("ERR- Hijo izquierdo de " + elem + " no es nulo");
        }
        return result;
    }

    // Inserción de un hijo derecho
    public NodoBinario insertaNodoHDer(NodoBinario nodo, int elem) {
        NodoBinario result = null;
        if (nodo == null) {
            NodoBinario NodoAux = new NodoBinario(elem);
            result = NodoAux;
            raiz = NodoAux;
        } else {
            if (nodo.hDer == null) {
                NodoBinario NodoAux = new NodoBinario(elem);
                nodo.hDer = NodoAux;
                result = NodoAux;
            } else {
                System.out.print("ERR- Hijo Derecho de " + elem + " no es nulo");
            }
        }
        return result;
    }

    // Inorden Recursivo del arbol
    public void inOrden(NodoBinario nodo) {
        if (nodo != null) {
            inOrden(nodo.hIzq);
            System.out.println(nodo.dato);
            inOrden(nodo.hDer);
        }
    }

    // Altura del arbol
    public int getAltura(NodoBinario nodo) {
        int altura = 0;
        if (nodo != null) {
            if (nodo.hIzq != null) {
                altura = Math.max(altura, getAltura(nodo.hIzq));
            }
            if (nodo.hDer != null) {
                altura = Math.max(altura, getAltura(nodo.hDer));
            }
            altura++;
        }
        return altura;
    }
}

class ArbolBinario {
    public static void main(String[] args) {
        Arbol objArbol = new Arbol();
        System.out.print("Agregando la raiz 30 \n");
        NodoBinario NodoAux = null, NodoAux2 = null, NodoAux3 = null, NodoAux4 = null;
        NodoAux2 = objArbol.insertaNodoHIzq(NodoAux, 30);
        NodoAux = NodoAux2;
        NodoAux2 = objArbol.insertaNodoHIzq(NodoAux, 25);
        NodoAux3 = objArbol.insertaNodoHDer(NodoAux, 45);
        NodoAux = NodoAux2;
        NodoAux2 = objArbol.insertaNodoHIzq(NodoAux, 20);
        NodoAux4 = objArbol.insertaNodoHDer(NodoAux, 27);
        System.out.print("\n El arbol binario en In orden es: \n");
        objArbol.inOrden(objArbol.raiz);
        int altura = objArbol.getAltura(objArbol.raiz);
        System.out.print("\n La altura del arbol es: " + altura + "\n");
    }
}
