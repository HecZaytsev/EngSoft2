/**
 *
 * @author Heck
 */
public class NodoDisciplina{
	private Disciplina disciplina;
	private NodoDisciplina prox;
	private NodoDisciplina ant;
        public NodoDisciplina(){
            this.disciplina = null;
            this.ant = null;
            this.prox = null;
        }
        public NodoDisciplina(Disciplina disciplina){
            this.disciplina = disciplina;
            this.ant = null;
            this.prox = null;
        }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public NodoDisciplina getProx() {
        return prox;
    }

    public void setProx(NodoDisciplina prox) {
        this.prox = prox;
    }

    public NodoDisciplina getAnt() {
        return ant;
    }

    public void setAnt(NodoDisciplina ant) {
        this.ant = ant;
    }
}