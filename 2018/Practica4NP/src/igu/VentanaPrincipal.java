package igu;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.jvnet.substance.SubstanceLookAndFeel;

import logica.Articulo;
import logica.Catalogo;
import logica.Pedido;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbLogo;
	private JLabel lbNombre;
	private JComboBox<Articulo> cbArticulos;
	private JLabel lbArticulos;
	private JTextField txUnidades;
	private JLabel lbUnidades;
	private JButton btComprar;
	private JLabel lbPrecio;
	private JTextField txPrecio;
	private JButton btSiguiente;
	private JButton btCancelar;

	private Pedido pedido;
	private Catalogo catalogo;
	private JTextField txUdsSelecc;
	private JLabel lbUdsTotales;
	private JButton btEliminar;
	private JButton btCarrito;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);
					SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.TwilightSkin");

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
		pedido = new Pedido();
		catalogo = new Catalogo();

		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/logo.png")));
		setTitle("Venta de Accesorios de Ordenador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 753, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbLogo());
		contentPane.add(getLbNombre());
		contentPane.add(getCbArticulos());
		contentPane.add(getLbArticulos());
		contentPane.add(getTxUnidades());
		contentPane.add(getLbUnidades());
		contentPane.add(getBtComprar());
		contentPane.add(getLbPrecio());
		contentPane.add(getTxPrecio());
		contentPane.add(getBtSiguiente());
		contentPane.add(getBtCancelar());
		contentPane.add(getTxUdsSelecc());
		contentPane.add(getLbUdsTotales());
		contentPane.add(getBtEliminar());
		contentPane.add(getBtCarrito());
	}

	private JLabel getLbLogo() {
		if (lbLogo == null) {
			lbLogo = new JLabel("");
			lbLogo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/logo.png")));
			lbLogo.setBounds(10, 0, 218, 178);
		}
		return lbLogo;
	}

	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("PC ACCESORIOS");
			lbNombre.setHorizontalAlignment(SwingConstants.CENTER);
			lbNombre.setForeground(SystemColor.textHighlight);
			lbNombre.setFont(new Font("Lucida Fax", Font.BOLD, 35));
			lbNombre.setBounds(283, 29, 315, 76);
		}
		return lbNombre;
	}

	private JComboBox<Articulo> getCbArticulos() {
		if (cbArticulos == null) {
			cbArticulos = new JComboBox<Articulo>();
			cbArticulos.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					txUnidades.grabFocus();
				}
			});
			cbArticulos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarUnidadesSeleccionadas();
				}
			});
			cbArticulos.setBounds(10, 209, 338, 20);
			cbArticulos.setModel(new DefaultComboBoxModel<Articulo>(catalogo.getArticulos()));
		}
		return cbArticulos;
	}

	private void mostrarUnidadesSeleccionadas() {
		Articulo[] list = catalogo.getArticulos();
		int posicion = getCbArticulos().getSelectedIndex();
		getTxUdsSelecc().setText("" + list[posicion].getUnidades());
	}

	private JLabel getLbArticulos() {
		if (lbArticulos == null) {
			lbArticulos = new JLabel("Art\u00EDculos:");
			lbArticulos.setLabelFor(getCbArticulos());
			lbArticulos.setDisplayedMnemonic('A');
			lbArticulos.setBounds(10, 184, 115, 14);
		}
		return lbArticulos;
	}

	private JTextField getTxUnidades() {
		if (txUnidades == null) {
			txUnidades = new JTextField();
			txUnidades.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					txUnidades.setText("1");
					txUnidades.selectAll();
				}

				@Override
				public void focusLost(FocusEvent e) {
					boolean error = false;
					int unidades = 0;
					try {
						unidades = Integer.parseInt(txUnidades.getText());
					} catch (NumberFormatException e1) {
						error = true;
					}
					if ((error) || (unidades <= 0))
						txUnidades.setText("");
				}
			});
			txUnidades.setText("");
			txUnidades.setBounds(393, 161, 105, 45);
			txUnidades.setColumns(10);
		}
		return txUnidades;
	}

	private JLabel getLbUnidades() {
		if (lbUnidades == null) {
			lbUnidades = new JLabel("Unidades:");
			lbUnidades.setLabelFor(getTxUnidades());
			lbUnidades.setDisplayedMnemonic('U');
			lbUnidades.setBounds(393, 130, 71, 20);
		}
		return lbUnidades;
	}

	private JButton getBtComprar() {
		if (btComprar == null) {
			btComprar = new JButton("Comprar");
			btComprar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (!txUnidades.getText().equals("")) {
						int unidadesSeleccionadas = Integer.parseInt(txUnidades.getText());
						Articulo[] list = catalogo.getArticulos();
						int posicion = getCbArticulos().getSelectedIndex();
						list[posicion].setUnidades(list[posicion].getUnidades() + unidadesSeleccionadas);

						Articulo articuloSeleccionado = (Articulo) cbArticulos.getSelectedItem();
						pedido.add(articuloSeleccionado, unidadesSeleccionadas);

						float precioPedido = pedido.calcularTotalSinIva();
						if (pedido.isDescuento()) {
							precioPedido = pedido.calcularTotalSinIva();
//							JOptionPane.showMessageDialog(null, "Descuento);
							// Añadir mensaje de descuento.
						}
						txPrecio.setText(String.valueOf(precioPedido) + " \u20AC");

						getBtSiguiente().setEnabled(true);
					} else {
						txPrecio.grabFocus();
					}
					mostrarUnidadesSeleccionadas();
				}
			});
			btComprar.setMnemonic('P');
			btComprar.setBounds(517, 161, 105, 45);
		}
		return btComprar;
	}

	private JLabel getLbPrecio() {
		if (lbPrecio == null) {
			lbPrecio = new JLabel("Precio Pedido: ");
			lbPrecio.setBounds(392, 207, 106, 25);
		}
		return lbPrecio;
	}

	private JTextField getTxPrecio() {
		if (txPrecio == null) {
			txPrecio = new JTextField();
			txPrecio.setEditable(false);
			txPrecio.setBounds(393, 227, 105, 45);
			txPrecio.setColumns(10);
		}
		return txPrecio;
	}

	private JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton("Siguiente");
			btSiguiente.setEnabled(false);
			btSiguiente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					mostrarVentanaRegistro();
				}
			});
			btSiguiente.setMnemonic('S');
			btSiguiente.setBounds(481, 295, 115, 38);
		}
		return btSiguiente;
	}

	private void mostrarVentanaRegistro() {
		VentanaRegistro v = new VentanaRegistro(this);
		v.setLocationRelativeTo(this);
		v.setModal(true);
		v.setVisible(true);
	}

	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.setMnemonic('C');
			btCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			btCancelar.setBounds(606, 295, 104, 38);
		}
		return btCancelar;
	}

	public Pedido getPedido() {
		return pedido;
	}

	private JTextField getTxUdsSelecc() {
		if (txUdsSelecc == null) {
			txUdsSelecc = new JTextField();
			txUdsSelecc.setText("");
			txUdsSelecc.setColumns(10);
			txUdsSelecc.setBounds(184, 288, 105, 45);
		}
		return txUdsSelecc;
	}

	private JLabel getLbUdsTotales() {
		if (lbUdsTotales == null) {
			lbUdsTotales = new JLabel("Unidades Totales:");
			lbUdsTotales.setBounds(59, 295, 115, 30);
		}
		return lbUdsTotales;
	}

	protected void inicializar() {
		// Lógica
		pedido.inicializar();

		// Interfaz
		cbArticulos.setSelectedIndex(0);
		txUnidades.setText("");
		txPrecio.setText("");
		btSiguiente.setEnabled(false);
	}

	private JButton getBtEliminar() {
		if (btEliminar == null) {
			btEliminar = new JButton("Eliminar");
			btEliminar.setBounds(632, 161, 105, 45);
		}
		return btEliminar;
	}

	private JButton getBtCarrito() {
		if (btCarrito == null) {
			btCarrito = new JButton("");
			btCarrito.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarVentanaCarrito();
				}
			});
			btCarrito.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/carrito.png")));
			btCarrito.setBounds(609, 11, 115, 76);
		}
		return btCarrito;
	}

	private void mostrarVentanaCarrito() {
		VentanaCarrito v = new VentanaCarrito();
		v.setVp(this);
		v.setLocationRelativeTo(this);
		v.setModal(true);
		v.setVisible(true);
	}

}
