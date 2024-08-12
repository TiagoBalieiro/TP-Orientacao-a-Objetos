package view;

import javax.swing.JOptionPane;
import cadastros.CadastroProfessor;
import exceptions.CampoEmBrancoException;
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
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
                    opcao = -1;
                    break;
            }
        } while (opcao != 0);
    }

    private void cadastrarProfessor() {
        Professor professor = dadosProfessor();
        boolean erro = false;
        try {
            if (professor.getNome().isEmpty())
                throw new CampoEmBrancoException("Campo nome em branco");
        } catch (CampoEmBrancoException e) {
            erro = true;
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        try {
            if (professor.getCpf().isEmpty())
                throw new CampoEmBrancoException("Campo cpf em branco");
        } catch (CampoEmBrancoException e) {
            erro = true;
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        try {
            if (professor.getEmail().isEmpty())
                throw new CampoEmBrancoException("Campo email em branco");
        } catch (CampoEmBrancoException e) {
            erro = true;
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        try {
            if (professor.getAreaFormacao().isEmpty())
            throw new CampoEmBrancoException("Campo area de formação em branco");
        } catch (CampoEmBrancoException e) {
            erro = true;
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        try {
            if (professor.getMatriculaFUB().isEmpty())
                throw new CampoEmBrancoException("Campo matricula FUB em branco");
        } catch (CampoEmBrancoException e) {
            erro = true;
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        try {
            if (professor.getDepartamento().isEmpty())
            throw new CampoEmBrancoException("Campo departamento em branco");
        } catch (CampoEmBrancoException e) {
            erro = true;
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        if(!erro){
            try{
                cadProfessor.adicionarProfessor(professor);
                JOptionPane.showMessageDialog(null, "professor cadastrada com sucesso");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar professor" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar professor", "Erro", JOptionPane.ERROR_MESSAGE);
        }
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
        String matriculaFUB = JOptionPane.showInputDialog("Informe a matrícula FUB a ser atualizada: ");
        Professor professor = cadProfessor.buscarProfessor(matriculaFUB);

        if (professor != null) {
            String novoNome = JOptionPane.showInputDialog("Informe o novo nome (deixe em branco para manter o atual):", professor.getNome());
            String novoCpf = JOptionPane.showInputDialog("Informe o novo cpf (deixe em branco para manter o atual):", professor.getCpf());
            String novoEmail = JOptionPane.showInputDialog("Informe o novo email (deixe em branco para manter o atual):", professor.getEmail());
            String novaAreaFormacao = JOptionPane.showInputDialog("Informe a nova área de formação (deixe em branco para manter o atual):", professor.getAreaFormacao());
            String novaMatriculaFUB = JOptionPane.showInputDialog("Informe a nova matrículaFUB (deixe em branco para manter o atual):", professor.getMatriculaFUB());
            String novoDepartamento = JOptionPane.showInputDialog("Informe o novo departamento (deixe em branco para manter o atual):", professor.getDepartamento());

            //Atualiza o professor com os novos dados
            if (novoNome != null && !novoNome.trim().isEmpty()){
                professor.setNome(novoNome);
            }
            if (novoCpf != null && !novoCpf.trim().isEmpty()){
                professor.setCpf(novoCpf);
            }
            if (novoEmail != null && !novoEmail.trim().isEmpty()){
                professor.setEmail(novoEmail);
            }   
            if (novaAreaFormacao != null && !novaAreaFormacao.trim().isEmpty()){
                professor.setAreaFormacao(novaAreaFormacao);
            }
            if (novaMatriculaFUB != null && !novaMatriculaFUB.trim().isEmpty()){
                professor.setMatriculaFUB(novaMatriculaFUB);
            }
            if (novoDepartamento != null && !novoDepartamento.trim().isEmpty()){
                professor.setDepartamento(novoDepartamento);
            }

            cadProfessor.atualizarProfessor(professor);
            JOptionPane.showMessageDialog(null, "Professor atualizado com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Professor não encontrado");
        }
    }

    private void removerProfessor() {
        String matriculaFUB = JOptionPane.showInputDialog("Informe a matrícula FUB a ser removida: ");
        boolean removido = cadProfessor.removerProfessor(matriculaFUB);

        if (removido) {
            JOptionPane.showMessageDialog(null, "Professor removido");
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
