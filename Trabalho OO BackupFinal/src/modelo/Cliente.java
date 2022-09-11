package modelo;
/**
* Classe Cliente herda de Pessoa
* @author Pedro Henrique Muniz de Oliveira
* @since 2022
* @version 1.0
*/


public class Cliente extends Pessoa {
        private String cpf;
        private String forma_pagamento;
        private String rg;
        
        
        
        public Cliente(String nome, String telefone, String endereco, String email, String cpf, String forma_pagamento, String rg) {
        	super(nome, telefone,endereco, email);
        	this.cpf = cpf;
        	this.forma_pagamento = forma_pagamento;
        	this.rg = rg;
        }
        
        /**
         * Sobrescreve o metodo ToString() da classe Object. Constrói uma String contendo a variavel nome da classe cliente
         * @return String
         */
        public String toString() {
        	return "Nome do cliente: " + nome;
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
        
        public String getCpf() {
        	return cpf;
        }
        
        public void setCpf(String cpf) {
        	this.cpf = cpf;
        }
        
        public String getFormaPag() {
        	return forma_pagamento;
        }
        
        public void setFormaPag(String forma_pagamento) {
        	this.forma_pagamento = forma_pagamento;
        }
        
        public String getRG() {
        	return rg;
        }
        
        public void setRG(String rg) {
        	this.rg = rg;
        }
        
        
        
        

}
