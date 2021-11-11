package tpo.principal;

import java.util.List;
import java.util.Map;

public interface ResolverProblemaInterface {

	public Map<Integer,List<Jugada>> resolverJuego(int nroJugadoresTotal, int posInicial, int posJugadorGanador, int maxPosASaltar); 

	
}
