package modelo;

import java.sql.Date;

import excepciones.CampoVacioException;
import excepciones.DniException;

public class Reserva {

	private int idReserva;
	private String nombre;
	private String dni;
	private String cuentaPago;
	private int numPersonas;
	private Date fechaReserva;
	private boolean parking;
	
	public Reserva() {
		super();
	}

	public Reserva(int idReserva, String nombre, String dni, String cuentaPago, int numPersonas, Date fechaReserva,
			boolean parking) throws CampoVacioException, DniException {
		super();
		this.setIdReserva(idReserva);
		this.setNombre(nombre);
		this.setDni(dni);
		this.setCuentaPago(cuentaPago);
		this.setNumPersonas(numPersonas);
		this.setFechaReserva(fechaReserva);
		this.setParking(parking);
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws CampoVacioException {
		if (nombre.length()!=0) {
			this.nombre = nombre;
		} else {
			throw new CampoVacioException();
		}
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) throws DniException {
		if (compruebaDni(dni)) {
			this.dni = dni;
		} else {
			throw new DniException();
		}
	}

	private boolean compruebaDni(String dni2) {
		
		String letraDni= "TRWAGMYFPDXBNJZSQVHLCKE";
		char letra= dni2.charAt(dni2.length()-1);
		int num=Integer.parseInt(dni2.substring(0, dni2.length()-1));
		
		int resto = num%23;
		if (letraDni.charAt(resto)==letra) {
			return true;
		}
		
		return false;
	}

	public String getCuentaPago() {
		return cuentaPago;
	}

	public void setCuentaPago(String cuentaPago) {
		this.cuentaPago = cuentaPago;
	}

	public int getNumPersonas() {
		return numPersonas;
	}

	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public boolean isParking() {
		return parking;
	}

	public void setParking(boolean parking) {
		this.parking = parking;
	}

	@Override
	public String toString() {
		return idReserva + ";" + nombre + ";" + dni + ";" + cuentaPago
				+ ";" + numPersonas + ";" + fechaReserva + ";" + parking;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idReserva;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		if (idReserva != other.idReserva)
			return false;
		return true;
	}
	
	
	
}
