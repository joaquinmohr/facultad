import java.io.*;
import java.util.Hashtable;
import java.util.PriorityQueue;

public class Huffman {

    public Huffman() {

    }

    private Hashtable<Character, String> tablaHuffman;

    public int[] calcularFrecuencias(File file) throws IOException {
        int[] frecuencias = new int[257];
        try (InputStream entrada = new BufferedInputStream(new FileInputStream(file))) {
            while (true) {
                int ascii = entrada.read();
                if (ascii == -1) {      //Condicion de corte, fin de la lectura
                    break;
                }
                frecuencias[ascii]++;
            }
        }
        return frecuencias;
    }

    public NodoBinario construirArbol(int[] frecuencias) {

        PriorityQueue<NodoBinario> cola = new PriorityQueue<>();

        for (int i = 0; i < frecuencias.length; i++) {
            if (frecuencias[i] > 0) {
                cola.add(new NodoBinario(new Dato(i, frecuencias[i])));
            }
        }

        while (cola.size() > 1) {
            NodoBinario izq = cola.remove();
            NodoBinario der = cola.remove();
            Dato dato = new Dato();
            dato.setFrecuencia(izq.getDato().getFrecuencia() + der.getDato().getFrecuencia());
            cola.add(new NodoBinario(dato, izq, der));
        }
        return cola.remove();
    }

    public Hashtable<Character, String> crearTabla(NodoBinario nodo) {
        tablaHuffman = new Hashtable<>();
        cargarTabla(nodo, "");
        return tablaHuffman;
    }

    //Cargar recursivo
    private void cargarTabla(NodoBinario nodo, String bits) {

        if (nodo != null) {
            if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                tablaHuffman.put((char) nodo.getDato().getSimbolo(), bits);
            }
            //Por la izquierda y mientras haya nodos, añadimos un 0 (cero) a la representacion del codigo
            cargarTabla(nodo.getIzquierdo(), bits + "0");
            //Por la derecha y mientras haya nodos, añadimos un 1 (uno) a la representacion del codigo
            cargarTabla(nodo.getDerecho(), bits + "1");
        }
    }

    public String codificarMensaje(Hashtable<Character, String> tabla, String mensaje) {
        String mensajeCodificado = "";
        for (char c : mensaje.toCharArray()) {
            mensajeCodificado += tabla.get(c);
        }
        return mensajeCodificado;
    }

    public String decodificarMensaje(Hashtable<Character, String> tabla, String mensaje) {
        Hashtable<String, Character> tablaInvertida = new Hashtable<>();
        for (char key : tabla.keySet()) {
            tablaInvertida.put(tabla.get(key), key);
        }
        String mensajeDecodificado = "";
        String codigo = "";
        for (char c : mensaje.toCharArray()) {
            if (tablaInvertida.containsKey(codigo)) {
                mensajeDecodificado += tablaInvertida.get(codigo);
                codigo = String.valueOf(c);
            } else {
                codigo += String.valueOf(c);
            }
        }
        mensajeDecodificado += tablaInvertida.get(codigo);
        return mensajeDecodificado;
    }
}
