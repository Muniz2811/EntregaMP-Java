package modelo;
/**
 * Classe Venda
 * @author Pedro Henrique Muniz de Oliveira
 * @since 2022
 * @version 1.0
 */


public class Venda {
      private String Identificador;
      private int dia;
      private int mes;
      private int ano;
      private int valor_total;
      private Cliente clnt;
      private Produto prod;
      
      
     
      public Venda(String ID, int d, int m, int a, int vt, Cliente cl, Produto p) {
    	  this.Identificador = ID;
    	  this.dia= d;
    	  this.mes = m;
    	  this.ano = a;
    	  this.valor_total = vt;
    	  this.clnt = cl;
    	  this.prod = p;
    	  
      }
      
      
      /**
       * Sobrescreve o metodo ToString() da classe Object. Constrói uma String contendo a variavel Identificador da classe Venda
       * @return String
       */
      public String toString() {
        	return "ID:" + Identificador;
        }
      
      public String getIdentif() {
    	  return Identificador;
      }
      
      public void setIdentif(String Identificador) {
    	  this.Identificador = Identificador;
      }
      
      public int getDia() {
    	  return dia;
      }
      
      public void setDia(int dia) {
    	  this.dia = dia;
      }
      
      public int getMes() {
    	  return mes;
      }
      
      public void setMes(int mes) {
    	  this.mes = mes;
      }
      
      public int getAno() {
    	  return ano;
      }
      
      public void setAno(int ano) {
    	  this.ano = ano;
      }
      
      public int getVT() {
    	  return valor_total;
      }
      
      public void setVT(int valor_total) {
    	  this.valor_total = valor_total;
      }
      
      public Cliente getClienteVenda() {
    	  return clnt;
      }
      
      public void setClienteVenda(Cliente clnt) {
    	  this.clnt = clnt;
      }
      
      public Produto getProdVenda() {
    	  return prod;
      }
      
      public void setProdVenda(Produto prod) {
    	  this.prod = prod;
      }
      
      
}
