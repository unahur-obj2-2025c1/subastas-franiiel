package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observables.ProductoSubastado;

public class Limite implements Estrategia{
	private Integer limiteOferta;
	
	public Limite(Integer limiteOferta) {
		this.limiteOferta = limiteOferta;
	}

	@Override
	public Oferta getEstrategia(Subastador subastador, Integer valor) {
		if(valor > limiteOferta) {
			throw new RuntimeException("El valor supera el limite de oferta");
		}
		return new Oferta(subastador, valor);
	}

	public Integer getLimiteOferta() {
		return limiteOferta;
	}

	}

