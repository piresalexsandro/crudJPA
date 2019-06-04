package br.com.learning.service;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import br.com.learning.DAO.EnderecoDAO;
import br.com.learning.model.Endereco;

public class EnderecoService {
	
	private EnderecoDAO enderecoDAO;
	
	public EnderecoService(EntityManagerFactory factory) {
		enderecoDAO = new EnderecoDAO(factory);
	}
	
	public Endereco incluir(Endereco endereco) {
		return enderecoDAO.incluir(endereco);
	}
	
	public void alterar(Endereco endereco) {
		enderecoDAO.alterar(endereco);
	}
	
	public void excluir(Integer id) {
		enderecoDAO.excluir(id);
	}
	
	public Endereco listarPorId(Integer id) {
		return enderecoDAO.listarPorId(id);
	}
	
	public List<Endereco> listarTodos(){
		return enderecoDAO.listarTodos();
	}
	
	public List<Endereco> listarPorNumero(Integer numero){
		return enderecoDAO.listarPorNumero(numero);
	}
	
	public List<Endereco> listarPorNomeLogradouro(String nomeLogradouro){
		return enderecoDAO.listarPorNomeLogradouro(nomeLogradouro);
	}
}
