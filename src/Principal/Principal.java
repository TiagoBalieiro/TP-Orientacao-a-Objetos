package Principal;

import javax.swing.JOptionPane;

import app.Disciplina;
import app.Professor;
import app.Aluno;
import app.Turma;
import cadastros.Cadastro;
import view.Menu;
import view.MenuPrincipal;

public class Principal {
	static Cadastro<Aluno> cadAluno;
	static Cadastro<Professor> cadProfessor;
	static Cadastro<Disciplina> cadDisciplina;
	static Cadastro<Turma> cadTurma;

	public static void main(String[] args) {
		cadAluno = new Cadastro<>(Aluno.class);
		cadProfessor = new Cadastro<>(Professor.class);
		cadDisciplina = new Cadastro<>(Disciplina.class);
		cadTurma = new Cadastro<>(Turma.class);

		int opcao = 0;

		do {
			opcao = MenuPrincipal.menuOpcoes();
			switch (opcao) {
				case 1:
					new Menu<>(cadAluno).exibirMenu();
					break;
				case 2:
					new Menu<>(cadProfessor).exibirMenu();
					break;
				case 3:
					new Menu<>(cadDisciplina).exibirMenu();
					break;
				case 4:
					new Menu<>(cadTurma).exibirMenu();
					break;
				case 0:
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção invalida");
					opcao = -1;
					break;
			}
		} while (opcao != 0);
	}
}