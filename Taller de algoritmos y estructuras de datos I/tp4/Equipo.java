public class Equipo {
    private String nombre;
    private int puntos;

    public Equipo() {

    }

    public Equipo(String nombre, int puntos) {
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public int aJugar(){
        return (int)(Math.random()*50);
    }
}
