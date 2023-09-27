package visao;

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

import Mensagens.CadastroErro;
import Mensagens.CadastroErro1;
import Mensagens.CadastroSucesso;
import controle.ClienteDAO;
import controle.EnderecoDAO;
import modelo.Cliente;
import modelo.Endereco;
import utilidades.RoundButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.ImageIcon;

public class CadastrarCliente extends JPanel {
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtnumeroTelefone;
	private JComboBox cbPessoaJuridica_ou_Fisica;
	private JTextField txtCep;
	private JLabel lblCep;
	private JTextField txtBairro;
	private JComboBox cbCidade;
	private JLabel lblCidade;
	private JLabel lblBairro;
	private JLabel lblBairro_1;
	private JComboBox cbUf;
	private JLabel lblUf;
	private JLabel lblFuno;
	private JButton bntDeletar;
	private JButton btnCadastrar;

	// Variaveis atribuidas
	private String verificarCampo;
	private JTextField textField;
	private JLabel lblLimpar;
	private String pessoajuridica_ou_fisica;

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

		lblLimpar = new JLabel("");
		lblLimpar.setBounds(1035, 92, 110, 33);
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
		txtNome.setBounds(252, 195, 276, 30);
		txtNome.setFont(new Font("Dialog", Font.BOLD, 13));
		txtNome.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtNome);
		txtNome.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(684, 195, 276, 30);
		txtEmail.setFont(new Font("Dialog", Font.BOLD, 13));
		txtEmail.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(252, 176, 67, 14);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 18));
		add(lblNome);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCpf.setBounds(271, 245, 46, 14);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblNome);

		JLabel lblEmail1 = new JLabel("Email:");
		lblEmail1.setBounds(684, 176, 67, 14);
		lblEmail1.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblEmail1);

		JLabel lblnumeroTelefone = new JLabel("Telefone:");
		lblnumeroTelefone.setBounds(684, 280, 98, 14);
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
		txtnumeroTelefone.setBounds(684, 305, 182, 30);
		txtnumeroTelefone.setText("");
		/**********/

		txtnumeroTelefone.setFont(new Font("Dialog", Font.BOLD, 13));
		txtnumeroTelefone.setColumns(10);
		add(txtnumeroTelefone);

		ArrayList<String> pessoajuridica_ou_fisica = new ArrayList<String>();
		pessoajuridica_ou_fisica.add("");
		pessoajuridica_ou_fisica.add("CPF");
		pessoajuridica_ou_fisica.add("CNPJ");

		cbPessoaJuridica_ou_Fisica = new JComboBox();
		cbPessoaJuridica_ou_Fisica.setBounds(252, 300, 182, 31);
		cbPessoaJuridica_ou_Fisica.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				for (int i = 0; i < pessoajuridica_ou_fisica.size(); i++) {
					cbPessoaJuridica_ou_Fisica.addItem(pessoajuridica_ou_fisica.get(i));

				}
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbPessoaJuridica_ou_Fisica.setFont(new Font("Dialog", Font.BOLD, 13));
		add(cbPessoaJuridica_ou_Fisica);

		/**********/
		MaskFormatter mascaraCep = null;
		try {
			mascaraCep = new MaskFormatter("#####-###");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtCep = new JFormattedTextField(mascaraCep);
		txtCep.setBounds(252, 383, 142, 30);
		txtCep.setText("");
		/**********/

		txtCep.setFont(new Font("Dialog", Font.BOLD, 13));
		txtCep.setColumns(10);
		add(txtCep);

		lblCep = new JLabel("CEP:");
		lblCep.setBounds(252, 365, 155, 14);
		lblCep.setFont(new Font("Dialog", Font.BOLD, 13));
		lblCep.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblCep);

		txtBairro = new JTextField();
		txtBairro.setBounds(684, 466, 182, 30);
		txtBairro.setFont(new Font("Dialog", Font.BOLD, 13));
		txtBairro.setColumns(10);
		add(txtBairro);

		ArrayList<String> cidade = new ArrayList<>();
		cidade.add("");
		cidade.add("São José");
		cidade.add("Ilhota");
		cidade.add("Gaspar");
		cidade.add("Blumenau");

		cbCidade = new JComboBox();
		cbCidade.setBounds(252, 466, 182, 30);
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
		lblBairro.setBounds(768, 428, 155, 14);
		cbCidade.setFont(new Font("Dialog", Font.BOLD, 13));
		add(cbCidade);

		lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(252, 447, 155, 14);
		lblCidade.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblCidade);

		lblBairro_1 = new JLabel("Bairro:");
		lblBairro_1.setBounds(684, 441, 155, 14);
		lblBairro_1.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblBairro_1);

		ArrayList<String> uf = new ArrayList<>();
		uf.add("");
		uf.add("SC");
		uf.add("SP");
		uf.add("RS");
		uf.add("PR");

		cbUf = new JComboBox();
		cbUf.setBounds(684, 383, 142, 30);
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

		lblUf = new JLabel("UF:");
		lblUf.setBounds(684, 365, 155, 14);
		lblUf.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblUf);

		btnCadastrar = new RoundButton("Confirmar");
		btnCadastrar.setBounds(498, 582, 132, 33);
		btnCadastrar.setText("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Cliente cliente = verificarDados();
				if (cliente == null) {
					CadastroErro erro = new CadastroErro ("Dados inválidos!");
					erro.setLocationRelativeTo(null);
					erro.setVisible(true);
					
				} else {
					ClienteDAO clienteDAO = new ClienteDAO();
					EnderecoDAO enderecoDAO = new EnderecoDAO();
					Endereco endereco = enderecoDAO.consultandoEndereco(cliente.getEndereco());
					boolean ende = false;
					if (endereco == null) {
						ende = enderecoDAO.inserirEndereco(cliente.getEndereco());
					}

					boolean ClienteRetornoCadastro = false;

					if (ende != false) {

						ClienteRetornoCadastro = clienteDAO.inserirCliente(cliente.getCliente());
						System.out.println(cliente.getCliente());

						if (ClienteRetornoCadastro != false) {
							cliente = clienteDAO.selecionar(cliente.getCliente());
							System.out.println(cliente);
							cliente.setCliente(cliente);
							boolean resultado = clienteDAO.inserirCliente(cliente);
							if (resultado = true) {
								CadastroSucesso sucesso = new CadastroSucesso("Usuário Cadastrado com Sucesso!");
								sucesso.setLocationRelativeTo(null);
								sucesso.setVisible(true);
								limparDados();
							} else {
								CadastroErro1 erro1 = new CadastroErro1("Erro de Cadastro, tente novamente!");
								erro1.setLocationRelativeTo(null);
								erro1.setVisible(true);
							}
						}

					} else {
						JOptionPane.showMessageDialog(null, "Erro");
					}

				}

			}
		});
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnCadastrar.setBackground(new Color(0, 128, 128));
		add(btnCadastrar);

		JButton btnLimparCampo = new RoundButton("Limpar Campo");
		btnLimparCampo.setBounds(1061, 92, 84, 33);
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

				txtBairro.setText("");

				cbUf.setSelectedIndex(-1);

				cbCidade.setSelectedIndex(-1);

				cbPessoaJuridica_ou_Fisica.setSelectedIndex(-1);

			}
		});
		add(btnLimparCampo);

		JLabel lblPJuridica_ou_Fisica = new JLabel("Pessoa Juridica ou Fisica:");
		lblPJuridica_ou_Fisica.setBounds(252, 280, 169, 14);
		lblPJuridica_ou_Fisica.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblPJuridica_ou_Fisica);

		setContentPane(contentPane);
		contentPane.setLayout(null);

	}

	protected void setSelectedItem(Object object) {
		// TODO Auto-generated method stub

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

		String PessoaJuridica_ou_Fisica = (String) cbPessoaJuridica_ou_Fisica.getSelectedItem();

		String email = txtEmail.getText();

		String numeroTelefone = txtnumeroTelefone.getText().replace("-", "").replace("(", "").replace(")", "");

		String cep = txtCep.getText().replace("-", "");

		String UF = (String) cbUf.getSelectedItem();

		String bairro = txtBairro.getText();

		String cidade = (String) cbCidade.getSelectedItem();

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
		// numeroTelefone
		if (numeroTelefone == null || numeroTelefone.trim() == "" || numeroTelefone.isEmpty()) {
			verificarCampo += "numeroTelefone\n";
		} else {
			cliente.setNumeroTelefone(numeroTelefone);

		}

		if (pessoajuridica_ou_fisica == null || pessoajuridica_ou_fisica.trim() == "" || pessoajuridica_ou_fisica.isEmpty()) {
			verificarCampo += "PessoaJuridica_ou_Fisica\n";
		} else {
			
			cliente.setPessoaJuridica_ou_Fisica(pessoajuridica_ou_fisica);
		}

		if (cep == null || cep.trim() == "" || cep.isEmpty()) {
			verificarCampo += "cep\n";
		} else {
			endereco.setCep(Integer.valueOf(cep));

		}

		if (cidade == null || cidade.trim() == "" || cidade.isEmpty()) {
			verificarCampo += "cidade\n";
		} else {
			endereco.setCidade(cidade);

		}

		if (bairro == null || cep.trim() == "" || cep.isEmpty()) {
			verificarCampo += "bairro\n";
		} else {
			endereco.setBairro(bairro);

		}


		if (UF == null || UF.trim() == "" || UF.isEmpty()) {
			verificarCampo += "UF\n";
		} else {
			endereco.setUf(UF);

		}
		if (verificarCampo.trim() == "") {
			cliente.setCliente(cliente);
			return cliente;
		}

		return null;

	}

	public void limparDados() {
		txtNome.setText("");
		txtEmail.setText("");
		txtnumeroTelefone.setText("");
		txtCep.setText("");
		txtBairro.setText("");
	}
}
