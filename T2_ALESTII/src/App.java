public class App {
    public static void main(String[] args) throws Exception {
        Grafo g = new Grafo(5);
        g.adicionarAresta("A", "B", 1);
        g.adicionarAresta("A", "C", 2);
        System.out.println(g.toDot());
    }
}
