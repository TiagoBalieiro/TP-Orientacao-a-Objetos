package view;

import javax.swing.JOptionPane;
import cadastros.CadastroProfessor;
import app.Professor;

public class MenuProfessor {

    private CadastroProfessor cadProfessor;

    public MenuProfessor(CadastroProfessor cadProfessor) {
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
                    cadastrarProfessor();
                    break;
                case 2:
                    pesquisarProfessor();
                    break;
                case 3:
                    atualizarProfessor();
                    break;
                case 4:
                    removerProfessor();
                    break;
                default:
                    break;
            }
        } while (opcao != 0);
    }

    private void cadastrarProfessor() {
        Professor professor = dadosProfessor();
        cadProfessor.adicionarProfessor(professor);
    }

    private void pesquisarProfessor() {
        String matriculaFUB = JOptionPane.showInputDialog("Informe a matrícula FUB: ");
        Professor professor = cadProfessor.buscarProfessor(matriculaFUB);

        if (professor != null) {
            JOptionPane.showMessageDialog(null, professor.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Professor não encontrado");
        }
    }

    private void atualizarProfessor() {
        String matriculaFUB = JOptionPane.showInputDialog("Informe a matrícula FUB: ");
        Professor professor = cadProfessor.buscarProfessor(matriculaFUB);

        if (professor != null) {
            // Atualize os dados do professor aqui
            Professor professorAtualizado = dadosProfessor();
            cadProfessor.atualizarProfessor(professorAtualizado);
        } else {
            JOptionPane.showMessageDialog(null, "Professor não encontrado");
        }
    }

    private void removerProfessor() {
        String matriculaFUB = JOptionPane.showInputDialog("Informe a matrícula FUB: ");
        boolean removido = cadProfessor.removerProfessor(matriculaFUB);

        if (removido) {
            JOptionPane.showMessageDialog(null, "Professor removido.");
        } else {
            JOptionPane.showMessageDialog(null, "Professor não encontrado");
        }
    }

    private Professor dadosProfessor() {
        String nome = JOptionPane.showInputDialog("Informe o nome: ");
        String cpf = JOptionPane.showInputDialog("Informe o CPF: ");
        String email = JOptionPane.showInputDialog("Informe o email: ");
        String areaFormacao = JOptionPane.showInputDialog("Informe a área de formação: ");
        String matriculaFUB = JOptionPane.showInputDialog("Informe a matrícula FUB: ");
        String departamento = JOptionPane.showInputDialog("Informe o departamento: ");
        return new Professor(nome, cpf, email, areaFormacao, matriculaFUB, departamento);
    }
}
