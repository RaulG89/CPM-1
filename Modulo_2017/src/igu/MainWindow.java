package igu;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jvnet.substance.SubstanceLookAndFeel;

import igu.PanelesAuxiliares.CardLayout.PanelBienvenida;
import igu.PanelesAuxiliares.CardLayout.PanelSeleccion;
import igu.PanelesAuxiliares.CardLayout.PanelSuperior;
import igu.PanelesAuxiliares.CardLayout.PanelTematico;
import model.Catalogue;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnCardlayout;
	private PanelBienvenida pnBienvenida;
	private Component pnSeleccion;
	private Component pnSuperior;
	private JPanel pnTematicos;
	private JPanel pnPaquetes;
	private JPanel pnAlojamientos;
	private Catalogue catalogue = new Catalogue();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
					Catalogue catalogue = new Catalogue();
					catalogue.getAccomodations();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.BusinessBlueSteelSkin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		pnSuperior = new PanelSuperior();
		contentPane.add(pnSuperior, BorderLayout.NORTH);
		contentPane.add(getPnCardlayout(), BorderLayout.CENTER);
	}

	private JPanel getPnCardlayout() {
		if (pnCardlayout == null) {
			pnCardlayout = new JPanel();
			pnCardlayout.setLayout(new CardLayout(0, 0));

			pnBienvenida = new PanelBienvenida(pnCardlayout);
			pnCardlayout.add(pnBienvenida, "pnBienvenida");

			pnSeleccion = new PanelSeleccion(pnCardlayout);
			pnCardlayout.add(pnSeleccion, "pnSeleccion");

			pnTematicos = new PanelTematico(pnCardlayout, catalogue.getThemeParks());
			pnCardlayout.add(pnTematicos, "pnTematicos");

			pnPaquetes = new JPanel();
			pnCardlayout.add(pnPaquetes, "pnPaquetes");

			pnAlojamientos = new JPanel();
			pnCardlayout.add(pnAlojamientos, "pnAlojamientos");
		}
		return pnCardlayout;
	}

}
