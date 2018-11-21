package vista;


import javax.swing.JFrame; //librería de ventanas

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Toolkit; //librería de inagen
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton; //librería de botones
import javax.swing.JLabel; //librería de etiquetas
import javax.swing.JTextField; //librería de cajas de texto
import javax.swing.SwingConstants;

import controlador.ManejadorEventos;


public class VentanaPrincipal extends JFrame {
	
	//todas las propiedades de la ventana son de la clase y se referencian al principio
	private JLabel numero1, numero2, resultado, operacion, imgReset, imgContinuar;
	private JTextField cajaTexto1, cajaTexto2;
	private JButton botonSumar, botonRestar, botonMultiplicar, botonDividir, botonRaiz2, botonRaiz3;
	private Font font1, font2;
	private Image imgCerebroReset, imgCerebroReset2, imgCerebroReset3, imgCerebroContinuar, imgCerebroContinuar2, imgCerebroContinuar3;



	//clase principal
	public VentanaPrincipal () {		
		setSize(450,580); //anchura y altura de la ventana
		setLocationRelativeTo(null);  //colocamos la ventana en el centro de la pantalla
		//lo anterior pordía sustituirse por: setBounds(x, y, w, h); indicandole la anchura, la altura de la ventana y su posicionamiento con dos valores
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //comportamiento de la ventana al cerrarse, en este caso cierrra la ventana y finaliza
		setResizable(false);  //fija el tamañode la ventana
		setLayout(null); // desactiva el organizador de objetos en la ventana (los estamos colocando manualmente)
		
		setTitle("Calculadora"); //titulo de la ventana
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/IconoCalculadora.png")); //icono de la ventana		
		
		inicializarComponentes();
		
		setVisible(true); //visibilidad de la ventana				
	}
	
