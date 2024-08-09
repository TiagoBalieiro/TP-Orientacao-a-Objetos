package app;

public class Disciplina {
    private String codigo;
    private String nome;

    public Disciplina(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "nome='" + nome + '\'' + '\n' +
                ", codigo='" + codigo + '\'' + '\n' +
                '}';
    }
}