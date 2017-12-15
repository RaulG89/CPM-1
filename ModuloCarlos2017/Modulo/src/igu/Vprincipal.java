package igu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import logica.Catalogo;
import java.awt.CardLayout;
//import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Vprincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnInicio;
	private JPanel pnTitulo;
	private JPanel panel;
	private JPanel Titulo;
	private JLabel lblTitulo;
	// private RedimensionarImagen lblImagen;
	private JLabel lblImagen;
	private JButton btnCesta;
	private JPanel pnGeneral;
	private JPanel pnNavegador;
	private JPanel pnAyuda;
	private JPanel pnCarrito;
	private JPanel pnFiltros;
	private JPanel pnFechas;
	private JPanel pnTipo;
	private JPanel pnLlegada;
	private JPanel pnSalida;
	private JLabel lblLlegada;
	private JLabel lblSalida;
	private JComboBox<String> cbLlegadaDia;
	private JComboBox<String> cbLlegadaMes;
	private JComboBox<String> cbLlegadaAño;
	private JComboBox<String> cbSalidaDia;
	private JComboBox<String> cbSalidaMes;
	private JComboBox<String> cbSalidaAño;
	private JPanel pnBuscar;
	private JButton btnBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vprincipal frame = new Vprincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vprincipal() {
		/* Catalogo catalogo = new Catalogo(); */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 832, 648);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnTitulo(), BorderLayout.NORTH);
		contentPane.add(getPnInicio(), BorderLayout.CENTER);

	}

	private JPanel getPnInicio() {
		if (pnInicio == null) {
			pnInicio = new JPanel();
			pnInicio.setLayout(new BorderLayout(0, 0));
			pnInicio.add(getPnGeneral(), BorderLayout.CENTER);
			pnInicio.add(getPnNavegador(), BorderLayout.SOUTH);
		}
		return pnInicio;
	}

	private JPanel getPnTitulo() {
		if (pnTitulo == null) {
			pnTitulo = new JPanel();
			pnTitulo.setLayout(new BorderLayout(0, 0));
			pnTitulo.add(getPanel(), BorderLayout.CENTER);
			pnTitulo.add(getTitulo(), BorderLayout.SOUTH);
		}
		return pnTitulo;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(0, 2, 0, 0));
			panel.add(getPnAyuda());
			panel.add(getPnCarrito());
		}
		return panel;
	}

	private JPanel getTitulo() {
		if (Titulo == null) {
			Titulo = new JPanel();
			FlowLayout flowLayout = (FlowLayout) Titulo.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			Titulo.add(getLblTitulo());
		}
		return Titulo;
	}

	private JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel("TRAVEL PARK");
			lblTitulo.setFont(new Font("Hobo Std", Font.BOLD, 44));
		}
		return lblTitulo;
	}

	private JLabel getLblImagen() {
		if (lblImagen == null) {
			lblImagen = new JLabel("");
			lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
			lblImagen.setHorizontalTextPosition(SwingConstants.CENTER);
			lblImagen.setIcon(new ImageIcon(Vprincipal.class
					.getResource("/img/earth-globe-16807770.jpg")));
		}
		return lblImagen;
	}

	private JButton getBtnCesta() {
		if (btnCesta == null) {
			btnCesta = new JButton("");
			btnCesta.setBounds(0, 0, 20, 20);
			btnCesta.setIcon(new ImageIcon(
					Vprincipal.class.getResource("/img/carrito.png")));
		}
		return btnCesta;
	}

	private JPanel getPnGeneral() {
		if (pnGeneral == null) {
			pnGeneral = new JPanel();
			pnGeneral.setLayout(new CardLayout(0, 0));
			pnGeneral.add(getPnFiltros(), "name_5635305611685");
		}
		return pnGeneral;
	}

	private JPanel getPnNavegador() {
		if (pnNavegador == null) {
			pnNavegador = new JPanel();
			FlowLayout fl_pnNavegador = (FlowLayout) pnNavegador.getLayout();
			fl_pnNavegador.setAlignment(FlowLayout.RIGHT);
		}
		return pnNavegador;
	}

	private JPanel getPnAyuda() {
		if (pnAyuda == null) {
			pnAyuda = new JPanel();
			pnAyuda.setLayout(new BorderLayout(0, 0));
			pnAyuda.add(getLblImagen(), BorderLayout.WEST);
		}
		return pnAyuda;
	}

	private JPanel getPnCarrito() {
		if (pnCarrito == null) {
			pnCarrito = new JPanel();
			pnCarrito.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
			pnCarrito.add(getBtnCesta());
		}
		return pnCarrito;
	}

	private JPanel getPnFiltros() {
		if (pnFiltros == null) {
			pnFiltros = new JPanel();
			pnFiltros.setLayout(new GridLayout(4, 1, 0, 0));
			pnFiltros.add(getPanel_1_2());
			pnFiltros.add(getPnTipo());
			pnFiltros.add(getPanel_1_3());
		}
		return pnFiltros;
	}

	private JPanel getPanel_1_2() {
		if (pnFechas == null) {
			pnFechas = new JPanel();
			pnFechas.setLayout(new GridLayout(0, 2, 0, 0));
			pnFechas.add(getPnLlegada());
			pnFechas.add(getPnSalida());
		}
		return pnFechas;
	}

	/*
	 * private JPanel getPanel_2_1() { if (pnPersonas == null) { pnPersonas =
	 * new JPanel(); pnPersonas.setLayout(new BorderLayout(0, 0));
	 * pnPersonas.add(getPanel_5(), BorderLayout.CENTER); } return pnPersonas; }
	 */

	private JPanel getPnTipo() {
		if (pnTipo == null) {
			pnTipo = new JPanel();
			pnTipo.setLayout(new BorderLayout(0, 0));
			pnTipo.add(getPanel_6(), BorderLayout.NORTH);
			pnTipo.add(getPanel_2(), BorderLayout.SOUTH);
		}
		return pnTipo;
	}

	private JPanel getPnLlegada() {
		if (pnLlegada == null) {
			pnLlegada = new JPanel();
			pnLlegada.setLayout(new GridLayout(1, 0, 0, 0));
			pnLlegada.add(getLblLlegada());
			pnLlegada.add(getCbLlegadaDia());
			pnLlegada.add(getCbLlegadaMes());
			pnLlegada.add(getCbLlegadaAño());
		}
		return pnLlegada;
	}

	private JPanel getPnSalida() {
		if (pnSalida == null) {
			pnSalida = new JPanel();
			pnSalida.setLayout(new GridLayout(1, 0, 0, 0));
			pnSalida.add(getLblSalida());
			pnSalida.add(getCbSalidaDia());
			pnSalida.add(getCbSalidaMes());
			pnSalida.add(getCbSalidaAño());
		}
		return pnSalida;
	}

	private JLabel getLblLlegada() {
		if (lblLlegada == null) {
			lblLlegada = new JLabel("           Llegada:");
		}
		return lblLlegada;
	}

	private JLabel getLblSalida() {
		if (lblSalida == null) {
			lblSalida = new JLabel("             Salida:");
		}
		return lblSalida;
	}

	private JComboBox<String> getCbLlegadaDia() {
		if (cbLlegadaDia == null) {
			cbLlegadaDia = new JComboBox<String>();
			cbLlegadaDia.setModel(
					new DefaultComboBoxModel<String>(calculaDias(31)));
		}
		return cbLlegadaDia;
	}

	private JComboBox<String> getCbLlegadaMes() {
		if (cbLlegadaMes == null) {
			cbLlegadaMes = new JComboBox<String>();
			cbLlegadaMes.setModel(
					new DefaultComboBoxModel<String>(calculaFechas("mes")));
		}
		return cbLlegadaMes;
	}

	private JComboBox<String> getCbLlegadaAño() {
		if (cbLlegadaAño == null) {
			cbLlegadaAño = new JComboBox<String>();
			cbLlegadaAño.setModel(
					new DefaultComboBoxModel<String>(calculaFechas("año")));
		}
		return cbLlegadaAño;
	}

	private JComboBox<String> getCbSalidaDia() {
		if (cbSalidaDia == null) {
			cbSalidaDia = new JComboBox<String>();
			cbSalidaDia.setModel(
					new DefaultComboBoxModel<String>(calculaDias(31)));
		}
		return cbSalidaDia;
	}

	private JComboBox<String> getCbSalidaMes() {
		if (cbSalidaMes == null) {
			cbSalidaMes = new JComboBox<String>();
			cbSalidaMes.setModel(
					new DefaultComboBoxModel<String>(calculaFechas("mes")));
		}
		return cbSalidaMes;
	}

	private JComboBox<String> getCbSalidaAño() {
		if (cbSalidaAño == null) {
			cbSalidaAño = new JComboBox<String>();
			cbSalidaAño.setModel(
					new DefaultComboBoxModel<String>(calculaFechas("año")));
		}
		return cbSalidaAño;
	}

	private JPanel getPanel_1_3() {
		if (pnBuscar == null) {
			pnBuscar = new JPanel();
			pnBuscar.add(getBtnBuscar());
		}
		return pnBuscar;
	}

	private JButton getBtnBuscar() {
		if (btnBuscar == null) {
			btnBuscar = new JButton("Buscar");
			btnBuscar.setIcon(null);
		}
		return btnBuscar;
	}

	private String[] calculaFechas(String tipo) {
		int tope = 0;
		ArrayList<String> lista = new ArrayList<String>();

		switch (tipo) {
		case "dia":
			tope = 31;
			break;

		case "mes":
			tope = 12;
			break;

		case "año":
			tope = 20;
			break;

		case "personas":
			tope = 100;
			break;

		default:
			break;
		}
		if (tipo != "año") {
			for (int i = 0; i < tope; i++) {
				lista.add("" + (i + 1));
			}
		} else {
			for (int i = 0; i < tope; i++) {
				lista.add("" + (i + 2017));
			}
		}
		if (tipo != "personas") {
			for (int i = 0; i < tope; i++) {
				lista.add("" + (i + 1));
			}
		}

		String[] salida = new String[lista.size()];
		salida = lista.toArray(salida);
		return salida;
	}

	private String[] calculaDias(int tope) {
		ArrayList<String> lista = new ArrayList<String>();

		for (int i = 0; i < tope; i++) {
			lista.add("" + (i + 1));
		}
		String[] salida = new String[lista.size()];
		salida = lista.toArray(salida);
		return salida;
	}

	// private int comprobarFechas(int numero){
	// int tope = 0;
	// }
	private JPanel panel_6;
	private JRadioButton rdbtnAlojamiento;
	private JRadioButton rdbtnParque;
	private JRadioButton rdbtnAmbos;
	// private Container pnPais;
	// private JPanel panel_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel panel_2;
	private JLabel lblPaises;
	private JComboBox<String> cbPaises;
	private JPanel panel_3;

	private JPanel getPanel_6() {
		if (panel_6 == null) {
			panel_6 = new JPanel();
			panel_6.add(getRdbtnAlojamiento());
			panel_6.add(getRdbtnParque());
			panel_6.add(getRdbtnAmbos());
		}
		return panel_6;
	}

	private JRadioButton getRdbtnAlojamiento() {
		if (rdbtnAlojamiento == null) {
			rdbtnAlojamiento = new JRadioButton("Alojamiento");
			buttonGroup.add(rdbtnAlojamiento);
		}
		return rdbtnAlojamiento;
	}

	private JRadioButton getRdbtnParque() {
		if (rdbtnParque == null) {
			rdbtnParque = new JRadioButton("Parque");
			buttonGroup.add(rdbtnParque);
		}
		return rdbtnParque;
	}

	private JRadioButton getRdbtnAmbos() {
		if (rdbtnAmbos == null) {
			rdbtnAmbos = new JRadioButton("Parque+Alojamiento");
			buttonGroup.add(rdbtnAmbos);
		}
		return rdbtnAmbos;
	}

	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new BorderLayout(0, 0));
			panel_2.add(getPanel_3(), BorderLayout.NORTH);
		}
		return panel_2;
	}

	private JLabel getLblPaises() {
		if (lblPaises == null) {
			lblPaises = new JLabel("Pais: ");
		}
		return lblPaises;
	}

	private JComboBox<String> getCbPaises() {
		if (cbPaises == null) {
			cbPaises = new JComboBox<String>();
		}
		return cbPaises;
	}

	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.add(getLblPaises());
			panel_3.add(getCbPaises());
		}
		return panel_3;
	}
}