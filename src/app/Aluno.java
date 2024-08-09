package app;

public class Aluno extends PessoaFisica {
    private String matricula;
    private String curso;

    public Aluno(String nome, String cpf, String email, String matricula, String curso) {
        super(nome, cpf, email);
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


    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + getNome() + '\'' + '\n' +
                ", cpf='" + getCpf() + '\'' + '\n' +
                ", email='" + getEmail() + '\'' + '\n' +
                ", matricula='" + matricula + '\'' + '\n' +
                ", curso='" + curso + '\'' + '\n' +
                '}';
    }
}