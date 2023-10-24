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

public class DeletarUsuario1 extends JFrame {

	private JPanel contentPane;
	private JLabel lblFalha;

	/**
	 * Create the frame.
	 */
	public DeletarUsuario1(String mensagem) {
		setBackground(new Color(0, 128, 128));
		setType(Type.UTILITY);
		setBounds(100, 100, 346, 213);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		lblFalha = new JLabel("");
		lblFalha.setText(mensagem);
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
		btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); 
            }
        });
		contentPane.add(btnOk);
		
		JLabel lblAviso = new JLabel("");
		lblAviso.setIcon(new ImageIcon(LoginErro1.class.getResource("/imagem/MensageAviso.png")));
		lblAviso.setBounds(123, -20, 110, 84);
		contentPane.add(lblAviso);
		
		JLabel lblFalha = new JLabel("Falha ao excluir Usuario");
		lblFalha.setFont(new Font("Dialog", Font.BOLD, 12));
		lblFalha.setForeground(new Color(255, 255, 255));
		lblFalha.setBounds(111, 85, 137, 14);
		contentPane.add(lblFalha);
	}
}
