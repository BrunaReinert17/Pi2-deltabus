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
import mensagens.CadastroErro;
import mensagens.CadastroErro1;
import mensagens.CadastroSucesso;
import mensagens.LoginErro;
import modelo.Endereco;
import modelo.Funcionario;
import modelo.Usuario;
import utilidades.RoundButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.AncestorEvent;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class CadastrarVenda extends JPanel {
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtDataDeNascimento;
	private JLabel lblCep;
	private JTextField txtBairro;
	private JLabel lblBairro;
	private JLabel lblBairro_1;
	private JLabel lblFuno;
	private JButton bntDeletar;
	private JButton btnCadastrar;
	// Variaveis atribuidas
	private String verificarCampo;
	private JTextField textField;
	private JLabel lblLimpar;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table1;
	private JTextField textField_4;
	private JTextField textField_1;

	public CadastrarVenda() {
		setLocale("Login");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 1200, 800);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 102));
		contentPane.setForeground(new Color(0, 102, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(220, 220, 220));
		panel_5.setLayout(null);
		panel_5.setBounds(284, 363, 604, 234);
		add(panel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 604, 28);
		panel_5.add(scrollPane);
		

		table1 = new JTable();
		table1.setBackground(new Color(255, 255, 255));
		table1.setFont(new Font("Dialog", Font.BOLD, 14));
		
		table1.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "CPF", "CNPJ", "Cliente", "Renavam", "Id Veiculo", "Valor R$", "Qtde" }));
		scrollPane.setViewportView(table1);
		
		
		lblLimpar = new JLabel("");
		lblLimpar.setBounds(1035, 92, 110, 33);
		lblLimpar.setBackground(new Color(245, 245, 245));
		lblLimpar.setIcon(new ImageIcon(CadastrarVenda.class.getResource("/imagem/Icone4.png")));
		add(lblLimpar);
		JLabel lblNewLabel = new JLabel("Cadastrar Vendas");
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
		txtNome.setBounds(636, 161, 249, 30);
		txtNome.setFont(new Font("Dialog", Font.BOLD, 13));
		txtNome.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtNome);
		txtNome.setColumns(10);
		JLabel lblNome = new JLabel("Cliente:");
		lblNome.setBounds(636, 137, 67, 14);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 18));
		add(lblNome);
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCpf.setBounds(271, 245, 46, 14);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblNome);

		JLabel lblCpf1 = new JLabel("CPF ou CNPJ:");
		lblCpf1.setBounds(284, 137, 98, 14);
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
		txtCpf.setBounds(284, 161, 182, 30);
		txtCpf.setText("");
		txtCpf.setFont(new Font("Dialog", Font.BOLD, 13));
		/**********/
		txtCpf.setBackground(new Color(255, 255, 255));
		txtCpf.setForeground(new Color(0, 0, 0));
		txtCpf.setColumns(10);
		add(txtCpf);
		
		
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
				txtBairro.setText("");
			}
		});
		add(btnLimparCampo);
		
		JLabel lblBairro_1_1 = new JLabel("Id Veiculo:");
		lblBairro_1_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblBairro_1_1.setBounds(441, 241, 155, 14);
		add(lblBairro_1_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Dialog", Font.BOLD, 13));
		textField_2.setColumns(10);
		textField_2.setBounds(666, 261, 84, 30);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Dialog", Font.BOLD, 13));
		textField_3.setColumns(10);
		textField_3.setBounds(801, 261, 84, 30);
		add(textField_3);
		
		JLabel lblQuantidade = new JLabel("Qtde:");
		lblQuantidade.setFont(new Font("Dialog", Font.BOLD, 13));
		lblQuantidade.setBounds(801, 241, 155, 14);
		add(lblQuantidade);
		
		JLabel lblBairro_1_1_1 = new JLabel("Renavam:");
		lblBairro_1_1_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblBairro_1_1_1.setBounds(284, 241, 155, 14);
		add(lblBairro_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Dialog", Font.BOLD, 13));
		textField_4.setColumns(10);
		textField_4.setBounds(284, 261, 116, 30);
		add(textField_4);
		
		JLabel lblValorR = new JLabel("Valor R$:");
		lblValorR.setFont(new Font("Dialog", Font.BOLD, 13));
		lblValorR.setBounds(666, 241, 155, 14);
		add(lblValorR);
		
		RoundButton rndbtnBuscar = new RoundButton("Limpar Campo");
		rndbtnBuscar.setText("Buscar");
		rndbtnBuscar.setForeground(Color.WHITE);
		rndbtnBuscar.setFont(new Font("Dialog", Font.BOLD, 14));
		rndbtnBuscar.setBackground(new Color(0, 128, 128));
		rndbtnBuscar.setBounds(490, 159, 67, 33);
		add(rndbtnBuscar);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 0));
		panel_4.setBounds(278, 351, 616, 253);
		add(panel_4);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Dialog", Font.BOLD, 13));
		textField_1.setColumns(10);
		textField_1.setBounds(441, 261, 116, 30);
		add(textField_1);
		
		RoundButton btnCadastrar_1 = new RoundButton("Confirmar");
		btnCadastrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrar_1.setText("Cadastrar");
		btnCadastrar_1.setForeground(Color.WHITE);
		btnCadastrar_1.setFont(new Font("Dialog", Font.BOLD, 16));
		btnCadastrar_1.setBackground(new Color(0, 128, 128));
		btnCadastrar_1.setBounds(440, 661, 116, 33);
		add(btnCadastrar_1);
		
		RoundButton btnDeletar2 = new RoundButton("Confirmar");
		btnDeletar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeletar2.setText("Deletar");
		btnDeletar2.setForeground(Color.WHITE);
		btnDeletar2.setFont(new Font("Dialog", Font.BOLD, 16));
		btnDeletar2.setBackground(new Color(0, 0, 0));
		btnDeletar2.setBounds(617, 661, 116, 33);
		add(btnDeletar2);
		
		RoundButton rndbtnBuscar_1 = new RoundButton("Limpar Campo");
		rndbtnBuscar_1.setText("Buscar");
		rndbtnBuscar_1.setForeground(Color.WHITE);
		rndbtnBuscar_1.setFont(new Font("Dialog", Font.BOLD, 14));
		rndbtnBuscar_1.setBackground(new Color(0, 128, 128));
		rndbtnBuscar_1.setBounds(567, 259, 67, 33);
		add(rndbtnBuscar_1);
		setContentPane(contentPane);
		contentPane.setLayout(null);
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
		
		String bairro = txtBairro.getText();
		
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
		
		if (verificarCampo.trim() == "") {
			funcionario.setUsuario(usuario);
			funcionario.setEndereco(endereco);
			return funcionario;
		}
		return null;
	}

	public void limparDados() {
		txtNome.setText("");
		txtCpf.setText("");

		txtBairro.setText("");
	}
}