import java.util.Arrays;

public class Cadena {

    private int[] cadena;

    private int tam, ind;

    public int getTam() {
        return tam;
    }

    public Cadena(int tam) {
        this.tam = tam;
        cadena = new int[tam];
        ind = 0;
    }

    public int getValor(int indice) {
        return cadena[indice];
    }

    public void setValor(int valor) {
        cadena[ind] = valor;
        ind++;
    }

    public int calcularMuestra() {
        int muestra = 0;
        for (int i = 0; i < tam; i++) {
            muestra += cadena[i] * 2;
        }
        return muestra;
    }

    public String mostrarCadena() {
        return "\n\tCadena => " + Arrays.toString(cadena) +
                "\n\tMuestra: " + calcularMuestra() + "\n";
    }
}
