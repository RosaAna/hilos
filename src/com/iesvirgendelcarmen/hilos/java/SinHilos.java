package com.iesvirgendelcarmen.hilos.java;

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SinHilos extends JFrame {
	//Variables de instancia
	private JButton boton;
	private Choice combo;
	//Constructor
	public SinHilos(){
		setLayout(new FlowLayout());
		add(boton = new JButton("cierta espera..."));
		add(combo = new Choice());
		combo.addItem("uno");
		combo.addItem("dos");
		combo.addItem("tres");
		setSize(300, 300);
		setVisible(true);
		//Llamamos al evento
		boton.addActionListener(new EscuchaBoton());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	//clase iterna para manejar el evento
	class EscuchaBoton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//Esperamos 10 segundos
			//simulamos la realización de una tarea
			//como la búsqueda en una BD
			try {
				Thread.sleep(10_000);
				//cuando termine aparece en consola
				//el siguiente mensaje y ya es accesible
				//el combobox
				System.out.println("Tiempo de espera...");
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}	
	}
	public static void main(String[] args) {
		new SinHilos();
	}
}
