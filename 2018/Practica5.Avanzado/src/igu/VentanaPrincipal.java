package igu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import logica.Dado;
import logica.Juego;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;
	private JButton btnDado;
	private JTextField txDado;
	private JLabel lblScore;
	private JTextField txPuntosLiebre;
	private JPanel panelTablero1;
	// private JButton btn0;
	// private JButton btn1;
	// private JButton btn2;
	// private JButton btn3;
	// private JButton btn4;
	// private JButton btn5;
	// private JButton btn6;
	// private JButton btn7;
	// private JButton btn8;
	// private JButton btn9;
	// private JButton btn10;
	private Juego juego;
	private JPanel panelTablero2;
	private ProcesaBoton pB;
	private List<JButton> botones;

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
		this.botones = new ArrayList<JButton>();
		this.juego = new Juego();
		this.pB = new ProcesaBoton();
		setResizable(false);
		setTitle("El Juego de la liebre y la zanahoria");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				VentanaPrincipal.class.getResource("/img/liebre.JPG")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 418);
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.BLACK);
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(null);
		panelPrincipal.add(getBtnDado());
		panelPrincipal.add(getTxDado());
		panelPrincipal.add(getLblScore());
		panelPrincipal.add(getTxPuntosLiebre());
		panelPrincipal.add(getPanelTablero1());
		panelPrincipal.add(getPanelTablero2());
		setLocationRelativeTo(null);
		deshabilitarPanel();
		generarBotones();
	}

	private void pintarPuntos() {
		txPuntosLiebre
				.setText(String.valueOf(juego.getLiebre().getPuntuacion()));
	}

	private void jugar(int n) {
		boolean resolverJugada = juego.resolverJugada(n);
		if (resolverJugada) {
			representarEstadoDeJuego();
		}
	}

	private void representarEstadoDeJuego() {
		pintarCalle();
		pintarPuntos();
		txDado.setText("");
		btnDado.setEnabled(true);
		deshabilitarPanel();
		if (juego.isPartidaFinalizada()) {
			juego.getLiebre().incrementaPuntuacion(200);
			txPuntosLiebre
					.setText(String.valueOf(juego.getLiebre().getPuntuacion()));
			JOptionPane.showMessageDialog(this, "Has finalizado el juego.");
			deshabilitarPanel();
			btnDado.setEnabled(false);
		}
	}

	private void lanzar() {
		boolean jugadaPosible = juego.lanzarDado();
		txDado.setText(String.valueOf(Dado.getValor()));
		if (jugadaPosible) {
			habilitarPanel();
			btnDado.setEnabled(false);
		} else {
			JOptionPane.showMessageDialog(this,
					"Jugada no posible. Intentar de nuevo");
			txDado.setText("");
		}
	}

	private void modificarPanel(JPanel panel, boolean estado) {
		for (Component c : panel.getComponents()) {
			c.setEnabled(estado);
		}
	}

	private void habilitarPanel() {
		modificarPanel(panelTablero1, true);
		modificarPanel(panelTablero2, true);
	}

	private void deshabilitarPanel() {
		modificarPanel(panelTablero1, false);
		modificarPanel(panelTablero2, false);
	}

	private JButton getBtnDado() {
		if (btnDado == null) {
			btnDado = new JButton("");
			btnDado.setDisabledIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/dado.JPG")));
			btnDado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lanzar();
				}
			});
			btnDado.setToolTipText("Click para lanzar el dado");
			btnDado.setIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/dado.JPG")));
			btnDado.setBorderPainted(false);
			btnDado.setBounds(55, 25, 62, 82);
		}
		return btnDado;
	}

	private JTextField getTxDado() {
		if (txDado == null) {
			txDado = new JTextField();
			txDado.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 60));
			txDado.setHorizontalAlignment(SwingConstants.CENTER);
			txDado.setBorder(null);
			txDado.setForeground(Color.GREEN);
			txDado.setBackground(Color.BLACK);
			txDado.setEditable(false);
			txDado.setBounds(146, 17, 125, 82);
			txDado.setColumns(10);
		}
		return txDado;
	}

	private JLabel getLblScore() {
		if (lblScore == null) {
			lblScore = new JLabel("SCORE");
			lblScore.setFont(new Font("Jokerman", Font.BOLD, 50));
			lblScore.setHorizontalAlignment(SwingConstants.CENTER);
			lblScore.setForeground(Color.YELLOW);
			lblScore.setBounds(380, 25, 219, 67);
		}
		return lblScore;
	}

	private JTextField getTxPuntosLiebre() {
		if (txPuntosLiebre == null) {
			txPuntosLiebre = new JTextField();
			txPuntosLiebre.setBorder(null);
			txPuntosLiebre.setBackground(Color.BLACK);
			txPuntosLiebre.setForeground(Color.MAGENTA);
			txPuntosLiebre.setFont(new Font("Tahoma", Font.PLAIN, 36));
			txPuntosLiebre.setText("0");
			txPuntosLiebre.setEditable(false);
			txPuntosLiebre.setHorizontalAlignment(SwingConstants.CENTER);
			txPuntosLiebre.setBounds(626, 24, 86, 67);
			txPuntosLiebre.setColumns(10);
		}
		return txPuntosLiebre;
	}

	private JPanel getPanelTablero1() {
		if (panelTablero1 == null) {
			panelTablero1 = new JPanel();
			panelTablero1.setBackground(Color.BLUE);
			panelTablero1.setBorder(new LineBorder(Color.BLUE, 10));
			panelTablero1.setBounds(33, 129, 797, 101);
			panelTablero1.setLayout(new GridLayout(1, 11, 2, 0));
		}
		return panelTablero1;
	}

	private void generarBotones() {
		for (int i = 0; i < 22; i++) {
			String nombreBoton = "btn" + i;
			JButton boton = new JButton();
			boton.setName(nombreBoton);
			boton.setBackground(Color.BLACK);
			botones.add(boton);
			boton.addActionListener(pB);
			if (i >= 0 && i < 11) {
				panelTablero1.add(boton);
			} else if (i >= 11 && i < 22) {
				panelTablero2.add(boton);
			}
			if (i == 21) {
				boton.setIcon(new ImageIcon(VentanaPrincipal.class
						.getResource("/img/zanahoria.JPG")));
				boton.setDisabledIcon(new ImageIcon(VentanaPrincipal.class
						.getResource("/img/zanahoria.JPG")));
			} else if (i == 0) {
				boton.setIcon(new ImageIcon(
						VentanaPrincipal.class.getResource("/img/liebre.JPG")));
				boton.setDisabledIcon(new ImageIcon(
						VentanaPrincipal.class.getResource("/img/liebre.JPG")));
			}
		}
	}

	private void pintarCalle() {
		ImageIcon imagen = new ImageIcon(
				getClass().getResource("/img/" + juego.getLiebre().getFoto()));

		Component[] botones1 = panelTablero1.getComponents();
		Component[] botones2 = panelTablero2.getComponents();

		 System.out.println(juego.getLiebre().getPosicion());
		for (int i = 0; i < botones1.length; i++) {
			JButton boton = (JButton) botones1[i];
			if (i == juego.getLiebre().getPosicion()) {
				boton.setIcon(imagen);
				boton.setDisabledIcon(imagen);
			} else {
				boton.setIcon(null);
				boton.setDisabledIcon(null);
			}
		}

		for (int i = 0; i < botones2.length; i++) {
			JButton boton = (JButton) botones2[i];
			if (i + 10 == juego.getLiebre().getPosicion()) {
				boton.setIcon(imagen);
				boton.setDisabledIcon(imagen);
			} else {
				boton.setIcon(null);
				boton.setDisabledIcon(null);
			}
		}
	}

	private JPanel getPanelTablero2() {
		if (panelTablero2 == null) {
			panelTablero2 = new JPanel();
			panelTablero2.setBorder(new LineBorder(Color.BLUE, 10));
			panelTablero2.setBounds(33, 230, 797, 87);
			panelTablero2.setLayout(new GridLayout(1, 0, 0, 0));
		}
		return panelTablero2;
	}

	class ProcesaBoton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < botones.size(); i++) {
				jugar(i);
			}
		}
	}
}
