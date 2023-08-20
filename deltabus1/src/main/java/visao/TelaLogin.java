package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
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

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField txtSenha;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/imagem/logoampliada.png")));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2000, 1500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 102));
		contentPane.setForeground(new Color(0, 102, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(751, 218, 447, 549);
		panel1.setBackground(new Color(255, 255, 255));
		panel1.setForeground(new Color(204, 204, 204));
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(116, 384, 219, 42);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 18));
		panel1.add(btnNewButton);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(87, 291, 274, 31);
		txtSenha.setText("    Senha: ");
		txtSenha.setForeground(Color.BLACK);
		txtSenha.setFont(new Font("Dialog", Font.BOLD, 13));
		txtSenha.setColumns(10);
		txtSenha.setBackground(new Color(245, 245, 245));
		panel1.add(txtSenha);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(87, 237, 274, 31);
		panel1.add(txtEmail);
		txtEmail.setBackground(new Color(245, 245, 245));
		txtEmail.setForeground(new Color(0, 0, 0));
		txtEmail.setFont(new Font("Dialog", Font.BOLD, 13));
		txtEmail.setText("    Email: ");
		txtEmail.setColumns(10);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagem/titulo2.png")));
		lblNewLabel_2.setBounds(-363, 51, 734, 114);
		panel1.add(lblNewLabel_2);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagem/logo.png")));
		lblNewLabel.setBounds(-363, 11, 916, 225);
		panel1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagem/fundo.png")));
		lblNewLabel_1.setBounds(0, 0, 2040, 1072);
		contentPane.add(lblNewLabel_1);
	}
}
