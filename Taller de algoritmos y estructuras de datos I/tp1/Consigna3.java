
import java.util.Scanner;

public class Consigna3 {
    public static void main(String[] args) {

        int tamano;
        int posicion;
        Scanner qwerty = new Scanner(System.in);
        try {
            System.out.println("Indique la cantidad de palabras que va a ingresar: ");
            tamano = Integer.parseInt(qwerty.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Solo numeros enteros!");
            main(args);
            return;
        }

        String[] palabras = new String[tamano];

        // Almacenar las palabras ingresadas por teclado
        for (int i = 0; i < tamano; i++) {
            System.out.println("Ingrese la palabra " + (i + 1));
            palabras[i] = qwerty.nextLine();
        }

        // Listar todas las palabras almacenadas
        System.out.println("Las palabras que usted ingreso son: ");
        for (int i = 0; i < tamano; i++) {
            System.out.println((i + 1) + "-> " + palabras[i]);
        }

        // Uso del método de conteo para una palabra N almacenada en una posición
        // elegida por el usuario desde el teclado
        boolean repetir = true;
        while (repetir) {
            try {
                System.out.println("Ingrese el numero que corresponde a la palabra que quiere analizar");
                posicion = Integer.parseInt(qwerty.nextLine());
                if (posicion > 0 && posicion <= tamano) {
                    Contador analisis = new Contador();
                    analisis.iniciarConteo(palabras[posicion - 1]);
                    analisis.mostrarConteo();
                    System.out.println("Si desea analizar otra palabra de la lista ingrese: si");
                    System.out.println("Para salir del programa ingrese: salir");
                    String p = qwerty.nextLine();
                    if (p.equalsIgnoreCase("si")) {
                        repetir = true;
                    } else if (p.equalsIgnoreCase("salir")) {
                        repetir = false;
                    }
                } else {
                    System.out.println("El numero ingresado no corresponde a ninguna palabra");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar solo numeros");
            }
        }
        System.out.println("Hasta la vista, baby");
    }
}