package clearminds.cuentas.test;
import clearminds.cuentas.Cuentas;

public class TestCuenta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cuentas cuenta1=new Cuentas("03476");
		cuenta1.setSaldo(675);
		Cuentas cuenta2=new Cuentas("03476", "C", 98);
		Cuentas cuenta3=new Cuentas("03476");
		cuenta1.setTipo("C");
		System.out.println("------------Valores Iniciales------------");
		cuenta1.imprimirConMiEstilo();
		cuenta2.imprimirConMiEstilo();
		cuenta3.imprimirConMiEstilo();
		System.out.println("------------Valores Modificados------------");
		cuenta1.setSaldo(444);
		cuenta2.setTipo("D");
		cuenta3.setSaldo(567);
		cuenta1.imprimirConMiEstilo();
		cuenta2.imprimirConMiEstilo();
		cuenta3.imprimirConMiEstilo();
		Cuentas cuenta4=new Cuentas("0987");
		cuenta4.setTipo("A");
		cuenta4.setSaldo(10);
		Cuentas cuenta5=new Cuentas("0557", "C", 10);
		Cuentas cuenta6=new Cuentas("0666");
		cuenta6.setTipo("A");
		cuenta6.setSaldo(0);
		cuenta4.imprimirConMiEstilo();
		cuenta5.imprimirConMiEstilo();
		cuenta6.imprimirConMiEstilo();
	}

}
