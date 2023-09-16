import java.util.HashMap;
import java.util.LinkedList;

public class Lista {
    private LinkedList<Character> lista;
    private HashMap<Character, Character> map;
    
    public Lista() {
        lista = new LinkedList<Character>();
    }

    public void add(char element) {
        lista.add(element);
    }

    public void deteriorar() {
        if (lista.size() <= 0) {
            return;
        }
        int indice = 0;

        while(podeDeteriorar() && indice < lista.size() - 1) {
            if (lista.get(indice) != lista.get(indice + 1)) {
                char c = compare(lista.get(indice), lista.get(indice + 1));
                lista.remove(indice);
                lista.remove(indice);
                lista.addLast(c);
                indice = 0;
            } else {
                indice++;
            }
        }
     }

     public boolean podeDeteriorar() {
        boolean ok = false;

        for (int i = 0; i < lista.size() - 1; i++) {

            if (lista.get(i) != lista.get(i + 1)) {
                ok = true;
                return ok;
            }
        }
        return ok;
     }

     public char compare(char a, char b) {
        if ((a == 'D' && b == 'N') || (a == 'N' && b == 'D') ) {
            return 'A';
        } else if ((a == 'D' && b == 'A') || (a == 'A' && b == 'D')) {
            return 'N';
        } else if ((a == 'A' && b == 'N') || (a == 'N' && b == 'A')) {
            return 'D';
        } else {
            return '*';
        }
     }

     @Override
     public String toString() {
        String s = "";
        for (int i = 0; i < lista.size(); i++) {
            s += lista.get(i);
        }
        return s;
     }
}
