// app/Professor.java
package app;

public class Professor extends PessoaFisica {
	private String areaFormacao;
	private String matriculaFUB;
	private String departamento;

	public Professor(String nome, String cpf, String email, String areaFormacao, String matriculaFUB, String departamento) {
		super(nome, cpf, email);
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

	public String getAreaFormacao() {
		return areaFormacao;
	}

	public void setAreaFormacao(String areaFormacao) {
		this.areaFormacao = areaFormacao;
	}

	@Override
	public String toString() {
		return "Professor{\n" +
				"nome='" + getNome() + '\'' + '\n' +
				"cpf='" + getCpf() + '\'' + '\n' +
				"email='" + getEmail() + '\'' + '\n' +
				"Área de formação='" + areaFormacao + '\'' + '\n' +
				"matriculaFUB='" + matriculaFUB + '\'' + '\n' +
				"departamento='" + departamento + '\'' + '\n' +
				'}';
	}
}