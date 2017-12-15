package logica;

public class Paquetes {

	private String codigoPaquete;
	private String denominacionPaquetes;
	private String codigoParques;
	private String codigoAlojamiento;
	private int diasDuracion;
	private Long precioAdulto;
	private Long precioNiño;
	private String imagen;
	private boolean descuento;

	public Paquetes(String codigoPaquetes, String denominacionPaquetes,
			String codigoParques, String codigoAlojamiento, int diasDuracion,
			Long precioAdulto, Long precioNiño) {
		super();
		this.codigoPaquete = codigoPaquetes;
		this.denominacionPaquetes = denominacionPaquetes;
		this.codigoParques = codigoParques;
		this.codigoAlojamiento = codigoAlojamiento;
		this.diasDuracion = diasDuracion;
		this.precioAdulto = precioAdulto;
		this.precioNiño = precioNiño;
		this.imagen = codigoPaquete + ".jpg";

	}

	public String getImagen() {
		return imagen;
	}

	private void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getCodigoPaquetes() {
		return codigoPaquete;
	}

	public void setCodigoPaquetes(String codigoPaquetes) {
		this.codigoPaquete = codigoPaquetes;
		setImagen(codigoPaquete + ".jpg");
	}

	public String getDenominacionPaquetes() {
		return denominacionPaquetes;
	}

	public void setDenominacionPaquetes(String denominacionPaquetes) {
		this.denominacionPaquetes = denominacionPaquetes;
	}

	public String getCodigoParques() {
		return codigoParques;
	}

	public void setCodigoParques(String codigoParques) {
		this.codigoParques = codigoParques;
	}

	public String getCodigoAlojamiento() {
		return codigoAlojamiento;
	}

	public void setCodigoAlojamiento(String codigoAlojamiento) {
		this.codigoAlojamiento = codigoAlojamiento;
	}

	public int getDiasDuracion() {
		return diasDuracion;
	}

	public void setDiasDuracion(int diasDuracion) {
		this.diasDuracion = diasDuracion;
	}

	public Long getPrecioAdulto() {
		return precioAdulto;
	}

	public void setPrecioAdulto(Long precioAdulto) {
		this.precioAdulto = precioAdulto;
	}

	public Long getPrecioNiño() {
		return precioNiño;
	}

	public void setPrecioNiño(Long precioNiño) {
		this.precioNiño = precioNiño;
	}

	public String getCodigoPaquete() {
		return codigoPaquete;
	}

	public void setCodigoPaquete(String codigoPaquete) {
		this.codigoPaquete = codigoPaquete;
	}

	public boolean isDescuento() {
		return descuento;
	}

	public void setDescuento(boolean descuento) {
		this.descuento = descuento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoAlojamiento == null) ? 0
				: codigoAlojamiento.hashCode());
		result = prime * result
				+ ((codigoPaquete == null) ? 0 : codigoPaquete.hashCode());
		result = prime * result
				+ ((codigoParques == null) ? 0 : codigoParques.hashCode());
		result = prime * result + ((denominacionPaquetes == null) ? 0
				: denominacionPaquetes.hashCode());
		result = prime * result + (descuento ? 1231 : 1237);
		result = prime * result + diasDuracion;
		result = prime * result + ((imagen == null) ? 0 : imagen.hashCode());
		result = prime * result
				+ ((precioAdulto == null) ? 0 : precioAdulto.hashCode());
		result = prime * result
				+ ((precioNiño == null) ? 0 : precioNiño.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paquetes other = (Paquetes) obj;
		if (codigoAlojamiento == null) {
			if (other.codigoAlojamiento != null)
				return false;
		} else if (!codigoAlojamiento.equals(other.codigoAlojamiento))
			return false;
		if (codigoPaquete == null) {
			if (other.codigoPaquete != null)
				return false;
		} else if (!codigoPaquete.equals(other.codigoPaquete))
			return false;
		if (codigoParques == null) {
			if (other.codigoParques != null)
				return false;
		} else if (!codigoParques.equals(other.codigoParques))
			return false;
		if (denominacionPaquetes == null) {
			if (other.denominacionPaquetes != null)
				return false;
		} else if (!denominacionPaquetes.equals(other.denominacionPaquetes))
			return false;
		if (descuento != other.descuento)
			return false;
		if (diasDuracion != other.diasDuracion)
			return false;
		if (imagen == null) {
			if (other.imagen != null)
				return false;
		} else if (!imagen.equals(other.imagen))
			return false;
		if (precioAdulto == null) {
			if (other.precioAdulto != null)
				return false;
		} else if (!precioAdulto.equals(other.precioAdulto))
			return false;
		if (precioNiño == null) {
			if (other.precioNiño != null)
				return false;
		} else if (!precioNiño.equals(other.precioNiño))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Paquetes [codigoPaquete=" + codigoPaquete
				+ ", denominacionPaquetes=" + denominacionPaquetes
				+ ", codigoParques=" + codigoParques + ", codigoAlojamiento="
				+ codigoAlojamiento + ", diasDuracion=" + diasDuracion
				+ ", precioAdulto=" + precioAdulto + ", precioNiño="
				+ precioNiño + ", imagen=" + imagen + ", descuento=" + descuento
				+ "]";
	}

}
