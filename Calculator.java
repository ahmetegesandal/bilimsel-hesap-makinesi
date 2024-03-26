package Calculator;

import java.util.InputMismatchException;

import java.util.Scanner;

public class Calculator {

	public static String RES = "\u001B[0m";
	public static String R = "\u001B[31m";
	public static String G = "\u001B[32m";
	public static String B = "\u001B[36m";
	public static String Y = "\u001B[33m";
	public static String ERROR = "Geçersiz bir değer girdiniz, lütfen tekrar deneyin.";

	// Method for CMD color
	public static String col(String color, String text) {
		return color + text + RES;

	}

	// Method for scan
	public static Scanner scan() {
		Scanner inp = new Scanner(System.in);
		return inp;
	}
	
	public static void pln(String text) {
		System.out.println(text);
	}
	
	public static void pr(String text) {
		System.out.print(text);
	}

	public static short getValidShortInput(String promptMessage) {
		short value = 0;
		boolean validInput = false;
		while (!validInput) {
			try {
				pr(promptMessage);
				value = scan().nextShort();
				validInput = true;
			} catch (InputMismatchException e) {
				pln(col(R, ERROR));
				scan().nextLine();
			}
		}
		return value;
	}

	public static float getValidFloatInput(String promptMessage) {
		float value = 0;
		boolean validInput = false;
		while (!validInput) {
			try {
				pr(promptMessage);
				value = scan().nextFloat();
				validInput = true;
			} catch (InputMismatchException e) {
				pln(col(R, ERROR));
				scan().nextLine();
			}
		}
		return value;
	}
	
	

	public static int getValidIntInput(String promptMessage) {
		int value = 0;
		boolean validInput = false;
		while (!validInput) {
			try {
				pr(promptMessage);
				value = scan().nextInt();
				validInput = true;
			} catch (InputMismatchException e) {
				pln(col(R, ERROR));
				scan().nextLine();
			}
		}
		return value;
	}

	public static void operationWrite() {
		pln(col(B, "-----------------------------------------------------------------------------------"));
		pln(B + "| Programdan çıkmak için => 0                                                     |");
		pln("-----------------------------------------------------------------------------------");
		pln("| Toplama için =>     1  | Çıkarma için =>        2  | Çarpma için =>          3  |");
		pln("-----------------------------------------------------------------------------------");
		pln("| Bölme için =>       4  | Polinom için =>        5  | Parabol için =>         6  |");
		pln("-----------------------------------------------------------------------------------");
		pln("| Türev için =>       7  | İntegral için =>       8  | Fonksiyon için =>       9  |");
		pln("-----------------------------------------------------------------------------------");
		pln("| Karesi için =>      10 | Küpü için =>           11 | Karekök için =>         12 |");
		pln("-----------------------------------------------------------------------------------");
		pln("| Modu için =>        13 | Faktöriyel için =>     14 | Üs alma için =>         15 |");
		pln("-----------------------------------------------------------------------------------");
		pln("| Random sayı için => 16 | Üste yuvarlama için => 17 | Aşağı yuvarlama için => 18 |");
		pln("-----------------------------------------------------------------------------------");
		pln("| PI sayısı için =>   19 | Euler sayısı için =>   20 |                            |" + RES);
		pln(col(B,"-----------------------------------------------------------------------------------"));
		pr(col(Y, "Yapmak istediğiniz işlemi seçiniz: "));
	}

	// Method for taking two numbers based on the operation
	public static float takeTwoNumbers(char process) {

		float x = 0, y = 0;
		x = getValidFloatInput(col(Y, "Birinci sayıyı girin: "));

		y = getValidFloatInput(col(Y, "İkinci sayıyı girin: "));

		float result = 0;

		if (process == '+') {
			result = x + y;
		} else if (process == '-') {
			result = x - y;
		} else if (process == '*') {
			result = x * y;
		} else if (process == '/') {
			if (y == 0) {
				pln(col(R, "Sıfır bölme hatası!"));
				return 0;
			} else {
				result = x / y;
			}

		} else if (process == '%') {
			result = x % y;
		}

		return result;

	}

