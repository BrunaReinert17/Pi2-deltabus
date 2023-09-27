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

import Mensagens.LoginErro;
import Mensagens.CadastroErro;
import Mensagens.CadastroErro1;
import Mensagens.CadastroSucesso;
import controle.EnderecoDAO;
import controle.FuncionarioDAO;
import controle.UsuarioDAO;
import modelo.Endereco;
import modelo.Funcionario;
import modelo.Usuario;
import utilidades.RoundButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.ImageIcon;

public class CadastrarUsuario extends JPanel {
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtCpf;
	private JTextField txtDataDeNascimento;
	private JTextField txtTelefone;
	private JLabel lblDataDeNascimento;
	private JComboBox cbGenero;
	private JTextField txtCep;
	private JLabel lblCep;
	private JTextField txtBairro;
	private JComboBox cbCidade;
	private JLabel lblCidade;
	private JLabel lblBairro;
	private JLabel lblBairro_1;
	private JComboBox cbUf;
	private JLabel lblUf;
	private JTextField txtSenha;
	private JLabel lblSenha;
	private JComboBox cbFuncao;
	private JLabel lblFuno;
	private JLabel lblFuncao;
	private JButton bntDeletar;
	private JButton btnCadastrar;
	private JTextField txtDataNasci;
	
	
	
	//Variaveis atribuidas
	private String verificarCampo ;
	private JLabel txtRua;
	private JTextField textRua;
	private JTextField textField;
	private JLabel lblLimpar;

