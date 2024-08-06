package app;

public class Turma extends Disciplina {
    private String alunos;
    private int numero;


    public Turma(String nome, String codigo, String alunos, int numero,int id) {
        super(nome, codigo, null, 0, id);
        this.alunos = alunos;
        this.numero = numero;
    }
    public String getAlunos() {
        return alunos;
    }

    public String getNumero() {
        return getNumero();
    }

    public String toString() {
        String resposta = super.toString() + '\n';
        resposta += "Alunos: " + alunos + '\n';
        resposta += "Numero: " + numero + '\n';
        return resposta;
    }
}
