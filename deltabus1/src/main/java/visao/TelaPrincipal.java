package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utilidades.RoundButton;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private RoundButton btnCadastrarUsuarios;
	private RoundButton btnVerificar;
	private RoundButton bntLogout;


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
		btnVerificar.setForeground(new Color(255, 255, 255));
		btnVerificar.setFont(new Font("Dialog", Font.BOLD, 15));
		btnVerificar.setBackground(new Color(0, 128, 128));
		btnVerificar.setBounds(90, 534, 199, 43);
		panel.add(btnVerificar);
		
		JButton btnLogout = new RoundButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogout.setForeground(new Color(255, 255, 255));
		btnLogout.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		btnLogout.setBackground(new Color(0, 0, 0));
		btnLogout.setBounds(120, 815, 140, 43);
		panel.add(btnLogout);
		
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
		btnCadastrarUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrarUsuarios.setForeground(Color.WHITE);
		btnCadastrarUsuarios.setFont(new Font("Dialog", Font.BOLD, 15));
		btnCadastrarUsuarios.setBackground(new Color(0, 128, 128));
		btnCadastrarUsuarios.setBounds(90, 457, 199, 43);
		panel.add(btnCadastrarUsuarios);
		
		btnCadastrarUsuarios.setForeground(Color.WHITE);
		btnCadastrarUsuarios.setFont(new Font("Dialog", Font.BOLD, 15));
		btnCadastrarUsuarios.setBackground(new Color(0, 128, 128));
		btnCadastrarUsuarios.setBounds(90, 457, 199, 43);
		panel.add(btnCadastrarUsuarios);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaCadastroFuncionario.class.getResource("/imagem/Telas Pi (2).png")));
		lblNewLabel.setBounds(276, 290, 1456, 407);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel1 = new JLabel("New label");
		lblNewLabel1.setIcon(new ImageIcon(TelaCadastroFuncionario.class.getResource("/imagem/deltabus.png")));
		lblNewLabel1.setBounds(1186, 868, 830, 126);
		contentPane.add(lblNewLabel1);
	}
}
