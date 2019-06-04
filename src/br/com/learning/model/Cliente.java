package br.com.learning.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Cliente {
	
	@Id
	@Column(name="id_cliente")
	@GeneratedValue
	private Integer idCliente;
	@NotNull
	private String nome;
	@Size(max = 60)
	@NotNull
	private String cpf;
	@Temporal(TemporalType.DATE)
	private LocalDate dataNascimento;
	@OneToMany(mappedBy="cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Compra> compras;
	@OneToMany(mappedBy="cliente", cascade = CascadeType.ALL)
	private List<Endereco> enderecos;

	public Cliente() {
		compras = new ArrayList<>();
		enderecos = new ArrayList<>();
	}
	
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente= idCliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public List<Compra> getCompras() {
		return compras;
	}
	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", cpf=" + cpf + ", dataNascimento="
				+ dataNascimento + "]";
	}
}