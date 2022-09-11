package controle;
import modelo.*;

/**
 * Classe ControleProduto controla a classe Fabricante
 * @author Pedro Henrique Muniz de Oliveira
 * @since 2022
 * @version 1.0
 */

public class ControleProduto {
	private Produto[] p;
    private int qtdProdutos;
    
    
    /**
     * Obtem os produtos e a quantidade de produtos
     * @param d controle de dados
     */
    public ControleProduto(ControleDados d) {
     	p = d.getProdutos();
     	qtdProdutos = d.getQtdProds();
     }
     
     public String[] getNomeProdutos() {
     	String[] s = new String[qtdProdutos];
     	for(int i = 0; i<qtdProdutos; i++) {
     		    s[i] = p[i].getNome();
     	}
     	
     	return s;
     }
	
     public int getQtd() {
      	return qtdProdutos;
      }
      
      public void setQtd(int qtd) {
      	this.qtdProdutos = qtd;
      }
	  
      

       
       public String getNome(int i) {
       	return p[i].getNome();
       }
       
       
       public int getVC(int i) {
       	return p[i].getVC();
       }
       
       public String getCategoria(int i) {
       	return p[i].getCat();
       }
	    
       
       public int getVV(int i) {
          	return p[i].getVV();
       }
       
       public Fabricante getFabricante(int i) {
          	return p[i].getFabricanteProd();
          }
	
	
	
	

}
