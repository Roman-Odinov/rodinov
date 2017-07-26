package ru.job4j;

public class Calculate {
	public String echo(String value){
		return String.format("%s", value);
	}
		
	public static void main (String[] args){
		Calculate calc = new Calculate();					// new instance of the Calculate class
		System.out.println(calc.echo("Hello, World!"));		//call 'echo' method
	}
}