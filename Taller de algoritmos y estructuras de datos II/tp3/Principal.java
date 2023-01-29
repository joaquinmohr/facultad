import java.io.*;
import java.util.Hashtable;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {

        Scanner qwerty = new Scanner(System.in);
        String opMenu;
        String ruta;
        String msjCodificado;
        String msjDecodificado;
        Huffman huffman;
        NodoBinario raiz;
        int[] frecuencias;
        Hashtable<Character, String> tabla;
        File file;

        do {
            System.out.println("\n\tMENU\nIngrese una opcion:\n1- Crear archivo para la compresion\n0- Salir");
            opMenu = qwerty.nextLine();
            switch (opMenu) {
                case "1" -> {
                    System.out.println("Ingrese el texto a comprimir");
                    String cadena = qwerty.nextLine();
                    ruta = System.getProperty("user.dir") + File.separator + "texto.txt";
                    file = new File(ruta);
                    FileWriter archivo = new FileWriter(file, false);
                    PrintWriter writer = new PrintWriter(archivo);
                    writer.print(cadena);
                    writer.close();
                    System.out.println("Archivo creado en " + ruta);

                    huffman = new Huffman();
                    frecuencias = huffman.calcularFrecuencias(file);
                    raiz = huffman.construirArbol(frecuencias);
                    tabla = huffman.crearTabla(raiz);

                    System.out.println("Los codigos de Huffman quedan de la siguiente manera\n");

                    for (Character c : tabla.keySet()){
                        System.out.println(c + "\t" + tabla.get(c));
                    }

                    System.out.print("\n\tPresione enter para continuar con la codificacion y decodificacion\n");
                    qwerty.nextLine();

                        //Codificar
                        msjCodificado = huffman.codificarMensaje(tabla, cadena);
                        System.out.println("Mensaje codificado");
                        System.out.println(msjCodificado);
                        System.out.println();

                        //Decodificar
                        msjDecodificado = huffman.decodificarMensaje(tabla, msjCodificado);
                        System.out.println("Mensaje decodificado");
                        System.out.println(msjDecodificado);
                        System.out.println();

                    System.out.println("Presione enter para volver al Menu principal\nIngrese 0 (cero) para salir");
                    opMenu = qwerty.nextLine();
                }
                case "0" -> System.out.println("Gracias por utilizar el programa");
                default -> System.out.println("Opcion incorrecta, reintente");
            }
        }while (!opMenu.equals("0"));
        qwerty.close();
    }
}
