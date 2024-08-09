package view;

import javax.swing.JOptionPane;
import cadastros.CadastroTurma;
import app.*;
import cadastros.CadastroAluno;
import cadastros.CadastroDisciplina;
import cadastros.CadastroProfessor;

public class MenuTurma {

    private CadastroTurma cadTurma;
    private CadastroAluno cadAluno;
    private CadastroDisciplina cadDisciplina;
    private CadastroProfessor cadProfessor;

    public MenuTurma(CadastroTurma cadTurma, CadastroAluno cadAluno, CadastroDisciplina cadDisciplina, CadastroProfessor cadProfessor) {
        this.cadTurma = cadTurma;
        this.cadAluno = cadAluno;
        this.cadDisciplina = cadDisciplina;
        this.cadProfessor = cadProfessor;
    }

    public void exibirMenu() {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar\n"
                + "2 - Pesquisar\n"
                + "3 - Atualizar\n"
                + "4 - Remover\n"
                + "0 - Voltar para menu anterior";

        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
                    cadastrarTurma();
                    break;
                case 2:
                    pesquisarTurma();
                    break;
                case 3:
                    atualizarTurma();
                    break;
                case 4:
                    removerTurma();
                    break;
                default:
                    break;
            }
        } while (opcao != 0);
    }

    private void cadastrarTurma() {
        Turma turma = dadosTurma();
        cadTurma.adicionarTurma(turma);
    }

    private void pesquisarTurma() {
        String codigo = JOptionPane.showInputDialog("Informe o código: ");
        Turma turma = cadTurma.buscarTurma(codigo);

        if (turma != null) {
            JOptionPane.showMessageDialog(null, turma.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Turma não encontrada");
        }
    }

    private void atualizarTurma() {
        String codigo = JOptionPane.showInputDialog("Informe o código: ");
        Turma turma = cadTurma.buscarTurma(codigo);

        if (turma != null) {
            // Atualize os dados da turma aqui
            Turma turmaAtualizada = dadosTurma();
            cadTurma.atualizarTurma(turmaAtualizada);
        } else {
            JOptionPane.showMessageDialog(null, "Turma não encontrada");
        }
    }

    private void removerTurma() {
        String codigo = JOptionPane.showInputDialog("Informe o código: ");
        boolean removido = cadTurma.removerTurma(codigo);

        if (removido) {
            JOptionPane.showMessageDialog(null, "Turma removida.");
        } else {
            JOptionPane.showMessageDialog(null, "Turma não encontrada");
        }
    }

    private Turma dadosTurma() {
        String nome = JOptionPane.showInputDialog("Informe o nome: ");
        String codigo = JOptionPane.showInputDialog("Informe o código: ");
        String numero = JOptionPane.showInputDialog("Informe o número: ");
        String horario = JOptionPane.showInputDialog("Informe o horário: ");
        String qtdVagas = JOptionPane.showInputDialog("Informe a quantidade de vagas: ");
        Disciplina disciplinaAssociada = cadDisciplina.buscarDisciplina(JOptionPane.showInputDialog("Informe o código da disciplina: "));
        Professor professor = cadProfessor.buscarProfessor(JOptionPane.showInputDialog("Informe a matrícula FUB do professor: "));
        int contadorAlunos = 0;

        Turma turma = new Turma(nome, codigo, horario, Integer.parseInt(qtdVagas), Integer.parseInt(numero), disciplinaAssociada, professor, contadorAlunos);

        String alunosInput = JOptionPane.showInputDialog("Informe as matrículas dos alunos (separados por vírgula): ");
        String[] matriculasAlunos = alunosInput.split(",\\s*");

        for (String matricula : matriculasAlunos) {
            Aluno aluno = cadAluno.buscarAluno(matricula.trim());
            if (aluno != null) {
                turma.adicionarAluno(aluno);
            } else {
                JOptionPane.showMessageDialog(null, "Aluno com matrícula " + matricula + " não encontrado.");
            }
        }

        return turma;
    }
}
