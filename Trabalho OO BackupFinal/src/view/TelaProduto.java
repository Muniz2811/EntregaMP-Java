package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



import controle.*;

/**
 * Classe TelaProduto, define e exibe a tela caso seja selecionado a opção produto no menu principal
 * @author Pedro Henrique Muniz de Oliveira
 * @since 2022
 * @version 1.0
 */

public class TelaProduto implements ActionListener{
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroProduto;
	private JButton BuscaProduto;
	private JTextField valorBusca;
	private static ControleDados dados;
	
	/**
	 * Especifica os limites dos itens presentes na TelaProduto
	 * @param d controle de dados
	 * @param op opção 
	 */
	
	public void mostrarProdutos(ControleDados d, int op) {
		dados = d;
		
		
		janela = new JFrame("Produtos");
		titulo = new JLabel("Buscar Produto");
		cadastroProduto = new JButton("Cadastrar");
		BuscaProduto = new JButton("Buscar");

		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(115, 10, 250, 30);
		
		
		valorBusca = new JTextField(200);
		valorBusca.setBounds(100, 80, 180, 25);
		cadastroProduto.setBounds(70, 177, 100, 30);
		BuscaProduto.setBounds(200, 177, 100, 30);

		janela.setLayout(null);

		janela.add(titulo);
		
		janela.add(cadastroProduto);
		janela.add(BuscaProduto);
        janela.add(valorBusca);
		janela.setSize(400, 250);
		janela.setVisible(true);

		cadastroProduto.addActionListener(this);
		BuscaProduto.addActionListener(this);
		
	}
	
	/**
	 * Recebe a interação com os botões da TelaProduto e decide o que fazer
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		
		if(src == cadastroProduto)
			new TelaCadastroProduto().inserirProduto(1, dados, this, 0, "");

	
        if(src == BuscaProduto)
        	new TelaCadastroProduto().inserirProduto(2,dados,this,0, valorBusca.getText());
		
	}

	
	
}
