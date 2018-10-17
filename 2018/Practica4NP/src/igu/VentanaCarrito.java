package igu;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import logica.Articulo;

public class VentanaCarrito extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private VentanaPrincipal vp;
	private JButton btAtras;
	private JTextArea txrPedido;

	/**
	 * Create the frame.
	 */
	public VentanaCarrito() {
		setTitle("Carrito");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaCarrito.class.getResource("/img/carrito.png")));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 530, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtAtras());
		contentPane.add(getTxrPedido());
	}
	
	

	private JButton getBtAtras() {
		if (btAtras == null) {
			btAtras = new JButton("Atr\u00E1s");
			btAtras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btAtras.setBounds(415, 228, 89, 23);
		}
		return btAtras;
	}

	private JTextArea getTxrPedido() {
		if (txrPedido == null) {
			txrPedido = new JTextArea();
			txrPedido.setBounds(10, 11, 494, 211);
			txrPedido.setEditable(false);
		}
		return txrPedido;
	}
	
	

	public void setVp(VentanaPrincipal vp) {
		this.vp = vp;
		rellenarTextArea();
	}


	private void rellenarTextArea() {
		String pedido = new String();
		for (Articulo articulo : vp.getPedido().getListaPedido()) {
			pedido += articulo + "\n";
		}
		txrPedido.setText(pedido);
	}
}
