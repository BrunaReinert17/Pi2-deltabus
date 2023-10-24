package mensagens;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import utilidades.RoundButton;
import visao.Login;

public class Limpar extends JFrame {

	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtDataNasci;
	private JTextField txtCep;
	private JTextField txtSenha;
	private JTextField txtBairro;
	private JTextField textRua;
	private JComboBox cbUf;
	private JComboBox cbCidade;
	private JComboBox cbFuncao;
	private JComboBox cbGenero;

	private JPanel contentPane;
	private JLabel lblLimpar;

	/**
	 * Create the frame.
	 */
	public Limpar (String mensagem) {
		setBackground(new Color(0, 128, 128));
		setType(Type.UTILITY);
		setBounds(100, 100, 346, 213);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		lblLimpar = new JLabel("");
		lblLimpar.setText(mensagem);
		contentPane.setLayout(null);

		RoundButton btnSim = new RoundButton("Sim");
		btnSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtCpf.setText("");
				txtEmail.setText("");
				txtTelefone.setText("");
				txtDataNasci.setText("");
				txtCep.setText("");
				txtSenha.setText("");
				txtBairro.setText("");
				textRua.setText("");
				cbUf.setSelectedIndex(-1);
				cbCidade.setSelectedIndex(-1);
				cbFuncao.setSelectedIndex(-1);
				cbGenero.setSelectedIndex(-1);
				dispose();
			}
		});
		btnSim.setBounds(100, 118, 61, 29);
		btnSim.setText("SIM");
		btnSim.setForeground(new Color(0, 128, 128));
		btnSim.setFont(new Font("Dialog", Font.BOLD, 11));
		btnSim.setBackground(new Color(255, 255, 255));
		btnSim.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	txtNome.setText("");
				txtCpf.setText("");
				txtEmail.setText("");
				txtTelefone.setText("");
				txtDataNasci.setText("");
				txtCep.setText("");
				txtSenha.setText("");
				txtBairro.setText("");
				textRua.setText("");
				cbUf.setSelectedIndex(-1);
				cbCidade.setSelectedIndex(-1);
				cbFuncao.setSelectedIndex(-1);
				cbGenero.setSelectedIndex(-1);
				dispose();
			}
		});
		contentPane.add(btnSim);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Logout.class.getResource("/imagem/MensageInterrogação.png")));
		lblNewLabel.setBounds(131, 11, 96, 96);
		contentPane.add(lblNewLabel);
		
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
		
		JLabel lblNewLabel_1 = new JLabel("Tem certeza de que deseja limpar os dados?");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNewLabel_1.setBounds(44, 79, 286, 14);
		contentPane.add(lblNewLabel_1);
	}
public void limparDados() {
	txtNome.setText("");
	txtCpf.setText("");
	txtEmail.setText("");
	txtTelefone.setText("");
	txtDataNasci.setText("");
	txtCep.setText("");
	txtSenha.setText("");
	txtBairro.setText("");
}
}
