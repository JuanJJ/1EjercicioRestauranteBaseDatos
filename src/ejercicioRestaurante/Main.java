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
		// TODO Ap�ndice de m�todo generado autom�ticamente

		
		try {
			frmReservas frame = new frmReservas();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
