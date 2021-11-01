package tpo.principal;

import java.util.ArrayList;
import java.util.List;

public class principal {

	public static void main(String[] args) {
		int cantidadJugadores = 10;
		int[] jugadores = new int[cantidadJugadores];
		int movimientos = 3;
		int jugadoresInicial = 1; 
		int jugadorGanador = 0; 
		int etapa = 1; //etapa me parece que tiene que ser un valor por referencia...
		List<String> solucion = new ArrayList<String>();
		
		
		for (int j = 0 ; j<cantidadJugadores; j +=1) {
			jugadores[j] = j;
		}
		
		for (int i = 1; i <= movimientos; i += 1) {
			System.out.print ("Evaluando solución para ");
			System.out.print( String.valueOf(i) + " Movimientos");
			System.out.println (" ");
			
			boolean resultado = jugar(jugadores, jugadoresInicial, jugadorGanador, i, etapa, solucion );
			if (resultado) {
				solucion.forEach(System.out::println);
			}
			else {
				System.out.println("No hay solución para " + String.valueOf(i));
			}	
			System.out.println("--------------------");
			System.out.println("    ");
		}
		
	}
	
	//el etapa me parece que tiene que ser un valor por referencia... analizarlo
	public static boolean jugar (int[] jugadores, int jugadorInicial, int jugadorGanador, int movimientos, int etapa, List<String> solucion) {
		if (jugadores.length == etapa) {
			if (jugadores[jugadorInicial] == jugadorGanador) {
				return true; 
				
			}
			else {
				return false; 
			}
		}
		else {
			etapa += 1;
			int nextPos = moverIzq(movimientos+1, jugadores, jugadorInicial);
			int verificacion = jugadores[nextPos]; 
			if (verificacion == jugadorGanador) return false; 
			jugadores[nextPos] = -1;
			solucion.add("izquierda " + String.valueOf(verificacion));
			boolean resIzq = jugar(jugadores, moverIzq(1, jugadores, nextPos), jugadorGanador, movimientos, etapa, solucion);			if (resIzq) {
				//System.out.println("izquierda " + String.valueOf(verificacion));
				return true;
			} else {
				jugadores[nextPos] = verificacion; 
				solucion.remove(solucion.size()-1);
				
			}
			//jugadores[nextPos] = verificacion; 
			//solucion.remove(solucion.size()-1);
			
			//etapa -= 1;
			
			nextPos = moverDer(movimientos+1, jugadores, jugadorInicial);
			verificacion = jugadores[nextPos]; 
			if (verificacion == jugadorGanador) return false; 
			jugadores[nextPos] = -1; 
			solucion.add("derecha " + String.valueOf(verificacion));
			//boolean resDer = jugar(jugadores, moverDer(1, jugadores, nextPos), jugadorGanador, movimientos, etapa, solucion);
			boolean resDer = jugar(jugadores, moverDer(1, jugadores, nextPos), jugadorGanador, movimientos, etapa, solucion);
			if (resDer) {
				//System.out.println("derecha " + String.valueOf(verificacion));
				return true;
			}
			else {
				jugadores[nextPos] = verificacion; 
				solucion.remove(solucion.size()-1);
				return false;
			}
		} 
	}
	
	public static int moverIzq(int posiciones, int[] jugadores, int jugadorInicial) { 
		int i = 0;
		int j = jugadorInicial; 
		while (i < posiciones) {
			j -= 1;
			if (j < 0) {
				j = jugadores.length -1; 
			}
			if (jugadores[j] != -1) {
				i += 1;
			}
		}
		return j;
	}
	
	public static int moverDer(int posiciones, int[] jugadores, int jugadorInicial) {
		int i = 0;
		int j = jugadorInicial; 
		while (i<posiciones) {
			j += 1;
			if (j > jugadores.length -1) {
				j = 0; 
			}
			if( jugadores[j] != -1) {
				i += 1;
			}
		}
		return j;
	}
	
	public static void imprimir(int [] arreglo) {
		for (int i = 0; i < arreglo.length; i++){
			System.out.print(arreglo[i]);
			System.out.print(", ");
		}
		System.out.println("");
	}

}
