public class ListaDobleProducto {
    Nodo primerNodo, ultimoNodo;

    public void agregarNodo(Producto valor) throws Exception {

        Nodo nodoNuevo = new Nodo();
        nodoNuevo.setValor(valor);
        //Primera situacion: que no existan nodos, ahora el que nos llega va a ser el primero
        if (primerNodo == null) {
            primerNodo = nodoNuevo;
            ultimoNodo = primerNodo;
        } else {
            //Segunda situacion: ya existia al menos un nodo, por lo tanto:
            //Nodo temporal con el puntero al inicio de la lista
            Nodo nodoTemporal = primerNodo;

            //Recorremos desde el primer nodo hasta el ultimo
            //Si encontramos un codigo igual, lanzamos la exception y no insertamos nada
            while (nodoTemporal != null) {
                if (nodoNuevo.getValor().getCodigo() == nodoTemporal.getValor().getCodigo()) {

                    throw new Exception("Error, no se pudo agregar el producto\nCodigo del producto ya existente\n");

                }
                nodoTemporal = nodoTemporal.getNodoSiguiente();
            }

            //Tercera situacion:
            //Si el codigo del producto que nos llega es menor que el codigo del producto que tenemos al principio de la lista
            //Lo insertamos al pincipio y nos salimos
            if (nodoNuevo.getValor().getCodigo() < primerNodo.getValor().getCodigo()) {

                nodoNuevo.setNodoSiguiente(primerNodo);
                primerNodo.setNodoAnterior(nodoNuevo);
                primerNodo = nodoNuevo;
                return;

            }
            //Cuarta situacion:
            //Si el codigo del producto que nos llega es mayor que el codigo del producto que tenemos al final de la lista
            //Lo insertamos al final y nos salimos
            if (nodoNuevo.getValor().getCodigo() > ultimoNodo.getValor().getCodigo()) {

                nodoNuevo.setNodoAnterior(ultimoNodo);
                ultimoNodo.setNodoSiguiente(nodoNuevo);
                ultimoNodo = nodoNuevo;
                return;

            }
            //Cuarta situacion:
            //Primero que nada, ponemos el puntero de nuestro nodotemporal al principio
            //Para recorrer desde el primer nodo hasta el ultimo
            //Como en las situaciones anteriores ya nos encargamos del orden, a esta altura de ejecucion
            //lo que exista hasta el momento ya se encuentra ordenado, por lo tanto
            //Si el codigo del producto que nos llega es mayor que el codigo del producto que tenemos de la iteracion actual y a su vez
            //El codigo del producto que nos llega es menor que el codigo del producto que tenemos en la iteracion actual
            //Encontramos la posicion correcta!!!
            //Lo insertamos seteando los respectivos punteros para cada uno de los nodos que tuvieron participacion en esa iteraccion.
            //Osea, el anterior, el que vamos a insertar y el siguiente
            //Nos salimos
            nodoTemporal = primerNodo;
            while (nodoTemporal != null) {
                if ((nodoNuevo.getValor().getCodigo() > nodoTemporal.getValor().getCodigo()) && (nodoNuevo.getValor().getCodigo() < nodoTemporal.getNodoSiguiente().getValor().getCodigo())) {

                    nodoNuevo.setNodoAnterior(nodoTemporal);
                    nodoNuevo.setNodoSiguiente(nodoTemporal.getNodoSiguiente());
                    nodoTemporal.getNodoSiguiente().setNodoAnterior(nodoNuevo);
                    nodoTemporal.setNodoSiguiente(nodoNuevo);
                    return;

                }
                nodoTemporal = nodoTemporal.getNodoSiguiente();
            }
        }
    }

    //Para saber si existen nodos
    public boolean sinNodos() {
        return primerNodo == null;
    }
    //Para mostrar los nodos
    public void imprimirNodos() {
        Nodo nodoTemporal = primerNodo;
        while (nodoTemporal != null) {
            System.out.print(nodoTemporal.getValor() + "\n");
            nodoTemporal = nodoTemporal.getNodoSiguiente();
        }
    }
}
