// src/app/Turma.java
package app;

public class Turma extends Disciplina {
    private String alunos, numero;
    private Disciplina disciplina;
    private Professor professor;

    public Turma(String nome, String codigo, String horario, String qtdVagas, String alunos, String numero, Disciplina disciplina, Professor professor) {
        super(nome, codigo, horario, Integer.parseInt(qtdVagas));
        this.alunos = alunos;
        this.numero = numero;
        this.disciplina = disciplina;
        this.professor = professor;
    }

    public String getAlunos() {
        return alunos;
    }

    public void setAlunos(String alunos) {
        this.alunos = alunos;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "nome='" + getNome() + '\'' + '\n' +
                ", codigo='" + getCodigo() + '\'' + '\n' +
                ", horario='" + getHorario() + '\'' + '\n' +
                ", Quantidade de Vagas=" + getQtdVagas() + '\n' +
                ", alunos='" + alunos + '\'' + '\n' +
                ", numero='" + numero + '\'' + '\n' +
                ", disciplina='" + (disciplina != null ? disciplina.getNome() : "null") + '\'' + '\n' +
                ", professor='" + (professor != null ? professor.getNome() : "null") + '\'' + '\n' +
                '}';
    }
}