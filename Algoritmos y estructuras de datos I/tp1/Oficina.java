public class Oficina {

    private int nro;
    private int piso;
    private boolean estaActiva;

    public Oficina(){

    }

    public Oficina(int nro, int piso, boolean estaActiva) {
        this.nro = nro;
        this.piso = piso;
        this.estaActiva = estaActiva;
    }

    public int getPiso() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public int getNro() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public boolean estaActiva() {
        return estaActiva;
    }

    public void setActiva(boolean activa) {
        estaActiva = activa;
    }

}

