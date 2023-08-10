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
		panel.setBounds(799, 305, 383, 502);
		panel.setBackground(new Color(255, 255, 255));
		panel.setForeground(new Color(204, 204, 204));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(47, 79, 79));
		btnNewButton.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 15));
		btnNewButton.setBounds(76, 420, 219, 42);
		panel.add(btnNewButton);
		
		txtSenha = new JTextField();
		txtSenha.setText("    Senha : ");
		txtSenha.setForeground(Color.BLACK);
		txtSenha.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 13));
		txtSenha.setColumns(10);
		txtSenha.setBackground(SystemColor.controlHighlight);
		txtSenha.setBounds(49, 299, 274, 31);
		panel.add(txtSenha);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(49, 225, 274, 31);
		panel.add(txtEmail);
		txtEmail.setBackground(SystemColor.controlHighlight);
		txtEmail.setForeground(new Color(0, 0, 0));
		txtEmail.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 13));
		txtEmail.setText("    Email : ");
		txtEmail.setColumns(10);
	}
}
