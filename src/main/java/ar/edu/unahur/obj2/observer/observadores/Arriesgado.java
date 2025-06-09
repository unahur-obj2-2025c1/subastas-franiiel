package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;

public class Arriesgado implements Estrategia {
	
	public Arriesgado() {}

	@Override
	public Oferta getEstrategia(Subastador subastador, Integer valor) {
		return new Oferta(subastador, valor + 10);
	}

}
