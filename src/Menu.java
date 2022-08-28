/**
 *
 * @author Heck
 */
public class Menu {

    Leitura ler;
    NodoDisciplina iniciodisciplinas;
    NodoDisciplina fimdisciplinas;

    public Menu() {
        ler = new Leitura();
        menu();
    }

    public void menu() {
        Disciplina novadisciplina;
        Nota novanota;
        NodoNota novonodonota;
        NodoDisciplina novonododisciplina;
        Aluno novoaluno;
        NodoAluno busca;
        String nome;
        int pos;
        NodoAluno novonodoaluno;
        int cod;
        int opc = -1;
        while (opc != 0) {
            opcoes();
            opc = ler.leInt("Escolha uma função: ");
            switch (opc) {
                case 1:
                    novadisciplina = new Disciplina(ler.leString("Digite o nome da disciplina"), ler.leInt("Insira um codigo para a disciplina"));
                    novonododisciplina = new NodoDisciplina(novadisciplina);
                    if (iniciodisciplinas == null) {
                        iniciodisciplinas = novonododisciplina;
                        fimdisciplinas = novonododisciplina;
                    } else {
                        insereInicio(novadisciplina);

                    }
                    break;

                case 2:
                    novoaluno = new Aluno(ler.leString("Digite o nome do aluno: "));
                    cod = ler.leInt("Digite o codigo da disciplina para inserir o aluno: ");
                    if (consultaCod(cod) == null) {
                        System.out.println("Codigo não encontrado!");
                    } else {
                        consultaCod(cod).getDisciplina().insereAluno(novoaluno);
                        System.out.println("Aluno inserido!");
                    }

                    break;
                case 3:
                    cod = ler.leInt("Digite o codigo da disciplina do aluno");
                    if (consultaCod(cod) == null) {
                        System.out.println("Codigo não encontrado!");
                    } else {
                        nome = ler.leString("Digite o nome do aluno");
                        busca = consultaCod(cod).getDisciplina().consultaNomeAluno(nome);
                        if (busca == null) {
                            System.out.println("Aluno não encontrado");
                        } else {
                            busca.getAluno().insereNota(new Nota(ler.leFloat("Digite a nota")));
                            System.out.println("Nota inserida!");
                        }
                    }

                    break;

                case 4:
                    escreve();
                    break;

                case 5:
                    cod = ler.leInt("Digite o codigo da disciplina");
                    if (consultaCod(cod) == null) {
                        System.out.println("Codigo de disciplina inválido");
                    } else {
                        consultaCod(cod).getDisciplina().mostrarTurma();
                    }

                    break;
                case 6:
                    nome = ler.leString("Digite o nome do aluno");
                    System.out.println("");
                    novonododisciplina = iniciodisciplinas;
                    while (novonododisciplina.getProx() != null) {
                        novonodoaluno = novonododisciplina.getDisciplina().consultaNomeAluno(nome);
                        if (novonodoaluno != null) {
                            if (novonodoaluno.getAluno().getNome().equals(nome)) {
                                System.out.println("Disciplina: " + novonododisciplina.getDisciplina().getNome());
                                novonodoaluno.getAluno().mostrarAluno();
                                System.out.println("");
                            }
                        }
                        novonododisciplina = novonododisciplina.getProx();
                    }
                    novonodoaluno = novonododisciplina.getDisciplina().consultaNomeAluno(nome);
                    if (novonodoaluno != null) {
                        if (novonodoaluno.getAluno().getNome().equals(nome)) {
                            System.out.println("Disciplina: " + novonododisciplina.getDisciplina().getNome());
                            novonodoaluno.getAluno().mostrarAluno();
                        }
                    }

                    break;
                case 7:
                    if (iniciodisciplinas == null) {
                        System.out.println("Não há disciplinas");
                        break;
                    }
                    cod = ler.leInt("Digite o codigo da disciplina para excluir: ");
                    if (consultaCod(cod).getDisciplina().getTurma() == null) {
                        excluiCod(cod);
                        System.out.println("Disciplina excluida!");
                    } else {
                        System.out.println("A disciplina deve estar vazia!");
                    }
                    break;

                case 8:
                    if (iniciodisciplinas == null) {
                        System.out.println("Não há disciplinas");
                        break;
                    }
                    cod = ler.leInt("Digite o codigo da disciplina do aluno: ");
                    System.out.println("");
                    nome = ler.leString("Digite o nome do aluno:");
                    System.out.println("");
                    try {
                        novoaluno = consultaCod(cod).getDisciplina().consultaNomeAluno(nome).getAluno();
                    } catch (Exception ex) {
                        System.out.println("Aluno não encontrado");
                        break;
                    }
                    pos = consultaCod(cod).getDisciplina().verificaPosAluno(novoaluno);
                    if (consultaCod(cod).getDisciplina().excluiPosicao(pos)) {
                        System.out.println("Aluno Excluído!");
                    }
                    break;

                case 9:
                    if (iniciodisciplinas == null) {
                        System.out.println("Não há disciplinas");
                        break;
                    }
                    nome = ler.leString("Digite o nome do aluno:");
                    System.out.println("");
                    NodoDisciplina atual = iniciodisciplinas;
                    while (atual != null) {
                        try {
                            novoaluno = atual.getDisciplina().consultaNomeAluno(nome).getAluno();
                        } catch (Exception ex) {
                            System.out.println("Aluno não presente em " + atual.getDisciplina().getNome());
                            novoaluno = null;
                        }
                        if (novoaluno != null) {
                            pos = atual.getDisciplina().verificaPosAluno(novoaluno);
                            if (atual.getDisciplina().excluiPosicao(pos)) {
                                System.out.println("Aluno Excluído de " + atual.getDisciplina().getNome());
                            }
                        }
                        atual = atual.getProx();
                    }
                    break;
            }
        }
        opcoes();
    }

