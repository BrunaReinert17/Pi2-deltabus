package visao;

import javax.swing.JPanel; 

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controle.FuncionarioDAO;
import controle.VeiculoDAO;
import mensagens.ConfirmacaoDeletar;
import mensagens.Deletar1;
import mensagens.Deletar2;
import mensagens.InterfaceMensagemConfirmacao;
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
	private JTextField textrenavam;
	private ArrayList<Veiculo> listVei;

private void deletarVeiculo() {
		
		String renavam;
		
		renavam = String.valueOf(textrenavam.getText());
		
		Veiculo objveiculo = new Veiculo();
		objveiculo.setRenavam(renavam);
		
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
				new String[] { "Combutível", "Marca", "Modelo", "Placa", "Tipo de Frota", "Lotação", "Renavam", "Cor", "Acessórios", "Ano","Preço", "Situação" }));
		scrollPane.setViewportView(table);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 0, 1200, 40);
		panel_1.setBounds(0, 7, 1152, 46);
		add(panel_1);
		
		JLabel lblNewLabel = new JLabel("      Listagem de Veículos\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(0, 0, 352, 38);
		panel_1.add(lblNewLabel);
		
		RoundButton rndbtnDeletar = new RoundButton("Deletar");
		rndbtnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int linhaSelecionada = table.getSelectedRow();
				if (linhaSelecionada >= 0) {
			        Veiculo veiculo = listVei.get(linhaSelecionada);

			       
                   ConfirmacaoDeletar confirmacao = new ConfirmacaoDeletar("Tem certeza que quer excluir o veículo?", new InterfaceMensagemConfirmacao() {
			        	

						@Override
						
						public void mensagemConfirmada() {
							if (VeiculoDAO.excluirVeiculo(veiculo)) {
			                DefaultTableModel model = (DefaultTableModel) table.getModel();
			                model.removeRow(linhaSelecionada);
			            } else {
			                Deletar1 falha = new Deletar1("Falha ao excluir veiculo");
			                falha.setLocationRelativeTo(null);
			                falha.setVisible(true);
			            }
							
						}

						@Override
						public void mensagemCancelada() {
							
							
						}
			        	
			        });
			        confirmacao.setVisible(true);
			     
			    } else {
			        Deletar2 falha2 = new Deletar2("Selecione um veiculo para excluir");
			        falha2.setLocationRelativeTo(null);
			        falha2.setVisible(true);
			    }
			}
		});
			
		rndbtnDeletar.setText("Deletar");
		rndbtnDeletar.setForeground(Color.BLACK);
		rndbtnDeletar.setFont(new Font("Dialog", Font.BOLD, 16));
		rndbtnDeletar.setBackground(Color.WHITE);
		rndbtnDeletar.setBounds(1023, 3, 115, 33);
		panel_1.add(rndbtnDeletar);
		
		RoundButton rndbtnAlterar = new RoundButton("Alterar");
		

		rndbtnAlterar.setText("Alterar");
		rndbtnAlterar.setForeground(Color.WHITE);
		rndbtnAlterar.setFont(new Font("Dialog", Font.BOLD, 16));
		rndbtnAlterar.setBackground(new Color(0, 128, 128));
		rndbtnAlterar.setBounds(889, 3, 114, 33);
		panel_1.add(rndbtnAlterar);
		
		textrenavam = new JTextField();
		textrenavam.setColumns(10);
		textrenavam.setBounds(496, 12, 177, 20);
		panel_1.add(textrenavam);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setForeground(Color.WHITE);
		btnPesquisar.setFont(new Font
				("Dialog", Font.BOLD, 16));
		btnPesquisar.setBackground(new Color(0, 128, 128));
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cpfpesquisa = textrenavam.getText();
				atualizarTabela();
			}
		});
		btnPesquisar.setBounds(362, 10, 115, 23);
		panel_1.add(btnPesquisar);

		atualizarTabela();
	}
	public void atualizarTabela() {
		DefaultTableModel tabela = new DefaultTableModel(new Object[][] {}, new String[] {  "Combutível", "Marca", "Modelo", "Placa", "Tipo de Frota", "Lotação", "Renavam", "Cor", "Acessórios", "Ano","Preço", "Situação"  });
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		listVei = veiculoDAO.listar();
		System.out.println(listVei);
		for (int i = 0; i < listVei.size(); i++) {
			Veiculo veiculo = listVei.get(i);
			tabela.addRow(new Object[] { veiculo.getRenavam(), veiculo.getMarca(), veiculo.getModelo(),veiculo.getCor(),veiculo.getPlaca(),veiculo.getLotacao(),veiculo.getTipoFrota(),veiculo.getTipoCombustivel(),veiculo.getAcessorios(),veiculo.getAno(),veiculo.getPreco(),veiculo.getSituacao()});

		}
		table.setModel(tabela);
	}

	}

