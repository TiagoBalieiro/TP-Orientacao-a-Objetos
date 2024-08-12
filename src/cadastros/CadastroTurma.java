package cadastros;

import java.util.HashMap;
import java.util.Map;
import app.Turma;

public class CadastroTurma {
    private Map<String, Turma> turmas;

    public CadastroTurma(CadastroAluno cadastroAluno, CadastroDisciplina cadastroDisciplina, CadastroProfessor cadastroProfessor) {
        this.turmas = new HashMap<>();
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
          // Remove a turma com o código antigo
        if (turma.getCodigoAntigo() != null && !turma.getCodigoAntigo().equals(turma.getCodigo())) {
            turmas.remove(turma.getCodigoAntigo());
        }
        turmas.put(turma.getCodigo(), turma);
    }
}
