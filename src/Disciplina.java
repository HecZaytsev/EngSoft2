/**
 *
 * @author Heck
 */
public class Disciplina {
    private String nome;
    private int codigo;
    private int tamanhoturma;
    private NodoAluno inicioturma;
    public Disciplina(){
        this.nome = "";
        this.codigo = 0;
        this.tamanhoturma = 0;
        this.inicioturma = null;
    }
    public Disciplina(String nome, int codigo){
        this.nome = nome;
        this.codigo = codigo;
        this.tamanhoturma = 0;
        this.inicioturma = null;
    }
    
    public void insereAluno(Aluno aluno){
        NodoAluno novo = new NodoAluno(aluno);
        if(inicioturma == null){
            inicioturma = novo;
        }else{
            novo.setProx(inicioturma);
            inicioturma=novo;
        }
        tamanhoturma++;
    }
    
    public boolean excluiInicio(){
        boolean res =false;
        NodoAluno aux = inicioturma;
        if(inicioturma != null){
            inicioturma = inicioturma.getProx();
            aux.setProx(null);
            res=true;
        }
        return res;
    }
    
    public boolean excluiFim(){
        boolean res = false;
        NodoAluno aux = inicioturma;
        NodoAluno ant = null;
        if(inicioturma != null){
            while(aux.getProx()!=null){
                ant = aux;
                aux = aux.getProx();
            }
            ant.setProx(null);
            res=true;
        }
        return res;
    }
    
    public boolean excluiPosicao(int pos){
        NodoAluno atual = inicioturma;
        NodoAluno ant = null;
        boolean res = false;
        int qtdeAlunos = this.tamanhoturma;
        if(qtdeAlunos == 0){
            return res;
        }
        if((pos >=0)&& (pos< qtdeAlunos)){
            if(pos==qtdeAlunos){
                res = this.excluiFim();
                this.tamanhoturma--;
                return res;
            }else{
                if(pos==0){
                    res = this.excluiInicio();
                    this.tamanhoturma--;
                    return res;
                }else{
                    for(int i=0; i<pos;i++){
                        ant = atual;
                        atual = atual.getProx();
                    }
                    ant.setProx(atual.getProx());
                    res = true;
                    this.tamanhoturma--;
                }
            }
    }
        return res;
    }
    public int verificaPosAluno(Aluno aluno){
        int posicao = 0;
        int resp = -1;
        NodoAluno atual = inicioturma;
        while((resp == -1)&&(atual!=null)){
            if(aluno.getNome().equals(atual.getAluno().getNome())){
                resp = posicao;
            }else{
                posicao++;
            }
            atual = atual.getProx();
        }
        return resp;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public NodoAluno getTurma() {
        return inicioturma;
    }

    public void setTurma(NodoAluno turma) {
        this.inicioturma = turma;
    }
    public NodoAluno consultaNomeAluno(String nome){
        NodoAluno atual = inicioturma;
        try{
            while((atual.getProx() != null) && (!atual.getAluno().getNome().equals(nome))){
            atual=atual.getProx();
        }
        }catch(Exception ex){
            //System.out.println("Aluno não encontrado");
            return null;
        }
        if(!atual.getAluno().getNome().equals(nome)){
            return null;
        }
        return atual;
    }

    @Override
    public String toString() {
        return "Nome = " + nome + ", Tamanho da turma = " + tamanhoturma + " [Codigo = " + codigo + "]";
    }
    public void mostrarTurma(){
        System.out.println("" + nome + ": \n");
        NodoAluno atual = inicioturma;
        while(atual!= null){
            atual.getAluno().mostrarAluno();
            atual=atual.getProx();
        }
    }
    
}
