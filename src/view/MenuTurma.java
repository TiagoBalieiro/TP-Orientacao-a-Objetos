package view;

import javax.swing.JOptionPane;

import app.Aluno;
import app.Disciplina;
import app.Professor;
import app.Turma;
import cadastros.CadastroAluno;
import cadastros.CadastroDisciplina;
import cadastros.CadastroProfessor;
import cadastros.CadastroTurma;

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
                + "5 - Imprimir Lista de Presença\n"
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

                case 5:
                    imprimirListaPresenca();
                    break;

                default:
                    break;
            }
        } while (opcao != 0);
    }

    // Método existente para cadastrar a turma
    private void cadastrarTurma() {
        Turma turma = dadosTurma();
        cadTurma.adicionarTurma(turma);
    }

    // Método existente para pesquisar a turma
    private void pesquisarTurma() {
        String codigo = JOptionPane.showInputDialog("Informe o código da turma: ");
        Turma turma = cadTurma.buscarTurma(codigo);
        if (turma != null) {
            JOptionPane.showMessageDialog(null, turma.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Turma não encontrada");
        }
    }

    // Método existente para atualizar a turma
    private void atualizarTurma() {
        String codigo = JOptionPane.showInputDialog("Informe o código da turma a ser atualizada: ");
        Turma turma = cadTurma.buscarTurma(codigo);
        if (turma != null) {
            // Atualize os dados da turma conforme necessário
            cadTurma.atualizarTurma(turma);
        } else {
            JOptionPane.showMessageDialog(null, "Turma não encontrada");
        }
    }

    // Método existente para remover a turma
    private void removerTurma() {
        String codigo = JOptionPane.showInputDialog("Informe o código da turma a ser removida: ");
        boolean removido = cadTurma.removerTurma(codigo);
        if (removido) {
            JOptionPane.showMessageDialog(null, "Turma removida.");
        } else {
            JOptionPane.showMessageDialog(null, "Turma não encontrada");
        }
    }

    // Novo método para imprimir a lista de presença de uma turma específica
    private void imprimirListaPresenca() {
        String codigo = JOptionPane.showInputDialog("Informe o código da turma para imprimir a lista de presença: ");
        Turma turma = cadTurma.buscarTurma(codigo);
        if (turma != null) {
            StringBuilder listaPresenca = new StringBuilder();
            listaPresenca.append("Lista de Presença\n");
            listaPresenca.append("Código da Turma: ").append(turma.getCodigo()).append("\n");
            listaPresenca.append("Nome da Disciplina: ").append(turma.getDisciplinaAssociada().getNome()).append("\n");
            listaPresenca.append("Nome do Professor: ").append(turma.getProfessor().getNome()).append("\n");
            listaPresenca.append("Alunos Matriculados:\n");

            for (Aluno aluno : turma.getAlunos()) {
                listaPresenca.append(aluno.getMatricula()).append(" - ").append(aluno.getNome()).append("\n");
            }

            JOptionPane.showMessageDialog(null, listaPresenca.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Turma não encontrada");
        }
    }

    // Método existente para coletar dados da turma
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
