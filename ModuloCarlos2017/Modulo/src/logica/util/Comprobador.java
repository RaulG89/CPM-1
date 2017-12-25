package logica.util;

import java.util.Date;

import javax.swing.JOptionPane;
import igu.Vprincipal;

public class Comprobador {

	/**
	 * 
	 */

	@SuppressWarnings("deprecation")
	public static boolean comprobarFiltro(Vprincipal v1) {
		Date llegada=v1.getDcLlegada().getDate();
		Date salida=v1.getDcSalida().getDate();
		
		if (v1.getDcLlegada().getDate() == null || v1.getDcSalida().getDate() == null
				|| v1.getCbPersonas().getSelectedItem() == null || v1.getCbPais().getSelectedItem() == null
				|| (!(v1.getRbAlojamiento().isSelected()) && !(v1.getRbParque().isSelected())
						&& !(v1.getRbAmbos().isSelected()))|| llegada.after(salida)) {
			
			

			if (v1.getDcLlegada().getDate() == null) {
				JOptionPane.showMessageDialog(null, "El campo de la fecha de llegada se encuentra vacio");
			}

			else if (v1.getDcSalida().getDate() == null) {
				JOptionPane.showMessageDialog(null, "El campo de la fecha de salida se encuentra vacio");
			}

			else if (v1.getCbPersonas().getSelectedItem() == null) {
				JOptionPane.showMessageDialog(null, "El campo del numero de personas se encuentra vacio");

			}

			else if (v1.getCbPais().getSelectedItem() == null) {
				JOptionPane.showMessageDialog(null, "El campo del pais se encuentra vacio");

			}

			else if ((!(v1.getRbAlojamiento().isSelected()) && !(v1.getRbParque().isSelected())
					&& !(v1.getRbAmbos().isSelected()))) {
				JOptionPane.showMessageDialog(null, "El campo del tipo de alojamiento se encuentra vacio");

			} else if (llegada.after(salida)) {
				JOptionPane.showMessageDialog(null, "La fecha de llegada es posterior a la de salida");
				return false;
			}
			return false;

		} else {
			llegada.setHours(0);
			llegada.setMinutes(0);
			llegada.setSeconds(0);
			
			salida.setHours(0);
			salida.setMinutes(0);
			salida.setSeconds(0);
				return true;
		}
	}

}
