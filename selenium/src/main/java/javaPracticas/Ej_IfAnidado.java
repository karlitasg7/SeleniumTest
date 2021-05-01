package javaPracticas;

public class Ej_IfAnidado {

	public static void main(String[] args) {
		int temperatura = 22;

		if (temperatura > 15) {
			if (temperatura > 25) {
				System.out.println("A la plaza!");
			} else {
				System.out.println("A la montaña!");
			}

		} else {
			System.out.println("A descansar...");
		}
	}

}
