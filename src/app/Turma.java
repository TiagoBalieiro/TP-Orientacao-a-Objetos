// src/app/Turma.java
package app;

import exceptions.NumeroIncorretoAlunosException;

public class Turma extends Disciplina {
    private int numero;
    private Disciplina disciplinaAssociada;
    private Professor professor;
    private Aluno[] alunos;  // Array de alunos associados à turma
    private int contadorAlunos;  // Mantém o controle de quantos alunos foram adicionados
    private int qtdVagas;
    private String horario;
    private String codigoAntigo;

    public Turma(String nome, String codigo, String horario, int qtdVagas, int numero, Disciplina disciplinaAssociada, Professor professor, int contadorAlunos) {
        super(nome, codigo);
        this.horario = horario;
        this.qtdVagas = qtdVagas;
        this.alunos = new Aluno[qtdVagas];  // Inicializa o array de alunos com a quantidade de vagas disponíveis        this.numero = numero;
        this.contadorAlunos = 0;
        this.numero = numero;
        this.disciplinaAssociada = disciplinaAssociada;
        this.professor = professor;
        this.contadorAlunos = contadorAlunos;
        this.codigoAntigo = codigo;
    }

    public int getContadorAlunos(){
        return contadorAlunos;
    }

    public Aluno[] getAlunos() {
        return alunos;
    }

    public void setAlunos(Aluno[] alunos){
        this.alunos = alunos;
    }

    public void adicionarAluno(Aluno aluno) {
        if (contadorAlunos < alunos.length) {
            alunos[contadorAlunos] = aluno;  // Adiciona o aluno ao próximo espaço disponível no array
            contadorAlunos++;
        }
    }
    
    public int getNumero() {
        return numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setCodigo(String codigo) {
        if (this.codigo != null && !this.codigo.equals(codigo)) {
            this.codigoAntigo = this.codigo;  // Armazena o código antigo
        }
        super.setCodigo(codigo);
    }
    
    public String getCodigoAntigo(){
        return codigoAntigo;
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

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getQtdvagas() {
        return qtdVagas;
    }
    
    public void setQtdVagas(int qtdVagas) {
        this.qtdVagas = qtdVagas;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Turma{\n");
        sb.append("nome='").append(getNome()).append("',\n");
        sb.append("codigo='").append(getCodigo()).append("',\n");
        sb.append("horario='").append(getHorario()).append("',\n");
        sb.append("Quantidade de Vagas=").append(getQtdvagas()).append(",\n");
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

    public void verificarNumeroAlunos() throws NumeroIncorretoAlunosException {
        if (contadorAlunos != alunos.length)
            throw new NumeroIncorretoAlunosException("Número de alunos não corresponde à quantidade de vagas");
    }

    public boolean removerAluno(String matriculaAluno) {
        for (int i = 0; i < contadorAlunos; i++) {
            if (alunos[i].getMatricula().equals(matriculaAluno)) {
                //move os alunos restantes para o comeco do array(esquerda)
                for (int j = i; j < contadorAlunos - 1; j++) {
                    alunos[j] = alunos[j + 1];
                }
                alunos[contadorAlunos - 1] = null; //limpa a ref. do ultimo aluno
                contadorAlunos--;
                return true; //Confirma que o aluno foi removido
            }
        }
        return false; //aluno nao encontrado
    }
}