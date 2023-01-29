public class Principal {
    public static void main(String[] args) {

        Equipo eq = new Equipo();
        Equipo[] arrEquipos = new Equipo[8];
        QuickSort orden = new QuickSort();

        arrEquipos[0] = new Equipo("Boca\t\t", eq.aJugar());
        arrEquipos[1] = new Equipo("Racing\t\t", eq.aJugar());
        arrEquipos[2] = new Equipo("Gimnasia\t", eq.aJugar());
        arrEquipos[3] = new Equipo("River\t\t", eq.aJugar());
        arrEquipos[4] = new Equipo("San Lorenzo", eq.aJugar());
        arrEquipos[5] = new Equipo("Tigre\t\t", eq.aJugar());
        arrEquipos[6] = new Equipo("Independiente", eq.aJugar());
        arrEquipos[7] = new Equipo("Patronato\t", eq.aJugar());

        //Sin ordenar
        System.out.println("\t| Tabla de posiciones |");
        System.out.println("\t| Equipo |\t| Puntos  |");
        for (Equipo arr : arrEquipos) {
            System.out.println("\t" + arr.getNombre() + " \t" + arr.getPuntos());
        }
        System.out.println();
        //Ordenamos
        orden.quickSort(arrEquipos, 0, arrEquipos.length - 1);

        //Ordenados y mostrando de mayor a menor
        System.out.println("\t| Tabla de posiciones |");
        System.out.println("\t| Equipo |\t| Puntos  |");
        for (int i = 7; i >= 0; i--) {
            System.out.println("\t" + arrEquipos[i].getNombre() + " \t" + arrEquipos[i].getPuntos());
        }
    }
}