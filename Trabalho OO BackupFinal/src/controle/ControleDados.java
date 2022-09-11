package controle;
import modelo.*;

/**
 * Classe ControleDados controla a classe de Dados
 * @author Pedro Henrique Muniz de Oliveira
 * @since 2022
 * @version 1.0
 */


public class ControleDados {
    private Dados d = new Dados();
	
    /**
     * Preenche com dados estabelecidos na classe Dados
     */
	public ControleDados() {
		d.PreencheDados();
	}
	
	public Dados getDados(){
		return d;
	}
	public void setDados(Dados d) {
		this.d = d;
	}

	public Fabricante[] getFabricantes() {
		return this.d.getFabricantes();
	}
	
	public int getQtdFabricantes() {
		return this.d.getQtdFabricantes();
	}
	
	public int getQtdClientes() {
		return this.d.getQtdClientes();
	}
	
	public  Cliente[] getClientes() {
		return this.d.getClientes();
	}
	
	public Produto[] getProdutos() {
		return this.d.getProdutos();
	}
	
	public Venda[] getVendas() {
		return this.d.getVendas();
	}
	
	public int getQtdVendas() {
		return this.d.getQtdVendas();
	}
	
	public int getQtdProds() {
		return this.d.getQtdProdutos();
	}
	
    
	/**
	 * Insere ou edita os dados de um cliente
	 * @param dadosClientes  dados dos clientes recebidos da view
	 * @return boolean
	 */
	public boolean inserirEditarCliente(String[] dadosClientes) {
		if(!dadosClientes[2].matches("[0-9]+") || !dadosClientes[5].matches("[0-9]+") || !dadosClientes[7].matches("[0-9]+")) {
			return false;
		}else {
			Cliente c = new Cliente(dadosClientes[1],dadosClientes[2],dadosClientes[3], dadosClientes[4],dadosClientes[5], dadosClientes[6], dadosClientes[7]);
			d.inserirEditarCliente(c, Integer.parseInt(dadosClientes[0]));
			return true;
			
		}
				
		
	}
	
	/**
	 * Insere ou edita os dados de um fabricante
	 * @param dadosFabricantes  dados dos fabricantes recebidos da view
	 * @return boolean
	 */
     public boolean inserirEditarFabricante(String[] dadosFabricantes) {
    	 if(!dadosFabricantes[2].matches("[0-9]+") || !dadosFabricantes[6].matches("[0-9]+")) {
    		 return false;
    	 }else {
    		 Fabricante f = new Fabricante(dadosFabricantes[1], dadosFabricantes[2], dadosFabricantes[3], dadosFabricantes[4], dadosFabricantes[5],dadosFabricantes[6], dadosFabricantes[7]);
				d.inserirEditarFabricantes(f, Integer.parseInt(dadosFabricantes[0]));
				return true;
    	 }
		
	}
     
    /**
     * Insere novos produtos
     * @param dadosProdutos  dados dos produtos recebidos da view
     * @param i  index do fabricante selecionado pra o cadastro do produto
     * @return boolean
     */
     public boolean inserirProdutos(String[] dadosProdutos, int i) {
    
              Produto p = new Produto(dadosProdutos[1], Integer.parseInt(dadosProdutos[2]), dadosProdutos[3], Integer.parseInt(dadosProdutos[4]), d.getFabricantes()[i]);
			  d.inserirEditarProdutos(p, Integer.parseInt(dadosProdutos[0]));
			  return true;
	      
	
	}
	
     /**
      * Insere novas vendas 
      * @param dadosVendas  dados das vendas recebidos da view
      * @param i  index do cliente selecionado para o cadastro dessa venda
      * @param q  index do produto selecionado para essa venda
      * @return boolean
      */
     public boolean inserirVendas(String[] dadosVendas, int i, int q) {
	    
        Venda v = new Venda(dadosVendas[1], Integer.parseInt(dadosVendas[2]), Integer.parseInt(dadosVendas[3]), Integer.parseInt(dadosVendas[4]), Integer.parseInt(dadosVendas[5]), d.getClientes()[i], d.getProdutos()[q]);
		  d.inserirEditarVendas(v, Integer.parseInt(dadosVendas[0]));
		  return true;
    

    }
	
	
	/**
	 * Remove um Cliente caso esse não esteja vinculado a uma venda cadastrado
	 * @param i  posição do cliente a ser removido
	 * @return boolean
	 */
	public boolean removerCliente(int i) {
		int qtdVends = d.getQtdVendas();
		String ClienteRemovido = d.getClientes()[i].getNome();
		String aux;
		
		for (int j = 0; j < qtdVends; j++) {//Verifica se o cliente esta vinculado a uma venda
			aux = d.getVendas()[j].getClienteVenda().getNome();
			if(ClienteRemovido.compareTo(aux) == 0) 
				return false;
			
		}
		if(i == (d.getQtdClientes() - 1)) { // O cliente a ser removido está no final do array
			d.setQtdClientes(d.getQtdClientes() - 1);
			d.getClientes()[d.getQtdClientes()] = null;
			return true;
		} else { // o cliente a ser removido está no meio do array
			int cont = 0;
			while(d.getClientes()[cont].getNome().compareTo(ClienteRemovido) != 0) {
				cont++;
			}
			
			for(int j = cont; j < d.getQtdClientes() - 1; j++) {
				d.getClientes()[j] = null;
				d.getClientes()[j] = d.getClientes()[j+1];
			}
			d.getClientes()[d.getQtdClientes()] = null;
			d.setQtdClientes(d.getQtdClientes() - 1);
			return true;
		}
	}
	
