package controlador;

import vista.VentanaPrincipal;

public class Main {

	public static void main(String[] args) {
		VentanaPrincipal miVentana = new VentanaPrincipal(); //llamada al objeto VentanaPrincipal
		ManejadorEventos manejador = new ManejadorEventos ();
		manejador.ConstructorManejadorEventos(miVentana);
		miVentana.establecerManejador(manejador);
	}

}
