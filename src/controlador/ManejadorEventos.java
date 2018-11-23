package controlador;

import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import vista.VentanaPrincipal;

public class ManejadorEventos implements ActionListener {
	
	private VentanaPrincipal ventana;
	private String texto1;
	private String texto2;
	private double num1;
	private double num2;
	private double suma;
	private double resta;
	private double multiplica;
	private double divide;
	private String pass = "";
	
	// Constructor
	public void ConstructorManejadorEventos(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}
	
	
	@Override
	public void actionPerformed (ActionEvent e) {
		// le damos valor a las variables texto1 y texto2, el contenido de la s cajas de texto
		setTexto1(ventana.getCajaTexto1().getText());
		setTexto2(ventana.getCajaTexto2().getText());
		
		try {
			//le asignamos a las variables num1 y num2 el texto de la primera y segunda caja de texto
			num1 = Double.parseDouble(getTexto1());
			num2 = Double.parseDouble(getTexto2());
			
			if ( (texto1.length() >= 10) || (texto2.length() >= 10) ) {	//comprobamos si los números introducidos tien igual o mas de diez caracteres
				ventana.getResultado2().setText("Número demasiado grande");
				ventana.getResultado().setText("");
			}
			else {
				// si lo seleccionado en la ventana "e.getSource()", es igual al botón selecionado de la ventana principal.
				
				if(e.getSource()==ventana.getBotonSumar()) { 		//comprotamiento del boton +
					sumar();
				}
				if(e.getSource()==ventana.getBotonRestar()) {		//comprotamiento del boton -
					restar();
				}
				if(e.getSource()==ventana.getBotonMultiplicar()) {		//comprotamiento del boton *
					multiplicar();
				}
				if(e.getSource()==ventana.getBotonDividir()) {		//comprotamiento del boton ÷
					dividir();
				}
			
			}
	
		}
		catch(NumberFormatException ex) { // Excepción de caracteres no numéricos
			
			// He puesto el IF en la excepción porque sinó siempre me saltaba antes la excepción, que la comprobación IF en las operaciones
			if ( texto1 == null || texto1.isEmpty() || texto2 == null || texto2.isEmpty()) { //comprobamos si se han introducido los dos números para la operación
				ventana.getResultado2().setText("Te falta algun número");
				ventana.getResultado().setText("");
			}
			else {
				ventana.getResultado2().setText("No son números");
				ventana.getResultado().setText("");
			}
		}
		
		// hacemos un try nuevo par que no sea capturada la excepción con la condición de rellenar las dos cajas de texto, y poder así hacer la raíz con un solo número.
		try {	
			if(e.getSource()==ventana.getBotonRaiz2()) {	//comprotamiento del boton ²√
				raizCuadrada();
			}				
			if(e.getSource()==ventana.getBotonRaiz3()) {	//comprotamiento del boton ³√
				caizCubica();
			}
	
			
		}
		catch(Exception ex) { 
			ventana.getResultado2().setText("Error");
			ventana.getResultado().setText("");
		}
		
		ventana.getCajaTexto1().requestFocus(); //colocamos el cursor en CajaTexto1
		
	}
	

	public void sumar() {
		ventana.getResultado().setText(String.valueOf(suma())); // le damos a la etiqueta 'resultado' de la ventana principal, el valor de la operación dada por el método suma()
		ventana.getResultado2().setText(num1+" + "+num2+" = "); // ponemos en la etiqueta 'operacion' de la ventana principal, la operación que estamos realizando.
	}	
	
	public void restar() {
		ventana.getResultado().setText(String.valueOf(resta()));
		ventana.getResultado2().setText(num1+" - "+num2+" = ");
	}	
	
	public void multiplicar() {
		ventana.getResultado().setText(String.valueOf(multiplica()));
		ventana.getResultado2().setText(num1+" x "+num2+" = ");
	}	
	
	public void dividir() {
		if((getNum1() == 0) || (getNum2()) == 0) { // comprobamos si el dividendo o el divisor es cero
			ventana.getResultado2().setText("No se puede dividir entre cero");
			ventana.getResultado().setText("");
		}
		else {
			ventana.getResultado().setText(String.valueOf(divide()));
			ventana.getResultado2().setText(num1+" ÷ "+num2+" = ");
		}
	}
	
