package fooBar;

import controler.Multiplos;

public class FooBarMain {

	public static void main(String[] args) {
		
		Multiplos mul = new Multiplos();
		
		for(int i=1;i<=100;i++){
			System.out.println(mul.fooBar(i));
		}
	}
}