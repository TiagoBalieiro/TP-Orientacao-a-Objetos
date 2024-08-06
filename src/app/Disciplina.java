// app/Disciplina.java
package app;

public class Disciplina extends ItensCadastrados {
    private String nome;
    private String codigo;
    private String horario;
    private int qtdVagas;

    public Disciplina(String nome, String codigo, String horario, int qtdVagas) {
        this.nome = nome;
        this.codigo = codigo;
        this.horario = horario;
        this.qtdVagas = qtdVagas;
    }

    public String getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }
    public String getHorario() {
        return horario;
    }
    public int getQtdVagas() {
        return qtdVagas;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "nome='" + nome + '\'' + '\n' +
                ", codigo='" + codigo + '\'' + '\n' +
                ", horario='" + horario + '\'' + '\n' +
                ", Quantodade de vagas=" + qtdVagas + '\n' +
                '}';
    }
}