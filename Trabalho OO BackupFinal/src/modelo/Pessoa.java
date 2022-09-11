package modelo;
/**
 * Classe Cliente herda de Pessoa
 * @author Pedro Henrique Muniz de Oliveira
 * @since 2022
 * @version 1.0
 */



public abstract class Pessoa{
         protected String nome;
         protected String telefone;
         protected String endereco;
         protected String email;
         
         
         
         public Pessoa(String nome, String telefone, String endereco, String email) {
     		super();
     		this.nome = nome;
     		this.telefone = telefone;
     		this.endereco = endereco;
     		this.email  = email;
     	}
         
         
         
         public String getNome() {
        	 return nome;
         }
         
         public void setNome(String nome) {
        	     this.nome = nome;
         }
         
         public String getTelefone() {
        	 return telefone;
         }
         
         public void setTelefone(String telefone) {
        	      this.telefone = telefone;
         }
         
         public String getEndereco() {
        	 return endereco;
         }
         
         public void setEndereco(String endereco) {
        	      this.endereco = endereco;
         }
         
         public String getEmail() {
        	 return email;
         }
         
         public void setEmail(String email) {
        	      this.email = email;
         }
        

}
