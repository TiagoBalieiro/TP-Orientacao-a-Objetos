package view;

import javax.swing.JOptionPane;

import app.Aluno;
import app.Disciplina;
import app.Professor;
import app.Turma;
import cadastros.CadastroAluno;
import cadastros.CadastroDisciplina;
import cadastros.CadastroProfessor;
import cadastros.CadastroTurma;
import exceptions.CampoEmBrancoException;
import exceptions.DisciplinaNaoAtribuidaException;
import exceptions.NumeroIncorretoAlunosException;
import exceptions.NumeroMaximoAlunosException;

public class MenuTurma {

    private CadastroTurma cadTurma;
    private CadastroAluno cadAluno;
    private CadastroDisciplina cadDisciplina;
    private CadastroProfessor cadProfessor;

    public MenuTurma(CadastroTurma cadTurma, CadastroAluno cadAluno, CadastroDisciplina cadDisciplina, CadastroProfessor cadProfessor) {
        this.cadTurma = cadTurma;
        this.cadAluno = cadAluno;
        this.cadDisciplina = cadDisciplina;
        this.cadProfessor = cadProfessor;
    }

    public void exibirMenu() {
        String txt = "Informe a opção desejada \n"
                + "1 - Cadastrar\n"
                + "2 - Pesquisar\n"
                + "3 - Atualizar\n"
                + "4 - Remover\n"
                + "5 - Imprimir Lista de Presença\n"
                + "0 - Voltar para menu anterior";

        int opcao = -1;
        do {
            String strOpcao = JOptionPane.showInputDialog(txt);
            opcao = Integer.parseInt(strOpcao);

            switch (opcao) {
                case 1:
                    cadastrarTurma();
                    break;

                case 2:
                    pesquisarTurma();
                    break;

                case 3:
                    atualizarTurma();
                    break;

                case 4:
                    removerTurma();
                    break;

                case 5:
                    imprimirListaPresenca();
                    break;

                default:
                    break;
            }
        } while (opcao != 0);
    }

