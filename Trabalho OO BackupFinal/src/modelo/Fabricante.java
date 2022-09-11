package modelo;
/**
 * Classe Fabricante herda de Pessoa
 * @author Pedro Henrique Muniz de Oliveira
 * @since 2022
 * @version 1.0
 */

public class Fabricante extends Pessoa {
       private String razao_social;
       private String cnpj;
       private String contato;
       
       
      
       
       public Fabricante(String nome, String telefone, String endereco, String email, String razao_social, String cnpj, String contato) {
    	   super(nome, telefone, endereco, email);
    	   this.razao_social = razao_social;
    	   this.cnpj = cnpj;
    	   this.contato = contato;
    	 
    	   
       }
       
       /**
        * Sobrescreve o metodo ToString() da classe Object. Constrói uma String contendo a variavel nome da classe fabricante
        * @return String
        */
       public String toString() {
       	return "Nome do fabricante" + nome;
       }
       
       
       public String getRZ() {
    	   return razao_social;
       }
       
       public void setRZ(String razao_social) {
    	    this.razao_social = razao_social;
       }
       
       public String getCN() {
    	   return cnpj;
       }
       
       public void setCN(String cnpj) {
    	    this.cnpj = cnpj;
       }
       
       public String getCONT() {
    	   return contato;
       }
       
       public void setCONT(String contato) {
    	    this.contato = contato;
       }
       
     
       
}
