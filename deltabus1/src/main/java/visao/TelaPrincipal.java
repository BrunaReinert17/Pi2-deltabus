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
		setBackground(new Color(51, 102, 102));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2000, 1500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 376, 733);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnHistorico = new JButton("Histórico");
		btnHistorico.setForeground(new Color(255, 255, 255));
		btnHistorico.setFont(new Font("Dialog", Font.BOLD, 14));
		btnHistorico.setBackground(new Color(0, 128, 128));
		btnHistorico.setBounds(90, 412, 199, 37);
		panel.add(btnHistorico);
		
		JButton btnNewButton_1 = new JButton("Consultar Cadastros");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(0, 128, 128));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(90, 469, 199, 37);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(0, 0, 0));
		btnNewButton_2.setBounds(79, 876, 185, 37);
		panel.add(btnNewButton_2);
		
		JButton btnFuncionario = new JButton("Funcionario");
		btnFuncionario.setForeground(new Color(255, 255, 255));
		btnFuncionario.setFont(new Font("Dialog", Font.BOLD, 14));
		btnFuncionario.setBackground(new Color(0, 128, 128));
		btnFuncionario.setBounds(90, 353, 199, 37);
		panel.add(btnFuncionario);
		
		JButton btnNewButton_1_1 = new JButton("Logout");
		btnNewButton_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_1_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1_1.setBounds(124, 574, 140, 37);
		panel.add(btnNewButton_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/teste.png")));
		lblNewLabel.setBounds(-73, 260, 1260, 209);
		contentPane.add(lblNewLabel);
	}
}
