import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class FileReader {
    NossoDigrafo g;

    public FileReader(String file) {
        g = new NossoDigrafo(1000000);
    }

    public void read() {
        Path path = Paths.get("T2_ALESTII\\src\\teste.txt");
        try (Scanner sc = new Scanner(path)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] lineArray = line.split(" ");

                int lastIndex = lineArray.length - 1;

                // Índice do elemento à esquerda da seta (->)
                int arrowIndex = findArrowIndex(lineArray);

                if (arrowIndex != -1) {
                    // Elementos à esquerda da seta
                    String[] leftElements = Arrays.copyOfRange(lineArray, 0, arrowIndex);

                    // Elemento à direita da seta
                    String rightElement = lineArray[lastIndex];

                    // Quantidade associada ao elemento à direita
                    int quantity = Integer.parseInt(lineArray[lastIndex - 2]);

                    // Criação de vértices e adição de arestas
                    Vertice[] vertices = Arrays.stream(leftElements)
                            .map(element -> new Vertice(element, 1))
                            .toArray(Vertice[]::new);

                    Vertice w = new Vertice(rightElement, quantity);
                    g.adicionarAresta(vertices, w);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(g.toDot());
    }

    private int findArrowIndex(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("->")) {
                return i;
            }
        }
        return -1;
    }
}

// import java.nio.file.Path;
// import java.nio.file.Paths;
// import java.util.Scanner;

// public class FileReader {
//     Digrafo g;

//     public FileReader(String file) {
//         g = new Digrafo(1000000);
//     }

//     public void read() {
//         Path path = Paths.get("T2_ALESTII\\src\\teste.txt");
//         try (Scanner sc = new Scanner(path)) {
//             while (sc.hasNextLine()) {
//                 String line = sc.nextLine();
//                 String[] lineArray = line.split(" ");
//                 Vertice v = new Vertice(lineArray[1], Integer.parseInt(lineArray[0]));
//                 Vertice w = new Vertice(lineArray[4], Integer.parseInt(lineArray[3]));
//                 g.adicionarAresta(v, w);
//             }
//         } catch (Exception e) {
//             System.out.println(e.getMessage());
//         }
//         System.out.println(g.toDot());
//     }
// }
