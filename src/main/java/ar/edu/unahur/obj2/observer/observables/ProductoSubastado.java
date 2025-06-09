package ar.edu.unahur.obj2.observer.observables;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observadores.Observer;
import ar.edu.unahur.obj2.observer.observadores.Subastador;

public class ProductoSubastado implements Observable{
	private Set<Subastador> subastadores = new HashSet<>();
	private List<Oferta> ofertasRecibidas = new LinkedList<>();
	
	
	
	
	public void agregarOferta(Oferta nuevaOferta) {
		if(!this.existeSubastador(nuevaOferta.getSubastador())) {
			throw new OfertaSubastadorException("El subastador no participa en la subasta");
		}
		getOfertasRecibidas().add(nuevaOferta);
		this.notificar();
	}
	public Oferta ultimaOferta() {
		return getOfertasRecibidas().get(getOfertasRecibidas().size()-1);
		
	}
	public Boolean existeSubastador(Subastador subastador) {
		return subastadores.stream().map(s -> s.getUsuario().toLowerCase())
				.anyMatch(s -> s.equals(subastador.getUsuario().toLowerCase()));
		
	}
	
	public void agregarSubastador(Subastador nuevoSubastador) {
		subastadores.add(nuevoSubastador);
		
	}

	
	public void quitarSubastador(Subastador subastador) {
		subastadores.remove(subastador);
		
	}


	public void notificar() {
		subastadores.forEach(s -> s.actualizar(this.ultimaOferta()));
		
	}
	public List<Oferta> getOfertasRecibidas() {
		return ofertasRecibidas;
	}
	

}
