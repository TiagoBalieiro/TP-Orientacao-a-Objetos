package cadastros;

import java.util.HashMap;
import java.util.Map;

import app.Aluno;
import app.Disciplina;
import app.Professor;
import app.Turma;

public class CadastroTurma {
    private Map<String, Turma> turmas;
    private CadastroAluno cadastroAluno;
    private CadastroDisciplina cadastroDisciplina;
    private CadastroProfessor cadastroProfessor;

    public CadastroTurma(CadastroAluno cadastroAluno, CadastroDisciplina cadastroDisciplina, CadastroProfessor cadastroProfessor) {
        this.turmas = new HashMap<>();
        this.cadastroAluno = cadastroAluno;
        this.cadastroDisciplina = cadastroDisciplina;
        this.cadastroProfessor = cadastroProfessor;
    }

    public void adicionarTurma(Turma turma) {
        turmas.put(turma.getCodigo(), turma);
    }

    public Turma buscarTurma(String codigo) {
        return turmas.get(codigo);
    }

    public boolean removerTurma(String codigo) {
        return turmas.remove(codigo) != null;
    }

    public void atualizarTurma(Turma turma) {
        turmas.put(turma.getCodigo(), turma);
    }
}
