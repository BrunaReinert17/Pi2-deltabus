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
		lblSucesso = new JLabel("");
		lblSucesso.setText(mensagem);
		contentPane.setLayout(null);

		RoundButton btnConfirmar = new RoundButton("Ok");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnConfirmar.setBounds(146, 123, 55, 29);
		btnConfirmar.setText("OK");
		btnConfirmar.setForeground(new Color(255, 255, 255));
		btnConfirmar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnConfirmar.setBackground(new Color(0, 0, 0));
		contentPane.add(btnConfirmar);
		
		JLabel lblSucesso = new JLabel("");
		lblSucesso.setIcon(new ImageIcon(CadastroSucesso.class.getResource("/imagem/mensage3.png")));
		lblSucesso.setBounds(59, 72, 261, 40);
		contentPane.add(lblSucesso);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(CadastroSucesso.class.getResource("/imagem/logoMensagens2.png")));
		lblNewLabel_1.setBounds(122, -17, 116, 78);
		contentPane.add(lblNewLabel_1);
	}
}
