package igu;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel pnPrincipal;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JPanel pnSexo;
	private JRadioButton rdbtnHombre;
	private JRadioButton rdbtnMujer;
	private JPanel pnEdad;
	private JTextField tfNombre;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JTextField tfApellidos;
	private JPanel pnRegistro;
	private JLabel lblUsuarioemail;
	private JLabel lblPassword;
	private JLabel lblRepassword;
	private JTextField tfUsuario;
	private JComboBox<String> cbDia;
	private JComboBox<String> cbMes;
	private JComboBox<String> cbAño;
	private JPasswordField pfPassword;
	private JPasswordField pfRepassword;
	private final ButtonGroup buttonGroupSexo = new ButtonGroup();
	// Para hacer que solo se pueda elegir un boton entre varias opciones

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro frame = new VentanaRegistro();
					frame.setLocationRelativeTo(null);
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
	public VentanaRegistro() {
		setTitle("Formulario de registro");
		// Configura la x para cerrar la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 373);
		pnPrincipal = new JPanel();
		pnPrincipal.setBackground(Color.WHITE);
		pnPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnPrincipal);
		pnPrincipal.setLayout(null);
		pnPrincipal.add(getBtnAceptar());
		pnPrincipal.add(getBtnCancelar());
		pnPrincipal.add(getPnSexo());
		pnPrincipal.add(getPnEdad());
		pnPrincipal.add(getLblNombre());
		pnPrincipal.add(getTfNombre());
		pnPrincipal.add(getLblApellidos());
		pnPrincipal.add(getTfApellidos());
		pnPrincipal.add(getPnRegistro());
	}

	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			btnCancelar.setBackground(Color.WHITE);
			btnCancelar.setBounds(594, 301, 89, 23);
		}
		return btnCancelar;
	}

	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (tfNombre.getText().equals(""))
						JOptionPane.showMessageDialog(null,
								"EL campo 'Nombre' esta vacio");
					else if (tfApellidos.getText().equals(""))
						JOptionPane.showMessageDialog(null,
								"EL campo 'Apellidos' esta vacio");
					else if (tfUsuario.getText().equals(""))
						JOptionPane.showMessageDialog(null,
								"EL campo 'Usuario' esta vacio");
					else if (String.valueOf(pfPassword.getPassword())
							.equals(""))
						JOptionPane.showMessageDialog(null,
								"EL campo 'Contraseña' esta vacio");
					else if (String.valueOf(pfPassword.getPassword())
							.length() < 5)
						JOptionPane.showMessageDialog(null,
								"EL campo 'Password' contener mñs de 5 caracteres");
					else if (String.valueOf(pfRepassword.getPassword())
							.equals(""))
						JOptionPane.showMessageDialog(null,
								"EL campo 'Reintroduzca Password' esta vacio");
					else if (String.valueOf(pfRepassword.getPassword())
							.length() < 5)
						JOptionPane.showMessageDialog(null,
								"EL campo 'Reintroduzca Password' contener mñs de 5 caracteres");
					else if (!(String.valueOf(pfPassword.getPassword()).equals(
							String.valueOf(pfRepassword.getPassword()))))
						JOptionPane.showMessageDialog(null,
								"Las contraseñas no coinciden");
					else
						System.exit(0);
				}
			});
			btnAceptar.setBackground(Color.WHITE);
			btnAceptar.setBounds(495, 301, 89, 23);
		}
		return btnAceptar;
	}

	private JPanel getPnSexo() {
		if (pnSexo == null) {
			pnSexo = new JPanel();
			pnSexo.setBorder(new TitledBorder(null, "Sexo",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnSexo.setBackground(Color.WHITE);
			pnSexo.setBounds(28, 88, 224, 65);
			pnSexo.setLayout(null);
			pnSexo.add(getRdbtnHombre());
			pnSexo.add(getRdbtnMujer());
		}
		return pnSexo;
	}

	private JRadioButton getRdbtnHombre() {
		if (rdbtnHombre == null) {
			rdbtnHombre = new JRadioButton("Hombre");
			rdbtnHombre.setSelected(true);
			buttonGroupSexo.add(rdbtnHombre);
			rdbtnHombre.setBackground(Color.WHITE);
			rdbtnHombre.setBounds(27, 22, 80, 23);
		}
		return rdbtnHombre;
	}

	private JRadioButton getRdbtnMujer() {
		if (rdbtnMujer == null) {
			rdbtnMujer = new JRadioButton("Mujer");
			buttonGroupSexo.add(rdbtnMujer);
			rdbtnMujer.setBackground(Color.WHITE);
			rdbtnMujer.setBounds(134, 22, 63, 23);
		}
		return rdbtnMujer;
	}

	private JPanel getPnEdad() {
		if (pnEdad == null) {
			pnEdad = new JPanel();
			pnEdad.setBackground(Color.WHITE);
			pnEdad.setBorder(new TitledBorder(null, "Fecha de Nacimiento",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnEdad.setBounds(330, 88, 315, 75);
			pnEdad.setLayout(null);
			pnEdad.add(getCbDia());
			pnEdad.add(getCbMes());
			pnEdad.add(getCbAño());
		}
		return pnEdad;
	}

	private JTextField getTfNombre() {
		if (tfNombre == null) {
			tfNombre = new JTextField();
			tfNombre.setBounds(91, 28, 161, 23);
			tfNombre.setColumns(10);
		}
		return tfNombre;
	}

	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(33, 28, 48, 23);
		}
		return lblNombre;
	}

	private JLabel getLblApellidos() {
		if (lblApellidos == null) {
			lblApellidos = new JLabel("Apellidos:");
			lblApellidos.setBounds(332, 28, 56, 23);
		}
		return lblApellidos;
	}

	private JTextField getTfApellidos() {
		if (tfApellidos == null) {
			tfApellidos = new JTextField();
			tfApellidos.setBounds(398, 28, 247, 23);
			tfApellidos.setColumns(10);
		}
		return tfApellidos;
	}

	private JPanel getPnRegistro() {
		if (pnRegistro == null) {
			pnRegistro = new JPanel();
			pnRegistro.setBorder(new TitledBorder(null, "Datos de Registro",
					TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnRegistro.setBackground(Color.WHITE);
			pnRegistro.setBounds(28, 172, 408, 140);
			pnRegistro.setLayout(null);
			pnRegistro.add(getLblUsuarioemail());
			pnRegistro.add(getTfUsuario());
			pnRegistro.add(getLblPassword());
			pnRegistro.add(getPfPassword());
			pnRegistro.add(getLblRepassword());
			pnRegistro.add(getPfRepassword());
		}
		return pnRegistro;
	}

	private JLabel getLblUsuarioemail() {
		if (lblUsuarioemail == null) {
			lblUsuarioemail = new JLabel("Usuario (email):");
			lblUsuarioemail.setBounds(11, 21, 159, 28);
		}
		return lblUsuarioemail;
	}

	private JLabel getLblPassword() {
		if (lblPassword == null) {
			lblPassword = new JLabel("Password:");
			lblPassword.setBounds(11, 60, 159, 28);
		}
		return lblPassword;
	}

	private JLabel getLblRepassword() {
		if (lblRepassword == null) {
			lblRepassword = new JLabel("Reintroduzca password:");
			lblRepassword.setBounds(11, 99, 159, 28);
		}
		return lblRepassword;
	}

	private JTextField getTfUsuario() {
		if (tfUsuario == null) {
			tfUsuario = new JTextField();
			tfUsuario.setBounds(180, 23, 212, 24);
			tfUsuario.setColumns(10);
		}
		return tfUsuario;
	}

	private JComboBox<String> getCbDia() {
		if (cbDia == null) {
			String[] dias = new String[31];
			for (int i = 0; i < 31; i++)
				dias[i] = "" + (i + 1);
			cbDia = new JComboBox<String>();
			cbDia.setBounds(18, 29, 44, 20);
			cbDia.setModel(new DefaultComboBoxModel<String>(dias));
		}
		return cbDia;
	}

	private JComboBox<String> getCbMes() {
		if (cbMes == null) {
			String[] meses = { "Enero", "Febrero", "Marzo", "Abril", "Mayo",
					"Junio", "Julio", "Agosto", "Septiembre", "Octubre",
					"Noviembre", "Diciembre" };
			cbMes = new JComboBox<String>();
			cbMes.setBounds(80, 29, 139, 20);
			cbMes.setModel(new DefaultComboBoxModel<String>(meses));
		}
		return cbMes;
	}

	private JComboBox<String> getCbAño() {
		if (cbAño == null) {
			String[] años = new String[100];
			for (int i = 0; i < 100; i++)
				años[i] = "" + (i + 1915);
			cbAño = new JComboBox<String>();
			cbAño.setBounds(237, 29, 60, 20);
			cbAño.setModel(new DefaultComboBoxModel<String>(años));
		}
		return cbAño;
	}

	private JPasswordField getPfPassword() {
		if (pfPassword == null) {
			pfPassword = new JPasswordField();
			pfPassword.setBounds(180, 62, 212, 24);
		}
		return pfPassword;
	}

	private JPasswordField getPfRepassword() {
		if (pfRepassword == null) {
			pfRepassword = new JPasswordField();
			pfRepassword.setBounds(180, 101, 212, 24);
		}
		return pfRepassword;
	}
}
