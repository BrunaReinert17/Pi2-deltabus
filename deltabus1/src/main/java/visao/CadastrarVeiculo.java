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

import mensagens.CadastroErro;

import mensagens.CadastroErro1;
import mensagens.CadastroSucesso;
import modelo.Endereco;
import modelo.Funcionario;
import modelo.Usuario;
import modelo.Veiculo;
import utilidades.RoundButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.ImageIcon;
import javax.swing.JTree;

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
	
	
	
	//Variaveis atribuidas
	private String verificarCampo ;
	private JLabel txtAno;
	private JTextField textField;
	private JLabel lblLimpar;
	private JTextField textLotacao;
	private JTextField textidVeiculo;
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
		
		lblLimpar = new JLabel("");
		lblLimpar.setBounds(1035, 92, 110, 33);
		lblLimpar.setBackground(new Color(245, 245, 245));
		lblLimpar.setIcon(new ImageIcon(CadastrarUsuario.class.getResource("/imagem/Icone4.png")));
		add(lblLimpar);

		JLabel lblNewLabel = new JLabel("Cadastrar Veiculos");
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

		txtRenavam = new JTextField();
		txtRenavam.setBounds(308, 174, 271, 30);
		txtRenavam.setFont(new Font("Dialog", Font.BOLD, 13));
		txtRenavam.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtRenavam);
		txtRenavam.setColumns(10);

		txtPlaca = new JTextField();
		txtPlaca.setBounds(308, 439, 194, 30);
		txtPlaca.setFont(new Font("Dialog", Font.BOLD, 13));
		txtPlaca.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtPlaca);
		txtPlaca.setColumns(10);

		JLabel lblRenavam = new JLabel("Renavam:");
		lblRenavam.setBounds(231, 182, 67, 14);
		lblRenavam.setFont(new Font("Dialog", Font.BOLD, 18));
		add(lblRenavam);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCpf.setBounds(271, 245, 46, 14);
		lblRenavam.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblRenavam);

		JLabel lblidVeiculo = new JLabel("idVeiculo :");
		lblidVeiculo.setBounds(681, 294, 74, 14);
		lblidVeiculo.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblidVeiculo);

		JLabel lblModelo = new JLabel("Modelo : ");
		lblModelo.setBounds(231, 288, 84, 14);
		lblModelo.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblModelo);

		
		

		JLabel lblLotacao = new JLabel("Lotação : ");
		lblLotacao.setBounds(231, 510, 67, 14);
		lblLotacao.setFont(new Font("Dialog", Font.BOLD, 18));
		lblLotacao.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblLotacao);

		
		
		
		
		lblSituacao = new JLabel("Situação:");
		lblSituacao.setBounds(672, 447, 67, 14);
		lblSituacao.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSituacao.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblSituacao);
		
		
		ArrayList<String> marca = new ArrayList<String>();
		marca.add("");
		marca.add("Volkswagen");
		marca.add("Mercedes");
		marca.add("Agrale");
		
		cbMarca = new JComboBox();
		cbMarca.setBounds(308, 233, 222, 33);
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
		cbCor.setBounds(308, 380, 222, 33);
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


		lblCor = new JLabel("Cor  :");
		lblCor.setBounds(231, 389, 42, 14);
		lblCor.setFont(new Font("Dialog", Font.BOLD, 13));
		lblCor.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblCor);
		
		

		
		lblFrota = new JLabel("Frota : ");
		lblFrota.setBounds(231, 562, 67, 14);
		lblFrota.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblFrota);

		lblPlaca = new JLabel("Placa :");
		lblPlaca.setBounds(231, 447, 59, 14);
		lblPlaca.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblPlaca);

		lblAcessorios = new JLabel("Acessórios :");
		lblAcessorios.setBounds(681, 242, 84, 14);
		lblAcessorios.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblAcessorios);
		
		

		lblCombustivel = new JLabel("Combustível : ");
		lblCombustivel.setBounds(681, 179, 90, 23);
		lblCombustivel.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblCombustivel);
		
		
		JButton btnLimparCampo = new RoundButton("Limpar Campo");
		btnLimparCampo.setBounds(1061, 92, 84, 33);
		btnLimparCampo.setText("");
		btnLimparCampo.setBackground(new Color(245, 245, 245));
		btnLimparCampo.setForeground(Color.WHITE);
		btnLimparCampo.setFont(new Font("Dialog", Font.BOLD, 14));
		btnLimparCampo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 txtRenavam.setText("");

				 txtPlaca.setText("");

			 textLotacao.setText("");
					

			textidVeiculo.setText("");

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
		lblMarca.setBounds(231, 235, 98, 14);
		lblMarca.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblMarca);
		
		txtAno = new JLabel("Ano :");
		txtAno.setBounds(681, 388, 42, 14);
		txtAno.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtAno);
		
		
		ArrayList<String> modelo = new ArrayList<String>();
		modelo.add("");
		modelo.add("Scania");
		modelo.add("mpolo");
		modelo.add("volvo");
		modelo.add("comil");
		
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
		cbModelo_1.setBounds(308, 285, 222, 33);
		add(cbModelo_1);
		
		textLotacao = new JTextField();
		textLotacao.setFont(new Font("Dialog", Font.BOLD, 13));
		textLotacao.setColumns(10);
		textLotacao.setBounds(308, 502, 110, 30);
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
	cbFrota.setBounds(282, 553, 222, 33);
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
		cbCombustivel.setBounds(781, 174, 194, 33);
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
		cbAcessorio.setBounds(781, 233, 194, 33);
		add(cbAcessorio);
		
		textidVeiculo = new JTextField();
		textidVeiculo.setFont(new Font("Dialog", Font.BOLD, 13));
		textidVeiculo.setColumns(10);
		textidVeiculo.setBounds(781, 290, 110, 30);
		add(textidVeiculo);
		
		textAno = new JTextField();
		textAno.setFont(new Font("Dialog", Font.BOLD, 13));
		textAno.setColumns(10);
		textAno.setBounds(749, 380, 194, 30);
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
		cbSituacao.setBounds(749, 438, 194, 33);
		add(cbSituacao);
		
		textPreco = new JTextField();
		textPreco.setFont(new Font("Dialog", Font.BOLD, 13));
		textPreco.setColumns(10);
		textPreco.setBounds(749, 502, 110, 30);
		add(textPreco);
		
		JLabel lblPreco = new JLabel("Preço  :");
		lblPreco.setFont(new Font("Dialog", Font.BOLD, 13));
		lblPreco.setBounds(681, 510, 67, 14);
		add(lblPreco);
		
		RoundButton btnCadastrar = new RoundButton("Confirmar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Veiculo veiculo = verificarDados();
				
				boolean veiculoRetornoCadastro = false;
				
				

                if (veiculo != null) {
                	VeiculoDAO veiculoDAO = new VeiculoDAO();
                    boolean resultado = veiculoDAO.inserirVeiculo(veiculo);

                    if (resultado == true) {
                        // O veículo foi cadastrado com sucesso
                        CadastroSucesso sucesso = new CadastroSucesso("Veículo Cadastrado com Sucesso!");
                        sucesso.setLocationRelativeTo(null);
                        sucesso.setVisible(true);
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

				 
	          


		btnCadastrar.setText("Cadastrar");
		
		
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnCadastrar.setBackground(new Color(0, 128, 128));
		btnCadastrar.setBounds(548, 663, 132, 33);
		add(btnCadastrar);

		setContentPane(contentPane);
		contentPane.setLayout(null);

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
		
		String idveiculo = textidVeiculo.getText();
		
		String ano = textAno.getText();
		
		String preco = textPreco.getText();

	
        String marca = (String) cbMarca.getSelectedItem();

		
        String modelo = (String) cbModelo_1.getSelectedItem();

		String cor  = (String) cbCor.getSelectedItem();
		
		
		String frota = (String) cbFrota.getSelectedItem();
		
		String combustivel = (String) cbCombustivel.getSelectedItem();


		String acessorios  = (String) cbAcessorio.getSelectedItem();
		

		String acessorio  = (String) cbAcessorio.getSelectedItem();
	


		String situacao  = (String) cbSituacao.getSelectedItem();
		
		
		
		
		
		
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
		
		if (idveiculo == null || idveiculo.trim() == "" || idveiculo.isEmpty()) {
			verificarCampo += "idVeiculo\n";
		} else {
			veiculo.setIdVeiculo(Long.valueOf(idveiculo));

		}
		
		
		if (ano == null || ano.trim() == "" || ano.isEmpty()) {
			verificarCampo += "Ano\n";
		} else {
			veiculo.setAno(Integer.valueOf(ano));

		}
		
		
		
		if (situacao == null || situacao.trim() == "" || situacao.isEmpty()) {
			verificarCampo += "Situaçao\n";
		} else {
			veiculo.setSituacao(Boolean.valueOf(situacao));

		}
		
		
		if (preco == null || preco.trim() == "" || preco.isEmpty()) {
			verificarCampo += "Preco\n";
		} else {
			veiculo.setPreco(Double.valueOf(preco));

		}
		
		return null;
	}
	public void limparDados() {
		 txtRenavam.setText("");

		 txtPlaca.setText("");

	 textLotacao.setText("");
			

	textidVeiculo.setText("");

	 textAno.setText("");

		 textPreco.setText("");
	
	}
}