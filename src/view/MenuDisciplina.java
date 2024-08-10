package view;

import javax.swing.JOptionPane;
import cadastros.CadastroDisciplina;
import exceptions.DisciplinaNaoAtribuidaException;
import app.Disciplina;

public class MenuDisciplina {

    private CadastroDisciplina cadDisciplina;

    public MenuDisciplina(CadastroDisciplina cadDisciplina) {
        this.cadDisciplina = cadDisciplina;
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
                    cadastrarDisciplina();
                    break;
                case 2:
                    pesquisarDisciplina();
                    break;
                case 3:
                    atualizarDisciplina();
                    break;
                case 4:
                    removerDisciplina();
                    break;
                default:
                    break;
            }
        } while (opcao != 0);
    }

    private void cadastrarDisciplina() {
        Disciplina disciplina = dadosDisciplina();
        boolean erro = false;
        try {
            if (disciplina.getNome().isEmpty())
                throw new DisciplinaNaoAtribuidaException("Campo nome em branco");
        } catch (DisciplinaNaoAtribuidaException e) {
            erro = true;
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        try {
            if (disciplina.getCodigo().isEmpty())
                throw new DisciplinaNaoAtribuidaException("Campo código em branco");
        } catch (Exception e) {
            erro = true;
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        
        if(!erro)
        cadDisciplina.adicionarDisciplina(disciplina);
        JOptionPane.showMessageDialog(null, "Disciplina cadastrada com sucesso");
    }

    private void pesquisarDisciplina() {
        String codigo = JOptionPane.showInputDialog("Informe o código: ");
        Disciplina disciplina = cadDisciplina.buscarDisciplina(codigo);

        if (disciplina != null) {
            JOptionPane.showMessageDialog(null, disciplina.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Disciplina não encontrada");
        }
    }

    private void atualizarDisciplina() {
        String codigo = JOptionPane.showInputDialog("Informe o código: ");
        Disciplina disciplina = cadDisciplina.buscarDisciplina(codigo);

        if (disciplina != null) {
            // Atualize os dados da disciplina aqui
            Disciplina disciplinaAtualizada = dadosDisciplina();
            cadDisciplina.atualizarDisciplina(disciplinaAtualizada);
            JOptionPane.showMessageDialog(null, "Disciplina atualizada com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Disciplina não encontrada");
        }
    }

    private void removerDisciplina() {
        String codigo = JOptionPane.showInputDialog("Informe o código: ");
        boolean removido = cadDisciplina.removerDisciplina(codigo);

        if (removido) {
            JOptionPane.showMessageDialog(null, "Disciplina removida");
        } else {
            JOptionPane.showMessageDialog(null, "Disciplina não encontrada");
        }
    }

    private Disciplina dadosDisciplina() {
        String nome = JOptionPane.showInputDialog("Informe o nome: ");
        String codigo = JOptionPane.showInputDialog("Informe o código: ");
        return new Disciplina(nome, codigo);
    }
}
