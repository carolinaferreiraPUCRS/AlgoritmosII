public class LinkedList {

    private Node head;
    private Node tail;
    private Node current;
    private int count;

    private class Node {
        public char element;
        public Node next;

        public Node(char e) {
            this.element = e;
            next = null;
        }
    }

    public LinkedList() {
        head = null;
        tail = null;
        count = 0;
    }

    public void add(char element) {
        Node n = new Node(element);
        if (head == null) {
            head = n;
        } else {
            tail.next = n;
        }
        tail = n;
        count++;

    }

    public void deteriorar() {
        if (head == null || head.next == null) {
            return;
        }

        Node aux = head;
        Node aux2 = head.next;
        Node prev = null;

        while (aux2 != null) {
            if (aux.element != aux2.element) {
                char c = compare(aux, aux2);
                Node n = new Node(c);

                if (prev == null) {
                    if (aux2.next == null) {
                        aux2.next = n;
                    }
                    head = aux2.next;
                } else {
                    prev.next = aux2.next;
                }
                count--;

                if (aux2.next == null) {
                    aux2.next = n;
                    prev.next = aux2.next;
                }
                tail.next = n;
                tail = n;
         
                if (aux == head) {
                    aux = head;
                    aux2 = head.next;
                } else {
                    aux = aux2.next;
                    if (aux.next != null) {
                        aux2 = aux.next;
                    } else {
                        aux2 = null;
                    }
                }
            } else {
                aux = aux.next;
                aux2 = aux2.next;
                if (prev == null) {
                    prev = head;
                } else {
                    prev = prev.next;
                }
            }
        }
        if (podeDeteriorar()) {
            deteriorar();
        }
        
    }

    private boolean podeDeteriorar() {
        boolean ok = false;
        Node aux = head;
        Node aux2 = head.next;

        while (aux2 != null) {
            if (aux.element != aux2.element) {
                ok = true;
            }
            aux = aux.next;
            aux2 = aux2.next;
        }
        return ok;
    }

    private char compare(Node aux, Node aux2) {
        if ((aux.element == 'D' && aux2.element == 'N') || (aux.element == 'N' && aux2.element == 'D')) {
            return 'A';
        } else if ((aux.element == 'N' && aux2.element == 'A') || (aux.element == 'A' && aux2.element == 'N')) {
            return 'D';
        } else if ((aux.element == 'D' && aux2.element == 'A') || (aux.element == 'A' && aux2.element == 'D')) {
            return 'N';
        } else {
            return '*';
        }
    }

    public int size() {
        return count;
    }

    public char getValue(int index) { // Método que retorna o valor da iésima posição
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }

        if (index == count - 1) {
            return tail.element;
        }
        Node aux = head;
        int c = 0;
        while (c < index) {
            aux = aux.next;
            c++;
        }
        return aux.element;
    }

    @Override
    public String toString() {
        String s = "";
        Node aux = head;
        while (aux != null) {
            s += aux.element;
            aux = aux.next;
        }
        return s;
    }
}
