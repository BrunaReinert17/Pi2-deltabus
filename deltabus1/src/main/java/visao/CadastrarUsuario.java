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
	private JComboBox cbUf;
	private JLabel lblUf;
	private JTextField txtSenha;
	private JLabel lblSenha;
	private JComboBox cbFuncao;
	private JLabel lblFuno;
	private JButton bntDeletar;
	private JButton btnConfirmar;
	private JTextField txtDataNasci;
	
	
	
	//Variaveis atribuidas
	private String verificarCampo ;
	private JLabel txtRua;
	private JTextField textField;

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

		JLabel lblNewLabel = new JLabel("Cadastrar Usuários");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(25, 11, 182, 14);
		add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 1200, 46);
		add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 45, 10, 755);
		add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(10, 790, 1190, 10);
		add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 0));
		panel_3.setBounds(1190, 34, 10, 766);
		add(panel_3);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Dialog", Font.BOLD, 18));
		txtNome.setBounds(271, 176, 278, 30);
		add(txtNome);
		txtNome.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Dialog", Font.BOLD, 18));
		txtEmail.setBounds(643, 176, 307, 30);
		add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNome.setBounds(271, 157, 67, 14);
		add(lblNome);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 18));
		lblEmail.setBounds(643, 157, 67, 14);
		add(lblEmail);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCpf.setBounds(271, 245, 46, 14);
		add(lblCpf);

		/**********/
		MaskFormatter mascaraCpf = null;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtCpf = new JFormattedTextField(mascaraCpf);
		txtCpf.setText("");
		txtCpf.setFont(new Font("Dialog", Font.BOLD, 18));
		/**********/

		txtCpf.setBackground(new Color(255, 255, 255));
		txtCpf.setForeground(new Color(0, 0, 0));
		txtCpf.setColumns(10);
		txtCpf.setBounds(271, 264, 205, 30);
		add(txtCpf);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTelefone.setBounds(643, 245, 98, 14);
		add(lblTelefone);

		
		/**********/
		MaskFormatter mascaraTelefone = null;
		try {
			mascaraCpf = new MaskFormatter("(##)#####-####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtTelefone = new JFormattedTextField(mascaraCpf);
		txtTelefone.setText("");
		/**********/
		
		txtTelefone.setFont(new Font("Dialog", Font.BOLD, 18));
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(643, 264, 205, 30);
		add(txtTelefone);
		
		lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Dialog", Font.BOLD, 18));
		lblDataDeNascimento.setBounds(271, 340, 194, 14);
		add(lblDataDeNascimento);
		
		/**********/
		MaskFormatter mascaraDataDeNascimento = null;
		try {
			mascaraCpf = new MaskFormatter("##/##/####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtDataNasci  = new JFormattedTextField(mascaraCpf);
		/**********/
		ArrayList<String> genero = new ArrayList<String>();
		genero.add("");
		genero.add("Masculino");
		genero.add("Feminino");
		genero.add("Outro");
		
		cbGenero = new JComboBox();
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
		cbGenero.setBounds(514, 363, 154, 31);
		add(cbGenero);

	
		/**********/
		MaskFormatter mascaraCep = null;
		try {
			mascaraCpf = new MaskFormatter("#####-###");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtCep  = new JFormattedTextField(mascaraCpf);
		txtCep.setText("");
		/**********/
		
		txtCep.setFont(new Font("Dialog", Font.BOLD, 18));
		txtCep.setColumns(10);
		txtCep.setBounds(271, 447, 149, 30);
		add(txtCep);

		lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCep.setBounds(271, 428, 155, 14);
		add(lblCep);

		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Dialog", Font.BOLD, 18));
		txtBairro.setColumns(10);
		txtBairro.setBounds(768, 447, 182, 30);
		add(txtBairro);
		
		ArrayList<String> cidade = new ArrayList<>();
		cidade.add("");
		cidade.add("Majé");
		cidade.add("Ilhota");
		cidade.add("Gaspar");
		cidade.add("Blumenau");
		
		cbCidade = new JComboBox();
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
		cbCidade.setFont(new Font("Dialog", Font.BOLD, 18));
		cbCidade.setBounds(503, 447, 199, 30);
		add(cbCidade);

		lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCidade.setBounds(503, 428, 155, 14);
		add(lblCidade);

		lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Dialog", Font.BOLD, 18));
		lblBairro.setBounds(768, 428, 155, 14);
		add(lblBairro);

		ArrayList<String> uf = new ArrayList<>();
		uf.add("");
		uf.add("SC");
		uf.add("SP");
		uf.add("RS");
		uf.add("PR");
		
		cbUf = new JComboBox();
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
		cbUf.setFont(new Font("Dialog", Font.BOLD, 18));
		cbUf.setBounds(271, 541, 98, 30);
		add(cbUf);

		lblUf = new JLabel("UF:");
		lblUf.setFont(new Font("Dialog", Font.BOLD, 18));
		lblUf.setBounds(271, 524, 155, 14);
		add(lblUf);

		txtSenha = new JTextField();
		txtSenha.setFont(new Font("Dialog", Font.BOLD, 18));
		txtSenha.setColumns(10);
		txtSenha.setBounds(768, 541, 182, 30);
		add(txtSenha);

		lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSenha.setBounds(768, 524, 155, 14);
		add(lblSenha);
		
		ArrayList<String> funcao = new ArrayList<>();
		funcao.add("adm");
		funcao.add("estagiario");
		funcao.add("vendedor");

		cbFuncao = new JComboBox();
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
		cbFuncao.setModel(new DefaultComboBoxModel(new String[] {"","Administrador", "Funcionário"}));
		cbFuncao.setFont(new Font("Dialog", Font.BOLD, 13));
		cbFuncao.setBounds(503, 543, 155, 30);
		add(cbFuncao);

		lblFuno = new JLabel("Função:");
		lblFuno.setFont(new Font("Dialog", Font.BOLD, 18));
		lblFuno.setBounds(503, 520, 155, 23);
		add(lblFuno);

		bntDeletar = new RoundButton("Deletar");
		bntDeletar.setFont(new Font("Dialog", Font.BOLD, 14));
		bntDeletar.setForeground(Color.WHITE);
		bntDeletar.setBackground(new Color(0, 0, 0));
		bntDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bntDeletar.setBounds(444, 618, 132, 33);
		add(bntDeletar);

		btnConfirmar = new RoundButton("Confirmar");
		btnConfirmar.setText("Cadastrar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Funcionario funcionario = verificarDados();
				
				Usuario usuario = new Usuario();
				if (funcionario == null ) {
					JOptionPane.showMessageDialog(null, verificarCampo, "Dados inválidos:",
							JOptionPane.ERROR_MESSAGE, null);

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
								JOptionPane.showMessageDialog(null, "Cadastrado");
								limparDados();
							}else {
								JOptionPane.showMessageDialog(null,"ERrO");
							}
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "Erro");
					}
						
					
				
				}
				
				
			}
		});
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnConfirmar.setBackground(new Color(0, 128, 128));
		btnConfirmar.setBounds(614, 618, 132, 33);
		add(btnConfirmar);
		
		
		txtDataNasci.setBounds(271, 365, 149, 29);
		add(txtDataNasci);
		txtDataNasci.setColumns(10);
		
		
		JButton btnLimparCampo = new RoundButton("Limpar Campo");
		btnLimparCampo.setText("Limpar");
		btnLimparCampo.setBackground(Color.BLACK);
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
			
			}
		});
		btnLimparCampo.setBounds(1019, 69, 110, 33);
		add(btnLimparCampo);
		
		JLabel lblGnero_1 = new JLabel("Gênero:");
		lblGnero_1.setFont(new Font("Dialog", Font.BOLD, 18));
		lblGnero_1.setBounds(513, 340, 155, 14);
		add(lblGnero_1);
		
		txtRua = new JLabel("Rua:");
		txtRua.setFont(new Font("Dialog", Font.BOLD, 18));
		txtRua.setBounds(766, 340, 155, 14);
		add(txtRua);
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.BOLD, 18));
		textField.setColumns(10);
		textField.setBounds(766, 365, 182, 31);
		add(textField);

		setContentPane(contentPane);
		contentPane.setLayout(null);

	}

	private void setLocale(String string) {
		// TODO Auto-generated method stub

	}

	private void setContentPane(JPanel contentPane) {
		// TODO Auto-generated method stub

	}

	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub

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
