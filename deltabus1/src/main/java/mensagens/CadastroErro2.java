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

public class CadastroErro2 extends JFrame {

	private JPanel contentPane;
	private JLabel lblDadoInvalido;

	/**
	 * Create the frame.
	 */
	public CadastroErro2 (String mensagem) {
		setBackground(new Color(0, 128, 128));
		setType(Type.UTILITY);
		setBounds(100, 100, 346, 213);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		lblDadoInvalido = new JLabel("");
		lblDadoInvalido.setText(mensagem);
		contentPane.setLayout(null);

		RoundButton btnOk = new RoundButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOk.setBounds(143, 122, 55, 29);
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CadastroErro1.class.getResource("/imagem/MensageAviso.png")));
		lblNewLabel.setBounds(121, -16, 105, 78);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Veriique os campos e tente novamente!");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_1.setBounds(50, 85, 240, 14);
		contentPane.add(lblNewLabel_1);
	}
}
