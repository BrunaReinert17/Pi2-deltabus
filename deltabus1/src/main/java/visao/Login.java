package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utilidades.RoundButton;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

import Mensagens.LoginErro;
import Mensagens.LoginErro1;
import controle.UsuarioDAO;
import modelo.Usuario;

import javax.swing.border.BevelBorder;
import javax.swing.DropMode;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel;
	private RoundButton btnNewButton;
	private JPasswordField txtSenha;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/imagem/logoampliada.png")));
		setExtendedState(MAXIMIZED_BOTH);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2000, 1400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 102));
		contentPane.setForeground(new Color(0, 102, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel1 = new JPanel();
		panel1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(0, 128, 128), null, null, null));
		panel1.setBounds(751, 218, 447, 549);
		panel1.setBackground(new Color(255, 255, 255));
		panel1.setForeground(new Color(204, 204, 204));
		contentPane.add(panel1);
		panel1.setLayout(null);

		btnNewButton = new RoundButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Usuario usuario = new Usuario();
				String email = txtEmail.getText();
				String senha = txtSenha.getText();
				usuario.setEmail(email);
				usuario.setSenha(senha);

				UsuarioDAO usuarioDAO = new UsuarioDAO();
				Usuario retorno = usuarioDAO.consultarLogin(usuario);

				if (!email.isEmpty() && !senha.isEmpty()) {

					if (retorno != null && retorno.getEmail().equals(email) && retorno.getSenha().equals(senha)) {
						MenuAdmin telaPrincipal = new MenuAdmin();
						telaPrincipal.setLocationRelativeTo(null);
						telaPrincipal.setVisible(true);
						dispose();
					} else {
						LoginErro janelaErro = new LoginErro("Senha ou E-mail Incorretos!");
						janelaErro.setLocationRelativeTo(null);
						janelaErro.setVisible(true);
					}

				} else {
					LoginErro1 janelaErro = new LoginErro1("Senha ou E-mail não Preenchidos!");
					janelaErro.setLocationRelativeTo(null);
					janelaErro.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(120, 414, 219, 42);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 18));
		panel1.add(btnNewButton);

		txtEmail = new JTextField();
		txtEmail.setBounds(127, 258, 212, 31);
		panel1.add(txtEmail);
		txtEmail.setBackground(new Color(255, 255, 255));
		txtEmail.setForeground(new Color(0, 0, 0));
		txtEmail.setFont(new Font("Dialog", Font.BOLD, 13));
		txtEmail.setColumns(10);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/imagem/titulo2.png")));
		lblNewLabel_2.setBounds(-361, 76, 734, 114);
		panel1.add(lblNewLabel_2);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/imagem/logo.png")));
		lblNewLabel.setBounds(-361, 66, 916, 150);
		panel1.add(lblNewLabel);

		txtSenha = new JPasswordField();
		txtSenha.setBackground(new Color(255, 255, 255));
		txtSenha.setBounds(127, 319, 212, 31);
		panel1.add(txtSenha);

		JLabel lblNewLabel_4 = new JLabel("E-mail:");
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_4.setBounds(128, 239, 56, 14);
		panel1.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(Login.class.getResource("/imagem/icone email.png")));
		lblNewLabel_5.setBounds(76, 234, 66, 55);
		panel1.add(lblNewLabel_5);

		lblNewLabel_3 = new JLabel("Senha:");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_3.setBounds(128, 300, 56, 14);
		panel1.add(lblNewLabel_3);

		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(Login.class.getResource("/imagem/icone senha.png")));
		lblNewLabel_6.setBounds(72, 295, 56, 55);
		panel1.add(lblNewLabel_6);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/imagem/fundo.png")));
		lblNewLabel_1.setBounds(0, 0, 2040, 1072);
		contentPane.add(lblNewLabel_1);
	}
}