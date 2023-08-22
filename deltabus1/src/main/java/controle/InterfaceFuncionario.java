package controle;

import modelo.Funcionario;

public interface InterfaceFuncionario {

	public boolean inserirFuncionario(Funcionario funcionario);

	public boolean deletarFuncionario(Funcionario funcionario);

	public Funcionario alterarFuncionario(Funcionario funcionario);
}
