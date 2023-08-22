package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utilidades.RoundButton;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.Toolkit;

public class TelaCadastroFuncionario extends JFrame {

	private JPanel contentPane;
	private RoundButton btnadministrador;
	private RoundButton btnFuncionario;
	private RoundButton btnLogout;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroFuncionario frame = new TelaCadastroFuncionario();
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
	public TelaCadastroFuncionario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroFuncionario.class.getResource("/imagem/logoampliada.png")));
		setTitle("Cadastrar Funcionário");
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
		
		btnadministrador = new RoundButton("Cadastro de Usuário");
		btnadministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnadministrador.setForeground(Color.WHITE);
		btnadministrador.setFont(new Font("Dialog", Font.BOLD, 15));
		btnadministrador.setBackground(new Color(0, 128, 128));
		btnadministrador.setBounds(90, 457, 199, 43);
		panel.add(btnadministrador);
		
		btnFuncionario = new RoundButton("Verificar");
		btnFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFuncionario.setForeground(new Color(255, 255, 255));
		btnFuncionario.setFont(new Font("Dialog", Font.BOLD, 15));
		btnFuncionario.setBackground(new Color(0, 128, 128));
		btnFuncionario.setBounds(90, 534, 199, 43);
		panel.add(btnFuncionario);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("admin");
		lblNewLabel_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(141, 276, 184, 18);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(-792, 82, 1210, 211);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/perfil.png")));
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TelaCadastroFuncionario.class.getResource("/imagem/deltabus.png")));
		lblNewLabel.setBounds(1186, 868, 830, 126);
		contentPane.add(lblNewLabel);
	}
}
