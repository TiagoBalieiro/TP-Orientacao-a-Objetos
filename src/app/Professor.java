package app;

public class Professor extends PessoaFisica{
	
	String areaFormacao, 
	       matriculaFUB; 
	
	public Professor(String nome, String cpf, String email, String areaFormacao, String matriculaFUB, int id) {
		super(nome, cpf, email,id);
		this.areaFormacao = areaFormacao;
		this.matriculaFUB = matriculaFUB;
	}

	public final String getAreaFormacao() {
		return areaFormacao;
	}

	public final String getMatriculaFUB() {
		return matriculaFUB;
	}

	protected void finalize() throws Throwable {
		System.out.println("Destruindo objeto: " + this);
	}
	public String toString() {
		String resposta = super.toString();
		resposta += "MATRICULA: " + matriculaFUB + '\n';
		resposta += "Area de formacao: " + areaFormacao  + '\n';
		return resposta;
	}

}