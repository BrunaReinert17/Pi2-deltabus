package Mensagens;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utilidades.RoundButton;

public class LoginErro1 extends JFrame {

	private JPanel contentPane;
	private JLabel lblMsg1;

	/**
	 * Create the frame.
	 */
	public LoginErro1(String mensagem) {
		setBackground(new Color(0, 128, 128));
		setType(Type.UTILITY);
		setBounds(100, 100, 346, 213);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		lblMsg1 = new JLabel("");
		lblMsg1.setText(mensagem);
		contentPane.setLayout(null);

		RoundButton btnOk = new RoundButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOk.setBounds(146, 123, 55, 29);
		btnOk.setText("OK");
		btnOk.setForeground(new Color(255, 255, 255));
		btnOk.setFont(new Font("Dialog", Font.BOLD, 11));
		btnOk.setBackground(new Color(0, 0, 0));
		contentPane.add(btnOk);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LoginErro.class.getResource("/imagem/aviso.png")));
		lblNewLabel_1.setBounds(124, -18, 86, 82);
		contentPane.add(lblNewLabel_1);

		JLabel lblMsg = new JLabel("");
		lblMsg.setIcon(new ImageIcon(LoginErro.class.getResource("/imagem/mensage1.png")));
		lblMsg.setBounds(39, 75, 254, 39);
		contentPane.add(lblMsg);
	}
}