	/**
	 * Remove um Fabricante caso esse não esteja vinculado a um produto cadastrado
	 * @param i  posição do fabricante a ser removido
	 * @return boolean
	 */
	public boolean removerFabricantes(int i) {
		int qtdProds = d.getQtdProdutos();
		String FabrRemovido = d.getFabricantes()[i].getNome();
		String aux;
		
		for (int j = 0; j < qtdProds; j++) {//Verifica se o fabricante esta vinculado a um produto cadastrado
			aux = d.getProdutos()[j].getFabricanteProd().getNome();
			if(FabrRemovido.compareTo(aux) == 0) 
				return false;
			
		}
		if(i == (d.getQtdFabricantes() - 1)) { // O Fabricante ser removido está no final do array
			d.setQtdFabricantes(d.getQtdFabricantes() - 1);
			d.getFabricantes()[d.getQtdFabricantes()] = null;
			return true;
		} else { // O Fabricante a ser removido está no meio do array
			int cont = 0;
			while(d.getFabricantes()[cont].getNome().compareTo(FabrRemovido) != 0)
				cont++;
			
			for(int j = cont; j < d.getQtdFabricantes() - 1; j++) {
				d.getFabricantes()[j] = null;
				d.getFabricantes()[j] = d.getFabricantes()[j+1];
			}
			d.getFabricantes()[d.getQtdFabricantes()] = null;
			d.setQtdFabricantes(d.getQtdFabricantes() - 1);
			return true;
		}
	}
	
	/**
	 * Remove um Produto caso esse não esteja vinculado a uma venda cadastrada
	 * @param i  posição do produto a ser removido
	 * @return boolean
	 */
	
	public boolean removerProduto(int i) {
		int qtdVends = d.getQtdVendas();
		String ProdutoRemovido = d.getProdutos()[i].getNome();
		String aux;
		
		for (int j = 0; j < qtdVends; j++) {//Verifica se o Produto esta vinculado a uma venda
			aux = d.getVendas()[j].getProdVenda().getNome();
			if(ProdutoRemovido.compareTo(aux) == 0) 
				return false;
			
		}
		if(i == (d.getQtdProdutos() - 1)) { // O produto a ser removido está no final do array
			d.setQtdProds(d.getQtdProdutos() - 1);
			d.getProdutos()[d.getQtdProdutos()] = null;
			return true;
		} else { // o produto a ser removido está no meio do array
			int cont = 0;
			while(d.getProdutos()[cont].getNome().compareTo(ProdutoRemovido) != 0) {
				cont++;
			}
			
			for(int j = cont; j < d.getQtdProdutos() - 1; j++) {
				d.getProdutos()[j] = null;
				d.getProdutos()[j] = d.getProdutos()[j+1];
			}
			d.getProdutos()[d.getQtdProdutos()] = null;
			d.setQtdProds(d.getQtdProdutos() - 1);
			return true;
		}
	}
	
	/**
	 * Remove uma venda
	 * @param i  posição da venda a ser removida
	 * @return boolean
	 */
	
	public boolean removerVenda(int i) {
		String ProdutoRemovido = d.getVendas()[i].getIdentif();
		
		if(i == (d.getQtdVendas() - 1)) { // A venda a ser removido está no final do array
			d.setQtdVendas(d.getQtdVendas() - 1);
			d.getVendas()[d.getQtdVendas()] = null;
			return true;
		} else { // A venda a ser removido está no meio do array
			int cont = 0;
			while(d.getVendas()[cont].getIdentif().compareTo(ProdutoRemovido) != 0) {
				cont++;
			}
			
			for(int j = cont; j < d.getQtdVendas() - 1; j++) {
				d.getVendas()[j] = null;
				d.getVendas()[j] = d.getVendas()[j+1];
			}
			d.getVendas()[d.getQtdVendas()] = null;
			d.setQtdVendas(d.getQtdVendas() - 1);
			return true;
		}
	}
	
	
}
