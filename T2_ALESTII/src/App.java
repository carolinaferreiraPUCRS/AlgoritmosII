public class App {
    public static void main(String[] args) throws Exception {
        NossoDigrafo g = new NossoDigrafo(1000000);
        g.lerArquivo("T2_ALESTII\\src\\teste.txt");
        g.toDot();
    }
}
