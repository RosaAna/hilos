package com.iesvirgendelcarmen.sincronizacion.java;

public class Sincronizacion1 {

	public static void main(String[] args) {
		final Contador contador = new Contador();
		for (int i = 0; i < 50; i++) {
			Thread thread = new IncrementarContador(contador,
					(int) (Math.random() * 8));
			thread.start();
		}
	}

}
class Contador {
	private int contador = 0;
	
	public synchronized void incrementarContador(int valor){
		contador += valor;
		System.out.println("Incrementando: " + valor + " contador: " + contador);
	}
}

class IncrementarContador extends Thread {
	private Contador contador;
	private int cantidad;
	public IncrementarContador(Contador contador, int cantidad) {
		super();
		this.contador = contador;
		this.cantidad = cantidad;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep((long) (Math.random() * 20));
			contador.incrementarContador(cantidad);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}