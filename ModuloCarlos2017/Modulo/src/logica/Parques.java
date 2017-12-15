package logica;

public class Parques {
	private String codigo;
	private String denominacion;
	private String pais;
	private String localidad;
	private String descripcion;
	private String imagen;
	private boolean descuento;

	public Parques(String codigo, String denominacion, String pais,
			String localidad, String descripcion) {
		this.codigo = codigo;
		this.denominacion = denominacion;
		this.pais = pais;
		this.localidad = localidad;
		this.descripcion = descripcion;
		this.imagen = codigo + ".jpg";
	}

	public String getImagen() {
		return imagen;
	}

	private void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
		setImagen(codigo + ".jpg");
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((denominacion == null) ? 0 : denominacion.hashCode());
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + (descuento ? 1231 : 1237);
		result = prime * result + ((imagen == null) ? 0 : imagen.hashCode());
		result = prime * result
				+ ((localidad == null) ? 0 : localidad.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
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
		Parques other = (Parques) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (denominacion == null) {
			if (other.denominacion != null)
				return false;
		} else if (!denominacion.equals(other.denominacion))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (descuento != other.descuento)
			return false;
		if (imagen == null) {
			if (other.imagen != null)
				return false;
		} else if (!imagen.equals(other.imagen))
			return false;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Parques [codigo=" + codigo + ", denominacion=" + denominacion
				+ ", pais=" + pais + ", localidad=" + localidad
				+ ", descripcion=" + descripcion + ", imagen=" + imagen
				+ ", descuento=" + descuento + "]";
	}

}
