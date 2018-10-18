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
	private JButton btnDado;
	private JTextField txtScore;
	private JPanel panelTablero;
	private JPanel panel_Contador;
	private JButton btn0;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btn10;
	private Juego juego;
	// private Dado dado;
	private JTextField txtDado;
	private JTextField joseLuis;

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
		juego = new Juego();
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
		contentPane.add(getBtnDado());
		contentPane.add(getTxtScore());
		contentPane.add(getPanelTablero());
		contentPane.add(getPanel_Contador());

		txtDado = new JTextField();
		txtDado.setHorizontalAlignment(SwingConstants.CENTER);
		txtDado.setText("0");
		txtDado.setBorder(null);
		txtDado.setForeground(Color.GREEN);
		txtDado.setFont(new Font("Tahoma", Font.BOLD, 40));
		txtDado.setEditable(false);
		txtDado.setBackground(Color.BLACK);
		txtDado.setBounds(122, 46, 129, 74);
		contentPane.add(txtDado);
		txtDado.setColumns(10);
		btn0.setEnabled(false);
		btn1.setEnabled(false);
		btn2.setEnabled(false);
		btn3.setEnabled(false);
		btn4.setEnabled(false);
		btn5.setEnabled(false);
		btn6.setEnabled(false);
		btn7.setEnabled(false);
		btn8.setEnabled(false);
		btn9.setEnabled(false);
		btn10.setEnabled(false);

		// EY
		pintarTablero();
	}

	private JButton getBtnDado() {
		if (btnDado == null) {
			btnDado = new JButton("");
			btnDado.setToolTipText("Pulsa para lanzar");
			btnDado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lanzarDado();
				}
			});
			btnDado.setIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/dado.JPG")));
			btnDado.setBounds(51, 46, 61, 86);
			btnDado.setBorderPainted(false);
			btnDado.setDisabledIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/dado.JPG")));
		}
		return btnDado;
	}

	private void lanzarDado() {
		boolean jugadaPosible = juego.lanzarDado();
		txtDado.setText(String.valueOf(Dado.getValor()));
		if (jugadaPosible) {
			habilitarPanel();
			btnDado.setEnabled(false);
		} else {
			JOptionPane.showMessageDialog(this, "La jugada no es posible");
			txtDado.setText("");
		}

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
			panelTablero.add(getBtn0());
			panelTablero.add(getBtn1());
			panelTablero.add(getBtn2());
			panelTablero.add(getBtn3());
			panelTablero.add(getBtn4());
			panelTablero.add(getBtn5());
			panelTablero.add(getBtn6());
			panelTablero.add(getBtn7());
			panelTablero.add(getBtn8());
			panelTablero.add(getBtn9());
			panelTablero.add(getBtn10());
		}
		return panelTablero;
	}

	private JPanel getPanel_Contador() {
		if (panel_Contador == null) {
			panel_Contador = new JPanel();
			panel_Contador.setToolTipText("");
			panel_Contador.setBackground(Color.BLACK);
			panel_Contador.setBorder(null);
			panel_Contador.setBounds(734, 46, 120, 86);
			panel_Contador.setLayout(new BorderLayout(0, 0));

			joseLuis = new JTextField();
			joseLuis.setText("0");
			joseLuis.setForeground(Color.MAGENTA);
			joseLuis.setHorizontalAlignment(SwingConstants.CENTER);
			joseLuis.setFont(new Font("Tahoma", Font.BOLD, 46));
			joseLuis.setEditable(false);
			joseLuis.setBackground(Color.BLACK);
			panel_Contador.add(joseLuis, BorderLayout.CENTER);
			joseLuis.setColumns(10);
			joseLuis.setBorder(null);
		}
		return panel_Contador;
	}

	private JButton getBtn0() {
		if (btn0 == null) {
			btn0 = new JButton("");
			btn0.setBackground(Color.BLACK);
			btn0.setIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/liebre.JPG")));
			btn0.setDisabledIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/liebre.JPG")));
		}
		return btn0;
	}

	private JButton getBtn1() {
		if (btn1 == null) {
			btn1 = new JButton("");
			btn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(1);
				}
			});
			btn1.setBackground(Color.BLACK);
		}
		return btn1;
	}

	private JButton getBtn2() {
		if (btn2 == null) {
			btn2 = new JButton("");
			btn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(2);
				}
			});
			btn2.setBackground(Color.BLACK);
		}
		return btn2;
	}

	private JButton getBtn3() {
		if (btn3 == null) {
			btn3 = new JButton("");
			btn3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(3);
				}
			});
			btn3.setBackground(Color.BLACK);
		}
		return btn3;
	}

	private JButton getBtn4() {
		if (btn4 == null) {
			btn4 = new JButton("");
			btn4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(4);
				}
			});
			btn4.setBackground(Color.BLACK);
		}
		return btn4;
	}

	private JButton getBtn5() {
		if (btn5 == null) {
			btn5 = new JButton("");
			btn5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(5);
				}
			});
			btn5.setBackground(Color.BLACK);
		}
		return btn5;
	}

	private JButton getBtn6() {
		if (btn6 == null) {
			btn6 = new JButton("");
			btn6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(6);
				}
			});
			btn6.setBackground(Color.BLACK);
		}
		return btn6;
	}

	private JButton getBtn7() {
		if (btn7 == null) {
			btn7 = new JButton("");
			btn7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(7);
				}
			});
			btn7.setBackground(Color.BLACK);
		}
		return btn7;
	}

	private JButton getBtn8() {
		if (btn8 == null) {
			btn8 = new JButton("");
			btn8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(8);
				}
			});
			btn8.setBackground(Color.BLACK);
		}
		return btn8;
	}

	private JButton getBtn9() {
		if (btn9 == null) {
			btn9 = new JButton("");
			btn9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(9);
				}
			});
			btn9.setBackground(Color.BLACK);
		}
		return btn9;
	}

	private JButton getBtn10() {
		if (btn10 == null) {
			btn10 = new JButton("");
			btn10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					jugar(10);
				}
			});
			btn10.setBackground(Color.BLACK);
			btn10.setIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/zanahoria.jpg")));
			btn10.setDisabledIcon(new ImageIcon(
					VentanaPrincipal.class.getResource("/img/zanahoria.jpg")));
		}
		return btn10;
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
			// EY
			if (i == juego.getPositionTrampa()) {
				boton.setIcon(new ImageIcon(VentanaPrincipal.class
						.getResource("/img/agujero.png")));
				boton.setDisabledIcon(new ImageIcon(VentanaPrincipal.class
						.getResource("/img/agujero.png")));
			} else if (i == juego.getLiebre().getPosicion()) {
				boton.setIcon(imagen);
				boton.setDisabledIcon(imagen);
			} else if (i == juego.getLiebre().getPosicion()) {
				boton.setIcon(imagen);
				boton.setDisabledIcon(imagen);
			} else {
				boton.setIcon(null);
				boton.setDisabledIcon(null);
			}
		}

		if (juego.getLiebre().getPosicion() == componentes.length - 1) {
			imagen = new ImageIcon(VentanaPrincipal.class
					.getResource("/img/liebre-comiendo.JPG"));
			JButton boton = (JButton) componentes[componentes.length - 1];
			boton.setIcon(imagen);
			boton.setDisabledIcon(imagen);
		}
	}

	private void representarEstadoJuego() {
		pintarPuntos();
		pintarTablero();
		// EY
		if (juego.isGameOver()) {
			JOptionPane.showMessageDialog(this, "Game Over");
			inicializar();
		} else if (juego.isPartidaFinalizada()) {
			JOptionPane.showMessageDialog(this, "partida finalizada");
			inicializar();
		} else {
			btnDado.setEnabled(true);
			txtDado.setText("");
		}
	}

	// EY
	private void inicializar() {
		juego.inicializarJuego();
		pintarPuntos();
		pintarTablero();
		btnDado.setEnabled(true);
		txtDado.setText("");
		btn10.setIcon(new ImageIcon(
				VentanaPrincipal.class.getResource("/img/zanahoria.jpg")));
		btn10.setDisabledIcon(new ImageIcon(
				VentanaPrincipal.class.getResource("/img/zanahoria.jpg")));
	}

	private void pintarPuntos() {
		joseLuis.setText(String.valueOf(juego.getLiebre().getPuntuacion()));
	}

	private void jugar(int posicion) {
		if (juego.resolverJugada(posicion)) {
			representarEstadoJuego();
			deshabilitarPanel();
		}
	}
}
