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
                    int id = lerId();
                    T objeto = cadastro.pesquisar(id);
                    if (objeto != null) {
                        JOptionPane.showMessageDialog(null, objeto);
                    } else {
                        JOptionPane.showMessageDialog(null, "Objeto não encontrado");
                    }
                    break;

                case 3:
                    int idAtualizar = lerId();
                    T objetoAtualizar = cadastro.pesquisar(idAtualizar);
                    if (objetoAtualizar != null) {
                        T novoObjetoAtualizar = dadosNovoObjeto();
                        cadastro.atualizar(idAtualizar, novoObjetoAtualizar);
                    } else {
                        JOptionPane.showMessageDialog(null, "Objeto não encontrado");
                    }
                    break;

                case 4:
                    int idRemover = lerId();
                    boolean removido = cadastro.remover(idRemover);
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

    private int lerId() {
        String strId = JOptionPane.showInputDialog("Informe o id: ");
        return Integer.parseInt(strId);
    }

    private T dadosNovoObjeto() {
        if (cadastro.getClass().equals(Cadastro.class)) {
            if (cadastro.getTipo().equals(Aluno.class)) {
                String nome = JOptionPane.showInputDialog("Informe o nome: ");
                String cpf = JOptionPane.showInputDialog("Informe o CPF: ");
                String email = JOptionPane.showInputDialog("Informe o email: ");
                String matricula = JOptionPane.showInputDialog("Informe a matricula: ");
                String curso = JOptionPane.showInputDialog("Informe o curso: ");
                int id = lerId();
                return (T) new Aluno(nome, cpf, email, matricula, curso, id);
            } else if (cadastro.getTipo().equals(Professor.class)) {
                String nome = JOptionPane.showInputDialog("Informe o nome: ");
                String cpf = JOptionPane.showInputDialog("Informe o CPF: ");
                String email = JOptionPane.showInputDialog("Informe o email: ");
                String areaFormacao = JOptionPane.showInputDialog("Informe a area de formacao: ");
                String matriculaFUB = JOptionPane.showInputDialog("Informe a matricula FUB: ");
                String departamento = JOptionPane.showInputDialog("Informe o departamento: ");
                int id = lerId();
                return (T) new Professor(nome, cpf, email, areaFormacao, matriculaFUB, id);
            } else if (cadastro.getTipo().equals(Disciplina.class)) {
                String nome = JOptionPane.showInputDialog("Informe o nome: ");
                String codigo = JOptionPane.showInputDialog("Informe o codigo: ");
                String horario = JOptionPane.showInputDialog("Informe o horario: ");
                int qtdVagas = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de vagas: "));
                int id = lerId();
                return (T) new Disciplina(nome, codigo, horario, qtdVagas, id);
            } else if (cadastro.getTipo().equals(Turma.class)) {
                String nome = JOptionPane.showInputDialog("Informe o nome: ");
                String codigo = JOptionPane.showInputDialog("Informe o codigo: ");
                String alunos = JOptionPane.showInputDialog("Informe os alunos: ");
                int numero = Integer.parseInt(JOptionPane.showInputDialog("Informe o numero: "));
                int id = lerId();
                return (T) new Turma(nome, codigo, alunos, numero, id);
            }
        }
        return null;
    }
}