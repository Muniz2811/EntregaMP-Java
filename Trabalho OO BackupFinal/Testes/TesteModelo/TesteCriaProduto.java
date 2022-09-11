package TesteModelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Fabricante;
import modelo.Produto;

class TesteCriaProduto {

	@Test
	public void CriarProduto() {
		Fabricante fabricante = new Fabricante("Fabricante Teste", "12345678900", "Endereco fabricante Teste","Email Teste", "Razao social Teste", "12345678900000", "Contato fabricante Teste");
		Produto produto = new Produto("Produto Teste" , 100, "Categoria Teste",200, fabricante);
		
		
		assertEquals("Produto Teste", produto.getNome());
		assertEquals(100, produto.getVC());
		assertEquals("Categoria Teste", produto.getCat());
		assertEquals(200, produto.getVV());
		
		assertEquals("Fabricante Teste", produto.getFabricanteProd().getNome());
		assertEquals("12345678900", produto.getFabricanteProd().getTelefone());
		assertEquals("Endereco fabricante Teste", produto.getFabricanteProd().getEndereco());
		assertEquals("Email Teste", produto.getFabricanteProd().getEmail());
		assertEquals("Razao social Teste", produto.getFabricanteProd().getRZ());
		assertEquals("12345678900000", produto.getFabricanteProd().getCN());
		assertEquals("Contato fabricante Teste", produto.getFabricanteProd().getCONT());
	}
	
}
