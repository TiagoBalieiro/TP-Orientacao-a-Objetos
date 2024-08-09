// src/cadastros/Cadastro.java
package cadastros;

import java.util.HashMap;
import java.util.Map;
import app.ItensCadastrados;
import app.Aluno;
import app.Professor;
import app.Disciplina;
import app.Turma;
import exceptions.CampoEmBrancoException;
import exceptions.DisciplinaNaoAtribuidaException;
import exceptions.ProfessorNaoAtribuidoException;

public class Cadastro<T> {
    private Map<String, T> itens;
    private Class<T> tipo;

    public Cadastro(Class<T> tipo) {
        this.tipo = tipo;
        this.itens = new HashMap<>();
    }

    public Class<T> getTipo() {
        return tipo;
    }

    public void cadastrar(T item) throws CampoEmBrancoException, DisciplinaNaoAtribuidaException, ProfessorNaoAtribuidoException {
        if (item instanceof Aluno) {
            Aluno aluno = (Aluno) item;
            if (aluno.getMatricula().isEmpty() || aluno.getNome().isEmpty() || aluno.getEmail().isEmpty() || aluno.getCurso().isEmpty()) {
                throw new CampoEmBrancoException("Preencha todos os campos");
            }
        } else if (item instanceof Professor) {
            Professor professor = (Professor) item;
            if (professor.getMatriculaFUB().isEmpty() || professor.getNome().isEmpty() || professor.getCpf().isEmpty() || professor.getEmail().isEmpty() || professor.getAreaFormacao().isEmpty() || professor.getDepartamento().isEmpty()) {
                throw new CampoEmBrancoException("Preencha todos os campos");
            }
        } else if (item instanceof Disciplina) {
            Disciplina disciplina = (Disciplina) item;
            if (disciplina.getCodigo().isEmpty() || disciplina.getNome().isEmpty()) {
                throw new CampoEmBrancoException("Preencha todos os campos");
            }
        } else if (item instanceof Turma) {
            Turma turma = (Turma) item;
            if (turma.getCodigo().isEmpty() || turma.getNome().isEmpty() || turma.getHorario().isEmpty() || turma.getQtdvagas() == 0 || turma.getAlunos().length == 0 || (Integer) turma.getNumero() == null) {
                throw new CampoEmBrancoException("Preencha todos os campos");
            }
            if (turma.getDisciplinaAssociada() == null) {
                throw new DisciplinaNaoAtribuidaException("Disciplina não atribuída");
            }
            if (turma.getProfessor() == null) {
                throw new ProfessorNaoAtribuidoException("Professor não atribuído");
            }
        }

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
        if (item instanceof Aluno) {
            return ((Aluno) item).getMatricula();
        } else if (item instanceof Professor) {
            return ((Professor) item).getMatriculaFUB();
        } else if (item instanceof Disciplina) {
            return ((Disciplina) item).getCodigo();
        } else if (item instanceof Turma) {
            return ((Turma) item).getCodigo();
        }
        return null;
    }
}