package validacijaKreditnihKartica;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KarticaTest {

	Kartica validacijaKartice;

	long kartica_Neispravna;
	long kartica_Ispravna;
	long kartica_PrvaCifraNijeIspravna;
	long kartica_BrojCifaraNijeOdgovarajuci;

	@BeforeEach
	void setUp() throws Exception {
		validacijaKartice = new Kartica();
		kartica_Neispravna = 4388576018402626L;
		kartica_Ispravna = 4388576018410707L;
		kartica_PrvaCifraNijeIspravna = 123456789123456789L;
		kartica_BrojCifaraNijeOdgovarajuci = 4212;
	}

	@AfterEach
	void tearDown() throws Exception {
		validacijaKartice = null;
	}

	@Test
	void shouldReturn70WhenAllNumbersAreAddedInRez() {
		validacijaKartice.napraviArrOdLonga(kartica_Neispravna);

		int rez = 0;

		for (int i : validacijaKartice.arr) {
			rez = rez + i;
		}

		assertEquals(rez, 70);
	}

	@Test
	void shouldReturn37WhenNumbersMultipliedBy2OnEvenPlaceAreAdded() {
		int rez = validacijaKartice.saberiBrojeveNaParnimIndeksimaPomnozeneSaDvaSaDesnaNaLijevo(
				validacijaKartice.napraviArrOdLonga(kartica_Neispravna));
		assertEquals(rez, 37);
	}

	@Test
	void shouldReturn38WhenNumbersOnOddPlaceAreAdded() {
		int rez = validacijaKartice
				.saberiBrojeveNaNeparnimIndeksimaSadesnaNaLijevo(validacijaKartice.napraviArrOdLonga(kartica_Neispravna));
		assertEquals(rez, 38);
	}

	@Test
	void shouldReturn75WhenNumbersFromFirstAndSecondMethodAreAdded() {

		int rez = validacijaKartice
				.saberiRezultateDobiveneIzPrveIDrugeMetode(validacijaKartice.napraviArrOdLonga(kartica_Neispravna));
		assertEquals(rez, 75);

	}

	@Test
	void shouldReturnFalseWhenFinalResultIsNotDivisisbleBy10() {

		boolean rez = validacijaKartice.provjeriJeLiKarticaValidna(validacijaKartice.napraviArrOdLonga(kartica_Neispravna));
		assertFalse(rez);

	}

	@Test
	void shouldReturnTrueWhenFinalResultIsDivisisbleBy10() {

		boolean rez = validacijaKartice.provjeriJeLiKarticaValidna(validacijaKartice.napraviArrOdLonga(kartica_Ispravna));
		assertTrue(rez);

	}

	@Test
	void shouldReturnFalseWhenFirstUnitIsNot4_5_6_OR_37() {
		boolean rez = validacijaKartice
				.provjeriPrvuCifru(validacijaKartice.napraviArrOdLonga(kartica_PrvaCifraNijeIspravna));
		assertFalse(rez);

	}

	@Test
	void shouldReturnTrueWhenFirstUnitIs4_5_6_OR_37() {
		boolean rez = validacijaKartice.provjeriPrvuCifru(validacijaKartice.napraviArrOdLonga(kartica_Ispravna));
		assertTrue(rez);

	}

	@Test
	void shouldReturnFalseWhenThereIsLessThan13OrMoreThan16() {
		boolean rez = validacijaKartice
				.provjeriBrojCifara(validacijaKartice.napraviArrOdLonga(kartica_BrojCifaraNijeOdgovarajuci));
		assertFalse(rez);

	}

	@Test
	void shouldReturnTrueWhenThereIsBetween13_Or_16Units() {
		boolean rez = validacijaKartice.provjeriBrojCifara(validacijaKartice.napraviArrOdLonga(kartica_Ispravna));
		assertTrue(rez);

	}
}