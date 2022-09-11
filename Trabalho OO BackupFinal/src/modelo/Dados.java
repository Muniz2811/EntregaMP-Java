package modelo;
/**
 * Classe Dados armazena todos os objetos em arrays com as instâncias de clientes, fabricantes, produtos e vendas
 * @author Pedro Henrique Muniz de Oliveira
 * @since 2022
 * @version 1.0
 */

public class Dados {
	private   Cliente[] clientes = new Cliente[50];
	private int qtdClientes = 0;
	private Fabricante[] fabricantes = new Fabricante[50];
	private int qtdFabricantes = 0;
	private Produto[] produtos = new Produto[50];
	private int qtdProds = 0;
	private Venda[] vendas = new Venda[50];
	private int qtdVendas = 0;
	
         
         /**
          * Preenche com dados aleatórios o software
          */
         public void PreencheDados() {
        	 clientes[0] = new Cliente("Cliente 0", "00000000000", "Endereço cliente 0","Email cliente 0", "00000000000", "Forma pag cliente 0", "0000000");
        	 clientes[1] = new Cliente("Cliente 1", "11111111111", "Endereço cliente 1","Email cliente 1", "11111111111", "Forma pag cliente 1", "1111111");
        	 clientes[2] = new Cliente("Cliente 2", "22222222222", "Endereço cliente 2","Email cliente 2", "22222222222", "Forma pag cliente 2", "2222222");
        	 clientes[3] = new Cliente("Cliente 3", "33333333333", "Endereço cliente 3","Email cliente 3", "33333333333", "Forma pag cliente 3", "3333333");
        	 clientes[4] = new Cliente("Cliente 4", "44444444444", "Endereço cliente 4","Email cliente 4", "44444444444", "Forma pag cliente 4", "4444444");
        	 clientes[5] = new Cliente("Cliente 5", "55555555555", "Endereço cliente 5","Email cliente 5", "55555555555", "Forma pag cliente 5", "5555555");
        	 clientes[6] = new Cliente("Cliente 6", "66666666666", "Endereço cliente 6","Email cliente 6", "66666666666", "Forma pag cliente 6", "6666666");
        	 clientes[7] = new Cliente("Cliente 7", "77777777777", "Endereço cliente 7","Email cliente 7", "77777777777", "Forma pag cliente 7", "7777777");
        	 clientes[8] = new Cliente("Cliente 8", "88888888888", "Endereço cliente 8","Email cliente 8", "88888888888", "Forma pag cliente 8", "8888888");
        	 clientes[9] = new Cliente("Cliente 9", "99999999999", "Endereço cliente 9","Email cliente 9", "99999999999", "Forma pag cliente 9", "9999999");
        	 
        	 fabricantes[0] = new Fabricante("Fabricante 0", "00000000000", "Endereço fabricante 0","Email fabricante 0", "Razao social fabricante 0", "00000000000000", "Contato fabricante 0");
        	 fabricantes[1] = new Fabricante("Fabricante 1", "11111111111", "Endereço fabricante 1","Email fabricante 1", "Razao social fabricante 1", "11111111111111", "Contato fabricante 1");
        	 fabricantes[2] = new Fabricante("Fabricante 2", "22222222222", "Endereço fabricante 2","Email fabricante 2", "Razao social fabricante 2", "22222222222222", "Contato fabricante 2");
        	 fabricantes[3] = new Fabricante("Fabricante 3", "33333333333", "Endereço fabricante 3","Email fabricante 3", "Razao social fabricante 3", "33333333333333", "Contato fabricante 3");
        	 fabricantes[4] = new Fabricante("Fabricante 4", "44444444444", "Endereço fabricante 4","Email fabricante 4", "Razao social fabricante 4", "44444444444444", "Contato fabricante 4");
        	 fabricantes[5] = new Fabricante("Fabricante 5", "55555555555", "Endereço fabricante 5","Email fabricante 5", "Razao social fabricante 5", "55555555555555", "Contato fabricante 5");
        	 fabricantes[6] = new Fabricante("Fabricante 6", "66666666666", "Endereço fabricante 6","Email fabricante 6", "Razao social fabricante 6", "66666666666666", "Contato fabricante 6");
        	 fabricantes[7] = new Fabricante("Fabricante 7", "77777777777", "Endereço fabricante 7","Email fabricante 7", "Razao social fabricante 7", "77777777777777", "Contato fabricante 7");
        	 fabricantes[8] = new Fabricante("Fabricante 8", "88888888888", "Endereço fabricante 8","Email fabricante 8", "Razao social fabricante 8", "88888888888888", "Contato fabricante 8");
        	 fabricantes[9] = new Fabricante("Fabricante 9", "99999999999", "Endereço fabricante 9","Email fabricante 9", "Razao social fabricante 9", "99999999999999", "Contato fabricante 9");
        	 
     		for(int i = 0; i < 10; i++){
    
     			produtos[i] = new Produto("Produto"+i, i*10, "Categoria"+i,i*20, fabricantes[i]);
     			vendas[i] = new Venda("Venda "+i, i+1, i+2,i+3, (i+10)*30, clientes[i], produtos[i]);	
     		}
     		qtdClientes = 10;
     		qtdFabricantes = 10;
     		qtdProds = 10;
     		qtdVendas = 10;
     	}
         
        
        public Cliente[] getClientes() {
        	return clientes;
        }
        
