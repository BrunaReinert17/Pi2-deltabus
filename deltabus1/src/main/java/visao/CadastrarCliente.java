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

import controle.ClienteDAO;
import controle.EnderecoDAO;
import controle.FuncionarioDAO;

import mensagens.CadastroErro;
import mensagens.CadastroErro1;
import mensagens.CadastroSucesso;
import mensagens.Limpar;
import mensagens.CadastroCliente;

import modelo.Cliente;
import modelo.Funcionario;

import modelo.Endereco;
import utilidades.RoundButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JComboBox;


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
	private JComboBox cbUf;
	private JComboBox cbCidade;



	// Variaveis atribuidas
	
	private String verificarCampo;
	private JTextField textField;
	private JLabel lblLimpar;
	private String cpf;
	private JTextField textCnpj;
	private JTextField txtBairro;
	private JTextField txtRua;

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
		lblnumeroTelefone.setBounds(683, 267, 98, 14);
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
		txtnumeroTelefone.setBounds(684, 290, 182, 30);
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


		lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Dialog", Font.BOLD, 13));
		lblBairro.setBounds(768, 428, 155, 14);



		btnCadastrar = new RoundButton("Confirmar");
		btnCadastrar.setBounds(495, 641, 132, 33);
		btnCadastrar.setText("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Cliente cliente = verificarDados();
				
				EnderecoDAO enderecoDAO = new EnderecoDAO();
				Endereco endereco = enderecoDAO.consultandoEndereco(cliente.getEndereco());
				boolean ende = false;
				System.out.println("Erro2");
				if (endereco == null) {
					ende = enderecoDAO.inserirEndereco(cliente.getEndereco());
				}
				
				boolean verificarRetornoCadastro = false;
				if (cliente != null) {
					
					ClienteDAO clienteDAO = new ClienteDAO();
					boolean resultado = clienteDAO.inserirCliente(cliente);
					
				 if (resultado == true) {
					 CadastroCliente cadastro = new CadastroCliente("Cliente cadastrado com sucesso!");
					 cadastro.setLocationRelativeTo(null);
					 cadastro.setVisible(true);
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

		JButton btnLimparCampo = new RoundButton("Limpar Campo");
		btnLimparCampo.setBounds(1061, 92, 84, 33);
		btnLimparCampo.setText("");
		btnLimparCampo.setBackground(new Color(245, 245, 245));
		btnLimparCampo.setForeground(Color.WHITE);
		btnLimparCampo.setFont(new Font("Dialog", Font.BOLD, 14));
		btnLimparCampo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpar limparDados = new Limpar("Tem certeza de que deseja limpar os dados?");
				limparDados.setLocationRelativeTo(null);
				limparDados.setVisible(true);
			}
		});
		add(btnLimparCampo);
		
		
		JLabel lblCpf2 = new JLabel("CPF");
		lblCpf2.setFont(new Font("Dialog", Font.BOLD, 13));
		lblCpf2.setBounds(252, 267, 155, 14);
		add(lblCpf2);
		/**********/
		MaskFormatter mascaraCpf2 = null;
		try {
			mascaraCpf2 = new MaskFormatter("###.###.###-##");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtCpf = new JFormattedTextField(mascaraCpf2);
		txtCpf.setBounds(252, 290, 182, 30);
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
		textCnpj.setBounds(684, 383, 235, 30);
		textCnpj.setText("");
		textCnpj.setFont(new Font("Dialog", Font.BOLD, 13));
		add(textCnpj);
		textCnpj.setColumns(10);
		/**********/
		
		
		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setFont(new Font("Dialog", Font.BOLD, 13));
		lblCnpj.setBounds(684, 365, 155, 14);
		add(lblCnpj);
		
		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Dialog", Font.BOLD, 13));
		txtBairro.setColumns(10);
		txtBairro.setBounds(684, 476, 182, 30);
		add(txtBairro);
		

		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Dialog", Font.BOLD, 13));
		lblCidade.setBounds(252, 458, 155, 14);
		add(lblCidade);
		
		JLabel lblBairro_1 = new JLabel("Bairro:");
		lblBairro_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblBairro_1.setBounds(684, 457, 155, 14);
		add(lblBairro_1);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Dialog", Font.BOLD, 13));
		lblRua.setBounds(252, 532, 155, 14);
		add(lblRua);
		
		txtRua = new JTextField();
		txtRua.setFont(new Font("Dialog", Font.BOLD, 13));
		txtRua.setColumns(10);
		txtRua.setBounds(252, 551, 182, 31);
		add(txtRua);
		
		ArrayList<String> uf = new ArrayList<>();
		uf.add("");
		uf.add("SC");
		uf.add("SP");
		uf.add("RS");
		uf.add("PR");
		cbUf = new JComboBox();
		cbUf.setBounds(684, 551, 98, 30);
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
		lblUf.setBounds(684, 532, 49, 14);
		add(lblUf);
		
		ArrayList<String> cidade = new ArrayList<>();
		cidade.add("");
		cidade.add("São José");
		cidade.add("Ilhota");
		cidade.add("Gaspar");
		cidade.add("Blumenau");
		cbCidade = new JComboBox();
		cbCidade.setBounds(252, 476, 171, 30);
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
	    String cpf = txtCpf.getText().replaceAll("[^0-9]", ""); // Remove caracteres não numéricos
	    String cnpj = textCnpj.getText().replaceAll("[^0-9]", "");
	    String numeroTelefone = txtnumeroTelefone.getText();
	    String cep = txtCep.getText().replaceAll("[^0-9]", "");
		String UF = (String) cbUf.getSelectedItem();
		String bairro = txtBairro.getText();
		String cidade = (String) cbCidade.getSelectedItem();
		String rua = txtRua.getText();


	    if (nome == null || nome.trim().isEmpty()) {
	        verificarCampo += "Nome\n";
	    } else {
	        cliente.setNome(nome);
	    }

	    if (email == null || email.trim().isEmpty()) {
	        verificarCampo += "Email\n";
	    } else {
	        cliente.setEmail(email);
	    }
	    if (cpf == null || cpf.trim().isEmpty()) {
	        verificarCampo += "Email\n";
	    } else {
	        cliente.setCpf(cpf);
	    }
	    if (nome == null || nome.trim().isEmpty()) {
	        verificarCampo += "Nome\n";
	    } else {
	        cliente.setCnpj(Long.parseLong(cnpj));
	    }
	    
	    if (numeroTelefone == null || numeroTelefone.trim().isEmpty()) {
	        verificarCampo += "numeroTelefone\n";
	    } else {
	        cliente.setNumeroTelefone(numeroTelefone);
	    }

	    if (cep == null || cep.trim().isEmpty()) {
	        verificarCampo += "numeroTelefone\n";
	    } else {
	        cliente.setCep(Long.parseLong(cep));
	    }
	    if (UF == null || UF.trim() == "" || UF.isEmpty()) {
			verificarCampo += "UF\n";
		} else {
			endereco.setUf(UF);
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
		if (verificarCampo.trim() == "") {
			cliente.setCliente(cliente);
			cliente.setEndereco(endereco);
			return cliente;
		}
	    
        return cliente;
	}


		public void limparDados() {
			txtNome.setText("");
			txtEmail.setText("");
			txtnumeroTelefone.setText("");
			txtCep.setText("");
			txtCpf.setText("");
			textCnpj.setText("");
			txtRua.setText("");
			txtBairro.setText("");
			cbCidade.setSelectedIndex(-1);
			cbUf.setSelectedIndex(-1);
		}
	}