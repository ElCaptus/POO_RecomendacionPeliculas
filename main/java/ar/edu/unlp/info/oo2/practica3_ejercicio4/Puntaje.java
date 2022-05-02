package ar.edu.unlp.info.oo2.practica3_ejercicio4;

import java.util.Collections;
import java.util.List;

public class Puntaje extends EstrategiaDeRecomendacion{

	@Override
	public List<Pelicula> peliculasRecomendadas(List<Pelicula> peliculas) {
		Collections.sort(peliculas, (peli1, peli2)->{
			double difPuntaje = peli1.getPuntaje() - peli2.getPuntaje();
			if (difPuntaje > 0){				
				return -1;
			} else if(difPuntaje < 0) {
				return 1;
			}
			if(peli2.getAnioDeEstreno() - peli1.getAnioDeEstreno() == 0 ) {
				return peli1.getNombre().compareTo(peli2.getNombre());
			}
			return peli2.getAnioDeEstreno() - peli1.getAnioDeEstreno();
		});
		return peliculas;
	}

}
