package br.com.learning.DAO;

import static java.util.Objects.isNull;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.learning.model.Compra;

public class CompraDAO {

	private EntityManagerFactory factory;

	public CompraDAO(EntityManagerFactory factory) {
		this.factory = factory;
	}

	public Compra incluir(Compra compra) {
		EntityManager manager = factory.createEntityManager();
		try {
	        manager.getTransaction().begin();        
	        manager.persist(compra);
	        manager.getTransaction().commit();
	        return compra;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
	        manager.close();		
		}
		return null;
	}
	
	public void alterar(Compra compra) {
		EntityManager manager = factory.createEntityManager();
		try {
	        manager.getTransaction().begin();        
	        manager.merge(compra);
	        manager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
	        manager.close();		
		}
	}
	
	public Compra listarPorId(Integer id) {
		EntityManager manager = factory.createEntityManager();
		try {
	        Compra compra = manager.find(Compra.class, id);
	        return compra;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
	        manager.close();		
		}
		return null;
	}
		
	public void excluir(Integer id) {
		EntityManager manager = factory.createEntityManager();
		try {
			Compra compra = manager.find(Compra.class, id);
			manager.getTransaction().begin();
	        manager.remove(compra);
	        manager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
	        manager.close();		
		}
	}

	public List<Compra> listarPorCliente(Integer id) {
		EntityManager manager = factory.createEntityManager();
		try {
			CriteriaBuilder cb = manager.getCriteriaBuilder();
			CriteriaQuery<Compra> compraQuery = cb.createQuery(Compra.class);
			Root<Compra> root = compraQuery.from(Compra.class);
			// navega ate o atributo em cliente
			compraQuery.select(root).where(cb.equal(root.get("cliente").get("idCliente"), id));
	        TypedQuery<Compra> query = manager.createQuery(compraQuery);
	        List<Compra> compras = query.getResultList();
	        return compras;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
	        manager.close();		
		}
		return null;
	}
	
	public List<Compra> listarTodos() {
		EntityManager manager = factory.createEntityManager();
		try {
//	        TypedQuery<Compra> query = manager.createQuery("SELECT * FROM  Compra", Compra.class);
//	        List<Compra> compras = query.getResultList();
			CriteriaBuilder cb = manager.getCriteriaBuilder();
			CriteriaQuery<Compra> compraQuery = cb.createQuery(Compra.class);
			Root<Compra> root = compraQuery.from(Compra.class);
			compraQuery.select(root);
			
	        TypedQuery<Compra> query = manager.createQuery(compraQuery);
	        List<Compra> compras = query.getResultList();
	        return compras;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
	        manager.close();		
		}
		return null;
	}
	
	public List<Compra> listarMaiorQue(BigDecimal valorMaiorQue) {
		EntityManager manager = factory.createEntityManager();
		if (isNull(valorMaiorQue)) {
			valorMaiorQue = BigDecimal.valueOf(0);
		}
		try {
			CriteriaBuilder cb = manager.getCriteriaBuilder();
			CriteriaQuery<Compra> compraQuery = cb.createQuery(Compra.class);
			Root<Compra> root = compraQuery.from(Compra.class);
			compraQuery.select(root).where(cb.gt(root.get("valorCompra"), valorMaiorQue));
			
	        TypedQuery<Compra> query = manager.createQuery(compraQuery);
	        List<Compra> compras = query.getResultList();
	        return compras;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
	        manager.close();		
		}
		return null;
	}
	
	public List<Compra> listarMenorQue(BigDecimal valorMenorQue) {
		EntityManager manager = factory.createEntityManager();
		if (isNull(valorMenorQue)) {
			valorMenorQue = BigDecimal.valueOf(999999.99);
		}
		try {
			CriteriaBuilder cb = manager.getCriteriaBuilder();
			CriteriaQuery<Compra> compraQuery = cb.createQuery(Compra.class);
			Root<Compra> root = compraQuery.from(Compra.class);
			compraQuery.select(root).where(cb.gt(root.get("valorCompra"), valorMenorQue));
			
	        TypedQuery<Compra> query = manager.createQuery(compraQuery);
	        List<Compra> compras = query.getResultList();
	        return compras;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
	        manager.close();		
		}
		return null;
	}
}