        public void setClientes(Cliente[] clientes) {
        	this.clientes = clientes;
        }
        
        public int getQtdClientes() {
    		return qtdClientes;
    	}
    	public void setQtdClientes(int qtdClientes) {
    		this.qtdClientes = qtdClientes;
    	}
    	
    	/**
    	 * Aumenta a quantidade de clientes caso um novo cliente seja cadastrado
    	 * @param c
    	 * @param pos
    	 */
    	public void inserirEditarCliente(Cliente c, int pos) {
    		this.clientes[pos] = c;
    		if(pos == qtdClientes) qtdClientes++;
    	}
    	
    	
    	
        
        public Fabricante[] getFabricantes() {
        	return fabricantes;
        }
        
        public void setFabricantes(Fabricante[] fabricantes) {
        	this.fabricantes= fabricantes;
        }
        
        public int getQtdFabricantes() {
    		return qtdFabricantes;
    	}
    	public void setQtdFabricantes(int qtdFabricantes) {
    		this.qtdFabricantes = qtdFabricantes;
    	}
    	
    	/**
    	 * Aumenta a quantidade de fabricantes caso um novo fabricante seja cadastrado
    	 * @param c
    	 * @param pos
    	 */
    	public void inserirEditarFabricantes(Fabricante f, int pos) {
    		this.fabricantes[pos] = f;
    		if(pos == qtdFabricantes) qtdFabricantes++;
    	}
    	
    	
    	
    	
        
        public Produto[] getProdutos() {
        	return produtos;
        }
        
        public void setProdutos(Produto[] produtos) {
        	this.produtos = produtos;
        }
        
        public int getQtdProdutos() {
    		return qtdProds;
    	}
    	public void setQtdProds(int qtdProds) {
    		this.qtdProds = qtdProds;
    	}
    	
    	/**
    	 * Aumenta a quantidade de produtos caso um novo produto seja cadastrado
    	 * @param c
    	 * @param pos
    	 */
    	public void inserirEditarProdutos(Produto p, int pos) {
    		this.produtos[pos] = p;
    		if(pos == qtdProds) qtdProds++;
    	}
    	
    	
    	
        
        public Venda[] getVendas() {
        	return vendas;
        }
        
        public void setVendas(Venda[] vendas) {
        	this.vendas = vendas;
        }
        
        public int getQtdVendas() {
    		return qtdVendas;
    	}
    	public void setQtdVendas(int qtdVendas) {
    		this.qtdVendas = qtdVendas;
    	}
    	
    	/**
    	 * Aumenta a quantidade de vendas caso uma nova venda seja cadastrada
    	 * @param c
    	 * @param pos
    	 */
    	public void inserirEditarVendas(Venda v, int pos) {
    		this.vendas[pos] = v;
    		if(pos == qtdVendas) qtdVendas++;
    	}
         
    	
        

}
