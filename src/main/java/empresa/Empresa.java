package empresa;

public class Empresa {
	public static void main(String[] args) {
		int opcion = 0;
		Departamentos2 d = new Departamentos2();
		Empleados e = new Empleados(d);
		d.setEmpleados(e);
		
		
		do{
		System.out.println("MEN�: ");
		System.out.println("1. Gesti�n de departamentos: ");
		System.out.println("2. Gesti�n de empleados: ");
		System.out.println("0. Salir. ");
		opcion = PedirDatos.leerEntero("Elija una opci�n: ");
		
		switch (opcion) {
		case 1:
			d.menu();
			break;
		case 2:
			e.menu();
			break;
		case 0:
			System.out.println("Adi�s!!!!");
			break;

		default:
			System.out.println("Por favor, elija una opci�n entre 0 y 2.");
			break;
		}
	
		}while(opcion!=0);
	}
}
