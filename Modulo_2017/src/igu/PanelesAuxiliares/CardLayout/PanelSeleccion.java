package igu.PanelesAuxiliares.CardLayout;

import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelSeleccion extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnTematicos;
	private JButton btnPaquetes;
	private JButton btnAlojamiento;
	private JPanel pnCardlayout;
	private CardLayout cardLayout;

	/**
	 * Create the panel.
	 * 
	 * @param pnCardlayout
	 */
	public PanelSeleccion(JPanel pnCardlayout) {
		this.pnCardlayout = pnCardlayout;
		this.cardLayout = (CardLayout) pnCardlayout.getLayout();
		setLayout(new GridLayout(0, 1, 0, 0));
		add(getBtnTematicos());
		add(getBtnPaquetes());
		add(getBtnAlojamiento());

	}

	private JButton getBtnTematicos() {
		if (btnTematicos == null) {
			btnTematicos = new JButton("Tematicos");
			btnTematicos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cardLayout.show(pnCardlayout, "pnTematicos");
				}
			});
		}
		return btnTematicos;
	}

	private JButton getBtnPaquetes() {
		if (btnPaquetes == null) {
			btnPaquetes = new JButton("Paquetes");
			btnPaquetes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cardLayout.show(pnCardlayout, "pnPaquetes");
				}
			});
		}
		return btnPaquetes;
	}

	private JButton getBtnAlojamiento() {
		if (btnAlojamiento == null) {
			btnAlojamiento = new JButton("Alojamiento");
			btnAlojamiento.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cardLayout.show(pnCardlayout, "pnAlojamientos");
				}
			});
		}
		return btnAlojamiento;
	}
}
