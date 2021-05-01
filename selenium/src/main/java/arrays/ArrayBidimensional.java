package arrays;

public class ArrayBidimensional {

	public static void main(String[] args) {

		// delcarando e inicializando el array 2D
		int arr[][] = { { 2, 7, 9 }, { 3, 6, 1 }, { 7, 4, 2 } };

		// la primera posicion es el array y la segunda posición es la que está dentro
		// del array
		System.out.println(arr[1][2]);

		// imprimir array 2D
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("");
		}

	}

}
