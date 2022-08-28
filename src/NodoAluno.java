/**
 *
 * @author Heck
 */
public class NodoAluno {
    private Aluno aluno;
    private NodoAluno prox;
    
    public NodoAluno(Aluno aluno){
        this.aluno = aluno;
        this.prox = null;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public NodoAluno getProx() {
        return prox;
    }

    public void setProx(NodoAluno prox) {
        this.prox = prox;
    }
    
}
