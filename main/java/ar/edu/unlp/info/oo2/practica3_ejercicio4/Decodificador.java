package ar.edu.unlp.info.oo2.practica3_ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class Decodificador {
	
	private List<Pelicula> peliculas;
	private EstrategiaDeRecomendacion estrategia;
	
	public Decodificador(List<Pelicula> peliculas) {
		this.peliculas = new ArrayList<Pelicula>(peliculas);
		this.estrategia = new Similaridad();
	}
	
	public Decodificador() {
		this.peliculas = new ArrayList<Pelicula>();
	}
	
	public void reproducir(Pelicula pelicula) {
		pelicula.ver();
	}
	
	public String recomendar() {
		return estrategia.recomendar(this.peliculas);
	}

	public void cambiarEstrategiaNovedad() {
		this.estrategia = new Novedad();
	}
	
	public void cambiarEstrategiaSimilaridad() {
			this.estrategia = new Similaridad();
	}
	
	public void cambiarEstrategiaPuntaje() {
		this.estrategia = new Puntaje();
	}

}
