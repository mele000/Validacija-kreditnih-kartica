package validacijaKreditnihKartica;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner unos = new Scanner(System.in);
		
		System.out.println("Unesite kreditnu karticu");
		long kartica = unos.nextLong();
		
		Kartica validacijaKartice = new Kartica(kartica);
		
		
		
		
	}

}
