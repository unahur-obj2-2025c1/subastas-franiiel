package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observables.ProductoSubastado;

public class Subastador implements Observer {
	private String usuario;
	private Oferta ultimaOferta;
	private ProductoSubastado producto;
	private Estrategia tipoSubastador;
	
	public Subastador(String nombre, Oferta ultimaOferta, ProductoSubastado producto, Estrategia tipoSubastador) {
		this.usuario = nombre;
		this.ultimaOferta = ultimaOferta;
		this.producto = producto;
		this.tipoSubastador = tipoSubastador;	
		}
	public String getUsuario() {
		return usuario;
	}
	public void realizarOferta() {
		producto.agregarOferta(tipoSubastador.getEstrategia(this, ultimaOferta.getValor() + 10));
	}
	
	@Override
	public void actualizar(Oferta nuevaOferta) {
		ultimaOferta = nuevaOferta;
	}
	public Oferta getUltimaOferta() {
		
		return ultimaOferta;
	}
	
	public void nuevoTipoSubastador(Estrategia nuevoTipo) {
		this.tipoSubastador = nuevoTipo;
	}
	
}
