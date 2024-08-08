// view/Menu.java
package view;

import javax.swing.JOptionPane;
import app.*;
import cadastros.Cadastro;

public class Menu<T extends ItensCadastrados> {

    private Cadastro<T> cadastro;

    public Menu(Cadastro<T> cadastro) {
        this.cadastro = cadastro;
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
                    T novoObjeto = dadosNovoObjeto();
                    try {
                        cadastro.cadastrar(novoObjeto);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;

                case 2:
                    String chave = lerChave();
                    T objeto = cadastro.pesquisar(chave);
                    if (objeto != null) {
                        JOptionPane.showMessageDialog(null, objeto);
                    } else {
                        JOptionPane.showMessageDialog(null, "Objeto não encontrado");
                    }
                    break;

                case 3:
                    String chaveAtualizar = lerChave();
                    T objetoAtualizar = cadastro.pesquisar(chaveAtualizar);
                    if (objetoAtualizar != null) {
                        T novoObjetoAtualizar = dadosNovoObjeto();
                        cadastro.atualizar(chaveAtualizar, novoObjetoAtualizar);
                    } else {
                        JOptionPane.showMessageDialog(null, "Objeto não encontrado");
                    }
                    break;

                case 4:
                    String chaveRemover = lerChave();
                    boolean removido = cadastro.remover(chaveRemover);
                    if (removido) {
                        JOptionPane.showMessageDialog(null, "Objeto removido.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Objeto não encontrado");
                    }
                    break;

                default:
                    break;
            }
        } while (opcao != 0);
    }

    private String lerChave() {
        if (cadastro.getTipo().equals(Aluno.class)) {
            return JOptionPane.showInputDialog("Informe a matricula: ");
        } else if (cadastro.getTipo().equals(Professor.class)) {
            return JOptionPane.showInputDialog("Informe a matricula FUB: ");
        } else {
            return JOptionPane.showInputDialog("Informe o codigo: ");
        }
    }

    private T dadosNovoObjeto() {
        if (cadastro.getTipo().equals(Aluno.class)) {
            String nome = JOptionPane.showInputDialog("Informe o nome: ");
            String cpf = JOptionPane.showInputDialog("Informe o CPF: ");
            String email = JOptionPane.showInputDialog("Informe o email: ");
            String matricula = JOptionPane.showInputDialog("Informe a matricula: ");
            String curso = JOptionPane.showInputDialog("Informe o curso: ");
            return (T) new Aluno(nome, cpf, email, matricula, curso);
        } else if (cadastro.getTipo().equals(Professor.class)) {
            String nome = JOptionPane.showInputDialog("Informe o nome: ");
            String cpf = JOptionPane.showInputDialog("Informe o CPF: ");
            String email = JOptionPane.showInputDialog("Informe o email: ");
            String areaFormacao = JOptionPane.showInputDialog("Informe a área de formação: ");
            String matriculaFUB = JOptionPane.showInputDialog("Informe a matrícula FUB: ");
            String departamento = JOptionPane.showInputDialog("Informe o departamento: ");
            return (T) new Professor(nome, cpf, email, areaFormacao, matriculaFUB, departamento);
        } else if (cadastro.getTipo().equals(Disciplina.class)) {
            String nome = JOptionPane.showInputDialog("Informe o nome: ");
            String codigo = JOptionPane.showInputDialog("Informe o código: ");
            String horario = JOptionPane.showInputDialog("Informe o horário: ");
            int qtdVagas = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de vagas: "));
            return (T) new Disciplina(nome, codigo, horario, qtdVagas);
        } else if (cadastro.getTipo().equals(Turma.class)) {
            String nome = JOptionPane.showInputDialog("Informe o nome: ");
            String codigo = JOptionPane.showInputDialog("Informe o código: ");
            String numero = JOptionPane.showInputDialog("Informe o número: ");
            String horario = JOptionPane.showInputDialog("Informe o horário: ");
            String qtdVagas = JOptionPane.showInputDialog("Informe a quantidade de vagas: ");
            Disciplina disciplina = (Disciplina) cadastro.pesquisar(JOptionPane.showInputDialog("Informe o código da disciplina: "));
    
            // Criar a turma inicialmente sem alunos
            Turma turma = new Turma(nome, codigo, horario, qtdVagas, numero, disciplina, null);
    
            // Adicionar alunos à turma
            String alunosInput = JOptionPane.showInputDialog("Informe as matrículas dos alunos (separados por vírgula): ");
            String[] matriculasAlunos = alunosInput.split(",\\s*");
            
            for (String matricula : matriculasAlunos) {
                Aluno aluno = (Aluno) cadastro.pesquisar(matricula.trim()); // Pesquisa o aluno usando a matrícula
                if (aluno != null) {
                    turma.adicionarAluno(aluno);
                } else {
                    JOptionPane.showMessageDialog(null, "Aluno com matrícula " + matricula + " não encontrado.");
                }
            }
    
            // Adicionar o professor à turma
            Professor professor = (Professor) cadastro.pesquisar(JOptionPane.showInputDialog("Informe a matrícula FUB do professor: "));
            turma.setProfessor(professor);
    
            return (T) turma;
        }
        return null; // Retorno obrigatório para tipos não tratados
    }
    
}