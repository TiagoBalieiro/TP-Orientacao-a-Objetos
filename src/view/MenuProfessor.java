package view;

import app.Professor;
import javax.swing.JOptionPane;
import cadastros.Cadastro;

public class MenuProfessor {
    public static Professor dadosNovoProfesor() {
        String nome = lernome();
        String cpf = lercpf();
        String email = leremail();
        String areaFormacao = lerareaFormacao();
        String matriculaFUB = lermatriculaFUB();
        int id = lerId();
        return new Professor(nome, cpf, email, areaFormacao, matriculaFUB,id);
    }
    private static String lernome(){
        return JOptionPane.showInputDialog(null, "Digite o nome do professor: ");}

    private static String lercpf(){
        return JOptionPane.showInputDialog(null, "Digite o cpf do professor: ");}

    private static String leremail(){
        return JOptionPane.showInputDialog(null, "Digite o email do professor: ");}

    private static String lerareaFormacao(){
        return JOptionPane.showInputDialog(null, "Digite a area de formacao do professor: ");}

    private static String lermatriculaFUB(){
        return JOptionPane.showInputDialog(null, "Digite a matricula FUB do professor: ");}

    private static int lerId() {
        return JOptionPane.showConfirmDialog(null, "Informe o id do professor: ");
    }
    public static void menuProfessor(Cadastro<Professor> cadProfessor) {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar professor\n"
                + "2 - Pesquisar professor\n"
                + "3 - Atualizar professor\n"
                + "4 - Remover professor\n"
                + "0 - Voltar para menu anterior";

        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
                    Professor novoProfessor = dadosNovoProfesor();
                    cadProfessor.cadastrar(novoProfessor);
                    break;

                case 2:
                    int id = lerId();
                    Professor p = cadProfessor.pesquisar(id);
                    if (p != null) {
                        JOptionPane.showMessageDialog(null, p);
                    } else {
                        JOptionPane.showMessageDialog(null, "Professor não encontrado");
                    }
                    break;

                case 3:
                    int idAtualizar = lerId();
                    Professor professorAtualizar = cadProfessor.pesquisar(idAtualizar);
                    if (professorAtualizar != null) {
                        Professor novoProfessorAtualizar = dadosNovoProfesor();
                        cadProfessor.atualizar(idAtualizar, novoProfessorAtualizar);
                    } else {
                        JOptionPane.showMessageDialog(null, "Professor não encontrado");
                    }
                    break;

                case 4:
                    int idRemover = lerId();
                    Professor professorRemover = cadProfessor.pesquisar(idRemover);
                    if (professorRemover != null) {
                        cadProfessor.remover(idRemover);
                    } else {
                        JOptionPane.showMessageDialog(null, "Professor não encontrado");
                    }
                    break;
            }
        } while (opcao != 0);
    }
}
