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

public class Alterar1 extends JFrame {

	private JPanel contentPane;
	private JLabel lblFalha2;

	/**
	 * Create the frame.
	 */
	public Alterar1(String mensagem) {
		setBackground(new Color(0, 128, 128));
		setType(Type.UTILITY);
		setBounds(100, 100, 346, 213);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		lblFalha2 = new JLabel("");
		lblFalha2.setText(mensagem);
		contentPane.setLayout(null);

		RoundButton btnOk = new RoundButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOk.setBounds(139, 123, 55, 29);
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
		lblAviso.setBounds(117, -19, 110, 84);
		contentPane.add(lblAviso);
		
		JLabel lblFalha2 = new JLabel("Selecione uma linha da lista para Alterar");
		lblFalha2.setFont(new Font("Dialog", Font.BOLD, 12));
		lblFalha2.setForeground(new Color(255, 255, 255));
		lblFalha2.setBounds(52, 82, 246, 14);
		contentPane.add(lblFalha2);
	}
}
