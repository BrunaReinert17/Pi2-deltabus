package controle;

import modelo.Funcionario;

public interface InterfaceFuncionario {

	public long inserirFuncionario(Funcionario funcionario);

	public boolean deletarFuncionario(Funcionario funcionario);

	public boolean alterarFuncionario(Funcionario funcionario);
}