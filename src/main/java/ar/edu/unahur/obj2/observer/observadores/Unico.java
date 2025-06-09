package ar.edu.unahur.obj2.observer.observadores;

import java.util.HashSet;
import java.util.Set;

import ar.edu.unahur.obj2.observer.Oferta;

public class Unico implements Estrategia {
	private Set<Subastador> subastadores = new HashSet<>(); ;
	
	public Unico() {
	}
	
	public Oferta getEstrategia(Subastador subastador, Integer valor) {
		if (subastadores.contains(subastador)) {
			throw new RuntimeException("El subastador ya realizo una oferta");
		}
		
		subastadores.add(subastador);
		return new Oferta(subastador, valor);
		
	}

}
