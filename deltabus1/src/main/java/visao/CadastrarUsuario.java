package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import utilidades.RoundButton;

public class CadastrarUsuario extends JPanel {
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtCpf;
	private JTextField txtDataDeNascimento;
	private JTextField txtTelefone;
	private JLabel lblDataDeNascimento;
	private JComboBox cbGenero;
	private JLabel lblGnero;
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
		txtNome.setBounds(178, 176, 278, 30);
		add(txtNome);
		txtNome.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Dialog", Font.BOLD, 18));
		txtEmail.setBounds(656, 176, 307, 30);
		add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNome.setBounds(178, 157, 67, 14);
		add(lblNome);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 18));
		lblEmail.setBounds(656, 157, 67, 14);
		add(lblEmail);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCpf.setBounds(178, 245, 46, 14);
		add(lblCpf);

		/**********/
		MaskFormatter mascaraCpf = null;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtCpf = new JFormattedTextField(mascaraCpf);
		txtCpf.setFont(new Font("Dialog", Font.BOLD, 18));
		/**********/

		txtCpf.setBackground(new Color(255, 255, 255));
		txtCpf.setForeground(new Color(0, 0, 0));
		txtCpf.setColumns(10);
		txtCpf.setBounds(178, 264, 205, 30);
		add(txtCpf);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTelefone.setBounds(656, 247, 98, 14);
		add(lblTelefone);

		
		/**********/
		MaskFormatter mascaraTelefone = null;
		try {
			mascaraCpf = new MaskFormatter("(##)#####-####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtTelefone = new JFormattedTextField(mascaraCpf);
		/**********/
		
		txtTelefone.setFont(new Font("Dialog", Font.BOLD, 18));
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(656, 265, 205, 29);
		add(txtTelefone);
		
		lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Dialog", Font.BOLD, 18));
		lblDataDeNascimento.setBounds(178, 340, 194, 14);
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
		
		cbGenero = new JComboBox();
		cbGenero.setFont(new Font("Dialog", Font.BOLD, 18));
		cbGenero.setBounds(656, 357, 182, 31);
		add(cbGenero);

		lblGnero = new JLabel("Gênero:");
		lblGnero.setFont(new Font("Dialog", Font.BOLD, 18));
		lblGnero.setBounds(656, 340, 155, 14);
		add(lblGnero);

	
		/**********/
		MaskFormatter mascaraCep = null;
		try {
			mascaraCpf = new MaskFormatter("#####-###");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtCep  = new JFormattedTextField(mascaraCpf);
		/**********/
		
		txtCep.setFont(new Font("Dialog", Font.BOLD, 18));
		txtCep.setColumns(10);
		txtCep.setBounds(178, 447, 149, 30);
		add(txtCep);

		lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCep.setBounds(178, 428, 155, 14);
		add(lblCep);

		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Dialog", Font.BOLD, 18));
		txtBairro.setColumns(10);
		txtBairro.setBounds(855, 447, 182, 30);
		add(txtBairro);

		cbCidade = new JComboBox();
		cbCidade.setFont(new Font("Dialog", Font.BOLD, 18));
		cbCidade.setBounds(545, 447, 199, 30);
		add(cbCidade);

		lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCidade.setBounds(545, 430, 155, 14);
		add(lblCidade);

		lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Dialog", Font.BOLD, 18));
		lblBairro.setBounds(854, 430, 155, 14);
		add(lblBairro);

		cbUf = new JComboBox();
		cbUf.setFont(new Font("Dialog", Font.BOLD, 18));
		cbUf.setBounds(178, 541, 98, 30);
		add(cbUf);

		lblUf = new JLabel("UF:");
		lblUf.setFont(new Font("Dialog", Font.BOLD, 18));
		lblUf.setBounds(178, 524, 155, 14);
		add(lblUf);

		txtSenha = new JTextField();
		txtSenha.setFont(new Font("Dialog", Font.BOLD, 18));
		txtSenha.setColumns(10);
		txtSenha.setBounds(855, 541, 182, 30);
		add(txtSenha);

		lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSenha.setBounds(855, 524, 155, 14);
		add(lblSenha);

		cbFuncao = new JComboBox();
		cbFuncao.setFont(new Font("Dialog", Font.BOLD, 18));
		cbFuncao.setBounds(545, 541, 155, 30);
		add(cbFuncao);

		lblFuno = new JLabel("Função:");
		lblFuno.setFont(new Font("Dialog", Font.BOLD, 18));
		lblFuno.setBounds(545, 520, 155, 23);
		add(lblFuno);

		bntDeletar = new RoundButton("Deletar");
		bntDeletar.setFont(new Font("Dialog", Font.BOLD, 14));
		bntDeletar.setForeground(Color.WHITE);
		bntDeletar.setBackground(new Color(0, 0, 0));
		bntDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bntDeletar.setBounds(423, 674, 132, 33);
		add(bntDeletar);

		btnConfirmar = new RoundButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnConfirmar.setBackground(Color.BLACK);
		btnConfirmar.setBounds(612, 674, 132, 31);
		add(btnConfirmar);
		
		
		txtDataNasci.setBounds(178, 376, 149, 29);
		add(txtDataNasci);
		txtDataNasci.setColumns(10);

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
}
