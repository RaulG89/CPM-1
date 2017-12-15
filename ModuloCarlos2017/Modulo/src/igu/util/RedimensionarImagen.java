package igu.util;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Container;

import javax.swing.ImageIcon;

public class RedimensionarImagen extends Container {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ImageIcon imagen;

	public RedimensionarImagen(String nombre) {
		try {
			String ruta = "/img" + nombre + ".jpg";
			imagen = new ImageIcon(getClass().getResource(ruta));
		} catch (Exception e) {

			imagen = new ImageIcon(getClass().getResource("/img/Defecto.jpg"));
		}
	}

	public void paint(Graphics g) {
		Rectangle r = g.getClipBounds();
		g.setColor(this.getBackground());
		g.fillRect(r.x, r.y, r.width, r.height);
		g.drawImage(imagen.getImage(), 0, 0, this.getWidth(), this.getHeight(),
				this.getBackground(), this);
		super.paint(g);

	}

}
