package logica;

public class Entrada {
	private String codigoEntrada;
	private String codigoParques;
	private Long precioAdulto;
	private Long precioNiño;
	private boolean descuento;

	public Entrada(String codigoEntrada, String codigoParques, Long precioAdulto, Long precioNiño) {
		super();
		this.codigoEntrada = codigoEntrada;
		this.codigoParques = codigoParques;
		this.precioAdulto = precioAdulto;
		this.precioNiño = precioNiño;
	}

	public String getCodigoEntrada() {
		return codigoEntrada;
	}

	public void setCodigoEntrada(String codigoEntrada) {
		this.codigoEntrada = codigoEntrada;
	}

	public String getCodigoParques() {
		return codigoParques;
	}

	public void setCodigoParques(String codigoParques) {
		this.codigoParques = codigoParques;
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
		result = prime * result + ((codigoEntrada == null) ? 0 : codigoEntrada.hashCode());
		result = prime * result + ((codigoParques == null) ? 0 : codigoParques.hashCode());
		result = prime * result + (descuento ? 1231 : 1237);
		result = prime * result + ((precioAdulto == null) ? 0 : precioAdulto.hashCode());
		result = prime * result + ((precioNiño == null) ? 0 : precioNiño.hashCode());
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
		Entrada other = (Entrada) obj;
		if (codigoEntrada == null) {
			if (other.codigoEntrada != null)
				return false;
		} else if (!codigoEntrada.equals(other.codigoEntrada))
			return false;
		if (codigoParques == null) {
			if (other.codigoParques != null)
				return false;
		} else if (!codigoParques.equals(other.codigoParques))
			return false;
		if (descuento != other.descuento)
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
		return "Entradas [codigoEntrada=" + codigoEntrada + ", codigoParques=" + codigoParques + ", precioAdulto="
				+ precioAdulto + ", precioNiño=" + precioNiño + ", descuento=" + descuento + "]";
	}

}
