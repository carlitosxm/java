package comkrakedev.persistencia.test;

import java.util.Date;

import com.krakedev.persistencia.servicios.AdminRegistroEntradas;
import com.krakedev.persistencia.utils.Convertidor;
import com.krakeved.persistencia.entidades.Empleado;
import com.krakeved.persistencia.entidades.RegistrosEntrada;

public class TestActualizarRegistro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Empleado em=new Empleado();
			Date fecha=Convertidor.convertirFecha("2000/12/13");
			Date hora=Convertidor.convertirHora("09:23");
			em.setCodigo_empleado(2222);
			em.setNombre("Prueba");
			em.setFecha(fecha);
			em.setHora(hora);
			RegistrosEntrada re=new RegistrosEntrada(99, "1111111111", Convertidor.convertirFecha("2000/12/13"), Convertidor.convertirHora("09:23"), em);
			AdminRegistroEntradas.actualizar(re);
			System.out.println("Ingreso correcto");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("error al insertar"+e);
		}
	}

}
