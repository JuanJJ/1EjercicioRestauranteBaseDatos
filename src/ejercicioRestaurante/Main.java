package ejercicioRestaurante;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import controlador.RestauranteController;
import excepciones.CampoVacioException;
import excepciones.CuentaCorrienteException;
import excepciones.DniException;
import modelo.Reserva;

public class Main {

	public static void main(String[] args) {
		// TODO Apéndice de método generado automáticamente

		
		Reserva reser=null;
		
		java.util.Date fecha=null;
		Date fechaReserva=null;
		SimpleDateFormat formateador=new SimpleDateFormat("dd/MM/yyyy");
		RestauranteController restaurante=null;
		
		
		try {
			fecha=formateador.parse("12/04/2019");
			fechaReserva=new Date(fecha.getTime());
			restaurante=new RestauranteController();
			
			//para agregar
			reser=new Reserva("Alfonzo", "21617287R", "3079-0152-54-6989436740", 2,fechaReserva , true);
			
			//Para eliminar o modificar
			//reser=new Reserva(2, "Alfonzo", "21617287R", "3079-0152-54-6989436740", 2,fechaReserva , true);
			
			restaurante.agregarReserva(reser);
			//restaurante.modificarReserva(reser);
			
			//restaurante.eliminarReserva(reser);
			restaurante.cerrarConexion();
			
			System.out.println("Todo OK");
		} catch (CampoVacioException | DniException | ParseException | CuentaCorrienteException | ClassNotFoundException | SQLException e) {
			System.err.println(e.getMessage());
		}
		
		/*
		RestauranteController restaurante=null;
		List<Reserva> listaReservas=null;
		try {
			restaurante=new RestauranteController();
			
			listaReservas=restaurante.getReservas("select * from reservas");
			System.out.println();
			restaurante.cerrarConexion();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
		*/
	}

}
