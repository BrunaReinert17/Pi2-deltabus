package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
		
		JButton btnHistorico = new JButton("Histórico");
		btnHistorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHistorico.setForeground(new Color(255, 255, 255));
		btnHistorico.setFont(new Font("Dialog", Font.BOLD, 15));
		btnHistorico.setBackground(new Color(0, 128, 128));
		btnHistorico.setBounds(90, 613, 199, 43);
		panel.add(btnHistorico);
		
		JButton btnNewButton_1 = new JButton("Consultar Cadastros");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 15));
		btnNewButton_1.setBackground(new Color(0, 128, 128));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(90, 687, 199, 43);
		panel.add(btnNewButton_1);
		
		JButton btnFuncionario = new JButton("+Funcionario");
		btnFuncionario.setForeground(new Color(255, 255, 255));
		btnFuncionario.setFont(new Font("Dialog", Font.BOLD, 15));
		btnFuncionario.setBackground(new Color(0, 128, 128));
		btnFuncionario.setBounds(90, 534, 199, 43);
		panel.add(btnFuncionario);
		
		JButton btnNewButton_1_1 = new JButton("Logout");
		btnNewButton_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_1_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1_1.setBounds(120, 815, 140, 43);
		panel.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Bem Vindo: Administrador");
		lblNewLabel_1.setForeground(new Color(0, 128, 128));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(109, 275, 184, 18);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(-792, 82, 1210, 211);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/perfil.png")));
		
		JButton btnadministrador = new JButton("+Administrador");
		btnadministrador.setForeground(Color.WHITE);
		btnadministrador.setFont(new Font("Dialog", Font.BOLD, 15));
		btnadministrador.setBackground(new Color(0, 128, 128));
		btnadministrador.setBounds(90, 457, 199, 43);
		panel.add(btnadministrador);
		
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
