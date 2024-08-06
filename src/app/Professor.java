// app/Professor.java
package app;

public class Professor extends ItensCadastrados {
	private String cpf;
	private String email;
	private String areaFormacao;
	private String matriculaFUB;
	private String departamento;

	public Professor(String nome, String cpf, String email, String areaFormacao, String matriculaFUB, String departamento) {
		super(nome);
		this.cpf = cpf;
		this.email = email;
		this.areaFormacao = areaFormacao;
		this.matriculaFUB = matriculaFUB;
		this.departamento = departamento;
	}

	public String getMatriculaFUB() {
		return matriculaFUB;
	}

	public void setMatriculaFUB(String matriculaFUB) {
		this.matriculaFUB = matriculaFUB;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAreaFormacao() {
		return areaFormacao;
	}

	public void setAreaFormacao(String areaFormacao) {
		this.areaFormacao = areaFormacao;
	}

	public String getNome() {
		return nome;
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