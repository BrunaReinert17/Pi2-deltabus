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

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JTextField txtSenha;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2000, 1500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 102));
		contentPane.setForeground(new Color(0, 102, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(750, 176, 447, 549);
		panel.setBackground(new Color(255, 255, 255));
		panel.setForeground(new Color(204, 204, 204));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(119, 383, 219, 42);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 18));
		panel.add(btnNewButton);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(87, 291, 274, 31);
		txtSenha.setText("    Senha: ");
		txtSenha.setForeground(Color.BLACK);
		txtSenha.setFont(new Font("Dialog", Font.BOLD, 13));
		txtSenha.setColumns(10);
		txtSenha.setBackground(new Color(245, 245, 245));
		panel.add(txtSenha);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(87, 237, 274, 31);
		panel.add(txtEmail);
		txtEmail.setBackground(new Color(245, 245, 245));
		txtEmail.setForeground(new Color(0, 0, 0));
		txtEmail.setFont(new Font("Dialog", Font.BOLD, 13));
		txtEmail.setText("    Email: ");
		txtEmail.setColumns(10);
		
		lblNewLabel = new JLabel("DELTABUS");
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel.setBounds(141, 130, 163, 31);
		panel.add(lblNewLabel);
	}
}
