package igu;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class VentanaRegistro extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel pnPrincipal;
	private JPanel pnSuperior;
	private JPanel pnInferior;
	private JLabel lbNombre;
	private JPanel pnNombre;
	private JPanel pnApellidos;
	private JPanel pnSexo;
	private JPanel pnFechaNac;
	private JLabel lbApellidos;
	private JTextField txNombre;
	private JTextField txApellidos;
	private JPanel pnRegistro;
	private JButton btSiguiente;
	private JButton btAnterior;
	private JPanel pnBotones;
	private JRadioButton rdbtnHombre;
	private JRadioButton rdbtnMujer;
	private JLabel lblUsuario;
	private JTextField txUsuario;
	private JLabel lblPassword;
	private JPasswordField pfPassword;
	private JLabel lblRpassword;
	private JPasswordField pfRpassword;
	private JComboBox<String> cbDia;
	private JComboBox<String> cbMes;
	private JComboBox<Integer> cbAnio;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private VentanaPrincipal vPrincipal;

	/**
	 * Create the frame.
	 */
	public VentanaRegistro(VentanaPrincipal vp) {
		setResizable(false);
		vPrincipal = vp;

		setTitle("Formulario de Registro");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		pnPrincipal = new JPanel();
		pnPrincipal.setBackground(Color.WHITE);
		pnPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnPrincipal);
		pnPrincipal.setLayout(new GridLayout(2, 0, 0, 0));
		pnPrincipal.add(getPnSuperior());
		pnPrincipal.add(getPnInferior());

		setLocationRelativeTo(null);

	}

	private JPanel getPnSuperior() {
		if (pnSuperior == null) {
			pnSuperior = new JPanel();
			pnSuperior.setBackground(Color.WHITE);
			pnSuperior.setLayout(new GridLayout(0, 2, 0, 0));
			pnSuperior.add(getPnNombre());
			pnSuperior.add(getPnApellidos());
			pnSuperior.add(getPnSexo());
			pnSuperior.add(getPnFechaNac());
		}
		return pnSuperior;
	}

	private JPanel getPnInferior() {
		if (pnInferior == null) {
			pnInferior = new JPanel();
			pnInferior.setBackground(Color.WHITE);
			pnInferior.setLayout(new GridLayout(0, 2, -130, 0));
			pnInferior.add(getPnRegistro());
			pnInferior.add(getPnBotones());
		}
		return pnInferior;
	}

	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre:");
			lbNombre.setDisplayedMnemonic('N');
			lbNombre.setLabelFor(getTxNombre());
			lbNombre.setBounds(10, 14, 52, 20);
			lbNombre.setHorizontalTextPosition(SwingConstants.LEADING);
			lbNombre.setVerticalAlignment(SwingConstants.TOP);
		}
		return lbNombre;
	}

	private JPanel getPnNombre() {
		if (pnNombre == null) {
			pnNombre = new JPanel();
			pnNombre.setBackground(Color.WHITE);
			pnNombre.setLayout(null);
			pnNombre.add(getLbNombre());
			pnNombre.add(getTxNombre());
		}
		return pnNombre;
	}

	private JPanel getPnApellidos() {
		if (pnApellidos == null) {
			pnApellidos = new JPanel();
			pnApellidos.setBackground(Color.WHITE);
			pnApellidos.setLayout(null);
			pnApellidos.add(getLbApellidos());
			pnApellidos.add(getTxApellidos());
		}
		return pnApellidos;
	}

	private JPanel getPnSexo() {
		if (pnSexo == null) {
			pnSexo = new JPanel();
			pnSexo.setBorder(new TitledBorder(null, "Sexo",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnSexo.setBackground(Color.WHITE);
			pnSexo.setLayout(null);
			pnSexo.add(getRdbtnHombre());
			pnSexo.add(getRdbtnMujer());
		}
		return pnSexo;
	}

	private JPanel getPnFechaNac() {
		if (pnFechaNac == null) {
			pnFechaNac = new JPanel();
			pnFechaNac.setBorder(new TitledBorder(null, "Fecha de nacimiento",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnFechaNac.setBackground(Color.WHITE);
			pnFechaNac.setLayout(null);
			pnFechaNac.add(getCbDia());
			pnFechaNac.add(getCbMes());
			pnFechaNac.add(getCbAnio());
		}
		return pnFechaNac;
	}

	private JLabel getLbApellidos() {
		if (lbApellidos == null) {
			lbApellidos = new JLabel("Apellidos:");
			lbApellidos.setDisplayedMnemonic('A');
			lbApellidos.setLabelFor(getTxApellidos());
			lbApellidos.setBounds(10, 8, 60, 14);
		}
		return lbApellidos;
	}

	private JTextField getTxNombre() {
		if (txNombre == null) {
			txNombre = new JTextField();
			txNombre.setBounds(60, 11, 217, 20);
			txNombre.setColumns(10);
		}
		return txNombre;
	}

	private JTextField getTxApellidos() {
		if (txApellidos == null) {
			txApellidos = new JTextField();
			txApellidos.setBounds(67, 5, 210, 20);
			txApellidos.setColumns(10);
		}
		return txApellidos;
	}

	private JPanel getPnRegistro() {
		if (pnRegistro == null) {
			pnRegistro = new JPanel();
			pnRegistro.setBorder(new TitledBorder(null, "Datos de Registro",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnRegistro.setBackground(Color.WHITE);
			pnRegistro.setLayout(null);
			pnRegistro.add(getLblUsuario());
			pnRegistro.add(getTxUsuario());
			pnRegistro.add(getLblPassword());
			pnRegistro.add(getPfPassword());
			pnRegistro.add(getLblRpassword());
			pnRegistro.add(getPfRpassword());
		}
		return pnRegistro;
	}

	private JButton getBtSiguiente() {
		if (btSiguiente == null) {
			btSiguiente = new JButton("Siguiente");
			btSiguiente.setMnemonic('S');
			btSiguiente.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					String nombre = getTxNombre().getText();
					String apellidos = getTxApellidos().getText();
					String usuario = getTxUsuario().getText();
					String password = String
							.valueOf(getPfPassword().getPassword());
					String rpassword = String
							.valueOf(getPfRpassword().getPassword());

					if (nombre.isEmpty() || apellidos.isEmpty()
							|| usuario.isEmpty() || password.isEmpty()
							|| rpassword.isEmpty()) {
						JOptionPane.showMessageDialog(null,
								"Alguno de los campos estni vacnio");
					} else if (!password.equals(rpassword)) {
						JOptionPane.showMessageDialog(null,
								"Los campos de contrasenia no coinciden");
					} else {
						mostrarVentanaConfirmacion();
					}
				}
			});
			btSiguiente.setBounds(249, 86, 93, 29);
		}
		return btSiguiente;
	}

	private void mostrarVentanaConfirmacion() {
		VentanaConfirmacion vc = new VentanaConfirmacion(this);
		vc.setLocationRelativeTo(this);
		vc.setModal(true);
		vc.setVisible(true);
	}

	private JButton getBtAnterior() {
		if (btAnterior == null) {
			btAnterior = new JButton("Anterior");
			btAnterior.setMnemonic('T');
			btAnterior.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btAnterior.setBounds(143, 86, 93, 29);
		}
		return btAnterior;
	}

	private JPanel getPnBotones() {
		if (pnBotones == null) {
			pnBotones = new JPanel();
			pnBotones.setBackground(Color.WHITE);
			pnBotones.setLayout(null);
			pnBotones.add(getBtSiguiente());
			pnBotones.add(getBtAnterior());
		}
		return pnBotones;
	}

	private JRadioButton getRdbtnHombre() {
		if (rdbtnHombre == null) {
			rdbtnHombre = new JRadioButton("Hombre");
			rdbtnHombre.setMnemonic('H');
			buttonGroup.add(rdbtnHombre);
			rdbtnHombre.setSelected(true);
			rdbtnHombre.setBackground(Color.WHITE);
			rdbtnHombre.setBounds(23, 19, 109, 23);
		}
		return rdbtnHombre;
	}

	private JRadioButton getRdbtnMujer() {
		if (rdbtnMujer == null) {
			rdbtnMujer = new JRadioButton("Mujer");
			rdbtnMujer.setMnemonic('M');
			buttonGroup.add(rdbtnMujer);
			rdbtnMujer.setBackground(Color.WHITE);
			rdbtnMujer.setBounds(155, 18, 109, 23);
		}
		return rdbtnMujer;
	}

	private JLabel getLblUsuario() {
		if (lblUsuario == null) {
			lblUsuario = new JLabel("Usuario (email):");
			lblUsuario.setDisplayedMnemonic('U');
			lblUsuario.setLabelFor(getTxUsuario());
			lblUsuario.setBounds(10, 24, 90, 22);
		}
		return lblUsuario;
	}

	private JTextField getTxUsuario() {
		if (txUsuario == null) {
			txUsuario = new JTextField();
			txUsuario.setBounds(152, 24, 181, 20);
			txUsuario.setColumns(10);
		}
		return txUsuario;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setLabelFor(getPfPassword());
			lblPassword.setDisplayedMnemonic('P');
			lblPassword.setBounds(10, 50, 73, 22);
		}
		return lblPassword;
	}

	private JPasswordField getPfPassword() {
		if (pfPassword == null) {
			pfPassword = new JPasswordField();
			pfPassword.setBounds(152, 51, 181, 20);
		}
		return pfPassword;
	}

	private JLabel getLblRpassword() {
		if (lblRpassword == null) {
			lblRpassword = new JLabel("Reintroduzca Password: ");
			lblRpassword.setDisplayedMnemonic('R');
			lblRpassword.setLabelFor(getPfRpassword());
			lblRpassword.setBounds(10, 83, 159, 14);
		}
		return lblRpassword;
	}

	private JPasswordField getPfRpassword() {
		if (pfRpassword == null) {
			pfRpassword = new JPasswordField();
			pfRpassword.setBounds(152, 82, 181, 20);
		}
		return pfRpassword;
	}

	private JComboBox<String> getCbDia() {
		if (cbDia == null) {
			cbDia = new JComboBox<String>();
			cbDia.setModel(new DefaultComboBoxModel<String>(new String[] { "1",
					"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
					"13", "14", "15", "16", "17", "18", "19", "20", "21", "22",
					"23", "24", "25", "26", "27", "28", "29", "30", "31" }));
			cbDia.setBounds(10, 29, 41, 22);
		}
		return cbDia;
	}

	private JComboBox<String> getCbMes() {
		if (cbMes == null) {
			cbMes = new JComboBox<String>();
			cbMes.setModel(new DefaultComboBoxModel<String>(
					new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo",
							"Junio", "Julio", "Agosto", "Septiembre", "Octubre",
							"Noviembre", "Diciembre" }));
			cbMes.setBounds(61, 29, 118, 22);
		}
		return cbMes;
	}

	private JComboBox<Integer> getCbAnio() {
		if (cbAnio == null) {
			cbAnio = new JComboBox<Integer>();
			int anioMinimo = 1900;
			int anioMaximo = 2018;
			for (int i = anioMinimo; i <= anioMaximo; i++) {
				cbAnio.addItem(i);
			}
			cbAnio.setBounds(193, 29, 84, 22);
		}
		return cbAnio;
	}

	public VentanaPrincipal getVp() {
		return vPrincipal;
	}

	public String getComprador() {
		String comprador = "\n";
		comprador += txNombre.getText() + " ";
		comprador += txApellidos.getText() + " ";
		comprador += ", Fecha de nacimiento: " + (cbDia.getSelectedIndex() + 1);
		comprador += "/" + (cbMes.getSelectedIndex() + 1);
		comprador += "/" + (cbAnio.getSelectedIndex() + 1);
		comprador += ", Sexo";
		return comprador;
	}
}