	// Method for calculating a polynomial
	public static float calculatePolynomial(short[] multiple, int takedPolynomial) {
		float result = 0;
		for (int i = 0; i < multiple.length; i++) {
			result += multiple[i] * takePower(takedPolynomial, multiple.length - 1 - i);
		}
		return result;
	}

	// Method for taking square and cube of a number
	public static double takeSquareAndCube(double number, char x) {
		double multiply = 0;
		if (x == '2') {
			multiply = number * number;
		} else if (x == '3') {
			multiply = number * number * number;
		}
		return multiply;
	}

	// Method for taking square root of a number
	public static double takeSquareRoot(double number) {
		return Math.sqrt(Math.abs(number));
	}

	// Method for calculating factorial of a number
	public static int takeFactorial(int number) {
		int factorial = 1;
		for (int i = number; i >= 1; i--) {
			factorial *= i;
		}
		return factorial;
	}

	// Method for calculating power of a number
	public static double takePower(double base, int power) {
		double result = 1;
		for (int i = 1; i <= power; i++) {
			result *= base;
		}
		return result;
	}

	// Method for calculating derivative of a function
	public static double derivative(double base, int power) {
		return power * takePower(base, power - 1);
	}

	// Method for calculating integral of a function
	public static double integral(double base, int power, double a, double b, int n) {

		double delta_x = (b - a) / n;
		double sum = 0.0;

		for (int i = 0; i < n; i++) {
			@SuppressWarnings("unused")
			double xi = a + i * delta_x;
			sum += takePower(base, power) * delta_x;
		}

		return sum;
	}

