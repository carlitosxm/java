package clearminds.cuentas;

public class Cuentas {
	private String id;
	private String tipo;
	private double saldo;
	
	public Cuentas (String id) {
		this.id=id;
		setTipo("A");
	}
	
	public Cuentas (String id, String tipo, double saldo) {
		this.id=id;
		this.tipo = tipo;
		this.saldo = saldo;
	}
	
	public String getId() {
		return id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void imprimirConMiEstilo () {
		System.out.println("**************************");
		System.out.println("CUENTA");
		System.out.println("**************************");
		System.out.println("Número de cuenta: "+getId());
		System.out.println("Tipo: "+getTipo());
		System.out.println("Saldo: USD "+getSaldo());
	}
	
}
