package TesteModelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Cliente;
import modelo.Fabricante;
import modelo.Produto;
import modelo.Venda;

class TesteCriaVenda {

	@Test
	public void CriarVenda() {
		Fabricante fabricante = new Fabricante("Fabricante Teste", "12345678900", "Endereco fabricante Teste","Email Teste", "Razao social Teste", "12345678900000", "Contato fabricante Teste");
		Cliente cliente = new Cliente("Cliente Teste" , "11111111111", "Endereco cliente teste","Email Cliente teste", "12345678900", "Forma pag cliente teste", "RG teste");
		Produto produto = new Produto("Produto Teste" , 100, "Categoria Teste",200, fabricante);
		Venda venda = new Venda("ID Teste", 10, 9,2022,200, cliente, produto);
		
		
		assertEquals("ID Teste", venda.getIdentif());
		assertEquals(10, venda.getDia());
		assertEquals(9, venda.getMes());
		assertEquals(2022, venda.getAno());
		assertEquals(200, venda.getVT());
		
		assertEquals("Cliente Teste", venda.getClienteVenda().getNome());
		assertEquals("11111111111", venda.getClienteVenda().getTelefone());
		assertEquals("Endereco cliente teste", venda.getClienteVenda().getEndereco());
		assertEquals("Email Cliente teste", venda.getClienteVenda().getEmail());
		assertEquals("12345678900", venda.getClienteVenda().getCpf());
		assertEquals("Forma pag cliente teste", venda.getClienteVenda().getFormaPag());
		assertEquals("RG teste", venda.getClienteVenda().getRG());
		
		assertEquals("Produto Teste", venda.getProdVenda().getNome());
		assertEquals(100, venda.getProdVenda().getVC());
		assertEquals("Categoria Teste", venda.getProdVenda().getCat());
		assertEquals(200, venda.getProdVenda().getVV());
		
		assertEquals("Fabricante Teste", venda.getProdVenda().getFabricanteProd().getNome());
		assertEquals("12345678900", venda.getProdVenda().getFabricanteProd().getTelefone());
		assertEquals("Endereco fabricante Teste", venda.getProdVenda().getFabricanteProd().getEndereco());
		assertEquals("Email Teste", venda.getProdVenda().getFabricanteProd().getEmail());
		assertEquals("Razao social Teste", venda.getProdVenda().getFabricanteProd().getRZ());
		assertEquals("12345678900000", venda.getProdVenda().getFabricanteProd().getCN());
		assertEquals("Contato fabricante Teste", venda.getProdVenda().getFabricanteProd().getCONT());
	}

}
