package app;

public class Aluno extends ItensCadastrados {
    private String cpf;
    private String email;
    private String matricula;
    private String curso;

    public Aluno(String nome, String cpf, String email, String matricula, String curso) {
        super(nome);
        this.cpf = cpf;
        this.email = email;
        this.matricula = matricula;
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
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

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' + '\n' +
                ", cpf='" + cpf + '\'' + '\n' +
                ", email='" + email + '\'' + '\n' +
                ", matricula='" + matricula + '\'' + '\n' +
                ", curso='" + curso + '\'' + '\n' +
                '}';
    }
}