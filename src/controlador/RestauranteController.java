package controlador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import excepciones.CampoVacioException;
import excepciones.CuentaCorrienteException;
import excepciones.DniException;
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
	
	
	//MODIFICAR UNA RESERVA ENVIANDOLE UN OBJETO TIPO RESERVA
	public boolean eliminarReserva(Reserva reser) throws SQLException {
		
		boolean eliminado=false;
		String sql="select * from reservas where ID_reserva = "+reser.getIdReserva();
		st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs=st.executeQuery(sql);
		
		rs.next();
		rs.deleteRow();
		
		eliminado=true;
		
		return eliminado;
	}
		
	//MODIFICAR UNA RESERVA ENVIANDOLE UN OBJETO TIPO RESERVA
	public boolean modificarReserva(Reserva reser) throws SQLException {
		
		boolean modificado=false;
		String sql="select * from reservas where ID_reserva = "+reser.getIdReserva();
		st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs=st.executeQuery(sql);
		
		rs.next();
		rs.updateInt("ID_reserva", reser.getIdReserva());
		rs.updateString("Nombre", reser.getNombre());
		rs.updateString("DNI", reser.getDni());
		rs.updateString("Cuenta_Pago", reser.getCuentaPago());
		rs.updateInt("Num_Personas", reser.getNumPersonas());
		rs.updateDate("Fecha_Reserva", reser.getFechaReserva());
		rs.updateBoolean("Parking", reser.isParking());
		rs.updateRow();
		
		modificado=true;
		
		return modificado;
	}
	
	
	//PARA AGREGAR UNA RESERVA, SE LE ENVIA UN OBJETO TIPO RESERVA
	public boolean agregarReserva(Reserva reser) throws SQLException {
		
		boolean agregado=false;
		String sql="select * from reservas";
		st=cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		rs=st.executeQuery(sql);
		
		rs.moveToInsertRow();
		rs.updateInt("ID_reserva", reser.getIdReserva());
		rs.updateString("Nombre", reser.getNombre());
		rs.updateString("DNI", reser.getDni());
		rs.updateString("Cuenta_Pago", reser.getCuentaPago());
		rs.updateInt("Num_Personas", reser.getNumPersonas());
		rs.updateDate("Fecha_Reserva", reser.getFechaReserva());
		rs.updateBoolean("Parking", reser.isParking());
		rs.insertRow();
		
		agregado=true;
		
		return agregado;
	}
	
	

	
	
	//DEVUELVE UN ARRAYLIST CON LAS RESERVAS SEGUN LA SQL QUE SE LE ENVIE
	public List<Reserva> getReservas(String sql) throws SQLException {
		st=cn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		rs=st.executeQuery(sql);
		reservas=new ArrayList<>();
		Reserva reserva=null;
		//rs.next();
		
		while (rs.next()) {
			int idReserva=rs.getInt("ID_reserva");
			String nombre=rs.getString("Nombre");
			String dni=rs.getString("DNI");
			String cuentaPago=rs.getString("Cuenta_Pago");
			int numPersonas=rs.getInt("Num_Personas");
			Date fechaReserva=rs.getDate("Fecha_Reserva");
			boolean parking=rs.getBoolean("Parking");
			
			try {
				reserva=new Reserva(idReserva, nombre, dni, cuentaPago, numPersonas, fechaReserva, parking);
				reservas.add(reserva);
			} catch (CampoVacioException | DniException | CuentaCorrienteException e) {
				System.err.println(e.getMessage());
			}
		}
		
		return reservas;
	}
	
	
	
}
