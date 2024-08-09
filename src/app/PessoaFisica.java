package app;

public class PessoaFisica {
	
	private String cpf,
			email,
			nome;
	
	public PessoaFisica(String nome, String cpf, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}



	public String toString() {
		String resposta = super.toString() + '\n';
		resposta += "CPF: " + cpf + '\n'; 
		resposta += "EMAIL: " + email + '\n';
		return resposta;
	}
}