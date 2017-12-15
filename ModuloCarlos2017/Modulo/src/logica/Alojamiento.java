package logica;

public class Alojamiento {
	private String codigoAlojamiento;
	private String tipo;
	private int estrellasCategoria;
	private String denominacion;
	private String codigoParque;
	private int nPlazas;
	private Long precioAlojamiento;
	private String imagen;
	private boolean descuento;

	public Alojamiento(String codigoAlojamiento, String tipo,
			int estrellasCategoria, String denominacion, String codigoParque,
			int nPlazas, Long precioAlojamiento) {
		super();
		this.codigoAlojamiento = codigoAlojamiento;
		this.tipo = tipo;
		this.estrellasCategoria = estrellasCategoria;
		this.denominacion = denominacion;
		this.codigoParque = codigoParque;
		this.nPlazas = nPlazas;
		this.precioAlojamiento = precioAlojamiento;
		this.imagen = codigoAlojamiento + ".jpg";
	}

	public String getImagen() {
		return imagen;
	}

	private void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getCodigoAlojamiento() {
		return codigoAlojamiento;
	}

	public void setCodigoAlojamiento(String codigoAlojamiento) {
		this.codigoAlojamiento = codigoAlojamiento;
		setImagen(codigoAlojamiento + ".jpg");
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getEstrellasCategoria() {
		return estrellasCategoria;
	}

	public void setEstrellasCategoria(int estrellasCategoria) {
		this.estrellasCategoria = estrellasCategoria;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public String getCodigoParque() {
		return codigoParque;
	}

	public void setCodigoParque(String codigoParque) {
		this.codigoParque = codigoParque;
	}

	public int getnPlazas() {
		return nPlazas;
	}

	public void setnPlazas(int nPlazas) {
		this.nPlazas = nPlazas;
	}

	public Long getPrecioAlojamiento() {
		return precioAlojamiento;
	}

	public void setPrecioAlojamiento(Long precioAlojamiento) {
		this.precioAlojamiento = precioAlojamiento;
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
				+ ((codigoParque == null) ? 0 : codigoParque.hashCode());
		result = prime * result
				+ ((denominacion == null) ? 0 : denominacion.hashCode());
		result = prime * result + (descuento ? 1231 : 1237);
		result = prime * result + estrellasCategoria;
		result = prime * result + ((imagen == null) ? 0 : imagen.hashCode());
		result = prime * result + nPlazas;
		result = prime * result + ((precioAlojamiento == null) ? 0
				: precioAlojamiento.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Alojamiento other = (Alojamiento) obj;
		if (codigoAlojamiento == null) {
			if (other.codigoAlojamiento != null)
				return false;
		} else if (!codigoAlojamiento.equals(other.codigoAlojamiento))
			return false;
		if (codigoParque == null) {
			if (other.codigoParque != null)
				return false;
		} else if (!codigoParque.equals(other.codigoParque))
			return false;
		if (denominacion == null) {
			if (other.denominacion != null)
				return false;
		} else if (!denominacion.equals(other.denominacion))
			return false;
		if (descuento != other.descuento)
			return false;
		if (estrellasCategoria != other.estrellasCategoria)
			return false;
		if (imagen == null) {
			if (other.imagen != null)
				return false;
		} else if (!imagen.equals(other.imagen))
			return false;
		if (nPlazas != other.nPlazas)
			return false;
		if (precioAlojamiento == null) {
			if (other.precioAlojamiento != null)
				return false;
		} else if (!precioAlojamiento.equals(other.precioAlojamiento))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Alojamiento [codigoAlojamiento=" + codigoAlojamiento + ", tipo="
				+ tipo + ", estrellasCategoria=" + estrellasCategoria
				+ ", denominacion=" + denominacion + ", codigoParque="
				+ codigoParque + ", nPlazas=" + nPlazas + ", precioAlojamiento="
				+ precioAlojamiento + ", imagen=" + imagen + ", descuento="
				+ descuento + "]";
	}

}
