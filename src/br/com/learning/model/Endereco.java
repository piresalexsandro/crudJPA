package br.com.learning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Endereco {

	@Id
	@Column(name="id_endereco")
	@GeneratedValue
	private Integer idEndereco;
	@NotNull
	private String nomeLogradouro;
	@NotNull
	private Integer numero;
    @ManyToOne
    @JoinColumn(name="id_cliente", nullable=false)
	private Cliente cliente;
	
	public Integer getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}
	public String getNomeLogradouro() {
		return nomeLogradouro;
	}
	public void setNomeLogradouro(String nomeLogradouro) {
		this.nomeLogradouro = nomeLogradouro;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@Override
	public String toString() {
		return "Endereco [idEndereco=" + idEndereco + ", nomeLogradouro=" + nomeLogradouro + ", numero=" + numero + "]";
	}
	
	
}