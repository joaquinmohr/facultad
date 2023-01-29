import java.util.Scanner;
public class Principal {
    public static void main(String[] args) {
        Scanner qwerty = new Scanner(System.in);
        ListaDobleProducto lista = new ListaDobleProducto();
        String opMenu;
        do {
            System.out.println("\n\t\tMENU\n Ingrese una opcion\n 1- Cargar producto\n 2- Mostrar listado de productos\n 0- Salir\n");
            opMenu = qwerty.nextLine();
            switch (opMenu) {
                case "0":
                    System.out.println("Gracias por utilizar el programa");
                    break;
                case "1":
                    try {
                        Producto prod = new Producto();
                        System.out.println("Ingrese el codigo del producto");
                        prod.setCodigo(Integer.parseInt(qwerty.nextLine()));
                        System.out.println("Ingrese la descripcion del producto");
                        prod.setDescripcion(qwerty.nextLine());
                        System.out.println("Ingrese el precio del producto");
                        prod.setPrecio(Integer.parseInt(qwerty.nextLine()));
                        lista.agregarNodo(prod);
                    } catch (NumberFormatException e) {
                        System.out.println("Error, solo numeros\n");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "2":
                    if (!lista.sinNodos()) {
                        System.out.println("\tListado de productos");
                        lista.imprimirNodos();
                    } else {
                        System.out.println("No existen productos en el sistema");
                    }
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (!opMenu.equals("0"));

    }
}
