// app/Professor.java
package app;

public class Professor extends ItensCadastrados {
	private String nome;
	private String cpf;
	private String email;
	private String areaFormacao;
	private String matriculaFUB;
	private String departamento;

	public Professor(String nome, String cpf, String email, String areaFormacao, String matriculaFUB, String departamento) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.areaFormacao = areaFormacao;
		this.matriculaFUB = matriculaFUB;
		this.departamento = departamento;
	}

	public String getMatriculaFUB() {
		return matriculaFUB;
	}

	@Override
	public String toString() {
		return "Professor{\n" +
				"nome='" + nome + '\'' + '\n' +
				"cpf='" + cpf + '\'' + '\n' +
				"email='" + email + '\'' + '\n' +
				"Área de formação='" + areaFormacao + '\'' + '\n' +
				"matriculaFUB='" + matriculaFUB + '\'' + '\n' +
				"departamento='" + departamento + '\'' + '\n' +
				'}';
	}
}