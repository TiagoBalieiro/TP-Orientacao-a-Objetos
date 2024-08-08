// src/app/Turma.java
package app;

import java.util.List;
import java.util.ArrayList;

public class Turma extends Disciplina {
    private String numero;
    private Disciplina disciplinaAssociada;
    private Professor professor;
    private Aluno[] alunos;  // Array de alunos associados à turma
    private int contadorAlunos;  // Mantém o controle de quantos alunos foram adicionados

    public Turma(String nome, String codigo, String horario, String qtdVagas, String numero, Disciplina disciplinaAssociada, Professor professor) {
        super(nome, codigo, horario, Integer.parseInt(qtdVagas));
        this.alunos = new Aluno[ Integer.parseInt(qtdVagas)];  // Inicializa o array de alunos com a quantidade de vagas disponíveis        this.numero = numero;
        this.contadorAlunos = 0;
        this.disciplinaAssociada = disciplinaAssociada;
        this.professor = professor;

    }

    public Aluno[] getAlunos() {
        return alunos;
    }

    public void adicionarAluno(Aluno aluno) {
        if (contadorAlunos < alunos.length) {
            alunos[contadorAlunos] = aluno;  // Adiciona o aluno ao próximo espaço disponível no array
            contadorAlunos++;
        } else {
            System.out.println("Não é possível adicionar mais alunos. A turma está cheia.");
        }
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Disciplina getDisciplinaAssociada() {
        return disciplinaAssociada;
    }

    public void setDisciplinaAssociada(Disciplina disciplinaAssociada) {
        this.disciplinaAssociada = disciplinaAssociada;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Turma{\n");
        sb.append("nome='").append(getNome()).append("',\n");
        sb.append("codigo='").append(getCodigo()).append("',\n");
        sb.append("horario='").append(getHorario()).append("',\n");
        sb.append("Quantidade de Vagas=").append(getQtdVagas()).append(",\n");
        sb.append("numero da Turma='").append(numero).append("',\n");
        sb.append("disciplinaAssociada='").append(disciplinaAssociada != null ? disciplinaAssociada.getNome() : "null").append("',\n");
        sb.append("professor='").append(professor != null ? professor.getNome() : "null").append("',\n");
        sb.append("alunos=[\n");

        for (int i = 0; i < contadorAlunos; i++) {
            sb.append(alunos[i].getNome()).append(", ");
        }

        if (contadorAlunos > 0) {
            sb.setLength(sb.length() - 2); // Remove a última vírgula e espaço
        }

        sb.append("]\n}");
        return sb.toString();
    }

}