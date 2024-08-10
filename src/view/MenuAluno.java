package view;

import javax.swing.JOptionPane;
import cadastros.CadastroAluno;
import exceptions.CampoEmBrancoException;
import app.Aluno;

public class MenuAluno {

    private CadastroAluno cadAluno;

    public MenuAluno(CadastroAluno cadAluno) {
        this.cadAluno = cadAluno;
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
                    cadastrarAluno();
                    break;
                case 2:
                    pesquisarAluno();
                    break;
                case 3:
                    atualizarAluno();
                    break;
                case 4:
                    removerAluno();
                    break;
                default:
                    break;
            }
        } while (opcao != 0);
    }

    private void cadastrarAluno() {
        Aluno aluno = dadosAluno();
        boolean erro = false;
        try {
            if (aluno.getNome().isEmpty())
                
                throw new CampoEmBrancoException("Campo nome em branco");
        }
        catch (CampoEmBrancoException e){
            erro = true;
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        try {
            if (aluno.getCpf().isEmpty())
                
                throw new CampoEmBrancoException("Campo cpf em branco");
        }
        catch (CampoEmBrancoException e){
            erro = true;
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            
        }
        try {
            if (aluno.getEmail().isEmpty())
                throw new CampoEmBrancoException("Campo email em branco");
        }
        catch (CampoEmBrancoException e){
            erro = true;
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        try {
            if (aluno.getMatricula().isEmpty())
            throw new CampoEmBrancoException("Campo matricula em branco");
        }
        catch (CampoEmBrancoException e){
            erro = true;
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        try {
            if (aluno.getCurso().isEmpty())
            throw new CampoEmBrancoException("Campo curso em branco");
        }
        catch (CampoEmBrancoException e){
            erro = true;
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        if (!erro){
            cadAluno.adicionarAluno(aluno);
            JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso");
        }
    }
    
    private void pesquisarAluno() {
        String matricula = JOptionPane.showInputDialog("Informe a matrícula: ");
        Aluno aluno = cadAluno.buscarAluno(matricula);
        
        if (aluno != null) {
            JOptionPane.showMessageDialog(null, aluno.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Aluno não encontrado");
        }
    }

    private void atualizarAluno() {
        String matricula = JOptionPane.showInputDialog("Informe a matrícula: ");
        Aluno aluno = cadAluno.buscarAluno(matricula);

        if (aluno != null) {
            // Atualize os dados do aluno aqui
            Aluno alunoAtualizado = dadosAluno();
            cadAluno.atualizarAluno(alunoAtualizado);
            JOptionPane.showMessageDialog(null, "Aluno atualizado com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Aluno não encontrado");
        }
    }

    private void removerAluno() {
        String matricula = JOptionPane.showInputDialog("Informe a matrícula: ");
        boolean removido = cadAluno.removerAluno(matricula);

        if (removido) {
            JOptionPane.showMessageDialog(null, "Aluno removido");
        } else {
            JOptionPane.showMessageDialog(null, "Aluno não encontrado");
        }
    }

    private Aluno dadosAluno() {
        String nome = JOptionPane.showInputDialog("Informe o nome: ");
        String cpf = JOptionPane.showInputDialog("Informe o CPF: ");
        String email = JOptionPane.showInputDialog("Informe o email: ");
        String matricula = JOptionPane.showInputDialog("Informe a matrícula: ");
        String curso = JOptionPane.showInputDialog("Informe o curso: ");
        return new Aluno(nome, cpf, email, matricula, curso);
    }
}
