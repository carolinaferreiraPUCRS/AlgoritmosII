import java.util.Scanner;

public class Controller {
    Scanner in;
    private ArchiveReader ar;
    private LinkedList lista;

    public Controller() {
        in = new Scanner(System.in);
        // ar = new ArchiveReader("ct_10.txt");
        // ar.read();
        // lista = ar.getLista();
    }

    public void execute() {
        boolean ok;
        int option = 0;

        do {
            do {
                ok = true;
                menu();
                try {
                    option = in.nextInt();
                } catch (Exception e) {
                    in.nextLine();
                    ok = false;
                    e.printStackTrace();
                    System.out.println("Opção inválida");
                }
            } while (!ok);
            in.nextLine();
            switch (option) {
                case 1:
                    ar = new ArchiveReader("ct_10.txt");
                    ar.read();
                    lista = ar.getLista();
                    lista.deteriorar();
                    System.out.println("\n" + "Cadeia deteriorada: " + lista + "\n");
                    break;
                case 2:
                    ar = new ArchiveReader("ct_100.txt");
                    ar.read();
                    lista = ar.getLista();
                    lista.deteriorar();
                    System.out.println("\n" + "Cadeia deteriorada: " + lista + "\n");
                    break;
                case 3:
                    ar = new ArchiveReader("ct_1000.txt");
                    ar.read();
                    lista = ar.getLista();
                    lista.deteriorar();
                    System.out.println("\n" + "Cadeia deteriorada: " + lista + "\n");
                    break;
                case 4:
                    ar = new ArchiveReader("ct_10000.txt");
                    ar.read();
                    lista = ar.getLista();
                    lista.deteriorar();
                    System.out.println("\n" + "Cadeia deteriorada: " + lista + "\n");
                    break;
                case 5:
                    ar = new ArchiveReader("ct_10004.txt");
                    ar.read();
                    lista = ar.getLista();
                    lista.deteriorar();
                    System.out.println("\n" + "Cadeia deteriorada: " + lista + "\n");
                    break;
                case 6:
                    ar = new ArchiveReader("ct_100000.txt");
                    ar.read();
                    lista = ar.getLista();
                    lista.deteriorar();
                    System.out.println("\n" + "Cadeia deteriorada: " + lista + "\n");
                    break;
                case 7:
                    ar = new ArchiveReader("ct_1000000.txt");
                    ar.read();
                    lista = ar.getLista();
                    lista.deteriorar();
                    System.out.println("\n" + "Cadeia deteriorada: " + lista + "\n");
                    break;
                case 8:
                    ar = new ArchiveReader("ct_2000000.txt");
                    ar.read();
                    lista = ar.getLista();
                    lista.deteriorar();
                    System.out.println("\n" + "Cadeia deteriorada: " + lista + "\n");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
            }
        } while (option != 0);
    }

    public void menu() {
        System.out.println("=====================================");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Deteriorar arquivo 'ct_10.txt'");
        System.out.println("2 - Deteriorar arquivo 'ct_100.txt'");
        System.out.println("3 - Deteriorar arquivo 'ct_1000.txt'");
        System.out.println("4 - Deteriorar arquivo 'ct_10000.txt'");
        System.out.println("5 - Deteriorar arquivo 'ct_10004.txt'");
        System.out.println("6 - Deteriorar arquivo 'ct_100000.txt'");
        System.out.println("7 - Deteriorar arquivo 'ct_1000000.txt'");
        System.out.println("8 - Deteriorar arquivo 'ct_2000000.txt'");
        System.out.println("0 - Sair");
        System.out.println("=====================================");
    }

}
