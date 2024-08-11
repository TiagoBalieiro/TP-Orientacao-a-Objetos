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
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
                    opcao = -1;
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
        if(!erro){
            try{
                cadAluno.adicionarAluno(aluno);
                JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar aluno" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar aluno", "Erro", JOptionPane.ERROR_MESSAGE);
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
        String matricula = JOptionPane.showInputDialog("Informe a matrícula do aluno a ser atualizado: ");
        Aluno aluno = cadAluno.buscarAluno(matricula);
    
        if (aluno != null) {
            // Solicitar novos dados do usuário
            String novoNome = JOptionPane.showInputDialog("Informe o novo nome (deixe em branco para manter o atual):", aluno.getNome());
            String novoCpf = JOptionPane.showInputDialog("Informe o novo cpf (deixe em branco para manter o atual):", aluno.getCpf());
            String novoEmail = JOptionPane.showInputDialog("Informe o novo email (deixe em branco para manter o atual):", aluno.getEmail());
            String novaMatricula = JOptionPane.showInputDialog("Informe a nova matrícula (deixe em branco para manter a atual):", aluno.getMatricula());
            String novoCurso = JOptionPane.showInputDialog("Informe o novo curso (deixe em branco para manter a atual):", aluno.getCurso());
    
            // Atualizar o aluno existente com os novos dados
            if (novoNome != null && !novoNome.trim().isEmpty()) {
                aluno.setNome(novoNome);
            }
            if (novaMatricula != null && !novaMatricula.trim().isEmpty()) {
                aluno.setMatricula(novaMatricula);
            }
            if (novoCpf != null && !novoCpf.trim().isEmpty()){
                aluno.setCpf(novoCpf);
            }
            if (novoEmail != null && !novoEmail.trim().isEmpty()){
                aluno.setEmail(novoEmail);
            }
            if (novoCurso != null && !novoCurso.trim().isEmpty()){
                aluno.setCurso(novoCurso);
            }
            cadAluno.atualizarAluno(aluno);
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
