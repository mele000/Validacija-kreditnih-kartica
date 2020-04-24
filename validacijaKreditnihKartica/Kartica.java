package validacijaKreditnihKartica;

import java.util.ArrayList;

public class Kartica {

	long kartica;
	String s;
	int[] arr;

	public Kartica() {
	}

	public Kartica(long kartica) {
		this.kartica = kartica;

		napraviArrOdLonga(kartica);
		
		if (provjeriBrojCifara(arr) == true) {
			if (provjeriPrvuCifru(arr) == true) {
				if (provjeriJeLiKarticaValidna(arr) == true) {
					System.out.println("Kartica " + s + " je validna");
				} else
					System.out.println("Nije Validna");
			} else
				System.out.println("Broj Cifara treba biti izmedju 13 i 16");
		} else
			System.out.println("Prva cifra treba biti 4,5,6 ili 37");

	}

	public int[] napraviArrOdLonga(long kartica) {
		s = kartica + "";
		arr = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			arr[i] = s.charAt(i) - '0';
		}

		return arr;
	}

	public int saberiBrojeveNaParnimIndeksimaPomnozeneSaDvaSaDesnaNaLijevo(int arr[]) {
		int rez = 0;

		for (int i = arr.length - 2; i >= 0; i = i - 2) { // pomnozi sa 2
			arr[i] = arr[i] * 2;
		}

		for (int i = arr.length - 2; i >= 0; i = i - 2) {
			if (arr[i] / 10 == 0) {
				rez = rez + arr[i];
			} else if (arr[i] / 10 != 0) {
				int prvaCifra = arr[i] / 10;
				int drugaCifra = arr[i] % 10;
				rez = rez + (prvaCifra + drugaCifra);
			}
		}

		return rez;
	}

	public int saberiBrojeveNaNeparnimIndeksimaSadesnaNaLijevo(int arr[]) {
		int rez = 0;

		for (int i = arr.length - 1; i >= 0; i = i - 2) {
			rez += arr[i];
		}
		return rez;
	}

	public int saberiRezultateDobiveneIzPrveIDrugeMetode(int arr[]) {

		int rez;

		rez = saberiBrojeveNaParnimIndeksimaPomnozeneSaDvaSaDesnaNaLijevo(arr)
				+ saberiBrojeveNaNeparnimIndeksimaSadesnaNaLijevo(arr);

		return rez;

	}

	public boolean provjeriJeLiKarticaValidna(int arr[]) {

		if (saberiRezultateDobiveneIzPrveIDrugeMetode(arr) % 10 != 0) {
			return false;
		} else
			return true;

	}

	public boolean provjeriPrvuCifru(int arr[]) {

		if (arr[0] == 4 || arr[0] == 5 || arr[0] == 6 || arr[0] == 37) {
			return true;
		} else
			return false;

	}

	public boolean provjeriBrojCifara(int arr[]) {
		if (arr.length >= 13 && arr.length <= 16) {
			return true;
		} else
			return false;
	}
}
