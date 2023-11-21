package controle;

import modelo.Endereco;

public interface InterfaceEndereco {

	public Endereco listandoEndereco(Endereco endereco);

	public long inserirEndereco(Endereco endereco);

	public boolean excluirEndereco(Endereco endereco);

	public boolean alterarEndereco(Endereco endereco);
}