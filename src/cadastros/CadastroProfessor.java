package cadastros;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;
import app.Professor;

public class CadastroProfessor {
    private Map<String, Professor> professores;

    public CadastroProfessor() {
        this.professores = new HashMap<>();
    }

    public void adicionarProfessor(Professor professor) {
        professores.put(professor.getMatriculaFUB(), professor);
    }

    public Professor buscarProfessor(String matriculaFUB) {
        return professores.get(matriculaFUB);
    }

    public boolean removerProfessor(String matriculaFUB) {
        return professores.remove(matriculaFUB) != null;
    }

    public void atualizarProfessor(Professor professor) {
        professores.put(professor.getMatriculaFUB(), professor);
    }

    public boolean existeProfessor(String matriculaFUB) {
        return professores.containsKey(matriculaFUB);
    }

    public Collection<Professor> listarProfessores() {
        return professores.values();
    }
}
