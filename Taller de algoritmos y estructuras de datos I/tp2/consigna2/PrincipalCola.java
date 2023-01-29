import java.util.Scanner;
public class PrincipalCola {
    public static void main(String[] args) {
        Scanner qwerty = new Scanner(System.in);
        Cola<Pedido> cola = new Cola<>();
        String opMenu;
        do {
            System.out.println("\t\tMENU\n Ingrese una opcion\n 1- Cargar pedido\n 2- Retirar pedido\n 3- Mostrar pedidos existentes\n 0- Salir\n");
            opMenu = qwerty.nextLine();
            switch (opMenu) {
                case "0":
                    System.out.println("\tGracias por utilizar el programa");
                    break;
                case "1":
                    try {
                        Pedido nuevoPedido = new Pedido();
                        System.out.println("Ingrese un codigo numerico");
                        nuevoPedido.setCodigo(Integer.parseInt(qwerty.nextLine()));
                        System.out.println("Ingrese nombre del cliente");
                        nuevoPedido.setNombre(qwerty.nextLine());
                        System.out.println("Ingrese apellido del cliente");
                        nuevoPedido.setApellido(qwerty.nextLine());
                        System.out.println("Ingrese la cantidad de ladrillos");
                        nuevoPedido.setLadrillos(Integer.parseInt(qwerty.nextLine()));
                        cola.encolar(nuevoPedido);
                    } catch (NumberFormatException e) {
                        System.out.println("Error, solo numeros\n");
                    }
                    break;
                case "2":
                    if (!cola.esVacia()) {
                        System.out.println("\tSe retiro el pedido con los siguientes datos\n");
                        System.out.println(cola.desencolar().getInfo());
                    } else {
                        System.out.println("\tNo existen pedidos a retirar\n");
                    }
                    break;
                case "3":
                    if (!cola.esVacia()){
                        System.out.println("\tLos pedidos en cola son los siguientes\n");
                        cola.imprimirCola();
                    }else {
                        System.out.println("\tNo existen pedidos\n");
                    }
                    break;
                default:
                    System.out.println("\tOpcion incorrecta\n");
                    break;
            }
        } while (!opMenu.equals("0"));
    }
}