package br.com.learning.service;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import br.com.learning.DAO.CompraDAO;
import br.com.learning.model.Compra;

public class CompraService {

	private CompraDAO compraDAO;

	public CompraService(EntityManagerFactory factory) {
		compraDAO = new CompraDAO(factory);
	}
	
	public Compra incluir(Compra compra) {
		return compraDAO.incluir(compra);
	}

	public void alterar(Compra compra) {
		compraDAO.alterar(compra);
	}

	public void excluir(Integer id) {
		compraDAO.excluir(id);
	}

	public Compra listarPorId(Integer id) {
		return compraDAO.listarPorId(id);
	}
	
	public List<Compra> listarTodos(){
		return compraDAO.listarTodos();
	}
	
	public List<Compra> listarMaiorQue(BigDecimal valorMaiorQue){
		return compraDAO.listarMaiorQue(valorMaiorQue);
	}
	
	public List<Compra> listarMenorQue(BigDecimal valorMenorQue){
		return compraDAO.listarMenorQue(valorMenorQue);
	}
	
	public List<Compra> listarPorCliente(Integer idCliente){
		return compraDAO.listarPorCliente(idCliente);
	}
	
	public BigDecimal sumarizarCompra(List<Compra> listaCompras) {
		
		BigDecimal totalCompra = BigDecimal.ZERO;
		
		for(Compra compra : listaCompras) {
			totalCompra = totalCompra.add(compra.getValorCompra());
		}
		return totalCompra;
	}
	
	public void percentualDaCompra(List<Compra> listaCompras) {

		BigDecimal totalCompra = sumarizarCompra(listaCompras);
		BigDecimal percentualMaximo = BigDecimal.valueOf(100.00);
		BigDecimal percentualDaCompra = BigDecimal.ZERO;
		
		if (totalCompra.compareTo(BigDecimal.ZERO) == 0) {
			return;
	    }	
		
		for(Compra compra : listaCompras) {
			percentualDaCompra = compra.getValorCompra()
					                   .multiply(percentualMaximo)
					                   // divide, nao esquecer de tratar arredondamento e casas decimais
					                   .divide(totalCompra, 2, BigDecimal.ROUND_HALF_UP); 
			
		    System.out.println("A compra: " + compra.getIdCompra() +  
		    		           ", no valor de: " + compra.getValorCompra() +
		    		           ", representa o percentual de: " + percentualDaCompra + 
		    		           ", sobre o valor total da compra que e de : " + totalCompra);
		}
	}
}
