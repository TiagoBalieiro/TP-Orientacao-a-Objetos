// app/Aluno.java
package app;

public class Aluno extends PessoaFisica {
    private String matricula;
    private String curso;
    private int id;

    public Aluno(String nome, String cpf, String email, String matricula, String curso, int id) {
        super(nome, cpf, email,id);
        this.matricula = matricula;
        this.curso = curso;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        String resposta = super.toString();
        resposta += "MATRICULA: " + matricula + '\n';
        resposta += "Curso: " + curso + '\n';
        return resposta;
    }
}