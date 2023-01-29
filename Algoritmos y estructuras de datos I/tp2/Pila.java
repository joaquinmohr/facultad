/*
Situación problemática
Durante la implementación de un sistema embebido con una máquina JVM, 
se necesita codificar una clase para manejar los estados en forma LIFO.
*/

public class Pila {

	class Nodo {
		int info;
		Nodo sig;
	}

	private Nodo raiz;

	public Pila() {
		raiz = null;
	}

	public void apilar(int x) {
		Nodo nuevo = new Nodo();
		nuevo.info = x;
		if (raiz == null) {
			nuevo.sig = null;
			raiz = nuevo;
		} else {
			nuevo.sig = raiz;
			raiz = nuevo;
		}
	}

	public int desapilar() {
		if (raiz != null) {
			int aux = raiz.info;
			raiz = raiz.sig;
			return aux;
		} else {
			return Integer.MAX_VALUE;
		}
	}

	public void verContenido() {
		Nodo reco = raiz;
		System.out.println("Listado de todos los elementos de la pila.");
		while (reco != null) {
			System.out.print(reco.info + "\n");
			reco = reco.sig;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Pila pila1 = new Pila();
		pila1.apilar(10);
		pila1.apilar(40);
		pila1.apilar(25);
		pila1.verContenido();
		System.out.println("Cima de la pila: " + pila1.desapilar());
		pila1.verContenido();
		pila1.apilar(13);
		pila1.apilar(53);
		pila1.verContenido();
		System.out.println("Cima de la pila: " + pila1.desapilar());
		pila1.verContenido();
	}
}
