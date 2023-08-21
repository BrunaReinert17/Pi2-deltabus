package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import utilidades.RoundButton;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarUsuario extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JPanel panel;
	private JPanel panel_1;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarUsuario frame = new CadastrarUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastrarUsuario() {
		setTitle("Cadastrar Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(800, 800, 800, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(0, 0, 0));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0)),
				"", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(0, 128, 128)));
		panel.setBounds(57, 121, 663, 415);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 18, 643, 386);
		panel.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("Dialog", Font.BOLD, 14));

		table.getColumn(0).setPreferredWidth(5);
		table.getColumn(1).setPreferredWidth(5000);

		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Nome", "Email", "Cpf", "Telefone", "Data de Nascimento", "Genero", "Endereço" }));
		scrollPane.setViewportView(table);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		panel_1.setBounds(57, 100, 663, 23);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("   Cadastrar Usuario\r\n");
		lblNewLabel.setBounds(0, 0, 663, 23);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel_1.add(lblNewLabel);


	}
}
