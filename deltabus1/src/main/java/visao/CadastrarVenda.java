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
import controle.PedidoDAO;
import controle.UsuarioDAO;
import controle.VeiculoDAO;
import mensagens.CadastroErro;
import mensagens.CadastroErro1;
import mensagens.CadastroSucesso;
import mensagens.CadastroVeiculo;
import mensagens.LoginErro;
import modelo.Endereco;
import modelo.Funcionario;
import modelo.Pedido;
import modelo.Usuario;
import modelo.Veiculo;
import utilidades.RoundButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.AncestorEvent;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Panel;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Choice;
import java.awt.List;

public class CadastrarVenda extends JPanel {
	private JTextField txtNomeCliente;
	private JTextField txtCliente;
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
	private JTable table1;
	private JTextField textRenavam;
	private JTextField textDataCompra;
	private JTextField textQuantidades;
	private JComboBox cbPagamento;
	private JTextField textValorpagar;

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
		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(617, 140, 249, 30);
		txtNomeCliente.setFont(new Font("Dialog", Font.BOLD, 13));
		txtNomeCliente.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtNomeCliente);
		txtNomeCliente.setColumns(10);
		JLabel lblNome = new JLabel("Cliente:");
		lblNome.setBounds(617, 115, 67, 14);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 18));
		add(lblNome);
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCpf.setBounds(271, 245, 46, 14);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblNome);

		JLabel lblCpf1 = new JLabel("CPF ou CNPJ:");
		lblCpf1.setBounds(278, 115, 98, 14);
		lblCpf1.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblCpf1);
		/**********/
		MaskFormatter mascaraCpf = null;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtCliente = new JFormattedTextField(mascaraCpf);
		txtCliente.setBounds(278, 137, 182, 30);
		txtCliente.setText("");
		txtCliente.setFont(new Font("Dialog", Font.BOLD, 13));
		/**********/
		txtCliente.setBackground(new Color(255, 255, 255));
		txtCliente.setForeground(new Color(0, 0, 0));
		txtCliente.setColumns(10);
		add(txtCliente);
		
		
		JButton btnLimparCampo = new RoundButton("Limpar Campo");
		btnLimparCampo.setBounds(1061, 92, 84, 33);
		btnLimparCampo.setText("");
		btnLimparCampo.setBackground(new Color(245, 245, 245));
		btnLimparCampo.setForeground(Color.WHITE);
		btnLimparCampo.setFont(new Font("Dialog", Font.BOLD, 14));
		btnLimparCampo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNomeCliente.setText("");
				txtCliente.setText("");
				txtBairro.setText("");
			}
		});
		add(btnLimparCampo);
		
		
		JLabel lblQuantidade = new JLabel("Qtde:");
		lblQuantidade.setFont(new Font("Dialog", Font.BOLD, 13));
		lblQuantidade.setBounds(845, 199, 155, 14);
		add(lblQuantidade);
		
		JLabel lblBairro_1_1_1 = new JLabel("Renavam:");
		lblBairro_1_1_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblBairro_1_1_1.setBounds(284, 199, 155, 14);
		add(lblBairro_1_1_1);
		
		textRenavam = new JTextField();
		textRenavam.setFont(new Font("Dialog", Font.BOLD, 13));
		textRenavam.setColumns(10);
		textRenavam.setBounds(284, 228, 116, 30);
		add(textRenavam);
		
		JLabel lblValorR = new JLabel("Valor R$:");
		lblValorR.setFont(new Font("Dialog", Font.BOLD, 13));
		lblValorR.setBounds(711, 199, 155, 14);
		add(lblValorR);
		
		RoundButton rndbtnBuscar = new RoundButton("Limpar Campo");
		rndbtnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rndbtnBuscar.setText("Buscar");
		rndbtnBuscar.setForeground(Color.WHITE);
		rndbtnBuscar.setFont(new Font("Dialog", Font.BOLD, 14));
		rndbtnBuscar.setBackground(new Color(0, 128, 128));
		rndbtnBuscar.setBounds(470, 135, 98, 33);
		add(rndbtnBuscar);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 0));
		panel_4.setBounds(278, 351, 616, 253);
		add(panel_4);
		
		RoundButton btnCadastrar_1 = new RoundButton("Confirmar");
		btnCadastrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
              Pedido pedido = verificarDados();
				
				boolean pedidoRetornoCadastro = false;
				
				

                if (pedido != null) {
                	
                	PedidoDAO pedidoDAO = new PedidoDAO();
                    boolean resultado = PedidoDAO.inserirPedido1(pedido);
                   

                    if (resultado == true) {
                        // O veículo foi cadastrado com sucesso
                        CadastroVeiculo cadastro = new CadastroVeiculo("Veículo Cadastrado com Sucesso!");
                        cadastro.setLocationRelativeTo(null);
                        cadastro.setVisible(true);
                       limparDados(); // Limpa os campos após o cadastro
                    } else {
                        // Ocorreu um erro durante o cadastro
                        CadastroErro1 erro1 = new CadastroErro1("Erro de Cadastro, tente novamente!");
                        erro1.setLocationRelativeTo(null);
                        erro1.setVisible(true);
                    }
                }
				
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
		rndbtnBuscar_1.setBounds(420, 226, 117, 33);
		add(rndbtnBuscar_1);
		
		JLabel lbldatacompra = new JLabel("Data de Compra :");
		lbldatacompra.setFont(new Font("Dialog", Font.BOLD, 13));
		lbldatacompra.setBounds(284, 285, 155, 14);
		add(lbldatacompra);
		/**********/
		MaskFormatter mascaraDatacompra = null;
		try {
			mascaraDatacompra = new MaskFormatter("##/##/####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		textDataCompra = new JFormattedTextField(mascaraDatacompra);
		textDataCompra.setFont(new Font("Dialog", Font.BOLD, 13));
		textDataCompra.setColumns(10);
		textDataCompra.setBounds(284, 310, 116, 30);
		add(textDataCompra);
		/**********/
		JLabel lblTipopagamento = new JLabel("TipoPagamento :");
		lblTipopagamento.setFont(new Font("Dialog", Font.BOLD, 13));
		lblTipopagamento.setBounds(548, 199, 155, 14);
		add(lblTipopagamento);
		
		textQuantidades = new JTextField();
		textQuantidades.setBounds(845, 228, 88, 26);
		add(textQuantidades);
		textQuantidades.setColumns(10);
		
		ArrayList<String> fpagamento = new ArrayList<String>();
		fpagamento.add("");
		fpagamento.add("catao");
		fpagamento.add("dinheiro");
		fpagamento.add("pix");
		fpagamento.add("outro");
		 cbPagamento = new JComboBox();
		cbPagamento.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				for (int i = 0; i <  fpagamento.size(); i++) {
					cbPagamento.addItem(fpagamento.get(i));

				}
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbPagamento.setBounds(558, 233, 94, 22);
		add(cbPagamento);
		
		textValorpagar = new JTextField();
		textValorpagar.setBounds(693, 228, 98, 30);
		add(textValorpagar);
		textValorpagar.setColumns(10);
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

	public Pedido verificarDados() {
		
		Pedido pedido = new Pedido();
		
		
		verificarCampo = "";
		
		
		String nome = txtNomeCliente.getText();
		String valorpagar = textValorpagar.getText();
		String cliente = txtCliente.getText().replace(".", "").replace("-", "");
		String renavam = textRenavam.getText();
		String quantidade = textQuantidades.getText();
		String datacompra = textDataCompra.getText();
		String formapagamento = (String) cbPagamento.getSelectedItem();
		
		
		if (nome == null || nome.trim() == "" || nome.isEmpty()) {
			verificarCampo += "Nome\n";
		} else {
			pedido.setNomeCliente(nome);
		}
		
		if (valorpagar == null || valorpagar.trim() == "" || valorpagar.isEmpty()) {
			verificarCampo += "Nome\n";
		} else {
			pedido.setValorPago(Double.valueOf(valorpagar));
		}
		
		
		if (cliente == null || cliente.trim() == "" || cliente.isEmpty()) {
			verificarCampo += "CPF\n";
		} else {
			String cpf = String.valueOf(cliente);
			pedido.setCliente(cpf);
		}
		
		if (renavam == null || renavam.trim() == "" || renavam.isEmpty()) {
			verificarCampo += "Renavam\n";
		} else {
			pedido.setRenavam(renavam);
		}
		
		if (quantidade == null || quantidade.trim() == "" || quantidade.isEmpty()) {
			verificarCampo += "Renavam\n";
		} else {
			pedido.setRenavam(renavam);
		}
		 
		if (datacompra == null || datacompra.trim() == "" || datacompra.isEmpty()) {
			verificarCampo += "Data\n";
		} else {
			String dataTest = datacompra.replace("/", "").trim();
			if (dataTest.length() == 0) {
				verificarCampo += "Data\n";
			} else {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate dta = LocalDate.parse(datacompra, formatter);
				dta.format(formatter);
				// tratamento de data para ver se é menor
				LocalDate dataAtual = LocalDate.now();
				if (dataAtual.isBefore(dta)) {
					verificarCampo += "Informe uma data anterior";
				} else {
					pedido.setDataCompra(dta);
				}
			}
		}
		
		if (formapagamento == null || formapagamento.trim() == "" || formapagamento.isEmpty()) {
			verificarCampo += "Cor\n";
		} else {
			
			pedido.setTipoPagamento(formapagamento);
		}
		
		
		return pedido;
	}

	public void limparDados() {
		txtNomeCliente.setText("");
		txtCliente.setText("");

		txtBairro.setText("");
	}
}