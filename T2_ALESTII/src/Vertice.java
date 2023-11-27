public class Vertice {
    private String elemento;
    private int quantidade;

    Vertice(String elemento, int quantidade) {
        this.elemento = elemento;
        this.quantidade = quantidade;
    }

    public String getElemento() {
        return elemento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String toString() {
        return "Vertice: " + elemento + " Quantidade: " + quantidade + "\n";
    }
}
