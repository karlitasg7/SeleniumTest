package accessMod;

public class A {

	private void mostrar() {
		System.out.println("Modificador de acceso");
	}

	public void mostrarPublic() {
		mostrar();
		System.out.println("hola");
	}

}
