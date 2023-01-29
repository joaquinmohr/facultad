/*
Situacion problematica
En un proyecto de portal de ecommerce se pide habilitar el registro de las operaciones de compras de productos y servicios por cada sesión iniciada. El portal tiene la opción ya habilitada y genera un archivo (tipo log o de texto) con un detalle de todo lo realizado por el usuario en esa sesión.
Dichos archivos no son muy grandes, pero debido al volumen de usuarios y masividad, se están generando muchos archivos, más de lo esperado.
Como acción de mitigación se pide desarrollar un módulo que comprima esos archivos de texto y solo se guardaran los archivos de los últimos 90 días.
El equipo de desarrollo dividirá el proyecto en 2 iteraciones, la creación de la compresión y luego las herramientas de descompresión.
Se necesita del alumno que desarrolle la creacion de la compresión
*/

import java.io.*;

public class Huffman {
    // Sub clases
    static class ArbolHuffman {
        //Clase Nodo de arbol de huffman
        static class NodoArbol {
            char clave;
            int frecuencia;
            boolean esDato;
            NodoArbol izquierda, derecha;

            public NodoArbol(char clave, int frecuencia, boolean esDato) {
                this.clave = clave;
                this.frecuencia = frecuencia;
                this.esDato = esDato;
                izquierda = derecha = null;
            }
        }

        //Clase Nodo de una lista (lista de árboles)
        static class NodoLista {
            public NodoArbol raiz;
            public NodoLista siguiente;

            public NodoLista(NodoArbol raiz) {
                this.raiz = raiz;
                siguiente = null;
            }
        }

        //Nodo inicial de la lista, dato referencial
        NodoLista nodoInicial;
        //Tabla de Huffman para caracteres ASCCI
        int tablaHuffman[];
        //Tabla de Huffman para las frecuencias
        String tablaHuffmanCodigos[];
        int tamanoTabla = 0;

        int byteToUnsignedByte(byte dato) {
            int resultado = dato;
            if (dato < 0) {
                resultado = (int) dato + 256;
            }
            return resultado;
        }

        //Creamos la tabla de Huffman en el arreglo (tabla de frecuencias)
        void cargarTablaDeArchivo(String nombreArchivo) {
            nodoInicial = null;
            tablaHuffman = new int[256];
            tablaHuffmanCodigos = new String[256];
            for (int i = 0; i <= 255; i++) {
                tablaHuffman[i] = 0;
                tablaHuffmanCodigos[i] = "";
            }
            System.out.println("Cargar archivo: " + nombreArchivo);
            try {
                RandomAccessFile file = new RandomAccessFile(nombreArchivo, "r");
                byte dato;
                int entero;
                long cont = 0;
                long tamano = file.length();
                System.out.print("Tamano: " + tamano + "\n");
                while (cont < tamano) {
                    file.seek(cont);
                    dato = file.readByte();
                    entero = byteToUnsignedByte(dato);
                    tablaHuffman[entero]++;
                    cont++;
                }
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int i = 0; i <= 255; i++) {
                if (tablaHuffman[i] > 0) {
                    tamanoTabla++;
                }
            }
            System.out.print("Tamano de la tabla: " + tamanoTabla + "\n");
        }

        //Crear Lista de arboles
        void insertarNodoLista(NodoLista nodoAInsertar) {
            NodoLista auxPosNodo, auxPosNodoAnt, auxNodo;
            //Insertar el nodo en la lista
            if (nodoInicial == null) {
                nodoInicial = nodoAInsertar;
            } else {
                auxPosNodo = nodoInicial;
                auxPosNodoAnt = null;
                while ((nodoAInsertar.raiz.frecuencia >= auxPosNodo.raiz.frecuencia) &
                        (auxPosNodo.siguiente != null)) {
                    auxPosNodoAnt = auxPosNodo;
                    auxPosNodo = auxPosNodo.siguiente;
                }
                if (auxPosNodoAnt == null) {
                    if (nodoAInsertar.raiz.frecuencia >= auxPosNodo.raiz.frecuencia) {
                        auxPosNodo.siguiente = nodoAInsertar;
                        //nodoAInsertar.siguiente=null;
                    } else {
                        nodoAInsertar.siguiente = nodoInicial;
                        nodoInicial = nodoAInsertar;
                    }
                } else {
                    //auxPosNodoAnt.siguiente=nodoAInsertar;
                    if (nodoAInsertar.raiz.frecuencia >= auxPosNodo.raiz.frecuencia) {
                        auxNodo = auxPosNodo.siguiente;
                        auxPosNodo.siguiente = nodoAInsertar;
                        nodoAInsertar.siguiente = auxNodo;
                    } else {
                        auxPosNodoAnt.siguiente = nodoAInsertar;
                        nodoAInsertar.siguiente = auxPosNodo;
                    }
                }
            }
        }

