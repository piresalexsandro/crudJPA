package br.com.learning.DAO;

import static java.util.Objects.isNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.learning.model.Endereco;

public class EnderecoDAO {

	private EntityManagerFactory factory;

	public EnderecoDAO(EntityManagerFactory factory) {
		this.factory = factory;
	}

	public Endereco incluir(Endereco endereco) {
		EntityManager manager = factory.createEntityManager();
		try {
	        manager.getTransaction().begin();        
	        manager.persist(endereco);
	        manager.getTransaction().commit();
	        return endereco;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
	        manager.close();		
		}
		return null;
	}
	
	public void alterar(Endereco endereco) {
		EntityManager manager = factory.createEntityManager();
		try {
	        manager.getTransaction().begin();        
	        manager.merge(endereco);
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
			Endereco endereco = manager.find(Endereco.class, id);
			manager.getTransaction().begin();
	        manager.remove(endereco);
	        manager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
	        manager.close();		
		}
	}

	public Endereco listarPorId(Integer id) {
		EntityManager manager = factory.createEntityManager();
		try {
	        Endereco endereco = manager.find(Endereco.class, id);
	        return endereco;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
	        manager.close();		
		}
		return null;
	}
		
	public List<Endereco> listarTodos() {
		EntityManager manager = factory.createEntityManager();
		try {
			CriteriaBuilder cb = manager.getCriteriaBuilder();
			CriteriaQuery<Endereco> enderecoQuery = cb.createQuery(Endereco.class);
			Root<Endereco> root = enderecoQuery.from(Endereco.class);
			enderecoQuery.select(root);
			
	        TypedQuery<Endereco> query = manager.createQuery(enderecoQuery);
	        List<Endereco> enderecos = query.getResultList();
	        return enderecos;
//	        TypedQuery<Endereco> query = manager.createQuery("SELECT * FROM Endereco", Endereco.class);
//	        List<Endereco> enderecos = query.getResultList();
//	        return enderecos;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
	        manager.close();		
		}
		return null;
	}
	
	public List<Endereco> listarPorNomeLogradouro(String nomeLogradouro) {
		EntityManager manager = factory.createEntityManager();
		if (isNull(nomeLogradouro)) {
			nomeLogradouro = "";
		}
		try {
			CriteriaBuilder cb = manager.getCriteriaBuilder();
			CriteriaQuery<Endereco> enderecoQuery = cb.createQuery(Endereco.class);
			Root<Endereco> root = enderecoQuery.from(Endereco.class);
			enderecoQuery.select(root).where(cb.like(root.get("nomeLogradouro"), "%" + nomeLogradouro + "%"));

	        TypedQuery<Endereco> query = manager.createQuery(enderecoQuery);
	        List<Endereco> enderecos = query.getResultList();
	        return enderecos;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
	        manager.close();		
		}
		return null;
	}
	
	public List<Endereco> listarPorNumero(Integer numero) {
		EntityManager manager = factory.createEntityManager();
		try {
			CriteriaBuilder cb = manager.getCriteriaBuilder();
			CriteriaQuery<Endereco> enderecoQuery = cb.createQuery(Endereco.class);
			Root<Endereco> root = enderecoQuery.from(Endereco.class);
			enderecoQuery.select(root).where(cb.equal(root.get("numero"), numero));
			
	        TypedQuery<Endereco> query = manager.createQuery(enderecoQuery);
	        List<Endereco> enderecos = query.getResultList();
	        return enderecos;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
	        manager.close();		
		}
		return null;
	}
}
