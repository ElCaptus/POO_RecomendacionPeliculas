package ar.edu.unlp.info.oo2.practica3_ejercicio4;

import java.util.List;
import java.util.stream.Collectors;

//patron Strategy
public abstract class EstrategiaDeRecomendacion {
	
	//patron Template
	public String recomendar(List<Pelicula> peliculas) {
		return this.peliculasRecomendadas(peliculas).stream().filter(pelicula -> {
			return !pelicula.visto();
		}).map(pelicula -> {
			return pelicula.getNombre();
		}).limit(3).collect(Collectors.joining(", "));
	}
	public abstract List<Pelicula> peliculasRecomendadas(List<Pelicula> peliculas);
}
