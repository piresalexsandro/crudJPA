package br.com.learning.service;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import br.com.learning.DAO.ClienteDAO;
import br.com.learning.model.Cliente;

public class ClienteService {

	private ClienteDAO clienteDAO;

	public ClienteService(EntityManagerFactory factory) {
		clienteDAO = new ClienteDAO(factory);
	}

	public Cliente incluir(Cliente cliente) {
		return clienteDAO.incluir(cliente);
	}

	public void excluir(Integer id) {
		clienteDAO.excluir(id);
	}

	public void alterar(Cliente cliente) {
		clienteDAO.alterar(cliente);
	}

	public Cliente listarPorId(Integer id) {
		return clienteDAO.listarPorId(id);
	}

	public List<Cliente> listarTodos() {
		return clienteDAO.listarTodos();
	}

	public List<Cliente> listarPorNome(String nomeCliente) {
		return clienteDAO.listarPorNome(nomeCliente);
	}

	public List<Cliente> listarPorDataNascimento(LocalDate dtNasc) {
		return clienteDAO.listarPorDataNascimento(dtNasc);
	}

}
