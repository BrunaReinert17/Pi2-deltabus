package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mensagens.Logout;
import utilidades.RoundButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Frame;

public class MenuFuncionario extends JFrame {

	private JPanel contentPane;
	private RoundButton btnCadastrarClientes;
	private RoundButton bntLogout;
	private JPanel panelTeste;
	private JPanel panelTeste1;
	private JPanel panelTeste2;
	private JPanel panelTeste3;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuFuncionario frame = new MenuFuncionario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuFuncionario() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(MenuFuncionario.class.getResource("/imagem/logoampliada.png")));
		setTitle("Principal Funcionario");
		setTitle("Menu");
		setBackground(new Color(51, 102, 102));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1382, 923);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);

		CadastrarCliente panelCliente = new CadastrarCliente();
		panelCliente.setToolTipText("");
		panelCliente.setLocation(579, 97);
		panelTeste = panelCliente;
		panelTeste.setBounds(568, 104, 1200, 800);
		panelTeste.setVisible(false);

		contentPane.add(panelTeste);
		
		CadastrarVeiculo veiculo = new CadastrarVeiculo();
		veiculo.setToolTipText("");
		veiculo.setLocation(579, 97);
		panelTeste3 = veiculo;
		panelTeste3.setBounds(568, 104, 1200, 800);
		panelTeste3.setVisible(false);
		
		contentPane.add(panelTeste3);


		
		
		
		
		CadastrarPedido cadastrarVendas = new CadastrarPedido();
		cadastrarVendas.setToolTipText("");
		cadastrarVendas.setLocation(579, 97);
		panelTeste2 = cadastrarVendas;
		panelTeste2.setBounds(568, 104, 1200, 800);
		panelTeste2.setVisible(false);

		contentPane.add(panelTeste2);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 376, 1061);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon(MenuFuncionario.class.getResource("/imagem/icone cadastro.png")));
		lblNewLabel_9.setBounds(79, 520, 50, 54);
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(MenuFuncionario.class.getResource("/imagem/icone cadastro.png")));
		lblNewLabel_4.setBounds(79, 594, 50, 43);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBounds(92, 337, 134, 43);
		panel.add(lblNewLabel_7);
		lblNewLabel_7.setIcon(new ImageIcon(MenuFuncionario.class.getResource("/imagem/IconeHome.png")));

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(-395, 421, 523, 73);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon(MenuFuncionario.class.getResource("/imagem/icone.png")));

		JLabel lblNewLabel_1 = new JLabel("Bem Vindo: Funcionario");
		lblNewLabel_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(109, 275, 184, 18);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(-792, 82, 1210, 211);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(MenuFuncionario.class.getResource("/imagem/perfil.png")));

		btnCadastrarClientes = new RoundButton("Cadastro de Clientes");
		btnCadastrarClientes.setHorizontalAlignment(SwingConstants.RIGHT);
		btnCadastrarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTeste.setVisible(true);
				panelTeste3.setVisible(false);
				panelTeste2.setVisible(false);
				
			}
		});
		btnCadastrarClientes.setForeground(new Color(0, 0, 0));
		btnCadastrarClientes.setFont(new Font("Dialog", Font.BOLD, 16));
		btnCadastrarClientes.setBackground(new Color(0, 128, 128));
		btnCadastrarClientes.setBounds(92, 444, 199, 109);
		panel.add(btnCadastrarClientes);

		btnCadastrarClientes.setForeground(Color.WHITE);
		btnCadastrarClientes.setFont(new Font("Dialog", Font.BOLD, 15));
		btnCadastrarClientes.setBackground(new Color(0, 128, 128));
		btnCadastrarClientes.setBounds(90, 457, 199, 43);
		panel.add(btnCadastrarClientes);

		RoundButton rndbtnCadastrarVeiculos = new RoundButton("Cadastrar");
		rndbtnCadastrarVeiculos.setHorizontalAlignment(SwingConstants.RIGHT);
		rndbtnCadastrarVeiculos.setText("Cadastrar Veiculos");
		rndbtnCadastrarVeiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTeste3.setVisible(true);
				panelTeste.setVisible(false);
				panelTeste2.setVisible(false);


			}
		});

		JLabel ImagemLogout = new JLabel("");
		ImagemLogout.setIcon(new ImageIcon(MenuFuncionario.class.getResource("/imagem/icone3.png")));
		ImagemLogout.setBounds(92, 839, 122, 47);
		panel.add(ImagemLogout);
		rndbtnCadastrarVeiculos.setForeground(Color.WHITE);
		rndbtnCadastrarVeiculos.setFont(new Font("Dialog", Font.BOLD, 16));
		rndbtnCadastrarVeiculos.setBackground(new Color(0, 128, 128));
		rndbtnCadastrarVeiculos.setBounds(90, 520, 199, 43);
		panel.add(rndbtnCadastrarVeiculos);

		JButton btnLogout = new RoundButton("Logout");
		btnLogout.setText("");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Logout logout = new Logout("Tem certeza de que deseja sair?");
				logout.setLocationRelativeTo(null);
				logout.setVisible(true);
			}
		});
		btnLogout.setForeground(new Color(255, 255, 255));
		btnLogout.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		btnLogout.setBackground(Color.WHITE);
		btnLogout.setBounds(109, 832, 146, 54);
		panel.add(btnLogout);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-395, 411, 533, 79);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(MenuFuncionario.class.getResource("/imagem/Icone.png")));

		RoundButton btnHome = new RoundButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTeste.setVisible(false);
				panelTeste3.setVisible(false);
				panelTeste2.setVisible(false);
			}
		});
		btnHome.setText("");
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		btnHome.setBackground(Color.WHITE);
		btnHome.setBounds(162, 337, 64, 43);
		panel.add(btnHome);
		
		RoundButton btnCadastroDeVendas = new RoundButton("Cadastro de Vendas");
		btnCadastroDeVendas.setHorizontalAlignment(SwingConstants.RIGHT);
		btnCadastroDeVendas.setText("Cadastrar Pedidos");
		btnCadastroDeVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTeste2.setVisible(true);
				panelTeste.setVisible(false);
				panelTeste3.setVisible(false);

			}
		});
		btnCadastroDeVendas.setForeground(new Color(255, 255, 255));
		btnCadastroDeVendas.setFont(new Font("Dialog", Font.BOLD, 16));
		btnCadastroDeVendas.setBackground(new Color(0, 128, 128));
		btnCadastroDeVendas.setBounds(90, 585, 199, 43);
		panel.add(btnCadastroDeVendas);

		JLabel lblNewLabel1 = new JLabel("New label");
		lblNewLabel1.setIcon(new ImageIcon(MenuFuncionario.class.getResource("/imagem/deltabus.png")));
		lblNewLabel1.setBounds(1186, 868, 830, 126);
		contentPane.add(lblNewLabel1);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(MenuFuncionario.class.getResource("/imagem/Telas Pi (2).png")));
		lblNewLabel_6.setBounds(263, 55, 1597, 959);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(413, 980, 46, 14);
		contentPane.add(lblNewLabel_8);

	}
}