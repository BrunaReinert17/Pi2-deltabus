package controle;

import modelo.Funcionario;

public interface InterfaceFuncionario {

	public boolean inserirFuncionario(Funcionario funcionario);

	public boolean deletarFuncionario(Funcionario funcionario);

	public boolean alterarFuncionario(Funcionario funcionario);
}