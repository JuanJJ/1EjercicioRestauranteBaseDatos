package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import modelo.Reserva;

public class RestauranteController {

	private final static String drv="com.mysql.jdbc.Driver";
	private final static String db= "jdbc:mysql://localhost:3306/restaurante?useSSL=false";
	private final static String userAndPass="root";
	private Connection cn;
	private Statement st;
	private ResultSet rs;
	private List<Reserva>reservas;
	private PreparedStatement pst;
	
	public RestauranteController() throws ClassNotFoundException, SQLException {
		super();
		abrirConexion();
		
	}

	public void cerrarConexion() throws SQLException {
		
		if (rs!=null) {
			rs.close();
		}
		if (st!=null) {
			st.close();
		}
		if (pst!=null) {
			pst.close();
		}
		if (cn!=null) {
			cn.close();
		}
		System.out.println("Conexion Cerrada");
	}

	public void abrirConexion() throws SQLException, ClassNotFoundException {
		
		Class.forName(drv);
		cn=DriverManager.getConnection(db, userAndPass, "");
		System.out.println("La conexion se realizo con exito");
		
	}
	
	
	
	
}