	private void inicializarComponentes() {
		
		getContentPane().setBackground(new Color(164,202,212)); //color de fondo de la ventana
		
		try {
			fuenteCalculadora1();
			//Font font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("alarm clock.ttf"));
			numero1 = new JLabel("Número 1:"); // constructor del elemento
			numero1.setBounds(30, 50, 250, 40); //posición y dimensiones del elemento
			numero1.setFont(font2.deriveFont(Font.BOLD, 28f)); // fuente, estilo y tamaño de letra
			numero1.setForeground(new Color(15,51,99)); //color de la letra
			add(numero1); //añadimos el elemento a la ventana
		
			fuenteCalculadora1();	
			numero2 = new JLabel("Número 2:");
			numero2.setBounds(30, 120, 250, 40);
			numero2.setFont(font2.deriveFont(Font.BOLD, 28f));
			numero2.setForeground(new Color(15,51,99));
			add(numero2);

			cajaTexto1 = new JTextField();
			cajaTexto1.setBounds(200, 50, 210, 40);
			cajaTexto1.setBorder(null); //quita el borde de la caja de texto
			cajaTexto1.setFont(font1.deriveFont(Font.BOLD, 30f));
			cajaTexto1.setForeground(new Color(131,4,231));
			cajaTexto1.setBackground(new Color(164,202,212));
			add(cajaTexto1);
			
			cajaTexto2 = new JTextField();
			cajaTexto2.setBounds(200, 120, 210, 40);
			cajaTexto2.setBorder(null);
			cajaTexto2.setFont(font1.deriveFont(Font.BOLD, 30f));
			cajaTexto2.setForeground(new Color(131,4,231));
			cajaTexto2.setBackground(new Color(164,202,212));
			add(cajaTexto2);
	
			Image imgSuma = new ImageIcon("img/03_imgSuma.png").getImage();
			Image imgSuma1 = new ImageIcon("img/05_imgSuma.png").getImage();
			botonSumar = new JButton((new ImageIcon(imgSuma.getScaledInstance(80, 80, Image.SCALE_SMOOTH))));
			botonSumar.setBounds(30, 200, 80, 80);
			botonSumar.setBorder(null);
			add(botonSumar);
			
			//botonSumar.setFont(new Font("Roboto", Font.BOLD,18)); //nombre de la fuente, tipo y tamaño
			//botonSumar.setForeground(new Color(20,67,240)); //color de la fuente
			//botonSumar.setBackground(new Color(212,221,255)); // color de fondo del boton
			
			//comportamiento del botón cuando interactuamos con él
			botonSumar.addMouseListener(new MouseListener() {
							
				@Override
				public void mouseReleased(MouseEvent e) { //comportamiento del botón al no interactuar con él
					botonSumar.setIcon(new ImageIcon(imgSuma.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));				
				}
				
				@Override
				public void mousePressed(MouseEvent e) { //comportamiento del botón al pulsarlo
					botonSumar.setIcon(new ImageIcon(imgSuma1.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
					
					// el botón Cerebro-Reset cambia de color cuando activamos el boton suma
					//imgReset.setIcon(new ImageIcon(imgCerebroReset3.getScaledInstance(80, 80, Image.SCALE_SMOOTH))); 
				}
				
				@Override
				public void mouseExited(MouseEvent e) { //comportamiento del botón al salir el ratón de encima
					botonSumar.setIcon(new ImageIcon(imgSuma.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));				
				}
				
				@Override
				public void mouseEntered(MouseEvent e) { //comportamiento del botón teniendo el ratón encima
					botonSumar.setIcon(new ImageIcon(imgSuma1.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));				
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub				
				}
			});	
		
			Image imgResta = new ImageIcon("img/03_imgResta.png").getImage();
			Image imgResta1 = new ImageIcon("img/05_imgResta.png").getImage();
			botonRestar = new JButton((new ImageIcon(imgResta.getScaledInstance(80, 80, Image.SCALE_SMOOTH))));
			botonRestar.setBounds(130, 200, 80, 80);
			botonRestar.setBorder(null);
			add(botonRestar);
			
			botonRestar.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					botonRestar.setIcon(new ImageIcon(imgResta.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));				
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					botonRestar.setIcon(new ImageIcon(imgResta1.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));			
					//imgReset.setIcon(new ImageIcon(imgCerebroReset3.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
				}
				
				@Override
				public void mouseExited(MouseEvent e) { 
					botonRestar.setIcon(new ImageIcon(imgResta.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));				
				}
				
				@Override
				public void mouseEntered(MouseEvent e) { 
					botonRestar.setIcon(new ImageIcon(imgResta1.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));				
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub				
				}
			});			

			Image imgMultiplica = new ImageIcon("img/03_imgMultiplica.png").getImage();
			Image imgMultiplica1 = new ImageIcon("img/05_imgMultiplica.png").getImage();
			
			botonMultiplicar = new JButton((new ImageIcon(imgMultiplica.getScaledInstance(80, 80, Image.SCALE_SMOOTH))));
			botonMultiplicar.setBounds(230, 200, 80, 80);
			botonMultiplicar.setBorder(null);
			add(botonMultiplicar);
			
			botonMultiplicar.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					botonMultiplicar.setIcon(new ImageIcon(imgMultiplica.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));				
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					botonMultiplicar.setIcon(new ImageIcon(imgMultiplica1.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));			
					//imgReset.setIcon(new ImageIcon(imgCerebroReset3.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					botonMultiplicar.setIcon(new ImageIcon(imgMultiplica.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));				
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					botonMultiplicar.setIcon(new ImageIcon(imgMultiplica1.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));				
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub				
				}
			});	

			
			Image imgDivide = new ImageIcon("img/03_imgDivide.png").getImage();
			Image imgDivide1 = new ImageIcon("img/05_imgDivide.png").getImage();
			botonDividir = new JButton((new ImageIcon(imgDivide.getScaledInstance(80, 80, Image.SCALE_SMOOTH))));
			botonDividir.setBounds(330, 200, 80, 80);
			botonDividir.setBorder(null);
			add(botonDividir);
			
			botonDividir.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					botonDividir.setIcon(new ImageIcon(imgDivide.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));				
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					botonDividir.setIcon(new ImageIcon(imgDivide1.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));			
					//imgReset.setIcon(new ImageIcon(imgCerebroReset3.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
				}
				
				@Override
				public void mouseExited(MouseEvent e) { //comportamiento de la imagen sin tener el ratón encima
					botonDividir.setIcon(new ImageIcon(imgDivide.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));				
				}
				
				@Override
				public void mouseEntered(MouseEvent e) { //comportamiento de la imagen teniendo el ratón encima
					botonDividir.setIcon(new ImageIcon(imgDivide1.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));				
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub				
				}
			});	


			Image imgRaizCuadrada = new ImageIcon("img/03_imgRaizCuadrada.png").getImage();
			Image imgRaizCuadrada1 = new ImageIcon("img/05_imgRaizCuadrada.png").getImage();
			botonRaiz2 = new JButton((new ImageIcon(imgRaizCuadrada.getScaledInstance(80, 80, Image.SCALE_SMOOTH))));
			botonRaiz2.setBounds(40, 300, 80, 80);
			botonRaiz2.setBorder(null);
			add(botonRaiz2);
			
			botonRaiz2.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					botonRaiz2.setIcon(new ImageIcon(imgRaizCuadrada.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));				
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					botonRaiz2.setIcon(new ImageIcon(imgRaizCuadrada1.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));			
					//imgReset.setIcon(new ImageIcon(imgCerebroReset3.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					botonRaiz2.setIcon(new ImageIcon(imgRaizCuadrada.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));				
				}
				
				@Override
				public void mouseEntered(MouseEvent e) { //comportamiento de la imagen teniendo el ratón encima
					botonRaiz2.setIcon(new ImageIcon(imgRaizCuadrada1.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));				
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub				
				}
			});	
			
			
			Image imgRaizCubica = new ImageIcon("img/03_imgRaizCubica.png").getImage();
			Image imgRaizCubica1 = new ImageIcon("img/05_imgRaizCubica.png").getImage();
			botonRaiz3 = new JButton((new ImageIcon(imgRaizCubica.getScaledInstance(80, 80, Image.SCALE_SMOOTH))));
			botonRaiz3.setBounds(140, 300, 80, 80);
			botonRaiz3.setBorder(null);
			add(botonRaiz3);
			
			botonRaiz3.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					botonRaiz3.setIcon(new ImageIcon(imgRaizCubica.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));				
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					botonRaiz3.setIcon(new ImageIcon(imgRaizCubica1.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
					//imgReset.setIcon(new ImageIcon(imgCerebroReset3.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
				}
				
				@Override
				public void mouseExited(MouseEvent e) { 
					botonRaiz3.setIcon(new ImageIcon(imgRaizCubica.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));				
				}
				
				@Override
				public void mouseEntered(MouseEvent e) { 
					botonRaiz3.setIcon(new ImageIcon(imgRaizCubica1.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));				
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub				
				}
			});	
			
			// etiqueta JLabel que contiene la imagen CerebroReset
			imgCerebroReset = new ImageIcon("img/imgBorrar.png").getImage();
			imgReset = new JLabel(new ImageIcon(imgCerebroReset.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));  // le damos el mismo tamaño que a la etiqueta a la imagen
			imgReset.setBounds(350, 300, 80, 80);
			add(imgReset);
			
			imgCerebroReset2 = new ImageIcon("img/imgBorrar3.png").getImage();
			
			imgReset.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					imgReset.setIcon(new ImageIcon(imgCerebroReset.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));				
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					imgReset.setIcon(new ImageIcon(imgCerebroReset2.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));	
					//cambiamos el contenido de las cajas de texto y de las etiquetas operación y resultado, cuando pulsamos el boton reset
					operacion.setText(""); 
					resultado.setText("");
					cajaTexto1.setText("");
					cajaTexto2.setText("");
					cajaTexto1.requestFocus(); //colocamos el cursor en numero 1
				}
				
				@Override
				public void mouseExited(MouseEvent e) { 
					imgReset.setIcon(new ImageIcon(imgCerebroReset.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));				
				}
				
				@Override
				public void mouseEntered(MouseEvent e) { 
					imgReset.setIcon(new ImageIcon(imgCerebroReset2.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));				
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub				
				}
			});

			
			// etiqueta JLabel que contiene la imagen CerebroContinuar
			imgCerebroContinuar = new ImageIcon("img/01_imgContinuar.png").getImage();
			imgContinuar = new JLabel(new ImageIcon(imgCerebroContinuar.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));  // le damos el mismo tamaño que a la etiqueta a la imagen
			imgContinuar.setBounds(250, 300, 80, 80);
			add(imgContinuar);
			
			imgCerebroContinuar2 = new ImageIcon("img/04_imgContinuar.png").getImage();
			imgCerebroContinuar3 = new ImageIcon("img/05_imgContinuar.png").getImage();
			
			imgContinuar.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					imgContinuar.setIcon(new ImageIcon(imgCerebroContinuar.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));				
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					imgContinuar.setIcon(new ImageIcon(imgCerebroContinuar3.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));	
					//cambiamos el contenido de las cajas de texto y de las etiquetas operación y resultado, cuando pulsamos el boton reset

					cajaTexto1.setText(resultado.getText()); // ponemos el contenido de la etiqueta resultado en la primera caja de texto, para continuar calculando
					operacion.setText(""); // borramos la etiqueta operación
					resultado.setText(""); // borramos la etiqueta resultado
					cajaTexto2.setText(""); // borramos la caja de segunda caja detexto
					cajaTexto2.requestFocus(); //colocamos el cursor en numero 2
				}
				
				@Override
				public void mouseExited(MouseEvent e) { 
					imgContinuar.setIcon(new ImageIcon(imgCerebroContinuar.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));				
				}
				
				@Override
				public void mouseEntered(MouseEvent e) { 
					imgContinuar.setIcon(new ImageIcon(imgCerebroContinuar2.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));				
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub				
				}
			});
			
			
			
			
			
			
			
			operacion = new JLabel("",JLabel.CENTER); //le indicamos a la etiqueta que se alinee al centro
			operacion.setBounds(0, 400, 440, 80);
			operacion.setFont(font2.deriveFont(Font.BOLD, 30f));
			operacion.setForeground(new Color(15,51,99));
			add(operacion);			
			
			resultado = new JLabel("",JLabel.CENTER); 
			resultado.setBounds(0, 460, 440, 80);
			resultado.setFont(font1.deriveFont(Font.BOLD, 35f));
			resultado.setForeground(new Color(131,4,231));
			add(resultado);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void fuenteCalculadora1() throws FontFormatException, IOException {
		font1 = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/modelo/alarm clock.ttf"));
		font2 = new Font("Roboto", Font.BOLD,18);
	}
	

	
	public void establecerManejador (ManejadorEventos manejador) {
		botonSumar.addActionListener(manejador);
		botonRestar.addActionListener(manejador);
		botonMultiplicar.addActionListener(manejador);
		botonDividir.addActionListener(manejador);
		botonRaiz2.addActionListener(manejador);
		botonRaiz3.addActionListener(manejador);
	}
	

	//get y set
	public JTextField getCajaTexto1() {
		return cajaTexto1;
	}
	public JTextField getCajaTexto2() {
		return cajaTexto2;
	}	
	public JButton getBotonSumar() {
		return botonSumar;
	}
	public JButton getBotonRestar() {
		return botonRestar;
	}
	public JButton getBotonMultiplicar() {
		return botonMultiplicar;
	}
	public JButton getBotonDividir() {
		return botonDividir;
	}
	public JLabel getNumero1() {
		return numero1;
	}
	public JLabel getNumero2() {
		return numero2;
	}
	public JLabel getResultado() {
		return resultado;
	}
	public JLabel getResultado2() {
		return operacion;
	}
	public void setResultado2(JLabel resultado2) {
		this.operacion = resultado2;
	}
	public JButton getBotonRaiz3() {
		return botonRaiz3;
	}
	public JButton getBotonRaiz2() {
		return botonRaiz2;
	}
	public JLabel getImgCerebro() {
		return imgReset;
	}
	public void setNumero1(JLabel numero1) {
		this.numero1 = numero1;
	}

	public void setNumero2(JLabel numero2) {
		this.numero2 = numero2;
	}

	public void setResultado(JLabel resultado) {
		this.resultado = resultado;
	}

	public void setImgCerebro(JLabel imgCerebro) {
		this.imgReset = imgCerebro;
	}

	public void setCajaTexto1(JTextField cajaTexto1) {
		this.cajaTexto1 = cajaTexto1;
	}

	public void setCajaTexto2(JTextField cajaTexto2) {
		this.cajaTexto2 = cajaTexto2;
	}

	public void setBotonSumar(JButton botonSumar) {
		this.botonSumar = botonSumar;
	}

	public void setBotonRestar(JButton botonRestar) {
		this.botonRestar = botonRestar;
	}

	public void setBotonMultiplicar(JButton botonMultiplicar) {
		this.botonMultiplicar = botonMultiplicar;
	}

	public void setBotonDividir(JButton botonDividir) {
		this.botonDividir = botonDividir;
	}

	public void setBotonRaiz2(JButton botonRaiz2) {
		this.botonRaiz2 = botonRaiz2;
	}

	public void setBotonRaiz3(JButton botonRaiz3) {
		this.botonRaiz3 = botonRaiz3;
	}
}