package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTable;

public class TelaCadastroFuncionario extends JFrame {

	private JPanel contentPane;

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
		
		JButton btnadministrador = new JButton("+Administrador");
		btnadministrador.setForeground(Color.WHITE);
		btnadministrador.setFont(new Font("Dialog", Font.BOLD, 15));
		btnadministrador.setBackground(new Color(0, 128, 128));
		btnadministrador.setBounds(90, 457, 199, 43);
		panel.add(btnadministrador);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("Administrador");
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
