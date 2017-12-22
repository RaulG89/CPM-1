package igu;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

public class PanelResultadoPaquetes extends JPanel{
	private JPanel pnImagen1;
	private JPanel pnPrecio1;
	private JPanel pnInfo1;
	private JLabel lblImagen1;
	private JLabel lblPrecio1;
	private JButton btnComprar1;
	private JLabel lblTitulo1;
	private JPanel pnResultado1;
	private Vprincipal v1;
	
	
	
	
	
	
	public PanelResultadoPaquetes(Vprincipal v1) {
		super();
		this.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		this.setLayout(new GridLayout(0, 3, 0, 0));
		this.add(getPnImagen1());
		this.add(getPnInfo1());
		this.add(getPnPrecio1());
		this.v1=v1;
	}

	private JPanel getPnImagen1() {
		if (pnImagen1 == null) {
			pnImagen1 = new JPanel();
			pnImagen1.add(getLblImagen1());
		}
		return pnImagen1;
	}

	private JPanel getPnPrecio1() {
		if (pnPrecio1 == null) {
			pnPrecio1 = new JPanel();
			pnPrecio1.setLayout(new GridLayout(0, 1, 0, 0));
			pnPrecio1.add(getLblPrecio1());
			pnPrecio1.add(getBtnComprar1());
		}
		return pnPrecio1;
	}

	private JPanel getPnInfo1() {
		if (pnInfo1 == null) {
			pnInfo1 = new JPanel();
			pnInfo1.setLayout(new GridLayout(0, 1, 0, 0));
			pnInfo1.add(getLblTitulo1());
		}
		return pnInfo1;
	}

	private JLabel getLblImagen1() {
		if (lblImagen1 == null) {
			lblImagen1 = new JLabel("imagen del hotel");
			lblImagen1.setIcon(new ImageIcon(Vprincipal.class.getResource("/img/logo2.png")));
		}
		return lblImagen1;
	}

	private JLabel getLblPrecio1() {
		if (lblPrecio1 == null) {
			lblPrecio1 = new JLabel("Precio");
		}
		return lblPrecio1;
	}

	private JButton getBtnComprar1() {
		if (btnComprar1 == null) {
			btnComprar1 = new JButton("Comprar");
		}
		return btnComprar1;
	}

	private JLabel getLblTitulo1() {
		if (lblTitulo1 == null) {
			lblTitulo1 = new JLabel();
			lblTitulo1.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		}
		return lblTitulo1;
	}


}
