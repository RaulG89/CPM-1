package igu.PanelCardLayout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import igu.VentanaPrincipal;
import logica.Pasajero;

public class PanelPasajeros extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5245380327901137550L;
	private VentanaPrincipal vp;
	private JPanel pnTituloPasajeros;
	private JPanel pnListaPasajeros;
	private JPanel pnBotonesPasajeros;
	private JLabel lblListaDePasajeros;
	private JButton btnAtrasPasajeros;
	private JButton btnSiguientePasajeros;
	private JTable tablaPasajeros;
	private DefaultTableModel modeloTablaPasajeros;
	private JButton btnCancelarPasajeros;
	private JLabel lblPorFavorIntroduzca_1;
	private JLabel lblPorFavorIntroduzca;
	private JScrollPane scPasajeros;

	public PanelPasajeros(VentanaPrincipal vp) {
		this.vp = vp;
		this.setLayout(new BorderLayout(0, 0));
		// this.add(getPnTituloPasajeros(), BorderLayout.NORTH);
		// this.add(getPnListaPasajeros(), BorderLayout.CENTER);
		// this.add(getPnBotonesPasajeros(), BorderLayout.SOUTH);
	}
	/*
	 * private JPanel getPnTituloPasajeros() { if (pnTituloPasajeros == null) {
	 * pnTituloPasajeros = new JPanel(); pnTituloPasajeros.setLayout(new
	 * GridLayout(2, 1, 0, 0)); pnTituloPasajeros.add(getLblListaDePasajeros());
	 * pnTituloPasajeros.add(getLblPorFavorIntroduzca()); } return
	 * pnTituloPasajeros; }
	 * 
	 * private JLabel getLblPorFavorIntroduzca() { if (lblPorFavorIntroduzca ==
	 * null) { lblPorFavorIntroduzca = new JLabel(
	 * "Por favor introduzca a las personas que van a realizar el crucero:");
	 * lblPorFavorIntroduzca.setHorizontalAlignment(SwingConstants.CENTER);
	 * lblPorFavorIntroduzca.setFont(new Font("Tahoma", Font.PLAIN, 16)); }
	 * return lblPorFavorIntroduzca; }
	 * 
	 * private JPanel getPnListaPasajeros() { if (pnListaPasajeros == null) {
	 * pnListaPasajeros = new JPanel(); pnListaPasajeros.setLayout(new
	 * BorderLayout(0, 0)); pnListaPasajeros.add(getScPasajeros(),
	 * BorderLayout.CENTER);
	 * pnListaPasajeros.add(getPnBotonesModificarPasajeros(),
	 * BorderLayout.SOUTH);
	 * pnListaPasajeros.add(getPnEspacio1RegistroPasajeros(),
	 * BorderLayout.WEST);
	 * pnListaPasajeros.add(getPnEspacio2RegistroPasajeros(),
	 * BorderLayout.EAST); } return pnListaPasajeros; }
	 * 
	 * private JPanel getPnBotonesPasajeros() { if (pnBotonesPasajeros == null)
	 * { pnBotonesPasajeros = new JPanel(); FlowLayout flowLayout = (FlowLayout)
	 * pnBotonesPasajeros.getLayout();
	 * flowLayout.setAlignment(FlowLayout.RIGHT);
	 * pnBotonesPasajeros.add(getBtnAtrasPasajeros());
	 * pnBotonesPasajeros.add(getBtnSiguientePasajeros());
	 * pnBotonesPasajeros.add(getBtnCancelarPasajeros()); } return
	 * pnBotonesPasajeros; }
	 * 
	 * private JLabel getLblListaDePasajeros() { if (lblListaDePasajeros ==
	 * null) { lblListaDePasajeros = new JLabel("Lista de pasajeros");
	 * lblListaDePasajeros.setHorizontalAlignment(SwingConstants.CENTER);
	 * lblListaDePasajeros.setFont(new Font("Tahoma", Font.PLAIN, 40)); } return
	 * lblListaDePasajeros; }
	 * 
	 * private JButton getBtnAtrasPasajeros() { if (btnAtrasPasajeros == null) {
	 * btnAtrasPasajeros = new JButton("Atras");
	 * btnAtrasPasajeros.setToolTipText(
	 * "Vuelve a la pantalla de detalles del crucero");
	 * btnAtrasPasajeros.setMnemonic('A'); btnAtrasPasajeros.setFont(new
	 * Font("Tahoma", Font.PLAIN, 12)); btnAtrasPasajeros.addActionListener(new
	 * ActionListener() { public void actionPerformed(ActionEvent arg0) {
	 * borrarModelo(modeloTablaPasajeros); setListaPasajeros(new
	 * ArrayList<Pasajero>()); btnSiguientePasajeros.setEnabled(false);
	 * btnSiguienteListaCruceros.grabFocus(); ((CardLayout)
	 * pnReservas.getLayout()).previous(pnReservas); getCbFechas().grabFocus();
	 * } }); } return btnAtrasPasajeros; }
	 * 
	 * public void activarBtnSiguientePasajeros() {
	 * btnSiguientePasajeros.setEnabled(true); }
	 * 
	 * public JButton getBtnSiguientePasajeros() { if (btnSiguientePasajeros ==
	 * null) { btnSiguientePasajeros = new JButton("Siguiente");
	 * btnSiguientePasajeros.setToolTipText(
	 * "Muestra la ventana de reserva de camarotes");
	 * btnSiguientePasajeros.setMnemonic('S'); btnSiguientePasajeros.setFont(new
	 * Font("Tahoma", Font.PLAIN, 12)); btnSiguientePasajeros.setEnabled(false);
	 * btnAñadirPasajero.setEnabled(true); btnBorrarPasajero.setEnabled(false);
	 * btnSiguientePasajeros.addActionListener(new ActionListener() { public
	 * void actionPerformed(ActionEvent arg0) { boolean mayor = false; for
	 * (Pasajero p : getListaPasajeros()) { if (!p.isMenor()) { mayor = true;
	 * break; } } if (mayor) { setListaClientes(new ArrayList<Pasajero>()); for
	 * (Pasajero p : getListaPasajeros()) getListaClientes().add(p);
	 * ((CardLayout) pnReservas.getLayout()).next(pnReservas);
	 * getBtnAñadirReservaCamarotes().grabFocus();
	 * btnBorrarReservaCamarotes.setEnabled(false);
	 * btnAñadirReservaCamarotes.setEnabled(true);
	 * btnSiguienteReservaCamarotes.setEnabled(false); } else
	 * JOptionPane.showMessageDialog(null,
	 * "Entre los pasajeros debe haber uno que sea mayor de edad", "Error",
	 * JOptionPane.ERROR_MESSAGE); } }); } return btnSiguientePasajeros; }
	 * 
	 * private JTable getTablaPasajeros() { if (tablaPasajeros == null) {
	 * modeloTablaPasajeros = new DefaultTableModel(new Object[] { "Nombre",
	 * "Apellidos", "Dni", "Fecha de nacimiento" }, 0); tablaPasajeros = new
	 * JTable(modeloTablaPasajeros) { private static final long serialVersionUID
	 * = -3502508279470742363L;
	 * 
	 * @Override public boolean isCellEditable(int row, int col) { return false;
	 * } }; tablaPasajeros.getTableHeader().setReorderingAllowed(false);
	 * DefaultTableCellRenderer celda = new DefaultTableCellRenderer();
	 * celda.setHorizontalAlignment(SwingConstants.CENTER);
	 * tablaPasajeros.setDefaultRenderer(Object.class, celda); } return
	 * tablaPasajeros; }
	 * 
	 * private JButton getBtnCancelarPasajeros() { if (btnCancelarPasajeros ==
	 * null) { btnCancelarPasajeros = new JButton("Cancelar");
	 * btnCancelarPasajeros.setToolTipText(
	 * "Borra todos los datos vuelve a la pantalla de inicio");
	 * btnCancelarPasajeros.setMnemonic('C'); btnCancelarPasajeros.setFont(new
	 * Font("Tahoma", Font.PLAIN, 12));
	 * btnCancelarPasajeros.addActionListener(new ActionListener() { public void
	 * actionPerformed(ActionEvent e) { inicializar(); } }); } return
	 * btnCancelarPasajeros; }
	 * 
	 * private JScrollPane getScPasajeros() { if (scPasajeros == null) {
	 * scPasajeros = new JScrollPane();
	 * scPasajeros.setViewportView(getTablaPasajeros()); } return scPasajeros; }
	 */
}
