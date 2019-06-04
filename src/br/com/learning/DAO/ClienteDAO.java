package br.com.learning.DAO;

import static java.util.Objects.isNull;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.learning.model.Cliente;

public class ClienteDAO {
	
	private EntityManagerFactory factory;

	public ClienteDAO(EntityManagerFactory factory) {
		this.factory = factory;
	}

	public Cliente incluir(Cliente cliente) {
		EntityManager manager = factory.createEntityManager();
		try {
	        manager.getTransaction().begin();        
	        manager.persist(cliente);
	        manager.getTransaction().commit();
	        return cliente;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
	        manager.close();		
		}
		return null;
	}
	
	public void alterar(Cliente cliente) {
		EntityManager manager = factory.createEntityManager();
		try {
	        manager.getTransaction().begin();        
	        manager.merge(cliente);
	        manager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
	        manager.close();		
		}
	}
	
	public void excluir(Integer id) {
		EntityManager manager = factory.createEntityManager();
		try {
			Cliente cliente = manager.find(Cliente.class, id);
			manager.getTransaction().begin();
	        manager.remove(cliente);
	        manager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Registro não encontrado");
			System.out.println(e.getMessage());
		} finally {
	        manager.close();		
		}
	}

	public Cliente listarPorId(Integer id) {
		EntityManager manager = factory.createEntityManager();
		try {
	        Cliente cliente = manager.find(Cliente.class, id);
	        return cliente;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
	        manager.close();		
		}
		return null;
	}
		
	public List<Cliente> listarTodos() {
		EntityManager manager = factory.createEntityManager();
		try {
			CriteriaBuilder cb = manager.getCriteriaBuilder();
			CriteriaQuery<Cliente> cr = cb.createQuery(Cliente.class);
			Root<Cliente> root = cr.from(Cliente.class);
			cr.select(root);
	        TypedQuery<Cliente> query = manager.createQuery("SELECT c FROM Cliente c", Cliente.class);
	        List<Cliente> clientes = query.getResultList();
	        return clientes;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
	        manager.close();		
		}
		return null;
	}
	
	public List<Cliente> listarPorNome(String nomeCliente) {
		EntityManager manager = factory.createEntityManager();
		if (isNull(nomeCliente)) {
			nomeCliente = "";
		}
		try {
			CriteriaBuilder cb = manager.getCriteriaBuilder();
			CriteriaQuery<Cliente> cr = cb.createQuery(Cliente.class);
			Root<Cliente> root = cr.from(Cliente.class);
			cr.select(root).where(cb.like(root.get("nome"), "%" + nomeCliente + "%"));
	        TypedQuery<Cliente> query = manager.createQuery(cr);
	        List<Cliente> clientes = query.getResultList();
	        return clientes;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
	        manager.close();		
		}
		return null;
	}
	
	public List<Cliente> listarPorDataNascimento(LocalDate dtNasc) {
		EntityManager manager = factory.createEntityManager();
		try {
			CriteriaBuilder cb = manager.getCriteriaBuilder();
			CriteriaQuery<Cliente> cr = cb.createQuery(Cliente.class);
			Root<Cliente> root = cr.from(Cliente.class);
			cr.select(root);
			
	        TypedQuery<Cliente> query = manager.createQuery(cr);
	        List<Cliente> clientes = query.getResultList();
	        return clientes;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
	        manager.close();		
		}
		return null;
	}
}