	public void raizCuadrada() {
		//si la caja de texto 2 esta vacía
		if((texto2 == null || texto2.isEmpty())) { 
			ventana.getResultado().setText(String.valueOf(Math.pow(num1, 1.0/2.0)));  // Math.pow(num, 1.0/3.0) para calcular la raiz cúbica
			ventana.getResultado2().setText(" ²√"+num1+" = ");
		}
		//si la caja de texto 1 esta vacía
		if((texto1 == null || texto1.isEmpty())) {
			ventana.getResultado().setText(String.valueOf(Math.pow(num2, 1.0/2.0))); 
			ventana.getResultado2().setText(" ²√"+num1+" = ");
		}
		//si hemos introducido dos números
		if(!(texto2 == null || texto2.isEmpty()) && !(texto1 == null || texto1.isEmpty())) { 
			ventana.getResultado2().setText("Introduce un solo número");
			ventana.getResultado().setText("");
		}
		
		// Comprotamiento del boton raiz 2 con ventana de menaje de información
		// JOptionPane.showMessageDialog(null, "FUNCIONALIDAD NO DISPONIBLE", "Raiz cuadrada", JOptionPane.INFORMATION_MESSAGE);
		//²√
	}
	
	public void caizCubica() {
		pass = String.valueOf(JOptionPane.showInputDialog(null, "CONTRASEÑA: ", "Raiz cúbica", JOptionPane.QUESTION_MESSAGE)); // le asignamos a la variable 'pass' el valor de la clave introducida
		//si la clave es correcta
		if(pass.equals("123")) { 
			//si la caja de texto 2 esta vacía
			if((texto2 == null || texto2.isEmpty())) { 
				ventana.getResultado().setText(String.valueOf(Math.pow(num1, 1.0/3.0)));  // Math.pow(num, 1.0/3.0) para calcular la raiz cúbica
				ventana.getResultado2().setText(" ³√"+num1+" = ");
			}
			//si la caja de texto 1 esta vacía
			if((texto1 == null || texto1.isEmpty())) {
				ventana.getResultado().setText(String.valueOf(Math.pow(num2, 1.0/3.0))); 
				ventana.getResultado2().setText(" ³√"+num1+" = ");
			}
			//si hemos introducido dos números
			if(!(texto2 == null || texto2.isEmpty()) && !(texto1 == null || texto1.isEmpty())) { 
				ventana.getResultado2().setText("Introduce un solo número");
				ventana.getResultado().setText("");
			}
		}
		//si la clace no es correcta
		if (!pass.equals("123")) {
			ventana.getResultado2().setText(String.valueOf("Contraseña errónea"));
			ventana.getResultado().setText("");
		}
	}

	// Metodos donde se realizan las operaciones
	public double suma() {
		return num1 + num2;
	}
	
	public double resta() {
		return num1 - num2;
	}
	
	public double multiplica() {
		return num1 * num2;
	}
	
	public double divide() {
		return num1 / num2;
	}
	
	
	
	// Métodos Get y Set
	
	public double getNum1() {
		return num1;
	}

	public void setNum1(double num1) {
		this.num1 = num1;
	}

	public double getNum2() {
		return num2;
	}

	public void setNum2(double num2) {
		this.num2 = num2;
	}

	public double getSuma() {
		return suma;
	}

	public void setSuma(long suma) {
		this.suma = suma;
	}

	public double getResta() {
		return resta;
	}

	public void setResta(long resta) {
		this.resta = resta;
	}

	public double getMultiplica() {
		return multiplica;
	}

	public void setMultiplica(long multiplica) {
		this.multiplica = multiplica;
	}

	public double getDivide() {
		return divide;
	}

	public void setDivide(double divide) {
		this.divide = divide;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getTexto1() {
		return texto1;
	}

	public void setTexto1(String texto1) {
		this.texto1 = texto1;
	}

	public String getTexto2() {
		return texto2;
	}

	public void setTexto2(String texto2) {
		this.texto2 = texto2;
	}
	
	
}