package br.com.learning.application;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.learning.model.Cliente;
import br.com.learning.model.Compra;
import br.com.learning.model.Endereco;
import br.com.learning.service.ClienteService;
import br.com.learning.service.CompraService;
import br.com.learning.service.EnderecoService;

public class App {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("testePU");

		ClienteService clienteService = new ClienteService(factory);
		EnderecoService enderecoService = new EnderecoService(factory);
		CompraService compraService = new CompraService(factory);


		LocalDate dataNascimento = LocalDate.of(1969, 11, 03);
		//cliente1.setDataNascimento(dataNascimento);
		
		
		
		BigDecimal valor1 = BigDecimal.valueOf(101.99);
		BigDecimal valor2 = BigDecimal.valueOf(201.99);
		BigDecimal valor3 = BigDecimal.valueOf(301.99);
		BigDecimal valor4 = BigDecimal.valueOf(401.99);
		BigDecimal valor5 = BigDecimal.valueOf(2);
		BigDecimal resultado = BigDecimal.ZERO;
		
	    resultado = resultado.add(valor4).add(valor2).multiply(valor5);
	    System.out.println(resultado);

	    resultado = resultado.add(valor4).divide(valor5, 2, BigDecimal.ROUND_HALF_UP);
	    System.out.println(resultado);

	    resultado = resultado.add(valor4).add(valor2).subtract(valor5);
	    System.out.println(resultado);

	    resultado = resultado.add(valor4).subtract(valor1);
	    System.out.println(resultado);

		resultado = resultado.add(valor1)
				             .add(valor2)
				             .add(valor3)
				             .add(valor4);
	    System.out.println(resultado);
		
	    resultado = resultado.setScale(0, BigDecimal.ROUND_HALF_UP);
	    System.out.println(resultado);
	    
	    
		if (valor1.compareTo(valor2) == 0) {
			System.out.println("Os valores sao iguais");
		} else if (valor1.compareTo(valor2) > 0) {
			System.out.println("O primeiro valor e maior");
		} else if (valor1.compareTo(valor2) < 0) {
			System.out.println("O segundo valor e maior");
		}
		
		//compraService.sumarizarCompra(compraService.listarPorCliente(8));
	    //compraService.percentualDaCompra(compraService.listarPorCliente(8));
		
		//System.out.println(clienteService.listarPorId(3));
		//System.out.println(dataNascimento.format(DateTimeFormatter.ofPattern("dd MM yyyy")));
		//System.out.println(ChronoUnit.DAYS.between(dataNascimento, LocalDate.now()));

		/*
		for (Cliente cliente : clienteService.listarTodos()) {
			System.out.println(cliente);
		}
		*/
	}

}
