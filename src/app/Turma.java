// app/Turma.java
package app;

public class Turma extends Disciplina {
    private String alunos, numero;


    public Turma(String nome, String codigo, String horario, String qtdVagas, String alunos, String numero) {
        super(nome, codigo, horario, Integer.parseInt(qtdVagas));
        this.alunos = alunos;
        this.numero = numero;
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
                '}';
    }
}