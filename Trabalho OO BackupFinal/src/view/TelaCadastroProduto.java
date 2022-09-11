package view;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controle.*;

/**
 * Classe TelaCadastro, define e exibe ou o resultado da busca ou a tela de cadastro de novo produto
 * @author Pedro Henrique Muniz de Oliveira
 * @since 2022
 * @version 1.0
 */


public class TelaCadastroProduto  implements ActionListener,  ListSelectionListener{
	private JFrame janela;
	private JLabel labelNome = new JLabel("Nome do Produto: ");
	private JTextField valorNome;
	private JLabel labelVC= new JLabel("Valor de custo: ");
	private JTextField valorVC;
	private JLabel labelCat = new JLabel("Categoria: ");
	private JTextField valorCat;
	private JLabel labelVV = new JLabel("Valor de venda: ");
	private JLabel labelFabricante = new JLabel("Escolha um fabricante abaixo:");
	private JTextField valorVV;
	
	private JLabel labelNomeFim;
	private JLabel labelVCfim;
	private JLabel labelCatfim;
	private JLabel labelVVfim;
	private JLabel labelNomeFabr;
	private JLabel titulo;
	
	
	private JList<String> listaFabricantesCadastrados;
	private String[] listaNomes = new String[50];
	private JScrollPane scroll; 
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private String[] novoDado = new String[9];
	private static ControleDados dados;
	private int posicao;
	private int opcao;
	private String s;
	private String BuscarFim;
	
	/**
	 * Recebe a escolha de busca ou cadastro e define os limites dos itens para cada escolha
	 * @param op opção
	 * @param d controle de dados
	 * @param v TelaProduto
	 * @param pos posição
	 * @param Busca Cliente buscado
	 */
	public void inserirProduto(int op, ControleDados d, TelaProduto v, int pos, String Busca) {
		opcao = op;
		posicao = pos;
		dados = d;
		BuscarFim = Busca;
	    
		//Preenche a lista de Fabricantes
		listaNomes = new ControleFabricante(dados).getNomeFabricante();
		listaFabricantesCadastrados = new JList<String>(listaNomes);
		
		if (op == 1) s = "Cadastro de Produto";
		if (op == 2) s = "Busca de produto";
		
		janela = new JFrame(s);
		
		
		    listaFabricantesCadastrados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scroll = new JScrollPane(listaFabricantesCadastrados);
			scroll.setBounds(20, 200, 350,120); 
		    valorNome = new JTextField(200);
		    valorVC = new JTextField(200);
		    valorCat = new JTextField(200);
		    valorVV = new JTextField(200);
		  
		
		
		if(op == 2) {//Faz a busca dos produtos pelo nome
			for(int i =0; i<dados.getQtdProds();i++) {
				
				if(BuscarFim.equals(dados.getProdutos()[i].getNome())) {//Caso encontre  um nome igual ao buscado retorna os dados desse produto
					valorNome = new JTextField(200);
					valorVC = new JTextField(200);
					valorCat = new JTextField(200);
					valorVV = new JTextField(200);
					labelNomeFim = new JLabel("Nome: " + dados.getProdutos()[i].getNome());
					labelVCfim = new JLabel("Valor de custo: " + dados.getProdutos()[i].getVC());
					labelCatfim = new JLabel("Categoria: " + dados.getProdutos()[i].getCat());
					labelVVfim = new JLabel("Valor de venda: " + dados.getProdutos()[i].getVV());
					labelNomeFabr = new JLabel("Fabricante: " + dados.getProdutos()[i].getFabricanteProd().getNome());
					titulo = new JLabel("Produto Encontrado");
					labelNomeFim.setBounds(30, 20, 300, 25);
					
					labelVCfim.setBounds(30, 50, 300, 25);
					
					labelCatfim.setBounds(30, 80, 300, 25);
					
					labelVVfim.setBounds(30, 110, 300, 25);
					
					labelNomeFabr.setBounds(30, 140, 300, 25);
					this.janela.add(labelNomeFim);
					this.janela.add(labelVCfim);
					this.janela.add(labelCatfim);
					this.janela.add(labelVVfim);
					this.janela.add(labelNomeFabr);
					this.janela.add(botaoExcluir);
					
					break;
					
				}else {//Caso não encontre  um nome igual ao buscado retorna produto nao encontrado
					titulo = new JLabel("Produto Não encontrado");
					
				}
			
			}
			
			
				
				
				valorNome = new JTextField(200);
				valorVC = new JTextField(200);
				valorCat = new JTextField(200);
				valorVV = new JTextField(200);
				
				
				titulo.setFont(new Font("Arial", Font.BOLD, 20));
				titulo.setBounds(200, 5, 250, 30);
				this.janela.add(titulo);
			
			
			
		}else {//Caso não seja uma busca simplesmente adiciona os campos para cadastro de novo produto
			this.janela.add(labelFabricante);
			this.janela.add(scroll);
			this.janela.add(labelNome);
			this.janela.add(valorNome);
			this.janela.add(labelVC);
			this.janela.add(valorVC);
			this.janela.add(labelCat);
			this.janela.add(valorCat);
			this.janela.add(labelVV);
			this.janela.add(valorVV);
			this.janela.add(botaoSalvar);
		}
		
		
		//Estabelece os limites dos campos de cadastro de produto
		labelNome.setBounds(30, 20, 150, 25);
		valorNome.setBounds(180, 20, 180, 25);
		
		labelVC.setBounds(30, 50, 150, 25);
		valorVC.setBounds(180, 50, 180, 25);
		
		labelCat.setBounds(30, 80, 150, 25);
		valorCat.setBounds(180, 80, 180, 25);
		
		labelVV.setBounds(30, 110, 180, 25);
		valorVV.setBounds(180, 110, 180, 25);
		
		labelFabricante.setBounds(20,180, 180,25);
		
		
        
		botaoSalvar.setBounds(120, 350, 115, 30);
		botaoExcluir.setBounds(245, 350, 115, 30);
		
		
		//Dados da janela
		this.janela.setLayout(null);
        this.janela.setSize(600, 450);
		this.janela.setVisible(true);
         
		
		//Adiciona o reconhecimento de interações com botões e listas
		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
		listaFabricantesCadastrados.addListSelectionListener(this);
	}
	
