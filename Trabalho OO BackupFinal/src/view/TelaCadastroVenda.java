package view;

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
 * Classe TelaCadastroVenda, define e exibe os itens para os detalhes ou o cadastro de nova venda
 * @author Pedro Henrique Muniz de Oliveira
 * @since 2022
 * @version 1.0
 */


public class TelaCadastroVenda implements ActionListener,  ListSelectionListener{
	private JFrame janela;
	private JLabel labelID = new JLabel("ID da venda: ");
	private JTextField valorID;
	private JLabel labelData= new JLabel("Digite a data da venda: ");
	private JLabel labelBarra1= new JLabel(" / ");
	private JLabel labelBarra2= new JLabel(" / ");
	private JTextField valorDia;
	private JTextField valorMes;
	private JTextField valorAno;
	private JLabel labelVT = new JLabel("Valor total da venda");
	private JTextField valorVT;
	private JLabel labelCliente = new JLabel("Escolha um cliente abaixo ");
	private JLabel labelProdutos = new JLabel("Escolha um Produto abaixo:");
	
	private JLabel labelIDFim;
	private JLabel labelDataFim;
	private JLabel labelVTFim;
	private JLabel labelClienteFim;
	private JLabel labelProdutosFim;
	
	private JList<String> listaClientesCadastrados;
	private String[] listaNomesClientes = new String[50];
	private JScrollPane scroll1; 
	
	private JList<String> listaProdutosCadastrados;
	private String[] listaNomesProds = new String[50];
	private JScrollPane scroll2; 
	
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private String[] novoDado = new String[9];
	private static ControleDados dados;
	private int posicao;
	private int opcao;
	private String s;
	
