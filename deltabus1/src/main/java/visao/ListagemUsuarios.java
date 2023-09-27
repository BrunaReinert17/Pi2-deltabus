package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Mensagens.ListagemErro;
import controle.FuncionarioDAO;
import modelo.Endereco;
import modelo.Funcionario;
import utilidades.RoundButton;

public class ListagemUsuarios extends JPanel {
	private JPanel contentPane;
	private JTable table;
	private JPanel panel;
	private JPanel panel_1;
	private ArrayList<Funcionario> listFuncionario;
	private JTextField textCPF;
	private Funcionario funcionarioClick;
	private JButton voltar;
	private AbstractButton btnSalvar;
	private String validacao = "";

	
private void deletarFuncionario() {
		
		long cpf;
		
		cpf = Long.valueOf(textCPF.getText());
		
		Funcionario objfuncionario = new Funcionario();
		objfuncionario.setCpf(cpf);
		
		FuncionarioDAO objfuncionariodao = new FuncionarioDAO();
		
		objfuncionariodao.deletarFuncionario(objfuncionario);
		
	}

	public ListagemUsuarios() {
		setTitle("Cadastrar Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(0, 0, 0));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)),
				"", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(0, 128, 128)));
		panel.setBounds(0, 37, 1184, 724);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 1164, 702);
		panel.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("Dialog", Font.BOLD, 14));


		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "Email", "Cpf", "Telefone", "Data de Nascimento", "Genero", "Endereço" }));
		scrollPane.setViewportView(table);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(0, 0, 1200, 46);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("      Listagem de Usuarios\r\n");
		lblNewLabel.setBounds(0, 0, 352, 38);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel_1.add(lblNewLabel);
		
		RoundButton rndbtnDeletar = new RoundButton("Deletar");
		rndbtnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletarFuncionario();
				atualizarTabela();
			}
		});
		rndbtnDeletar.setText("Deletar");
		rndbtnDeletar.setForeground(new Color(0, 0, 0));
		rndbtnDeletar.setFont(new Font("Dialog", Font.BOLD, 16));
		rndbtnDeletar.setBackground(new Color(255, 255, 255));
		rndbtnDeletar.setBounds(1050, 3, 115, 33);
		panel_1.add(rndbtnDeletar);
		
		
		RoundButton rndbtnAlterar = new RoundButton("Alterar");
		rndbtnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int position = table.getSelectedRow();

				
				if(position == -1) {
					ListagemErro naoSelecionado = new ListagemErro("Nenhum Usuário Selecionado!");
					naoSelecionado.setLocationRelativeTo(null);
					naoSelecionado.setVisible(true);


				if (position == -1) {
					JOptionPane.showMessageDialog(null, "Nenhum usuario Selecionado");

					return;
				}
				funcionarioClick = listFuncionario.get(position);
				preencherFuncionarioTabela(funcionarioClick);

				funcionarioClick = new Funcionario();

				rndbtnAlterar.setVisible(false);
				panel.remove(rndbtnAlterar);

				rndbtnAlterar.setVisible(false);
				panel.remove(rndbtnAlterar);

				rndbtnDeletar.setVisible(false);
				panel.remove(rndbtnDeletar);

				voltar = new JButton("Cancelar");
				voltar.setForeground(new Color(255, 255, 255));
				voltar.setBackground(new Color(149, 208, 157));

				voltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						limparBorda();

						rndbtnAlterar.setFont(new Font("Dialog", Font.BOLD, 14));
						panel.add(rndbtnAlterar, "cell 1 5, grow");
						rndbtnAlterar.setVisible(true);

						panel.remove(voltar);

						btnSalvar.setVisible(false);
						panel.remove(rndbtnAlterar);

						limparTela();

					}

					private void limparTela() {
						// TODO Auto-generated method stub

					}

					private void limparBorda() {
						// TODO Auto-generated method stub

					}
				});
				rndbtnAlterar.setFont(new Font("Dialog", Font.BOLD, 14));
				panel.add(rndbtnAlterar, "cell 1 5, grow");

				btnSalvar = new JButton("Salvar");
				btnSalvar.setForeground(new Color(255, 255, 255));
				btnSalvar.setBackground(new Color(149, 208, 157));
				btnSalvar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						validacao = "";

						Funcionario funcionario = new Funcionario();
						var nome = new CadastrarUsuario();
						var cpf = new CadastrarUsuario();
						var telefone = new CadastrarUsuario();
						var dataNasci = new CadastrarUsuario();
						var genero = new CadastrarUsuario();
						var endereco = new Endereco();
						
						
						funcionario = setarObjetoFuncionario();
						nome = setarObjetoNome();
						cpf = setarObjetoCpf();
						telefone = setarObjetoTelefone();
					    dataNasci = setarObjetoDataNasci();
						genero = setarObjetoGenero();
					    endereco = setarObjetoEndereco();
						
						
						
						if (funcionario != null && endereco != null ) {
							
							funcionario.setEndereco(endereco);
							
						

							Funcionario cadastroFuncionarioHelper = new Funcionario();
							Funcionario retorno = cadastroFuncionarioHelper.editarFuncionario(funcionario);
							if (Funcionario.FUNCIONARIEDITADO == retorno) {
								JOptionPane.showMessageDialog(null, "Funcionario editado");
								atualizarTabela();
								limparTela();

							} else {
								JOptionPane.showMessageDialog(null, "Erro ao editar");
							}

							panel.add(rndbtnAlterar);
							rndbtnAlterar.setVisible(true);

							rndbtnAlterar.setFont(new Font("Dialog", Font.BOLD, 14));
							panel.add(rndbtnAlterar, "cell 1 5,growx");
							rndbtnAlterar.setVisible(true);

							rndbtnDeletar.setFont(new Font("Dialog", Font.BOLD, 14));
							panel.add(rndbtnDeletar, "cell 3 5,grow");
							rndbtnDeletar.setVisible(true);
							limparTela();
							voltar.setVisible(true);
							panel.remove(voltar);
							limparTela();

							btnSalvar.setVisible(true);
							panel.remove(btnSalvar);

						} else {
							JOptionPane.showMessageDialog(null, validacao, "Dados inválidos:",
									JOptionPane.ERROR_MESSAGE, null);
						}

					}

					private Endereco setarObjetoEndereco() {
						// TODO Auto-generated method stub
						return null;
					}

					private Funcionario setarObjetoFuncionario() {
						// TODO Auto-generated method stub
						return null;
					}

					private CadastrarUsuario setarObjetoNome() {
						// TODO Auto-generated method stub
						return null;
					}

					private CadastrarUsuario setarObjetoGenero() {
						// TODO Auto-generated method stub
						return null;
					}

					private CadastrarUsuario setarObjetoDataNasci() {
						// TODO Auto-generated method stub
						return null;
					}

					private CadastrarUsuario setarObjetoTelefone() {
						// TODO Auto-generated method stub
						return null;
					}

					private CadastrarUsuario setarObjetoCpf() {
						// TODO Auto-generated method stub
						return null;
					}

					private void limparTela() {
						// TODO Auto-generated method stub

					}

				});
				
				
				rndbtnAlterar.setFont(new Font("Dialog", Font.BOLD, 14));
				panel_1.add(rndbtnAlterar, "cell 1 5, grow");
				}

			
			}

			private void preencherFuncionarioTabela(Funcionario funcionarioClick) {
				// TODO Auto-generated method stub
				
			}
			
			
		});

		rndbtnAlterar.setText("Alterar");
		rndbtnAlterar.setForeground(Color.WHITE);
		rndbtnAlterar.setFont(new Font("Dialog", Font.BOLD, 16));
		rndbtnAlterar.setBackground(new Color(0, 128, 128));
		rndbtnAlterar.setBounds(918, 4, 114, 33);
		panel_1.add(rndbtnAlterar);

	
		
		textCPF = new JTextField();
		textCPF.setBounds(496, 12, 177, 20);
		panel_1.add(textCPF);
		textCPF.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setForeground(new Color(255, 255, 255));
		btnPesquisar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnPesquisar.setBackground(new Color(0, 128, 128));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpfpesquisa = textCPF.getText();
				atualizarTabela();
			}
		});
		btnPesquisar.setBounds(362, 10, 115, 23);
		panel_1.add(btnPesquisar);

		atualizarTabela();
	}
	private void setTitle(String string) {
		// TODO Auto-generated method stub
		
	}


	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub
		
	}


	private void setContentPane(JPanel contentPane2) {
		// TODO Auto-generated method stub
		
	}


	private void atualizarTabela() {
		DefaultTableModel tabela = new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Cpf", "Telefone", "Data de Nascimento", "Genero", "Endereço" });
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		listFuncionario = funcionarioDAO.consultarTodos();
		System.out.println(listFuncionario);
		for (int i = 0; i < listFuncionario.size(); i++) {
			Funcionario funcionario = listFuncionario.get(i);
			tabela.addRow(new Object[] { funcionario.getNome(), funcionario.getCpf(), funcionario.getNumeroTelefone(),funcionario.getDatanasci(),funcionario.getGenero(),funcionario.getEndereco().getCep()});

		}
		table.setModel(tabela);
	}

	public void setLocationRelativeTo(Object object) {
		// TODO Auto-generated method stub
		
	}
	
}