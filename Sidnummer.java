import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * Skriv ett program som l�ter anv�ndaren mata in ett antal sidnummer. Inmatningen avslutas med en
 * nolla. Det �r givet att numren alltid kommer i stigande ordning och att det inte f�rekommer
 * dubbletter. Programmet skall sedan skriva ut detta med ett mer komprimerat format.
 * 
 * Formatet skall vara p� f�ljande vis:
 * 1. N�r det �r minst tv� konsekutiva tal, skriv ut det f�rsta och det sista med ett bindestreck
 *    emellan.
 * 2. Alla andra nummer skall separeras med komma.
 * 3. Utskriften skall vara p� en rad.
 */

public class Sidnummer {

	public static void main(String[] args) throws IOException {
		System.out.println("Skriv in sidnummer i stigande ordning utan dubbletter, inmatningen avslutas med en nolla.");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		while (true) {
			System.out.print("Mata in sidnummer: ");
			String input = reader.readLine();
			int num = Integer.parseInt(input);

			if (arrayList.contains(num) || arrayList.stream().anyMatch(n -> n > num && num != 0)) { // Kontrollerar
																									// syntax i
																									// inmatningen.
				System.out.println("Felaktig inmatning, programmet avslutas...");
				break;
			} else if (num == 0) {

				// System.out.println(arrayList.toString()); // Tempor�r println f�r att kontrollera input.

				Integer[] array = new Integer[arrayList.size()];
				array = arrayList.toArray(array);

				if (array.length > 0) {
					String comma = "";
					int i = 0, j = 0;

					do {
						j = i + 1;
						while (j < array.length) {
							if (array[j] - array[i] != j - i) {
								break;
							}
							j++;
						}

						if (i == j - 1) {
							System.out.print(comma + array[i]); // Skriver ut vanliga nummer
						} else {
							System.out.print(comma + array[i] + "-" + array[j - 1]); // Skriver ut konsekutiva nummer
						}

						i = j;
						comma = ", ";

					} while (i < array.length);
				}
				break;
			}
			arrayList.add(num);
		}
	}
}
