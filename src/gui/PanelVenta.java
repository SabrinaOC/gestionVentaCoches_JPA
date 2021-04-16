package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import model.Cliente;
import model.Coche;
import model.Concesionario;
import model.Venta;
import model.controllers.ControladorCliente;
import model.controllers.ControladorCoche;
import model.controllers.ControladorConcesionario;
import model.controllers.ControladorVenta;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class PanelVenta extends JPanel {
	private JTextField jtfId;
	private JTextField jtfFecha;
	private JTextField jtfPrecio;
	private Venta actual = null;
	private SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
	private JComboBox <Cliente> jcbIdCliente;
	private JComboBox <Concesionario> jcbIdConcesionario;
	private JComboBox <Coche> jcbIdCoche;
	private int idEliminado;

	public PanelVenta() {
		//cargamos la primera venta
		actual = ControladorVenta.getInstance().findPrimero();
		//lanzamos panel
		iniciar();
		//cargamos los jcombobox
		cargarDatosClientes();
		cargarDatosCoches();
		cargarDatosConcesionarios();
		//mostramos información en pantalla
		cargarActualEnPantalla();
	}
	
	/**
	 * Create the panel.
	 */
	public void iniciar() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 0;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Id cliente:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcbIdCliente = new JComboBox<Cliente>();
		GridBagConstraints gbc_jcbIdCliente = new GridBagConstraints();
		gbc_jcbIdCliente.insets = new Insets(0, 0, 5, 0);
		gbc_jcbIdCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbIdCliente.gridx = 1;
		gbc_jcbIdCliente.gridy = 1;
		add(jcbIdCliente, gbc_jcbIdCliente);
		
		JLabel lblNewLabel_2 = new JLabel("Id concesionario:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcbIdConcesionario = new JComboBox<Concesionario>();
		GridBagConstraints gbc_jcbIdConcesionario = new GridBagConstraints();
		gbc_jcbIdConcesionario.insets = new Insets(0, 0, 5, 0);
		gbc_jcbIdConcesionario.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbIdConcesionario.gridx = 1;
		gbc_jcbIdConcesionario.gridy = 2;
		add(jcbIdConcesionario, gbc_jcbIdConcesionario);
		
		JLabel lblNewLabel_3 = new JLabel("Id coche:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jcbIdCoche = new JComboBox<Coche>();
		GridBagConstraints gbc_jcbIdCoche = new GridBagConstraints();
		gbc_jcbIdCoche.insets = new Insets(0, 0, 5, 0);
		gbc_jcbIdCoche.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbIdCoche.gridx = 1;
		gbc_jcbIdCoche.gridy = 3;
		add(jcbIdCoche, gbc_jcbIdCoche);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfFecha = new JTextField();
		GridBagConstraints gbc_jtfFecha = new GridBagConstraints();
		gbc_jtfFecha.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFecha.gridx = 1;
		gbc_jtfFecha.gridy = 4;
		add(jtfFecha, gbc_jtfFecha);
		jtfFecha.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Precio venta:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtfPrecio = new JTextField();
		GridBagConstraints gbc_jtfPrecio = new GridBagConstraints();
		gbc_jtfPrecio.insets = new Insets(0, 0, 5, 0);
		gbc_jtfPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfPrecio.gridx = 1;
		gbc_jtfPrecio.gridy = 5;
		add(jtfPrecio, gbc_jtfPrecio);
		jtfPrecio.setColumns(10);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 6;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnPrimero = new JButton("<<");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorVenta.getInstance().findPrimero();
				cargarActualEnPantalla();
			}
		});
		panel.add(btnPrimero);
		
		JButton btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorVenta.getInstance().findAnterior(actual.getId());
				cargarActualEnPantalla();
			}
		});
		panel.add(btnAnterior);
		
		JButton btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorVenta.getInstance().findSiguiente(actual.getId());
				cargarActualEnPantalla();
			}
		});
		panel.add(btnSiguiente);
		
		JButton btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorVenta.getInstance().findUltimo();
				cargarActualEnPantalla();
			}
		});
		panel.add(btnUltimo);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vaciarCampos();
			}
		});
		panel.add(btnNuevo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		panel.add(btnGuardar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
				
			}
		});
		panel.add(btnEliminar);
		

	}
	
	/**
	 * Método para cargar datos de los clientes jcb
	 */
	private void cargarDatosClientes() {
		List<Cliente> clientes = ControladorCliente.getInstance().findAll();
		
		for (Cliente c : clientes) {
			this.jcbIdCliente.addItem(c);
		}
	}
	
	/**
	 * Método para cargar datos de los concesionario jcb
	 */
	private void cargarDatosConcesionarios() {
		List<Concesionario> concesionarios = ControladorConcesionario.getInstance().findAll();
		
		for (Concesionario c : concesionarios) {
			this.jcbIdConcesionario.addItem(c);
		}
	}
	
	/**
	 * Método para cargar datos de los coches jcb
	 */
	private void cargarDatosCoches() {
		List<Coche> coches = ControladorCoche.getInstance().findAll();
		
		for (Coche c : coches) {
			this.jcbIdCoche.addItem(c);
		}
	}
	
	/**
	 * 
	 */
	private void cargarActualEnPantalla() {
		if (this.actual != null) {
			this.jtfId.setText("" + this.actual.getId());
			this.jtfFecha.setText("" + this.actual.getFecha());
			this.jtfPrecio.setText("" + this.actual.getPrecioVenta());
		}

		// Carga del cliente adecuado comparando el id de cliente de la venta actual
		// con el id del cliente del combobox
		for (int i = 0; i < this.jcbIdCliente.getItemCount(); i++) {
			if (this.actual.getCliente().getId() == (this.jcbIdCliente.getItemAt(i)).getId()) {
				this.jcbIdCliente.setSelectedIndex(i);
			}
		}
		//hacemos lo mismo para los concesionarios y los coches
		for (int i = 0; i < this.jcbIdConcesionario.getItemCount(); i++) {
			if (this.actual.getConcesionario().getId() == (this.jcbIdConcesionario.getItemAt(i)).getId()) {
				this.jcbIdConcesionario.setSelectedIndex(i);
			}
		}
		for (int i = 0; i < this.jcbIdCoche.getItemCount(); i++) {
			if (this.actual.getCoche().getId() == (this.jcbIdCoche.getItemAt(i)).getId()) {
				this.jcbIdCoche.setSelectedIndex(i);
			}
		}
	}
	
	/**
	 * Método para guardar los datos de la pantalla en la BBDD
	 */
	private void cargarActualDesdePantalla() {
		this.actual.setId(Integer.parseInt(jtfId.getText()));
		//creamos objeto de tipo cliente para guardar en el el cliente seleccionado del jcb y luego poder presentarlo en pantalla
		Cliente c = (Cliente) jcbIdCliente.getSelectedItem();
		this.actual.setCliente(c);
		//hacemos lo mismo para el resto de campos jcb, concesionario y coche
		Concesionario con = (Concesionario) jcbIdConcesionario.getSelectedItem();
		this.actual.setConcesionario(con);
		Coche co = (Coche) jcbIdCoche.getSelectedItem();
		this.actual.setCoche(co);
		//this.actual.setFecha(this.jtfFecha.getText());
		this.actual.setPrecioVenta(Float.parseFloat(jtfPrecio.getText()));
		
		
		try {
			this.actual.setFecha(this.formato.parse(this.jtfFecha.getText()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Método para vaciar campos
	 */
	private void vaciarCampos() {
		this.jtfId.setText("0");
		this.jtfFecha.setText("");
		this.jtfPrecio.setText("");
	
	}
	
	/**
	 * Método para guardar información en BBDD
	 */
	private void guardar() {
		cargarActualDesdePantalla();
		boolean resultado = ControladorVenta.getInstance().guardar(this.actual);
		// Decido si se trata de guardar un registro existente o nuevo
		if (resultado && this.actual.getId() > 0 && this.actual != null ) { // Modificación
			ControladorVenta.getInstance().guardar(this.actual);
			JOptionPane.showMessageDialog(null, "Registro guardado correctamente");
			
		}
		else { // Alta -  nuevo
			JOptionPane.showMessageDialog(null, "Error al guardar registro");
			
		}
		
		cargarActualDesdePantalla();
	}
	
	/**
	 * Método para eliminar ventas de la BBDD
	 */
	private void eliminar() {
		
		String posiblesRespuestas[] = {"Sí","No"};
		// En esta opci�n se utiliza un showOptionDialog en el que personalizo el icono mostrado
		int opcionElegida = JOptionPane.showOptionDialog(null, "¿Desea eliminar?", "Gestión venta de coches", 
		        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, posiblesRespuestas, posiblesRespuestas[1]);
	    if(opcionElegida == 0) {
	    	ControladorVenta.getInstance().borrar(this.actual);
	    	
	    	vaciarCampos();
	    	JOptionPane.showMessageDialog(null, "Eliminado correctamente");
	    	
	    }
	  //para que no se quede vacío después de eliminar un registro, cargamos el último en pantalla
	    this.actual = ControladorVenta.getInstance().findAnterior(idEliminado);
	    cargarActualEnPantalla();
	}
	
}