	// Method for main
	public static void main(String[] args) {

		String operation = null;
		float result = 0;

		while (operation != "0") {
			operationWrite();

			operation = scan().next();

			pln(col(B,"-----------------------------------------------------------------------------------"));

			switch (operation) {
			case "0":
				pln(col(R, "Program kapanıyor..."));
				operation = "0";
				break;
			case "1":
				result = takeTwoNumbers('+');
				pln(col(G, "Toplama işleminin sonucu: " + result));
				break;
			case "2":
				result = takeTwoNumbers('-');
				pln(col(G, "Çıkarma işleminin sonucu: " + result));
				break;
			case "3":
				result = takeTwoNumbers('*');
				pln(col(G, "Çarpma işleminin sonucu: " + result));
				break;
			case "4":
				result = takeTwoNumbers('/');
				if (result != 0) {
					pln(col(G, "Bölme işleminin sonucu: " + result));
				}

				break;
			case "5":
				short willTakePolynomial = 0;

				willTakePolynomial = getValidShortInput(col(Y, "Kaç katsayılı polinom istiyorsun: "));

				pln(col(Y,"Polinom katsayılarını sırasıyla girin (örn. 2x^3 + 4x^2 - 3x + 5 için 2 4 -3 5): "));

				short[] multiplePolynomial = new short[willTakePolynomial];
				for (int i = 0; i < multiplePolynomial.length; i++) {
					multiplePolynomial[i] = getValidShortInput(Y+ (i + 1) + RES + col(Y, ". değişken değerini girin: "));
				}

				short takedPolynomial = getValidShortInput(col(Y, "x değerini girin: "));

				result = calculatePolynomial(multiplePolynomial, takedPolynomial);
				pln(col(G, "Polinom sonucu: " + result));

				break;
			case "6":
				pln(col(Y,"Parabol katsayılarını sırasıyla girin (örn. 2x^2 - 3x + 5 için 2 -3 5): "));

				short[] willTakeParabola = new short[3]; // Creating a 3-length array

				for (int i = 0; i < willTakeParabola.length; i++) {
					willTakeParabola[i] = getValidShortInput(Y+ (i + 1) + RES + col(Y, ". değişken değerini girin: "));
				}

				short willTakeParabolaX = getValidShortInput(col(Y, "x değerini girin: "));

				// Send data to the calculate polynomial function and assign the returned result
				// to the variable
				float takedParabola = calculatePolynomial(willTakeParabola, willTakeParabolaX);

				pln(col(G, "Parabol sonucu: " + takedParabola));

				break;
			case "7":

				double willTakeDerivative = getValidFloatInput(col(Y, "Taban değerini giriniz: "));

				int willTakePower = getValidIntInput(col(Y, "Üs kuvvetini giriniz: "));

				double takedDerivative = derivative(willTakeDerivative, willTakePower);
				pln(
						col(G, "f'nin x=" + willTakeDerivative + " noktasındaki türevi: " + takedDerivative));

				break;
			case "8":

				short willTakeIntegralBase = getValidShortInput(col(Y, "Taban değerini giriniz: "));

				short willTakeIntegralPower = getValidShortInput(col(Y, "Üs kuvvetini giriniz: "));

				double a = 0.0; // Lower limit of integral
				double b = 1.0; // Upper limit of integral

				int n = 1000; // number of episodes

				double TakedIntegral = integral(willTakeIntegralBase, willTakeIntegralPower, a, b, n);

				pln(col(G, "Integral: " + TakedIntegral));

				break;
			case "9":

				short willTakeFunction = getValidShortInput(col(Y, "Kaç katsayılı fonksiyon istiyorsun: "));

				short[] functionMultiple = new short[willTakeFunction];
				for (int i = 0; i < functionMultiple.length; i++) {
					functionMultiple[i] = getValidShortInput(Y+ (i + 1) + RES + col(Y, ". değişken değerini girin: "));
				}

				short willTakeFunctionX = getValidShortInput(col(Y, "x değerini girin: "));

				double takedCalculatePolynomial = calculatePolynomial(functionMultiple, willTakeFunctionX);
				pln(col(G, "Fonksiyon sonucu: " + takedCalculatePolynomial));
				break;
			case "10":
				double willTakeSquare = getValidFloatInput(col(Y, "Karesini almak istediğiniz sayı: "));

				double takedSquare = takeSquareAndCube(willTakeSquare, '2');
				pln(col(G, willTakeSquare + "'in karesi: " + takedSquare));

				break;
			case "11":
				double willTakeCube = getValidFloatInput(col(Y, "Küpünü almak istediğiniz sayı: "));

				double takedCube = takeSquareAndCube(willTakeCube, '3');
				pln(col(G, willTakeCube + "'in küpü: " + takedCube));

				break;
			case "12":
				double squareRoot = getValidFloatInput(col(Y, "Karekökünü almak istediğiniz sayı: "));

				double takedSquareRoot = takeSquareRoot(squareRoot);
				pln(col(G, squareRoot + "'in karekökü: " + takedSquareRoot));

				break;
			case "13":
				result = takeTwoNumbers('%');
				pln(col(G, "Mod işleminin sonucu: " + result));

				break;
			case "14":
				int willTakeFactorial = getValidIntInput(col(Y, "Faktöriyelini almak istediğiniz sayı: "));

				result = takeFactorial(willTakeFactorial);
				pln(col(G, "Faktöriyel işleminin sonucu: " + result));

				break;
			case "15":
				int base = getValidIntInput(col(Y, "Üssünü almak istediğiniz sayı: "));
				int power = getValidIntInput(col(Y, "Sayının üssü: "));

				result = (float) takePower(base, power);
				pln(G + "Üs alma işleminin sonucu: (" + base + "^" + power + ")" + "= " + result + RES);

				break;
			case "16":
				pln(col(G, "Rastgele sayı: " + Math.random()));
				break;
			case "17":
				double willTakeRoundUp = getValidFloatInput(col(Y, "Yukarı yuvarlamak istediğiniz sayı: "));

				pln(col(G, "Yukarı yuvarlanmış sayı: " + (int) Math.ceil(willTakeRoundUp)));
				break;
			case "18":
				double willTakeRoundDown = getValidFloatInput(col(Y, "Aşağı yuvarlamak istediğiniz sayı: "));

				pln(col(G, "Aşağı yuvarlanmış sayı: " + (int) Math.floor(willTakeRoundDown)));
				break;
			case "19":
				pln(col(G, "PI sayısı: " + Math.PI));
				break;
			case "20":
				pln(col(G, "Euler sayısı: " + Math.E));
				break;
			default:
				pln(col(R, "Geçersiz işlem seçildi. Lütfen tekrar seçiniz."));
			}
		}

	}

}
