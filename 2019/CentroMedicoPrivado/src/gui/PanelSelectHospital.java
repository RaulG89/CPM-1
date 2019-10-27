package gui;

import javax.swing.JPanel;

import logic.MedicalCenter;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class PanelSelectHospital extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel pnSelection;
	private JPanel pnRight;
	private JPanel pnMedicalCenter;
	private JPanel panel;
	private JPanel pn;
	private JPanel pnnCbCentro;
	private JPanel pbLblCentroMedico;
	private JLabel lblCentroMedico;
	private JComboBox comboBox;

	public PanelSelectHospital() {
		setLayout(new BorderLayout(0, 0));
		add(getPnSelection());
	}

	private JPanel getPnSelection() {
		if (pnSelection == null) {
			pnSelection = new JPanel();
			pnSelection.setLayout(new GridLayout(0, 1, 0, 0));
			pnSelection.add(getPnMedicalCenter());
			pnSelection.add(getPnRight());
		}
		return pnSelection;
	}
	private JPanel getPnRight() {
		if (pnRight == null) {
			pnRight = new JPanel();
		}
		return pnRight;
	}
	private JPanel getPnMedicalCenter() {
		if (pnMedicalCenter == null) {
			pnMedicalCenter = new JPanel();
			pnMedicalCenter.setLayout(new GridLayout(0, 2, 0, 0));
			pnMedicalCenter.add(getPanel());
			pnMedicalCenter.add(getPn());
		}
		return pnMedicalCenter;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(2, 0, 0, 0));
			panel.add(getPbLblCentroMedico());
			panel.add(getPnnCbCentro());
		}
		return panel;
	}
	private JPanel getPn() {
		if (pn == null) {
			pn = new JPanel();
		}
		return pn;
	}
	private JPanel getPnnCbCentro() {
		if (pnnCbCentro == null) {
			pnnCbCentro = new JPanel();
			pnnCbCentro.setLayout(new BorderLayout(0, 0));
			pnnCbCentro.add(getComboBox());
		}
		return pnnCbCentro;
	}
	private JPanel getPbLblCentroMedico() {
		if (pbLblCentroMedico == null) {
			pbLblCentroMedico = new JPanel();
			pbLblCentroMedico.setLayout(new BorderLayout(0, 0));
			pbLblCentroMedico.add(getLblCentroMedico());
		}
		return pbLblCentroMedico;
	}
	private JLabel getLblCentroMedico() {
		if (lblCentroMedico == null) {
			lblCentroMedico = new JLabel("Centro Medico:");
		}
		return lblCentroMedico;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
		}
		return comboBox;
	}
}
