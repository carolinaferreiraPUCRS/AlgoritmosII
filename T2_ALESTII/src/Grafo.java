import java.util.ArrayList;
import java.util.HashMap;

public class Grafo {
    private int vertices;
    private int arestas;
    public HashMap<String, Integer> mapaVertices;
    public ArrayList<ArestaValorada>[] listaAdjacencia;

    public Grafo(int vertices) {
        this.vertices = vertices;
        this.arestas = 0; 
        listaAdjacencia = new ArrayList[this.vertices];
        for (int v = 0; v < this.vertices; v++) {
            listaAdjacencia[v] = new ArrayList<ArestaValorada>();
        }
        mapaVertices = new HashMap<String, Integer>();
    }
    public void adicionarAresta(String v, String w, int peso) {
        ArestaValorada a = new ArestaValorada(v, w, peso);
        listaAdjacencia[v].add(a);
        arestas++;
    }
    public Iterable<ArestaValorada> adjacentes(int vertice) {
        return listaAdjacencia[vertice];
    }
    public Iterable<ArestaValorada> listaArestas() {
        ArrayList<ArestaValorada> lista = new ArrayList<>();
        for (int v = 0; v < vertices; v++) {
            for (ArestaValorada a:listaAdjacencia[v]) {
                if(a.getW()>v) {
                    lista.add(a);
                }
            }
        }
        return lista;
    }
    public String toDot() {
        String resultado = "graph G { " + System.lineSeparator();
        for (int i = 0; i < this.vertices; i++) {
            resultado = resultado + "\t" + i + ";" + System.lineSeparator();
        }
        boolean[][] jaImpresso = new boolean[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < listaAdjacencia[i].size(); j++) {
                ArestaValorada aresta = listaAdjacencia[i].get(j);
                int v = aresta.getV();
                int w = aresta.getW();
                int peso = aresta.getPeso();
                if(!jaImpresso[v][w] && !jaImpresso[w][v]) {
                    resultado += "\t" + v + "--" + w + "  [label=" + peso + "]" + ";" + System.lineSeparator();
                    jaImpresso[v][w] = true;
                    jaImpresso[w][v] = true;
                }
            }
        }
        resultado += "}";
        return resultado;
    }
    public int grau(int vertice) {
        return listaAdjacencia[vertice].size();
    }
    public int getVertices() {
        return this.vertices;
    }
}