    // Método existente para cadastrar a turma
    private void cadastrarTurma() {
        Turma turma = dadosTurma();
        boolean erro = false;
        try {
            if (turma.getNome().isEmpty())
                throw new CampoEmBrancoException("Campo nome em branco");
        } catch (CampoEmBrancoException e) {
            erro = true;
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        try {
            if (turma.getCodigo().isEmpty())
                throw new CampoEmBrancoException("Campo código em branco");
        } catch (CampoEmBrancoException e) {
            erro = true;
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        try {
            if (turma.getHorario().isEmpty())
            throw new CampoEmBrancoException("Campo horário em branco");
        } catch (CampoEmBrancoException e) {
            erro = true;
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        try {
            if (turma.getDisciplinaAssociada() == null)
                throw new DisciplinaNaoAtribuidaException("Disciplina não atribuída");
        } catch (DisciplinaNaoAtribuidaException e) {
            erro = true;
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        try {
            if (turma.getProfessor() == null)
                throw new DisciplinaNaoAtribuidaException("Professor não atribuído");
        } catch (DisciplinaNaoAtribuidaException e) {
            erro = true;
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        // Verifica se o número de alunos está correto
        try{
            turma.verificarNumeroAlunos();
        } catch (NumeroIncorretoAlunosException e){
            erro = true;
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

        try {
            if (turma.getAlunos().length > turma.getQtdvagas())
                throw new NumeroMaximoAlunosException("Não é possível adicionar mais alunos. A turma está cheia");
        } catch (NumeroMaximoAlunosException e) {
            erro = true;
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        if(!erro){
            try{
                cadTurma.adicionarTurma(turma);
                JOptionPane.showMessageDialog(null, "Turma cadastrada com sucesso");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar turma" + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar turma", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Método existente para pesquisar a turma
    private void pesquisarTurma() {
        String codigo = JOptionPane.showInputDialog("Informe o código da turma: ");
        Turma turma = cadTurma.buscarTurma(codigo);
        if (turma != null) {
            JOptionPane.showMessageDialog(null, turma.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Turma não encontrada");
        }
    }
    
    // Método existente para atualizar a turma
    private void atualizarTurma() {
        String codigo = JOptionPane.showInputDialog("Informe o código da turma a ser atualizada: ");
        Turma turma = cadTurma.buscarTurma(codigo);
        
        if (turma != null) {
            // Solicitar novos dados do usuário
            String novoNome = JOptionPane.showInputDialog("Informe o novo nome (deixe em branco para manter o atual):", String.valueOf(turma.getNome()));
            String novoCodigo = JOptionPane.showInputDialog("Informe o novo código (deixe em branco para manter o atual):", String.valueOf(turma.getCodigo()));
            String novoNumero = JOptionPane.showInputDialog("Informe o novo número (deixe em branco para manter o atual):", String.valueOf(turma.getNumero()));
            String novoHorario = JOptionPane.showInputDialog("Informe o novo horário (deixe em branco para manter o atual):", turma.getHorario());
            String novaQtdVagas = JOptionPane.showInputDialog("Informe a nova quantidade de vagas (deixe em branco para manter o atual):", String.valueOf(turma.getQtdvagas()));
            String novoCodigoDisciplina = JOptionPane.showInputDialog("Informe o código da nova disciplina (deixe em branco para manter a atual):");
            String novaMatriculaProfessor = JOptionPane.showInputDialog("Informe a matrícula FUB do novo professor (deixe em branco para manter a atual):");                
            if (novoNome != null && !novoNome.trim().isEmpty()) {
                turma.setNome(novoNome);
            }
            if (novoCodigo != null && !novoCodigo.trim().isEmpty()) {
                turma.setCodigo(novoCodigo);
            }  
            if (novoNumero != null && !novoNumero.trim().isEmpty()) {
                try {
                    turma.setNumero(Integer.parseInt(novoNumero));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Número inválido. A turma não foi atualizada.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            if (novoHorario != null && !novoHorario.trim().isEmpty()) {
                turma.setHorario(novoHorario);
            }
            if (novaQtdVagas != null && !novaQtdVagas.trim().isEmpty()) {
                try {
                    int novaQtdVagasInt = Integer.parseInt(novaQtdVagas);
                    turma.setQtdVagas(novaQtdVagasInt);
                    //redimensiona o array de alunos se a qtdvagas mudar 
                    if (novaQtdVagasInt < turma.getContadorAlunos()) {
                        //se o novo numero de vagas for menor do que os alunos, precisamos remover alunos que excedem esse numero
                        Aluno[] novosAlunos = new Aluno[novaQtdVagasInt];
                        System.arraycopy(turma.getAlunos(), 0, novosAlunos, 0, novaQtdVagasInt);
                        turma.setAlunos(novosAlunos);
                    }else{
                        Aluno[] novosAlunos = new Aluno[novaQtdVagasInt];
                        System.arraycopy(turma.getAlunos(), 0, novosAlunos, 0, turma.getContadorAlunos());
                        turma.setAlunos(novosAlunos);
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Quantidade de vagas inválida. A turma não foi atualizada.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            if (novoCodigoDisciplina != null && !novoCodigoDisciplina.trim().isEmpty()) {
                Disciplina novaDisciplina = cadDisciplina.buscarDisciplina(novoCodigoDisciplina);
                if (novaDisciplina != null) {
                    turma.setDisciplinaAssociada(novaDisciplina);
                } else {
                    JOptionPane.showMessageDialog(null, "Disciplina não encontrada. A turma não foi atualizada.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            if (novaMatriculaProfessor != null && !novaMatriculaProfessor.trim().isEmpty()) {
                Professor novoProfessor = cadProfessor.buscarProfessor(novaMatriculaProfessor);
                if (novoProfessor != null) {
                    turma.setProfessor(novoProfessor);
                } else {
                    JOptionPane.showMessageDialog(null, "Professor não encontrado. A turma não foi atualizada.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } 

            // Remover alunos matriculados
            while (true) {
                String matriculaAluno = JOptionPane.showInputDialog("Informe a matrícula do aluno para remover da turma (deixe em branco para continuar):");
                if (matriculaAluno == null || matriculaAluno.trim().isEmpty()) {
                    break;
                }

                boolean removido = turma.removerAluno(matriculaAluno);
                if (!removido) {
                    JOptionPane.showMessageDialog(null, "Aluno não encontrado. Matrícula inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }

            //adiciona um novo aluno matriculado
            while (true) {
                String matriculaAluno = JOptionPane.showInputDialog("Informe a matrícula do aluno para adicionar à turma (deixe em branco para terminar):");
                if (matriculaAluno == null || matriculaAluno.trim().isEmpty()) {
                    break;
                }
    
                Aluno aluno = cadAluno.buscarAluno(matriculaAluno);
                if (aluno != null) {
                    turma.adicionarAluno(aluno);
                } else {
                    JOptionPane.showMessageDialog(null, "Aluno não encontrado. Matrícula inválida.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }      
        }else {
            JOptionPane.showMessageDialog(null, "Turma não encontrada");
        }
        // Validar e atualizar a turma
        boolean erro = false;
        
        try {
            if (turma.getNome().isEmpty())
            throw new CampoEmBrancoException("Campo nome em branco");
        } catch (CampoEmBrancoException e) {
            erro = true;
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        try {
            if (turma.getCodigo().isEmpty())
            throw new CampoEmBrancoException("Campo código em branco");
        } catch (CampoEmBrancoException e) {
            erro = true;
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        try {
            if (turma.getHorario().isEmpty())
            throw new CampoEmBrancoException("Campo horário em branco");
        } catch (CampoEmBrancoException e) {
            erro = true;
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        try {
            if (turma.getQtdvagas() <= 0)
            throw new CampoEmBrancoException("Campo quantidade de vagas deve ser maior que zero");
        } catch (CampoEmBrancoException e) {
            erro = true;
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        try {
            if (turma.getDisciplinaAssociada() == null)
            throw new DisciplinaNaoAtribuidaException("Disciplina não atribuída");
        } catch (DisciplinaNaoAtribuidaException e) {
            erro = true;
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        try {
            if (turma.getProfessor() == null)
            throw new DisciplinaNaoAtribuidaException("Professor não atribuído");
        } catch (DisciplinaNaoAtribuidaException e) {
            erro = true;
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        try {
            turma.verificarNumeroAlunos();
        } catch (NumeroIncorretoAlunosException e) {
            erro = true;
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        try {
            if (turma.getAlunos().length > turma.getQtdvagas())
            throw new NumeroMaximoAlunosException("Não é possível adicionar mais alunos. A turma está cheia");
        } catch (NumeroMaximoAlunosException e) {
            erro = true;
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
        if (!erro) {
            cadTurma.atualizarTurma(turma);
            JOptionPane.showMessageDialog(null, "Turma atualizada com sucesso");
        }else{
            JOptionPane.showMessageDialog(null, "Erro ao atualizar turma");
        }
    }
    // Método existente para remover a turma
    private void removerTurma() {
        String codigo = JOptionPane.showInputDialog("Informe o código da turma a ser removida: ");
        boolean removido = cadTurma.removerTurma(codigo);
        if (removido) {
            JOptionPane.showMessageDialog(null, "Turma removida");
        } else {
            JOptionPane.showMessageDialog(null, "Turma não encontrada");
        }
    }

    // Novo método para imprimir a lista de presença de uma turma específica
    private void imprimirListaPresenca() {
        String codigo = JOptionPane.showInputDialog("Informe o código da turma para imprimir a lista de presença: ");
        Turma turma = cadTurma.buscarTurma(codigo);
        if (turma != null) {
            StringBuilder listaPresenca = new StringBuilder();
            listaPresenca.append("Lista de Presença\n");
            listaPresenca.append("Código da Turma: ").append(turma.getCodigo()).append("\n");
            listaPresenca.append("Nome da Disciplina: ").append(turma.getDisciplinaAssociada().getNome()).append("\n");
            listaPresenca.append("Nome do Professor: ").append(turma.getProfessor().getNome()).append("\n");
            listaPresenca.append("Alunos Matriculados:\n");

            for (Aluno aluno : turma.getAlunos()) {
                listaPresenca.append(aluno.getMatricula()).append(" - ").append(aluno.getNome()).append("\n");
            }

            JOptionPane.showMessageDialog(null, listaPresenca.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Turma não encontrada");
        }
    }

    // Método existente para coletar dados da turma
    private Turma dadosTurma() {
        String nome = JOptionPane.showInputDialog("Informe o nome: ");
        String codigo = JOptionPane.showInputDialog("Informe o código: ");
        String numeroStr = JOptionPane.showInputDialog("Informe o número: ");
        String horario = JOptionPane.showInputDialog("Informe o horário: ");
        String qtdVagasStr = JOptionPane.showInputDialog("Informe a quantidade de vagas: ");
        Disciplina disciplinaAssociada = cadDisciplina.buscarDisciplina(JOptionPane.showInputDialog("Informe o código da disciplina: "));
        Professor professor = cadProfessor.buscarProfessor(JOptionPane.showInputDialog("Informe a matrícula FUB do professor: "));
        int contadorAlunos = 0;
        //Verifica e trata da entrada de número e qtdvagas
        int numero = 0;
        int qtdVagas =0;
        try {
            if(numeroStr != null && !numeroStr.trim().isEmpty()){
                numero = Integer.parseInt(numeroStr);
            }
            if(qtdVagasStr != null && !qtdVagasStr.trim().isEmpty()){
                qtdVagas = Integer.parseInt(qtdVagasStr);
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Número ou quantidade de vagas inválidos. A turma não foi Cadastrada", "Erro", JOptionPane.ERROR_MESSAGE);
        }

        Turma turma = new Turma(nome, codigo, horario, qtdVagas, numero, disciplinaAssociada, professor, contadorAlunos);

        String alunosInput = JOptionPane.showInputDialog("Informe as matrículas dos alunos (separados por vírgula): ");
        String[] matriculasAlunos = alunosInput.split(",\\s*");

        for (String matricula : matriculasAlunos) {
            Aluno aluno = cadAluno.buscarAluno(matricula.trim());
            if (aluno != null) {
                turma.adicionarAluno(aluno);
            } else {
                JOptionPane.showMessageDialog(null, "Aluno com matrícula " + matricula + " não encontrado.");
            }
        }

        return turma;
    }
}
