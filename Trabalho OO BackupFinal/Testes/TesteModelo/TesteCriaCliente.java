package TesteModelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Cliente;

class TesteCriaCliente {

	@Test
	public void CriarCliente() {
		Cliente cliente = new Cliente("Cliente teste" , "Tel teste", "Endereco cliente teste","Email Cliente teste", "12345678900", "Forma pag cliente teste", "RG teste");
		
		
		assertEquals("Cliente teste", cliente.getNome());
		assertEquals("Tel teste", cliente.getTelefone());
		assertEquals("Endereco cliente teste", cliente.getEndereco());
		assertEquals("Email Cliente teste", cliente.getEmail());
		assertEquals("12345678900", cliente.getCpf());
		assertEquals("Forma pag cliente teste", cliente.getFormaPag());
		assertEquals("RG teste", cliente.getRG());
	}
	

}