        void mostrarListaDeArboles() {
            NodoLista auxNodo = nodoInicial;
            int count = 0;
            System.out.print("Lista de arboles: ");
            while (auxNodo != null) {
                count++;
                System.out.print(count);
                System.out.print("'" + auxNodo.raiz.clave + "'");
                System.out.print("(");
                System.out.print(auxNodo.raiz.frecuencia);
                System.out.print("), ");
                auxNodo = auxNodo.siguiente;
            }
            System.out.println(" ");
        }

        void crearListaDeArboles() {
            int entero;
            int pos = 0;
            char caracter;
            NodoLista auxUltimoNodo = nodoInicial, auxPosNodo, auxPosNodoAnt;
            System.out.println("Tabla:");
            for (int i = 0; i <= 255; i++) {
                if (tablaHuffman[i] > 0) {
                    pos++;
                    caracter = (char) i;
                    //Crear un nodo raiz de arbol que contiene DATOS (flag en true)
                    NodoArbol AUXNA = new NodoArbol((char) i, tablaHuffman[i], true);
                    NodoLista AUXNL = new NodoLista(AUXNA);
                    NodoLista AUXRECORIDONL;
                    //Contenido de la tabla
                    System.out.print("Nodo ");
                    System.out.print(pos);
                    System.out.print(" " + (char) i + "(");
                    System.out.print(tablaHuffman[i]);
                    System.out.print("); ");
                    insertarNodoLista(AUXNL);
                }
            }
            System.out.println(" ");
            mostrarListaDeArboles();
        }

        // Proceso para reducir la lista a un solo nodo con un solo árbol
        void procesarListaDeArboles() {
            if (nodoInicial != null) {
                NodoLista AUXRECORIDONL, AUXNL1, AUXNL2, AUXNODOANT = null;
                NodoArbol AUXNAR1, AUXNAR2;
                AUXRECORIDONL = nodoInicial;
                //Verificar que exista la lista
                if (AUXRECORIDONL != null) {
                    //Mientras la lista tenga más de 2 nodos, procesar.
                    while (AUXRECORIDONL.siguiente != null) {
                        //Buscar los 2 primeros nodos
                        AUXNL1 = AUXRECORIDONL;
                        AUXNL2 = AUXRECORIDONL.siguiente;
                        //Asignar los árboles de cada nodo
                        AUXNAR1 = AUXNL1.raiz;
                        AUXNAR2 = AUXNL2.raiz;
                        //Eliminar ambos nodos de la lista
                        nodoInicial = AUXNL2.siguiente;
                        //Crear un nuevo nodo raíz que tenga los 2 subárboles que NO contiene DATOS(flag en false)con la sumatoria de frecuencias
                        NodoArbol AUXNA = new NodoArbol('*', AUXNL1.raiz.frecuencia + AUXNL2.raiz.frecuencia, false);
                        AUXNA.izquierda = AUXNL1.raiz;
                        AUXNA.derecha = AUXNL2.raiz;
                        //Creamos un nuevo nodo de lista para insertar en reemplazo de los 2 eliminados
                        NodoLista AUXNL = new NodoLista(AUXNA);
                        //Insertar nodo nuevo a la lista en forma ordenada
                        insertarNodoLista(AUXNL);
                        AUXRECORIDONL = nodoInicial;
                    }
                }
            }
        }

        void generarCodigosDeHuffman_recursivo(NodoArbol auxNodoRaiz, String codigo) {
            //De la siguiente manera identificamos el nodo
            if (auxNodoRaiz.izquierda == null && auxNodoRaiz.derecha == null && auxNodoRaiz.clave != 0){

                tablaHuffmanCodigos[auxNodoRaiz.clave] =  codigo;

                return;

            }

            //Cada vez que nos vamos por la izquierda añadimos un cero a la representacion del codigo
            generarCodigosDeHuffman_recursivo(auxNodoRaiz.izquierda, codigo + "0");
            //Cada vez que nos vamos por la derecha añadimos un uno a la representacion del codigo
            generarCodigosDeHuffman_recursivo(auxNodoRaiz.derecha, codigo + "1");

        }

