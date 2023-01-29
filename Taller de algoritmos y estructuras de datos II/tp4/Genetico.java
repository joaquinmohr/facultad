import java.util.Random;

public class Genetico {
    private Cadena principal;
    private int iter, temp, cruces;

    public int getTemp() {
        return temp;
    }

    public Genetico() {
        principal = generarCadena();
        iter = 0;
        temp = 0;
        cruces = 0;
    }

    public Cadena generarCadena() {
        Cadena nuevaCadena = new Cadena(20);
        for (int i = 0; i < 20; i++) {
            nuevaCadena.setValor(generarAleatorio());
        }
        return nuevaCadena;
    }

    public Cadena generarCruce(Cadena primera, Cadena segunda) {
        Cadena optima = new Cadena(20);
        for (int i = 0; i < primera.getTam(); i++) {
            if (primera.getValor(i) == segunda.getValor(i)) {
                optima.setValor(1);
            }
        }
        return optima;
    }

    private int generarAleatorio() {
        Random ran = new Random();
        return ran.nextInt(0, 2);
    }

    public void comenzarProceso() throws InterruptedException {
        System.out.println("Comenzando proceso con la cadena\n\t" + principal.mostrarCadena());
        while (principal.calcularMuestra() < 40) {
            Cadena nuevaCadena = generarCadena();
            Cadena cadenaCruzada = generarCruce(principal, nuevaCadena);
            if (cadenaCruzada.calcularMuestra() > principal.calcularMuestra()) {
                Thread.sleep(1000);
                temp += 1000;
                cruces++;
                System.out.println("--------------------------\tResultado del cruce " + cruces + "\t--------------------------");
                System.out.println("Cadena principal anterior:\n\t" + principal.mostrarCadena());
                principal = cadenaCruzada;
                System.out.println("Nueva cadena principal:\n\t" + principal.mostrarCadena());
                System.out.println("------------------------------------------------------------------------------\n");
                System.out.print("Procesando...\r");
            }
            iter++;
        }
        System.out.println("Numero de cruces efectivos: " + cruces);
        System.out.println("Cantidad de iteraciones necesarias para lograr una cadena completa: " + iter);
    }
}
