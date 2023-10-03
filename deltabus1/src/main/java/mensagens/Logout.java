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
import visao.Login;

public class Logout extends JFrame {

	private JPanel contentPane;
	private JLabel lblLogout;

	/**
	 * Create the frame.
	 */
	public Logout(String mensagem) {
		setBackground(new Color(0, 128, 128));
		setType(Type.UTILITY);
		setBounds(100, 100, 346, 213);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		lblLogout = new JLabel("");
		lblLogout.setText(mensagem);
		contentPane.setLayout(null);

		RoundButton btnSim = new RoundButton("Sim");
		btnSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSim.setBounds(100, 118, 61, 29);
		btnSim.setText("SIM");
		btnSim.setForeground(new Color(0, 128, 128));
		btnSim.setFont(new Font("Dialog", Font.BOLD, 11));
		btnSim.setBackground(new Color(255, 255, 255));
		btnSim.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Login telaLogin = new Login();
				telaLogin.setLocationRelativeTo(null);
				telaLogin.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnSim);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Logout.class.getResource("/imagem/MensageInterrogação.png")));
		lblNewLabel.setBounds(131, 11, 96, 96);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Logout.class.getResource("/imagem/mensage7.png")));
		lblNewLabel_1.setBounds(67, 81, 240, 29);
		contentPane.add(lblNewLabel_1);
		
		RoundButton btnNao = new RoundButton("Não");
		btnNao.setText("NÃO");
		btnNao.setForeground(new Color(255, 255, 255));
		btnNao.setFont(new Font("Dialog", Font.BOLD, 11));
		btnNao.setBackground(new Color(0, 0, 0));
		btnNao.setBounds(182, 118, 61, 29);
		btnNao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); 
            }
        });
		contentPane.add(btnNao);
	}
}
