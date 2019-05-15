package modelo;

import java.sql.Date;

import excepciones.CampoVacioException;
import excepciones.CuentaCorrienteException;
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

	public Reserva(String nombre, String dni, String cuentaPago, int numPersonas, Date fechaReserva, boolean parking) throws CampoVacioException, CuentaCorrienteException, DniException {
		super();
		this.setNombre(nombre);
		this.setDni(dni);
		this.setCuentaPago(cuentaPago);
		this.setNumPersonas(numPersonas);
		this.setFechaReserva(fechaReserva);
		this.setParking(parking);
	}

	public Reserva(int idReserva, String nombre, String dni, String cuentaPago, int numPersonas, Date fechaReserva,
			boolean parking) throws CampoVacioException, DniException, CuentaCorrienteException {
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

	public void setCuentaPago(String cuentaPago) throws CuentaCorrienteException {
		
		if (compruebaCcc(cuentaPago)) {
			this.cuentaPago = cuentaPago;
		} else {
			throw new CuentaCorrienteException();
		}
	}

	private boolean compruebaCcc(String cuentaPago2) {
		
		int[]entSuc=new int[8];
		int[]dc=new int[2];
		int[]numCuenta=new int[10];
		int[]numeros= {1,2,4,8,5,10,9,7,3,6};
		int acu1=0,acu2=0;
		cuentaPago2=cuentaPago2.replace("-", "");
		if (cuentaPago2.length()==20) {
			for (int i = 0; i < entSuc.length; i++) {
				entSuc[i]=Integer.parseInt(Character.toString(cuentaPago2.charAt(i)));
			}
			for (int i = 0; i < dc.length; i++) {
				dc[i]=Integer.parseInt(Character.toString(cuentaPago2.charAt(i+8)));
			}
			for (int i = 0; i < numCuenta.length; i++) {
				numCuenta[i]=Integer.parseInt(Character.toString(cuentaPago2.charAt(i+10)));
			}
			
			for (int i = 0; i < entSuc.length; i++) {
				acu1+=numeros[i+2]*entSuc[i];
			}
			for (int i = 0; i < numeros.length; i++) {
				acu2+=numeros[i]*numCuenta[i];
			}
			
			int resto1=11-(acu1%11);
			int resto2=11-(acu2%11);
			
			if (resto1==10) {
				resto1=1;
			}
			if (resto1==11) {
				resto1=0;
			}
			if (resto2==10) {
				resto2=1;
			}
			if (resto2==11) {
				resto2=0;
			}
			
			if (resto1==dc[0]&&resto2==dc[1]) {
				return true;
			}
		}
		
		return false;
	}

	public int getNumPersonas() {
		return numPersonas;
	}

	public void setNumPersonas(int numPersonas) throws CampoVacioException {
		if (numPersonas>0) {
			this.numPersonas = numPersonas;
		} else {
			throw new CampoVacioException();
		}
	}

	public Date getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(Date fechaReserva) throws CampoVacioException {
		if (fechaReserva!=null) {
			this.fechaReserva = fechaReserva;
		} else {
			throw new CampoVacioException();
		}
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
