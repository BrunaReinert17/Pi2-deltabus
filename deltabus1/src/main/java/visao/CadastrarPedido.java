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
import mensagens.ConfirmacaoDeletar;
import mensagens.Deletar1;
import mensagens.Deletar2;
import mensagens.InterfaceMensagemConfirmacao;
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
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.List;

public class CadastrarPedido extends JPanel {
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
	private JTextField txtRenavam;
	private JTextField txtDataCompra;
	private JTextField txtQtdes;
	private JComboBox cbPagamento;
	private JTextField txtValorPago;
	private ArrayList<Pedido> listPedido;

	public CadastrarPedido() {
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
		panel_5.setLayout(new BorderLayout());
		panel_5.setBounds(297, 405, 604, 234);
		add(panel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 604, 28);
		panel_5.add(scrollPane, BorderLayout.CENTER);
		
		
		

		table1 = new JTable();
		table1.setBackground(new Color(255, 255, 255));
		table1.setFont(new Font("Dialog", Font.BOLD, 14));
		
		table1.setModel(new DefaultTableModel(new Object[][] {},
				new String[] {"CNPJ", "Cliente", "Renavam", "Pagamento","Valor", "Qtde", "Data Compra"}));
		scrollPane.setViewportView(table1);
		
		
		lblLimpar = new JLabel("");
		lblLimpar.setBounds(933, 92, 110, 33);
		lblLimpar.setBackground(new Color(245, 245, 245));
		lblLimpar.setIcon(new ImageIcon(CadastrarPedido.class.getResource("/imagem/Icone4.png")));
		add(lblLimpar);
		JLabel lblNewLabel = new JLabel("Cadastrar Pedido");
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
		
		
		
		JLabel lblNome = new JLabel("Cliente:");
		lblNome.setBounds(652, 142, 67, 14);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 18));
		add(lblNome);
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCpf.setBounds(271, 245, 46, 14);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblNome);
	
		txtNomeCliente = new JFormattedTextField();
		txtNomeCliente.setBounds(652, 164, 249, 30);
		txtNomeCliente.setFont(new Font("Dialog", Font.BOLD, 13));
		txtNomeCliente.setFont(new Font("Dialog", Font.BOLD, 13));
		txtNomeCliente.setColumns(10);
		add(txtNomeCliente);
		

		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(291, 142, 98, 14);
		lblCnpj.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblCnpj);
		/**********/
		MaskFormatter mascaraCpf = null;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtCliente = new JFormattedTextField(mascaraCpf);
		txtCliente.setBounds(291, 164, 182, 30);
		txtCliente.setText("");
		txtCliente.setFont(new Font("Dialog", Font.BOLD, 13));
		/**********/
		txtCliente.setBackground(new Color(255, 255, 255));
		txtCliente.setForeground(new Color(0, 0, 0));
		txtCliente.setColumns(10);
		add(txtCliente);
		
		
		JButton btnLimparCampo = new RoundButton("Limpar Campo");
		btnLimparCampo.setBounds(968, 92, 84, 33);
		btnLimparCampo.setText("");
		btnLimparCampo.setBackground(new Color(245, 245, 245));
		btnLimparCampo.setForeground(Color.WHITE);
		btnLimparCampo.setFont(new Font("Dialog", Font.BOLD, 14));
		btnLimparCampo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNomeCliente.setText("");
				txtCliente.setText("");
				txtRenavam.setText("");
				txtValorPago.setText("");
				txtQtdes.setText("");
				txtDataCompra.setText("");
				cbPagamento.setSelectedIndex(-1);
			}
		});
		add(btnLimparCampo);
		
		
		JLabel lblQtde = new JLabel("Qtde:");
		lblQtde.setFont(new Font("Dialog", Font.BOLD, 13));
		lblQtde.setBounds(834, 220, 155, 14);
		add(lblQtde);
		
		JLabel lblRenavam = new JLabel("Renavam:");
		lblRenavam.setFont(new Font("Dialog", Font.BOLD, 13));
		lblRenavam.setBounds(291, 220, 155, 14);
		add(lblRenavam);

		txtRenavam = new JFormattedTextField();
		txtRenavam.setBounds(291, 239, 132, 30);
		txtRenavam.setText("");
		txtRenavam.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtRenavam);
		txtRenavam.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor R$:");
		lblValor.setFont(new Font("Dialog", Font.BOLD, 13));
		lblValor.setBounds(678, 220, 155, 14);
		add(lblValor);
		
		RoundButton rndbtnBuscar = new RoundButton("Limpar Campo");
		rndbtnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rndbtnBuscar.setText("Buscar");
		rndbtnBuscar.setForeground(Color.WHITE);
		rndbtnBuscar.setFont(new Font("Dialog", Font.BOLD, 14));
		rndbtnBuscar.setBackground(new Color(0, 128, 128));
		rndbtnBuscar.setBounds(529, 162, 75, 33);
		add(rndbtnBuscar);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 0));
		panel_4.setBounds(291, 397, 616, 249);
		add(panel_4);
		
		RoundButton btnCadastrar_1 = new RoundButton("Cadastrar");
		btnCadastrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
              Pedido pedido = verificarDados();
          	  System.out.println("erro1");

				boolean pedidoRetornoCadastro = false;
            	System.out.println("erro2");

                if (pedido != null) {
                	System.out.println("erro3");
                	
                	PedidoDAO pedidoDAO = new PedidoDAO();
                    boolean resultado = PedidoDAO.inserirPedido1(pedido);
                    
                	System.out.println("erro1");


                    if (resultado == true) {
                    	System.out.println("erro4");

                        CadastroVeiculo cadastro = new CadastroVeiculo("Cadastrado com Sucesso!");
                        cadastro.setLocationRelativeTo(null);
                        cadastro.setVisible(true);
        				atualizarTabela();
                       limparDados(); // Limpa os campos após o cadastro
                    } else {
                    	System.out.println("erro5");
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
		btnCadastrar_1.setBounds(551, 679, 116, 33);
		add(btnCadastrar_1);
		atualizarTabela();

		
		RoundButton btnDeletar2 = new RoundButton("Confirmar");
		btnDeletar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = table1.getSelectedRow();
				if (linhaSelecionada >= 0) {
			        Pedido pedido = listPedido.get(linhaSelecionada);

			       
                   ConfirmacaoDeletar confirmacao = new ConfirmacaoDeletar("Tem certeza que quer excluir o veículo?", new InterfaceMensagemConfirmacao() {
                	   
                	   

						@Override
						
						public void mensagemConfirmada() {
							PedidoDAO pedidoDAO = new PedidoDAO();
							
							if (PedidoDAO.excluirPedido1(pedido)) {
			                DefaultTableModel model = (DefaultTableModel) table1.getModel();
			                model.removeRow(linhaSelecionada);
			                atualizarTabela();
			            } else {
			                Deletar1 falha = new Deletar1("Falha ao excluir veiculo");
			                falha.setLocationRelativeTo(null);
			                falha.setVisible(true);
			            }
							
						}

						@Override
						public void mensagemCancelada() {
							
							
						}
			        	
			        });
			        confirmacao.setVisible(true);
			     
			    } else {
			        Deletar2 falha2 = new Deletar2("Selecione um usuario para excluir");
			        falha2.setLocationRelativeTo(null);
			        falha2.setVisible(true);
			    }
			}
		});
        atualizarTabela();

			
		btnDeletar2.setText("Deletar");
		btnDeletar2.setForeground(new Color(0, 0, 0));
		btnDeletar2.setFont(new Font("Dialog", Font.BOLD, 16));
		btnDeletar2.setBackground(new Color(245, 245, 245));
		btnDeletar2.setBounds(1084, 92, 84, 33);
		add(btnDeletar2);
		
		RoundButton rndbtnBuscar_1 = new RoundButton("Limpar Campo");
		rndbtnBuscar_1.setText("Buscar");
		rndbtnBuscar_1.setForeground(Color.WHITE);
		rndbtnBuscar_1.setFont(new Font("Dialog", Font.BOLD, 14));
		rndbtnBuscar_1.setBackground(new Color(0, 128, 128));
		rndbtnBuscar_1.setBounds(433, 237, 84, 33);
		add(rndbtnBuscar_1);
		
		JLabel lblDataCompra = new JLabel("Data de Compra :");
		lblDataCompra.setFont(new Font("Dialog", Font.BOLD, 13));
		lblDataCompra.setBounds(291, 292, 155, 14);
		add(lblDataCompra);
		/**********/
		MaskFormatter mascaraDatacompra = null;
		try {
			mascaraDatacompra = new MaskFormatter("##/##/####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtDataCompra = new JFormattedTextField(mascaraDatacompra);
		txtDataCompra.setFont(new Font("Dialog", Font.BOLD, 13));
		txtDataCompra.setColumns(10);
		txtDataCompra.setBounds(291, 310, 116, 30);
		add(txtDataCompra);
		/**********/
		JLabel lblTipopagamento = new JLabel("Pagamento:");
		lblTipopagamento.setFont(new Font("Dialog", Font.BOLD, 13));
		lblTipopagamento.setBounds(551, 220, 155, 14);
		add(lblTipopagamento);
		
		
		txtQtdes = new JFormattedTextField();
		txtQtdes.setBounds(834, 239, 67, 30);
		txtQtdes.setText("");
		txtQtdes.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtQtdes);
		txtQtdes.setColumns(10);
		
		ArrayList<String> fpagamento = new ArrayList<String>();
		fpagamento.add("");
		fpagamento.add("Cartão");
		fpagamento.add("Dinheiro");
		fpagamento.add("Pix");
		fpagamento.add("Outro");
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
		cbPagamento.setBounds(551, 240, 89, 30);
		add(cbPagamento);
		
		
		txtValorPago = new JFormattedTextField();
		txtValorPago.setBounds(678, 239, 126, 30);
		txtValorPago.setText("");
		txtValorPago.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtValorPago);
		txtValorPago.setColumns(10);
		
		JButton btnPesquisar_1 = new JButton("Pesquisar");
		btnPesquisar_1.setForeground(Color.WHITE);
		btnPesquisar_1.setFont(new Font("Dialog", Font.BOLD, 16));
		btnPesquisar_1.setBackground(new Color(0, 128, 128));
		btnPesquisar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpfpesquisa = txtRenavam.getText();
				atualizarTabela();
			}
		});
		btnPesquisar_1.setBounds(291, 371, 115, 23);
		add(btnPesquisar_1);
		atualizarTabela();
		
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
		
		
		String nomeCliente = txtNomeCliente.getText();
		String valorpagar = txtValorPago.getText();
		String cliente = txtCliente.getText().replace(".", "").replace("-", "");
		String renavam = txtRenavam.getText();
		String quantidade = txtQtdes.getText();
		String datacompra = txtDataCompra.getText();
		String formapagamento = (String) cbPagamento.getSelectedItem();
		
		
		if (nomeCliente == null || nomeCliente.trim() == "" || nomeCliente.isEmpty()) {
			verificarCampo += "Nome\n";
		} else {
			pedido.setNomeCliente(nomeCliente);
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
public void atualizarTabela() {
	DefaultTableModel tabela = new DefaultTableModel(new Object[][] {}, new String[] { "CNPJ", "Cliente", "Renavam", "Pagamento", "Valor", "Qtde", "Data Compra" });
	PedidoDAO pedidoDAO = new PedidoDAO();
	listPedido = pedidoDAO.listar();
	System.out.println(listPedido);
	for (int i = 0; i < listPedido.size(); i++) {
		Pedido pedido = listPedido.get(i);
		tabela.addRow(new Object[] { pedido.getCliente(), pedido.getNomeCliente(), pedido.getRenavam(),pedido.getTipoPagamento(),pedido.getValorPago(),pedido.getQuantidade(),pedido.getDataCompra()});

	}
	table1.setModel(tabela);
}
	public void limparDados() {
		txtNomeCliente.setText("");
		txtCliente.setText("");
		txtRenavam.setText("");
		txtValorPago.setText("");
		txtQtdes.setText("");
		txtDataCompra.setText("");
		cbPagamento.setSelectedIndex(-1);
	}
}
