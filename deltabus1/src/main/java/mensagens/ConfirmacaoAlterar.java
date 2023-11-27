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
import javax.swing.JButton;

public class ConfirmacaoAlterar extends JFrame {

	private JPanel contentPane;
	private JLabel lblDadoInvalido;

	/**
	 * Create the frame.
	 */
	public ConfirmacaoAlterar (String mensagem, InterfaceMensagemConfirmacao janela) {
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

		RoundButton btnConfirmar = new RoundButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConfirmar.setBounds(47, 111, 94, 29);
		btnConfirmar.setText("Confirmar");
		btnConfirmar.setForeground(new Color(255, 255, 255));
		btnConfirmar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnConfirmar.setBackground(new Color(0, 0, 0));
		btnConfirmar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	janela.mensagemConfirmada();
                dispose(); 
                
            }
        });
		contentPane.add(btnConfirmar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CadastroErro.class.getResource("/imagem/MensageAviso.png")));
		lblNewLabel.setBounds(116, -15, 107, 76);
		contentPane.add(lblNewLabel);
		
		RoundButton btnCancelar = new RoundButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janela.mensagemCancelada();
                dispose(); 
			}
		});
		btnCancelar.setText("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnCancelar.setBackground(Color.BLACK);
		btnCancelar.setBounds(198, 111, 94, 29);
		contentPane.add(btnCancelar);
		
		JLabel lblNewLabel_1 = new JLabel("Tem certeza que deseja realizar alteração?");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(39, 72, 253, 14);
		contentPane.add(lblNewLabel_1);
	}
}
