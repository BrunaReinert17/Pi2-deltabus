package visao;

import javax.swing.JPanel;
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


	

private void deletarFuncionario() {
		
		long cpf;
		
		cpf = Long.valueOf(textRenavam.getText());
		
		Funcionario objfuncionario = new Funcionario();
		objfuncionario.setCpf(cpf);
		
		FuncionarioDAO objfuncionariodao = new FuncionarioDAO();
		
		objfuncionariodao.deletarFuncionario(objfuncionario);
		
	}

	
	
	public ListagemVeiculos() {
		setBackground(new Color(0, 0, 0));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(27, 64, 1125, 735);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1136, 28);
		panel.add(scrollPane);
		
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setFont(new Font("Dialog", Font.BOLD, 14));
		
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Renavam", "Marca", "Modelo", "Cor", "Placa", "Lotação", "Frota", "Combustível", "Acessórios", "Ano","Situação", "Preço" }));
		scrollPane.setViewportView(table);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 7, 1200, 46);
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
		rndbtnAlterar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		        int selectedRow = table.getSelectedRow();

		        if (selectedRow == -1) {
		            JOptionPane.showMessageDialog(null, "Nenhum veículo selecionado.", "Erro", JOptionPane.ERROR_MESSAGE);
		        } else {
		            // Obtenha os valores atuais da linha selecionada
		            String renavam = table.getValueAt(selectedRow, 0).toString();
		            String marca = table.getValueAt(selectedRow, 1).toString();
		            String modelo = table.getValueAt(selectedRow, 2).toString();
		            String cor = table.getValueAt(selectedRow, 3).toString();
		            String placa = table.getValueAt(selectedRow, 4).toString();
		            int locacao = Integer.parseInt(table.getValueAt(selectedRow, 5).toString());
		            String frota = table.getValueAt(selectedRow, 6).toString();
		            String combustivel = table.getValueAt(selectedRow, 7).toString();
		            String acessorio = table.getValueAt(selectedRow, 8).toString();
		            Long idVeiculo = Long.parseLong(table.getValueAt(selectedRow, 9).toString());
		            double preco = Double.parseDouble(table.getValueAt(selectedRow, 12).toString());
		            Date ano = null;
					try {
						ano = dateFormat.parse(toString());
					} catch (ParseException e1) {
						e1.printStackTrace();
					}		            
		            

		            // Crie uma janela de diálogo para edição
		            JTextField renavamField = new JTextField(renavam);
		            JTextField marcaField = new JTextField(marca);
		            JTextField modeloField = new JTextField(modelo);
		            JTextField corField = new JTextField(cor);
		            JTextField placaField = new JTextField(placa);
		            JTextField locacaoField = new JTextField(String.valueOf(locacao));
		            JTextField frotaField = new JTextField(frota);
		            JTextField combustivelField = new JTextField(combustivel);
		            JTextField acessorioField = new JTextField(acessorio);
		            JTextField idVeiculoField = new JTextField(String.valueOf(idVeiculo));
		            JTextField anoField = new JTextField(ano.toString());
		            JTextField precoField = new JTextField(String.valueOf(preco));

		            // Adicione campos para os outros atributos...

		            JPanel editPanel = new JPanel(new GridLayout(0, 2));
		            editPanel.add(new JLabel("Renavam:"));
		            editPanel.add(renavamField);
		            editPanel.add(new JLabel("Marca:"));
		            editPanel.add(marcaField);
		            editPanel.add(new JLabel("Modelo:"));
		            editPanel.add(modeloField);
		            editPanel.add(new JLabel("Cor:"));
		            editPanel.add(corField);
		            editPanel.add(new JLabel("Placa:"));
		            editPanel.add(placaField);
		            editPanel.add(new JLabel("Locação:"));
		            editPanel.add(locacaoField);
		            editPanel.add(new JLabel("Frota:"));
		            editPanel.add(frotaField);
		            editPanel.add(new JLabel("Combustível:"));
		            editPanel.add(combustivelField);
		            editPanel.add(new JLabel("Acessório:"));
		            editPanel.add(acessorioField);
		            editPanel.add(new JLabel("Id Veículo:"));
		            editPanel.add(idVeiculoField);
		            editPanel.add(new JLabel("Ano:"));
		            editPanel.add(anoField);
		            editPanel.add(new JLabel("Preço:"));
		            editPanel.add(precoField);

		            // Adicione campos para os outros atributos...

		            int result = JOptionPane.showConfirmDialog(null, editPanel, "Editar Veículo",
		                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

		            if (result == JOptionPane.OK_OPTION) {
		                // Obtenha os novos valores dos campos
		                String novoRenavam = renavamField.getText();
		                String novaMarca = marcaField.getText();
		                String novoModelo = modeloField.getText();
		                String novaCor = corField.getText();
		                String novaPlaca = placaField.getText();
		                int novaLocacao = Integer.parseInt(locacaoField.getText());
		                String novaFrota = frotaField.getText();
		                String novoCombustivel = combustivelField.getText();
		                String novoAcessorio = acessorioField.getText();
		                Long novoIdVeiculo = Long.parseLong(idVeiculoField.getText());
		                Date novoAno = java.sql.Date.valueOf(anoField.getText());
		                double novoPreco = Double.parseDouble(precoField.getText());

		                // Atualize os valores na tabela
		                table.setValueAt(novoRenavam, selectedRow, 0);
		                table.setValueAt(novaMarca, selectedRow, 1);
		                table.setValueAt(novoModelo, selectedRow, 2);
		                table.setValueAt(novaCor, selectedRow, 3);
		                table.setValueAt(novaPlaca, selectedRow, 4);
		                table.setValueAt(novaLocacao, selectedRow, 5);
		                table.setValueAt(novaFrota, selectedRow, 6);
		                table.setValueAt(novoCombustivel, selectedRow, 7);
		                table.setValueAt(novoAcessorio, selectedRow, 8);
		                table.setValueAt(novoIdVeiculo, selectedRow, 9);
		                table.setValueAt(novoAno, selectedRow, 10);
		                table.setValueAt(novoPreco, selectedRow, 12);

		                // Continue com os outros campos...

		                // Aqui você pode salvar as alterações no seu banco de dados ou em algum lugar que desejar
		            }
		        }
		    }
		});

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

