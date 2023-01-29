import java.util.Random;

public class Principal {

    /*
    Situación problemática
    Poseemos un edificio inteligente con sensores IoT que detectan por infrarrojo temperatura corporal, 
    es decir que tienen la habilidad de encontrar si la habitación tiene personas. 
    El edificio es un edificio de 10 pisos (de planta baja hasta el piso 10). 
    En planta baja no hay sensores, pero por cada piso y en cada espacio por piso (oficinas e incluso hall de ascensores) 
    tenemos un sensor cuya función de consulta nos devuelve verdadero si hay personas, o falso si no hay.
    Cada piso tiene el siguiente esquema:
    _____________________
    |   1   | 2 |   3   |
    ---------------------
    |   4   { 5 }   6   |
    ---------------------
    |   7   | 8 |   9   |
    ---------------------
    Donde los números son las oficinas, salvo el 5 que es el hall de ascensores.
    */

    public static void main(String[] args) {

        Edificio edificio = new Edificio();
        Random random = new Random();
        Oficina oficinas[][] = new Oficina[10][9];
        for (int i = 0; i < oficinas.length; i++) {
            for (int j = 0; j < oficinas[i].length; j++) {
                Oficina oficina = new Oficina(i, j, random.nextBoolean());
                oficinas[i][j] = oficina;
                System.out.println("Oficina N° : " + (oficina.getNro()+1) + ", piso: " + (oficina.getPiso()+1) + ", esta activa? " + oficina.estaActiva());
            }
        }

        edificio.setOficinas(oficinas);
        edificio.cantidadDeOficinasActivas();
        edificio.primerOficinaActiva();

    }

}