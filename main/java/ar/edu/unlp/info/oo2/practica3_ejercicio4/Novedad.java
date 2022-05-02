package ar.edu.unlp.info.oo2.practica3_ejercicio4;

import java.util.Collections;
import java.util.List;

public class Novedad extends EstrategiaDeRecomendacion {

	@Override
	public List<Pelicula> peliculasRecomendadas(List<Pelicula> peliculas) {
		Collections.sort(peliculas, (peli1, peli2)->{
			int anioDiff = peli2.getAnioDeEstreno() - peli1.getAnioDeEstreno();
			if (anioDiff == 0) {
				return peli1.getNombre().compareTo(peli2.getNombre());
			}
			return anioDiff;
		});
		return peliculas;
	}

}
