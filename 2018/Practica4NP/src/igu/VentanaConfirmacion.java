package igu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logica.*;

public class VentanaConfirmacion extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lbOkey;
	private JLabel lbAviso;
	private JLabel lbCodigo;
	private JTextField txCodigo;
	private JButton btnFinalizar;
	
	private VentanaRegistro vRegistro;

	/**
	 * Create the frame.
	 */
	public VentanaConfirmacion(VentanaRegistro vr) {
		setResizable(false);
		vRegistro = vr;
		
		setTitle("Venta de Accesorios de Ordenador (Confirmaci\u00F3n de Pedido)");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 488, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLbOkey());
		contentPane.add(getLbAviso());
		contentPane.add(getLbCodigo());
		contentPane.add(getTxCodigo());
		contentPane.add(getBtnFinalizar());
	}

	private JLabel getLbOkey() {
		if (lbOkey == null) {
			lbOkey = new JLabel("");
			lbOkey.setHorizontalAlignment(SwingConstants.CENTER);
			lbOkey.setIcon(new ImageIcon(VentanaConfirmacion.class.getResource("/img/ok.png")));
			lbOkey.setBounds(20, 37, 75, 52);
		}
		return lbOkey;
	}
	private JLabel getLbAviso() {
		if (lbAviso == null) {
			lbAviso = new JLabel("Estamos procesando su pedido");
			lbAviso.setFont(new Font("Tahoma", Font.BOLD, 18));
			lbAviso.setBounds(130, 43, 329, 46);
		}
		return lbAviso;
	}
	private JLabel getLbCodigo() {
		if (lbCodigo == null) {
			lbCodigo = new JLabel("El c\u00F3digo de recogida es: ");
			lbCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lbCodigo.setBounds(130, 100, 169, 39);
		}
		return lbCodigo;
	}
	private JTextField getTxCodigo() {
		if (txCodigo == null) {
			txCodigo = new JTextField();
			txCodigo.setFont(new Font("Tahoma", Font.BOLD, 20));
			txCodigo.setEditable(false);
			txCodigo.setBounds(309, 100, 150, 39);
			txCodigo.setColumns(10);
			txCodigo.setText(FileUtil.setFileName());
		}
		return txCodigo;
	}
	private JButton getBtnFinalizar() {
		if (btnFinalizar == null) {
			btnFinalizar = new JButton("Finalizar");
			btnFinalizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					finalizar();	
				}
			});
			btnFinalizar.setMnemonic('F');
			btnFinalizar.setBounds(357, 218, 102, 35);
		}
		return btnFinalizar;
	}
	
	private void finalizar(){
		vRegistro.getVp().getPedido().grabarPedido(txCodigo.getText(), vRegistro.getComprador());					
		vRegistro.getVp().inicializar();
		vRegistro.dispose();
		dispose();	
	}
}
