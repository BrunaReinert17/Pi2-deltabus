package mensagens;

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

public class CadastroSucesso extends JFrame {

	private JPanel contentPane;
	private JLabel lblSucesso;

	/**
	 * Create the frame.
	 */
	public CadastroSucesso(String mensagem) {
		setBackground(new Color(0, 128, 128));
		setType(Type.UTILITY);
		setBounds(100, 100, 346, 213);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);

		RoundButton btnOk = new RoundButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnOk.setBounds(146, 123, 55, 29);
		btnOk.setText("OK");
		btnOk.setForeground(new Color(255, 255, 255));
		btnOk.setFont(new Font("Dialog", Font.BOLD, 11));
		btnOk.setBackground(new Color(0, 0, 0));
		contentPane.add(btnOk);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CadastroSucesso.class.getResource("/imagem/MensageCerto.png")));
		lblNewLabel.setBounds(122, -21, 129, 82);
		contentPane.add(lblNewLabel);

		lblSucesso = new JLabel(mensagem);
		lblSucesso.setForeground(new Color(255, 255, 255));
		lblSucesso.setFont(new Font("Dialog", Font.BOLD, 12));
		lblSucesso.setBounds(73, 81, 211, 14);
		contentPane.add(lblSucesso);
	}
}
