
package cadastros;

import java.util.HashMap;
import java.util.Map;
import app.ItensCadastrados;
import app.Aluno;
import app.Professor;
import app.Disciplina;

public class Cadastro<T extends ItensCadastrados> {
    private Map<String, T> itens;
    private Class<T> tipo;

    public Cadastro(Class<T> tipo) {
        this.tipo = tipo;
        this.itens = new HashMap<>();
    }

    public Class<T> getTipo() {
        return tipo;
    }

    public void cadastrar(T item) {
        String chave = getChave(item);
        itens.put(chave, item);
    }

    public T pesquisar(String chave) {
        return itens.get(chave);
    }

    public void atualizar(String chave, T item) {
        itens.put(chave, item);
    }

    public boolean remover(String chave) {
        return itens.remove(chave) != null;
    }

    private String getChave(T item) {
        if (tipo.equals(Aluno.class)) {
            return ((Aluno) item).getMatricula();
        } else if (tipo.equals(Professor.class)) {
            return ((Professor) item).getMatriculaFUB();
        } else {
            return ((Disciplina) item).getCodigo();
        }
    }
}