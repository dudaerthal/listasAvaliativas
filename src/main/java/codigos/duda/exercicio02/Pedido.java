package codigos.duda.exercicio02;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private BigDecimal valorPedido;
	private Integer idGarcom;
	private boolean gorjeta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(BigDecimal valorPedido) {
		this.valorPedido = valorPedido;
	}

	public Integer getIdGarcom() {
		return idGarcom;
	}

	public void setIdGarcom(Integer idGarcom) {
		this.idGarcom = idGarcom;
	}

	public boolean isGorjeta() {
		return gorjeta;
	}

	public void setGorjeta(boolean gorjeta) {
		this.gorjeta = gorjeta;
	}

	public Pedido(Integer id, BigDecimal valorPedido, Integer idGarcom, boolean gorjeta) {
		super();
		this.id = id;
		this.valorPedido = valorPedido;
		this.idGarcom = idGarcom;
		this.gorjeta = gorjeta;
	}

	public Pedido() {
		super();
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", valorPedido=" + valorPedido + ", idGarcom=" + idGarcom + ", gorjeta=" + gorjeta
				+ "]";
	}

}
