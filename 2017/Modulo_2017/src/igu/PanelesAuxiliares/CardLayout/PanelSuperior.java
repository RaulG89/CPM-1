package igu.PanelesAuxiliares.CardLayout;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelSuperior extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnAyuda;
	private JPanel pnCarrito;
	private JButton btnAyuda;
	private JButton btnCarrito;

	public PanelSuperior() {
		this.setLayout(new GridLayout(1, 0, 0, 0));
		this.add(getPnAyuda());
		this.add(getPnCarrito());

	}

	private JPanel getPnAyuda() {
		if (pnAyuda == null) {
			pnAyuda = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnAyuda.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			pnAyuda.add(getBtnAyuda());
		}
		return pnAyuda;
	}

	private JPanel getPnCarrito() {
		if (pnCarrito == null) {
			pnCarrito = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnCarrito.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			pnCarrito.add(getBtnCarrito());
		}
		return pnCarrito;
	}

	private JButton getBtnAyuda() {
		if (btnAyuda == null) {
			btnAyuda = new JButton("?");
		}
		return btnAyuda;
	}

	private JButton getBtnCarrito() {
		if (btnCarrito == null) {
			btnCarrito = new JButton("Carrito");
			btnCarrito.setEnabled(false);
		}
		return btnCarrito;
	}
}
