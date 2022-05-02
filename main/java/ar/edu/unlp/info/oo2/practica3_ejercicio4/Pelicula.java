package ar.edu.unlp.info.oo2.practica3_ejercicio4;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Pelicula {
	private String nombre;
	private double puntaje;
	private int anioDeEstreno;
	private boolean visto;
	private List<Pelicula> similares;
	
	public Pelicula(String nombre, double puntaje, int anioDeEstreno) {
		super();
		this.nombre = nombre;
		this.puntaje = puntaje;
		this.anioDeEstreno = anioDeEstreno;
		this.visto = false;
		this.similares = new ArrayList<Pelicula>();
	}
	
	public void ver() {
		this.visto = true;
	}
	
	public boolean visto() {
		return this.visto;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(double puntaje) {
		this.puntaje = puntaje;
	}

	public int getAnioDeEstreno() {
		return anioDeEstreno;
	}
	
	public List<Pelicula> getListaSimilares(){
		return this.similares;
	}

	public String getSimilares() {
		
		return similares.stream().map(pelicula -> {
			return pelicula.getNombre();
		}).collect(Collectors.joining(", "));
		
	}
 
	public void addSimilar(Pelicula pelicula) {
		if (pelicula.equals(this))
			return;
		if(!similares.contains(pelicula)) {
			similares.add(pelicula);
			similares.stream().forEach(peliculita ->{
				peliculita.addSimilar(pelicula);
			});
			pelicula.addSimilar(this);
		}
		
	}
	
	public void deleteSimilar(String nombrePelicula) {
		Pelicula pelicula = similares.stream().filter(peliculita ->{
			return peliculita.getNombre()== nombrePelicula;
		}).findFirst().orElse(null);
		if(!pelicula.equals(null)) {
			this.deleteSimilar(pelicula);
		}
	}
	
	public void deleteSimilar(Pelicula pelicula) {
		if(pelicula.equals(this)) {
			return;
		}
		if(similares.contains(pelicula)) {
			similares.remove(pelicula);
			similares.stream().forEach(peliculita ->{
				peliculita.deleteSimilar(pelicula);
			});
			pelicula.deleteSimilar(this);
		}
	}
	
	@Override
	public String toString() {
		return String.format(Locale.ENGLISH,"%s, %,.1f, %s, (Similar a: %s)",this.getNombre(),this.getPuntaje(), this.getAnioDeEstreno(), this.getSimilares());
	}
}











