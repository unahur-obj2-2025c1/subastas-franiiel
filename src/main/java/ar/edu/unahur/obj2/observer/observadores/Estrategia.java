package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;

public interface Estrategia {
	Oferta getEstrategia(Subastador subastador, Integer valor);

}
