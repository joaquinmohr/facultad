public class Dato {

    private int simbolo;
    private int frecuencia;

    public Dato(){

    }

    public Dato(int simbolo, int frecuencia) {
        this.simbolo = simbolo;
        this.frecuencia = frecuencia;
    }

    public int getSimbolo() {
        return simbolo;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }
}
