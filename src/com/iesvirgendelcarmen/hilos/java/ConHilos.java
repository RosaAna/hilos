package com.iesvirgendelcarmen.hilos.java;
/*Ahora creamos una clase interna que
 * se encarga de realizar la conexión 
 * a una supuesta BD u otro servicio,
 * de manera que lo lanzamos en un  hilo
 * independiente y la GUI no deja de estar
 * inhábil, mas concretamente el combobox es
 * accesible independientemente de que haya 
 * terminado o no el computo.
 */


import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ConHilos extends JFrame {

	
		// TODO Auto-generated method stub
		//variables de instancia
		private JButton boton;
		private Choice combo;
		public ConHilos(){
			setLayout(new FlowLayout());
			add(boton = new JButton("cierta espera..."));
			add(combo = new Choice());
			combo.addItem("uno");
			combo.addItem("dos");
			combo.addItem("tres");
			setSize(300, 300);
			setVisible(true);
			//llamamos al manejador del evento.
			boton.addActionListener(new EscuchaBoton());
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		//clase interna que gestiona el evento
		class EscuchaBoton implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//Inhabilitamos el botón mietras dure el proceso
				//para eso es necesario que sea una variable de instancia
				boton.setEnabled(false);
				//Creamos un objeto que realiza el computo que va
				//a llevar cierto tiempo.
				TareaBoton t = new TareaBoton();
				t.start(); //arrancamo el hilo
				

			}
		}
			
			//clase interna que gestiona el proceso
			//que dura cierto tiempo
			public class TareaBoton extends Thread {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(10000);
						//cuando termine los 10 segundo
						//vuelvo a activar el botón
						boton.setEnabled(true);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

			public static void main(String[] args) {
				new ConHilos();
			}

	

}