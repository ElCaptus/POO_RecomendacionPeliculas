package ar.edu.unlp.info.oo2.practica3_ejercicio4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DecodificadorTest {
	
	Pelicula peliThor;
	Pelicula peliCap;
	Pelicula peliDunk;
	Pelicula peliRocky;
	Pelicula peliRambo;
	Pelicula peliIronMan;
	
	Decodificador decodeCargado;
	
	@BeforeEach
	void setUp() throws Exception{
		peliThor = new Pelicula("Thor", 7.9, 2007); //(similar a capitanamerica e ironman)
		peliCap = new Pelicula("Capitan America", 7.8, 2016); //(similar a thor, ironman)
		peliIronMan = new Pelicula("Iron Man", 7.9, 2010); //(similar a thor, capitanamerica)
		peliDunk = new Pelicula("Dunkirk", 7.9, 2017);
		peliRocky = new Pelicula("Rocky", 8.1, 1976); //(similar a rambo)
		peliRambo = new Pelicula("Rambo", 7.8, 1979); //(similar a rocky)
		
		peliThor.addSimilar(peliCap);
		peliThor.addSimilar(peliIronMan);
		
		peliRambo.addSimilar(peliRocky);
		
		List<Pelicula> peliculas = new ArrayList<Pelicula>() {
			{add(peliThor);
			add(peliCap); 
			add(peliIronMan);
			add(peliDunk); 
			add(peliRocky); 
			add(peliRambo);
			}
		};
		
		decodeCargado = new Decodificador(peliculas);
		
		decodeCargado.reproducir(peliRocky);
		decodeCargado.reproducir(peliThor);
	}
	
	@Test
	public void pelisSimilares() {
		assertEquals("Capitan America, Iron Man", peliThor.getSimilares());
		assertEquals("Thor, 7.9, 2007, (Similar a: Capitan America, Iron Man)", peliThor.toString());
		
		assertEquals("Capitan America, Thor", peliIronMan.getSimilares());
		assertEquals("", peliDunk.getSimilares());
		assertEquals("Rambo", peliRocky.getSimilares());
	}
	
	@Test
	public void borrarPeliculas() {
//		peliThor.deleteSimilar(peliCap);
//		assertEquals("Iron Man",peliThor.getSimilares());
		
		assertEquals("Rocky", peliRambo.getSimilares());
		peliRocky.deleteSimilar("Rambo");
		assertEquals("",peliRambo.getSimilares());
	}
	
	@Test
	public void recomendarPelis() {
		decodeCargado.cambiarEstrategiaNovedad();
		assertEquals("(i): Dunkirk, Capitan America, Iron Man", "(i): "+ decodeCargado.recomendar());
		
		decodeCargado.cambiarEstrategiaSimilaridad();
		assertEquals("(ii): Capitan America, Iron Man, Rambo", "(ii): "+ decodeCargado.recomendar());
		
		decodeCargado.cambiarEstrategiaPuntaje();
		assertEquals("(iii): Dunkirk, Iron Man, Capitan America", "(iii): "+ decodeCargado.recomendar());
	}

}
