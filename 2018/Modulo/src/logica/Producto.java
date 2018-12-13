package logica;

public class Producto {

	private String codigo;
	private String nombre;
	private TipoProducto tipo;
	private String descripcion;
	private double precioUnidad;
	private double precioGrupo;
	private String foto;

	public Producto(String cod, TipoProducto tipo, String nom, String desc, float precioInd, float precioG) {
		this.codigo = cod;
		this.tipo = tipo;
		this.nombre = nom;
		this.setDescripcion(desc);
		this.precioUnidad = precioInd;
		this.precioGrupo = precioG;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoProducto getTipo() {
		return tipo;
	}

	public void setTipo(TipoProducto tipo) {
		this.tipo = tipo;
	}

	public double getPrecioUnidad() {
		return precioUnidad;
	}

	public void setPrecioUnidad(double precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	public double getPrecioGrupo() {
		return precioGrupo;
	}

	public void setPrecioGrupo(double precioGrupo) {
		this.precioGrupo = precioGrupo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", tipo=" + tipo + ", precioUnidad=" + precioUnidad
				+ ", precioGrupo=" + precioGrupo + ", foto=" + foto + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((foto == null) ? 0 : foto.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		long temp;
		temp = Double.doubleToLongBits(precioGrupo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(precioUnidad);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Producto other = (Producto) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (foto == null) {
			if (other.foto != null)
				return false;
		} else if (!foto.equals(other.foto))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (Double.doubleToLongBits(precioGrupo) != Double.doubleToLongBits(other.precioGrupo))
			return false;
		if (Double.doubleToLongBits(precioUnidad) != Double.doubleToLongBits(other.precioUnidad))
			return false;
		return true;
	}

}