        byte stringBytetoByte(String strToByte) {
            byte byteResult = 0;
            int intResult = 0;
            if (strToByte.length() > 0)
                if (Integer.parseInt(strToByte.substring(0, 1)) > 0)
                    intResult = intResult + 128;
            if (strToByte.length() > 1)
                if (Integer.parseInt(strToByte.substring(1, 2)) > 0)
                    intResult = intResult + 64;
            if (strToByte.length() > 2)
                if (Integer.parseInt(strToByte.substring(2, 3)) > 0)
                    intResult = intResult + 32;
            if (strToByte.length() > 3)
                if (Integer.parseInt(strToByte.substring(3, 4)) > 0)
                    intResult = intResult + 16;
            if (strToByte.length() > 4)
                if (Integer.parseInt(strToByte.substring(4, 5)) > 0)
                    intResult = intResult + 8;
            if (strToByte.length() > 5)
                if (Integer.parseInt(strToByte.substring(5, 6)) > 0)
                    intResult = intResult + 4;
            if (strToByte.length() > 6)
                if (Integer.parseInt(strToByte.substring(6, 7)) > 0)
                    intResult = intResult + 2;
            if (strToByte.length() > 7)
                if (Integer.parseInt(strToByte.substring(7, 8)) > 0)
                    intResult = intResult + 1;
            byteResult = (byte) intResult;
            return byteResult;
        }

        String procesarBuffer(String strBuff, RandomAccessFile archivo) throws IOException {

            String auxStr = strBuff, stringByte = "";

            while (auxStr.length() >= 8) {
                stringByte = auxStr.substring(0, 8);
                auxStr = auxStr.substring(8, auxStr.length());
                archivo.writeByte(stringBytetoByte(stringByte));
            }

            return auxStr;

        }

        void generarArchivoComprimido(String nombreArchivoO, String nombreArchivoD) {
            //Grabamos el archivo a comprimir
            String strBuffer = "";
            String strBufferTmp = "";
            //Borrar si existe el archivo
            File arch = new File(nombreArchivoD);
            if (arch.delete()) System.out.println("archivo borrado");
            try {
                //Abriendo el archivo original de solo lectura
                RandomAccessFile archivoOrigen = new RandomAccessFile(nombreArchivoO, "r");
                //Abriendo el archivo destino como lectura escritura
                RandomAccessFile archivoDestino = new RandomAccessFile(nombreArchivoD, "rw");
                int entero;
                byte dato;
                long cont = 0;
                long tamano = archivoOrigen.length();
                //System.out.println(strBuffer);
                while (cont < tamano) {
                    archivoOrigen.seek(cont);
                    dato = archivoOrigen.readByte();
                    entero = byteToUnsignedByte(dato);
                    //Codificar en buffer de string
                    //System.out.println(entero);
                    strBuffer = strBuffer + tablaHuffmanCodigos[entero];
                    strBufferTmp = strBufferTmp + " " + tablaHuffmanCodigos[entero];
                    //System.out.println(TablaHuffmanCodigos[entero]);
                    strBuffer = procesarBuffer(strBuffer, archivoDestino);
                    cont++;
                }
                System.out.println(strBufferTmp);
                archivoOrigen.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //Huffman
    //public ArbolHuffman AH;

    void comprimir(String nombreArchivo) {
        ArbolHuffman AH = new ArbolHuffman();
        if (AH != null) {
            AH.cargarTablaDeArchivo(nombreArchivo);
            //System.out.println("crea lista: ");
            AH.crearListaDeArboles();
            AH.procesarListaDeArboles();
            AH.generarCodigosDeHuffman_recursivo(AH.nodoInicial.raiz, "");
            AH.generarArchivoComprimido(nombreArchivo, nombreArchivo + ".compress");
        }
    }

    public static void main(String[] args) {
        //Crear arbol de huffman
        Huffman AHuffman = new Huffman();
        //Cambiar el nombre del archivo por el archivo deseado
        AHuffman.comprimir("D:\\prueba.txt");
    }
}