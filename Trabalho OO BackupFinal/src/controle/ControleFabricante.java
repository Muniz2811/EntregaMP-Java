package controle;
import modelo.*;

/**
 * Classe ControleFabricante controla a classe Fabricante
 * @author Pedro Henrique Muniz de Oliveira
 * @since 2022
 * @version 1.0
 */

public class ControleFabricante{
	 private Fabricante[] f;
     private int qtdFabricantes;
     
     
     /**
      * Obtem os fabricantes e a quantidade de fabricantes
      * @param d controle de dados
      */
     public ControleFabricante(ControleDados d) {
     	f = d.getFabricantes();
     	qtdFabricantes = d.getQtdFabricantes();
     }
     
     public String[] getNomeFabricante() {
     	String[] s = new String[qtdFabricantes];
     	for(int i = 0; i<qtdFabricantes; i++) {
     		    s[i] = f[i].getNome();
     	}
     	
     	return s;
     }
     
     public int getQtd() {
     	return qtdFabricantes;
     }
     
     public void setQtd(int qtd) {
     	this.qtdFabricantes = qtd;
     }
     
     public String getNome(int i) {
     	return f[i].getNome();
     }
     
     
     public String getTel(int i) {
     	return f[i].getTelefone();
     }
     
     public String getEnd(int i) {
     	return f[i].getEndereco();
     }
     
     public void setQtdFabricantes(int qtdFabricantes) {
     	this.qtdFabricantes = qtdFabricantes;
     }
     
     public String getEMAIL(int i) {
     	return f[i].getEmail();
     }
     
     public String getRazao_Social(int i) {
     	return f[i].getRZ();
     }
     
     public String getCNPJ(int i) {
     	return f[i].getCN();
     }
	  
     public String getContato(int i) {
      	return f[i].getCONT();
      }
 	   
	 
}
