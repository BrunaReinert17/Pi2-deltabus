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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Mensagens.LoginErro;
import utilidades.RoundButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JComboBox;
import java.awt.Frame;

public class MenuAdmin extends JFrame {

	private JPanel contentPane;
	private RoundButton btnCadastrarUsuarios;
	private RoundButton btnVerificar;
	private RoundButton bntLogout;
	private JPanel panelTeste;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuAdmin frame = new MenuAdmin();
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
	public MenuAdmin() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuAdmin.class.getResource("/imagem/logoampliada.png")));
		setTitle("Principal Administrador");
		setTitle("Menu");
		setBackground(new Color(51, 102, 102));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2000, 1500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		//aqui
				CadastrarUsuario panelUsuario = new CadastrarUsuario();
				panelUsuario.setToolTipText("");
				panelUsuario.setLocation(579, 97);
				panelTeste = panelUsuario;
				panelTeste.setBounds(568, 104, 1200, 800);
				panelTeste.setVisible(false);
				
						contentPane.add(panelTeste);
		
	
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 376, 1061);
		contentPane.add(panel);
		panel.setLayout(null);

		btnVerificar = new RoundButton("Verificar");
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
				
				JLabel lblNewLabel_7 = new JLabel("");
				lblNewLabel_7.setBounds(92, 337, 134, 43);
				panel.add(lblNewLabel_7);
				lblNewLabel_7.setIcon(new ImageIcon(MenuAdmin.class.getResource("/imagem/IconeHome.png")));
				
				JLabel lblNewLabel_5 = new JLabel("");
				lblNewLabel_5.setBounds(46, 530, 141, 33);
				panel.add(lblNewLabel_5);
				lblNewLabel_5.setIcon(new ImageIcon(MenuAdmin.class.getResource("/imagem/icone-5.png")));
				
				JLabel lblNewLabel_4 = new JLabel("");
				lblNewLabel_4.setBounds(36, 596, 92, 33);
				panel.add(lblNewLabel_4);
				lblNewLabel_4.setIcon(new ImageIcon(MenuAdmin.class.getResource("/imagem/Icone2.png")));
		
				JLabel lblNewLabel_3 = new JLabel("");
				lblNewLabel_3.setBounds(-395, 421, 523, 73);
				panel.add(lblNewLabel_3);
				lblNewLabel_3.setIcon(new ImageIcon(MenuAdmin.class.getResource("/imagem/icone.png")));
		btnVerificar.setForeground(Color.WHITE);
		btnVerificar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnVerificar.setBackground(new Color(0, 128, 128));
		btnVerificar.setBounds(90, 596, 199, 43);
		panel.add(btnVerificar);

		JLabel lblNewLabel_1 = new JLabel("Bem Vindo: Administrador");
		lblNewLabel_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(109, 275, 184, 18);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(-792, 82, 1210, 211);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(MenuAdmin.class.getResource("/imagem/perfil.png")));

		btnCadastrarUsuarios = new RoundButton("Cadastro de Usuário");
		btnCadastrarUsuarios.setHorizontalAlignment(SwingConstants.RIGHT);
		btnCadastrarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTeste.setVisible(true);
				//aqui
			}
		});
		btnCadastrarUsuarios.setForeground(new Color(0, 0, 0));
		btnCadastrarUsuarios.setFont(new Font("Dialog", Font.BOLD, 16));
		btnCadastrarUsuarios.setBackground(new Color(0, 128, 128));
		btnCadastrarUsuarios.setBounds(90, 457, 199, 43);
		panel.add(btnCadastrarUsuarios);

		btnCadastrarUsuarios.setForeground(Color.WHITE);
		btnCadastrarUsuarios.setFont(new Font("Dialog", Font.BOLD, 15));
		btnCadastrarUsuarios.setBackground(new Color(0, 128, 128));
		btnCadastrarUsuarios.setBounds(90, 457, 199, 43);
		panel.add(btnCadastrarUsuarios);

		RoundButton rndbtnListar = new RoundButton("Listar");
		rndbtnListar.setHorizontalAlignment(SwingConstants.RIGHT);
		rndbtnListar.setText("Listagem de Usuários");
		rndbtnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTeste.setVisible(false);
				ListarUsuario listarUsuario = new ListarUsuario();
				listarUsuario.setLocationRelativeTo(null);
				listarUsuario.setVisible(true);
				//aqui
			}
		});

		JLabel ImagemLogout = new JLabel("");
		ImagemLogout.setIcon(new ImageIcon(MenuAdmin.class.getResource("/imagem/icone3.png")));
		ImagemLogout.setBounds(92, 776, 122, 47);
		panel.add(ImagemLogout);
		rndbtnListar.setForeground(Color.WHITE);
		rndbtnListar.setFont(new Font("Dialog", Font.BOLD, 15));
		rndbtnListar.setBackground(new Color(0, 128, 128));
		rndbtnListar.setBounds(90, 530, 199, 43);
		panel.add(rndbtnListar);

		JButton btnLogout = new RoundButton("Logout");
		btnLogout.setText("");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login telaLogin = new Login();
				telaLogin.setLocationRelativeTo(null);
				telaLogin.setVisible(true);
				dispose();
			}
		});
		btnLogout.setForeground(new Color(255, 255, 255));
		btnLogout.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		btnLogout.setBackground(Color.WHITE);
		btnLogout.setBounds(109, 769, 146, 54);
		panel.add(btnLogout);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-395, 411, 533, 79);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(MenuAdmin.class.getResource("/imagem/Icone.png")));
		
		RoundButton btnHome = new RoundButton("Logout");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuAdmin telaPrincipal = new MenuAdmin();
				telaPrincipal.setLocationRelativeTo(null);
				telaPrincipal.setVisible(true);
				dispose();
			}
		});
        
		btnHome.setText("");
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		btnHome.setBackground(Color.WHITE);
		btnHome.setBounds(162, 337, 64, 43);
		panel.add(btnHome);

		JLabel lblNewLabel1 = new JLabel("New label");
		lblNewLabel1.setIcon(new ImageIcon(MenuAdmin.class.getResource("/imagem/deltabus.png")));
		lblNewLabel1.setBounds(1186, 868, 830, 126);
		contentPane.add(lblNewLabel1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(MenuAdmin.class.getResource("/imagem/Telas Pi (2).png")));
		lblNewLabel_6.setBounds(263, 55, 1597, 959);
		contentPane.add(lblNewLabel_6);

	}
}
