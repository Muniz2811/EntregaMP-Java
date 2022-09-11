package controle;
import modelo.*;

/**
 * Classe ControleVenda controla a classe Venda
 * @author Pedro Henrique Muniz de Oliveira
 * @since 2022
 * @version 1.0
 */

public class ControleVenda {
	private Venda[] v;
    private int qtdVendas;
    
    
    /**
     * Obtem as vendas e a quantidade de vendas
     * @param d controle de dados
     */
    public ControleVenda(ControleDados d) {
     	v = d.getVendas();
     	qtdVendas = d.getQtdVendas();
     }
    
    public String[] getIDvendas() {
     	String[] s = new String[qtdVendas];
     	for(int i = 0; i<qtdVendas; i++) {
     		    s[i] = v[i].getIdentif();
     	}
     	
     	return s;
     }
    
    public int getQtd() {
      	return qtdVendas;
      }
      
      public void setQtd(int qtd) {
      	this.qtdVendas = qtd;
      }
	  
      

       
       public String getIdentif(int i) {
       	return v[i].getIdentif();
       }
       
       
       public int getDia(int i) {
       	return v[i].getDia();
       }
       
       
       public int getMes(int i) {
          	return v[i].getMes();
       }
       
       
       public int getAno(int i) {
          	return v[i].getAno();
       }
       
       
       public int getVT(int i) {
          	return v[i].getVT();
       }
       
     
       public Cliente getClienteVenda(int i) {
          	return v[i].getClienteVenda();
       }
       
       public Produto getProdutoVenda(int i) {
         	return v[i].getProdVenda();
       }
    
}
