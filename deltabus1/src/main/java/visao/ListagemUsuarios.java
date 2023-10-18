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
import mensagens.ListagemErro;
import modelo.Endereco;
import modelo.Funcionario;
import modelo.Usuario;
import modelo.Veiculo;
import utilidades.RoundButton;

public class ListagemUsuarios extends JPanel {
	
	private JTable table;
	private JPanel panel;
	private JPanel panel_1;
	private ArrayList<Funcionario> listFuncionario;
	private JTextField textcpf;
	private Funcionario funcionarioClick;
	private JButton voltar;
	private AbstractButton btnSalvar;
	private String validacao = "";
	private ArrayList<Usuario> listUsuario;

private void deletarFuncionario() {
		long cpf;
		cpf = Long.valueOf(textcpf.getText());
		Funcionario objfuncionario = new Funcionario();
		objfuncionario.setCpf(cpf);
		FuncionarioDAO objfuncionariodao = new FuncionarioDAO();
		objfuncionariodao.excluirFuncionario(objfuncionario);
	}
	public ListagemUsuarios() {
		setBackground(new Color(0, 0, 0));
		setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(new Color(0, 102, 0));
		panel.setBackground(new Color(0, 0, 0));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)),"", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(0, 128, 128)));
		panel.setBounds(0, 37, 1184, 689);
		JPanel panel = new JPanel();
		panel.setBounds(27, 64, 1125, 735);
		add(panel);
		panel.setLayout(new BorderLayout());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 1164, 667);
		panel.add(scrollPane);
		scrollPane.setBounds(0, 0, 1136, 28);
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
				    // Obtém o usuário selecionado da lista
				    Funcionario funcionario = listFuncionario.get(linhaSelecionada);

				    
				   // if (FuncionarioDAO.deletarFuncionario(funcionario)) {
				        // Atualize a lista e a tabela após a exclusão bem-sucedida
				        DefaultTableModel model = (DefaultTableModel) table.getModel();
				        model.removeRow(linhaSelecionada);
				    } else {
				        JOptionPane.showMessageDialog(null, "Falha ao excluir o usuário do banco de dados.");
				    }
			    else {
				    JOptionPane.showMessageDialog(null, "Selecione um usuário para excluir.");
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

		
		textcpf = new JTextField();
		textcpf.setColumns(10);
		textcpf.setBounds(496, 12, 177, 20);
		panel_1.add(textcpf);
		

		textcpf = new JTextField();
		textcpf.setBounds(496, 12, 177, 20);
		panel_1.add(textcpf);
		textcpf.setColumns(10);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setForeground(Color.WHITE);
		btnPesquisar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnPesquisar.setBackground(new Color(0, 128, 128));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
<
				String cpfpesquisa = textcpf.getText();
				atualizarTabela1();

				String cpfpesquisa = textcpf.getText();
				

			}
		});
		btnPesquisar.setBounds(362, 10, 115, 23);
		panel_1.add(btnPesquisar);

		atualizarTabela1();
	}
	public void atualizarTabela1() {
		DefaultTableModel tabela = new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Email", "Cpf", "Telefone", "Data de Nascimento", "Gênero" });
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		listUsuario = usuarioDAO.listar();
		System.out.println(listUsuario);
		for (int i = 0; i < listUsuario.size(); i++) {
			Usuario usuarios = listUsuario.get(i);
			tabela.addRow(new Object[] { Usuario.getNome(), Usuario.Email(), Usuario.getCpf(),Usuario.getTelefone(),Usuario.getDataNasci(),Usuario.getGenero()});

		}
		table.setModel(tabela);
	}
 

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

