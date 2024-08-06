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
                    cadastro.cadastrar(novoObjeto);
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
        if (cadastro.getClass().equals(Cadastro.class)) {
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
                String areaFormacao = JOptionPane.showInputDialog("Informe a area de formacao: ");
                String matriculaFUB = JOptionPane.showInputDialog("Informe a matricula FUB: ");
                String departamento = JOptionPane.showInputDialog("Informe o departamento: ");
                return (T) new Professor(nome, cpf, email, areaFormacao, matriculaFUB, departamento);
            } else if (cadastro.getTipo().equals(Disciplina.class)) {
                String nome = JOptionPane.showInputDialog("Informe o nome: ");
                String codigo = JOptionPane.showInputDialog("Informe o codigo: ");
                String horario = JOptionPane.showInputDialog("Informe o horario: ");
                int qtdVagas = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de vagas: "));
                return (T) new Disciplina(nome, codigo, horario, qtdVagas);
            } else if (cadastro.getTipo().equals(Turma.class)) {
                String nome = JOptionPane.showInputDialog("Informe o nome: ");
                String codigo = JOptionPane.showInputDialog("Informe o codigo: ");
                String alunos = JOptionPane.showInputDialog("Informe os alunos: ");
                String numero = JOptionPane.showInputDialog("Informe o numero: ");
                String horario = JOptionPane.showInputDialog("Informe o horario: ");
                String qtdVagas = JOptionPane.showInputDialog("Informe a quantidade de vagas: ");
                return (T) new Turma(nome, codigo, alunos, numero, horario, qtdVagas);
            }
        }
        return null;
    }
}