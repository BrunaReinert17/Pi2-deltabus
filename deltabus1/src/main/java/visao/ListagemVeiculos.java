package visao;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.FuncionarioDAO;
import controle.VeiculoDAO;
import modelo.Funcionario;
import modelo.Veiculo;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.SwingConstants;
import utilidades.RoundButton;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ListagemVeiculos extends JPanel {
	private JTable table;
	private JTextField textRenavam;
	private ArrayList<Veiculo> listVei;


	

private void deletarVeiculo() {
		
		Long idveiculo;
		
		idveiculo = Long.valueOf(textRenavam.getText());
		
		Veiculo objveiculo = new Veiculo();
		objveiculo.setIdVeiculo(idveiculo);
		
		VeiculoDAO objveiculodao = new VeiculoDAO();
		
		objveiculodao.excluirVeiculo(objveiculo);
		}

	
	
	public ListagemVeiculos() {
		setBackground(new Color(0, 0, 0));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 51, 1179, 748);
		add(panel);
		panel.setLayout(new BorderLayout());
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 37, 1184, 689);
		panel.add(scrollPane, BorderLayout.CENTER);
		
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("Dialog", Font.BOLD, 14));
		
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Renavam", "Marca", "Modelo", "Cor", "Placa", "Lotação", "Frota", "Combustível", "Acessórios", "Ano","Situação", "Preço" }));
		scrollPane.setViewportView(table);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 0, 1200, 40);
		add(panel_1);
		
		JLabel lblNewLabel = new JLabel("      Listagem de Veículos\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(0, 0, 352, 38);
		panel_1.add(lblNewLabel);
		
		RoundButton rndbtnDeletar = new RoundButton("Deletar");
		rndbtnDeletar.setText("Deletar");
		rndbtnDeletar.setForeground(Color.BLACK);
		rndbtnDeletar.setFont(new Font("Dialog", Font.BOLD, 16));
		rndbtnDeletar.setBackground(Color.WHITE);
		rndbtnDeletar.setBounds(1050, 3, 115, 33);
		panel_1.add(rndbtnDeletar);
		
		RoundButton rndbtnAlterar = new RoundButton("Alterar");
		

		rndbtnAlterar.setText("Alterar");
		rndbtnAlterar.setForeground(Color.WHITE);
		rndbtnAlterar.setFont(new Font("Dialog", Font.BOLD, 16));
		rndbtnAlterar.setBackground(new Color(0, 128, 128));
		rndbtnAlterar.setBounds(918, 4, 114, 33);
		panel_1.add(rndbtnAlterar);
		
		textRenavam = new JTextField();
		textRenavam.setColumns(10);
		textRenavam.setBounds(496, 12, 177, 20);
		panel_1.add(textRenavam);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setForeground(Color.WHITE);
		btnPesquisar.setFont(new Font("Dialog", Font.BOLD, 16));
		btnPesquisar.setBackground(new Color(0, 128, 128));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpfpesquisa = textRenavam.getText();
				atualizarTabela();
			}
		});
		btnPesquisar.setBounds(362, 10, 115, 23);
		panel_1.add(btnPesquisar);

		atualizarTabela();
	}
	public void atualizarTabela() {
		DefaultTableModel tabela = new DefaultTableModel(new Object[][] {}, new String[] { "Renavam", "Marca", "Modelo", "Cor", "Placa", "Lotação", "Frota", "Combustível", "Acessórios", "Ano", "Preço"  });
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		listVei = veiculoDAO.listar();
		System.out.println(listVei);
		for (int i = 0; i < listVei.size(); i++) {
			Veiculo veiculo = listVei.get(i);
			tabela.addRow(new Object[] { veiculo.getRenavam(), veiculo.getMarca(), veiculo.getModelo(),veiculo.getCor(),veiculo.getPlaca(),veiculo.getLotacao(),veiculo.getTipoFrota(),veiculo.getTipoCombustivel(),veiculo.getAcessorios(),veiculo.getAno(),veiculo.getPreco()});

		}
		table.setModel(tabela);
	}

	}

