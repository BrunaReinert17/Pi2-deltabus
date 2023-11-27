package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

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
import controle.VeiculoDAO;
import mensagens.AlteraSucesso;
import mensagens.AlteracaoNaoRealizada;
import mensagens.Alterar1;
import mensagens.AlterarSucesso1;
//import mensagens.Alterar1;
//import mensagens.AlterarSucesso1;
import mensagens.CadastroErro;

import mensagens.CadastroErro1;
import mensagens.CadastroErro2;
import mensagens.CadastroSucesso;
import mensagens.CadastroVeiculo;
import mensagens.ConfirmacaoAlterar;
import mensagens.ConfirmacaoDeletar;
import mensagens.Deletar1;
import mensagens.Deletar2;
import mensagens.ErroAlterar;
import mensagens.InterfaceMensagemConfirmacao;
import modelo.Endereco;
import modelo.Funcionario;
import modelo.Usuario;
import modelo.Veiculo;
import utilidades.RoundButton;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.AncestorEvent;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CadastrarVeiculo extends JPanel {

	private JTextField txtRenavam;
	private JTextField txtPlaca;
	private JTextField txtDataDeNascimento;
	private JLabel lblSituacao;
	private JComboBox cbMarca;
	private JLabel lblCor;
	private JLabel lblFrota;
	private JLabel lblBairro;
	private JLabel lblPlaca;
	private JLabel lblAcessorios;
	private JLabel lblFuno;
	private JLabel lblCombustivel;
	private JButton bntDeletar;

	// Variaveis atribuidas
	private String verificarCampo;
	private JLabel txtAno;
	private JTextField textField;
	private JLabel lblLimpar;
	private JTextField textLotacao;
	private JTextField textAno;
	private JTextField textPreco;
	private JComboBox cbCor;
	private JComboBox cbFrota;
	private JComboBox cbCombustivel;
	private JComboBox cbAcessorio;
	private JComboBox cbKlm;
	private JComboBox cbSituacao;
	private JComboBox cbModelo;
	private JComboBox cbModelo_1;
	private ArrayList<Veiculo> listVei;
	private JTable table;
	private JPanel panel_4;
	private JButton btnSalvar1;
	private JButton btnAl;
	private Veiculo pedidoSelecionado;

	
	public CadastrarVeiculo() {
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
		lblNewLabel_1.setIcon(new ImageIcon(CadastrarVeiculo.class.getResource("/imagem/deletar.png")));
		lblNewLabel_1.setBounds(1108, 80, 59, 59);
		add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(207, 404, 773, 250);
		add(scrollPane);

		table = new JTable();
		table.setFont(new Font("Dialog", Font.BOLD, 14));
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);

		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Combutível", "Marca", "Modelo", "Placa",
				"Frota", "Lotação", "Renavam", "Cor", "Acessórios", "Ano", "Preço", "Situação" }));
		scrollPane.setViewportView(table);

		lblLimpar = new JLabel("");
		lblLimpar.setBounds(988, 92, 110, 33);
		lblLimpar.setBackground(new Color(245, 245, 245));
		lblLimpar.setIcon(new ImageIcon(CadastrarUsuario.class.getResource("/imagem/Icone4.png")));
		add(lblLimpar);

		JLabel lblNewLabel = new JLabel("Adicionar Veiculos");
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

		MaskFormatter renavam = null;
		try {
			renavam = new MaskFormatter("###########");
		} catch (ParseException e3) {
			e3.printStackTrace();
		}
		txtRenavam = new JFormattedTextField(renavam);
		txtRenavam.setBounds(207, 164, 167, 30);
		txtRenavam.setText("");
		txtRenavam.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtRenavam);
		txtRenavam.setColumns(10);

		MaskFormatter mascaraPlacaOnibus = null;
		try {
			mascaraPlacaOnibus = new MaskFormatter("UUU#U##");
			// "U" representa letras e "#" representa dígitos.
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtPlaca = new JFormattedTextField(mascaraPlacaOnibus);
		txtPlaca.setBounds(802, 164, 167, 30);
		txtPlaca.setText("");
		txtPlaca.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtPlaca);
		txtPlaca.setColumns(10);
		/**********/

		JLabel lblRenavam = new JLabel("Renavam:");
		lblRenavam.setBounds(207, 145, 67, 14);
		lblRenavam.setFont(new Font("Dialog", Font.BOLD, 18));
		add(lblRenavam);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCpf.setBounds(271, 245, 46, 14);
		lblRenavam.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblRenavam);

		JLabel lblModelo = new JLabel("Modelo: ");
		lblModelo.setBounds(603, 145, 84, 14);
		lblModelo.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblModelo);

		JLabel lblLotacao = new JLabel("Lotação: ");
		lblLotacao.setBounds(668, 222, 67, 14);
		lblLotacao.setFont(new Font("Dialog", Font.BOLD, 18));
		lblLotacao.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblLotacao);

		lblSituacao = new JLabel("Situação:");
		lblSituacao.setBounds(376, 295, 67, 14);
		lblSituacao.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSituacao.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblSituacao);

		ArrayList<String> marca = new ArrayList<String>();
		marca.add("");
		marca.add("Volkswagen");
		marca.add("Mercedes");
		marca.add("Agrale");

		cbMarca = new JComboBox();
		cbMarca.setBounds(407, 163, 167, 33);
		cbMarca.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				for (int i = 0; i < marca.size(); i++) {
					cbMarca.addItem(marca.get(i));

				}
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbMarca.setFont(new Font("Dialog", Font.BOLD, 13));
		add(cbMarca);

		ArrayList<String> cor = new ArrayList<String>();
		cor.add("");
		cor.add("Azul");
		cor.add("Verde");
		cor.add("Preto");

		cbCor = new JComboBox();
		cbCor.setBounds(306, 241, 127, 33);
		cbCor.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				for (int i = 0; i < cor.size(); i++) {
					cbCor.addItem(cor.get(i));

				}
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbCor.setFont(new Font("Dialog", Font.BOLD, 13));
		add(cbCor);

		lblCor = new JLabel("Cor  :");
		lblCor.setBounds(218, 327, 42, 14);

		lblCor = new JLabel("Cor:");
		lblCor.setBounds(306, 222, 42, 14);
		lblCor.setFont(new Font("Dialog", Font.BOLD, 13));
		lblCor.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblCor);

		lblFrota = new JLabel("Frota: ");
		lblFrota.setBounds(764, 222, 67, 14);
		lblFrota.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblFrota);

		lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(802, 145, 59, 14);
		lblPlaca.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblPlaca);

		lblAcessorios = new JLabel("Acessórios:");
		lblAcessorios.setBounds(469, 222, 84, 14);
		lblAcessorios.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblAcessorios);

		lblCombustivel = new JLabel("Combustível: ");
		lblCombustivel.setBounds(207, 291, 90, 23);
		lblCombustivel.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblCombustivel);

		JButton btnLimparCampo = new RoundButton("Limpar Campo");
		btnLimparCampo.setBounds(1048, 92, 41, 33);
		btnLimparCampo.setText("");
		btnLimparCampo.setBackground(new Color(245, 245, 245));
		btnLimparCampo.setForeground(new Color(245, 245, 245));
		btnLimparCampo.setFont(new Font("Dialog", Font.BOLD, 14));
		btnLimparCampo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
           
				txtRenavam.setText("");

				txtPlaca.setText("");

				textLotacao.setText("");

				textAno.setText("");

				textPreco.setText("");

				cbModelo_1.setSelectedIndex(-1);

				cbCor.setSelectedIndex(-1);

				cbFrota.setSelectedIndex(-1);

				cbCombustivel.setSelectedIndex(-1);

				cbMarca.setSelectedIndex(-1);

				cbAcessorio.setSelectedIndex(-1);

			cbSituacao.setSelectedIndex(-1);

				
				 txtRenavam.setText("");

				 txtPlaca.setText("");

			 textLotacao.setText("");
					
			 textAno.setText("");

				 textPreco.setText("");
				 
				 cbModelo.setSelectedIndex(-1);
					
					cbCor.setSelectedIndex(-1);
					
					cbFrota.setSelectedIndex(-1);
					
					cbCombustivel.setSelectedIndex(-1);
					
                    cbMarca.setSelectedIndex(-1);
					
					cbAcessorio.setSelectedIndex(-1);
					
					cbKlm.setSelectedIndex(-1);
					
					cbSituacao.setSelectedIndex(-1);
					
					
			
			}
		});
		add(btnLimparCampo);

		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(407, 145, 98, 14);
		lblMarca.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblMarca);

		txtAno = new JLabel("Ano:");
		txtAno.setBounds(207, 222, 42, 14);
		txtAno.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtAno);

		ArrayList<String> modelo = new ArrayList<String>();
		modelo.add("");
		modelo.add("Scania");
		modelo.add("marcopolo");
		modelo.add("Volvo");
		modelo.add("Comil");

		cbModelo_1 = new JComboBox();
		cbModelo_1.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				for (int i = 0; i < modelo.size(); i++) {
					cbModelo_1.addItem(modelo.get(i));

				}
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbModelo_1.setFont(new Font("Dialog", Font.BOLD, 13));
		cbModelo_1.setBounds(603, 163, 167, 33);
		add(cbModelo_1);

		textLotacao = new JTextField();
		textLotacao.setFont(new Font("Dialog", Font.BOLD, 13));
		textLotacao.setColumns(10);
		textLotacao.setBounds(668, 242, 67, 30);
		add(textLotacao);

		ArrayList<String> frota = new ArrayList<String>();
		frota.add("");
		frota.add("Turismo");
		frota.add("Escolar");
		frota.add("Especial");
		frota.add("Viagem");

		cbFrota = new JComboBox();
		cbFrota.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				for (int i = 0; i < frota.size(); i++) {
					cbFrota.addItem(frota.get(i));

				}
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbFrota.setFont(new Font("Dialog", Font.BOLD, 13));
		cbFrota.setBounds(764, 241, 205, 33);
		add(cbFrota);

		ArrayList<String> combustivel = new ArrayList<String>();
		combustivel.add("");
		combustivel.add("Diesel");
		combustivel.add("GNC");
		combustivel.add("GNL");
		combustivel.add("Etanol");

		cbCombustivel = new JComboBox();
		cbCombustivel.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				for (int i = 0; i < combustivel.size(); i++) {
					cbCombustivel.addItem(combustivel.get(i));

				}
			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbCombustivel.setFont(new Font("Dialog", Font.BOLD, 13));
		cbCombustivel.setBounds(207, 312, 132, 33);
		add(cbCombustivel);

		ArrayList<String> acessorio = new ArrayList<String>();
		acessorio.add("");
		acessorio.add("Ar-condicionado");
		acessorio.add("Poltronas reclináveis");
		acessorio.add("Banheiros");
		acessorio.add("WiFi");

		cbAcessorio = new JComboBox();

		for (int i = 0; i < acessorio.size(); i++) {
			cbAcessorio.addItem(acessorio.get(i));
		}

		cbAcessorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});

		cbAcessorio.setFont(new Font("Dialog", Font.BOLD, 13));
		cbAcessorio.setBounds(469, 241, 167, 33);
		add(cbAcessorio);
         
		MaskFormatter ano = null;
		try {
			ano = new MaskFormatter("####");
		} catch (ParseException e3) {
			e3.printStackTrace();
		}
		
		textAno = new JFormattedTextField(ano);
		textAno = new JTextField();
		textAno.setFont(new Font("Dialog", Font.BOLD, 13));
		textAno.setColumns(10);
		textAno.setBounds(207, 242, 67, 30);
		add(textAno);

		ArrayList<String> situacao = new ArrayList<String>();
		situacao.add("");
		situacao.add("Novo");
		situacao.add("Seminovo");

		cbSituacao = new JComboBox();

		for (int i = 0; i < situacao.size(); i++) {
			cbSituacao.addItem(situacao.get(i));
		}

		cbSituacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbSituacao.setFont(new Font("Dialog", Font.BOLD, 13));
		cbSituacao.setBounds(376, 312, 153, 33);
		add(cbSituacao);

		MaskFormatter mascaraValor = null;
		try {
			mascaraValor = new MaskFormatter("###,##");
		} catch (ParseException e3) {
			e3.printStackTrace();
		}
		textPreco = new JFormattedTextField(mascaraValor);
		textPreco.setFont(new Font("Dialog", Font.BOLD, 13));
		textPreco.setColumns(10);
		textPreco.setBounds(573, 313, 110, 30);
		add(textPreco);

		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setFont(new Font("Dialog", Font.BOLD, 13));
		lblPreco.setBounds(573, 295, 67, 14);
		add(lblPreco);

		RoundButton btnCadastrar = new RoundButton("Cadastrar");// criando objeto
		btnCadastrar.addActionListener(new ActionListener() {// adicionando ação ao botao
			public void actionPerformed(ActionEvent e) {

				Veiculo veiculo = verificarDados();// metodo

				if (veiculo != null) {

					VeiculoDAO veiculoDAO = new VeiculoDAO();// instancia
					boolean resultado = veiculoDAO.inserirVeiculo(veiculo);

					if (resultado == true) {
						// O veículo foi cadastrado com sucesso
						CadastroVeiculo cadastro = new CadastroVeiculo("Veículo Cadastrado com Sucesso!");
						cadastro.setLocationRelativeTo(null);
						cadastro.setVisible(true);
						atualizarTabela();
						limparDados(); // Limpa os campos após o cadastro
					} else {
						// Ocorreu um erro durante o cadastro
						CadastroErro1 erro1 = new CadastroErro1("Erro de Cadastro, tente novamente!");
						erro1.setLocationRelativeTo(null);
						erro1.setVisible(true);
					}
				} else {
					CadastroErro2 erro2 = new CadastroErro2("Veriique os campos e tente novamente!");
					erro2.setLocationRelativeTo(null);
					erro2.setVisible(true);
				}

			}
		});

		btnCadastrar.setText("Cadastrar");
		atualizarTabela();

		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnCadastrar.setBackground(new Color(0, 128, 128));
		btnCadastrar.setBounds(435, 691, 132, 33);
		add(btnCadastrar);

		RoundButton btnAl = new RoundButton("Alterar");
		btnAl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int pos = table.getSelectedRow();

				if (pos >= 0) {
					System.out.println(pos);
					pedidoSelecionado = listVei.get(pos);

					cbMarca.setSelectedItem(pedidoSelecionado.getMarca());
					txtRenavam.setText((pedidoSelecionado.getRenavam()));
					cbModelo_1.setSelectedItem(pedidoSelecionado.getModelo());
					txtPlaca.setText((pedidoSelecionado.getPlaca()));
					textAno.setText(Integer.toString(pedidoSelecionado.getAno()));
					cbCor.setSelectedItem(pedidoSelecionado.getCor());
					cbAcessorio.setSelectedItem(pedidoSelecionado.getAcessorios());
					textLotacao.setText(Integer.toString(pedidoSelecionado.getLotacao()));
					cbFrota.setSelectedItem(pedidoSelecionado.getTipoFrota());
					cbCombustivel.setSelectedItem(pedidoSelecionado.getTipoCombustivel());
					cbSituacao.setSelectedItem(pedidoSelecionado.getSituacao());
					textPreco.setText(Double.toString(pedidoSelecionado.getPreco()).replace(".", ","));

					btnSalvar1.setVisible(true);
					btnCadastrar.setVisible(false);

				} else {
					Alterar1 falha1 = new Alterar1("Selecione uma linha da lista para alterar");
					falha1.setLocationRelativeTo(null);
					falha1.setVisible(true);
				}
			}
		});
		btnAl.setText("Alterar");
		btnAl.setForeground(Color.WHITE);
		btnAl.setFont(new Font("Dialog", Font.BOLD, 16));
		btnAl.setBackground(new Color(0, 0, 0));
		btnAl.setBounds(629, 691, 132, 33);
		add(btnAl);

		btnSalvar1 = new RoundButton("Salvar");
		btnSalvar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Veiculo v = verificarDados();

				v.setIdVeiculo(pedidoSelecionado.getIdVeiculo());

				ConfirmacaoAlterar confirmacao = new ConfirmacaoAlterar("Tem certeza que quer excluir o veículo?",
						new InterfaceMensagemConfirmacao() {

							public void mensagemConfirmada() {
								if (v != null) {

									/*
									 * salvar alteracao no banco
									 **/
									VeiculoDAO pedidoDAO = new VeiculoDAO();
									boolean resultado = VeiculoDAO.alterarVeiculo(v);
									/*
									 * Atualizar tabela
									 **/
									atualizarTabela();
									/*
									 * Ocular salvar e motrar cadastrar
									 **/
									btnSalvar1.setVisible(false);
									btnCadastrar.setVisible(true);

									if (resultado == true) {

										AlterarSucesso1 alterar = new AlterarSucesso1("Usuário alterado com Sucesso!");
										alterar.setLocationRelativeTo(null);
										alterar.setVisible(true);
										limparDados();
										
									} else {
										ErroAlterar erro1 = new ErroAlterar("Erro de alteração, tente novamente!");
										erro1.setLocationRelativeTo(null);
										erro1.setVisible(true);
									}
								}
							}

							public void mensagemCancelada() {

							}

						});
				confirmacao.setLocationRelativeTo(null);
				confirmacao.setVisible(true);

			}
		});
		btnSalvar1.setText("Salvar");
		btnSalvar1.setForeground(Color.WHITE);
		btnSalvar1.setFont(new Font("Dialog", Font.BOLD, 16));
		btnSalvar1.setBackground(new Color(0, 128, 128));
		btnSalvar1.setBounds(435, 691, 132, 33);
		add(btnSalvar1);

		RoundButton btnDeletar2 = new RoundButton("Deletar");
		btnDeletar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = table.getSelectedRow();
				if (linhaSelecionada >= 0) {
					Veiculo veiculo = listVei.get(linhaSelecionada);

					ConfirmacaoDeletar confirmacao = new ConfirmacaoDeletar("Tem certeza que quer excluir o veículo?",
							new InterfaceMensagemConfirmacao() {

								@Override

								public void mensagemConfirmada() {
									VeiculoDAO veiculoDAO = new VeiculoDAO();

									if (veiculoDAO.excluirVeiculo(veiculo)) {
										DefaultTableModel model = (DefaultTableModel) table.getModel();
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
		btnDeletar2.setText("");
		btnDeletar2.setForeground(new Color(245, 245, 245));
		btnDeletar2.setFont(new Font("Dialog", Font.BOLD, 16));
		btnDeletar2.setBackground(new Color(245, 245, 245));
		btnDeletar2.setBounds(1120, 92, 41, 33);
		add(btnDeletar2);

		panel_4 = new JPanel();
		panel_4.setBackground(new Color(0, 0, 0));
		panel_4.setBounds(200, 398, 786, 262);
		add(panel_4);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		// atualizarTabela();
	}

	public void atualizarTabela() {
		DefaultTableModel tabela = new DefaultTableModel(new Object[][] {},
				new String[] { "Combutível", "Marca", "Modelo", "Placa", "Tipo de Frota", "Lotação", "Renavam", "Cor",
						"Acessórios", "Ano", "Preço", "Situação" });
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		listVei = veiculoDAO.listar();
		System.out.println(listVei);
		for (int i = 0; i < listVei.size(); i++) {
			Veiculo veiculo = listVei.get(i);
			tabela.addRow(new Object[] { veiculo.getTipoCombustivel(), veiculo.getMarca(), veiculo.getModelo(),
					veiculo.getPlaca(), veiculo.getTipoFrota(), veiculo.getLotacao(), veiculo.getRenavam(),
					veiculo.getCor(), veiculo.getAcessorios(), veiculo.getAno(), veiculo.getPreco(),
					veiculo.getSituacao() });

		}
		table.setModel(tabela);
	}

	private void setLocale(String string) {

	}

	private void setContentPane(JPanel contentPane) {

	}

	private void setDefaultCloseOperation(int exitOnClose) {

	}

	public Veiculo verificarDados() {

		Veiculo veiculo = new Veiculo();

		verificarCampo = "";

		String renavam = txtRenavam.getText();

		String placa = txtPlaca.getText();

		String lotacao = textLotacao.getText();
				
		String ano = textAno.getText();

		double preco = Double.parseDouble(textPreco.getText().replace(",", "."));

		String marca = (String) cbMarca.getSelectedItem();

		String modelo = (String) cbModelo_1.getSelectedItem();

		String cor = (String) cbCor.getSelectedItem();

		String frota = (String) cbFrota.getSelectedItem();

		String combustivel = (String) cbCombustivel.getSelectedItem();

		String acessorios = (String) cbAcessorio.getSelectedItem();

		String acessorio = (String) cbAcessorio.getSelectedItem();

		String situacao = (String) cbSituacao.getSelectedItem();

		if (renavam == null || renavam.trim() == "" || renavam.isEmpty()) {
			verificarCampo += "Renavam\n";
		} else {
			veiculo.setRenavam(renavam);
		}

		if (placa == null || placa.trim() == "" || placa.isEmpty()) {
			verificarCampo += "Placa\n";
		} else {
			veiculo.setPlaca(String.valueOf(placa));
		}
		if (marca == null || marca.trim() == "" || marca.isEmpty()) {
			verificarCampo += "Marca\n";
		} else {
			veiculo.setMarca(marca);
		}

		if (modelo == null || modelo.trim() == "" || modelo.isEmpty()) {
			verificarCampo += "Modelo\n";
		} else {
			veiculo.setModelo(modelo);

		}

		if (cor == null || cor.trim() == "" || cor.isEmpty()) {
			verificarCampo += "Cor\n";
		} else {

			veiculo.setCor(cor);
		}

		if (lotacao == null || lotacao.trim() == "" || lotacao.isEmpty()) {
			verificarCampo += "Lotaçao\n";

		} else {
			veiculo.setLotacao(Integer.valueOf(lotacao));
		}

		if (frota == null || frota.trim() == "" || frota.isEmpty()) {
			verificarCampo += "Frota\n";
		} else {
			veiculo.setTipoFrota(frota);

		}

		if (combustivel == null || combustivel.trim() == "" || combustivel.isEmpty()) {
			verificarCampo += "Combustivel\n";
		} else {
			veiculo.setTipoCombustivel(combustivel);

		}

		if (acessorio == null || acessorio.trim() == "" || acessorio.isEmpty()) {
			verificarCampo += "Acessorios\n";
		} else {
			veiculo.setAcessorios(acessorio);

		}

		
		if (ano == null || ano.trim() == "" || ano.isEmpty()) {
			verificarCampo += "Ano\n";
		} else {
			veiculo.setAno(Integer.valueOf(ano));

		}

		if (situacao == null || situacao.trim() == "" || situacao.isEmpty()) {
			verificarCampo += "Situaçao\n";
		} else {
			veiculo.setSituacao(String.valueOf(situacao));

		}

		if (preco == 0) {
			verificarCampo += "ValorPagar\n";
		} else {
			veiculo.setPreco(preco);
		}

		return veiculo;
	}

	public void limparDados() {
		txtRenavam.setText("");

		txtPlaca.setText("");

		textLotacao.setText("");

		textAno.setText("");

		textPreco.setText("");

		cbModelo_1.setSelectedIndex(-1);
	 textLotacao.setText("");
			
	 textAno.setText("");

		cbCor.setSelectedIndex(-1);

		cbFrota.setSelectedIndex(-1);

		cbCombustivel.setSelectedIndex(-1);

		cbMarca.setSelectedIndex(-1);

		cbAcessorio.setSelectedIndex(-1);

		cbSituacao.setSelectedIndex(-1);
	
	}
		
		

	

	private void preencherDados(Veiculo veiculoSelecionado) {
		txtRenavam.setText(veiculoSelecionado.getRenavam());
		txtPlaca.setText(String.valueOf(veiculoSelecionado.getPlaca()));
		textLotacao.setText(String.valueOf(veiculoSelecionado.getLotacao()));
		textAno.setText(String.valueOf(veiculoSelecionado.getAno()));
		textPreco.setText(String.valueOf(veiculoSelecionado.getPreco()));
		cbMarca.setToolTipText((veiculoSelecionado.getMarca()));
		cbModelo_1.setToolTipText(veiculoSelecionado.getModelo());
		cbCor.setToolTipText(veiculoSelecionado.getCor());
		cbFrota.setToolTipText(veiculoSelecionado.getTipoFrota());
		cbCombustivel.setToolTipText(veiculoSelecionado.getTipoCombustivel());
		cbAcessorio.setToolTipText(String.valueOf(veiculoSelecionado.getAcessorios()));
		cbSituacao.setToolTipText(veiculoSelecionado.getSituacao());

	}

	
}
