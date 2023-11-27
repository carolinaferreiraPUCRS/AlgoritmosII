import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class NossoDigrafo {
    private int qtdVertices;
    private int arestas;
    private ArrayList<Vertice>[] listaAdjacencia;
    public ArrayList<Vertice> listaVertices;

    NossoDigrafo(int qtdVertices) {
        this.arestas = 0;
        this.qtdVertices = qtdVertices;
        this.listaVertices = new ArrayList<>();
        listaAdjacencia = new ArrayList[this.qtdVertices];
        for (int i = 0; i < this.qtdVertices; i++) {
            listaAdjacencia[i] = new ArrayList<>();
        }
    }

    public int getArestas() {
        return arestas;
    }

    public void adicionarAresta(Vertice[] vertices, Vertice w) {
        for (int i = 0; i < vertices.length; i++) {
            if (buscaVerticeParaAdicionar(vertices[i], w) != null) {
                return;
            }
            int counterV = 0;
            if (existeVertice(vertices[i])) {
                counterV = posicaoVerticeNaLista(vertices[i]);
            }
            listaAdjacencia[counterV].add(w);
            adicionarVerticeNaLista(vertices[i]);
            adicionarVerticeNaLista(w);
            arestas++;
        }
    }

    public void lerArquivo(String caminhoArquivo) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(caminhoArquivo))) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                adicionarArestaFromLinha(linha);
            }
        }
    }

    private void adicionarArestaFromLinha(String linha) {
        String[] partes = linha.split(" -> ");

        // Verifique se a linha possui o formato esperado
        if (partes.length != 2) {
            System.out.println("Formato inválido: " + linha);
            return;
        }

        String[] origemPartes = partes[0].split(" ");
        String[] destinoPartes = partes[1].split(" ");

        // Verifique se as partes têm o formato esperado
        if (origemPartes.length < 2 || destinoPartes.length != 2) {
            System.out.println("Formato inválido: " + linha);
            return;
        }

        int peso = Integer.parseInt(destinoPartes[0]);

        // Criação dos vértices
        Vertice[] vertices = new Vertice[origemPartes.length - 1];
        for (int i = 1; i < origemPartes.length; i++) {
            vertices[i - 1] = new Vertice(origemPartes[i], 1);
        }

        Vertice w = new Vertice(destinoPartes[1], peso);

        // Adição da aresta
        adicionarAresta(vertices, w);
    }
    // public void adicionarAresta(Vertice v, Vertice w) {
    //     if (buscaVerticeParaAdicionar(v, w) != null) {
    //         return;
    //     }
    //     int counterV = 0;
    //     if (existeVertice(v)) {
    //         counterV = posicaoVerticeNaLista(v);
    //     }
    //     listaAdjacencia[counterV].add(w);
    //     adicionarVerticeNaLista(v);
    //     adicionarVerticeNaLista(w);

    //     arestas++;
    // }

    public Iterable<Vertice> adjacentes(int vertice) {
        return listaAdjacencia[vertice];
    }

    public int posicaoVerticeNaLista(Vertice v) {
        for (int i = 0; i < listaVertices.size(); i++) {
            if (listaVertices.get(i).equals(v)) {
                return i;
            }
        }
        return -1;
    }

    public boolean existeVertice(Vertice v) {
        for (int i = 0; i < listaVertices.size(); i++) {
            if (listaVertices.get(i).equals(v)) {
                return true;
            }
        }
        return false;
    }

    public void adicionarVerticeNaLista(Vertice v) {
        if (listaVertices.contains(v)) {
            return;
        }
        listaVertices.add(v);
    }

    public String buscaVerticeParaAdicionar(Vertice v, Vertice w) {
        for (int i = 0; i < qtdVertices; i++) {
            if (listaAdjacencia[i].equals(v)) {
                return v.getElemento();
            }
            if (listaAdjacencia[i].equals(w)) {
                return w.getElemento();
            }
        }
        return null;
    }

    // public int calculaQuantidadeDeHidrogenio(String v) {
    //     for (int i=0; i<listaVertices.size(); i++) {
    //         if (listaVertices.get(i).equals("hidrogenio")) {
    //             listaAdjacencia[i];
    //         }
    //     }
    // }

    public String toDot() {
        // String resultado = "graph G { " + System.lineSeparator();
        // for (int i = 0; i < qtdVertices; i++) {
        //     resultado = resultado + "\t" + i + ";" + System.lineSeparator();
        // }
        // boolean[][] jaImpresso = new boolean[qtdVertices][qtdVertices];
        // for (int i = 0; i < qtdVertices; i++) {
        //     for (int j = 0; j < listaAdjacencia[i].size(); j++) {
        //         ArestaValorada aresta = listaAdjacencia[i].get(j);
        //         String verticeV = aresta.getV();
        //         String verticeW = aresta.getW();
        //         int v = posicaoVerticeNaLista(verticeV);
        //         int w = posicaoVerticeNaLista(verticeW);
        //         int peso = aresta.getPeso();
        //         if (!jaImpresso[v][w] && !jaImpresso[w][v]) {
        //             resultado += "\t" + verticeV + "--" + verticeW + "  [label=" + peso + "]" + ";"
        //                     + System.lineSeparator();
        //             jaImpresso[v][w] = true;
        //             jaImpresso[w][v] = true;
        //         }
        //     }
        // }
        // resultado += "}";
        // return resultado;
        String resultado = "digraph G { " + System.lineSeparator();
        for (int i = 0; i < listaVertices.size(); i++) {
            resultado = resultado + "\t" + i + ";" + System.lineSeparator();
        }
        for (int i = 0; i < listaVertices.size(); i++) {
            for (int j = 0; j < listaAdjacencia[i].size(); j++) {
                resultado += "\t" + listaAdjacencia[i].toString() + "->" + listaAdjacencia[i].get(j).toString() + ";" + System.lineSeparator() + "\n";
            }
        }
        resultado += "}";
        return resultado;
    }

    // public void lerArquivo(String caminhoArquivo) throws FileNotFoundException {
    //     try (Scanner scanner = new Scanner(new File(caminhoArquivo))) {
    //         while (scanner.hasNextLine()) {
    //             String linha = scanner.nextLine();
    //             adicionarArestaFromLinha(linha);
    //         }
    //     }
    // }

    // private void adicionarArestaFromLinha(String linha) {
    //     String[] partes = linha.split(" -> ");
    //     String[] origemPartes = partes[0].split(" ");
    //     String[] destinoPartes = partes[1].split(" ");
    //     String origem = origemPartes[1];
    //     String destino = destinoPartes[1];
    //     int peso = Integer.parseInt(destinoPartes[0]);

    //     adicionarAresta(origem, destino, peso);
    // }
}


