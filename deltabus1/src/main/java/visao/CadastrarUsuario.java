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
	private JTextField textField_4;
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
		setBounds(100, 100, 800, 600);
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
		panel.setBounds(0, 0, 800, 46);
		add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 45, 10, 555);
		add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(10, 590, 790, 10);
		add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 0));
		panel_3.setBounds(790, 45, 10, 555);
		add(panel_3);

		textField = new JTextField();
		textField.setBounds(81, 110, 229, 23);
		add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(460, 110, 262, 23);
		add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNome.setBounds(81, 91, 46, 14);
		add(lblNome);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEmail.setBounds(460, 91, 46, 14);
		add(lblEmail);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCpf.setBounds(81, 169, 46, 14);
		add(lblCpf);

		/**********/
		MaskFormatter mascaraCpf = null;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtCpf = new JFormattedTextField(mascaraCpf);
		/**********/

		txtCpf.setBackground(new Color(255, 255, 255));
		txtCpf.setForeground(new Color(245, 245, 245));
		txtCpf.setColumns(10);
		txtCpf.setBounds(81, 188, 174, 23);
		add(txtCpf);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTelefone.setBounds(460, 171, 98, 14);
		add(lblTelefone);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(81, 270, 174, 23);
		add(textField_4);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(460, 189, 155, 23);
		add(textField_3);

		lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDataDeNascimento.setBounds(81, 252, 155, 14);
		add(lblDataDeNascimento);

		comboBox = new JComboBox();
		comboBox.setBounds(460, 269, 155, 23);
		add(comboBox);

		lblGnero = new JLabel("Gênero:");
		lblGnero.setFont(new Font("Dialog", Font.BOLD, 14));
		lblGnero.setBounds(460, 252, 155, 14);
		add(lblGnero);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(81, 355, 137, 23);
		add(textField_5);

		lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCep.setBounds(81, 336, 155, 14);
		add(lblCep);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(585, 355, 137, 23);
		add(textField_7);

		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(328, 355, 146, 23);
		add(comboBox_1);

		lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCidade.setBounds(328, 338, 155, 14);
		add(lblCidade);

		lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Dialog", Font.BOLD, 14));
		lblBairro.setBounds(584, 338, 155, 14);
		add(lblBairro);

		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(81, 437, 67, 23);
		add(comboBox_2);

		lblUf = new JLabel("UF:");
		lblUf.setFont(new Font("Dialog", Font.BOLD, 14));
		lblUf.setBounds(81, 420, 155, 14);
		add(lblUf);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(585, 437, 137, 23);
		add(textField_6);

		lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSenha.setBounds(585, 420, 155, 14);
		add(lblSenha);

		comboBox_3 = new JComboBox();
		comboBox_3.setBounds(328, 437, 137, 23);
		add(comboBox_3);

		lblFuno = new JLabel("Função:");
		lblFuno.setFont(new Font("Dialog", Font.BOLD, 14));
		lblFuno.setBounds(328, 416, 155, 23);
		add(lblFuno);

		btnNewButton = new RoundButton("Deletar");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(263, 513, 118, 30);
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
