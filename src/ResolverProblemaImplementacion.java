
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ResolverProblemaImplementacion implements ResolverProblemaInterface{
	
	public ArrayList<Jugada> resolverJuego(int nroJugadoresTotal, int posInicial, int posJugadorGanador, int maxPosASaltar) {
		
		ArrayList<Jugada> solucionFinal = new ArrayList<Jugada>();
		int[] jugadores = new int[nroJugadoresTotal];
		
		for (int i = 1; i <= maxPosASaltar; i += 1) {

			Jugada jugada = new Jugada();
			jugada.setMov(null);
			jugada.setPos(i);
		
			solucionFinal.add(jugada);
			int etapa = 1;
			for (int j = 0 ; j<nroJugadoresTotal; j +=1) {
				jugadores[j] = j;
			}
//			
			boolean resultado = jugar(jugadores, posInicial, posJugadorGanador, i, etapa, solucionFinal );
		}
		return solucionFinal;
	}
	
	public boolean jugar (int[] jugadores, int posInicial, int posJugadorGanador, int maxPosASaltar, int etapa, ArrayList<Jugada> solucion) {
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
			
			Jugada jugada = new Jugada();
			jugada.setMov(Movimiento.IZQ);
			jugada.setPos(verificacion);
			
			solucion.add(jugada);
			
			boolean resIzq = jugar(jugadores, moverIzq(1, jugadores, nextPos), posJugadorGanador, maxPosASaltar, etapa, solucion);		
			if (resIzq) {
				return true;
			} else {
				jugadores[nextPos] = verificacion; 
				solucion.remove(solucion.size()-1);	
			}
			
			nextPos = moverDer(maxPosASaltar+1, jugadores, posInicial);
			verificacion = jugadores[nextPos]; 
			if (verificacion == posJugadorGanador) return false; 
			jugadores[nextPos] = -1; 
			
			Jugada jugada2 = new Jugada();
			jugada2.setMov(Movimiento.DER);
			jugada2.setPos(verificacion);
			
			solucion.add(jugada2);
			
			boolean resDer = jugar(jugadores, moverDer(1, jugadores, nextPos), posJugadorGanador, maxPosASaltar, etapa, solucion);
			if (resDer) {
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
