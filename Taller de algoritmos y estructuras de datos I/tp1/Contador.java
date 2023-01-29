
public class Contador {
    public Contador() {
        // Constructor
    }

    int[] conteos = new int[26];

    // Metodo conteo de frecuencia
    public void iniciarConteo(String palabra) {
        palabra = palabra.toUpperCase();
        for (int i = 0; i < palabra.length(); i++)
            try {
                conteos[palabra.charAt(i) - 'A']++;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("El siguiente caracter genero un error: \"" + palabra.charAt(i) + "\"");
            }
    }

    // Metodo imprimir frecuencias
    public void mostrarConteo() {
        for (int i = 0; i < conteos.length; i++)
            if (conteos[i] != 0) {
                System.out.println((char) (i + 'A') + ": " + conteos[i]);
            }
    }
}
