package Mensagens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import utilidades.RoundButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class LoginErro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginErro frame = new LoginErro();
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
	public LoginErro() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 346, 213);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		RoundButton btnConfirmar = new RoundButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConfirmar.setBounds(144, 120, 56, 29);
		btnConfirmar.setText("OK");
		btnConfirmar.setForeground(new Color(255, 255, 255));
		btnConfirmar.setFont(new Font("Dialog", Font.BOLD, 14));
		btnConfirmar.setBackground(new Color(0, 0, 0));
		contentPane.add(btnConfirmar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LoginErro.class.getResource("/imagem/background.png")));
		lblNewLabel_1.setBounds(-75, 0, 418, 174);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Preencha os Campos!");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBounds(105, 72, 191, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(LoginErro.class.getResource("/imagem/logoMensagens.png")));
		lblNewLabel_2.setBounds(84, 0, 149, 67);
		contentPane.add(lblNewLabel_2);
	}
}
