package igu.PanelesAuxiliares.CardLayout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelBienvenida extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -255366028269424242L;
	private JPanel pnComenzar;
	private JLabel lblBienvenido;
	private JButton btnComenzar;
	private JPanel pnCardlayout;

	/**
	 * Create the panel.
	 * 
	 * @param pnCardlayout
	 */
	public PanelBienvenida(JPanel pnCardlayout) {
		this.pnCardlayout = pnCardlayout;
		this.setLayout(new BorderLayout(0, 0));
		this.add(getLblBienvenido(), BorderLayout.NORTH);
		this.add(getComenzar(), BorderLayout.SOUTH);
	}

	private JPanel getComenzar() {
		if (pnComenzar == null) {
			pnComenzar = new JPanel();
			pnComenzar.add(getBtnComenzar());
		}
		return pnComenzar;
	}

	private JLabel getLblBienvenido() {
		if (lblBienvenido == null) {
			lblBienvenido = new JLabel("Bienvenido");
			lblBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 44));
			lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblBienvenido;
	}

	private JButton getBtnComenzar() {
		if (btnComenzar == null) {
			btnComenzar = new JButton("Comenzar");
			btnComenzar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					((CardLayout) pnCardlayout.getLayout()).next(pnCardlayout);
				}
			});
		}
		return btnComenzar;
	}
}