	public CadastrarUsuario() {
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
		lblLimpar.setIcon(new ImageIcon(CadastrarUsuario.class.getResource("/imagem/Icone4.png")));
		add(lblLimpar);

		JLabel lblNewLabel = new JLabel("Cadastrar Usuários");
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
		txtNome.setBounds(217, 176, 307, 30);
		txtNome.setFont(new Font("Dialog", Font.BOLD, 13));
		txtNome.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtNome);
		txtNome.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(649, 176, 325, 30);
		txtEmail.setFont(new Font("Dialog", Font.BOLD, 13));
		txtEmail.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(217, 157, 67, 14);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 18));
		add(lblNome);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCpf.setBounds(271, 245, 46, 14);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblNome);

		JLabel lblEmail1 = new JLabel("Email:");
		lblEmail1.setBounds(649, 157, 67, 14);
		lblEmail1.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblEmail1);

		JLabel lblCpf1 = new JLabel("CPF:");
		lblCpf1.setBounds(217, 252, 46, 14);
		lblCpf1.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblCpf1);

		/**********/
		MaskFormatter mascaraCpf = null;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtCpf = new JFormattedTextField(mascaraCpf);
		txtCpf.setBounds(217, 270, 182, 30);
		txtCpf.setText("");
		txtCpf.setFont(new Font("Dialog", Font.BOLD, 13));
		/**********/

		txtCpf.setBackground(new Color(255, 255, 255));
		txtCpf.setForeground(new Color(0, 0, 0));
		txtCpf.setColumns(10);
		add(txtCpf);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(217, 346, 98, 14);
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblTelefone);

		
		/**********/
		MaskFormatter mascaraTelefone = null;
		try {
			mascaraCpf = new MaskFormatter("(##)####-####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtTelefone = new JFormattedTextField(mascaraCpf);
		txtTelefone.setBounds(217, 364, 182, 30);
		txtTelefone.setText("");
		/**********/
		
		txtTelefone.setFont(new Font("Dialog", Font.BOLD, 13));
		txtTelefone.setColumns(10);
		add(txtTelefone);
		
		lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(521, 252, 194, 14);
		lblDataDeNascimento.setFont(new Font("Dialog", Font.BOLD, 18));
		lblDataDeNascimento.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblDataDeNascimento);
		
		/**********/
		MaskFormatter mascaraDataDeNascimento = null;
		try {
			mascaraCpf = new MaskFormatter("##/##/####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtDataNasci  = new JFormattedTextField(mascaraCpf);
		txtDataNasci.setBounds(521, 271, 149, 29);
		txtDataNasci.setFont(new Font("Dialog", Font.BOLD, 13));
		/**********/
		ArrayList<String> genero = new ArrayList<String>();
		genero.add("");
		genero.add("Masculino");
		genero.add("Feminino");
		genero.add("Outro");
		
		cbGenero = new JComboBox();
		cbGenero.setBounds(792, 270, 182, 31);
		cbGenero.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				for (int i = 0; i < genero.size(); i++) {
					cbGenero.addItem(genero.get(i));

				}
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbGenero.setFont(new Font("Dialog", Font.BOLD, 13));
		add(cbGenero);

	
		/**********/
		MaskFormatter mascaraCep = null;
		try {
			mascaraCpf = new MaskFormatter("#####-###");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtCep  = new JFormattedTextField(mascaraCpf);
		txtCep.setBounds(521, 364, 149, 30);
		txtCep.setText("");
		/**********/
		
		txtCep.setFont(new Font("Dialog", Font.BOLD, 13));
		txtCep.setColumns(10);
		add(txtCep);

		lblCep = new JLabel("CEP:");
		lblCep.setBounds(521, 346, 155, 14);
		lblCep.setFont(new Font("Dialog", Font.BOLD, 13));
		lblCep.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblCep);

		txtBairro = new JTextField();
		txtBairro.setBounds(521, 447, 182, 30);
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
		cbCidade.setBounds(217, 447, 182, 30);
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
		lblCidade.setBounds(217, 428, 155, 14);
		lblCidade.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblCidade);

		lblBairro_1 = new JLabel("Bairro:");
		lblBairro_1.setBounds(521, 428, 155, 14);
		lblBairro_1.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblBairro_1);

		ArrayList<String> uf = new ArrayList<>();
		uf.add("");
		uf.add("SC");
		uf.add("SP");
		uf.add("RS");
		uf.add("PR");
		
		cbUf = new JComboBox();
		cbUf.setBounds(820, 364, 98, 30);
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
		lblUf.setBounds(820, 346, 155, 14);
		lblUf.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblUf);

		txtSenha = new JTextField();
		txtSenha.setBounds(691, 541, 182, 30);
		txtSenha.setFont(new Font("Dialog", Font.BOLD, 13));
		txtSenha.setColumns(10);
		add(txtSenha);

		lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(691, 524, 155, 14);
		lblSenha.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblSenha);
		
		ArrayList<String> funcao = new ArrayList<>();
		funcao.add("Administrador");
		funcao.add("Funcionario");

		cbFuncao = new JComboBox();
		cbFuncao.setBounds(362, 541, 155, 30);
		cbFuncao.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				for (int i = 0; i < funcao.size(); i++) {
					cbFuncao.addItem(funcao.get(i));

				}
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbFuncao.setModel(new DefaultComboBoxModel(new String[] {""}));
		cbFuncao.setFont(new Font("Dialog", Font.BOLD, 13));
		add(cbFuncao);

		lblFuncao = new JLabel("Função:");
		lblFuncao.setBounds(362, 520, 155, 23);
		lblFuncao.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblFuncao);

		btnCadastrar = new RoundButton("Cadastrar");
		btnCadastrar.setBounds(521, 627, 132, 33);
		btnCadastrar.setText("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Funcionario funcionario = verificarDados();
				
				
				Usuario usuario = new Usuario();
				if (funcionario == null ) {
					CadastroErro erro = new CadastroErro ("Dados inválidos!");
					erro.setLocationRelativeTo(null);
					erro.setVisible(true);
					
				}else {
					FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
					EnderecoDAO enderecoDAO = new EnderecoDAO();
					UsuarioDAO usuarioDAO = new UsuarioDAO();
					Endereco endereco = enderecoDAO.consultandoEndereco(funcionario.getEndereco());
					boolean ende = false;
					if(endereco== null) {
						 ende = enderecoDAO.inserirEndereco(funcionario.getEndereco());
					}
					
					boolean usuarioRetornoCadastro = false;
					


					if(ende != false) {
						
						usuarioRetornoCadastro = usuarioDAO.inserirUsuario(funcionario.getUsuario());
						System.out.println(funcionario.getUsuario());
						
						if(usuarioRetornoCadastro!=false) {
							 usuario  = usuarioDAO.selecionar(funcionario.getUsuario());
							 System.out.println(usuario);
							 funcionario.setUsuario(usuario);
							boolean resultado = funcionarioDAO.inserirFuncionario(funcionario);
							if(resultado = true) {
								CadastroSucesso sucesso = new CadastroSucesso("Usuário Cadastrado com Sucesso!");
								sucesso.setLocationRelativeTo(null);
								sucesso.setVisible(true);
								limparDados();
							}else {
								CadastroErro1 erro1 = new CadastroErro1("Erro de Cadastro, tente novamente!");
								erro1.setLocationRelativeTo(null);
								erro1.setVisible(true);
							}
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "Erro");
					}
						
					
				
				}
				
				
			}
		});
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnCadastrar.setBackground(new Color(0, 128, 128));
		add(btnCadastrar);
		add(txtDataNasci);
		txtDataNasci.setColumns(10);
		
		
		JButton btnLimparCampo = new RoundButton("Limpar Campo");
		btnLimparCampo.setBounds(1061, 92, 84, 33);
		btnLimparCampo.setText("");
		btnLimparCampo.setBackground(new Color(245, 245, 245));
		btnLimparCampo.setForeground(Color.WHITE);
		btnLimparCampo.setFont(new Font("Dialog", Font.BOLD, 14));
		btnLimparCampo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtNome.setText("");

				txtCpf.setText("");

				txtEmail.setText("");

				txtTelefone.setText("");
						
				txtDataNasci.setText("");
	
				txtCep.setText("");

				txtSenha.setText("");
				
				txtBairro.setText("");
				
				textRua.setText("");
				
				cbUf.setSelectedIndex(-1);
				
				cbCidade.setSelectedIndex(-1);
				
				cbFuncao.setSelectedIndex(-1);
				
				cbGenero.setSelectedIndex(-1);

			}
		});
		add(btnLimparCampo);
		
		JLabel lblGnero_1 = new JLabel("Gênero:");
		lblGnero_1.setBounds(792, 252, 98, 14);
		lblGnero_1.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblGnero_1);
		
		txtRua = new JLabel("Rua:");
		txtRua.setBounds(792, 428, 155, 14);
		txtRua.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtRua);
		
		textRua = new JTextField();
		textRua.setBounds(792, 447, 182, 31);
		textRua.setFont(new Font("Dialog", Font.BOLD, 13));
		textRua.setColumns(10);
		add(textRua);

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
	public Funcionario verificarDados() {
		
		Funcionario funcionario = new Funcionario();
		Usuario usuario = new Usuario();
		Endereco endereco = new Endereco();
		
		
		verificarCampo = "";
		
		String nome = txtNome.getText();

		String cpfTxt = txtCpf.getText().replace(".", "").replace("-", "");

		String genero = (String) cbGenero.getSelectedItem();

		String email = txtEmail.getText();

		String telefone = txtTelefone.getText().replace("-", "").replace("(", "").replace(")",
				"");

		String dataN = txtDataNasci.getText();

		String cep = txtCep.getText().replace("-", "");

		String UF = (String) cbUf.getSelectedItem();

		String funcao = (String) cbFuncao.getSelectedItem();
		
		String senha = txtSenha.getText();
		
		String bairro = txtBairro.getText();
		
		String cidade = (String) cbCidade.getSelectedItem();
		
		String rua = txtRua.getText();
		if (nome == null || nome.trim() == "" || nome.isEmpty()) {
			verificarCampo += "Nome\n";
		} else {
			funcionario.setNome(nome);
		}


		if (cpfTxt == null || cpfTxt.trim() == "" || cpfTxt.isEmpty()) {
			verificarCampo += "CPF\n";
		} else {
			long cpf = Long.parseLong(cpfTxt);		
			funcionario.setCpf(cpf);
		}
		if (email == null || email.trim() == "" || email.isEmpty()) {
			verificarCampo += "Email\n";
		} else {
			usuario.setEmail(email);
		}
		// telefone
		if (telefone == null || telefone.trim() == "" || telefone.isEmpty()) {
			verificarCampo += "Telefone\n";
		} else {
			funcionario.setNumeroTelefone(telefone);

		}
		
		if (genero == null || genero.trim() == "" || genero.isEmpty()) {
			verificarCampo += "Genero\n";
		} else {
			
			funcionario.setGenero(genero);
		}
		// data Nascimento
		if (dataN == null || dataN.trim() == "" || dataN.isEmpty()) {
			verificarCampo += "Data\n";
		} else {
			String dataTest = dataN.replace("/", "").trim();
			if (dataTest.length() == 0) {
				verificarCampo += "Data\n";
		
			} else {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate dta = LocalDate.parse(dataN, formatter);
				dta.format(formatter);

				// tratamento de data para ver se é menor
				LocalDate dataAtual = LocalDate.now();

				if (dataAtual.isBefore(dta)) {
					verificarCampo += "Informe uma data anterior";

				} else {
					funcionario.setDatanasci(dta);
				}

			}

		}
		
		if (funcao == null || funcao.trim() == "" || funcao.isEmpty()) {
			verificarCampo += "funcao\n";

		} else {
			usuario.setCargo(funcao);
		}
		if (senha == null || senha.trim() == "" || senha.isEmpty()) {
			verificarCampo += "senha\n";
		} else {
			usuario.setSenha(senha);

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
		
		
		if (rua == null || rua.trim() == "" || rua.isEmpty()) {
			verificarCampo += "rua\n";
		} else {
			endereco.setRua(rua);

		}
		if (UF == null || UF.trim() == "" || UF.isEmpty()) {
			verificarCampo += "UF\n";
		} else {
			endereco.setUf(UF);

		}
		if(verificarCampo.trim() == "") {
			funcionario.setUsuario(usuario);
			funcionario.setEndereco(endereco);
			return funcionario;
		}
		
		return null;
		
		
		
		
		
		
		
	}
	public void limparDados() {
		 txtNome.setText("");

			txtCpf.setText("");

		
			 txtEmail.setText("");

		 txtTelefone.setText("");
				

		txtDataNasci.setText("");

		 txtCep.setText("");

			

			
			
			 txtSenha.setText("");
			
			txtBairro.setText("");
	}
}