	/**
	 * Recebe as interações com os botões da TelaCadastroProduto
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == botaoSalvar) {
			try {
				boolean res;
				if(opcao == 1) //cadastro de novo Produto
					
				 
				novoDado[0] = Integer.toString(dados.getQtdProds());

				novoDado[1] =  valorNome.getText();
				novoDado[2] =  valorVC.getText();
				novoDado[3] =  valorCat.getText();
				novoDado[4] =  valorVV.getText();
				
				
				res = dados.inserirProdutos(novoDado, listaFabricantesCadastrados.getSelectedIndex());


				if(res) {
					mensagemSucessoCadastro();
				}
				else mensagemErroCadastro();

			} catch (NullPointerException exc1) {
				mensagemErroCadastro();
			} catch (NumberFormatException exc2) {
				mensagemErroCadastro();
			}
		}

		if(src == botaoExcluir) {//Exclui o produto
			boolean res = false;
				res = dados.removerProduto(posicao);
				if (res) mensagemSucessoExclusao(); 
				else mensagemErroExclusaoProduto(); 
			
				
		}
	}
	
	/**
	 * Recebe a interação com a lista de fabricantes na tela de cadastro
	 */
	public void valueChanged(ListSelectionEvent e) {
		
			listaFabricantesCadastrados.getSelectedIndex();
		
	}
	
	/**
	 * Exibe a mensagem de sucesso caso seja efetivada exclusão de algum dado
	 */
	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
     
	/**
	 * Exibe a mensagem sucesso caso seja efetivado o cadastro de algum dado
	 */
	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
    
	/**
     * Exibe a menagem de erro caso haja algum problema no cadastro de dados
     */
	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS", null, 
				JOptionPane.ERROR_MESSAGE);
	}
    
	/**
     * Exibe a mensagem de erro caso haja algum problema na exclusao de um produto
     */
	public void mensagemErroExclusaoProduto() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado, verifique se esse produto não está vinculado a uma venda cadastrada", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	
	
	
}
