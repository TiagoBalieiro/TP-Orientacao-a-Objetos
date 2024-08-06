package app;

public class PessoaFisica extends ItensCadastrados {
	
	private String cpf,
	               email;
	
	public PessoaFisica(String nome, String cpf, String email,int id) {
		super(id,nome);
		this.cpf = cpf;
		this.email = email;
	}


	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public String toString() {
		String resposta = super.toString() + '\n';
		resposta += "CPF: " + cpf + '\n'; 
		resposta += "EMAIL: " + email + '\n';
		return resposta;
	}
}