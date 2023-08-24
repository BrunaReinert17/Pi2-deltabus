package controle;

import modelo.Endereco;

public interface InterfaceEndereco {

	public Endereco consultandoEndereco(Endereco endereco);

	public boolean inserirEndereco(Endereco endereco);

	public boolean excluirEndereco(Endereco endereco);

	public boolean alterarEndereco(Endereco endereco);
}