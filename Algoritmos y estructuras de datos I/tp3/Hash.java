/*
Situacion problematica
Una prestigiosa universidad está proponiendo un proyecto de investigación de IA que reconoce a los estudiantes que ingresan y permanecen en el campus. 
Mientras los alumnos permanezcan en el campus, todos los subsistemas deberán poder acceder de forma rápida a la información de cada uno y para ello 
se propone almacenar en memoria de los servers una tabla hash con los alumnos del campus.
*/

public class Hash {

	int dato;
	int estado; // 0 = Vacio, 1 = Eliminado, 2 = Ocupado

	static int FuncionHash(int n, int m) {
		// n es el valor original
		// m es el tamano de la tabla
		// y debe devolver una posicion int dentro del tama�o m

		int x; // Declaramos la variable x como entero
		x = n % m; // Asignamos a x el resto (mod) de n entre m
		return x; // Retornamos x

	}

	static void insertaHash(Hash[] h, int m, int n) {
		boolean i = false;
		int j = FuncionHash(n, m);
		do {
			if (h[j].estado == 0 || h[j].estado == 1) {
				h[j].dato = n;
				h[j].estado = 2;
				i = true;
			} else {
				j++;
			}
		} while (j < m && !i);
		if (i) {
			System.out.print("Elemento insertado con exito! \n");
		} else {
			System.out.print("Tabla llena!!! \n");
		}
	}

	static int buscaHash(Hash[] h, int m, int n) {
		// h es la tabla hash
		// m es el tamano de la tabla
		// n es el valor buscado
		// y debe devolver el valor mismo que busca n si lo encuentra y -1 si no
		// encuentra nada

		int hash = FuncionHash(n, m); // Declaramos como entero a hash para asignarle lo que retorna FuncionHash
		while (hash < m) { // Usamos el bucle while con la condicion de que hash sea menor que m
			if (h[hash].estado == 0) { // Si el estado es 0
				return -1; // Devuelve -1, lo que es equivalente a vacio
			} else if (h[hash].dato == n) { // Si encontramos el dato
				if (h[hash].estado == 1) { // Consultamos si su estado es eliminado
					return -1; // Devolvemos vacio
				} else { // Sino
					return hash; // Devolvemos la posicion
				}
			} else { // En el caso de que no encuentre dato
				hash++; // incrementamos la posicion en 1
			}
		}
		return -1; // Si directamente no se entra en el bucle porque hash es mayor o igual a m,
					// devolvemos vacio
	}

	static int eliminaHash(Hash[] h, int m, int n) {
		int i = buscaHash(h, m, n);
		if (i == -1) {
			return -1;
		} else {
			h[i].estado = 1;
			System.out.print("Elemento Borrado! \n");
			return 1;
		}
	}

	public static void main(String[] args) {

		int i, elemento;
		// Tabla Definida de 15
		int m = 15;
		Hash[] h = new Hash[m];
		for (i = 0; i < m; i++) {
			h[i] = new Hash();
			h[i].estado = 0;
		}
		// Insertar elemento
		Hash.insertaHash(h, m, 15);
		Hash.insertaHash(h, m, 130);
		Hash.insertaHash(h, m, 7);
		Hash.insertaHash(h, m, 32);
		// Buscando un elemento
		elemento = 7;
		i = Hash.buscaHash(h, m, elemento);

		System.out.println(i); // Devuelve la posicion del elemento buscado

		i = Hash.eliminaHash(h, m, 130);

	}
}
