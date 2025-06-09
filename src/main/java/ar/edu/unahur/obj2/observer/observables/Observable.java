package ar.edu.unahur.obj2.observer.observables;

import ar.edu.unahur.obj2.observer.observadores.Subastador;

public interface Observable {
	void agregarSubastador(Subastador subastador);

    void quitarSubastador(Subastador subastador);

    void notificar();

}
