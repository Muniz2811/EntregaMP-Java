package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controle.*;

/**
 * Classe TelaMenu, define e exibe o menu principal do programa
 * @author Pedro Henrique Muniz de Oliveira
 * @since 2022
 * @version 1.0
 */

public class TelaMenu implements ActionListener {
        
	
	private static JFrame janela = new JFrame("App Controle de vendas");
	private static JLabel titulo = new JLabel("Menu");
	private static JButton cliente = new JButton("Clientes");
	private static JButton fabricante = new JButton("Fabricante");
	private static JButton produto = new JButton("Produtos");
	private static JButton venda = new JButton("Vendas");
	
	public static ControleDados dados = new ControleDados();
	
	/**
	 * Especifica as medidas dos itens presentes no menu
	 */
	public TelaMenu() {
		
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(250, 10, 150, 30);
		fabricante.setBounds(10, 50, 100, 30);
		cliente.setBounds(10, 100, 100, 30);
        venda.setBounds(10, 200, 100, 30);
        produto.setBounds(10, 150, 100, 30);
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(fabricante);
		janela.add(cliente);
		janela.add(produto);
		janela.add(venda);
		
		janela.setSize(600, 350);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
		}
	
	/**
	 * Exibe o menu na tela
	 * @param args
	 */
	public static void main(String[] args) {
		TelaMenu menu = new TelaMenu();
		
		fabricante.addActionListener(menu);
	    cliente.addActionListener(menu);
		produto.addActionListener(menu);
		venda.addActionListener(menu);
	}
	
	/**
	 * Recebe a interação com os botões do menu e decide o que fazer
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == fabricante)
			new TelaPessoa().mostrarDados(dados, 1);
		
		if(src == cliente)
			new TelaPessoa().mostrarDados(dados, 2);
		
		if(src == produto)
			new TelaProduto().mostrarProdutos(dados, 2);
		
		if(src == venda)
			new TelaVenda().principalVendas(dados, 2);
	}
	
	
}
