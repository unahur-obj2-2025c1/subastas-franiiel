package ar.edu.unahur.obj2.observer.observables;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observadores.Subastador;

class ProductoSubatadoTest {
	
	    private ProductoSubastado producto;
	    private Subastador gonzager;
	    private Subastador martomau;
	    private Subastador diazdan;

	    @BeforeEach
	    public void setUp() {
	        producto = new ProductoSubastado();

	        gonzager = new Subastador("gonzager", new Oferta(null, 0), producto);
	        martomau = new Subastador("martomau", new Oferta(null, 0), producto);
	        diazdan  = new Subastador("diazdan",  new Oferta(null, 0), producto);

	        producto.agregarSubastador(gonzager);
	        producto.agregarSubastador(martomau);

	        martomau.actualizar(new Oferta(martomau, 0));
	        martomau.realizarOferta(); 

	        
	        gonzager.actualizar(new Oferta(gonzager, 10));
	        gonzager.realizarOferta(); 

	        
	        martomau.actualizar(new Oferta(martomau, 20));
	        martomau.realizarOferta(); 
	    }

	    @Test
	    public void test1_subastadoresRecibenUltimaOferta() {
	        assertNotNull(gonzager);
	        assertNotNull(martomau);
	        assertEquals(30, gonzager.getUltimaOferta().getValor());
	        assertEquals(30, martomau.getUltimaOferta().getValor());
	    }

	    @Test
	    public void test2_ultimaOfertaEsDeMartomau() {
	        Oferta ultima = producto.ultimaOferta();
	        assertEquals("martomau", ultima.getSubastador().getUsuario());
	    }

	    @Test
	    public void test3_valorUltimaOfertaEs30() {
	        Oferta ultima = producto.ultimaOferta();
	        assertEquals(30, ultima.getValor());
	    }

	    @Test
	    public void test4_cantidadDeOfertasEs3() {
	        assertEquals(3, producto.getOfertasRecibidas().size());
	    }

	    @Test
	    public void test5_ofertaDeDiazdanLanzaExcepcion() {
	        Exception e = assertThrows(OfertaSubastadorException.class, () -> {
	            diazdan.realizarOferta();
	        });
	        assertEquals("El subastador no participa en la subasta", e.getMessage());
	    }
	}



