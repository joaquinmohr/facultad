import java.util.InputMismatchException;
import java.util.Scanner;
public class PrincipalPila {
    public static void main(String[] args){

        Scanner qwerty = new Scanner(System.in);
        try {
            int dato;
            int opMenu;
            //Definimos el tamaño del arreglo
        System.out.print("Ingrese el tamano de la pila: ");
        dato = qwerty.nextInt();
        Pila instanciaPila = new Pila(dato);
        System.out.println("\n\tSe creo una pila para "+dato+" elementos\n");

                do {
                    System.out.println("\t\tMENU\n Ingrese una opcion\n 1- Apilar un elemento\n 2- Desapilar un elemento\n 3- Estado de la pila\n 0- Salir\n");
                    opMenu = qwerty.nextInt();
                    switch (opMenu) {
                        case 0:
                            //Salimos del while
                            System.out.println("\tGracias por utilizar el programa");
                            break;
                        case 1:
                            //Preguntamos si la pila no esta llena
                            if (!instanciaPila.esLlena()) {
                                System.out.print("Ingrese el dato que quiere apilar: ");
                                dato = qwerty.nextInt();
                                instanciaPila.apilarDato(dato);
                            } else {
                                System.out.println("\n\tLa pila esta llena, imposible apilar mas elementos\n");
                            }
                            break;
                        case 2:
                            //Preguntamos si la pila no esta vacia
                            if (!instanciaPila.esVacia()) {
                                dato = instanciaPila.desapilarDato();
                                System.out.println("\n\tSe desapilo el elemento " + dato + " de la pila\n");
                            } else {
                                instanciaPila.desapilarDato();
                            }
                            break;
                        case 3:
                            //Mostramos la cantidad de elementos que tiene la pila en el caso de que haya
                            dato = instanciaPila.tamanoPila();
                            String msj = dato != 0 ? "\n\tLa pila contiene "+dato+" elementos\n" : "\n\tLa pila esta vacia\n";
                            System.out.println(msj);
                            break;
                        default:
                            System.out.println("\n\tOpcion incorrecta\n");
                            break;
                    }

                } while (opMenu != 0);
            }catch (InputMismatchException e){
            System.out.println("\n\tDebe ingresar solo numeros \n\tFin del programa");
        }
    }
}
