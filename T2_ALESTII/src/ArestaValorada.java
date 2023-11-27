public class ArestaValorada {
    private String v;
    private String w;
    private int peso;

    ArestaValorada(String v, String w, int peso) {
        this.v = v;
        this.w = w;
        this.peso = peso;
    }

    public String getV() {
        return v;
    }

    public String getW() {
        return w;
    }

    public String adjacente(String vertice) {
        if(vertice==v) return w;
        else return v;
    }

    public int getPeso() {
        return peso;
    }

    public int compareTo(ArestaValorada outraAresta) {
        if(this.peso<outraAresta.peso) return -1;
        else if(this.peso>outraAresta.peso) return 1;
        else return 0;
    }
}
