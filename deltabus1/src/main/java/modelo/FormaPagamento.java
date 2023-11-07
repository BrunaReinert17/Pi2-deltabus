package modelo;

public enum FormaPagamento {
	
	CARTAO("Cartão"),DINHEIRO("Dinheiro"),PIX("Pix"),OUTRO("Outro");
	
	
	
	
	private String descricao;
	
	FormaPagamento(String descricao) {
			this.descricao = descricao;
		}
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.descricao;
	}
	
	public static FormaPagamento getFormaPagamento(String descricao) {
		for (FormaPagamento tipo : FormaPagamento.values()) {
			if(descricao.equalsIgnoreCase(tipo.getDescricao())) {
				return tipo;
			}
		}
		return null;
		
	}
	
	

}
