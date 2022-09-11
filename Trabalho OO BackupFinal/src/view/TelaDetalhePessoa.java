package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controle.*;

/**
 * Classe TelaDetalhePessoa, define e exibe o menu para cadastro ou edição de dados de fabricantes ou clientes
 * @author Pedro Henrique Muniz de Oliveira
 * @since 2022
 * @version 1.0
 */

public class TelaDetalhePessoa  implements ActionListener{
	
	private JFrame janela;
	private JLabel labelNome = new JLabel("Nome: ");
	private JTextField valorNome;
	private JLabel labelTelefone= new JLabel("Telefone: ");
	private JTextField valorTelefone;
	private JLabel labelEnd = new JLabel("Endereco: ");
	private JTextField valorEnd;
	private JLabel labelEmail = new JLabel("E-mail: ");
	private JTextField valorEmail;
	
	
	private JLabel labelRazaoSocial = new JLabel("Razao Social: ");
	private JTextField valorRS;
	private JLabel labelCNPJ = new JLabel("CNPJ: ");
	private JTextField valorCnpj;
	private JLabel labelCont = new JLabel("Contato: ");
	private JTextField valorCont;
	
	
	private JLabel labelCPF = new JLabel("CPF: ");
	private JTextField valorCPF;
	private JLabel labelFormaPag = new JLabel("FormaPag: ");
	private JTextField valorFormaPag;
	private JLabel labelRG = new JLabel("RG: ");
	private JTextField valorRG;
	
	
	
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private String[] novoDado = new String[9];
	private static ControleDados dados;
	private int posicao;
	private int opcao;
	private String s;
	
