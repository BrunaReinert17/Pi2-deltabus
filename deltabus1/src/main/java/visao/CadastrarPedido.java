package visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controle.ClienteDAO;
import controle.PedidoDAO;
import controle.VeiculoDAO;
import mensagens.AlteraSucesso;
import mensagens.Alterar1;
import mensagens.CadastroErro1;
import mensagens.CadastroVeiculo;
import mensagens.ConfirmacaoAlterar;
import mensagens.ConfirmacaoDeletar;
import mensagens.Deletar1;
import mensagens.Deletar2;
import mensagens.ErroAlterar;
import mensagens.InterfaceMensagemConfirmacao;
import modelo.Cliente;
import modelo.FormaPagamento;
import modelo.Pedido;
import modelo.Veiculo;
import utilidades.RoundButton;

public class CadastrarPedido extends JPanel {
	private JTextField txtNomeCliente;
	private JTextField txtCnpj;
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
	private JTextField txtDataCompra;
	private JTextField txtQtdes;
	private JComboBox cbPagamento;
	private JTextField txtValorPago;
	private ArrayList<Pedido> listPedido;
	private Pedido pedidoSelecionado;
	private JComboBox<Veiculo> cbVeiculo;

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

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(CadastrarPedido.class.getResource("/imagem/deletar.png")));
		lblNewLabel_1.setBounds(1108, 92, 58, 33);
		add(lblNewLabel_1);

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
				new String[] { "Cnpj", "Cliente", "Renavam", "Pagamento", "Valor", "Qtde", "Data Compra" }));
		scrollPane.setViewportView(table1);

		lblLimpar = new JLabel("");
		lblLimpar.setBounds(986, 92, 98, 33);
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
		lblNome.setBounds(538, 158, 67, 14);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 18));
		add(lblNome);
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCpf.setBounds(271, 245, 46, 14);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblNome);

		txtNomeCliente = new JFormattedTextField();
		txtNomeCliente.setEditable(false);
		txtNomeCliente.setBounds(538, 173, 363, 30);
		txtNomeCliente.setFont(new Font("Dialog", Font.BOLD, 13));
		txtNomeCliente.setFont(new Font("Dialog", Font.BOLD, 13));
		txtNomeCliente.setColumns(10);
		add(txtNomeCliente);

		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(297, 158, 98, 14);
		lblCnpj.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblCnpj);
		/**********/
		MaskFormatter mascaraCnpj = null;
		try {
			mascaraCnpj = new MaskFormatter("##.###.###/####-##");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtCnpj = new JFormattedTextField(mascaraCnpj);
		txtCnpj.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				ClienteDAO clie = new ClienteDAO();
				String cnpj = txtCnpj.getText().replace("##", "").replace(".", "").replace("###", "").replace(".", "")
						.replace("###", "").replace("/", "").replace("####", "").replace("-", "").replace("##", "")
						.trim();
				Cliente clienteSelecionado = new Cliente();
				clienteSelecionado.setCnpj(Long.parseLong(cnpj));
				clienteSelecionado = clie.selecionarCliente(clienteSelecionado);
				if (clienteSelecionado == null) {
					CadastroErro1 erro1 = new CadastroErro1("Cnpj inválido, tente novamente!");
					erro1.setLocationRelativeTo(null);
					erro1.setVisible(true);
					txtCnpj.transferFocus();
					txtCnpj.setText("");
				} else {
					txtNomeCliente.setText(clienteSelecionado.getNome());
				}

			}
		});
		txtCnpj.setBounds(297, 173, 171, 30);
		txtCnpj.setText("");
		txtCnpj.setFont(new Font("Dialog", Font.BOLD, 13));
		/**********/
		txtCnpj.setBackground(new Color(255, 255, 255));
		txtCnpj.setForeground(new Color(0, 0, 0));
		txtCnpj.setColumns(10);
		add(txtCnpj);

		JButton btnLimparCampo = new RoundButton("Limpar Campo");
		btnLimparCampo.setBounds(1048, 92, 41, 33);
		btnLimparCampo.setText("");
		btnLimparCampo.setBackground(new Color(245, 245, 245));
		btnLimparCampo.setForeground(new Color(245, 245, 245));
		btnLimparCampo.setFont(new Font("Dialog", Font.BOLD, 14));
		btnLimparCampo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNomeCliente.setText("");
				txtCnpj.setText("");
				cbVeiculo.setSelectedItem(null);
				txtValorPago.setText("");
				txtQtdes.setText("");
				txtDataCompra.setText("");
				cbPagamento.setSelectedIndex(-1);
			}
		});
		add(btnLimparCampo);

		JLabel lblQtde = new JLabel("Quantidade:");
		lblQtde.setFont(new Font("Dialog", Font.BOLD, 13));
		lblQtde.setBounds(297, 318, 155, 14);
		add(lblQtde);

		JLabel lblRenavam = new JLabel("Veículo:");
		lblRenavam.setFont(new Font("Dialog", Font.BOLD, 13));
		lblRenavam.setBounds(297, 228, 155, 14);
		add(lblRenavam);

		/**********/
		MaskFormatter mascaraRenavam = null;
		try {
			mascaraRenavam = new MaskFormatter("###########");
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		/**********/

		JLabel lblValor = new JLabel("Valor R$:");
		lblValor.setFont(new Font("Dialog", Font.BOLD, 13));
		lblValor.setBounds(775, 228, 155, 14);
		add(lblValor);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 0));
		panel_4.setBounds(291, 397, 616, 249);
		add(panel_4);

		RoundButton btnCadastrar_1 = new RoundButton("Cadastrar");
		btnCadastrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Pedido p = verificarDados(null);

				if (p != null) {

					PedidoDAO pedidoDAO = new PedidoDAO();
					boolean resultado = PedidoDAO.inserirPedido1(p);

					if (resultado == true) {

						CadastroVeiculo cadastro = new CadastroVeiculo("Cadastrado com Sucesso!");
						cadastro.setLocationRelativeTo(null);
						cadastro.setVisible(true);
						atualizarTabela();
						limparDados(); // Limpa os campos após o cadastro
					} else {

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
		btnCadastrar_1.setBounds(480, 683, 116, 33);
		add(btnCadastrar_1);
		atualizarTabela();

		RoundButton btnDeletar2 = new RoundButton("Confirmar");
		btnDeletar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = table1.getSelectedRow();
				if (linhaSelecionada >= 0) {
					Pedido pedido = listPedido.get(linhaSelecionada);

					ConfirmacaoDeletar confirmacao = new ConfirmacaoDeletar("Tem certeza que quer excluir o veículo?",
							new InterfaceMensagemConfirmacao() {

								@Override

								public void mensagemConfirmada() {
									PedidoDAO pedidoDAO = new PedidoDAO();

									if (PedidoDAO.excluirPedido1(pedido)) {
										DefaultTableModel model = (DefaultTableModel) table1.getModel();
										model.removeRow(linhaSelecionada);

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
					confirmacao.setLocationRelativeTo(null);
					confirmacao.setVisible(true);

				} else {
					Deletar2 falha2 = new Deletar2("Selecione um usuario para excluir");
					falha2.setLocationRelativeTo(null);
					falha2.setVisible(true);
				}
			}
		});

		btnDeletar2.setText("");
		btnDeletar2.setForeground(new Color(245, 245, 245));
		btnDeletar2.setFont(new Font("Dialog", Font.BOLD, 16));
		btnDeletar2.setBackground(new Color(245, 245, 245));
		btnDeletar2.setBounds(1120, 92, 41, 33);
		add(btnDeletar2);

		JLabel lblDataCompra = new JLabel("Data de Compra :");
		lblDataCompra.setFont(new Font("Dialog", Font.BOLD, 13));
		lblDataCompra.setBounds(426, 318, 155, 14);
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
		txtDataCompra.setBounds(426, 343, 116, 30);
		add(txtDataCompra);
		/**********/
		JLabel lblTipopagamento = new JLabel("Pagamento:");
		lblTipopagamento.setFont(new Font("Dialog", Font.BOLD, 13));
		lblTipopagamento.setBounds(610, 224, 155, 23);
		add(lblTipopagamento);

		/**********/

		txtQtdes = new JFormattedTextField();
		txtQtdes.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}

			}
		});
		txtQtdes.setBounds(297, 343, 78, 30);
		txtQtdes.setColumns(10);
		txtQtdes.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtQtdes);

		/**********/
		cbPagamento = new JComboBox();
		cbPagamento.setFont(new Font("Dialog", Font.BOLD, 13));

		cbPagamento.addItem(FormaPagamento.CARTAO);
		cbPagamento.addItem(FormaPagamento.DINHEIRO);
		cbPagamento.addItem(FormaPagamento.PIX);
		cbPagamento.addItem(FormaPagamento.OUTRO);
		cbPagamento.setBounds(610, 244, 89, 30);
		add(cbPagamento);

		/**********/
		MaskFormatter mascaraValor = null;
		try {
			mascaraValor = new MaskFormatter(" ###,##");
		} catch (ParseException e3) {
			e3.printStackTrace();
		}
		txtValorPago = new JFormattedTextField(mascaraValor);
		txtValorPago.setEditable(false);
		txtValorPago.setBounds(775, 244, 126, 30);
		txtValorPago.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtValorPago);
		/**********/

		/*
		 * EDITAR
		 */
		RoundButton btnSalvar = new RoundButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				/*
				 * Pegar dado do componente da tela
				 **/

				Pedido p = verificarDados(pedidoSelecionado);

				p.setId_pedido(pedidoSelecionado.getId_pedido());

				ConfirmacaoAlterar confirmacao = new ConfirmacaoAlterar("Tem certeza que quer excluir o veículo?",
						new InterfaceMensagemConfirmacao() {

							public void mensagemConfirmada() {

								if (p != null) {

									/*
									 * salvar alteracao no banco
									 **/
									PedidoDAO pedidoDAO = new PedidoDAO();
									boolean resultado = pedidoDAO.alterarPedido(p);
									/*
									 * Atualizar tabela
									 **/
									atualizarTabela();
									/*
									 * Ocular salvar e motrar cadastrar
									 **/
									btnSalvar.setVisible(false);
									btnCadastrar_1.setVisible(true);

									if (resultado == true) {

										AlteraSucesso alterar = new AlteraSucesso("Usuário alterado com Sucesso!");
										alterar.setLocationRelativeTo(null);
										alterar.setVisible(true);
										limparDados(); // Limpa os campos após o cadastro

									} else {
										ErroAlterar erro1 = new ErroAlterar("Erro de alteração, tente novamente!");
										erro1.setLocationRelativeTo(null);
										erro1.setVisible(true);
									}
								}

								return;

							}

							public void mensagemCancelada() {

							}

						});
				confirmacao.setLocationRelativeTo(null);
				confirmacao.setVisible(true);

			}
		});
		btnSalvar.setText("Salvar");
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSalvar.setBackground(new Color(0, 128, 128));
		btnSalvar.setBounds(480, 683, 116, 33);
		btnSalvar.setVisible(false);
		add(btnSalvar);

		RoundButton btnAlterarP = new RoundButton("Alterar");
		btnAlterarP.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				/***
				 * selecionar registro
				 */
				int pos = table1.getSelectedRow();

				if (pos >= 0) {
					System.out.println(pos);
					pedidoSelecionado = listPedido.get(pos);

					/*
					 * preencher os campo
					 * 
					 */
					System.out.println(pedidoSelecionado.getDataCompra().toString());
					txtCnpj.setText(String.valueOf(pedidoSelecionado.getCliente().getCnpj()));
					txtNomeCliente.setText(pedidoSelecionado.getCliente().getNome());
					cbVeiculo.setSelectedItem(pedidoSelecionado.getVeiculo());
					cbPagamento.setSelectedItem(pedidoSelecionado.getTipoPagamento());
					txtValorPago.setText(Double.toString(pedidoSelecionado.getVeiculo().getPreco()).replace(".", ","));
					txtQtdes.setText(Integer.toString(pedidoSelecionado.getQuantidade()));
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
					txtDataCompra.setText(pedidoSelecionado.getDataCompra().format(formatter));

					/*
					 * ocutar botaocadastro aparecer botao salvar
					 * 
					 * 
					 */
					btnSalvar.setVisible(true);
					btnCadastrar_1.setVisible(false);

				} else {
					Alterar1 falha1 = new Alterar1("Selecione uma linha da lista para alterar");
					falha1.setLocationRelativeTo(null);
					falha1.setVisible(true);
				}
			}
		});
		btnAlterarP.setForeground(Color.WHITE);
		btnAlterarP.setFont(new Font("Dialog", Font.BOLD, 16));
		btnAlterarP.setBackground(new Color(0, 0, 0));
		btnAlterarP.setBounds(637, 683, 116, 33);
		add(btnAlterarP);

		cbVeiculo = new JComboBox<Veiculo>();

		cbVeiculo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Veiculo v = (Veiculo) cbVeiculo.getSelectedItem();
				if(v!= null) {
					txtValorPago.setText(String.valueOf(v.getPreco()).replace(".", ","));
				}

			}
		});
		cbVeiculo.setFont(new Font("Dialog", Font.BOLD, 13));
		cbVeiculo.setBounds(297, 244, 265, 30);
		VeiculoDAO veiDao = new VeiculoDAO();
		ArrayList<Veiculo> listasVeiculos = veiDao.listar();
		for (Veiculo veiculo : listasVeiculos) {
			cbVeiculo.addItem(veiculo);
		}
		Veiculo v = listasVeiculos.get(0);
		txtValorPago.setText(String.valueOf(v.getPreco()).replace(".", ","));

		add(cbVeiculo);

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

	public Pedido verificarDados(Pedido pedidoSelecionado) {

		Pedido pedido = null;
		if (pedidoSelecionado == null) {
			pedido = new Pedido(); // pegar ao inves o pedido que foi selecionado
		} else {
			pedido = this.pedidoSelecionado;
		}

		verificarCampo = "";

		String nomeCliente = txtNomeCliente.getText();

		System.out.println(txtValorPago.getText().replace(".", ","));

		double valorPago = Double.parseDouble(txtValorPago.getText().replace(",", "."));

		String cnpj = txtCnpj.getText().replace("##", "").replace(".", "").replace("###", "").replace(".", "")
				.replace("###", "").replace("/", "").replace("####", "").replace("-", "").replace("##", "");

		Veiculo v = (Veiculo) cbVeiculo.getSelectedItem();
		pedido.setVeiculo(v);
		String quantidade = txtQtdes.getText();
		String datacompra = txtDataCompra.getText();
		FormaPagamento formapagamento = (FormaPagamento) cbPagamento.getSelectedItem();

		if (valorPago == 0) {
			verificarCampo += "ValorPagar\n";
		} else {
			pedido.setValorPago(valorPago);
		}

		if (cnpj == null || cnpj.trim() == "" || cnpj.isEmpty()) {
			verificarCampo += "Cnpj\n";
		} else {

			Cliente c = new Cliente();
			c.setCnpj(Long.parseLong(cnpj));
			ClienteDAO cliDao = new ClienteDAO();
			c = cliDao.selecionarCliente(c);
			pedido.setCliente(c);
		}

		if (quantidade == null || quantidade.trim() == "" || quantidade.isEmpty()) {
			verificarCampo += "Quantidade\n";
		} else {
			pedido.setQuantidade(Integer.parseInt(quantidade));
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
		pedido.setTipoPagamento(formapagamento);

		return pedido;
	}

	public void atualizarTabela() {
		DefaultTableModel tabela = new DefaultTableModel(new Object[][] {},
				new String[] { "Cnpj", "Cliente", "Renavam", "Pagamento", "Valor", "Qtde", "Data Compra" });
		PedidoDAO pedidoDAO = new PedidoDAO();
		listPedido = pedidoDAO.listar();
		System.out.println(listPedido);
		for (int i = 0; i < listPedido.size(); i++) {
			Pedido pedido = listPedido.get(i);
			tabela.addRow(new Object[] { pedido.getCliente().getCnpj(), pedido.getCliente().getNome(),
					pedido.getVeiculo().getRenavam(), pedido.getTipoPagamento().getDescricao(), pedido.getValorPago(),
					pedido.getQuantidade(), pedido.getDataCompra() });

		}
		table1.setModel(tabela);
	}

	public void limparDados() {
		txtNomeCliente.setText("");
		txtCnpj.setText("");
		cbVeiculo.setSelectedItem(null);
		txtValorPago.setText("");
		txtQtdes.setText("");
		txtDataCompra.setText("");
		cbPagamento.setSelectedIndex(-1);
	}
}
