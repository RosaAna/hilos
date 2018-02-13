package com.iesvirgendelcarmen.sincronizacion.java;

public class Sincronizacion2 {

	public static void main(String[] args) {
		final Contador1 contador1 = new Contador1();
		for (int i = 0; i < 50; i++) {
			Thread thread = new IncrementarContador1(contador1,
					(int) (Math.random() * 8));
			thread.start();
		}
	}

}
class Contador1 {
	private volatile int contador = 0;
	
	public  void incrementarContador1(int valor){
		contador += valor;
		System.out.println("Incrementando: " + valor + " contador: " + contador);
	}
}

class IncrementarContador1 extends Thread {
	private Contador1 contador;
	private int cantidad;
	public IncrementarContador1(Contador1 contador, int cantidad) {
		super();
		this.contador = contador;
		this.cantidad = cantidad;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep((long) (Math.random() * 20));
			contador.incrementarContador1(cantidad);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}