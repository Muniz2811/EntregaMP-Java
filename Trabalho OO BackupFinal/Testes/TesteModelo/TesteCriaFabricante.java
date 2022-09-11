package TesteModelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Fabricante;

class TesteCriaFabricante {

	@Test
	public void CriarFabricante() {
		Fabricante fabricante = new Fabricante("Fabricante Teste", "12345678900", "Endereco fabricante Teste","Email Teste", "Razao social Teste", "12345678900000", "Contato fabricante Teste");
		
		assertEquals("Fabricante Teste", fabricante.getNome());
		assertEquals("12345678900", fabricante.getTelefone());
		assertEquals("Endereco fabricante Teste", fabricante.getEndereco());
		assertEquals("Email Teste", fabricante.getEmail());
		assertEquals("Razao social Teste", fabricante.getRZ());
		assertEquals("12345678900000", fabricante.getCN());
		assertEquals("Contato fabricante Teste", fabricante.getCONT());
	}

}
