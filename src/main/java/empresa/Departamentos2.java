package empresa;

public class Departamentos2 {
	 private Departamento[] departamentos=new Departamento[100];
	 private int posicion=0;
	 private Empleados e;
	 
	 public Departamento[] getDepartamentos() {
			return departamentos;
		}
	 
	 public void menu(){
		 int opcion=0;
		do {
			 System.out.println("1. a�adir departamento");
			 System.out.println("2. listar departamento");
			 System.out.println("3. modificar departamento");
			 System.out.println("4. borrar departamento");
			 System.out.println("5. Mostrar total salario de un departamento.");
			 System.out.println("6. Mostrar total salarios de los departamentos.");
			 System.out.println("0. salir");
			 opcion=PedirDatos.leerEntero("seleccione una opcion");
			 
			 switch (opcion) {
			case 1:
				addDepartamento();
				break;
			case 2:
				listarDepartamento();
				
				break;

			case 3:
				setDepartamento();
				break;

			case 4:
				borrarDepartamento();
				break;
			case 5:
				mostrarSalarioDepartamento();
				break;
			case 6:
				mostrarSalarios();
				break;
			case 0:
				System.out.println("has salido del menu");
				break;
			default:
				System.out.println("debe introducir un numero entre 0 y 4");
				break;
			}
		} while (opcion!=0);	
	 }
	public void setEmpleados(Empleados e){
		this.e=e;		
	}
 
	private void mostrarSalarioDepartamento() {
		int dptonum = PedirDatos.leerEntero("Introduzca el n�mero del departamento del que desea consultar el salario.");
		int pos = buscarDepartamento(dptonum);
		
		System.out.println("El total del departamento "+dptonum+" es "+departamentos[pos].getTotalsalarios());
	}

	private void mostrarSalarios() {
		for (int i = 0; i < posicion; i++) {
			System.out.println("El total del departamento "+departamentos[i].getDptonum()+" es "+departamentos[i].getTotalsalarios());
		}
		
	}

	public int buscarDepartamento(int dptonum){
		for (int i = 0; i < posicion; i++) {
			if(dptonum==departamentos[i].getDptonum()){
				return i;
			}	
		}
		return -1;	
	}

	private void addDepartamento() {
		int dptonum=PedirDatos.leerEntero("introduzca el numero de departamento que desea a�adir");
		int pos=buscarDepartamento(dptonum);
		if(pos!=-1){
			System.out.println("el departamento ya existe");
			return;
		}
		Departamento d=new Departamento();
		d.pedirDepartamento(dptonum);
		departamentos[posicion]=d;
		posicion++;		
	}
	
	private void listarDepartamento() {
		for (int i = 0; i < posicion; i++) {
			System.out.println(departamentos[i]);
		}		
	}
	
	private void setDepartamento() {
		int dptonum=PedirDatos.leerEntero("inserte el codigo del departamento que desea modificar");
		int pos=buscarDepartamento(dptonum);
		if(pos==-1){
			System.out.println("el departamento no existe, no se puede modificar");
			return;
		}
		Departamento d=new Departamento();
		d.pedirDepartamento(dptonum);
		departamentos[pos]=d;	
	}

	private void borrarDepartamento() {
		int dptonum=PedirDatos.leerEntero("inserte el numero del departamento que desea eliminar");
		int pos=buscarDepartamento(dptonum);
		if(pos==-1){
			System.out.println("el departamento no existe, no se puede eliminar");
			return;
		}
		for (int i = pos; i < posicion; i++) {
			departamentos[i]=departamentos[i+1];
		}
		posicion--;	
	}
	
}
