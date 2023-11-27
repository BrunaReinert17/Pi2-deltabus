package mensagens;

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

public class AlterarSucessoCliente extends JFrame {

	private JPanel contentPane;
	private JLabel lblSucesso1;
	

	/**
	 * Create the frame.
	 */
	public AlterarSucessoCliente(String mensagem) {
		setBackground(new Color(0, 128, 128));
		setType(Type.UTILITY);
		setBounds(100, 100, 346, 213);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		lblSucesso1 = new JLabel("");
		lblSucesso1.setText(mensagem);
		contentPane.setLayout(null);
		
		

		RoundButton btnOk = new RoundButton("Ok");
		btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); 
            }
        });
		btnOk.setBounds(132, 114, 55, 29);
		btnOk.setText("OK");
		btnOk.setForeground(new Color(255, 255, 255));
		btnOk.setFont(new Font("Dialog", Font.BOLD, 11));
		btnOk.setBackground(new Color(0, 0, 0));
		contentPane.add(btnOk);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CadastroSucesso.class.getResource("/imagem/MensageCerto.png")));
		lblNewLabel.setBounds(107, -20, 129, 82);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cliente Alterado!");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(107, 72, 137, 31);
		contentPane.add(lblNewLabel_1);
	}
}
