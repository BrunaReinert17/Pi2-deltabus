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

import utilidades.RoundButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class TelaPrincipal extends JFrame {

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
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/imagem/logoampliada.png")));
		setExtendedState(MAXIMIZED_BOTH);
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
				
				JLabel lblNewLabel_4 = new JLabel("");
				lblNewLabel_4.setBounds(36, 596, 92, 33);
				panel.add(lblNewLabel_4);
				lblNewLabel_4.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/Icone2.png")));
		
				JLabel lblNewLabel_3 = new JLabel("");
				lblNewLabel_3.setBounds(-395, 421, 522, 79);
				panel.add(lblNewLabel_3);
				lblNewLabel_3.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/icone.png")));
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
		lblNewLabel_2.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/perfil.png")));

		btnCadastrarUsuarios = new RoundButton("Cadastro de Usuário");
		btnCadastrarUsuarios.setHorizontalAlignment(SwingConstants.RIGHT);
		btnCadastrarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelTeste.setVisible(true);
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

			}
		});

		JLabel ImagemLogout = new JLabel("");
		ImagemLogout.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/icone3.png")));
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
				TelaLogin telaLogin = new TelaLogin();
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
		lblNewLabel.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/Icone.png")));

		JLabel lblNewLabel1 = new JLabel("New label");
		lblNewLabel1.setIcon(new ImageIcon(TelaCadastroFuncionario.class.getResource("/imagem/deltabus.png")));
		lblNewLabel1.setBounds(1186, 868, 830, 126);
		contentPane.add(lblNewLabel1);

	}
}
