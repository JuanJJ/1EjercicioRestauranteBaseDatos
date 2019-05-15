package ejercicioRestaurante;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controlador.RestauranteController;
import modelo.Reserva;

public class frmReservas extends JFrame {

	private JPanel panel;
	private JTextField textIdReserva, textNombre, textDni, textCuentaPago,textFechaReserva;
	JCheckBox chckbxParking;
	private JButton btnPrimero, btnAtras, btnAdelante, btnUltimo;
	private JButton btnNuevo, btnEditar, btnGuardar, btnDeshacer, btnBorrar;
	private JPanel panelMantenimiento;
	private JPanel panelGrid;
	private JScrollPane scrollPane;
	private JTable tblReservas;
	private List<Reserva>listaReservas;
	private int puntero;
	DefaultTableModel dtm;
	private JTextField textNumPersonas;
	private RestauranteController tablaLibros;
	private ResultSet rs;
	private boolean nuevoRegistro=false;
	private JFrame frame;
	JComboBox comboCampo;
	private JTextField textFiltrar;
	JButton btnFiltrar;
	JLabel lblConsulta;

	
	public frmReservas() {
		setTitle("F O R M U L A R I O   D E   M A N T E N I M I E N T O");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1182, 476);
		puntero=0;
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		definirVentana();
		definirEventos();
		cargarDatos("select * from libros");
		
		
		frame=this;
		this.setVisible(true);
	}
	
	private void cargarDatos(String sql) {
		// TODO Apéndice de método generado automáticamente

	}



	private void mostrarDatos(Reserva reserva) throws SQLException {
		// TODO Apéndice de método generado automáticamente

	
	}


	private void cargarGrid(List<Reserva> listaReservas) {
		// TODO Apéndice de método generado automáticamente

	}


	//E V E N T O S
	private void definirEventos() {
			// TODO Apéndice de método generado automáticamente
	//end definir eventos	
	}
		
	
		// D E F I N I R   V E N T A N A
	private void definirVentana() {
		// TODO Apéndice de método generado automáticamente
		JPanel panelLibros = new JPanel();
		panelLibros.setLayout(null);
		panelLibros.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2), "Reserva", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panelLibros.setBounds(28, 118, 298, 227);
		panel.add(panelLibros);
	
		textIdReserva = new JTextField();
		textIdReserva.setEditable(false);
		textIdReserva.setColumns(10);
		textIdReserva.setBounds(112, 32, 58, 20);
		panelLibros.add(textIdReserva);
	
		JLabel lblIdreserva = new JLabel("IdReserva");
		lblIdreserva.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdreserva.setBounds(10, 32, 92, 14);
		panelLibros.add(lblIdreserva);
	
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(10, 60, 92, 14);
		panelLibros.add(lblNombre);
	
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setColumns(10);
		textNombre.setBounds(112, 60, 176, 20);
		panelLibros.add(textNombre);
	
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDni.setBounds(10, 91, 92, 14);
		panelLibros.add(lblDni);
	
		textDni = new JTextField();
		textDni.setEditable(false);
		textDni.setColumns(10);
		textDni.setBounds(112, 91, 176, 20);
		panelLibros.add(textDni);
	
		JLabel lblCuentaPago = new JLabel("Cuenta Pago");
		lblCuentaPago.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCuentaPago.setBounds(10, 121, 92, 14);
		panelLibros.add(lblCuentaPago);
	
		textCuentaPago = new JTextField();
		textCuentaPago.setEditable(false);
		textCuentaPago.setColumns(10);
		textCuentaPago.setBounds(112, 122, 176, 20);
		panelLibros.add(textCuentaPago);
		
		JLabel lblFecha = new JLabel("Fecha :");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFecha.setBounds(10, 173, 92, 14);
		panelLibros.add(lblFecha);
		
		textFechaReserva = new JTextField();
		textFechaReserva.setBounds(112, 173, 176, 20);
		textFechaReserva.setEditable(false);
		panelLibros.add(textFechaReserva);
		textFechaReserva.setColumns(10);
		
		chckbxParking = new JCheckBox("Parking");
		chckbxParking.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxParking.setBounds(25, 197, 97, 23);
		panelLibros.add(chckbxParking);
		
		JLabel lblIsbn = new JLabel("Num Personas");
		lblIsbn.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIsbn.setBounds(10, 146, 92, 14);
		panelLibros.add(lblIsbn);
		
		textNumPersonas = new JTextField();
		textNumPersonas.setEditable(false);
		textNumPersonas.setBounds(112, 146, 65, 20);
		panelLibros.add(textNumPersonas);
		textNumPersonas.setColumns(10);
		
	
		JPanel panelNavegador = new JPanel();
		panelNavegador.setLayout(null);
		panelNavegador.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2), "Navegador", TitledBorder.LEADING,
		TitledBorder.TOP, null, Color.BLUE));
		panelNavegador.setBounds(28, 356, 218, 74);
		panel.add(panelNavegador);
	
		// NAVEGADOR
		btnPrimero = new JButton("Primero");
		btnPrimero.setBounds(15, 15, 40, 40);
		panelNavegador.add(btnPrimero);
		
		
		btnAtras = new JButton("Atras");
		btnAtras.setBounds(65, 15, 40, 40);
		panelNavegador.add(btnAtras);

		btnAdelante = new JButton("Adelante");
		btnAdelante.setBounds(115, 15, 40, 40);
		panelNavegador.add(btnAdelante);
		
		btnUltimo = new JButton("Ultimo");
		btnUltimo.setBounds(165, 15, 40, 40);
		panelNavegador.add(btnUltimo);
		
		panelMantenimiento = new JPanel();
		panelMantenimiento.setLayout(null);
		panelMantenimiento.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 255), 2), "Mantenimiento Reservas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panelMantenimiento.setBounds(28, 21, 266, 74);
		panel.add(panelMantenimiento);
		
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.setToolTipText("Insertar Nuevo Libro");
		btnNuevo.setBounds(15, 15, 40, 40);
		panelMantenimiento.add(btnNuevo);
		
		
		btnEditar = new JButton("Editar");
		btnEditar.setToolTipText("Editar");
		btnEditar.setBounds(65, 15, 40, 40);
		panelMantenimiento.add(btnEditar);
		
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setEnabled(false);
		btnGuardar.setToolTipText("Guardar");
		btnGuardar.setBounds(166, 15, 40, 40);
		panelMantenimiento.add(btnGuardar);
		
		
		btnDeshacer = new JButton("Deshacer");
		btnDeshacer.setEnabled(false);
		btnDeshacer.setToolTipText("Deshacer");
		btnDeshacer.setBounds(216, 15, 40, 40);
		panelMantenimiento.add(btnDeshacer);
		
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setToolTipText("Borrar Registro");
		btnBorrar.setBounds(116, 15, 40, 40);
		panelMantenimiento.add(btnBorrar);
		
		panelGrid = new JPanel();
		panelGrid.setBounds(363, 98, 766, 305);
		panel.add(panelGrid);
		panelGrid.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panelGrid.add(scrollPane, BorderLayout.CENTER);
		dtm=new DefaultTableModel();
		tblReservas = new JTable(dtm);
	
		
		scrollPane.setViewportView(tblReservas);
		
		comboCampo = new JComboBox();
		comboCampo.setModel(new DefaultComboBoxModel(new String[] {"titulo", "autor", "editorial"}));
		comboCampo.setBounds(396, 52, 68, 20);
		panel.add(comboCampo);
		
		textFiltrar = new JTextField();
		textFiltrar.setBounds(472, 52, 177, 20);
		panel.add(textFiltrar);
		textFiltrar.setColumns(10);
		
		btnFiltrar = new JButton("FILTRAR");
		
		btnFiltrar.setBounds(659, 51, 89, 23);
		panel.add(btnFiltrar);
		
		lblConsulta = new JLabel("Consulta");
		lblConsulta.setBounds(392, 21, 257, 14);
		panel.add(lblConsulta);

	}

	//HABILITAR DESABILITAR PANELES
	private void habilitarPanelLibros(boolean sw){
		
		textDni.setEditable(sw);
		textNombre.setEditable(sw);
		textCuentaPago.setEditable(sw);
		textFechaReserva.setEditable(sw);
		textNumPersonas.setEditable(sw);
		chckbxParking.setEnabled(sw);
	}
	
	private void habilitarPanelMantenimiento(boolean sw){
		
		btnNuevo.setEnabled(sw);
		btnEditar.setEnabled(sw);
		btnBorrar.setEnabled(sw);
	    btnGuardar.setEnabled(!sw);
	    btnDeshacer.setEnabled(!sw);
				
		
	}
	private void deshabilitarPanelMantenimiento(){
		boolean sw=false;
		btnNuevo.setEnabled(sw);
		btnEditar.setEnabled(sw);
		btnBorrar.setEnabled(sw);
	    btnGuardar.setEnabled(sw);
	    btnDeshacer.setEnabled(sw);
				
		
	}
	
	
	private void habilitarNavegador(boolean sw){
		
		btnPrimero.setEnabled(sw);
		btnAtras.setEnabled(sw);
		btnAdelante.setEnabled(sw);
		btnUltimo.setEnabled(sw);
		
		
	}

}
