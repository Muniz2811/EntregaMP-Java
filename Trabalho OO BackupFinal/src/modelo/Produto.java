package modelo;
/**
* Classe Produto 
* @author Pedro Henrique Muniz de Oliveira
* @since 2022
* @version 1.0
*/


public class Produto {
      private String nome;
      private int valor_custo;
      private String categoria;
      private int valor_venda;
      private Fabricante fabr;
      
      
      
      public Produto(String nome, int valor_custo, String categoria, int valor_venda, Fabricante fabr) {
    	  
    	  this.nome = nome;
    	  this.valor_custo = valor_custo; 
    	  this.categoria = categoria;
    	  this.valor_venda = valor_venda; 
    	  this.fabr = fabr;
      }
      
      /**
       * Sobrescreve o metodo ToString() da classe Object. Constrói uma String contendo a variavel nome da classe Produto
       * @return String
       */
      public String toString() {
      	return "Nome do Produto: " + nome;
      }
      
      public String getNome() {
    	  return nome;
      }
      public void setNome(String nome) {
    	  this.nome = nome;
      }
      
      public int getVC() {
    	  return valor_custo;
      }
      public void setVC(int valor_custo) {
    	  this.valor_custo = valor_custo;
      }
      
      public String getCat() {
    	  return categoria;
      }
      public void setCat(String categoria) {
    	  this.categoria = categoria;
      }
      
      public int getVV() {
    	  return valor_venda;
      }
      public void setVV(int valor_venda) {
    	  this.valor_venda = valor_venda;
      }
      
      public Fabricante getFabricanteProd() {
    	  return fabr;
      }
      
      public void setFabricanteProd(Fabricante fabr) {
    	  this.fabr = fabr;
      }
      
      
      
}
