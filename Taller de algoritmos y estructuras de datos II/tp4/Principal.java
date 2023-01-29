public class Principal {
    public static void main(String[] args) throws InterruptedException {

        long inicio, fin, tiempo;

        Genetico gen = new Genetico();
        inicio = System.currentTimeMillis();
        gen.comenzarProceso();
        fin = System.currentTimeMillis();
        tiempo = (fin - inicio) - gen.getTemp();
        System.out.println("Tiempo de ejecucion del algoritmo: " + tiempo + "ms");

    }
}
