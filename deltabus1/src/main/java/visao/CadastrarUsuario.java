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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtCpf;
	private JTextField txtDataDeNascimento;
	private JTextField textField_3;
	private JLabel lblDataDeNascimento;
	private JComboBox comboBox;
	private JLabel lblGnero;
	private JTextField textField_5;
	private JLabel lblCep;
	private JTextField textField_7;
	private JComboBox comboBox_1;
	private JLabel lblCidade;
	private JLabel lblBairro;
	private JComboBox comboBox_2;
	private JLabel lblUf;
	private JTextField textField_6;
	private JLabel lblSenha;
	private JComboBox comboBox_3;
	private JLabel lblFuno;
	private JButton btnNewButton;
	private JButton btnConfirmar;

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

		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.BOLD, 18));
		textField.setBounds(178, 176, 278, 30);
		add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Dialog", Font.BOLD, 18));
		textField_1.setBounds(656, 176, 307, 30);
		add(textField_1);
		textField_1.setColumns(10);

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

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(81, 270, 174, 23);
		add(textField_4);

		textField_3 = new JTextField();
		textField_3.setFont(new Font("Dialog", Font.BOLD, 18));
		textField_3.setColumns(10);
		textField_3.setBounds(656, 265, 205, 29);
		add(textField_3);
		
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
		txtDataDeNascimento = new JFormattedTextField(mascaraCpf);
		txtCpf.setFont(new Font("Dialog", Font.PLAIN, 12));
		/**********/
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Dialog", Font.BOLD, 18));
		comboBox.setBounds(656, 357, 182, 31);
		add(comboBox);

		lblGnero = new JLabel("Gênero:");
		lblGnero.setFont(new Font("Dialog", Font.BOLD, 18));
		lblGnero.setBounds(656, 340, 155, 14);
		add(lblGnero);

		textField_5 = new JTextField();
		textField_5.setFont(new Font("Dialog", Font.BOLD, 18));
		textField_5.setColumns(10);
		textField_5.setBounds(178, 447, 194, 30);
		add(textField_5);

		lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCep.setBounds(178, 428, 155, 14);
		add(lblCep);

		textField_7 = new JTextField();
		textField_7.setFont(new Font("Dialog", Font.BOLD, 18));
		textField_7.setColumns(10);
		textField_7.setBounds(855, 447, 182, 30);
		add(textField_7);

		comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Dialog", Font.BOLD, 18));
		comboBox_1.setBounds(545, 447, 199, 30);
		add(comboBox_1);

		lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCidade.setBounds(545, 430, 155, 14);
		add(lblCidade);

		lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Dialog", Font.BOLD, 18));
		lblBairro.setBounds(854, 430, 155, 14);
		add(lblBairro);

		comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Dialog", Font.BOLD, 18));
		comboBox_2.setBounds(178, 541, 98, 30);
		add(comboBox_2);

		lblUf = new JLabel("UF:");
		lblUf.setFont(new Font("Dialog", Font.BOLD, 18));
		lblUf.setBounds(178, 524, 155, 14);
		add(lblUf);

		textField_6 = new JTextField();
		textField_6.setFont(new Font("Dialog", Font.BOLD, 18));
		textField_6.setColumns(10);
		textField_6.setBounds(855, 541, 182, 30);
		add(textField_6);

		lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSenha.setBounds(855, 524, 155, 14);
		add(lblSenha);

		comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Dialog", Font.BOLD, 18));
		comboBox_3.setBounds(545, 541, 155, 30);
		add(comboBox_3);

		lblFuno = new JLabel("Função:");
		lblFuno.setFont(new Font("Dialog", Font.BOLD, 18));
		lblFuno.setBounds(545, 520, 155, 23);
		add(lblFuno);

		btnNewButton = new RoundButton("Deletar");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(423, 674, 137, 33);
		add(btnNewButton);

		btnConfirmar = new RoundButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConfirmar.setForeground(Color.BLACK);
		btnConfirmar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnConfirmar.setBackground(Color.BLACK);
		btnConfirmar.setBounds(420, 513, 118, 30);
		add(btnConfirmar);

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
