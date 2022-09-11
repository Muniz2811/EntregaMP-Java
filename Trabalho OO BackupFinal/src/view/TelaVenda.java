package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import controle.*;

/**
 * Classe TelaVenda, define e exibe a tela caso seja selecionado a opção venda no menu principal
 * @author Pedro Henrique Muniz de Oliveira
 * @since 2022
 * @version 1.0
 */

public class TelaVenda implements ActionListener, ListSelectionListener{
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroVenda;
	private JButton AtualizarVenda;
	private static ControleDados dados;
	
	private JList<String> listaVendasCadastrados;
	private String[] listaID = new String[50];
	
	private JScrollPane scroll;
	
	/**
	 * Define os limites dos itens presentes na TelaVenda
	 * @param d controle de dados
	 * @param op opção
	 */
	public void principalVendas(ControleDados d, int op) {
		dados = d;
		
		//Preenche a lista de vendas
		listaID = new ControleVenda(dados).getIDvendas();
		listaVendasCadastrados = new JList<String>(listaID);
        listaVendasCadastrados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scroll = new JScrollPane(listaVendasCadastrados);
		scroll.setBounds(20, 50, 350,120);
		
		
		//Define os elementos presentes na janela
		janela = new JFrame("Vendas");
		titulo = new JLabel("Vendas");
		cadastroVenda = new JButton("Cadastrar");
		AtualizarVenda = new JButton("Atualizar");
		
		
		//Define os limites dos elementos presentes na janela
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(150, 10, 250, 30);
		cadastroVenda.setBounds(20, 177, 150, 30);
		AtualizarVenda.setBounds(200, 177, 150, 30);
		
		
		//Define os dados da janela e os elementos a serem adicionados nela 
		janela.setLayout(null);
        janela.add(titulo);
		janela.add(cadastroVenda);
		janela.add(AtualizarVenda);
        janela.add(scroll);
        janela.setSize(400, 250);
		janela.setVisible(true);
        
		
		//Adiciona o reconhecimento de interações com botões e listas
		cadastroVenda.addActionListener(this);
		AtualizarVenda.addActionListener(this);
		listaVendasCadastrados.addListSelectionListener(this);
	}
	
	/**
	 * Recebe a interação com os botões da TelaVenda e decide o que fazer
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		
		if(src == cadastroVenda)//Cadastra nova venda 
			new TelaCadastroVenda().inserirVenda(1, dados, this, 0);

	

		
		if(src == AtualizarVenda) {//Atualiza a lista de vendas
			listaVendasCadastrados.setListData(new ControleVenda(dados).getIDvendas());
			listaVendasCadastrados.updateUI();
		}

		
	}
	
	/**
	 * Recebe a interação com a lista de vendas e decide o  que fazer
	 */
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		if(e.getValueIsAdjusting() && src == listaVendasCadastrados) {//Mostra os dados da venda selecionada na lista
			new TelaCadastroVenda().inserirVenda(2, dados, this, listaVendasCadastrados.getSelectedIndex());
		}

		
	}
	
}
