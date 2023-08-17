package controle;

import java.util.ArrayList;

import modelo.Funcionario;

public class FuncionarioDAO{
    
	private static ArrayList<Funcionario> listaFuncionario;

	private static FuncionarioDAO funcionarioDao;

	public static void getIntancia() {
		if (funcionarioDao == null) {
			funcionarioDao = new FuncionarioDAO();
			listaFuncionario = new ArrayList<Funcionario>();
			
			listaFuncionario.add(
					new Funcionario("Bruna", 14058567937l, "bruna@gmail.com", "secretaria", "bruna18"));
			listaFuncionario.add(new Funcionario("agatha",123456789101l,"agatha@gmail.com","vice secretaria","agatha12"));
			listaFuncionario.add(new Funcionario("Maria Tereza",123456789101l,"maria@gmail.com","gerente","maria05"));
			listaFuncionario.add(new Funcionario("Aguida",123456789101l,"aguida@gmail.com","vice gerente","aguida123"));
			}
	
	
}
}