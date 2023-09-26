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
	private JLabel lblKlm;
	private JLabel lblAcessorios;
	private JLabel lblFuno;
	private JLabel lblCombustivel;
	private JButton bntDeletar;
	private JButton btnConfirmar;
	
	
	
	//Variaveis atribuidas
	private String verificarCampo ;
	private JLabel txtAno;
	private JTextField textField;
	private JLabel lblLimpar;
	private JTextField textLotacao;
	private JTextField textidVeiculo;
	private JTextField textAno;
	private JTextField textPreco;
	private JComboBox cbModelo;
	private JComboBox cbCor;
	private JComboBox cbFrota;
	private JComboBox cbCombustivel;
	private JComboBox cbAcessorios;
	private JComboBox cbKlm;
	private JComboBox cbSituacao;
	
	
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
		txtRenavam.setBounds(295, 112, 271, 30);
		txtRenavam.setFont(new Font("Dialog", Font.BOLD, 13));
		txtRenavam.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtRenavam);
		txtRenavam.setColumns(10);

		txtPlaca = new JTextField();
		txtPlaca.setBounds(295, 377, 194, 30);
		txtPlaca.setFont(new Font("Dialog", Font.BOLD, 13));
		txtPlaca.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtPlaca);
		txtPlaca.setColumns(10);

		JLabel lblRenavam = new JLabel("Renavam:");
		lblRenavam.setBounds(218, 120, 67, 14);
		lblRenavam.setFont(new Font("Dialog", Font.BOLD, 18));
		add(lblRenavam);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCpf.setBounds(271, 245, 46, 14);
		lblRenavam.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblRenavam);

		JLabel lblidVeiculo = new JLabel("idVeiculo :");
		lblidVeiculo.setBounds(211, 671, 74, 14);
		lblidVeiculo.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblidVeiculo);

		JLabel lblModelo = new JLabel("Modelo : ");
		lblModelo.setBounds(218, 226, 84, 14);
		lblModelo.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblModelo);

		/**********/
		MaskFormatter mascaraCpf = null;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		JLabel lblLotacao = new JLabel("Lotação : ");
		lblLotacao.setBounds(218, 448, 67, 14);
		lblLotacao.setFont(new Font("Dialog", Font.BOLD, 18));
		lblLotacao.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblLotacao);

		
		/**********/
		MaskFormatter mascaraTelefone = null;
		try {
			mascaraCpf = new MaskFormatter("(##)#####-####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		lblSituacao = new JLabel("Situação :");
		lblSituacao.setBounds(670, 448, 67, 14);
		lblSituacao.setFont(new Font("Dialog", Font.BOLD, 18));
		lblSituacao.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblSituacao);
		
		/**********/
		MaskFormatter mascaraDataDeNascimento = null;
		try {
			mascaraCpf = new MaskFormatter("##/##/####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		/**********/
		ArrayList<String> genero = new ArrayList<String>();
		genero.add("");
		genero.add("Masculino");
		genero.add("Feminino");
		genero.add("Outro");
		
		cbMarca = new JComboBox();
		cbMarca.setBounds(295, 165, 222, 33);
		cbMarca.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				for (int i = 0; i < genero.size(); i++) {
					cbMarca.addItem(genero.get(i));

				}
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbMarca.setFont(new Font("Dialog", Font.BOLD, 13));
		add(cbMarca);

	
		/**********/
		MaskFormatter mascaraCep = null;
		try {
			mascaraCpf = new MaskFormatter("#####-###");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		lblCor = new JLabel("Cor  :");
		lblCor.setBounds(218, 327, 42, 14);
		lblCor.setFont(new Font("Dialog", Font.BOLD, 13));
		lblCor.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblCor);
		
		ArrayList<String> cidade = new ArrayList<>();
		cidade.add("");
		cidade.add("Majé");
		cidade.add("Ilhota");
		cidade.add("Gaspar");
		cidade.add("Blumenau");

		lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Dialog", Font.BOLD, 13));
		lblBairro.setBounds(768, 428, 155, 14);

		lblFrota = new JLabel("Frota : ");
		lblFrota.setBounds(218, 500, 67, 14);
		lblFrota.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblFrota);

		lblPlaca = new JLabel("Placa :");
		lblPlaca.setBounds(218, 385, 59, 14);
		lblPlaca.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblPlaca);

		ArrayList<String> uf = new ArrayList<>();
		uf.add("");
		uf.add("SC");
		uf.add("SP");
		uf.add("RS");
		uf.add("PR");

		lblKlm = new JLabel("Klm :");
		lblKlm.setBounds(698, 385, 39, 14);
		lblKlm.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblKlm);

		lblAcessorios = new JLabel("Acessórios :");
		lblAcessorios.setBounds(195, 615, 84, 14);
		lblAcessorios.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblAcessorios);
		
		ArrayList<String> funcao = new ArrayList<>();
		funcao.add("Administrador");
		funcao.add("Funcionário");

		lblCombustivel = new JLabel("Combustível : ");
		lblCombustivel.setBounds(195, 552, 90, 23);
		lblCombustivel.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblCombustivel);

		btnConfirmar = new RoundButton("Confirmar");
		btnConfirmar.setBounds(655, 684, 216, 33);
		btnConfirmar.setText("Cadastrar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Funcionario funcionario = verificarDados();
				
				Usuario usuario = new Usuario();
				if (funcionario == null ) {
					JOptionPane.showMessageDialog(null, verificarCampo, "Dados inválidos:",
							JOptionPane.ERROR_MESSAGE, null);

				}else {
					FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
					EnderecoDAO enderecoDAO = new EnderecoDAO();
					UsuarioDAO usuarioDAO = new UsuarioDAO();
					Endereco endereco = enderecoDAO.consultandoEndereco(funcionario.getEndereco());
					boolean ende = false;
					if(endereco== null) {
						 ende = enderecoDAO.inserirEndereco(funcionario.getEndereco());
					}
					
					boolean usuarioRetornoCadastro = false;
					


					if(ende != false) {
						
						usuarioRetornoCadastro = usuarioDAO.inserirUsuario(funcionario.getUsuario());
						System.out.println(funcionario.getUsuario());
						
						if(usuarioRetornoCadastro!=false) {
							 usuario  = usuarioDAO.selecionar(funcionario.getUsuario());
							 System.out.println(usuario);
							 funcionario.setUsuario(usuario);
							boolean resultado = funcionarioDAO.inserirFuncionario(funcionario);
							if(resultado = true) {
								JOptionPane.showMessageDialog(null, "Cadastrado");
								limparDados();
							}else {
								JOptionPane.showMessageDialog(null,"ErrO");
							}
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "Erro");
					}
						
					
				
				}
				
				
			}
		});
		btnConfirmar.setForeground(Color.WHITE);
		btnConfirmar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnConfirmar.setBackground(new Color(0, 128, 128));
		add(btnConfirmar);
		
		
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
					
					cbAcessorios.setSelectedIndex(-1);
					
					cbKlm.setSelectedIndex(-1);
					
					cbSituacao.setSelectedIndex(-1);
					
					
			
			}
		});
		add(btnLimparCampo);
		
		JLabel lblMarca = new JLabel("Marca :");
		lblMarca.setBounds(218, 173, 98, 14);
		lblMarca.setFont(new Font("Dialog", Font.BOLD, 13));
		add(lblMarca);
		
		txtAno = new JLabel("Ano :");
		txtAno.setBounds(698, 333, 42, 14);
		txtAno.setFont(new Font("Dialog", Font.BOLD, 13));
		add(txtAno);
		
		JComboBox cbModelo = new JComboBox();
		cbModelo.setFont(new Font("Dialog", Font.BOLD, 13));
		cbModelo.setBounds(295, 223, 222, 33);
		add(cbModelo);
		
		JComboBox cbCor = new JComboBox();
		cbCor.setFont(new Font("Dialog", Font.BOLD, 13));
		cbCor.setBounds(295, 318, 194, 33);
		add(cbCor);
		
		textLotacao = new JTextField();
		textLotacao.setFont(new Font("Dialog", Font.BOLD, 13));
		textLotacao.setColumns(10);
		textLotacao.setBounds(295, 440, 110, 30);
		add(textLotacao);
		
		JComboBox cbFrota = new JComboBox();
		cbFrota.setFont(new Font("Dialog", Font.BOLD, 13));
		cbFrota.setBounds(295, 491, 194, 33);
		add(cbFrota);
		
		JComboBox cbCombustivel = new JComboBox();
		cbCombustivel.setFont(new Font("Dialog", Font.BOLD, 13));
		cbCombustivel.setBounds(295, 547, 194, 33);
		add(cbCombustivel);
		
		JComboBox cbFrota_1_1 = new JComboBox();
		cbFrota_1_1.setFont(new Font("Dialog", Font.BOLD, 13));
		cbFrota_1_1.setBounds(295, 606, 194, 33);
		add(cbFrota_1_1);
		
		textidVeiculo = new JTextField();
		textidVeiculo.setFont(new Font("Dialog", Font.BOLD, 13));
		textidVeiculo.setColumns(10);
		textidVeiculo.setBounds(295, 663, 110, 30);
		add(textidVeiculo);
		
		textAno = new JTextField();
		textAno.setFont(new Font("Dialog", Font.BOLD, 13));
		textAno.setColumns(10);
		textAno.setBounds(750, 325, 194, 30);
		add(textAno);
		
		JComboBox cbCor_1 = new JComboBox();
		cbCor_1.setFont(new Font("Dialog", Font.BOLD, 13));
		cbCor_1.setBounds(750, 376, 194, 33);
		add(cbCor_1);
		
		JComboBox cbSituacao = new JComboBox();
		cbSituacao.setFont(new Font("Dialog", Font.BOLD, 13));
		cbSituacao.setBounds(750, 439, 194, 33);
		add(cbSituacao);
		
		textPreco = new JTextField();
		textPreco.setFont(new Font("Dialog", Font.BOLD, 13));
		textPreco.setColumns(10);
		textPreco.setBounds(750, 498, 110, 30);
		add(textPreco);
		
		JLabel lblPreco = new JLabel("Preço  :");
		lblPreco.setFont(new Font("Dialog", Font.BOLD, 13));
		lblPreco.setBounds(670, 501, 67, 14);
		add(lblPreco);

		setContentPane(contentPane);
		contentPane.setLayout(null);

	}

	private void setLocale(String string) {
		

	}

	private void setContentPane(JPanel contentPane) {
		

	}

	private void setDefaultCloseOperation(int exitOnClose) {
	

	}
	public Funcionario verificarDados() {
		
		Veiculo veiculo = new Veiculo();
	
		
		
		verificarCampo = "";
		
		String renavam = txtRenavam.getText();
		
		String placa = txtPlaca.getText();
		
		String lotacao = textLotacao.getText();
		
		String idveiculo = textidVeiculo.getText();
		
		String ano = textAno.getText();
		
		String preco = textPreco.getText();

	
        String marca = (String) cbMarca.getSelectedItem();

		
        String modelo = (String) cbModelo.getSelectedItem();

		String cor  = (String) cbCor.getSelectedItem();
		
		
		String frota = (String) cbFrota.getSelectedItem();
		
		String combustivel = (String) cbCombustivel.getSelectedItem();

		String acessorios  = (String) cbAcessorios.getSelectedItem();
		
		String klm = (String) cbKlm.getSelectedItem();

		String situacao  = (String) cbSituacao.getSelectedItem();
		
		
		
		
		
		
		if (renavam == null || renavam.trim() == "" || renavam.isEmpty()) {
			verificarCampo += "Renavam\n";
		} else {
			veiculo.setRenavam(renavam);
		}


		if (placa == null || placa.trim() == "" || placa.isEmpty()) {
			verificarCampo += "Placa\n";
		} else {
			long cpf = Long.parseLong(placa);		
			veiculo.setPlaca(placa);
		}
		if (marca == null || marca.trim() == "" || marca.isEmpty()) {
			verificarCampo += "Marca\n";
		} else {
			veiculo.setMarca(marca);
		}
		// telefone
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
		
		
	//	if (lotacao == null || lotacao.trim() == "" || lotacao.isEmpty()) {
			//verificarCampo += "Lotaçao\n";

	//	} else {
	//		veiculo.setLotacao(lotacao);
	//	}
		
		
		if (frota == null || frota.trim() == "" || frota.isEmpty()) {
			verificarCampo += "Frota\n";
		} else {
			veiculo.setTipoFrota(frota);

		}
		
		if (combustivel == null || frota.trim() == "" || frota.isEmpty()) {
			verificarCampo += "Frota\n";
		} else {
			veiculo.setTipoFrota(frota);

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