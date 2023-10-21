package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


import controle.FuncionarioDAO;
import controle.UsuarioDAO;
import controle.VeiculoDAO;
import mensagens.Deletar1;
import mensagens.Deletar2;
import mensagens.ListagemErro;
import modelo.Endereco;
import modelo.Funcionario;
import modelo.Usuario;
import modelo.Veiculo;
import utilidades.RoundButton;

public class ListagemUsuarios extends JPanel {
	
	private JTable table;
	private JPanel panel;
	private ArrayList<Funcionario> listFuncionario;
	private JTextField textcpf;
	private JTextField txtNome;
	

	

private void deletarUsuario() {
	String cpf;
	
	cpf = String.valueOf(textcpf.getText());
	
	Funcionario objfuncionario = new Funcionario();
	objfuncionario.setCpf(cpf);
	
	FuncionarioDAO objusuariodao = new 	FuncionarioDAO();
	
	objusuariodao.deletarFuncionario(objfuncionario);
	}

	public ListagemUsuarios() {
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
				new String[] { "Nome", "Email", "Cpf", "Telefone", "Data de Nascimento", "Gênero" }));
		scrollPane.setViewportView(table);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 7, 1152, 46);
		add(panel_1);
		
		JLabel lblNewLabel = new JLabel("      Listagem de Usuários\r\n");
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
				    
				    Funcionario funcionario = listFuncionario.get(linhaSelecionada);
                    
				    
				    if (FuncionarioDAO.excluirFuncionario(funcionario)) {
				        
				        DefaultTableModel model = (DefaultTableModel) table.getModel();
				        model.removeRow(linhaSelecionada);
				    } else {
				    	Deletar1 falha = new Deletar1("Falha ao excluir veiculo");
				    	falha.setLocationRelativeTo(null);
				    	falha.setVisible(true);
				    }
				} else {
					Deletar2 falha2 = new Deletar2("Selecione um veiculo para excluir");
			    	falha2.setLocationRelativeTo(null);
			    	falha2.setVisible(true);				}
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

		textcpf = new JTextField();
		textcpf.setColumns(10);
		textcpf.setBounds(496, 12, 177, 20);
		panel_1.add(textcpf);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setForeground(Color.WHITE);
		btnPesquisar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnPesquisar.setBackground(new Color(0, 128, 128));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String cpfpesquisa = textcpf.getText();
				atualizarTabela();				

			}
		});
		btnPesquisar.setBounds(362, 10, 115, 23);
		panel_1.add(btnPesquisar);

		atualizarTabela();
   }
	
	
	private void atualizarTabela() {
		DefaultTableModel tabela = new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Cpf", "Telefone", "Data de Nascimento", "Genero", "Endereço" });
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		listFuncionario = funcionarioDAO.consultarTodos();
		System.out.println(listFuncionario);
		for (int i = 0; i < listFuncionario.size(); i++) {
			Funcionario funcionario = listFuncionario.get(i);
			tabela.addRow(new Object[] { funcionario.getNome(), funcionario.getCpf(), funcionario.getNumeroTelefone(),funcionario.getDatanasci(),funcionario.getGenero(),funcionario.getEndereco().getCep()});

		}
		table.setModel(tabela);
	}
	
}

