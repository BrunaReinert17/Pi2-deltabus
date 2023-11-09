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
	private JTextField txtRua;
	private JTextField txtBairro;
	private JTextField textField;
	private JLabel lblLimpar;
	private String cpf;
	private JTextField txtCnpj;
	private JComboBox cbCidade;
	private JComboBox cbUf;
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
		txtNome.setBounds(122, 111, 241, 30);
		txtNome.setFont(new Font("Dialog", Font.BOLD, 13));
		txtNome.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtNome);
		txtNome.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(435, 111, 241, 30);
		txtEmail.setFont(new Font("Dialog", Font.BOLD, 13));
		txtEmail.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(122, 92, 67, 14);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 18));
		add(lblNome);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCpf.setBounds(271, 245, 46, 14);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblNome);

		JLabel lblEmail1 = new JLabel("Email:");
		lblEmail1.setBounds(435, 92, 67, 14);
		lblEmail1.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblEmail1);

		JLabel lblnumeroTelefone = new JLabel("Telefone:");
		lblnumeroTelefone.setBounds(367, 171, 98, 14);
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
		txtnumeroTelefone.setBounds(367, 190, 182, 30);
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
		txtCep.setBounds(122, 190, 142, 30);
		txtCep.setText("");
		/**********/

		txtCep.setFont(new Font("Dialog", Font.BOLD, 13));
		txtCep.setColumns(10);
		add(txtCep);

		lblCep = new JLabel("CEP:");
		lblCep.setBounds(122, 171, 155, 14);
		lblCep.setFont(new Font("Dialog", Font.BOLD, 13));
		lblCep.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblCep);

		lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Dialog", Font.BOLD, 13));
		lblBairro.setBounds(768, 428, 155, 14);

		btnCadastrar = new RoundButton("Confirmar");
		btnCadastrar.setBounds(527, 661, 116, 33);
		btnCadastrar.setText("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Cliente cliente = verificarDados();
				System.out.println("aaaa");
				System.out.println(cliente);
				if (cliente == null) {
					CadastroErro erro = new CadastroErro("Dados inválidos!");
					erro.setLocationRelativeTo(null);
					erro.setVisible(true);
				} else {
					ClienteDAO clienteDAO = new ClienteDAO();
					EnderecoDAO enderecoDAO = new EnderecoDAO();
					Endereco endereco = enderecoDAO.listandoEndereco(cliente.getEndereco());
					System.out.println(endereco);
					boolean ende = true;
					if (endereco == null) {
						ende = enderecoDAO.inserirEndereco(cliente.getEndereco());
					}
					boolean clienteRetornoCadastro;
					if (ende != false) {
							boolean resultado=false;
							try {
								resultado = clienteDAO.inserirCliente(cliente);
							} catch (Exception e2) {
								CadastroErro erro = new CadastroErro("Erro ao cadastrar, verifique os dados novamente!");
								erro.setLocationRelativeTo(null);
								erro.setVisible(true);
								return;
							
							}
							
							
							if (resultado == true) {
								CadastroSucesso sucesso = new CadastroSucesso("Cliente Cadastrado com Sucesso!");
								sucesso.setLocationRelativeTo(null);
								sucesso.setVisible(true);
								limparDados();
								atualizarTabela();

							} else {
								CadastroErro1 erro1 = new CadastroErro1("Erro de Cadastro, tente novamente!");
								erro1.setLocationRelativeTo(null);
								erro1.setVisible(true);
							}
						
					} else {
						CadastroErro1 erro1 = new CadastroErro1("Erro ao cadastrar endereço!");
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
				txtCpf.setText("");
				txtnumeroTelefone.setText("");
				txtCep.setText("");
				txtCnpj.setText("");
				cbCidade.setSelectedIndex(-1);
				cbUf.setSelectedIndex(-1);
				txtBairro.setText("");
				txtRua.setText("");
				dispose();

			}
		});
		add(btnLimparCampo);

		JLabel lblCpf2 = new JLabel("CPF");
		lblCpf2.setFont(new Font("Dialog", Font.BOLD, 13));
		lblCpf2.setBounds(745, 92, 155, 14);
		add(lblCpf2);
		/**********/
		MaskFormatter mascaraCpf2 = null;
		try {
			mascaraCpf2 = new MaskFormatter("###.###.###-##");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtCpf = new JFormattedTextField(mascaraCpf2);
		txtCpf.setBounds(745, 111, 142, 30);
		txtCpf.setText("");
		txtCpf.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtCpf);
		txtCpf.setColumns(10);
		/**********/

		MaskFormatter mascaraCnpj = null;
		try {
			mascaraCnpj = new MaskFormatter("##.###.###/####-##");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		txtCnpj = new JFormattedTextField(mascaraCnpj);
		txtCnpj.setBounds(652, 190, 235, 30);
		txtCnpj.setText("");
		txtCnpj.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtCnpj);
		txtCnpj.setColumns(10);
		/**********/

		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setFont(new Font("Dialog", Font.BOLD, 13));
		lblCnpj.setBounds(652, 171, 155, 14);
		add(lblCnpj);

		ArrayList<String> uf = new ArrayList<>();
		uf.add("");
		uf.add("SC");
		uf.add("SP");
		uf.add("RS");
		uf.add("PR");
		cbUf = new JComboBox();
		cbUf.setBounds(873, 271, 98, 30);
		cbUf.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				for (int i = 0; i < uf.size(); i++) {
					cbUf.addItem(uf.get(i));
				}
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbUf.setFont(new Font("Dialog", Font.BOLD, 13));
		add(cbUf);

		JLabel lblUf = new JLabel("UF:");
		lblUf.setFont(new Font("Dialog", Font.BOLD, 13));
		lblUf.setBounds(873, 242, 84, 14);
		add(lblUf);

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Dialog", Font.BOLD, 13));
		lblRua.setBounds(122, 241, 155, 14);
		add(lblRua);

		txtRua = new JTextField();
		txtRua.setFont(new Font("Dialog", Font.BOLD, 13));
		txtRua.setColumns(10);
		txtRua.setBounds(122, 270, 182, 31);
		add(txtRua);

		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Dialog", Font.BOLD, 13));
		txtBairro.setColumns(10);
		txtBairro.setBounds(367, 271, 182, 30);
		add(txtBairro);

		ArrayList<String> cidade = new ArrayList<>();
		cidade.add("");
		cidade.add("São José");
		cidade.add("Ilhota");
		cidade.add("Gaspar");
		cidade.add("Blumenau");
		cbCidade = new JComboBox();
		cbCidade.setBounds(587, 271, 182, 30);
		cbCidade.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				for (int i = 0; i < cidade.size(); i++) {
					cbCidade.addItem(cidade.get(i));
				}
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbCidade.setFont(new Font("Dialog", Font.BOLD, 13));
		add(cbCidade);

		lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Dialog", Font.BOLD, 13));
		lblBairro.setBounds(367, 242, 155, 14);
		add(lblBairro);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Dialog", Font.BOLD, 13));
		lblCidade.setBounds(587, 242, 155, 14);
		add(lblCidade);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		RoundButton btnDeletar2 = new RoundButton("Confirmar");
		btnDeletar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = table.getSelectedRow();
				if (linhaSelecionada >= 0) {
					Cliente cliente = listClientes.get(linhaSelecionada);

					ConfirmacaoDeletarCliente confirmar = new ConfirmacaoDeletarCliente("Tem certeza que quer excluir",
							new InterfaceMensagemConfirmacao() {

								@Override

								public void mensagemConfirmada() {
									if (ClienteDAO.deleteCliente(cliente)) {
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
				String cpfpesquisa = txtCnpj.getText();
				atualizarTabela();
			}
		});
		btnPesquisar_1.setBounds(291, 371, 115, 23);
		add(btnPesquisar_1);
		atualizarTabela();

		btnPesquisar_1.setForeground(Color.WHITE);
		btnPesquisar_1.setFont(new Font("Dialog", Font.BOLD, 16));
		btnPesquisar_1.setBackground(new Color(245, 245, 245));
		btnPesquisar_1.setBounds(214, 331, 115, 23);
		add(btnPesquisar_1);

		setContentPane(contentPane);
		contentPane.setLayout(null);

	}

	public void atualizarTabela() {
		DefaultTableModel tabela = new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "Numero Telefone", "Email", "Cpf", "Cnpj", "Cep" });
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

	private void dispose() {

	}

	public Cliente verificarDados() {

		Cliente cliente = new Cliente();
		Endereco endereco = new Endereco();

		verificarCampo = "";

		String nome = txtNome.getText();

		String email = txtEmail.getText();

		String cpf = txtCpf.getText().replace(".", "").replace("-", "");

		String numeroTelefone = txtnumeroTelefone.getText().replace("-", "").replace("(", "").replace(")", "");

		String cep = txtCep.getText().replace("-", "");

		String cnpj = txtCnpj.getText().replace(".", "").replace(".", "").replace("/", "").replace("-", "");

		String cidade = (String) cbCidade.getSelectedItem();

		String UF = (String) cbUf.getSelectedItem();

		String bairro = txtBairro.getText();

		String rua = txtRua.getText();

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
		if (cpf == null || cpf.toString().trim().isEmpty()) {
			verificarCampo += "cpf\n";
		} else {

			cliente.setCpf(cpf);
		}
		if (numeroTelefone == null || numeroTelefone.isEmpty()) {
			verificarCampo += "numeroTelefone\n";
		} else {
			cliente.setNumeroTelefone(numeroTelefone);

		}

		if (cep == null || cep.toString().trim().isEmpty()) {
			verificarCampo += "cep\n";
		} else {
			EnderecoDAO ende1 = new EnderecoDAO();
			endereco.setCep(Long.parseLong(cep));
			Endereco enderecoSelecionado = ende1.listandoEndereco(endereco);
			
			if(enderecoSelecionado == null) {
				ende1.inserirEndereco(endereco);
				enderecoSelecionado = endereco;
			}
			cliente.setEndereco(endereco);

		}

		if (cnpj == null || cnpj.toString().trim().isEmpty()) {
			verificarCampo += "cnpj\n";
		} else {
			cliente.setCnpj(Long.parseLong(cnpj));

		}
		if (cidade == null || cidade.trim() == "" || cidade.isEmpty()) {
			verificarCampo += "cidade\n";
		} else {
			endereco.setCidade(cidade);
		}
		if (UF == null || UF.trim() == "" || UF.isEmpty()) {
			verificarCampo += "UF\n";
		} else {
			endereco.setUf(UF);
		}
		if (bairro == null || cep.trim() == "" || cep.isEmpty()) {
			verificarCampo += "bairro\n";
		} else {
			endereco.setBairro(bairro);
		}
		if (rua == null || rua.trim() == "" || rua.isEmpty()) {
			verificarCampo += "rua\n";
		} else {
			endereco.setRua(rua);
		}

		if (verificarCampo.trim() == "") {
			return cliente;
		}

		return cliente;

	}

	public void limparDados() {
		txtNome.setText("");
		txtEmail.setText("");
		txtCpf.setText("");
		txtnumeroTelefone.setText("");
		txtCep.setText("");
		txtCnpj.setText("");
		cbCidade.setSelectedIndex(-1);
		cbUf.setSelectedIndex(-1);
		txtBairro.setText("");
		txtRua.setText("");
	}
}
