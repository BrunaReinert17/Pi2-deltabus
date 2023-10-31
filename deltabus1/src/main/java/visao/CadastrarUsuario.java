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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import controle.EnderecoDAO;
import controle.FuncionarioDAO;
import controle.UsuarioDAO;
import mensagens.ErroVeiculo;
import mensagens.InterfaceMensagemConfirmacao;
import mensagens.AlteraSucesso;
import mensagens.CadastroErro;
import mensagens.CadastroErro1;
import mensagens.CadastroSucesso;
import mensagens.ConfirmacaoDeletarUsuario;
import mensagens.DeletarUsuario1;
import mensagens.DeletarUsuario2;
import mensagens.ErroAlterar;
import mensagens.Limpar;
import mensagens.ListagemErro;
import mensagens.LoginErro;
import modelo.Endereco;
import modelo.Funcionario;
import modelo.StatusTelaUsuario;
import modelo.Usuario;
import utilidades.RoundButton;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
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
	// Variaveis atribuidas
	private String verificarCampo;
	private JLabel txtRua;
	private JTextField textRua;
	private JTextField textField;
	private JLabel lblLimpar;
	private JPanel panel;
	private JTable table;
	private JPanel panel_1;
	private JTextField textCPF;
	private JButton voltar;
	private AbstractButton btnSalvar;
	private String validacao = "";
	private Funcionario funcionarioClick;
	private ArrayList<Funcionario> listFunc;
	private RoundButton rndbtnSalvar;
	private ArrayList<Usuario> listUsuario;
	private Usuario UsuarioSelecionado;
	private Funcionario funcionarioSelecionado;
	private UsuarioDAO usuarioDao;
	private FuncionarioDAO funcionarioDao;
	private EnderecoDAO enderecoDao;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JPanel panel_4;
	private JScrollPane scrollPane_2;
	private JTable table_1;
	private JPanel panel_5;
	private ArrayList<Funcionario> listFuncionario;

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
		contentPane.setLayout(null);
		panel = new JPanel();
		panel.setForeground(new Color(0, 102, 0));
		panel.setBackground(new Color(245, 245, 245));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)),
				"", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(0, 128, 128)));
		panel.setBounds(0, 37, 1184, 724);
		contentPane.add(panel);
		panel.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 0, 1200, 46);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		JLabel lblNewLabel = new JLabel("      Listagem de Usuarios\r\n");
		lblNewLabel.setBounds(0, 0, 352, 38);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel_1.add(lblNewLabel);

		RoundButton rndbtnDeletar = new RoundButton("Deletar");
		rndbtnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletarFuncionario();

			}
		});
		rndbtnDeletar.setText("Deletar");
		rndbtnDeletar.setForeground(new Color(0, 0, 0));
		rndbtnDeletar.setFont(new Font("Dialog", Font.BOLD, 16));
		rndbtnDeletar.setBackground(new Color(255, 255, 255));
		rndbtnDeletar.setBounds(1050, 3, 115, 33);
		panel_1.add(rndbtnDeletar);

		textCPF = new JTextField();
		textCPF.setBounds(496, 12, 177, 20);
		panel_1.add(textCPF);
		textCPF.setColumns(10);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setForeground(new Color(255, 255, 255));
		btnPesquisar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnPesquisar.setBackground(new Color(0, 128, 128));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpfpesquisa = textCPF.getText();

			}

		});

		btnPesquisar.setBounds(362, 10, 115, 23);
		panel_1.add(btnPesquisar);

		panel_4 = new JPanel();
		panel_4.setBackground(new Color(220, 220, 220));
		panel_4.setBounds(153, 419, 882, 234);
		add(panel_4);
		panel_4.setLayout(new BorderLayout());

		scrollPane_2 = new JScrollPane();
		panel_4.add(scrollPane_2, BorderLayout.CENTER);

		table_1 = new JTable();
		table_1.setFont(new Font("Dialog", Font.BOLD, 14));
		table_1.setBackground(Color.WHITE);
		scrollPane_2.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "Email", "Cpf", "Telefone", "Data de Nascimento", "Gênero", "Endereço" }));
		scrollPane_2.setViewportView(table_1);

		lblLimpar = new JLabel("");
		lblLimpar.setBounds(1035, 92, 110, 33);
		lblLimpar.setBackground(new Color(245, 245, 245));
		lblLimpar.setIcon(new ImageIcon(CadastrarUsuario.class.getResource("/imagem/Icone4.png")));
		add(lblLimpar);
		JLabel lblNewLabel1 = new JLabel("Cadastrar Usuários");
		lblNewLabel1.setBounds(25, 11, 182, 14);
		lblNewLabel1.setForeground(new Color(255, 255, 255));
		lblNewLabel1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		add(lblNewLabel1);
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
		txtNome.setBounds(153, 176, 227, 30);
		txtNome.setFont(new Font("Dialog", Font.BOLD, 13));
		txtNome.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtNome);
		txtNome.setColumns(10);
		txtEmail = new JTextField();
		txtEmail.setBounds(437, 176, 227, 30);
		txtEmail.setFont(new Font("Dialog", Font.BOLD, 13));
		txtEmail.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtEmail);
		txtEmail.setColumns(10);
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(153, 157, 67, 14);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 18));
		add(lblNome);
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCpf.setBounds(271, 245, 46, 14);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblNome);
		JLabel lblEmail1 = new JLabel("Email:");
		lblEmail1.setBounds(437, 157, 67, 14);
		lblEmail1.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblEmail1);

		JLabel lblCpf1 = new JLabel("CPF:");
		lblCpf1.setBounds(714, 157, 46, 14);
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
		txtCpf.setBounds(714, 176, 132, 30);
		txtCpf.setText("");
		txtCpf.setFont(new Font("Dialog", Font.BOLD, 13));
		/**********/
		txtCpf.setBackground(new Color(255, 255, 255));
		txtCpf.setForeground(new Color(0, 0, 0));
		txtCpf.setColumns(10);
		add(txtCpf);
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(153, 239, 98, 14);
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
		txtTelefone.setBounds(153, 257, 132, 30);
		txtTelefone.setText("");
		/**********/
		txtTelefone.setFont(new Font("Dialog", Font.BOLD, 13));
		txtTelefone.setColumns(10);
		add(txtTelefone);
		lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setBounds(900, 157, 194, 14);
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
		txtDataNasci = new JFormattedTextField(mascaraCpf);
		txtDataNasci.setBounds(900, 177, 135, 29);
		txtDataNasci.setFont(new Font("Dialog", Font.BOLD, 13));
		/**********/
		ArrayList<String> genero = new ArrayList<String>();
		genero.add("");
		genero.add("Masculino");
		genero.add("Feminino");
		genero.add("Outro");

		cbGenero = new JComboBox();
		cbGenero.setBounds(342, 257, 120, 31);
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
		txtCep = new JFormattedTextField(mascaraCpf);
		txtCep.setBounds(515, 257, 149, 30);
		txtCep.setText("");
		/**********/

		txtCep.setFont(new Font("Dialog", Font.BOLD, 13));
		txtCep.setColumns(10);
		add(txtCep);
		lblCep = new JLabel("CEP:");
		lblCep.setBounds(515, 239, 155, 14);
		lblCep.setFont(new Font("Dialog", Font.BOLD, 13));
		lblCep.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblCep);
		txtBairro = new JTextField();
		txtBairro.setBounds(153, 339, 188, 30);
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
		cbCidade.setBounds(853, 257, 182, 30);
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
		lblCidade.setBounds(853, 239, 155, 14);
		lblCidade.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblCidade);
		lblBairro_1 = new JLabel("Bairro:");
		lblBairro_1.setBounds(153, 321, 155, 14);
		lblBairro_1.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblBairro_1);
		ArrayList<String> uf = new ArrayList<>();
		uf.add("");
		uf.add("SC");
		uf.add("SP");
		uf.add("RS");
		uf.add("PR");
		cbUf = new JComboBox();
		cbUf.setBounds(714, 257, 98, 30);
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
		lblUf.setBounds(714, 239, 155, 14);
		lblUf.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblUf);
		txtSenha = new JTextField();
		txtSenha.setBounds(853, 339, 182, 30);
		txtSenha.setFont(new Font("Dialog", Font.BOLD, 13));
		txtSenha.setColumns(10);
		add(txtSenha);
		lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(853, 321, 155, 14);
		lblSenha.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblSenha);
		ArrayList<String> funcao = new ArrayList<>();
		funcao.add("Administrador");
		funcao.add("Funcionario");

		cbFuncao = new JComboBox();
		cbFuncao.setBounds(660, 339, 135, 30);
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

		cbFuncao.setModel(new DefaultComboBoxModel(new String[] { "" }));
		cbFuncao.setFont(new Font("Dialog", Font.BOLD, 13));
		add(cbFuncao);
		lblFuncao = new JLabel("Função:");
		lblFuncao.setBounds(660, 317, 155, 23);
		lblFuncao.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblFuncao);

		btnCadastrar = new RoundButton("Cadastrar");
		btnCadastrar.setBounds(545, 697, 132, 33);
		btnCadastrar.setText("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Funcionario funcionario = verificarDados();
				System.out.println("aaaa");
				System.out.println(funcionario);
				Usuario usuario = new Usuario();
				if (funcionario == null) {
					CadastroErro erro = new CadastroErro("Dados inválidos!");
					erro.setLocationRelativeTo(null);
					erro.setVisible(true);
				} else {
					FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
					EnderecoDAO enderecoDAO = new EnderecoDAO();
					UsuarioDAO usuarioDAO = new UsuarioDAO();
					Endereco endereco = enderecoDAO.consultandoEndereco(funcionario.getEndereco());
					System.out.println(endereco);
					boolean ende = true;
					if (endereco == null) {
						ende = enderecoDAO.inserirEndereco(funcionario.getEndereco());
					}
					System.out.println(ende);

					boolean usuarioRetornoCadastro;
					System.out.println("ddddd1");
					if (ende != false) {
						System.out.println("ddddd12");
						usuarioRetornoCadastro = usuarioDAO.inserirUsuario(funcionario.getUsuario());
						System.out.println(funcionario.getUsuario());
						System.out.println("ddddd13");
						if (usuarioRetornoCadastro) {
							System.out.println("ddddd14");
							usuario = usuarioDAO.selecionar(funcionario.getUsuario());
							System.out.println(usuario);
							funcionario.setUsuario(usuario);
							boolean resultado = funcionarioDAO.inserirFuncionario(funcionario);

							if (resultado = true) {
								CadastroSucesso sucesso = new CadastroSucesso("Usuário Cadastrado com Sucesso!");
								sucesso.setLocationRelativeTo(null);
								sucesso.setVisible(true);
								atualizarTabela();
								limparDados();

							} else {
								CadastroErro1 erro1 = new CadastroErro1("Erro de Cadastro, tente novamente!");
								erro1.setLocationRelativeTo(null);
								erro1.setVisible(true);
							}
						}
					} else {
						CadastroErro1 erro1 = new CadastroErro1("Tente novamente!");
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
		add(txtDataNasci);
		txtDataNasci.setColumns(10);
		atualizarTabela();

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
				dispose();
			}
		});
		add(btnLimparCampo);
		JLabel lblGnero_1 = new JLabel("Gênero:");
		lblGnero_1.setBounds(342, 239, 98, 14);
		lblGnero_1.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblGnero_1);
		txtRua = new JLabel("Rua:");
		txtRua.setBounds(405, 321, 155, 14);
		txtRua.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtRua);
		textRua = new JTextField();
		textRua.setBounds(405, 339, 188, 31);
		textRua.setFont(new Font("Dialog", Font.BOLD, 13));
		textRua.setColumns(10);
		add(textRua);

		RoundButton rndbtnAlterar = new RoundButton("Alterar");
		rndbtnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int position = contentPane.getBaseline(WIDTH, HEIGHT);

				funcionarioClick = listFunc.get(getComponentCount());
				verificarDados(funcionarioClick);

				funcionarioClick = new Funcionario();

				btnCadastrar.setVisible(false);
				panel.remove(btnCadastrar);

				rndbtnAlterar.setVisible(false);
				panel.remove(rndbtnAlterar);

				bntDeletar.setVisible(false);
				panel.remove(bntDeletar);

				voltar = new JButton("Cancelar");
				voltar.setForeground(new Color(255, 255, 255));
				voltar.setBackground(new Color(149, 208, 157));

				voltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						limparDados();
						panel.add(btnCadastrar);
						btnCadastrar.setVisible(true);

						rndbtnAlterar.setFont(new Font("Tahoma", Font.BOLD, 16));
						panel.add(rndbtnAlterar, "cell 1 5,growx");
						rndbtnAlterar.setVisible(true);

						bntDeletar.setFont(new Font("Tahoma", Font.BOLD, 16));
						panel.add(bntDeletar, "cell 3 5,grow");
						bntDeletar.setVisible(true);

						panel.remove(voltar);

						btnSalvar.setVisible(false);
						panel.remove(btnSalvar);

						limparDados();
					}
				});
				voltar.setFont(new Font("Tahoma", Font.BOLD, 16));
				panel.add(voltar, "cell 1 5,growx");

				btnSalvar = new JButton("Salvar");
				btnSalvar.setForeground(new Color(255, 255, 255));
				btnSalvar.setBackground(new Color(149, 208, 157));
				btnSalvar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						validacao = "";

						Funcionario funcionario = new Funcionario();
						var endereco = new Endereco();
						var usuario = new Usuario();
						funcionario = verificarDados();
						endereco = setarObjetoEndereco();

						if (funcionario != null && usuario != null && endereco != null) {

							funcionario.setEndereco(endereco);
							funcionario.setUsuario(usuario);

							usuarioDao = new UsuarioDAO();
							UsuarioDAO.getInstancia(usuario);
							boolean retorno = funcionarioDao.alterarFuncionario(funcionario);
							if (retorno == true) {
								AlteraSucesso erroALt = new AlteraSucesso("Usuário Alterado!");
								erroALt.setLocationRelativeTo(null);
								erroALt.setVisible(true);
							} else {
								ErroAlterar erroALt = new ErroAlterar("Erro, Usuario Não Alterado!");
								erroALt.setLocationRelativeTo(null);
								erroALt.setVisible(true);
							}

							panel.add(btnCadastrar);
							btnCadastrar.setVisible(true);

							rndbtnAlterar.setFont(new Font("Dialog", Font.BOLD, 16));
							rndbtnAlterar.setBackground(new Color(0, 128, 128));
							rndbtnAlterar.setBounds(556, 627, 120, 33);
							rndbtnAlterar.setVisible(true);

							bntDeletar.setFont(new Font("Dialog", Font.BOLD, 16));
							bntDeletar.setBackground(new Color(0, 128, 128));
							bntDeletar.setBounds(556, 627, 120, 33);
							bntDeletar.setVisible(true);
							limparDados();
							voltar.setVisible(false);
							panel.remove(voltar);
							limparDados();

							btnSalvar.setVisible(false);
							panel.remove(btnSalvar);

						} else {
							CadastroErro erro1 = new CadastroErro("Dados Inválidos!");
							erro1.setLocationRelativeTo(null);
							erro1.setVisible(true);
						}

					}

					private Endereco setarObjetoEndereco() {
						Endereco endereco = new Endereco();
						enderecoDao = new EnderecoDAO();
						new EnderecoDAO();

						String cep = (String) txtCep.getText();
						String uf = (String) cbUf.getSelectedItem();
						String cidade = (String) cbCidade.getSelectedItem();
						String bairro = txtBairro.getText();
						String rua = txtRua.getText();

						if (cep == null || cep.trim() == "" || cep.isEmpty()) {
							validacao += " Cep\n";
						} else {
							Integer cep1 = Integer.valueOf(cep);
							endereco.setCep(cep1);
						}

						if (bairro == null || bairro.trim() == "" || bairro.isEmpty()) {
							validacao += " Bairro\n";
						} else {
							endereco.setBairro(bairro);
						}

						if (cidade == null || cidade.trim() == "" || cidade.isEmpty()) {
							validacao += " Cidade\n";
						} else {
							endereco.setCidade(cidade);
						}

						if (rua == null || rua.trim() == "" || rua.isEmpty()) {
							validacao += " Rua\n";
						} else {
							endereco.setRua(rua);
						}

						endereco.setUf(uf);
						if (validacao.trim() == "") {
							return endereco;
						} else {
							return endereco;
						}

					}

				});
				btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 16));
				panel.add(btnSalvar, "cell 7 1,grow");

				/*
				 * rndbtnAlterar.setVisible(false); contentPane.remove(rndbtnAlterar);
				 * 
				 * txtCpf.setEditable(false); int position = table.getSelectedRow(); String
				 * erros = "";
				 * 
				 * funcionarioSelecionado = listFunc.get(position);
				 * verificarDados(funcionarioSelecionado); UsuarioSelecionado =
				 * listUsuario.get(position);
				 * 
				 * JButton salvar = new JButton("salva"); salvar.addActionListener(new
				 * ActionListener() {
				 * 
				 * public void actionPerformed(ActionEvent e) {
				 * 
				 * String erros = "";
				 * 
				 * String nome = txtNome.getText(); String email = txtEmail.getText(); String
				 * dataNasci = (String) txtDataNasci.getText(); String genero = (String)
				 * cbGenero.getSelectedItem(); String numeroTelefone = txtTelefone.getText();
				 * String cpf = txtCpf.getText().replace(".", "").replace("-", ""); String cep =
				 * (String) txtCep.getText(); String senha = txtSenha.getText(); String cargo =
				 * (String) cbFuncao.getSelectedItem(); String uf = (String)
				 * cbUf.getSelectedItem(); String cidade = (String) cbCidade.getSelectedItem();
				 * String bairro = txtBairro.getText(); String rua = txtRua.getText();
				 * 
				 * Endereco endereco = new Endereco(); Funcionario funcionario = new
				 * Funcionario(); funcionario.setCpf(funcionarioSelecionado.getCpf()); Usuario
				 * usuario = new Usuario();
				 * usuario.setIdUsuario(UsuarioSelecionado.getIdUsuario());
				 * 
				 * if (nome == null || nome.trim() == "" || nome.isEmpty()) { erros += "nome\n";
				 * } else { funcionario.setNome(nome); }
				 * 
				 * if (email == null || email.trim() == "" || email.isEmpty()) { erros +=
				 * "email\n"; } else { funcionario.setEmail(email); }
				 * 
				 * if(dataNasci == null || dataNasci.toString() == "" || dataNasci.isBlank()) {
				 * erros += "dataNasci\n"; }else { funcionario.setDatanasci(null);// nao é pra
				 * ser null } if(genero == null || genero.trim() == "" || genero.isEmpty()) {
				 * erros += "genero\n"; }else { funcionario.setGenero(genero); }
				 * 
				 * if(numeroTelefone == null || numeroTelefone.trim() == "" ||
				 * numeroTelefone.isEmpty()) { erros += "numeroTelefone\n"; }else {
				 * funcionario.setNumeroTelefone(numeroTelefone); }
				 * 
				 * if(cpf == null || cpf.trim() == "" || cpf.isEmpty()) { erros += "cpf\n";
				 * }else { funcionario.setCpf(cpf); }
				 * 
				 * if(cep == null || cep.trim() == "" || cep.isEmpty()) { erros += "cep\n";
				 * }else { endereco.setCep(Integer.valueOf(cep)); }
				 * 
				 * if(senha == null || senha.trim() == "" || senha.isEmpty()) { erros +=
				 * "senha\n"; }else { usuario.setSenha(senha); }
				 * 
				 * if(cargo == null || cargo.trim() == "" || cargo.isEmpty()) { erros +=
				 * "cargo\n"; }else { usuario.setCargo(cargo); }
				 * 
				 * if(uf == null || uf.trim() == "" || uf.isEmpty()) { erros += "uf\n"; }else {
				 * endereco.setUf(uf); }
				 * 
				 * if(cidade == null || cidade.trim() == "" || cidade.isEmpty()) { erros +=
				 * "cidade\n"; }else { endereco.setCidade(cidade); }
				 * 
				 * if(bairro == null || bairro.trim() == "" || bairro.isEmpty()) { erros +=
				 * "bairro\n"; }else { endereco.setBairro(bairro); }
				 * 
				 * if(rua == null || rua.trim() == "" || rua.isEmpty()) { erros += "rua\n";
				 * }else { endereco.setRua(rua); }
				 * 
				 * usuarioDao = new UsuarioDAO(); UsuarioDAO.getIntancia(usuario); boolean
				 * retorno = funcionarioDao.alterarFuncionario(funcionario); if (retorno ==
				 * true) { AlteraSucesso erroALt = new AlteraSucesso("Usuário Alterado!");
				 * erroALt.setLocationRelativeTo(null); erroALt.setVisible(true); } else {
				 * ErroAlterar erroALt = new ErroAlterar("Erro, Usuario Não Alterado!");
				 * erroALt.setLocationRelativeTo(null); erroALt.setVisible(true); }
				 * 
				 * 
				 * 
				 * }
				 * 
				 * });
				 */
			}
		});
		rndbtnAlterar.setText("Alterar");
		rndbtnAlterar.setForeground(Color.WHITE);
		rndbtnAlterar.setFont(new Font("Dialog", Font.BOLD, 16));
		rndbtnAlterar.setBackground(new Color(0, 0, 0));
		rndbtnAlterar.setBounds(749, 697, 120, 33);
		add(rndbtnAlterar);

		RoundButton rndbtnSalvar = new RoundButton("Salvar");

		rndbtnSalvar.setForeground(new Color(255, 255, 255));
		rndbtnSalvar.setFont(new Font("Dialog", Font.BOLD, 16));
		rndbtnSalvar.setBackground(new Color(0, 128, 128));
		rndbtnSalvar.setBounds(352, 698, 110, 31);
		add(rndbtnSalvar);

		panel_5 = new JPanel();
		panel_5.setBackground(new Color(0, 0, 0));
		panel_5.setBounds(148, 411, 893, 249);
		add(panel_5);

		JButton btnPesquisar_1 = new JButton("Pesquisar");
		btnPesquisar_1.setForeground(Color.WHITE);
		btnPesquisar_1.setFont(new Font("Dialog", Font.BOLD, 16));
		btnPesquisar_1.setBackground(new Color(0, 128, 128));
		btnPesquisar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpfpesquisa = txtCpf.getText();
				atualizarTabela();
			}
		});
		btnPesquisar_1.setBounds(148, 385, 115, 23);
		add(btnPesquisar_1);

		RoundButton rndbtnDeletar_1 = new RoundButton("Deletar");
		rndbtnDeletar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = table_1.getSelectedRow();
				if (linhaSelecionada >= 0) {

					Funcionario funcionario = listFuncionario.get(linhaSelecionada);

					ConfirmacaoDeletarUsuario confirmar = new ConfirmacaoDeletarUsuario("Tem certeza que quer excluir",
							new InterfaceMensagemConfirmacao() {

								@Override

								public void mensagemConfirmada() {
									if (FuncionarioDAO.excluirFuncionario(funcionario)) {
										DefaultTableModel model = (DefaultTableModel) table_1.getModel();
										model.removeRow(linhaSelecionada);

									} else {
										DeletarUsuario1 falha = new DeletarUsuario1("Falha ao excluir veiculo");
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
					DeletarUsuario2 falha2 = new DeletarUsuario2("Selecione um veiculo para excluir");
					falha2.setLocationRelativeTo(null);
					falha2.setVisible(true);
				}
			}
		});
		rndbtnDeletar_1.setText("Deletar");
		rndbtnDeletar_1.setForeground(Color.BLACK);
		rndbtnDeletar_1.setFont(new Font("Dialog", Font.BOLD, 16));
		rndbtnDeletar_1.setBackground(Color.WHITE);
		rndbtnDeletar_1.setBounds(920, 92, 115, 33);
		add(rndbtnDeletar_1);
		atualizarTabela();

	}

	protected void dispose() {

	}

	protected void setExtendedState(int maximizedBoth) {

	}

	protected void setLocationRelativeTo(Object object) {
	}

	protected void verificarDados(Funcionario verificarDados) {
	}

	protected void deletarFuncionario() {
	}

	protected void setSelectedItem(Object object) {
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
		String telefone = txtTelefone.getText().replace("-", "").replace("(", "").replace(")", "");
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
			String cpf = String.valueOf(cpfTxt);
			funcionario.setCpf(cpf);
		}
		if (email == null || email.trim() == "" || email.isEmpty()) {
			verificarCampo += "Email\n";
		} else {
			usuario.setEmail(email);
			funcionario.setEmail(email);
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
		if (verificarCampo.trim() == "") {
			System.out.println("definindo usuario");
			System.err.println(usuario);
			funcionario.setUsuario(usuario);
			funcionario.setEndereco(endereco);
			System.out.println(funcionario);
			return funcionario;
		}
		return funcionario;
	}

	public void atualizarTabela() {
		DefaultTableModel tabela = new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "Cpf", "Telefone", "Data de Nascimento", "Genero", "Endereço" });
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		listFuncionario = funcionarioDAO.consultarTodos();
		System.out.println(listFuncionario);
		for (int i = 0; i < listFuncionario.size(); i++) {
			Funcionario funcionario = listFuncionario.get(i);
			tabela.addRow(new Object[] { funcionario.getNome(), funcionario.getCpf(), funcionario.getNumeroTelefone(),
					funcionario.getDatanasci(), funcionario.getGenero(), funcionario.getEndereco().getCep() });

		}
		table_1.setModel(tabela);
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
