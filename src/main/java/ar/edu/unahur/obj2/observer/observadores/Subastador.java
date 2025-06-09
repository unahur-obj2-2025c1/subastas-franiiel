package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observables.ProductoSubastado;

public class Subastador implements Observer {
	private String usuario;
	private Oferta ultimaOferta;
	private ProductoSubastado producto;
	
	public Subastador(String nombre, Oferta ultimaOferta, ProductoSubastado producto) {
		this.usuario = nombre;
		this.ultimaOferta = ultimaOferta;
		this.producto = producto;
	}
	public String getUsuario() {
		return usuario;
	}
	public void realizarOferta() {
		producto.agregarOferta(new Oferta(this, ultimaOferta.getValor() + 10));
	}
	
	@Override
	public void actualizar(Oferta nuevaOferta) {
		ultimaOferta = nuevaOferta;
	}
	public Oferta getUltimaOferta() {
		
		return ultimaOferta;
	}

}
