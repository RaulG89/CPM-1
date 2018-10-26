package igu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import logica.Dado;
import logica.Juego;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton botonDado;
	private JTextField txtScore;
	private JPanel panelTablero;
	private JPanel panelContador;
	private Juego juego;
	private AccionBoton aB;
	private JTextField txtDado;
	private JTextField txtPuntuacion;

	class AccionBoton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("asdsad");
			JButton bt = (JButton) e.getSource();
			jugar(Integer.parseInt(bt.getActionCommand()));
		}
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
		juego = new Juego(preguntarTrampas());
		aB = new AccionBoton();
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				VentanaPrincipal.class.getResource("/img/liebre.JPG")));
		setTitle("El juego de la Liebre y la Zanahoria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 398);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBotonDado());
		contentPane.add(getTxtScore());
		contentPane.add(getPanelTablero());
		contentPane.add(getPanel_Contador());
		creaBotonesTablero();
		txtDado = new JTextField();
		txtDado.setText("0");
		txtDado.setForeground(Color.GREEN);
		txtDado.setHorizontalAlignment(SwingConstants.CENTER);
		txtDado.setFont(new Font("Tahoma", Font.PLAIN, 50));
		txtDado.setEditable(false);
		txtDado.setBackground(Color.BLACK);
		txtDado.setBounds(122, 46, 129, 74);
		contentPane.add(txtDado);
		txtDado.setColumns(10);
		txtDado.setBorder(null);
		this.asociarEventosBotones();
		pintarTablero();
	}

	private void inicializar() {
		juego.inicializarJuego(preguntarTrampas());
		pintarPuntos();
		pintarTablero();
		botonDado.setEnabled(true);
		txtDado.setText("");
		Component[] botones = panelTablero.getComponents();
		JButton btnMeta = (JButton) botones[juego.DIM - 1];
		btnMeta.setIcon(new ImageIcon(
				VentanaPrincipal.class.getResource("/img/zanahoria.jpg")));
		btnMeta.setDisabledIcon(new ImageIcon(
				VentanaPrincipal.class.getResource("/img/zanahoria.jpg")));

	}

	private void creaBotonesTablero() {
		for (int i = 0; i < juego.DIM; i++) {
			panelTablero.add(nuevoBoton(i));
		}
	}

	private JButton nuevoBoton(int posicion) {
		JButton boton = new JButton("");
		boton.setBackground(Color.BLACK);
		boton.setActionCommand(String.valueOf(posicion));
		boton.addActionListener(aB);
		return boton;
	}

	private int preguntarTrampas() {
		String[] numTrampas = { "0", "1", "2", "3", "4" };
		String resp = (String) JOptionPane.showInputDialog(null,
				"Seleccione el número de trampas", "Trampas",
				JOptionPane.DEFAULT_OPTION, null, numTrampas, numTrampas[0]);
		return Integer.parseInt(resp);
	}

	private boolean controlJugar = false;

	private void jugar(int posicion) {
		if (!controlJugar) {
			controlJugar = true;
			if (juego.resolverJugada(posicion)) {
				representarEstadoJuego();
				deshabilitarPanel();
			}
		} else {
			controlJugar = false;
		}
	}

	private JButton getBotonDado() {
		if (botonDado == null) {
			botonDado = new JButton("");
			botonDado.setToolTipText("Pulsa para lanzar");
			botonDado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lanzarDado();
				}
			});
			botonDado.setIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/dado.JPG")));
			botonDado.setDisabledIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/dado.JPG")));
			botonDado.setBounds(51, 46, 61, 86);
			botonDado.setBorderPainted(false);
		}
		return botonDado;
	}

	private void lanzarDado() {
		boolean jugadaPosible = juego.lanzarDado();
		txtDado.setText(String.valueOf(Dado.getValor()));
		if (jugadaPosible) {
			habilitarPanel();
			botonDado.setEnabled(false);
		} else {
			JOptionPane.showMessageDialog(this, "La jugada no es posible");
			txtDado.setText("");
		}

	}

	private void representarEstadoJuego() {
		if (juego.isPartidaFinalizadaTrampa()) {
			if (!juego.getLiebre().isSuperpoder()) {
				JOptionPane.showMessageDialog(this, "Partida finalizada");
				inicializar();
			} else {
				juego.luison();
				botonDado.setEnabled(true);
				txtDado.setText("");
			}
		} else if (juego.isPartidaFinalizada()) {
			JOptionPane.showMessageDialog(this, "Partida finalizada");
			inicializar();
		} else {
			botonDado.setEnabled(true);
			txtDado.setText("");
		}
		pintarPuntos();
		pintarTablero();
	}

	private JTextField getTxtScore() {
		if (txtScore == null) {
			txtScore = new JTextField();
			txtScore.setEditable(false);
			txtScore.setBackground(new Color(0, 0, 0));
			txtScore.setForeground(Color.YELLOW);
			txtScore.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 46));
			txtScore.setToolTipText("");
			txtScore.setText("SCORE");
			txtScore.setBounds(505, 46, 201, 86);
			txtScore.setColumns(10);
			txtScore.setBorder(null);
		}
		return txtScore;
	}

	private JPanel getPanelTablero() {
		if (panelTablero == null) {
			panelTablero = new JPanel();
			panelTablero.setEnabled(false);
			panelTablero.setBorder(new LineBorder(Color.BLUE, 5));
			panelTablero.setBackground(Color.BLUE);
			panelTablero.setBounds(84, 194, 725, 85);
			panelTablero.setLayout(new GridLayout(1, 11, 2, 0));

		}
		return panelTablero;
	}

	private JPanel getPanel_Contador() {
		if (panelContador == null) {
			panelContador = new JPanel();
			panelContador.setToolTipText("");
			panelContador.setBackground(Color.BLACK);
			panelContador.setBorder(new LineBorder(Color.WHITE, 3));
			panelContador.setBounds(734, 46, 139, 86);
			panelContador.setLayout(new BorderLayout(0, 0));
			panelContador.add(getTxtPuntuacion(), BorderLayout.CENTER);
		}
		return panelContador;
	}

	private void asociarEventosBotones() {
		for (Component c : panelTablero.getComponents()) {
			JButton btn = (JButton) c;
			btn.addActionListener(aB);
		}
	}

	private void modificarPanel(JPanel panel, boolean habilitado) {
		for (Component componente : panel.getComponents()) {
			componente.setEnabled(habilitado);
		}
	}

	private void habilitarPanel() {
		modificarPanel(panelTablero, true);

	}

	private void deshabilitarPanel() {
		modificarPanel(panelTablero, false);

	}

	private void pintarTablero() {
		ImageIcon imagen = new ImageIcon(
				getClass().getResource(juego.getLiebre().getFoto()));
		Component[] componentes = panelTablero.getComponents();
		for (int i = 0; i < componentes.length - 1; i++) {
			JButton boton = (JButton) componentes[i];
			if (i == juego.getLiebre().getPosicion()) {
				boton.setIcon(imagen);
				boton.setDisabledIcon(imagen);
			} else if (i == juego.getSuperpoder()) {
				boton.setIcon(new ImageIcon(VentanaPrincipal.class
						.getResource("/img/estrella.JPEG")));
				boton.setDisabledIcon(new ImageIcon(VentanaPrincipal.class
						.getResource("/img/estrella.JPEG")));
			} else if (juego.getPosicionTrampa(i)) {
				boton.setIcon(new ImageIcon(VentanaPrincipal.class
						.getResource("/img/agujero.JPEG")));
				boton.setDisabledIcon(new ImageIcon(VentanaPrincipal.class
						.getResource("/img/agujero.JPEG")));
			} else {
				boton.setIcon(null);
				boton.setDisabledIcon(null);
			}
		}

		if (juego.getLiebre().getPosicion() == componentes.length - 1) {
			imagen = new ImageIcon(VentanaPrincipal.class
					.getResource("/img/liebre-comiendo.jpg"));
			JButton boton = (JButton) componentes[componentes.length - 1];
			boton.setIcon(imagen);
			boton.setDisabledIcon(imagen);
		} else {
			imagen = new ImageIcon(VentanaPrincipal.class
					.getResource("/img/zanahoria.jpg"));
			JButton boton = (JButton) componentes[componentes.length - 1];
			boton.setIcon(imagen);
			boton.setDisabledIcon(imagen);
		}

	}

	private void pintarPuntos() {
		txtPuntuacion
				.setText(String.valueOf(juego.getLiebre().getPuntuacion()));
	}

	private JTextField getTxtPuntuacion() {
		if (txtPuntuacion == null) {
			txtPuntuacion = new JTextField();
			txtPuntuacion.setText("0");
			txtPuntuacion.setEditable(false);
			txtPuntuacion.setForeground(Color.MAGENTA);
			txtPuntuacion.setFont(new Font("Tahoma", Font.PLAIN, 46));
			txtPuntuacion.setHorizontalAlignment(SwingConstants.CENTER);
			txtPuntuacion.setBackground(Color.BLACK);
			txtPuntuacion.setColumns(10);
		}
		return txtPuntuacion;
	}
}
