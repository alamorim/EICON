package br.com.loja.teste.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@AutoConfigureTestEntityManager
@XmlRootElement(name = "pedido")
@Table(name = "pedido")
public class Pedido {
	
	@Id
	@Column(name="numero_controle")
	private Integer numeroControle;

	@Column(name="codigo_cliente")
	private Integer codigoCliente;
	
	@Column(name="data_cadastro")
	@JsonFormat(pattern="yyyy-MM-dd", locale = "pt-BR", timezone = "Brazil/East")
	private Date data;
	@Column(name="nome")
	private String nome;
	@Column(name="valor")
	private double valor;
	@Column(name="quantidade")
	private Integer quantidade;
	
	@Column(name="total")
	private String total;
	
	public Integer getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public Integer getNumeroControle() {
		return numeroControle;
	}
	public void setNumeroControle(Integer numeroControle) {
		this.numeroControle = numeroControle;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	
	@Override
	public String toString() {
		return "Pedido [codigoCliente=" + codigoCliente + ", controle=" + numeroControle + ", data=" + data + ", nome=" + nome
				+ ", valor=" + valor + ", quantidade=" + quantidade + ", total=" + total + "]";
	}

	
}
