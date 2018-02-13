package com.iesvirgendelcarmen.hilos.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestNumerosPrimos {

	public static void main(String[] args) {
		List<Long> listaNumeros = new ArrayList<>();
		
		try (Scanner sc = new Scanner(new File("Numeros.txt"));){
			while (sc.hasNextLong())
				listaNumeros.add(sc.nextLong());
			//System.out.println(listaNumeros);
			ExecutorService executor = 
					Executors.newFixedThreadPool(4);
			for (Long long1 : listaNumeros) {
				Runnable tarea = new NumeroPrimo(long1);
				executor.execute(tarea);
			}
			
			executor.shutdown();
			while (!executor.isTerminated()) {}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean isPrime(long n) {
		if (n <= 3) {
			return n > 1;
		} else if (n % 2 == 0 || n % 3 == 0) {
			return false;
		} else {
			for (long i = 5; i * i <= n; i += 6) {
				if (n % i == 0 || n % (i + 2) == 0) {
					return false;
				}
			}
			return true;
		}
	}

}

class NumeroPrimo implements Runnable {
	
	private long valor;
	
	public NumeroPrimo (long valor){
		this.valor = valor;
	}


	@Override
	public void run() {
		
		System.out.println(valor + " ¿es primo? " + 
				TestNumerosPrimos.isPrime(valor) );

	}

}





