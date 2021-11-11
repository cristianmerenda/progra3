import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class principal {

	public static void main(String[] args) {
		int nroJugadoresTotal = obtenerNroJugadoresTotales();		
		int maxPosASaltar = obtenerMaximaPosicionASaltar();
		int posInicial = obtenerPosiciónInicial();
		int posJugadorGanador = obtenerPosicionJugadorGanador();
				
		ResolverProblemaImplementacion resolverProblema = new ResolverProblemaImplementacion();
		//Map<Integer, List<Jugada>> resultado= resolverProblema.resolverJuego(nroJugadoresTotal, posInicial, posJugadorGanador, maxPosASaltar);
		ArrayList<Jugada> resultado= resolverProblema.resolverJuego(nroJugadoresTotal, posInicial, posJugadorGanador, maxPosASaltar);
		
		imprimirResultado(resultado);
		
	}
	
	
	private static int obtenerNroJugadoresTotales () {
		System.out.println ("Ingrese la cantidad total de jugadores");
		String entradaTeclado = "";
		Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
		entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
		return Integer.valueOf(entradaTeclado);
	}
	
	private static int obtenerMaximaPosicionASaltar () {
		
		System.out.println ("Ingrese la cantidad máxima de posiciones a saltar");
		String entradaTeclado = "";
		Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
		entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
		return Integer.valueOf(entradaTeclado);
	}
	
	private static int obtenerPosicionJugadorGanador () {
		System.out.println ("Ingrese la posición del jugador ganador (Se comienza desde la posición 0)");
		String entradaTeclado = "";
		Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
		entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
		return Integer.valueOf(entradaTeclado);
	}
	
	private static int obtenerPosiciónInicial () {
		System.out.println ("Ingrese la posición a comenzar(Tener en cuenta que comienza desde el jugador 0)");
		String entradaTeclado = "";
		Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
		entradaTeclado = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
		return Integer.valueOf(entradaTeclado);
	}
	
	private static void imprimirResultado (ArrayList<Jugada> resultado) {
		resultado.forEach((c) -> System.out.println(c.getMov() + " " + c.getPos()));
	}
	
}
