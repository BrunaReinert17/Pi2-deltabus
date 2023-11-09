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
import controle.PedidoDAO;
import controle.UsuarioDAO;
import controle.VeiculoDAO;
import mensagens.AlteraSucesso;
import mensagens.CadastroErro;
import mensagens.CadastroErro1;
import mensagens.CadastroSucesso;
import mensagens.CadastroVeiculo;
import mensagens.ConfirmacaoDeletar;
import mensagens.Deletar1;
import mensagens.Deletar2;
import mensagens.InterfaceMensagemConfirmacao;
import mensagens.ErroAlterar;
import mensagens.LoginErro;
import modelo.Cliente;
import modelo.Endereco;
import modelo.FormaPagamento;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

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
				new String[] {"Cnpj", "Cliente", "Renavam", "Pagamento","Valor", "Qtde", "Data Compra"}));
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
		lblNome.setBounds(483, 111, 67, 14);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 18));
		add(lblNome);
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCpf.setBounds(271, 245, 46, 14);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblNome);
	
		txtNomeCliente = new JFormattedTextField();
		txtNomeCliente.setEditable(false);
		txtNomeCliente.setBounds(483, 136, 405, 30);
		txtNomeCliente.setFont(new Font("Dialog", Font.BOLD, 13));
		txtNomeCliente.setFont(new Font("Dialog", Font.BOLD, 13));
		txtNomeCliente.setColumns(10);
		add(txtNomeCliente);
		

		JLabel lblCnpj = new JLabel("CNPJ:");
		lblCnpj.setBounds(278, 122, 98, 14);
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
				ClienteDAO  clie = new ClienteDAO();
				String cnpj = txtCnpj.getText().replace("##", "").replace(".", "").replace("###", "").replace(".", "").replace("###", "").replace("/", "").replace("####", "").replace("-", "").replace("##", "").trim(); 
				Cliente clienteSelecionado = new Cliente(); 
			    clienteSelecionado.setCnpj(Long.parseLong(cnpj));
				clienteSelecionado = clie.selecionarCliente(clienteSelecionado);
				if(clienteSelecionado == null) {
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
		txtCnpj.setBounds(278, 137, 182, 30);
		txtCnpj.setText("");
		txtCnpj.setFont(new Font("Dialog", Font.BOLD, 13));
		/**********/
		txtCnpj.setBackground(new Color(255, 255, 255));
		txtCnpj.setForeground(new Color(0, 0, 0));
		txtCnpj.setColumns(10);
		add(txtCnpj);
		
		
		JButton btnLimparCampo = new RoundButton("Limpar Campo");
		btnLimparCampo.setBounds(968, 92, 84, 33);
		btnLimparCampo.setText("");
		btnLimparCampo.setBackground(new Color(245, 245, 245));
		btnLimparCampo.setForeground(Color.WHITE);
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
		
		
		JLabel lblQtde = new JLabel("Qtde:");
		lblQtde.setFont(new Font("Dialog", Font.BOLD, 13));
		lblQtde.setBounds(834, 220, 155, 14);
		add(lblQtde);
		
		JLabel lblRenavam = new JLabel("Veículo:");
		lblRenavam.setFont(new Font("Dialog", Font.BOLD, 13));
		lblRenavam.setBounds(275, 209, 155, 14);
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
		rndbtnBuscar.setBounds(579, 79, 75, 33);
		add(rndbtnBuscar);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 0));
		panel_4.setBounds(291, 397, 616, 249);
		add(panel_4);
		
		RoundButton btnCadastrar_1 = new RoundButton("Cadastrar");
		btnCadastrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Pedido p = verificarDados();
          	

				boolean pedidoRetornoCadastro = false;
            	

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
		btnCadastrar_1.setBounds(364, 661, 116, 33);
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
      

			
		btnDeletar2.setText("Deletar");
		btnDeletar2.setForeground(new Color(0, 0, 0));
		btnDeletar2.setFont(new Font("Dialog", Font.BOLD, 16));
		btnDeletar2.setBackground(new Color(0, 0, 0));
		btnDeletar2.setBounds(538, 661, 116, 33);
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
		lblTipopagamento.setBounds(540, 205, 155, 23);
		add(lblTipopagamento);
		
		/**********/
	
		txtQtdes = new JFormattedTextField();
		txtQtdes.addKeyListener(new KeyAdapter() {
	        public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
		          if (!((c >= '0') && (c <= '9') ||
		             (c == KeyEvent.VK_BACK_SPACE) ||
		             (c == KeyEvent.VK_DELETE))) {
		            getToolkit().beep();
		            e.consume();
		          }


			}
		});
		txtQtdes.setBounds(821, 228, 67, 30);
		txtQtdes.setColumns(10);
		txtQtdes.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtQtdes);
	
		
		/**********/
		cbPagamento = new JComboBox();

		cbPagamento.addItem(FormaPagamento.CARTAO);
		cbPagamento.addItem(FormaPagamento.DINHEIRO);
		cbPagamento.addItem(FormaPagamento.PIX);
		cbPagamento.addItem(FormaPagamento.OUTRO);
		cbPagamento.setBounds(538, 229, 89, 30);
		add(cbPagamento);
		
		
		
		
		
		/**********/
		MaskFormatter mascaraValor = null;
		try {
		    mascaraValor = new MaskFormatter(" ###,##");
		} catch (ParseException e3) {
		    e3.printStackTrace();
		}
		txtValorPago = new JFormattedTextField(mascaraValor);
		txtValorPago.setBounds(665, 228, 126, 30);
		txtValorPago.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtValorPago);
		/**********/
		
		
		
		
		JButton btnPesquisar_1 = new JButton("Pesquisar");
		btnPesquisar_1.setForeground(Color.WHITE);
		btnPesquisar_1.setFont(new Font("Dialog", Font.BOLD, 16));
		btnPesquisar_1.setBackground(new Color(0, 128, 128));
		btnPesquisar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPesquisar_1.setBounds(291, 371, 115, 23);
		add(btnPesquisar_1);

		RoundButton btnSalvar = new RoundButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*
				 * Pegar dado do componente da tela 
				 * **/
				
				Pedido p = verificarDados();
			
				
				p.setId_pedido(pedidoSelecionado.getId_pedido());
				
                  if (p != null) {
                	
               
      				/*
      				 * salvar alteracao no banco
      				 * **/
      				PedidoDAO pedidoDAO = new PedidoDAO();
                      boolean resultado = pedidoDAO.alterarPedido(p);
      				/*
      				 * Atualizar tabela
      				 * **/
      				atualizarTabela();
      				/*
      				 * Ocular salvar e motrar cadastrar
      				 * **/
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
                
                
                


				
			}
		});
		btnSalvar.setText("Salvar");
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSalvar.setBackground(new Color(0, 128, 128));
		btnSalvar.setBounds(364, 661, 116, 33);
		btnSalvar.setVisible(false);
		add(btnSalvar);
		
		RoundButton btnAlterarP = new RoundButton("Alterar");
		btnAlterarP.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				/***
				 * selecionar registro
				 * */
				int pos = table1.getSelectedRow();
				System.out.println(pos);
				pedidoSelecionado =listPedido.get(pos);

				

				/*
				 * preencher os campo
				 * 
				 * */
				System.out.println(pedidoSelecionado.getDataCompra().toString());
				txtCnpj.setText(String.valueOf(pedidoSelecionado.getCliente().getCnpj()));
				txtNomeCliente.setText(pedidoSelecionado.getCliente().getNome());
				cbVeiculo.setSelectedItem(pedidoSelecionado.getVeiculo());
				cbPagamento.setSelectedItem(pedidoSelecionado.getTipoPagamento());
				txtValorPago.setText(Double.toString(pedidoSelecionado.getValorPago()).replace(".", ","));
				txtQtdes.setText(Integer.toString(pedidoSelecionado.getQuantidade()));
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
				txtDataCompra.setText(pedidoSelecionado.getDataCompra().format(formatter));
				
				
				/*
				 * ocutar botaocadastro
				 * aparecer botao salvar
				 * 
				 * 
				 */
				btnSalvar.setVisible(true);
				btnCadastrar_1.setVisible(false);
				
				
			}
		});
		btnAlterarP.setForeground(Color.WHITE);
		btnAlterarP.setFont(new Font("Dialog", Font.BOLD, 16));
		btnAlterarP.setBackground(new Color(0, 128, 128));
		btnAlterarP.setBounds(705, 661, 116, 33);
		add(btnAlterarP);
		
		cbVeiculo = new JComboBox<Veiculo>();
		cbVeiculo.setBounds(278, 234, 145, 33);
		VeiculoDAO veiDao= new VeiculoDAO();
		ArrayList<Veiculo> listasVeiculos = veiDao.listar();
		for (Veiculo veiculo : listasVeiculos) {
			cbVeiculo.addItem(veiculo);
		}
		
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

	public Pedido verificarDados() {
		
		Pedido pedido = new Pedido();
		
		
		verificarCampo = "";
		
		
		String nomeCliente = txtNomeCliente.getText();
		System.out.println(txtValorPago.getText().replace(".", ","));
		double valorPago = Double.parseDouble(txtValorPago.getText().replace(",", "."));
		String cnpj = txtCnpj.getText().replace("##", "").replace(".", "").replace("###", "").replace(".", "").replace("###", "").replace("/", "").replace("####", "").replace("-", "").replace("##", ""); 
		Veiculo v = (Veiculo) cbVeiculo.getSelectedItem();
		pedido.setVeiculo(v);
		String quantidade = txtQtdes.getText();
		String datacompra = txtDataCompra.getText();
		FormaPagamento formapagamento =  (FormaPagamento) cbPagamento.getSelectedItem();
		
		
		
		if (valorPago == 0) {
			verificarCampo += "ValorPagar\n";
		} else {
			pedido.setValorPago(valorPago);
		}
		
		if (cnpj == null || cnpj.trim() == "" || cnpj.isEmpty() ) {
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
	DefaultTableModel tabela = new DefaultTableModel(new Object[][] {}, new String[] { "Cnpj", "Cliente", "Renavam", "Pagamento", "Valor", "Qtde", "Data Compra" });
	PedidoDAO pedidoDAO = new PedidoDAO();
	listPedido = pedidoDAO.listar();
	System.out.println(listPedido);
	for (int i = 0; i < listPedido.size(); i++) {
		Pedido pedido = listPedido.get(i);
		tabela.addRow(new Object[] { pedido.getCliente().getCnpj(), pedido.getCliente().getNome(), pedido.getVeiculo().getRenavam(),pedido.getTipoPagamento().getDescricao(),pedido.getValorPago(),pedido.getQuantidade(),pedido.getDataCompra()});

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
