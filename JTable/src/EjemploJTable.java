import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EjemploJTable {

	private JFrame frame;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploJTable window = new EjemploJTable();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EjemploJTable() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(getScrollPane(), BorderLayout.CENTER);
	}

	private JTable getTable() {
		if (table == null) {
			DefaultTableModel modelo = new DefaultTableModel(new Object[] {
					"Dni", "Nombre", "Apellidos", "Seleccionado" }, 0);
			modelo.addRow(new Object[] { "1", "2", "3" });
			modelo.addRow(new Object[] { "2", "Iván", "González" });
			modelo.addRow(new Object[] { "3", "Raúl", "Peréz" });
			modelo.addRow(new Object[] { "4", "Carlos", "García" });
			table = new JTable(modelo);
			
			// Alinear texto en celda
			DefaultTableCellRenderer center = new DefaultTableCellRenderer();
			center.setHorizontalAlignment(SwingConstants.CENTER);
			
			// Una sola
			// table.getColumnModel().getColumn(modelo.getColumnCount() - 1)
			// .setCellRenderer(center);
			
			// Todas las celdas
			table.setDefaultRenderer(Object.class, center);

			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					int column = modelo.getColumnCount() - 1;
					int row = table.getSelectedRow();
					for (int i = 0; i < modelo.getRowCount(); i++) {
						table.setValueAt("", i, column);
					}
					table.setValueAt("x", row, column);
				}
			});
		}
		return table;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
}
