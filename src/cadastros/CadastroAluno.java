package cadastros;

import java.util.HashMap;
import java.util.Map;

import app.Aluno;

public class CadastroAluno {
    private Map<String, Aluno> alunos;

    public CadastroAluno() {
        this.alunos = new HashMap<>();
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.put(aluno.getMatricula(), aluno);
    }

    public Aluno buscarAluno(String matricula) {
        return alunos.get(matricula);
    }

    public boolean removerAluno(String matricula) {
        return alunos.remove(matricula) != null;
    }

    public void atualizarAluno(Aluno aluno) {
        alunos.put(aluno.getMatricula(), aluno);
    }
}
