package app;

public class ItensCadastrados {
    private int id;
    private String nome;

    public ItensCadastrados(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String toString() {
        String resposta = "ID: " + id + '\n';
        resposta += "NOME: " + nome + '\n';
        return resposta;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