	/**
	 * Recebe a opção selecionada na tela anterior e define os limites para cada caso, seja edição de dados ou cadastro de novos dados
	 * @param op opção
	 * @param d controle dados
	 * @param p tela pessoa
	 * @param pos posição
	 */
	public void inserirEditar(int op, ControleDados d, TelaPessoa p, int pos) {
		opcao = op;
		posicao = pos;
		dados = d;

		if (op == 1) s = "Cadastro de Cliente";
		if (op == 2) s = "Cadastro de Fabricante";
		if (op == 3) s = "Detalhe de Cliente";
		if (op == 4) s = "Detalhe de Fabricante";

		janela = new JFrame(s);

		
		if (op == 3) {//Preenche os dados do cliente selecionado
			valorNome = new JTextField(dados.getClientes()[pos].getNome(), 200);
			valorTelefone = new JTextField(dados.getClientes()[pos].getTelefone(),200);
			valorEnd = new JTextField(dados.getClientes()[pos].getEndereco(), 200);
			valorEmail = new JTextField(dados.getClientes()[pos].getEmail(), 200);
			
			valorRS = new JTextField(200);
			valorCnpj = new JTextField(200);
			valorCont = new JTextField(200);
			
			valorCPF = new JTextField(dados.getClientes()[pos].getCpf(),200);
			valorFormaPag = new JTextField(dados.getClientes()[pos].getFormaPag(),200);
			valorRG = new JTextField(dados.getClientes()[pos].getRG(),200);

		} else if (op == 4) {//Preenche os dados do fabricante selecionado
			valorNome = new JTextField(dados.getFabricantes()[pos].getNome(), 200);
			valorTelefone = new JTextField(dados.getFabricantes()[pos].getTelefone(),200);
			valorEnd = new JTextField(dados.getFabricantes()[pos].getEndereco(), 200);
			valorEmail = new JTextField(dados.getFabricantes()[pos].getEmail(), 200);
			
			valorCPF = new JTextField(200);;
			valorFormaPag = new JTextField(200);
			valorRG = new JTextField(200);
			
			valorRS = new JTextField(dados.getFabricantes()[pos].getRZ(), 200);
			valorCnpj = new JTextField(dados.getFabricantes()[pos].getCN(), 200);
			valorCont = new JTextField(dados.getFabricantes()[pos].getCONT(), 200);
			
	

		} else {//Apenas define os campos para cadastro

			valorNome = new JTextField(200);
			valorTelefone = new JTextField(200);
			valorEnd = new JTextField(200);
			valorEmail = new JTextField(200);
			
			valorRS = new JTextField(200);
			valorCnpj = new JTextField(200);
			valorCont = new JTextField(200);
			
			valorCPF = new JTextField(200);
			valorFormaPag = new JTextField(200);
			valorRG = new JTextField(200);

			botaoSalvar.setBounds(245, 300, 115, 30);
		}
		
		
        //Definição dos limites do campos relacionados ao cadastro e detalhamento de clientes e fabricantes
		labelNome.setBounds(30, 20, 150, 25);
		valorNome.setBounds(180, 20, 180, 25);
		
		labelTelefone.setBounds(30, 50, 150, 25);
		valorTelefone.setBounds(180, 50, 180, 25);
		
		labelEnd.setBounds(30, 80, 150, 25);
		valorEnd.setBounds(180, 80, 180, 25);
		
		labelEmail.setBounds(30, 110, 180, 25);
		valorEmail.setBounds(180, 110, 180, 25);	
		
		labelCPF.setBounds(30, 140, 150, 25);
		valorCPF.setBounds(180, 140, 180, 25);
		labelFormaPag.setBounds(30, 170, 150, 25);
		valorFormaPag.setBounds(180, 170, 180, 25);
		labelRG.setBounds(30, 200, 150, 25);
		valorRG.setBounds(180, 200, 180, 25);
		
		labelRazaoSocial.setBounds(30, 140, 150, 25);
		valorRS.setBounds(180, 140, 180, 25);
		labelCNPJ.setBounds(30, 170, 150, 25);
		valorCnpj.setBounds(180, 170, 180, 25);
		labelCont.setBounds(30, 200, 150, 25);
		valorCont.setBounds(180, 200, 180, 25);


		//Coloca os campos relacionados a Cliente
		if (op == 1 || op == 3 ) {
			this.janela.add(labelCPF);
			this.janela.add(valorCPF);
			this.janela.add(labelFormaPag);
			this.janela.add(valorFormaPag);
			this.janela.add(labelRG);
			this.janela.add(valorRG);
		}

		//Coloca campos relacionados a  Fabricante
		if (op == 2 || op == 4) {

			this.janela.add(labelRazaoSocial);
			this.janela.add(valorRS);
			this.janela.add(labelCNPJ);
			this.janela.add(valorCnpj);
			this.janela.add(labelCont);
			this.janela.add(valorCont);
		}

		//Coloca botoes de excluir e salvar
		if (op == 3 || op == 4) {
			botaoSalvar.setBounds(120, 300, 115, 30);
			botaoExcluir.setBounds(245, 300, 115, 30);
			this.janela.add(botaoExcluir);
		}
        
		
		//Adiciona na janela os campos para cadastro comuns a fabricante e cliente
		this.janela.add(labelNome);
		this.janela.add(valorNome);
		this.janela.add(labelTelefone);
		this.janela.add(valorTelefone);
		this.janela.add(labelEnd);
		this.janela.add(valorEnd);
		this.janela.add(labelEmail);
		this.janela.add(valorEmail);
		this.janela.add(botaoSalvar);
        
		
		//Define os dados da janela
		this.janela.setLayout(null);
        this.janela.setSize(600, 450);
		this.janela.setVisible(true);
        
		
		//Adiciona o reconhecimento de interações com botões
		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
	}
	
     
	/**
	 * Recebe a interação com os botões da tela de cadastro
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == botaoSalvar) {
			try {
				boolean res;
				if(opcao == 1) //cadastro de novo Cliente
					novoDado[0] = Integer.toString(dados.getQtdClientes());
				else if (opcao == 2) // cadastro de novo Fabricante
					novoDado[0] = Integer.toString(dados.getQtdFabricantes());
				else // edicao de dado existente
					novoDado[0] = Integer.toString(posicao);

				novoDado[1] =  valorNome.getText();
				novoDado[2] =  valorTelefone.getText();
				novoDado[3] =  valorEnd.getText();
				novoDado[4] =  valorEmail.getText();
				

				if (opcao == 1 || opcao == 3) {
					novoDado[5] =  valorCPF.getText();
					novoDado[6] =  valorFormaPag.getText();
					novoDado[7] =  valorRG.getText();
					res = dados.inserirEditarCliente(novoDado);
				} else {
					novoDado[5] =  valorRS.getText();
					novoDado[6] =  valorCnpj.getText();
					novoDado[7] =  valorCont.getText();
					res = dados.inserirEditarFabricante(novoDado);
				}

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

		if(src == botaoExcluir) {
			boolean res = false;

			if (opcao == 3) {//exclui Cliente
				res = dados.removerCliente(posicao);
				if (res) mensagemSucessoExclusao(); 
				else mensagemErroExclusaoCliente(); 
			}
				
			if (opcao == 4){ //exclui Fabricante
				res = dados.removerFabricantes(posicao);
				if (res) mensagemSucessoExclusao(); 
				else mensagemErroExclusaoFabricante(); 
			}


			
		}
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
     * Exibe a mensagem de erro caso haja algum problema na exclusao de um cliente
     */
	public void mensagemErroExclusaoCliente() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado, verifique se esse cliente nao esta vinculado a uma venda cadastrada", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	/**
     *Exibe a mensagem de erro caso haja algum problema na exclusao de um fabricante
     */
	public void mensagemErroExclusaoFabricante() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado, verifique se esse fabricante nao é responsavel por algum produto cadastrado", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	
}
