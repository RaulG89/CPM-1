package igu;

//import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.ButtonGroup;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vprincipal2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnCabecera;
	private JPanel pnAyudaCarrito;
	private JPanel pnTitulo;
	private JLabel lblTitulo;
	// private RedimensionarImagen lblImagen;
	private JLabel lblImagen;
	private JButton btnCarrito;
	private JPanel pnLogo;
	private JPanel pnCarrito;
	private JPanel pnPrincipal;
	private JPanel pnFiltros;
	private JPanel pnBuscar;
	private JPanel pnFechas;
	private JPanel pnPersonas;
	private JPanel pnPais;
	private JPanel pnLlegada;
	private JPanel pnSalida;
	private JLabel lblLlegada;
	private JLabel lblSalida;
	private JDateChooser dcLlegada;
	private JDateChooser dcSalida;
	private JLabel lblPersonas;
	private JComboBox<String> cbPersonas;
	private JLabel lblPais;
	private JComboBox<String> cbPais;
	private JPanel pnTexto;
	private JLabel lbTextoFiltros;
	private JPanel pnAlojamiento;
	private JRadioButton rbAlojamiento;
	private JPanel pnParque;
	private JRadioButton rbParque;
	private JPanel pnAlojamientoParque;
	private JRadioButton rbAmbos;
	private JButton btnBuscar;
	private Date date;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnAyuda;
	private JPanel pnAyuda;
	private JPanel pnCardLayout;
	private JPanel pnResultados;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel label;
	private JPanel panel_2;
	private JLabel label_1;
	private JTextArea textArea;
	private JPanel panel_3;
	private JLabel label_2;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vprincipal2 frame = new Vprincipal2();
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
	public Vprincipal2() {
		setResizable(false);
		/* Catalogo catalogo = new Catalogo(); */
		//LIBRERIA JCALENDAAAAAAAAAAAAR
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 648);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPnCabecera(), BorderLayout.NORTH);
		contentPane.add(getPnCardLayout(), BorderLayout.CENTER);
		((CardLayout)pnCardLayout.getLayout()).first(pnCardLayout);

	}

	private JPanel getPnCabecera() {
		if (pnCabecera == null) {
			pnCabecera = new JPanel();
			pnCabecera.setLayout(new BorderLayout(0, 0));
			pnCabecera.add(getPnAyudaCarrito(), BorderLayout.CENTER);
			pnCabecera.add(getPnTitulo(), BorderLayout.SOUTH);
		}
		return pnCabecera;
	}

	private JPanel getPnAyudaCarrito() {
		if (pnAyudaCarrito == null) {
			pnAyudaCarrito = new JPanel();
			pnAyudaCarrito.setLayout(new GridLayout(0, 2, 0, 0));
			pnAyudaCarrito.add(getPnLogo());
			pnAyudaCarrito.add(getPnCarrito());
		}
		return pnAyudaCarrito;
	}

	private JPanel getPnTitulo() {
		if (pnTitulo == null) {
			pnTitulo = new JPanel();
			FlowLayout fl_pnTitulo = (FlowLayout) pnTitulo.getLayout();
			fl_pnTitulo.setAlignment(FlowLayout.LEFT);
			pnTitulo.add(getLblTitulo());
		}
		return pnTitulo;
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
			lblImagen.setIcon(new ImageIcon(Vprincipal2.class.getResource("/img/logo2.png")));
		}
		return lblImagen;
	}

	private JButton getBtnCarrito() {
		if (btnCarrito == null) {
			btnCarrito = new JButton("");
			btnCarrito.setBounds(0, 0, 20, 20);
			btnCarrito.setIcon(new ImageIcon(Vprincipal2.class.getResource("/img/carrito.png")));
		}
		return btnCarrito;
	}

	private JPanel getPnLogo() {
		if (pnLogo == null) {
			pnLogo = new JPanel();
			pnLogo.setLayout(new BorderLayout(0, 0));
			pnLogo.add(getLblImagen(), BorderLayout.WEST);
			pnLogo.add(getPnAyuda(), BorderLayout.NORTH);
		}
		return pnLogo;
	}

	private JPanel getPnCarrito() {
		if (pnCarrito == null) {
			pnCarrito = new JPanel();
			pnCarrito.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
			pnCarrito.add(getBtnCarrito());
		}
		return pnCarrito;
	}

	private String[] calculaListas(String tipo) {
		int tope = 0;
		ArrayList<String> lista = new ArrayList<String>();

		switch (tipo) {

		case "personas":
			tope = 100;
			break;

		default:
			break;
		}

		if (tipo == "personas") {
			for (int i = 0; i < tope; i++) {
				lista.add("" + (i + 1));
			}
		}

		String[] salida = new String[lista.size()];
		salida = lista.toArray(salida);
		return salida;
	}

	private JPanel getPnPrincipal() {
		if (pnPrincipal == null) {
			pnPrincipal = new JPanel();
			pnPrincipal.setLayout(new BorderLayout(0, 0));
			pnPrincipal.add(getPnFiltros(), BorderLayout.NORTH);
			pnPrincipal.add(getPnBuscar(), BorderLayout.SOUTH);
		}
		return pnPrincipal;
	}

	private JPanel getPnFiltros() {
		if (pnFiltros == null) {
			pnFiltros = new JPanel();
			pnFiltros.setLayout(new GridLayout(0, 1, 0, 0));
			pnFiltros.add(getPnFechas());
			pnFiltros.add(getPnPersonas());
			pnFiltros.add(getPnPais());
			pnFiltros.add(getPnTexto());
			pnFiltros.add(getPnAlojamientoParque());
			pnFiltros.add(getPnAlojamiento());
			pnFiltros.add(getPnParque());
		}
		return pnFiltros;
	}

	private JPanel getPnBuscar() {
		if (pnBuscar == null) {
			pnBuscar = new JPanel();
			pnBuscar.add(getBtnBuscar());
		}
		return pnBuscar;
	}

	private JPanel getPnFechas() {
		if (pnFechas == null) {
			pnFechas = new JPanel();
			pnFechas.setLayout(new GridLayout(0, 2, 0, 0));
			pnFechas.add(getPnLlegada());
			pnFechas.add(getPnSalida());
		}
		return pnFechas;
	}

	private JPanel getPnPersonas() {
		if (pnPersonas == null) {
			pnPersonas = new JPanel();
			pnPersonas.add(getLblPersonas());
			pnPersonas.add(getCbPersonas());
		}
		return pnPersonas;
	}

	private JPanel getPnPais() {
		if (pnPais == null) {
			pnPais = new JPanel();
			pnPais.add(getLblPais());
			pnPais.add(getCbPais());
		}
		return pnPais;
	}

	private JPanel getPnLlegada() {
		if (pnLlegada == null) {
			pnLlegada = new JPanel();
			pnLlegada.add(getLblLlegada());
			pnLlegada.add(getDcLlegada());
		}
		return pnLlegada;
	}

	private JPanel getPnSalida() {
		if (pnSalida == null) {
			pnSalida = new JPanel();
			pnSalida.add(getLblSalida());
			pnSalida.add(getDcSalida());

		}
		return pnSalida;
	}

	private JLabel getLblLlegada() {
		if (lblLlegada == null) {
			lblLlegada = new JLabel("Llegada:");
		}
		return lblLlegada;
	}

	private JLabel getLblSalida() {
		if (lblSalida == null) {
			lblSalida = new JLabel("Salida:");
		}
		return lblSalida;
	}

	private JDateChooser getDcLlegada() {
		if (dcLlegada == null) {
			dcLlegada = new JDateChooser();
			dcLlegada.setMinSelectableDate(new Date());
			dcLlegada.setDate(new Date());

			dcLlegada.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent evt) {
					if (dcLlegada.getDate() != null) {
						date = dcLlegada.getDate();
						dcSalida.setMinSelectableDate(date);
						dcSalida.setEnabled(true);
					}
				}
			});

		}
		return dcLlegada;
	}

	private JDateChooser getDcSalida() {
		if (dcSalida == null) {
			dcSalida = new JDateChooser();
			dcSalida.setMinSelectableDate(dcLlegada.getMinSelectableDate());
			dcSalida.setEnabled(false);
			if (dcLlegada.getDate() != null) {
				dcSalida.setMinSelectableDate(dcLlegada.getDate());
				dcSalida.setEnabled(true);

			}
		}
		return dcSalida;

	}

	private JLabel getLblPersonas() {
		if (lblPersonas == null) {
			lblPersonas = new JLabel("Nº de Personas:");
		}
		return lblPersonas;
	}

	private JComboBox<String> getCbPersonas() {
		if (cbPersonas == null) {
			cbPersonas = new JComboBox<String>();
			cbPersonas.setModel(new DefaultComboBoxModel<String>(calculaListas("personas")));
		}
		return cbPersonas;
	}

	private JLabel getLblPais() {
		if (lblPais == null) {
			lblPais = new JLabel("Pais:");
		}
		return lblPais;
	}

	private JComboBox<String> getCbPais() {
		if (cbPais == null) {
			cbPais = new JComboBox<String>();
			cbPais.setModel(new DefaultComboBoxModel<String>(new String[] { "Seleccione un pais", "Afganistán",
					"Akrotiri", "Albania", "Alemania", "Andorra", "Angola", "Anguila", "Antártida", "Antigua y Barbuda",
					"Antillas Neerlandesas", "Arabia Saudí", "Arctic Ocean", "Argelia", "Argentina", "Armenia", "Aruba",
					"Atlantic Ocean", "Australia", "Austria", "Azerbaiyán", "Bahamas", "Bahráin", "Bangladesh",
					"Barbados", "Bélgica", "Belice", "Benín", "Bermudas", "Bielorrusia", "Birmania; Myanmar", "Bolivia",
					"Bosnia y Hercegovina", "Botsuana", "Brasil", "Brunéi", "Bulgaria", "Burkina Faso", "Burundi",
					"Bután", "Cabo Verde", "Camboya", "Camerún", "Canadá", "Chad", "Chile", "China", "Chipre",
					"Clipperton Island", "Colombia", "Comoras", "Congo", "Coral Sea Islands", "Corea del Norte",
					"Corea del Sur", "Costa de Marfil", "Costa Rica", "Croacia", "Cuba", "Dhekelia", "Dinamarca",
					"Dominica", "Ecuador", "Egipto", "El Salvador", "El Vaticano", "Emiratos Árabes Unidos", "Eritrea",
					"Eslovaquia", "Eslovenia", "España", "Estados Unidos", "Estonia", "Etiopía", "Filipinas",
					"Finlandia", "Fiyi", "Francia", "Gabón", "Gambia", "Gaza Strip", "Georgia", "Ghana", "Gibraltar",
					"Granada", "Grecia", "Groenlandia", "Guam", "Guatemala", "Guernsey", "Guinea", "Guinea Ecuatorial",
					"Guinea-Bissau", "Guyana", "Haití", "Honduras", "Hong Kong", "Hungría", "India", "Indian Ocean",
					"Indonesia", "Irán", "Iraq", "Irlanda", "Isla Bouvet", "Isla Christmas", "Isla Norfolk", "Islandia",
					"Islas Caimán", "Islas Cocos", "Islas Cook", "Islas Feroe", "Islas Heard y McDonald",
					"Islas Malvinas", "Islas Marianas del Norte", "Islas Marshall", "Islas Pitcairn", "Islas Salomón",
					"Islas Turcas y Caicos", "Islas Vírgenes Americanas", "Islas Vírgenes Británicas", "Israel",
					"Italia", "Jamaica", "Jan Mayen", "Japón", "Jersey", "Jordania", "Kazajistán", "Kenia",
					"Kirguizistán", "Kiribati", "Kuwait", "Laos", "Lesoto", "Letonia", "Líbano", "Liberia", "Libia",
					"Liechtenstein", "Lituania", "Luxemburgo", "Macao", "Macedonia", "Madagascar", "Malasia", "Malaui",
					"Maldivas", "Malí", "Malta", "Man, Isle of", "Marruecos", "Mauricio", "Mauritania", "Mayotte",
					"México", "Micronesia", "Moldavia", "Mónaco", "Mongolia", "Montenegro", "Montserrat", "Mozambique",
					"Mundo", "Namibia", "Nauru", "Navassa Island", "Nepal", "Nicaragua", "Níger", "Nigeria", "Niue",
					"Noruega", "Nueva Caledonia", "Nueva Zelanda", "Omán", "Pacific Ocean", "Países Bajos", "Pakistán",
					"Palaos", "Panamá", "Papúa-Nueva Guinea", "Paracel Islands", "Paraguay", "Perú",
					"Polinesia Francesa", "Polonia", "Portugal", "Puerto Rico", "Qatar", "Reino Unido",
					"República Centroafricana", "República Checa", "República del Congo", "República Dominicana",
					"Ruanda", "Rumania", "Rusia", "Sáhara Occidental", "Samoa", "Samoa Americana",
					"San Cristóbal y Nieves", "San Marino", "San Pedro y Miquelón", "San Vicente y las Granadinas",
					"Santa Helena", "Santa Lucía", "Santo Tomé y Príncipe", "Senegal", "Serbia", "Seychelles",
					"Sierra Leona", "Singapur", "Siria", "Somalia", "Southern Ocean", "Spratly Islands", "Sri Lanka",
					"Suazilandia", "Sudáfrica", "Sudán", "Suecia", "Suiza", "Surinam", "Svalbard y Jan Mayen",
					"Tailandia", "Taiwán", "Tanzania", "Tayikistán", "Timor Oriental", "Togo", "Tokelau", "Tonga",
					"Trinidad y Tobago", "Túnez", "Turkmenistán", "Turquía", "Tuvalu", "Ucrania", "Uganda",
					"Unión Europea", "Uruguay", "Uzbekistán", "Vanuatu", "Venezuela", "Vietnam", "Wake Island",
					"Wallis y Futuna", "West Bank", "Yemen", "Yibuti", "Zambia", "Zimbabue" }));
		}
		return cbPais;
	}

	private JPanel getPnTexto() {
		if (pnTexto == null) {
			pnTexto = new JPanel();
			pnTexto.add(getLbTextoFiltros());
		}
		return pnTexto;
	}

	private JLabel getLbTextoFiltros() {
		if (lbTextoFiltros == null) {
			lbTextoFiltros = new JLabel("Seleccione el tipo de paquete vacacional que está buscando");
		}
		return lbTextoFiltros;
	}

	private JPanel getPnAlojamiento() {
		if (pnAlojamiento == null) {
			pnAlojamiento = new JPanel();
			pnAlojamiento.add(getRbAlojamiento());
		}
		return pnAlojamiento;
	}

	private JRadioButton getRbAlojamiento() {
		if (rbAlojamiento == null) {
			rbAlojamiento = new JRadioButton("Alojamiento");
			buttonGroup.add(rbAlojamiento);
		}
		return rbAlojamiento;
	}

	private JPanel getPnParque() {
		if (pnParque == null) {
			pnParque = new JPanel();
			pnParque.add(getRbParque());
		}
		return pnParque;
	}

	private JRadioButton getRbParque() {
		if (rbParque == null) {
			rbParque = new JRadioButton("Parque");
			buttonGroup.add(rbParque);
		}
		return rbParque;
	}

	private JPanel getPnAlojamientoParque() {
		if (pnAlojamientoParque == null) {
			pnAlojamientoParque = new JPanel();
			pnAlojamientoParque.add(getRbAmbos());
		}
		return pnAlojamientoParque;
	}

	private JRadioButton getRbAmbos() {
		if (rbAmbos == null) {
			rbAmbos = new JRadioButton("Alojamiento+Parque");
			buttonGroup.add(rbAmbos);
		}
		return rbAmbos;
	}

	private JButton getBtnBuscar() {
		if (btnBuscar == null) {
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout) pnCardLayout.getLayout()).next(pnCardLayout);
				}
			});
		}
		return btnBuscar;
	}
	private JButton getBtnAyuda() {
		if (btnAyuda == null) {
			btnAyuda = new JButton("Ayuda");
		}
		return btnAyuda;
	}
	private JPanel getPnAyuda() {
		if (pnAyuda == null) {
			pnAyuda = new JPanel();
			FlowLayout fl_pnAyuda = (FlowLayout) pnAyuda.getLayout();
			fl_pnAyuda.setAlignment(FlowLayout.LEFT);
			pnAyuda.add(getBtnAyuda());
		}
		return pnAyuda;
	}
	JPanel getPnCardLayout() {
		if (pnCardLayout == null) {
			pnCardLayout = new JPanel();
			pnCardLayout.setLayout(new CardLayout(0, 0));
			pnPrincipal = new PanelFiltros(this);
			pnCardLayout.add(getPnPrincipal(), "name_45313710148855");
			pnCardLayout.add(getPnResultados(), "name_45329308444284");
		}
		return pnCardLayout;
	}
	private JPanel getPnResultados() {
		if (pnResultados == null) {
			pnResultados = new JPanel();
			pnResultados.setLayout(new BorderLayout(0, 0));
			pnResultados.add(getPanel());
		}
		return pnResultados;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 3, true), "Resultados",
								TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setLayout(new GridLayout(1, 0, 0, 0));
			panel.add(getPanel_1());
			panel.add(getPanel_2());
			panel.add(getPanel_3());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.add(getLabel());
		}
		return panel_1;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("imagen del hotel");
		}
		return label;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new GridLayout(0, 1, 0, 0));
			panel_2.add(getLabel_1());
			panel_2.add(getTextArea());
		}
		return panel_2;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("Hotel El Retiro ****");
			label_1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		}
		return label_1;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setWrapStyleWord(true);
			textArea.setLineWrap(true);
			textArea.setEditable(false);
//			textArea.setDropMode(DropMode.ON);
		}
		return textArea;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setLayout(new GridLayout(0, 1, 0, 0));
			panel_3.add(getLabel_2());
			panel_3.add(getButton());
		}
		return panel_3;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("Precio");
		}
		return label_2;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("Comprar");
		}
		return button;
	}
}