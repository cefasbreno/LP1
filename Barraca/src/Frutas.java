public class Frutas {

    private String fruta;
    private int quantidade;
    private int embalagem;

    public void setFruta(String fruta) {
        this.fruta = fruta;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setEmbalagem(int embalagem) {
        this.embalagem = quantidade/12;
    }

    public String getFruta() {
        return fruta;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getEmbalagem() {
        return embalagem;
    }

    public void colocarFrutas() {
        System.out.println("Os funcionários separam as frutas pelas categorias e colocam em suas respectivas mesas");
        System.out.println("A distribuição ficou assim:");
        System.out.println("Mesa 1 - melancia, jaca e melão\nMesa 2 - maracujá, abacaxi e abacate\nMesa 3 - laranja, limão e maçã");
        System.out.println(" ");
    }

    public void erroCalculo() {
        System.out.println("Houve um erro de cálculo e parece que vieram " + fruta + "s a mais!");
        System.out.println("Realmente! vieram " + quantidade + " " + fruta + "s a mais, e os funcionários começam a discutir...");
        System.out.println("O chefe resolve a discussão com a ideia de colocar algumas frutas na bancada de frutas maiores.");
        System.out.println(" ");
    }

    public void embalarFrutas(Mesa mesa) {
        System.out.println("Ele decide então por colocar 12 unidades de " + fruta + " em sacos para igualar com uma fruta grande e colocar na mesa " + mesa.getNumero() + ".");
        System.out.println("As " + quantidade + " " + fruta + "s excedentes são colocadas em " + embalagem + " sacos.");
        System.out.println(" ");
    }









}