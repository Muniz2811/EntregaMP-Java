package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import javax.swing.event.*;

import controle.*;

/**
 * Classe TelaPessoa, define e exibe a tela caso seja selecionado a opção fabricante ou cliente no menu principal
 * @author Pedro Henrique Muniz de Oliveira
 * @since 2022
 * @version 1.0
 */


public class TelaPessoa implements ActionListener, ListSelectionListener{
        
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroCliente;
	private JButton refreshCliente;
	private JButton cadastroFabricante;
	private JButton refreshFabricante;
	private static ControleDados dados;
	private JList<String> listaClientesCadastrados;
	private JList<String> listaFabricantesCadastrados;
	private String[] listaNomes = new String[50];
	private JScrollPane scroll;
	
	/**
	 * Especifica as medidas dos itens presentes na TelaPessoa
	 * @param d controle de dados
	 * @param op opção selecionada
	 */
	public void mostrarDados(ControleDados d, int op){
		
		dados = d;

		switch (op) {
		case 1:
			listaNomes = new ControleFabricante(dados).getNomeFabricante();
			listaFabricantesCadastrados = new JList<String>(listaNomes);
			janela = new JFrame("Fabricantes");
			titulo = new JLabel("Fabricantes Cadastrados");
			cadastroFabricante = new JButton("Cadastrar");
			refreshFabricante = new JButton("Atualizar");

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaFabricantesCadastrados.setBounds(20, 50, 350, 120);

			listaFabricantesCadastrados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			scroll = new JScrollPane(listaFabricantesCadastrados);
			scroll.setBounds(20, 50, 350,120); 

			cadastroFabricante.setBounds(70, 177, 100, 30);
			refreshFabricante.setBounds(200, 177, 100, 30);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(scroll);
			janela.add(cadastroFabricante);
			janela.add(refreshFabricante);

			janela.setSize(400, 250);
			janela.setVisible(true);

			cadastroFabricante.addActionListener(this);
			refreshFabricante.addActionListener(this);
			listaFabricantesCadastrados.addListSelectionListener(this);

			break;

		case 2:
			listaNomes = new ControleCliente(dados).getNomeCliente();
			listaClientesCadastrados = new JList<String>(listaNomes);
			janela = new JFrame("Clientes");
			titulo = new JLabel("Clientes Cadastrados");
			cadastroCliente = new JButton("Cadastrar");
			refreshCliente = new JButton("Atualizar");

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaClientesCadastrados.setBounds(20, 50, 350, 120);

			listaClientesCadastrados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			scroll = new JScrollPane(listaClientesCadastrados);
			scroll.setBounds(20, 50, 350,120); 


			cadastroCliente.setBounds(70, 177, 100, 30);
			refreshCliente.setBounds(200, 177, 100, 30);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(scroll);
			janela.add(cadastroCliente);
			janela.add(refreshCliente);

			janela.setSize(400, 250);
			janela.setVisible(true);

			cadastroCliente.addActionListener(this);
			refreshCliente.addActionListener(this);
			listaClientesCadastrados.addListSelectionListener(this);
			break;

		default:
			JOptionPane.showMessageDialog(null,"Opção não encontrada!", null, 
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Recebe a interação com os botões da TelaPessoa e decide o que fazer
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		
		if(src == cadastroCliente)
			new TelaDetalhePessoa().inserirEditar(1, dados, this, 0);

		
		if(src == cadastroFabricante)
			new TelaDetalhePessoa().inserirEditar(2, dados, this, 0);

		
		if(src == refreshCliente) {
			listaClientesCadastrados.setListData(new ControleCliente(dados).getNomeCliente());			
			listaClientesCadastrados.updateUI();
		}

		// Atualiza a lista de nomes de professores mostrada no JList
		if(src == refreshFabricante) {
			listaFabricantesCadastrados.setListData(new ControleFabricante(dados).getNomeFabricante());
			listaFabricantesCadastrados.updateUI();
		}

	}

	
	/**
	 * Recebe a interação com as listas de cada possibilidade TelaPessoa e decide o que fazer
	 */
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		if(e.getValueIsAdjusting() && src == listaClientesCadastrados) {
			new TelaDetalhePessoa().inserirEditar(3, dados, this, listaClientesCadastrados.getSelectedIndex());
		}

		if(e.getValueIsAdjusting() && src == listaFabricantesCadastrados) {
			new TelaDetalhePessoa().inserirEditar(4, dados, this, listaFabricantesCadastrados.getSelectedIndex());
		}
	}
	
}
