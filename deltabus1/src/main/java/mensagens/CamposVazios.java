package mensagens;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utilidades.RoundButton;

public class CamposVazios extends JFrame {

	private JPanel contentPane;
	private JLabel lblDadoInvalido;

	/**
	 * Create the frame.
	 */
	public CamposVazios (String mensagem) {
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CadastroErro.class.getResource("/imagem/MensageAviso.png")));
		lblNewLabel.setBounds(124, -15, 107, 76);
		contentPane.add(lblNewLabel);
		
		JLabel lblErroAlterar = new JLabel("Campos vazios, tente novamente!");
		lblErroAlterar.setFont(new Font("Dialog", Font.BOLD, 13));
		lblErroAlterar.setForeground(Color.WHITE);
		lblErroAlterar.setBounds(59, 82, 261, 24);
		contentPane.add(lblErroAlterar);
	}
}