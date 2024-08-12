package cadastros;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;
import app.Disciplina;

public class CadastroDisciplina {
    private Map<String, Disciplina> disciplinas;

    public CadastroDisciplina() {
        this.disciplinas = new HashMap<>();
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.put(disciplina.getCodigo(), disciplina);
    }

    public Disciplina buscarDisciplina(String codigo) {
        return disciplinas.get(codigo);
    }

    public boolean removerDisciplina(String codigo) {
        return disciplinas.remove(codigo) != null;
    }

    public void atualizarDisciplina(Disciplina disciplina) {
        if(disciplina.getCodigoAntigo() != null && !disciplina.getCodigoAntigo().equals(disciplina.getCodigo())){
            disciplinas.remove(disciplina.getCodigoAntigo());
        }
        disciplinas.put(disciplina.getCodigo(), disciplina);
    }

    public boolean existeDisciplina(String codigo) {
        return disciplinas.containsKey(codigo);
    }

    public Collection<Disciplina> listarDisciplinas() {
        return disciplinas.values();
    }
}
