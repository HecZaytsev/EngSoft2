/**
 *
 * @author Heck
 */
public class Aluno {

    private String nome;
    private NodoNota inicionotas;

    public Aluno() {
        this.nome = "";
        this.inicionotas = null;
    }

    public Aluno(String nome) {
        this.nome = nome;
        this.inicionotas = null;
    }

    public void insereNota(Nota nota) {
        NodoNota novo = new NodoNota(nota);
        if (inicionotas == null) {//primeira insersão
            inicionotas = novo;
        } else {
            novo.setProx(inicionotas);
            inicionotas = novo;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public NodoNota getNotas() {
        return inicionotas;
    }

    public void setNotas(NodoNota notas) {
        this.inicionotas = notas;
    }

    public void mostrarAluno() {
        System.out.print(nome +" | Notas: ");
        NodoNota atual = inicionotas;
        int contador = 0;
        float somador = 0;
        if(atual == null){
            System.out.print("Sem notas!");
        }else{
            while(atual != null){
                try{
                System.out.print(atual.getNota().getValor() + ", ");
                somador = somador + atual.getNota().getValor();
                atual = atual.getProx();  
                contador++;
                }catch(Exception ex){
                    break;
                }
            }
            somador = somador/contador;
            System.out.print("[Média: "+somador+"]");
        }
        System.out.println("");
    }
}
