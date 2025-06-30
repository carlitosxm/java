package comkrakedev.persistencia.test;

import com.krakedev.persistencia.servicios.AdminEmpleado;
import com.krakeved.persistencia.entidades.Empleado;

public class TestPK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Empleado e= AdminEmpleado.buscarPorCodigo(2222);
			System.out.println(e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
