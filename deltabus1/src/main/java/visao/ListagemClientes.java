package visao;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.ClienteDAO;
import controle.FuncionarioDAO;
import modelo.Cliente;
import modelo.Funcionario;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.SwingConstants;
import utilidades.RoundButton;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ListagemClientes extends JPanel {
	private JTable table;
	private JTextField textcnpj;
	private ArrayList<Cliente> listClientes;


	

private void deletarClientes() {
	
	Double cnpj;
		
		cnpj = Double.valueOf(textcnpj.getText());
		
		Cliente objcliente = new Cliente();
		objcliente.setCnpj(cnpj);
		
		ClienteDAO objclientedao = new ClienteDAO();
		
		objclientedao.excluirCliente(objcliente);
		}

	
	
	public ListagemClientes() {
		setBackground(new Color(0, 0, 0));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 51, 1179, 748);
		add(panel);
		panel.setLayout(new BorderLayout());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 37, 1184, 689);
		panel.add(scrollPane, BorderLayout.CENTER);
		
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("Dialog", Font.BOLD, 14));
		
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "Numero Telefone", "Email", "Cpf", "Cnpj", "Cep" }));
		scrollPane.setViewportView(table);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 0, 1200, 40);
		panel_1.setBounds(0, 7, 1152, 46);
		add(panel_1);
		
		JLabel lblNewLabel = new JLabel("      Listagem de Clientes\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(0, 0, 352, 38);
		panel_1.add(lblNewLabel);
		
		RoundButton rndbtnDeletar = new RoundButton("Deletar");
		rndbtnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int linhaSelecionada = table.getSelectedRow();
				if (linhaSelecionada >= 0) {
				    // Obtém o veículo selecionado da lista
				    Cliente cliente = listClientes.get(linhaSelecionada);

				    // Chama o método DAO para excluir o veículo
				    if (ClienteDAO.excluirCliente(cliente)) {
				        // Atualize a lista e a tabela após a exclusão bem-sucedida
				        DefaultTableModel model = (DefaultTableModel) table.getModel();
				        model.removeRow(linhaSelecionada);
				    } else {
				        JOptionPane.showMessageDialog(null, "Falha ao excluir do banco de dados.");
				    }
				} else {
				    JOptionPane.showMessageDialog(null, "Selecione para excluir.");
				}
		    }
		});
			
		rndbtnDeletar.setText("Deletar");
		rndbtnDeletar.setForeground(Color.BLACK);
		rndbtnDeletar.setFont(new Font("Dialog", Font.BOLD, 16));
		rndbtnDeletar.setBackground(Color.WHITE);
		rndbtnDeletar.setBounds(1023, 3, 115, 33);
		panel_1.add(rndbtnDeletar);
		
		RoundButton rndbtnAlterar = new RoundButton("Alterar");
		

		rndbtnAlterar.setText("Alterar");
		rndbtnAlterar.setForeground(Color.WHITE);
		rndbtnAlterar.setFont(new Font("Dialog", Font.BOLD, 16));
		rndbtnAlterar.setBackground(new Color(0, 128, 128));
		rndbtnAlterar.setBounds(889, 3, 114, 33);
		panel_1.add(rndbtnAlterar);
		
		textcnpj = new JTextField();
		textcnpj.setColumns(10);
		textcnpj.setBounds(496, 12, 177, 20);
		panel_1.add(textcnpj);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setForeground(Color.WHITE);
		btnPesquisar.setFont(new Font
				("Dialog", Font.BOLD, 16));
		btnPesquisar.setBackground(new Color(0, 128, 128));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpfpesquisa = textcnpj.getText();
				atualizarTabela();
			}
		});
		btnPesquisar.setBounds(362, 10, 115, 23);
		panel_1.add(btnPesquisar);

		atualizarTabela();
	}
	public void atualizarTabela() {
		DefaultTableModel tabela = new DefaultTableModel(new Object[][] {}, new String[] {  "Nome", "Numero Telefone", "Email", "Cpf", "Cnpj", "Cep"  });
		ClienteDAO clientedao = new ClienteDAO();
		listClientes = clientedao.listar();
		System.out.println(listClientes);
		for (int i = 0; i < listClientes.size(); i++) {
			Cliente cliente = listClientes.get(i);
			tabela.addRow(new Object[] { cliente.getNome(), cliente.getNumeroTelefone(), cliente.getEmail(),cliente.getCpf(),cliente.getCnpj(),cliente.getCep()});

		}
		table.setModel(tabela);
	}

	}

