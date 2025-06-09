package ar.edu.unahur.obj2.observer.observables;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observadores.Arriesgado;
import ar.edu.unahur.obj2.observer.observadores.Estrategia;
import ar.edu.unahur.obj2.observer.observadores.Limite;
import ar.edu.unahur.obj2.observer.observadores.Subastador;
import ar.edu.unahur.obj2.observer.observadores.Unico;

class ProductoSubatadoTest {
	
	    private ProductoSubastado producto;
	    private Subastador gonzager;
	    private Subastador martomau;
	    private Subastador diazdan;
	    private Estrategia limite;
	    private Estrategia arriesgado;
	    private Estrategia unico;

	    @BeforeEach
	    public void setUp() {
	        producto = new ProductoSubastado();
	        limite = new Limite(40);
	        arriesgado = new Arriesgado();
	        unico = new Unico();
	        

	        gonzager = new Subastador("gonzager", new Oferta(null, 0), producto, limite);
	        martomau = new Subastador("martomau", new Oferta(null, 0), producto, limite);
	        diazdan  = new Subastador("diazdan",  new Oferta(null, 0), producto, unico);

	        producto.agregarSubastador(gonzager);
	        producto.agregarSubastador(martomau);

	        martomau.realizarOferta(); 
	        gonzager.realizarOferta(); 
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
	    
	    @Test
	    public void test6_cambioDeTipoDeLimiteHaciaArriesgadoLaUltimaOfertaDebeSer50() {
	    	gonzager.nuevoTipoSubastador(arriesgado);
	    	gonzager.realizarOferta();
	    	Oferta ultima = producto.ultimaOferta();
		    assertEquals(50, ultima.getValor());
	    }
	    @Test
	    public void test6_SubastadorTipoUnicoRealizarMasDe1OfertaLanzaExcepcion() {
	    	producto.agregarSubastador(diazdan);
	    	diazdan.realizarOferta();
	    	 
	    	
	    	 Exception e = assertThrows(RuntimeException.class, () -> {
		            diazdan.realizarOferta();
		        });
	    	 assertEquals("El subastador ya realizo una oferta", e.getMessage());
	    }
	}



