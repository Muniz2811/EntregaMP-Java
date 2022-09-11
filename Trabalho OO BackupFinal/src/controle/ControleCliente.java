package controle;
import modelo.*;

/**
 * Classe ControleCliente controla a classe Cliente
 * @author Pedro Henrique Muniz de Oliveira
 * @since 2022
 * @version 1.0
 */

public class ControleCliente{
        private  Cliente[] c;
        private int qtdClientes;
        
        
        /**
         * Obtem os clientes e a quantidade de clientes
         * @param d controle de dados
         */
        public ControleCliente(ControleDados d) {
        	c = d.getClientes();
        	qtdClientes = d.getQtdClientes();
        }
        
        public String[] getNomeCliente() {
        	String[] s = new String[qtdClientes];
        	for(int i = 0; i<qtdClientes; i++) {
        		    s[i] = c[i].getNome();
        	}
        	
        	return s;
        }
        
        public int getQtd() {
        	return qtdClientes;
        }
        
        public void setQtd(int qtd){
        	this.qtdClientes = qtd;
        }
        
        public String getNome(int i) {
        	return c[i].getNome();
        }
        
        public String getCPF(int i) {
        	return c[i].getCpf();
        	
        }
        
        public String getTel(int i) {
        	return c[i].getTelefone();
        }
        
        public String getEnd(int i) {
        	return c[i].getEndereco();
        }
        
        public void setQtdClientes(int qtdClientes) {
        	this.qtdClientes = qtdClientes;
        }
        
        public String getEMAIL(int i) {
        	return c[i].getEmail();
        }
        
        public String getFormPag(int i) {
        	return c[i].getFormaPag();
        }
        
        public String getRg(int i) {
        	return c[i].getRG();
        }
        
        
  
}
