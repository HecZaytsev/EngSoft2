/**
 *
 * @author Heck
 */
public class NodoNota {
    private Nota nota;
    private NodoNota prox;
    
    public NodoNota(Nota nota){
        this.nota = nota;
        this.prox = null;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public NodoNota getProx() {
        return prox;
    }

    public void setProx(NodoNota prox) {
        this.prox = prox;
    }
}
