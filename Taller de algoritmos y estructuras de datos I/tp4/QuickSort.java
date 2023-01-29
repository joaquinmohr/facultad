public class QuickSort {
    public void quickSort(Equipo[] arrEq, int izq, int der) {

        int pivPts = arrEq[izq].getPuntos();    //Como vamos a ordenar de acuerdo a los puntos, tomamos como pivote al primer elemento
        String pivNom = arrEq[izq].getNombre(); //Tambien el equipo que corresponde a ese primer elemento para no perder la referencia
        int i = izq;                            // i realiza la búsqueda de izquierda a derecha
        int j = der;                            // j realiza la búsqueda de derecha a izquierda
        int auxPts;                             //Auxiliar para puntos del equipo
        String auxNom;                          //Auxiliar para nombre del equipo

        while (i < j) {                                             //Mientras no se crucen las búsquedas (de izquierda a derecha y de derecha a izquierda)
            while (arrEq[i].getPuntos() <= pivPts && i < j) i++;    //Buscamos el elemento mayor que pivote
            while (arrEq[j].getPuntos() > pivPts) j--;              //Buscamos el elemento menor que pivote
            if (i < j) {                                            //Si no se cruzaron
                auxPts = arrEq[i].getPuntos();                      //Intercambiamos los puntos
                auxNom = arrEq[i].getNombre();                      //Intercambiamos los nombres
                arrEq[i].setPuntos(arrEq[j].getPuntos());
                arrEq[i].setNombre(arrEq[j].getNombre());
                arrEq[j].setPuntos(auxPts);
                arrEq[j].setNombre(auxNom);
            }
        }

        arrEq[izq].setPuntos(arrEq[j].getPuntos());
        arrEq[izq].setNombre(arrEq[j].getNombre());     //Colocamos los pivotes en su lugar de forma que tendremos
        arrEq[j].setPuntos(pivPts);                     //Los menores puntajes a su izquierda correspondientes a cada equipo
        arrEq[j].setNombre(pivNom);                     //Y los mayores puntajes a su derecha tambien correspondientes a cada equipo

        if (izq < j - 1)
            quickSort(arrEq, izq, j - 1);          //Ordenamos subarray izquierdo
        if (j + 1 < der)
            quickSort(arrEq, j + 1, der);          //Ordenamos subarray derecho

    }
}