    private void insereInicio(Disciplina disciplina) {
        NodoDisciplina novo = new NodoDisciplina(disciplina);
        if (iniciodisciplinas == null) {
            fimdisciplinas = novo;
        } else {
            iniciodisciplinas.setAnt(novo);
            novo.setProx(iniciodisciplinas);
        }
        iniciodisciplinas = novo;
    }

    private void excluiInicio() {
        NodoDisciplina atual = iniciodisciplinas;
        if (iniciodisciplinas != null) {
            if (iniciodisciplinas == fimdisciplinas) {
                iniciodisciplinas = null;
                fimdisciplinas = null;
            } else {
                iniciodisciplinas = iniciodisciplinas.getProx();
                iniciodisciplinas.setAnt(null);
            }
        } else {
            System.out.println("Não há disciplinas!");
        }
    }

    private void excluiFim() {
        NodoDisciplina atual = fimdisciplinas;
        if (iniciodisciplinas != null) {
            if (iniciodisciplinas == fimdisciplinas) {
                iniciodisciplinas = null;
                fimdisciplinas = null;
            } else {
                fimdisciplinas = fimdisciplinas.getAnt();
                fimdisciplinas.setProx(null);
            }
        } else {
            System.out.println("Não há disciplinas!");
        }
    }

    private void excluiCod(int cod) {
        NodoDisciplina atual = null;
        if (iniciodisciplinas != null) {
            atual = this.consultaCod(cod);
            if (atual == null) {
                System.out.println("Não existe uma disciplina com esse codigo");
            } else {
                if (iniciodisciplinas == fimdisciplinas) {
                    iniciodisciplinas = null;
                    fimdisciplinas = null;
                } else {
                    if (iniciodisciplinas.getDisciplina().getCodigo() == cod) {
                        this.excluiInicio();
                    } else {
                        if (fimdisciplinas.getDisciplina().getCodigo() == cod) {
                            this.excluiFim();
                        } else {
                            atual.getAnt().setProx(atual.getProx());
                            atual.getProx().setAnt(atual.getAnt());
                        }

                    }
                }
            }
        } else {
            System.out.println("Não há disciplinas!");
        }
    }

    private void escreve() {
        NodoDisciplina primeiro = iniciodisciplinas;
        if (primeiro == null) {
            System.out.println("Não há disciplinas");
        } else {
            while (primeiro != null) {
                System.out.println(primeiro.getDisciplina().toString());
                primeiro = primeiro.getProx();
            }
        }
    }

    NodoDisciplina consultaCod(int cod) {
        NodoDisciplina atual = iniciodisciplinas;
        while ((atual != null) && (atual.getDisciplina().getCodigo() != cod)) {
            atual = atual.getProx();
        }
        return atual;
    }

    private void opcoes() {
        System.out.println("1 - Inserir disciplina");
        System.out.println("2 - Inserir aluno");
        System.out.println("3 - Inserir nota");
        System.out.println("4 - Listar as disciplinas e número de alunos nelas");
        System.out.println("5 - Listar alunos, notas e médias de uma disciplina");
        System.out.println("6 - Analisar um aluno pelo nome");
        System.out.println("7 - Exclui uma disciplina");
        System.out.println("8 - Exclui um aluno de uma disciplina");
        System.out.println("9 - Exclui aluno de todas disciplinas");
        System.out.println("0 - Sair");
    }
}