	/**
	 * Recebe caso a interação foi com o botão de cadastro ou o com a lista de vendas, Define e exibe os itens para caso seja visualização ou cadastro de nova venda
	 * @param op opção
	 * @param d controle e dados
	 * @param v tela venda
	 * @param pos posição
	 */ 
	public void inserirVenda(int op, ControleDados d, TelaVenda v, int pos) {
		opcao = op;
		posicao = pos;
		dados = d;
		
		listaNomesProds = new ControleProduto(dados).getNomeProdutos();
		listaProdutosCadastrados = new JList<String>(listaNomesProds);
		
		listaNomesClientes = new ControleCliente(dados).getNomeCliente();
		listaClientesCadastrados = new JList<String>(listaNomesClientes);
		
		if (op == 1) s = "Cadastro de Venda";
		if (op == 2) s = "Detalhe de Venda";
		
		janela = new JFrame(s);
		
		if(op ==2) {
			valorID = new JTextField(200);
			valorDia = new JTextField(200);
			valorMes = new JTextField(200);
			valorAno = new JTextField(200);
			valorVT = new JTextField(200);
			
			
			labelIDFim = new JLabel("ID da venda: " + dados.getVendas()[pos].getIdentif());
			labelIDFim.setBounds(30, 20, 300, 25);
			
			labelDataFim = new JLabel( "Data da venda: " + dados.getVendas()[pos].getDia()+ "/" + dados.getVendas()[pos].getMes() + "/" + dados.getVendas()[pos].getAno());
			labelDataFim.setBounds(30, 50, 300, 25);
			
			labelVTFim = new JLabel("Valor Total: " + dados.getVendas()[pos].getVT());
			labelVTFim.setBounds(30, 80, 300, 25);
			
			labelClienteFim = new JLabel("" + dados.getVendas()[pos].getClienteVenda());
			labelClienteFim.setBounds(30, 110, 300, 25);
			
			labelProdutosFim = new JLabel("" + dados.getVendas()[pos].getProdVenda());
			labelProdutosFim.setBounds(30, 140, 300, 25);
		}else {
			
            listaClientesCadastrados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			scroll1 = new JScrollPane(listaClientesCadastrados);
			scroll1.setBounds(20, 200, 200,120); 
			
            listaProdutosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			scroll2 = new JScrollPane(listaProdutosCadastrados);
			scroll2.setBounds(300, 200, 200,120); 
			
			
		    valorID = new JTextField(200);
		    valorDia = new JTextField(200);
		    valorMes = new JTextField(200);
		    valorAno = new JTextField(200);
		    valorVT = new JTextField(200);
		  
		}
		
	
		if(op == 2) {//coloca os campos relacionados aos detalhes da venda
			this.janela.add(labelIDFim);
			this.janela.add(labelDataFim);
			this.janela.add(labelVTFim);
			this.janela.add(labelClienteFim);
			this.janela.add(labelProdutosFim);
			this.janela.add(botaoExcluir);
			
		}else {//coloca os campos relacionados ao cadastro de venda
			this.janela.add(labelID);
			this.janela.add(valorID);
			
			this.janela.add(labelData);
			this.janela.add(valorDia);
			this.janela.add(labelBarra1);
			this.janela.add(valorMes);
			this.janela.add(labelBarra2);
			this.janela.add(valorAno);
			
			this.janela.add(labelVT);
			this.janela.add(valorVT);
			
			this.janela.add(labelCliente);
			this.janela.add(labelProdutos);
			
			this.janela.add(scroll1);
			this.janela.add(scroll2);
			
			this.janela.add(botaoSalvar);
		}
			
		
		//Definiçao dos limites dos campos relacionados ao cadastro da venda
		labelID.setBounds(30, 20, 150, 25);
		valorID.setBounds(180, 20, 180, 25);
		
		labelData.setBounds(30, 50, 150, 25);
		valorDia.setBounds(180, 50, 30, 25);
		labelBarra1.setBounds(215,50,30,25);
		valorMes.setBounds(230,50,30,25);
		labelBarra2.setBounds(265,50,30,25);
		valorAno.setBounds(280,50,30,25);
		
		labelVT.setBounds(30, 80, 150, 25);
		valorVT.setBounds(180, 80, 180, 25);
		
		labelCliente.setBounds(20,180, 180,25);
		labelProdutos.setBounds(300,180, 180,25);
		
		botaoSalvar.setBounds(220, 350, 115, 30);
		botaoExcluir.setBounds(245, 350, 115, 30);
		
		
		//Dados da janela
		this.janela.setLayout(null);
        this.janela.setSize(600, 450);
		this.janela.setVisible(true);
        
		
		//Adiciona o reconhecimento de interações com botões e listas
		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
		listaClientesCadastrados.addListSelectionListener(this);
		listaProdutosCadastrados.addListSelectionListener(this);
		
	}
	
	/**
	 * Recebe a interação com os botões da TelaCadastroVenda e decide o que fazer
	 */
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == botaoSalvar) {
			try {
				boolean res;
				if(opcao == 1) //cadastro de nova Venda
					
				 
				novoDado[0] = Integer.toString(dados.getQtdVendas());

				novoDado[1] =  valorID.getText();
				novoDado[2] =  valorDia.getText();
				novoDado[3] =  valorMes.getText();
				novoDado[4] =  valorAno.getText();
				novoDado[5] =  valorVT.getText();
				
				
				res = dados.inserirVendas(novoDado, listaClientesCadastrados.getSelectedIndex(), listaProdutosCadastrados.getSelectedIndex());


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
		
		if(src == botaoExcluir) {//Exclui a venda
			boolean res = false;
				res = dados.removerVenda(posicao);
				if (res) mensagemSucessoExclusao(); 
			
		}

	}
	
	/**
	 * Recebe a interação com a listas para o cadastro de cliente e produto na venda
	 */
	public void valueChanged(ListSelectionEvent e) {
		
		listaClientesCadastrados.getSelectedIndex();
		
		listaProdutosCadastrados.getSelectedIndex();
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
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n", null, 
				JOptionPane.ERROR_MESSAGE);
	}

	
}
