import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import excepciones.CampoVacioException;
import excepciones.DniException;
import modelo.Reserva;

public class Main {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		
		Reserva reser=null;
		
		java.util.Date fecha=null;
		Date fechaReserva=null;
		SimpleDateFormat formateador=new SimpleDateFormat("dd/MM/yyyy");
		
		
		
		try {
			fecha=formateador.parse("12/04/2019");
			fechaReserva=new Date(fecha.getTime());
			
			reser=new Reserva(1, "Juan", "28303125S", "3079-8954-81-4505752742", 12,fechaReserva , false);
			System.out.println("Todo OK");
		} catch (CampoVacioException | DniException | ParseException e) {
			System.err.println(e.getMessage());
		}
		
	}

}
