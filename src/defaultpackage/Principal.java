package defaultpackage;

import javax.swing.JOptionPane;
import cadastros.CadastroAluno;
import cadastros.CadastroProfessor;
import cadastros.CadastroDisciplina;
import cadastros.CadastroTurma;
import view.MenuAluno;
import view.MenuProfessor;
import view.MenuDisciplina;
import view.MenuTurma;
import view.MenuPrincipal;

public class Principal {
    static CadastroAluno cadAluno;
    static CadastroProfessor cadProfessor;
    static CadastroDisciplina cadDisciplina;
    static CadastroTurma cadTurma;

    public static void main(String[] args) {
        cadAluno = new CadastroAluno();
        cadProfessor = new CadastroProfessor();
        cadDisciplina = new CadastroDisciplina();
        cadTurma = new CadastroTurma(cadAluno, cadDisciplina, cadProfessor);

        MenuAluno menuAluno = new MenuAluno(cadAluno);
        MenuProfessor menuProfessor = new MenuProfessor(cadProfessor);
        MenuDisciplina menuDisciplina = new MenuDisciplina(cadDisciplina);
        MenuTurma menuTurma = new MenuTurma(cadTurma, cadAluno, cadDisciplina, cadProfessor);

        int opcao = 0;

        do {
            opcao = MenuPrincipal.menuOpcoes();
            switch (opcao) {
                case 1:
                    menuAluno.exibirMenu();
                    break;
                case 2:
                    menuProfessor.exibirMenu();
                    break;
                case 3:
                    menuDisciplina.exibirMenu();
                    break;
                case 4:
                    menuTurma.exibirMenu();
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
}
