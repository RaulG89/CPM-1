package igu;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelFiltros extends JPanel {

	private static final long serialVersionUID = 1L;
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
	private Vprincipal2 v;

	public PanelFiltros(Vprincipal2 v1) {
		v = v1;
		this.setLayout(new BorderLayout(0, 0));
		this.add(getPnFiltros(), BorderLayout.NORTH);
		this.add(getPnBuscar(), BorderLayout.SOUTH);

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
			cbPersonas.setModel(new DefaultComboBoxModel<String>(
					calculaListas("personas")));
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
			cbPais.setModel(new DefaultComboBoxModel<String>(new String[] {
					"Seleccione un pais", "Afganistán", "Akrotiri", "Albania",
					"Alemania", "Andorra", "Angola", "Anguila", "Antártida",
					"Antigua y Barbuda", "Antillas Neerlandesas",
					"Arabia Saudí", "Arctic Ocean", "Argelia", "Argentina",
					"Armenia", "Aruba", "Atlantic Ocean", "Australia",
					"Austria", "Azerbaiyán", "Bahamas", "Bahráin", "Bangladesh",
					"Barbados", "Bélgica", "Belice", "Benín", "Bermudas",
					"Bielorrusia", "Birmania; Myanmar", "Bolivia",
					"Bosnia y Hercegovina", "Botsuana", "Brasil", "Brunéi",
					"Bulgaria", "Burkina Faso", "Burundi", "Bután",
					"Cabo Verde", "Camboya", "Camerún", "Canadá", "Chad",
					"Chile", "China", "Chipre", "Clipperton Island", "Colombia",
					"Comoras", "Congo", "Coral Sea Islands", "Corea del Norte",
					"Corea del Sur", "Costa de Marfil", "Costa Rica", "Croacia",
					"Cuba", "Dhekelia", "Dinamarca", "Dominica", "Ecuador",
					"Egipto", "El Salvador", "El Vaticano",
					"Emiratos Árabes Unidos", "Eritrea", "Eslovaquia",
					"Eslovenia", "España", "Estados Unidos", "Estonia",
					"Etiopía", "Filipinas", "Finlandia", "Fiyi", "Francia",
					"Gabón", "Gambia", "Gaza Strip", "Georgia", "Ghana",
					"Gibraltar", "Granada", "Grecia", "Groenlandia", "Guam",
					"Guatemala", "Guernsey", "Guinea", "Guinea Ecuatorial",
					"Guinea-Bissau", "Guyana", "Haití", "Honduras", "Hong Kong",
					"Hungría", "India", "Indian Ocean", "Indonesia", "Irán",
					"Iraq", "Irlanda", "Isla Bouvet", "Isla Christmas",
					"Isla Norfolk", "Islandia", "Islas Caimán", "Islas Cocos",
					"Islas Cook", "Islas Feroe", "Islas Heard y McDonald",
					"Islas Malvinas", "Islas Marianas del Norte",
					"Islas Marshall", "Islas Pitcairn", "Islas Salomón",
					"Islas Turcas y Caicos", "Islas Vírgenes Americanas",
					"Islas Vírgenes Británicas", "Israel", "Italia", "Jamaica",
					"Jan Mayen", "Japón", "Jersey", "Jordania", "Kazajistán",
					"Kenia", "Kirguizistán", "Kiribati", "Kuwait", "Laos",
					"Lesoto", "Letonia", "Líbano", "Liberia", "Libia",
					"Liechtenstein", "Lituania", "Luxemburgo", "Macao",
					"Macedonia", "Madagascar", "Malasia", "Malaui", "Maldivas",
					"Malí", "Malta", "Man, Isle of", "Marruecos", "Mauricio",
					"Mauritania", "Mayotte", "México", "Micronesia", "Moldavia",
					"Mónaco", "Mongolia", "Montenegro", "Montserrat",
					"Mozambique", "Mundo", "Namibia", "Nauru", "Navassa Island",
					"Nepal", "Nicaragua", "Níger", "Nigeria", "Niue", "Noruega",
					"Nueva Caledonia", "Nueva Zelanda", "Omán", "Pacific Ocean",
					"Países Bajos", "Pakistán", "Palaos", "Panamá",
					"Papúa-Nueva Guinea", "Paracel Islands", "Paraguay", "Perú",
					"Polinesia Francesa", "Polonia", "Portugal", "Puerto Rico",
					"Qatar", "Reino Unido", "República Centroafricana",
					"República Checa", "República del Congo",
					"República Dominicana", "Ruanda", "Rumania", "Rusia",
					"Sáhara Occidental", "Samoa", "Samoa Americana",
					"San Cristóbal y Nieves", "San Marino",
					"San Pedro y Miquelón", "San Vicente y las Granadinas",
					"Santa Helena", "Santa Lucía", "Santo Tomé y Príncipe",
					"Senegal", "Serbia", "Seychelles", "Sierra Leona",
					"Singapur", "Siria", "Somalia", "Southern Ocean",
					"Spratly Islands", "Sri Lanka", "Suazilandia", "Sudáfrica",
					"Sudán", "Suecia", "Suiza", "Surinam",
					"Svalbard y Jan Mayen", "Tailandia", "Taiwán", "Tanzania",
					"Tayikistán", "Timor Oriental", "Togo", "Tokelau", "Tonga",
					"Trinidad y Tobago", "Túnez", "Turkmenistán", "Turquía",
					"Tuvalu", "Ucrania", "Uganda", "Unión Europea", "Uruguay",
					"Uzbekistán", "Vanuatu", "Venezuela", "Vietnam",
					"Wake Island", "Wallis y Futuna", "West Bank", "Yemen",
					"Yibuti", "Zambia", "Zimbabue" }));
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
			lbTextoFiltros = new JLabel(
					"Seleccione el tipo de paquete vacacional que está buscando");
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
				public void actionPerformed(ActionEvent arg0) {
					((CardLayout) v.getPnCardLayout().getLayout()).next(v.getPnCardLayout());
				}
			});
		}
		return btnBuscar;
	}
}
