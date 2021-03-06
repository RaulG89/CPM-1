package igu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.GridLayout;

import javax.swing.border.LineBorder;

import logica.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import java.awt.event.InputEvent;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel pnPrincipal;
	private JTextField txtPuntuacionLiebre;
	private JTextField txtPuntuacionTortuga;
	private JButton btnDado;
	private JLabel lblPuntuacion;
	private JPanel pnLiebre;
	private JTextField txtMovimientos;
	private JPanel pnTortuga;

	private Carrera carrera;
	private JLabel lbLiebre;
	private JLabel lblTortuga;
	private JMenuBar menuBar;
	private JMenu mnJuego;
	private JMenu mnAyuda;
	private JMenuItem mntmNuevo;
	private JMenuItem mntmSalir;
	private JMenuItem mntmContenido;
	private JMenuItem mntmAcercaDe;
	private JSeparator separatorJuego;
	private JSeparator separatorAyuda;

	private ActionBoton accionBoton; // Creo la clase privada

	private JMenu mnOpciones;
	private JMenuItem mntmNmeroDerboles;
	private VentanaOpciones vo;
	private JLabel lblTurnoTortuga;
	private JLabel lblTurnoLiebre;

	/**
	 * Receptor de evento Creamos esta clase para no tener que rellenar todos
	 * los botones manualmente
	 * 
	 * @author Iv�n Gonz�lez Mahagamage
	 *
	 */
	class ActionBoton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton boton = (JButton) e.getSource(); // Obtenemos el boton que
														// se pulsa
			jugar(Integer.parseInt(boton.getActionCommand()));

		}
	}

	/**
	 * Introduce la accion en todos los botones del panel
	 * 
	 * @param panel Panel a rellenar
	 */
	private void asociarEventosBotones(JPanel panel) {
		for (int i = 0; i < panel.getComponents().length; i++) {
			JButton boton = (JButton) panel.getComponents()[i];
			boton.setActionCommand(String.valueOf(i));
			boton.addActionListener(accionBoton);
		}
	}

	private JButton nuevoBoton(int posicion, String imagen) {
		JButton boton = new JButton();
		boton.setBackground(Color.BLACK);
		boton.setEnabled(true);
		boton.setDisabledIcon(
				new ImageIcon(VentanaPrincipal.class.getResource(imagen)));
		boton.setBorder(new LineBorder(Color.BLUE));
		boton.setBackground(Color.BLACK);
		boton.setForeground(Color.BLACK);
		return boton;
	}

	protected void crearPanelBotones(JPanel panel, int numBotones,
			String imagen) {
		for (int i = 0; i < numBotones; i++)
			panel.add(nuevoBoton(i, imagen));
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setResizable(false);
		vo = new VentanaOpciones(this);
		carrera = new Carrera();
		accionBoton = new ActionBoton();

		setIconImage(Toolkit.getDefaultToolkit().getImage(
				VentanaPrincipal.class.getResource("/img/liebre_peq.jpg")));
		setTitle("El juego de la liebre y la tortuga");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 86 * vo.getNumCasillas(), 390);
		setJMenuBar(getMenuBar_1());
		pnPrincipal = new JPanel();
		pnPrincipal.setBackground(Color.BLACK);
		pnPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnPrincipal);
		pnPrincipal.setLayout(null);
		pnPrincipal.add(getTxtPuntuacionLiebre());
		pnPrincipal.add(getTxtPuntuacionTortuga());
		pnPrincipal.add(getBtnDado());
		pnPrincipal.add(getTxtMovimientos());
		pnPrincipal.add(getLblPuntuacion());
		pnPrincipal.add(getPnLiebre());
		pnPrincipal.add(getPnTortuga());
		pnPrincipal.add(getLbLiebre());
		pnPrincipal.add(getLblTortuga());
		pnPrincipal.add(getLblTurnoTortuga());
		pnPrincipal.add(getLblTurnoLiebre());

		inicializar();
		this.setLocationRelativeTo(null);
	}

	private JLabel getLbLiebre() {
		if (lbLiebre == null) {
			lbLiebre = new JLabel("");
			lbLiebre.setIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/liebre_peq.jpg")));
			lbLiebre.setBounds(548, 36, 35, 32);
		}
		return lbLiebre;
	}

	private JLabel getLblTortuga() {
		if (lblTortuga == null) {
			lblTortuga = new JLabel("");
			lblTortuga.setIcon(new ImageIcon(VentanaPrincipal.class
					.getResource("/img/tortuga_peq.jpg")));
			lblTortuga.setBounds(548, 75, 35, 32);
		}
		return lblTortuga;
	}

	private JTextField getTxtPuntuacionLiebre() {
		if (txtPuntuacionLiebre == null) {
			txtPuntuacionLiebre = new JTextField();
			txtPuntuacionLiebre.setHorizontalAlignment(SwingConstants.CENTER);
			txtPuntuacionLiebre.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtPuntuacionLiebre.setText("0");
			txtPuntuacionLiebre.setForeground(Color.MAGENTA);
			txtPuntuacionLiebre.setBackground(Color.BLACK);
			txtPuntuacionLiebre.setEditable(false);
			txtPuntuacionLiebre.setBounds(593, 39, 125, 32);
			txtPuntuacionLiebre.setColumns(10);
		}
		return txtPuntuacionLiebre;
	}

	private JTextField getTxtPuntuacionTortuga() {
		if (txtPuntuacionTortuga == null) {
			txtPuntuacionTortuga = new JTextField();
			txtPuntuacionTortuga.setHorizontalAlignment(SwingConstants.CENTER);
			txtPuntuacionTortuga.setForeground(Color.MAGENTA);
			txtPuntuacionTortuga.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtPuntuacionTortuga.setText("0");
			txtPuntuacionTortuga.setBackground(Color.BLACK);
			txtPuntuacionTortuga.setEditable(false);
			txtPuntuacionTortuga.setColumns(10);
			txtPuntuacionTortuga.setBounds(593, 75, 125, 32);
		}
		return txtPuntuacionTortuga;
	}

	private JButton getBtnDado() {
		if (btnDado == null) {
			btnDado = new JButton("");
			btnDado.setDisabledIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/dado.jpg")));
			btnDado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (carrera.lanzarDado()) {
						txtMovimientos.setText(
								String.valueOf(carrera.getNumeroDado()));
						jugar(carrera.getNumeroDado()
								+ carrera.getCorredorActivo().getPosicion());
					} else {
						txtMovimientos.setText(
								String.valueOf(carrera.getNumeroDado()));
						JOptionPane.showMessageDialog(null,
								"Movimiento no v�lido.\nPasa turno");
					}
				}
			});
			btnDado.setToolTipText("Click para lanzar el dado");
			btnDado.setBorderPainted(false);
			btnDado.setIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/dado.jpg")));
			btnDado.setBounds(38, 24, 67, 92);
		}
		return btnDado;
	}

	private JLabel getLblPuntuacion() {
		if (lblPuntuacion == null) {
			lblPuntuacion = new JLabel("SCORE");
			lblPuntuacion.setFont(new Font("Jokerman", Font.PLAIN, 45));
			lblPuntuacion.setForeground(Color.YELLOW);
			lblPuntuacion.setBounds(352, 39, 168, 56);
		}
		return lblPuntuacion;
	}

	protected JPanel getPnLiebre() {
		if (pnLiebre == null) {
			pnLiebre = new JPanel();
			pnLiebre.setBackground(Color.BLACK);
			pnLiebre.setBounds(94, 140, (70 * vo.getNumCasillas()), 65);
			pnLiebre.setLayout(new GridLayout(1, 0, 0, 0)); // Configura numero
															// de filas, espacio
															// entre filas,
															// columnas, espacio
															// entre columnas
			crearPanelBotones(pnLiebre, vo.getNumCasillas(), "/img/liebre.jpg"); // Crea
																					// los
																					// botones
			asociarEventosBotones(pnLiebre); // A�ade las acciones
		}
		return pnLiebre;
	}

	private JTextField getTxtMovimientos() {
		if (txtMovimientos == null) {
			txtMovimientos = new JTextField();
			txtMovimientos.setBorder(null);
			txtMovimientos.setHorizontalAlignment(SwingConstants.CENTER);
			txtMovimientos.setEditable(false);
			txtMovimientos.setForeground(Color.GREEN);
			txtMovimientos
					.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 60));
			txtMovimientos.setBorder(null);
			txtMovimientos.setText("0");
			txtMovimientos.setBackground(Color.BLACK);
			txtMovimientos.setBounds(136, 24, 47, 77);
			txtMovimientos.setColumns(10);
		}
		return txtMovimientos;
	}

	private JPanel getPnTortuga() {
		if (pnTortuga == null) {
			pnTortuga = new JPanel();
			pnTortuga.setBackground(Color.BLACK);
			pnTortuga.setBounds(94, 223, (70 * vo.getNumCasillas()), 65);
			pnTortuga.setLayout(new GridLayout(1, 0, 0, 0));
			crearPanelBotones(pnTortuga, vo.getNumCasillas(),
					"/img/tortuga.jpg");
			asociarEventosBotones(pnTortuga);
		}
		return pnTortuga;
	}

	private void jugar(int posicion) {
		// Comprueba si la jugada es posible
		if (carrera.resolverJugada(posicion)) {
			representaEstado();
			btnDado.setEnabled(true);
		}

		// Indica de quien es el turno
		if (carrera.getCorredorActivo() == carrera.getLiebre()) {
			lblTurnoLiebre.setIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/flecha.jpg")));
			lblTurnoTortuga.setIcon(null);
		} else {
			lblTurnoTortuga.setIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/flecha.jpg")));
			lblTurnoLiebre.setIcon(null);
		}

		// Si un corredor cae en el agujero, pierde y se empieza otra vez
		if (carrera.getCorredorNoActivo().lesionado()) {
			JOptionPane.showMessageDialog(null,
					"Partida finalizada por ca�da\nSe ha lesionada la "
							+ carrera.getCorredorNoActivo().getNombre());
			btnDado.setEnabled(false);
			inicializar();
		}

		// Indica quien ha ganado
		if (carrera.isPartidaFinalizadaLiebre()) {
			JOptionPane.showMessageDialog(null,
					"Partida finalizada\n" + "El ganador es: la Liebre");
			btnDado.setEnabled(false);
			inicializar();
		} else if (carrera.isPartidaFinalizadaTortuga()) {
			JOptionPane.showMessageDialog(null,
					"Partida finalizada\n" + "El ganador es: la Tortuga");
			btnDado.setEnabled(false);
			inicializar();
		}
	}

	private void representaEstado() {
		txtPuntuacionLiebre
				.setText(String.valueOf(carrera.getLiebre().getPuntuacion()));
		txtPuntuacionTortuga
				.setText(String.valueOf(carrera.getTortuga().getPuntuacion()));
		pintarLiebre();
		pintarTortuga();
	}

	private void pintarCalle(Corredor corredor, Component[] botones) {
		String imagen = "/img/" + corredor.getFoto();
		String imagenArbol = "/img/arbol.jpg";
		String durmiendo = "/img/liebre_durmiendo.jpg";
		String imagenAgujero = "/img/agujero.png";
		String imagenPremio = "/img/estrella.jpg";
		for (int i = 0; i < botones.length; i++) {
			JButton boton = (JButton) botones[i];
			if (i == corredor.getPosicion()) {
				if (corredor.getCalleAsignada().getCasilla(i).tieneArbol()) {
					boton.setIcon(
							new ImageIcon(getClass().getResource(durmiendo)));
					boton.setDisabledIcon(
							new ImageIcon(getClass().getResource(durmiendo)));
				} else {
					boton.setIcon(
							new ImageIcon(getClass().getResource(imagen)));
					boton.setDisabledIcon(
							new ImageIcon(getClass().getResource(imagen)));
				}
			} else if (corredor.getCalleAsignada().getCasilla(i).tieneArbol()) {
				boton.setIcon(
						new ImageIcon(getClass().getResource(imagenArbol)));
				boton.setDisabledIcon(
						new ImageIcon(getClass().getResource(imagenArbol)));
			} else if (corredor.getCalleAsignada().getCasilla(i)
					.tieneAgujero()) {
				boton.setIcon(
						new ImageIcon(getClass().getResource(imagenAgujero)));
				boton.setDisabledIcon(
						new ImageIcon(getClass().getResource(imagenAgujero)));
			} else if (corredor.getCalleAsignada().getCasilla(i)
					.tienePremio()) {
				boton.setIcon(
						new ImageIcon(getClass().getResource(imagenPremio)));
				boton.setDisabledIcon(
						new ImageIcon(getClass().getResource(imagenPremio)));
			} else
				boton.setIcon(null);
		}
	}

	private void pintarLiebre() {
		pintarCalle(carrera.getLiebre(), pnLiebre.getComponents());
	}

	private void pintarTortuga() {
		pintarCalle(carrera.getTortuga(), pnTortuga.getComponents());
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnJuego());
			menuBar.add(getMnOpciones());
			menuBar.add(getMnAyuda());
		}
		return menuBar;
	}

	private JMenu getMnJuego() {
		if (mnJuego == null) {
			mnJuego = new JMenu("Juego");
			mnJuego.setMnemonic('j');
			mnJuego.add(getMntmNuevo());
			mnJuego.add(getSeparatorJuego());
			mnJuego.add(getMntmSalir());
		}
		return mnJuego;
	}

	private JMenu getMnAyuda() {
		if (mnAyuda == null) {
			mnAyuda = new JMenu("Ayuda");
			mnAyuda.setMnemonic('a');
			mnAyuda.add(getMntmContenido());
			mnAyuda.add(getSeparatorAyuda());
			mnAyuda.add(getMntmAcercaDe());
		}
		return mnAyuda;
	}

	private JMenuItem getMntmNuevo() {
		if (mntmNuevo == null) {
			mntmNuevo = new JMenuItem("Nuevo");
			mntmNuevo.setMnemonic('n');
			mntmNuevo.setMnemonic(KeyEvent.VK_F12);
			mntmNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inicializar();
				}
			});
			mntmNuevo
					.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F12, 0));
		}
		return mntmNuevo;
	}

	/**
	 * Modifica el numero de botones del panel
	 * 
	 * @param panel  Panel que queremos modificar
	 * @param imagen Imagen del corredor
	 */
	private void modificarPanel(JPanel panel, String imagen) {
		panel.setBounds(panel.getX(), panel.getY(), (70 * vo.getNumCasillas()),
				65);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		panel.removeAll(); // Borra lo que contenia
		crearPanelBotones(panel, vo.getNumCasillas() + 1, imagen);
		asociarEventosBotones(panel); // A�ade las acciones
	}

	/**
	 * Modifica la ventana cuando cambiamos el numero de casillas
	 */
	private void modificarVentana() {
		this.setBounds(100, 100, 86 * vo.getNumCasillas(), 390);
		this.setLocationRelativeTo(null);
		txtPuntuacionLiebre.setBounds(593 + (86 * (vo.getNumCasillas() - 10)),
				39, 125, 32);
		txtPuntuacionTortuga.setBounds(593 + (86 * (vo.getNumCasillas() - 10)),
				75, 125, 32);
		lbLiebre.setBounds(548 + (86 * (vo.getNumCasillas() - 10)), 36, 35, 32);
		lblTortuga.setBounds(548 + (86 * (vo.getNumCasillas() - 10)), 75, 35,
				32);
		lblPuntuacion.setBounds(352 + (86 * (vo.getNumCasillas() - 10)), 39,
				168, 56);
	}

	public void inicializar() {
		carrera.inicializarJuego(vo.getNumCasillas(), vo.getNumArboles());
		modificarVentana();
		modificarPanel(pnLiebre, "/img/liebre.jpg");
		modificarPanel(pnTortuga, "/img/tortuga.jpg");
		lblTurnoLiebre.setIcon(null);
		lblTurnoTortuga.setIcon(new ImageIcon(
				VentanaPrincipal.class.getResource("/img/flecha.jpg")));
		txtPuntuacionLiebre.setText("0");
		txtPuntuacionTortuga.setText("0");
		representaEstado();
		txtMovimientos.setText("0");
		btnDado.setEnabled(true);

	}

	private JMenuItem getMntmSalir() {
		if (mntmSalir == null) {
			mntmSalir = new JMenuItem("Salir");
			mntmSalir.setMnemonic('s');
			mntmSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,
					InputEvent.ALT_MASK));
		}
		return mntmSalir;
	}

	private JMenuItem getMntmContenido() {
		if (mntmContenido == null) {
			mntmContenido = new JMenuItem("Contenido");
			mntmContenido.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "Ayuda no disponible",
							"Ayuda", JOptionPane.QUESTION_MESSAGE);
				}
			});
			mntmContenido
					.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0)); // Para
																				// menus,
																				// funciona
																				// como
																				// el
																				// mnemonico
																				// pero
																				// sin
																				// pulsar
																				// Alt
			mntmContenido.setMnemonic('c');
			mntmContenido.setMnemonic(KeyEvent.VK_F1);
		}
		return mntmContenido;
	}

	private JMenuItem getMntmAcercaDe() {
		if (mntmAcercaDe == null) {
			mntmAcercaDe = new JMenuItem("Acerca de");
			mntmAcercaDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,
							"El juego de la Liebre y la Tortuga\nComunicaci�n Persona-Maquina 2015-2016\nEscuela de Informatica de Oviedo",
							"Acerca de", JOptionPane.INFORMATION_MESSAGE);
				}
			});
			mntmAcercaDe.setMnemonic('c');
		}
		return mntmAcercaDe;
	}

	private JSeparator getSeparatorJuego() {
		if (separatorJuego == null) {
			separatorJuego = new JSeparator();
		}
		return separatorJuego;
	}

	private JSeparator getSeparatorAyuda() {
		if (separatorAyuda == null) {
			separatorAyuda = new JSeparator();
		}
		return separatorAyuda;
	}

	private JMenu getMnOpciones() {
		if (mnOpciones == null) {
			mnOpciones = new JMenu("Opciones");
			mnOpciones.setMnemonic('o');
			mnOpciones.add(getMntmNmeroDerboles());
		}
		return mnOpciones;
	}

	private JMenuItem getMntmNmeroDerboles() {
		if (mntmNmeroDerboles == null) {
			mntmNmeroDerboles = new JMenuItem(
					"Configuraci\u00F3n de la partida");
			mntmNmeroDerboles.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarVentanaOpciones();
				}
			});
			mntmNmeroDerboles
					.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0));
		}
		return mntmNmeroDerboles;
	}

	/**
	 * Muestra la ventana de opciones del juego
	 */
	private void mostrarVentanaOpciones() {
		vo.setLocationRelativeTo(null);
		vo.setModal(true);
		vo.setVisible(true);
	}

	public Carrera getCarrera() {
		return carrera;
	}

	private JLabel getLblTurnoTortuga() {
		if (lblTurnoTortuga == null) {
			lblTurnoTortuga = new JLabel("");
			lblTurnoTortuga.setIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/flecha.jpg")));
			lblTurnoTortuga.setBounds(10, 216, 74, 77);
		}
		return lblTurnoTortuga;
	}

	private JLabel getLblTurnoLiebre() {
		if (lblTurnoLiebre == null) {
			lblTurnoLiebre = new JLabel("");
			lblTurnoLiebre.setBounds(10, 127, 74, 78);
		}
		return lblTurnoLiebre;
	}
}
