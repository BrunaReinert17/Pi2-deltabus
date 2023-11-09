package visao;

import java.awt.BorderLayout;
import java.awt.Color; 
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import controle.ClienteDAO;
import controle.EnderecoDAO;
import controle.FuncionarioDAO;
import mensagens.CadastroErro;
import mensagens.CadastroErro1;
import mensagens.CadastroSucesso;
import mensagens.ConfirmacaoDeletarCliente;
import mensagens.ConfirmacaoDeletarUsuario;
import mensagens.DeletarCliente1;
import mensagens.DeletarCliente2;
import mensagens.DeletarUsuario1;
import mensagens.DeletarUsuario2;
import mensagens.InterfaceMensagemConfirmacao;
import mensagens.CadastroCliente;

import modelo.Cliente;
import modelo.Endereco;
import modelo.Funcionario;
import utilidades.RoundButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.AncestorEvent;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CadastrarCliente extends JPanel {
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtnumeroTelefone;
	private JTextField txtCpf;
	private JTextField txtCep;
	private JLabel lblCep;
	private JLabel lblBairro;
	private JLabel lblFuno;
	private JButton bntDeletar;
	private JButton btnCadastrar;

	// Variaveis atribuidasa
	private String verificarCampo;
	private JTextField textField;
	private JLabel lblLimpar;
	private String cpf;
	private JTextField textCnpj;
	private JTable table;
	private ArrayList<Cliente> listClientes;


	public CadastrarCliente() {
		setLocale("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 1200, 800);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 102));
		contentPane.setForeground(new Color(0, 102, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(220, 369, 751, 252);
		add(scrollPane3, BorderLayout.CENTER);
		
		table = new JTable();
		table.setFont(new Font("Dialog", Font.BOLD, 14));
		table.setBackground(Color.WHITE);
		scrollPane3.setViewportView(table);
		
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "Numero Telefone", "Email", "Cpf", "Cnpj", "Cep" }));
		scrollPane3.setViewportView(table);
		
		

		lblLimpar = new JLabel("");
		lblLimpar.setBounds(930, 92, 110, 33);
		lblLimpar.setBackground(new Color(245, 245, 245));
		lblLimpar.setIcon(new ImageIcon(CadastrarCliente.class.getResource("/imagem/Icone4.png")));
		add(lblLimpar);

		JLabel lblNewLabel = new JLabel("Cadastrar Clientes");
		lblNewLabel.setBounds(25, 11, 182, 14);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1200, 46);
		panel.setBackground(new Color(0, 0, 0));
		add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 45, 10, 755);
		panel_1.setBackground(new Color(0, 0, 0));
		add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 790, 1190, 10);
		panel_2.setBackground(new Color(0, 0, 0));
		add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(1190, 34, 10, 766);
		panel_3.setBackground(new Color(0, 0, 0));
		add(panel_3);

		txtNome = new JTextField();
		txtNome.setBounds(214, 185, 241, 30);
		txtNome.setFont(new Font("Dialog", Font.BOLD, 13));
		txtNome.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtNome);
		txtNome.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(527, 185, 241, 30);
		txtEmail.setFont(new Font("Dialog", Font.BOLD, 13));
		txtEmail.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(214, 166, 67, 14);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 18));
		add(lblNome);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCpf.setBounds(271, 245, 46, 14);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblNome);

		JLabel lblEmail1 = new JLabel("Email:");
		lblEmail1.setBounds(527, 166, 67, 14);
		lblEmail1.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblEmail1);

		JLabel lblnumeroTelefone = new JLabel("Telefone:");
		lblnumeroTelefone.setBounds(459, 245, 98, 14);
		lblnumeroTelefone.setFont(new Font("Dialog", Font.BOLD, 18));
		lblnumeroTelefone.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblnumeroTelefone);

		/**********/
		MaskFormatter mascaranumeroTelefone = null;
		try {
			mascaranumeroTelefone = new MaskFormatter("(##)#####-####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtnumeroTelefone = new JFormattedTextField(mascaranumeroTelefone);
		txtnumeroTelefone.setBounds(459, 264, 182, 30);
		txtnumeroTelefone.setText("");
		txtnumeroTelefone.setFont(new Font("Dialog", Font.BOLD, 13));
		txtnumeroTelefone.setColumns(10);
		add(txtnumeroTelefone);

		/**********/
		MaskFormatter mascaraCep = null;
		try {
			mascaraCep = new MaskFormatter("#####-###");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtCep = new JFormattedTextField(mascaraCep);
		txtCep.setBounds(214, 264, 142, 30);
		txtCep.setText("");
		/**********/

		txtCep.setFont(new Font("Dialog", Font.BOLD, 13));
		txtCep.setColumns(10);
		add(txtCep);

		lblCep = new JLabel("CEP:");
		lblCep.setBounds(214, 245, 155, 14);
		lblCep.setFont(new Font("Dialog", Font.BOLD, 13));
		lblCep.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblCep);

		ArrayList<String> cidade = new ArrayList<>();
		cidade.add("");
		cidade.add("São José");
		cidade.add("Ilhota");
		cidade.add("Gaspar");
		cidade.add("Blumenau");

		lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Dialog", Font.BOLD, 13));
		lblBairro.setBounds(768, 428, 155, 14);

		ArrayList<String> uf = new ArrayList<>();
		uf.add("");
		uf.add("SC");
		uf.add("SP");
		uf.add("RS");
		uf.add("PR");

		btnCadastrar = new RoundButton("Confirmar");
		btnCadastrar.setBounds(527, 661, 116, 33);
		btnCadastrar.setText("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cliente cliente = verificarDados();
				
				boolean verificarRetornoCadastro = false;
				
				
				
				if (cliente != null) {
					
					ClienteDAO clienteDAO = new ClienteDAO();
					boolean resultado = clienteDAO.inserirCliente(cliente);
					
				 if (resultado == true) {
					 CadastroCliente cadastro = new CadastroCliente("Cliente cadastrado com sucesso!");
					 cadastro.setLocationRelativeTo(null);
					 cadastro.setVisible(true);
     				atualizarTabela();
					 limparDados();
				 }
				 else {
					 CadastroErro1 erro1 = new CadastroErro1("Erro de Cadastro, tente novamente!");
                     erro1.setLocationRelativeTo(null);
                     erro1.setVisible(true);
                     }
				}
			}

		});
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnCadastrar.setBackground(new Color(0, 128, 128));
		add(btnCadastrar);
		atualizarTabela();


		JButton btnLimparCampo = new RoundButton("Limpar Campo");
		btnLimparCampo.setBounds(968, 92, 84, 33);
		btnLimparCampo.setText("");
		btnLimparCampo.setBackground(new Color(245, 245, 245));
		btnLimparCampo.setForeground(Color.WHITE);
		btnLimparCampo.setFont(new Font("Dialog", Font.BOLD, 14));
		btnLimparCampo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtNome.setText("");

				txtEmail.setText("");

				txtnumeroTelefone.setText("");

				txtCep.setText("");



			}
		});
		add(btnLimparCampo);
		
		
		JLabel lblCpf2 = new JLabel("CPF");
		lblCpf2.setFont(new Font("Dialog", Font.BOLD, 13));
		lblCpf2.setBounds(837, 166, 155, 14);
		add(lblCpf2);
		/**********/
		MaskFormatter mascaraCpf2 = null;
		try {
			mascaraCpf2 = new MaskFormatter("###.###.###-##");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtCpf = new JFormattedTextField(mascaraCpf2);
		txtCpf.setBounds(837, 185, 142, 30);
		txtCpf.setText("");
		txtCpf.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtCpf);
		txtCpf.setColumns(10);
		/**********/
		
		MaskFormatter mascaraCnpj = null;
		try {
		    mascaraCnpj = new MaskFormatter("##.###.###/2001-##");
		} catch (ParseException e1) {
		    e1.printStackTrace();
		}

		textCnpj = new JFormattedTextField(mascaraCnpj);
		textCnpj.setBounds(744, 264, 235, 30);
		textCnpj.setText("");
		textCnpj.setFont(new Font("Dialog", Font.BOLD, 13));
		add(textCnpj);
		textCnpj.setColumns(10);
		/**********/
		
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setFont(new Font("Dialog", Font.BOLD, 13));
		lblCnpj.setBounds(744, 245, 155, 14);
		add(lblCnpj);
		
		RoundButton btnDeletar2 = new RoundButton("Confirmar");
		btnDeletar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = table.getSelectedRow();
				if (linhaSelecionada >= 0) {
				    Cliente cliente = listClientes.get(linhaSelecionada);

				   ConfirmacaoDeletarCliente confirmar = new ConfirmacaoDeletarCliente("Tem certeza que quer excluir", new InterfaceMensagemConfirmacao() { 
				    
					   
					   @Override
						
						public void mensagemConfirmada() {
							if (ClienteDAO.excluirCliente(cliente)) {
			                DefaultTableModel model = (DefaultTableModel) table.getModel();
			                model.removeRow(linhaSelecionada);
			                
			            } else {
			                DeletarCliente1 falha = new DeletarCliente1("Falha ao excluir Cliente");
			                falha.setLocationRelativeTo(null);
			                falha.setVisible(true);
			            }
							
						}

						@Override
						public void mensagemCancelada() {
							
							
						}
			        	
			        });
			        confirmar.setVisible(true);
			     
			    } else {
			    	DeletarCliente2 falha2 = new DeletarCliente2("Selecione um veiculo para excluir");
			        falha2.setLocationRelativeTo(null);
			        falha2.setVisible(true);
			    }
			}
		});
			
		btnDeletar2.setText("Deletar");
		btnDeletar2.setForeground(Color.BLACK);
		btnDeletar2.setFont(new Font("Dialog", Font.BOLD, 16));
		btnDeletar2.setBackground(new Color(245, 245, 245));
		btnDeletar2.setBounds(1084, 92, 84, 33);
		add(btnDeletar2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 0));
		panel_4.setBounds(214, 361, 763, 267);
		add(panel_4);
		
		JButton btnPesquisar_1 = new JButton("Pesquisar");
		btnPesquisar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpfpesquisa = textCnpj.getText();
				atualizarTabela();
				}
			});
			btnPesquisar_1.setBounds(291, 371, 115, 23);
			add(btnPesquisar_1);
			atualizarTabela();
			
		btnPesquisar_1.setForeground(Color.WHITE);
		btnPesquisar_1.setFont(new Font("Dialog", Font.BOLD, 16));
		btnPesquisar_1.setBackground(new Color(0, 128, 128));
		btnPesquisar_1.setBounds(214, 331, 115, 23);
		add(btnPesquisar_1);

		setContentPane(contentPane);
		contentPane.setLayout(null);

	}

	public void atualizarTabela() {
		DefaultTableModel tabela = new DefaultTableModel(new Object[][] {}, new String[] {  "Nome", "Numero Telefone", "Email", "Cpf", "Cnpj", "Cep"  });
		ClienteDAO clientedao = new ClienteDAO();
		listClientes = clientedao.listar();
		System.out.println(listClientes);
		for (int i = 0; i < listClientes.size(); i++) {
			Cliente cliente = listClientes.get(i);
			tabela.addRow(new Object[] { cliente.getNome(), cliente.getNumeroTelefone(), cliente.getEmail(),cliente.getCpf(),cliente.getCnpj(),cliente.getEndereco().getCep()});

		}
		table.setModel(tabela);
	}

	private void setLocale(String string) {

	}

	private void setContentPane(JPanel contentPane) {

	}

	private void setDefaultCloseOperation(int exitOnClose) {

	}

	public Cliente verificarDados() {

		Cliente cliente = new Cliente();
		Endereco endereco = new Endereco();

		verificarCampo = "";

		String nome = txtNome.getText();

		String email = txtEmail.getText();

		String numeroTelefone = txtnumeroTelefone.getText().replace("-", "").replace("(", "").replace(")", "");

		String cep = txtCep.getText().replace("-", "");


		if (nome == null || nome.trim() == "" || nome.isEmpty()) {
			verificarCampo += "Nome\n";
		} else {
			cliente.setNome(nome);
		}

		if (email == null || email.trim() == "" || email.isEmpty()) {
			verificarCampo += "Email\n";
		} else {
			cliente.setEmail(email);
		}
		
		 if (numeroTelefone == null  || numeroTelefone.trim().isEmpty()) {
			verificarCampo += "numeroTelefone\n";
		} else {
			cliente.setNumeroTelefone(numeroTelefone);

		}

		if (cpf == null || cpf.toString().trim().isEmpty()) {
			verificarCampo += "cpf\n";
		} else {
			
			cliente.setCpf(cpf);
		}

		if (cep == null || cep.toString().trim().isEmpty()) {
			verificarCampo += "cep\n";
		} else {
			EnderecoDAO ende1 = new EnderecoDAO();
			endereco.setCep(Long.parseLong(cep));
			endereco = ende1.listandoEndereco(endereco);
			cliente.setEndereco(endereco);

		}

		if (verificarCampo.trim() == "") {
			return cliente;
		}

		return cliente;

	}

	public void limparDados() {
		txtNome.setText("");
		txtEmail.setText("");
		txtnumeroTelefone.setText("");
		txtCep.setText("");
	}
}
