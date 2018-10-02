package igu.PanelesAuxiliares.CardLayout;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import model.ThemePark;

public class PanelTematico extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pnFiltros;
	private JPanel pnSeleccionFiltro;
	private JPanel pnBotonesFiltros;
	private JButton btnFiltrar;
	private JButton btnLimpiar;
	private JComboBox<Object> comboBox;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JPanel pnCardlayout;
	private JScrollPane pnTabla;
	private JTable table;
	private Map<String, ThemePark> map;
	private DefaultTableModel modeloTabla;

	/**
	 * Create the panel.
	 * 
	 * @param pnCardlayout
	 * @param map
	 */
	public PanelTematico(JPanel pnCardlayout, Map<String, ThemePark> map) {
		this.setPnCardlayout(pnCardlayout);
		this.map = map;
		setLayout(new BorderLayout(0, 0));
		add(getPnFiltros(), BorderLayout.NORTH);
		add(getPnTabla(), BorderLayout.CENTER);
		cargarTabla(map);
	}

	private JPanel getPnFiltros() {
		if (pnFiltros == null) {
			pnFiltros = new JPanel();
			pnFiltros.setLayout(new GridLayout(0, 1, 0, 0));
			pnFiltros.add(getPnSeleccionFiltro());
			pnFiltros.add(getPnBotonesFiltros());
		}
		return pnFiltros;
	}

	private JPanel getPnSeleccionFiltro() {
		if (pnSeleccionFiltro == null) {
			pnSeleccionFiltro = new JPanel();
			pnSeleccionFiltro.setLayout(new GridLayout(0, 3, 0, 0));
			pnSeleccionFiltro.add(getLblNewLabel());
			pnSeleccionFiltro.add(getComboBox());
			pnSeleccionFiltro.add(getTextField());
		}
		return pnSeleccionFiltro;
	}

	private JPanel getPnBotonesFiltros() {
		if (pnBotonesFiltros == null) {
			pnBotonesFiltros = new JPanel();
			pnBotonesFiltros.add(getBtnFiltrar());
			pnBotonesFiltros.add(getBtnLimpiar());
		}
		return pnBotonesFiltros;
	}

	private JButton getBtnFiltrar() {
		if (btnFiltrar == null) {
			btnFiltrar = new JButton("Filtrar");
			btnFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 22));
			btnFiltrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Map<String, ThemePark> filter = new HashMap<>();
					for (Map.Entry<String, ThemePark> element : map
							.entrySet()) {
						ThemePark park = element.getValue();
						String value = (String) comboBox.getSelectedItem();
						switch (value) {
						case "city":
							value = park.getCity();
							break;
						case "country":
							value = park.getCountry();
							break;
						case "description":
							value = park.getDescription();
							break;
						case "namePark":
							value = park.getNamePark();
							break;
						}
						if (value.contains(textField.getText())) {
							filter.put(park.getCodePark(), park);
						}
					}
					cargarTabla(filter);
				}
			});
		}
		return btnFiltrar;
	}

	private JButton getBtnLimpiar() {
		if (btnLimpiar == null) {
			btnLimpiar = new JButton("Limpiar");
			btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 22));
			btnLimpiar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cargarTabla(map);
					textField.setText("");
				}
			});
		}
		return btnLimpiar;
	}

	private JComboBox<Object> getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox<Object>();
			comboBox.setFont(new Font("Tahoma", Font.PLAIN, 22));
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textField.setText("");
				}
			});
			comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {
					"city", "country", "description", "namePark" }));
		}
		return comboBox;
	}

	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
			textField.setColumns(10);
		}
		return textField;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Selecciona un campo:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel;
	}

	private JScrollPane getPnTabla() {
		if (pnTabla == null) {
			pnTabla = new JScrollPane();
			pnTabla.setViewportView(getTable());
		}
		return pnTabla;
	}

	private JTable getTable() {
		modeloTabla = new DefaultTableModel(new Object[] { "city", "country",
				"description", "namePark", "Ver datos" }, 0);
		if (table == null) {
			table = new JTable(modeloTabla);
		}
		return table;
	}

	private void borrarModelo() {
		while (modeloTabla.getRowCount() > 0)
			modeloTabla.removeRow(0);
	}

	private void cargarTabla(Map<String, ThemePark> map) {
		borrarModelo();
		for (Map.Entry<String, ThemePark> element : map.entrySet()) {
			ThemePark park = element.getValue();
			modeloTabla.addRow(new Object[] { park.getCity(), park.getCountry(),
					park.getDescription(), park.getNamePark(), new JButton() });
		}
	}

	public JPanel getPnCardlayout() {
		return pnCardlayout;
	}

	public void setPnCardlayout(JPanel pnCardlayout) {
		this.pnCardlayout = pnCardlayout;
	}

}
