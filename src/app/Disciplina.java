package app;

public class Disciplina {
    protected String codigo;
    private String codigoAntigo;
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

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setCodigo(String codigo){
        if(this.codigo != null && !this.codigo.equals(codigo)){
            this.codigoAntigo = this.codigo;
        }
        this.codigo = codigo;
    }
    public String getCodigoAntigo(){
        return codigoAntigo;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "nome='" + nome + '\'' + '\n' +
                ", codigo='" + codigo + '\'' + '\n' +
                '}';
    }
}