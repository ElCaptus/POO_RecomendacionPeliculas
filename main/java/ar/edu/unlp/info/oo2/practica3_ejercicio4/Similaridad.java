package ar.edu.unlp.info.oo2.practica3_ejercicio4;

import java.util.List;
import java.util.stream.Collectors;

public class Similaridad extends EstrategiaDeRecomendacion{

	@Override
	public List<Pelicula> peliculasRecomendadas(List<Pelicula> peliculas) {
		return peliculas.stream().filter(pelis ->{
			return pelis.visto();
		}).map(peliVista ->{
			return peliVista.getListaSimilares();
		}).flatMap(List::stream)
				.filter(pelis ->{
					return !pelis.visto();
				})
				.distinct()
				.collect(Collectors.toList());
	}

}
