package tpo.principal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ResolverProblemaImplementacion implements ResolverProblemaInterface{
	
	public Map<Integer,List<Jugada>> resolverJuego(int nroJugadoresTotal, int posInicial, int posJugadorGanador, int maxPosASaltar) {
		
		

		Map<Integer, List<Jugada>> resultadoFinal = new HashMap<Integer,List<Jugada>>();
		Map<Integer, List<Jugada>> solucionFinal = new HashMap<Integer,List<Jugada>>(); 
		int[] jugadores = new int[nroJugadoresTotal];
		
		for (int i = 1; i <= maxPosASaltar; i += 1) {
			List<Jugada> solucion = new ArrayList<Jugada>(); 
			int etapa = 1;
			for (int j = 0 ; j<nroJugadoresTotal; j +=1) {
				jugadores[j] = j;
			}
	
//			System.out.print ("Evaluando solución para ");
//			System.out.print( String.valueOf(i) + " maxPosASaltar");
//			System.out.println (" ");
//			
			boolean resultado = jugar(jugadores, posInicial, posJugadorGanador, i, etapa, solucion );
//			if (resultado) {
//				solucion.forEach(System.out::println);
//			}
//			else {
//				System.out.println("No hay solución para " + String.valueOf(i));
//			}
			solucionFinal.put(i, solucion);
			

//			System.out.println("--------------------");
//			System.out.println("    ");
		}
		

		
		
		
		
		return solucionFinal;
	}
	
	//el etapa me parece que tiene que ser un valor por referencia... analizarlo
	public boolean jugar (int[] jugadores, int posInicial, int posJugadorGanador, int maxPosASaltar, int etapa, List<Jugada> solucion) {
		if (jugadores.length == etapa) {
			if (jugadores[posInicial] == posJugadorGanador) {
				return true; 
				
			}
			else {
				return false; 
			}
		}
		else {
			etapa += 1;
			int nextPos = moverIzq(maxPosASaltar+1, jugadores, posInicial);
			int verificacion = jugadores[nextPos]; 
			if (verificacion == posJugadorGanador) return false; 
			jugadores[nextPos] = -1;
			//solucion.add("izquierda " + String.valueOf(verificacion));
			solucion.add(new Jugada("Izquierda", verificacion));
			boolean resIzq = jugar(jugadores, moverIzq(1, jugadores, nextPos), posJugadorGanador, maxPosASaltar, etapa, solucion);			if (resIzq) {
				//System.out.println("izquierda " + String.valueOf(verificacion));
				return true;
			} else {
				jugadores[nextPos] = verificacion; 
				solucion.remove(solucion.size()-1);
				
			}
			//jugadores[nextPos] = verificacion; 
			//solucion.remove(solucion.size()-1);
			
			//etapa -= 1;
			
			nextPos = moverDer(maxPosASaltar+1, jugadores, posInicial);
			verificacion = jugadores[nextPos]; 
			if (verificacion == posJugadorGanador) return false; 
			jugadores[nextPos] = -1; 
			solucion.add(new Jugada("Derecha", verificacion));
			//solucion.add("derecha " + String.valueOf(verificacion));
			//boolean resDer = jugar(jugadores, moverDer(1, jugadores, nextPos), posJugadorGanador, maxPosASaltar, etapa, solucion);
			boolean resDer = jugar(jugadores, moverDer(1, jugadores, nextPos), posJugadorGanador, maxPosASaltar, etapa, solucion);
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
	
	public int moverIzq(int posiciones, int[] jugadores, int posInicial) { 
		int i = 0;
		int j = posInicial; 
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
	
	public int moverDer(int posiciones, int[] jugadores, int posInicial) {
		int i = 0;
		int j = posInicial; 
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

	
	
}
