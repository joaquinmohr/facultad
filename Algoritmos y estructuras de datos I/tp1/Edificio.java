public class Edificio {

    //private int numOficinas;
    private Oficina[][] oficinas;

    public Edificio() {
        //this.numOficinas = cantidadDeOficinas;
    }

    public void setOficinas(Oficina[][] oficinas) {
        this.oficinas = oficinas;
    }

    public int cantidadDeOficinasActivas() {
        int contador = 0;
        for (int i = 0; i < oficinas.length; i++) {
            for (int j = 0; j < oficinas[i].length; j++) {
                if (this.oficinas[i][j].estaActiva()) {
                    contador++;
                }
            }
        }
        System.out.println("cantidad de oficinas activas: " + contador);
        return contador;
    }


    public Oficina primerOficinaActiva() {
        Oficina oficina = new Oficina();
        boolean bandera = false;
        for (int i = 0; i < oficinas.length && !bandera; i++) {
            for (int j = 0; j < oficinas[i].length && !bandera; j++) {
                if (this.oficinas[i][j].estaActiva()) {
                    bandera = true;
                    oficina = oficinas[i][j];
                }
            }
        }
        System.out.println("La primer oficina activa encontrada es la " + (oficina.getNro()+1) + " en el piso N°: " + (oficina.getPiso()+1));
        return oficina;

    }


}



