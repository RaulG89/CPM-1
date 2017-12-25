package igu;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import logica.Parque;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class PanelResultadoParques extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnPrecio;
	private JLabel lblPrecioAdulto;
	private JButton btnComprar1;
	private Vprincipal v1;
	private Parque parque;
	private JLabel lblPrecioNiño;
	private JPanel pnPrecioAdulto;
	private JPanel pnPrecioNiño;
	private JPanel pnComprar;
	private JPanel pnPrincipal;
	private JPanel pnTexto;
	private JPanel pnCabecera;
	private JLabel lblImagen;
	private JLabel lblNombre;
	private JScrollPane scrollTexto;
	private JTextArea textArea;
	
	
	
	
	
	
	public PanelResultadoParques(Vprincipal v1, Parque parque) {
		super();
		this.v1=v1;
		this.parque=parque;
		this.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		this.add(getPnPrecio(), BorderLayout.EAST);
		add(getPnPrincipal());
	}

	private JPanel getPnPrecio() {
		if (pnPrecio == null) {
			pnPrecio = new JPanel();
			pnPrecio.setLayout(new GridLayout(0, 1, 0, 0));
			pnPrecio.add(getPnPrecioAdulto());
			pnPrecio.add(getPnPrecioNiño());
			pnPrecio.add(getPnComprar());
		}
		return pnPrecio;
	}

	private JLabel getLblPrecioAdulto() {
		if (lblPrecioAdulto == null) {
			lblPrecioAdulto = new JLabel(String.valueOf(parque.getEntrada().getPrecioAdulto()));
		}
		return lblPrecioAdulto;
	}

	private JButton getBtnComprar1() {
		if (btnComprar1 == null) {
			btnComprar1 = new JButton("Comprar");
		}
		return btnComprar1;
	}


	private JLabel getLblPrecioNiño() {
		if (lblPrecioNiño == null) {
			lblPrecioNiño = new JLabel(String.valueOf(parque.getEntrada().getPrecioNiño()));
		}
		return lblPrecioNiño;
	}
	private JPanel getPnPrecioAdulto() {
		if (pnPrecioAdulto == null) {
			pnPrecioAdulto = new JPanel();
			pnPrecioAdulto.setLayout(new BorderLayout(0, 0));
			pnPrecioAdulto.add(getLblPrecioAdulto(), BorderLayout.CENTER);
		}
		return pnPrecioAdulto;
	}
	private JPanel getPnPrecioNiño() {
		if (pnPrecioNiño == null) {
			pnPrecioNiño = new JPanel();
			pnPrecioNiño.setLayout(new BorderLayout(0, 0));
			pnPrecioNiño.add(getLblPrecioNiño());
		}
		return pnPrecioNiño;
	}
	private JPanel getPnComprar() {
		if (pnComprar == null) {
			pnComprar = new JPanel();
			pnComprar.setLayout(new BorderLayout(0, 0));
			pnComprar.add(getBtnComprar1());
		}
		return pnComprar;
	}
	private JPanel getPnPrincipal() {
		if (pnPrincipal == null) {
			pnPrincipal = new JPanel();
			pnPrincipal.setLayout(new BorderLayout(0, 0));
			pnPrincipal.add(getPnCabecera(), BorderLayout.NORTH);
			pnPrincipal.add(getPnTexto());
		}
		return pnPrincipal;
	}
	private JPanel getPnTexto() {
		if (pnTexto == null) {
			pnTexto = new JPanel();
			pnTexto.setLayout(new BorderLayout(0, 0));
			pnTexto.add(getScrollTexto(), BorderLayout.CENTER);
		}
		return pnTexto;
	}
	private JPanel getPnCabecera() {
		if (pnCabecera == null) {
			pnCabecera = new JPanel();
			pnCabecera.setLayout(new GridLayout(0, 2, 0, 0));
			pnCabecera.add(getLblImagen());
			pnCabecera.add(getLblNombre());
		}
		return pnCabecera;
	}
	private JLabel getLblImagen() {
		if (lblImagen == null) {
			lblImagen = new JLabel("New label");
		}
		return lblImagen;
	}
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel(parque.getDenominacion());
		}
		return lblNombre;
	}
	private JScrollPane getScrollTexto() {
		if (scrollTexto == null) {
			scrollTexto = new JScrollPane();
			scrollTexto.setViewportView(getTextArea());
		}
		return scrollTexto;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea(parque.getDescripcion());
		}
		return textArea;
	}
	
}
