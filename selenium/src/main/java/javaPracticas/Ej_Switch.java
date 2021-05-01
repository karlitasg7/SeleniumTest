package javaPracticas;

public class Ej_Switch {

	public static void main(String[] args) {
		int i = 10;
		String str = "two";

		switch (i) {
		case 0:
			System.out.println("i es cero");
			break;

		case 1:
			System.out.println("i es uno");
			break;

		case 2:
			System.out.println("i es dos");
			break;

		default:
			System.out.println("i es mayor que 2");

		}

		/*switch (str) {
		case "zero":
			System.out.println("i es certo");
			break;

		case "one":
			System.out.println("i es uno");
			break;

		case "two":
			System.out.println("i es dos");
			break;

		default:
			System.out.println("i es mayor a dos");

		}
		*/

	}

}
