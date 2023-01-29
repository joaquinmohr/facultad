/*
Enunciado de la actividad
Se cuenta con un sistema de reconocimiento de patentes (matrículas) de vehículos, y se intenta diseñar un sistema que
al detectar pasar un vehículo, verifique si este ha pasado en los últimos 10 minutos por cualquier otro reconocedor de patentes de la red. 
Para ello se considera tener, en cada computadora que maneja esos sensores, un árbol autobalanceado para tener ordenadas en memoria las patentes de los últimos 10 minutos.
Como estudiante del grupo de investigación, tendras que desarrollar la clase árbol binario de búsqueda, para que luego las clases de árboles autobalanceados hereden de ella.
 */

//Clase de Arbol Binario de Busqueda ABB
class ABB {
    // Clase Nodo de un ABB
    class Nodo {
        int clave;
        Nodo hijoIzquierdo, hijoDerecho;

        public Nodo(int clave) {
            this.clave = clave;
            hijoIzquierdo = hijoDerecho = null;
        }
    }

    // Nodo raiz, dato referencial
    Nodo raiz;

    // Constructor de ABB que se inicializa como arbol vacío
    ABB() {
        raiz = null;
    }

    // Borrar un Nodo de un árbol ABB
    void borrarClave(int clave) {
        raiz = borrarRecursivo(raiz, clave);
    }

    // Borrado recursivo
    Nodo borrarRecursivo(Nodo raiz, int clave) {
        // Si el Arbol está vacio
        if (raiz == null) {
            return raiz;
        }
        // Recorrer el árbol
        if (clave < raiz.clave) { // Recorrer el sub árbol izquierdo
            raiz.hijoIzquierdo = borrarRecursivo(raiz.hijoIzquierdo, clave);
        } else if (clave > raiz.clave) { // Recorrer el sub árbol derecho
            raiz.hijoDerecho = borrarRecursivo(raiz.hijoDerecho, clave);
        } else {
            // El nodo contiene solo un hijo
            if (raiz.hijoIzquierdo == null) {
                return raiz.hijoDerecho;
            } else if (raiz.hijoDerecho == null) {
                return raiz.hijoIzquierdo;
            }
            // El Nodo tiene 2 hijos
            // Obtener el sucesor inorder (Valor mínimo del subarbol derecho)
            raiz.clave = valorMinimo(raiz.hijoDerecho);

            // Borrar el sucesor inorder
            raiz.hijoDerecho = borrarRecursivo(raiz.hijoDerecho, raiz.clave);
        }
        return raiz;
    }

    int valorMinimo(Nodo raiz) {
        // Codificar para devolver el Valor mínimo del subarbol derecho

        // Seteamos a menor con el valor de la raiz que nos llegue
        // Donde se va a usar el metodo es en borrarRecursivo
        // Y por argumento nos manda raiz.hijoDerecho,
        // asi que comienza por el subarbol derecho

        int menor = raiz.clave;

        Nodo aux = raiz; // Nodo auxiliar para ir recorriendo

        while (aux.hijoIzquierdo != null) { // Recorremos mientras exista un hijo izquierdo
            aux = aux.hijoIzquierdo; // Actualizamos al siguiente hijo
            menor = aux.clave; // Vamos actualizando con el ultimo valor
        }

        return menor; // Cuando salga del bucle tenemos el valor minimo
    }

    // Insertar Nodo en ABB
    void insertar(int clave) {
        raiz = insertarRecursivo(raiz, clave);
    }

    // Funcion recursiva de inserción
    Nodo insertarRecursivo(Nodo raiz, int clave) {
        // Codificar el método de inserción

        if (raiz == null) { // Si no existe ningun nodo o bien se cumple por la recursividad

            raiz = new Nodo(clave); // Seteamos a este como raiz con la clave que nos llega por ser el primero
            // o bien por la recursividad encontramos donde insertar el nodo que nos llega

        } else if (clave < raiz.clave) { // Sino, si la clave que nos llega es menor que la clave de la raiz
            // Nos vamos por la rama izquierda
            raiz.hijoIzquierdo = insertarRecursivo(raiz.hijoIzquierdo, clave);

        } else if (clave > raiz.clave) { // Sino, si la clave que nos llega es mayor que la clave de la raiz
            // Nos vamos por la rama derecha
            raiz.hijoDerecho = insertarRecursivo(raiz.hijoDerecho, clave);

        }

        return raiz;

    }

    // Método de recorrido inroder para ABB
    void inOrden() {
        inOrdenRecursivo(raiz);
    }

    // recorrido inorder recursivo ABB
    void inOrdenRecursivo(Nodo raiz) {
        if (raiz != null) {
            inOrdenRecursivo(raiz.hijoIzquierdo);
            System.out.print(raiz.clave + " ");
            inOrdenRecursivo(raiz.hijoDerecho);
        }
    }

    boolean buscar(int clave) {
        Nodo aux = raiz;
        aux = buscarRecursivo(aux, clave);
        if (aux != null)
            return true;
        else
            return false;
    }

    // busqueda recursiva
    Nodo buscarRecursivo(Nodo raiz, int clave) {
        // Caso Base raiz es null o la clave esta presente como raiz
        if (raiz == null || raiz.clave == clave)
            return raiz;
        // val is greater than raiz's clave
        if (raiz.clave > clave)
            return buscarRecursivo(raiz.hijoIzquierdo, clave);
        // val is less than raiz's clave
        return buscarRecursivo(raiz.hijoDerecho, clave);
    }

    public static void main(String[] args) {
        // Crear el objeto ABB
        ABB abb = new ABB();

        abb.insertar(45);
        abb.insertar(10);
        abb.insertar(7);
        abb.insertar(12);
        abb.insertar(90);
        abb.insertar(50);

        // Mostrar el arbol ABB
        System.out.println("El arbol ABB ha sido creado (izquierda-raiz-derecha):");
        abb.inOrden();
        // Borrar nodo hoja
        System.out.println("\nEl arbol ABB despues de borrar 12(Nodo hoja):");
        abb.borrarClave(12);
        abb.inOrden();
        // Borrar el nodo con un solo hijo
        System.out.println("\nEl arbol ABB despues de borrar 90 (Nodo con 1 hijo):");
        abb.borrarClave(90);
        abb.inOrden();
        // Borrar nodo con 2 hijos
        System.out.println("\nEl arbol ABB despues de borrar 45 (Nodo con 2 hijos):");
        abb.borrarClave(45);
        abb.inOrden();
        // Buscar clave en el ABB
        boolean ret_val = abb.buscar(50);
        System.out.println("\nClave 50 en el ABB: " + (ret_val ? "Existe" : "No existe"));
        ret_val = abb.buscar(12);
        System.out.println("Clave 12 en el ABB: " + (ret_val ? "Existe" : "No existe"));
    }
}