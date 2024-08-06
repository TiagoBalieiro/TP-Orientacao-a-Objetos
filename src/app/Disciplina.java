package app;

public class Disciplina extends ItensCadastrados {

    private String nome,
            horario,
            codigo;
    private int qtdVagas;

    public Disciplina(String nome, String codigo, String horario, int qtdVagas, int id) {
        super(id,nome);
        this.codigo = codigo;
        this.horario = horario;
        this.qtdVagas = qtdVagas;
    }

    public int getQtdVagas() {
        return qtdVagas;
    }
    public String getHorario() {
        return horario;
    }

    public String getCodigo() {
        return codigo;
    }


    public String toString() {
        String resposta = super.toString() + '\n';
        resposta += "NOME: " + nome + '\n';
        resposta += "CODIGO: " + codigo + '\n';
        resposta += "HORARIO: " + horario + '\n';
        resposta += "VAGAS: " + qtdVagas + '\n';
        return resposta;
    }
}