/* 
public class CalculadoraHidrogenio {
    private static Map<String, List<Aresta>> grafo = new HashMap<>();

    private static class Aresta {
        int quantidade;
        List<String> elementos;

        Aresta(int quantidade, List<String> elementos) {
            this.quantidade = quantidade;
            this.elementos = elementos;
        }
    }

    public static void main(String[] args) {
        lerRegrasDoArquivo("regras.txt");

        List<String> caminho = encontrarCaminho("hidrogenio", "ouro");

        if (caminho != null) {
            int quantidadeHidrogenio = calcularQuantidadeHidrogenio(caminho);
            System.out.println("A quantidade de hidrogenio necessaria para obter ouro e: " + quantidadeHidrogenio);
        } else {
            System.out.println("Não foi encontrado um caminho do hidrogenio ao ouro.");
        }
    }

    private static void lerRegrasDoArquivo(String nomeArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(" -> ");
                String[] entrada = partes[0].split("\\s+");
                int quantidade = Integer.parseInt(entrada[0]);
                List<String> elementos = Arrays.asList(Arrays.copyOfRange(entrada, 1, entrada.length));
                String produto = partes[1];
                if (!grafo.containsKey(produto)) {
                    grafo.put(produto, new ArrayList<>());
                }
                grafo.get(produto).add(new Aresta(quantidade, elementos));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> encontrarCaminho(String inicio, String fim) {
        Queue<List<String>> fila = new LinkedList<>();
        Set<String> visitados = new HashSet<>();

        fila.add(Collections.singletonList(inicio));
        visitados.add(inicio);

        while (!fila.isEmpty()) {
            List<String> caminhoAtual = fila.poll();
            String ultimoElemento = caminhoAtual.get(caminhoAtual.size() - 1);

            if (ultimoElemento.equals(fim)) {
                return caminhoAtual;
            }

            if (grafo.containsKey(ultimoElemento)) {
                for (Aresta aresta : grafo.get(ultimoElemento)) {
                    List<String> novoCaminho = new ArrayList<>(caminhoAtual);
                    novoCaminho.addAll(aresta.elementos);
                    if (!visitados.contains(novoCaminho.get(novoCaminho.size() - 1))) {
                        fila.add(novoCaminho);
                        visitados.add(novoCaminho.get(novoCaminho.size() - 1));
                    }
                }
            }
        }

        return null;
    }

    private static int calcularQuantidadeHidrogenio(List<String> caminho) {
        int quantidadeHidrogenio = 0;

        for (int i = 0; i < caminho.size() - 1; i++) {
            String elementoAtual = caminho.get(i);
            String proximoElemento = caminho.get(i + 1);

            if (grafo.containsKey(elementoAtual)) {
                for (Aresta aresta : grafo.get(elementoAtual)) {
                    if (aresta.elementos.get(aresta.elementos.size() - 1).equals(proximoElemento)) {
                        quantidadeHidrogenio += aresta.quantidade;
                        break;
                    }
                }
            }
        }

        return quantidadeHidrogenio;
    }
}
*/
