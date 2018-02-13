package com.iesvirgendelcarmen.hilos.java;

public class TestHiloUsuario {

	public static void main(String[] args) {
		Thread hilo1 = new Thread(new HiloUsuario("HILO DE USUARIO"));
		hilo1.setDaemon(true);
		hilo1.start();
		Thread hilo2 = new Thread(new HiloUsuario("HILO DE USUARIO"));
		hilo2.setDaemon(true);
		hilo2.start();
		
		for (int i = 0; i < 250; i++) {
			try {
				Thread.sleep((long) (Math.random() * 100));
				System.out.println(Thread.currentThread().getName() + " -- " +
						Thread.currentThread().getPriority());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("FIN DEL HILO PRINCIPAL ########################");
	}

}
	class HiloUsuario implements Runnable {
		private String nombre;

		public HiloUsuario(String nombre) {
			this.nombre = nombre;
		//	Thread.currentThread().setName(nombre);
		}

		@Override
		public void run() {
			while (true){
				try {
					Thread.sleep((long) (Math.random() * 100));
					System.out.println(Thread.currentThread().getName() + " -- " +
							Thread.currentThread().getPriority());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}