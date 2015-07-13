import java.util.Scanner;

public class Comprobar_fecha {

	public static void main(String[] args) {
		// Testeo:
		
		int fecha[] = fechaCorrecta(1900,2014);
		
		System.out.printf("%d %d %d",fecha[0], fecha[1], fecha[2]);

	}
	

/*
 * M�TODO fechaCorrecta(int,int):
   � El m�todo est� compuesto por dos par�metros, ambos 'int':
       - El primer par�metro es el a�o m�nimo que se quiere establecer.
       - El segundo, el a�o m�ximo.
     El valor devuelto ser� un vector con d�a, mes y a�o correctos en este orden.
     Compruebo meses de 28, 29, 30 y 31 d�as y a�os m�nimos y m�ximos. Obligo al usuario a
     introducir valores correctos para poder devolverlos con el m�todo.

*/
	private static int [] fechaCorrecta(int ano_min, int ano_max) {
		
	 // DECLARACI�N DE VARIABLES
	 // ========================	 
		
		int d, m, a; // d�a, mes y a�o.
		
	 // ENTRADA DE DATOS (INPUT)
     // ========================
			
		Scanner entrada = new Scanner(System.in);
		
		// FECHA DE HOY.
		// A�O:
		System.out.println("Introduce el a�o:");
		a = entrada.nextInt();
		while (a<ano_min || a>ano_max) {
			System.out.printf("Por favor, introduce un a�o entre %d y %d.\n", ano_min, ano_max);
			a = entrada.nextInt();
		}
		// MES:
		System.out.println("Introduce el mes (1-12):");
		m = entrada.nextInt();
		while (m<1 || m>12) {
			System.out.println("Por favor, introduce un mes entre el 1 y el 12.");
			m = entrada.nextInt();
		}
		// D�A:
		System.out.println("Introduce el d�a:");
		d = entrada.nextInt();
		switch (m) {
			case 2:  // Febrero.
				if (d==29) {  // Si el usuario introduce d�a '29', comprobamos si el a�o es bisiesto.
					if (!((a % 4 == 0) && ((a % 100 != 0) || (a % 400 == 0)))) {
						System.out.println("Es Febrero, pero el a�o introducido anteriormente NO es bisiesto.");
						do {
							System.out.println("Por favor, introduce un d�a entre 1 y 28."); // Nos aseguramos de que el usuario introduzca
							d = entrada.nextInt();									 // un d�a correcto.
						}
						while (d<1 || d>28);
					}
				}
				else if (d<1 || d>28) {  // Nos aseguramos de que el usuario introduzca un d�a entre el 1 y el 28.
					do {
						System.out.println("Por favor, introduce un d�a entre 1 y 28.");
						d = entrada.nextInt();
					}
					while (d<1 || d>28);
				}
				break;				
			case 4: case 6: case 9: case 11: // Abril, Junio, Septiembre y Noviembre.
				while (d<1 || d>30) {  // Nos aseguramos de que el usuario introduzca un d�a entre el 1 y el 30.
					System.out.println("Por favor, introduce un d�a entre 1 y 30.");
					d = entrada.nextInt();
				}
				break;				
			case 1: case 3: case 5: case 7: case 8: case 12: // Enero, Marzo, Mayo, Julio, Agosto y Diciembre.
				while (d<1 || d>31) {  // Nos aseguramos de que el usuario introduzca un d�a entre el 1 y el 31.
					System.out.println("Por favor, introduce un d�a entre 1 y 31.");
					d = entrada.nextInt();
				}
				break;				
			default:
				break;
		} // fin de 'switch'
		
	 // PROCESAMIENTO DE DATOS
	 // ======================
		
		int fecha[] = {d,m,a};  // Declaro e inicializao el vector 'fecha[]' con el d�a, mes y a�o correctos.
		
	 // SALIDA DE DATOS (OUTPUT)
	 // ========================
		
		return fecha;
		
	}
	
/*
 * FIN M�TODO fechaCorrecta(int,int);
 */
}
