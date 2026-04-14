public class Mesa {

private String categoria;
private int capacidade;
private int numero;

    public void setCategoria(String categoria) {
    this.categoria = categoria;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return categoria;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getNumero() {
        return numero;
    }

    public void montarMesas() {
        System.out.println("Os funcionários chegam cedo à feira e começam a montar a barraca");
        System.out.println("Eles montam 3 mesas, uma de cada categoria.");
        System.out.println("Mesa 1 - frutas grandes\nMesa 2 - frutas médias\nMesa 3 - frutas pequenas");
        System.out.println(" ");
    }

    public void arrumarMesa(Frutas frutas) {
        System.out.println("Para manter o controle das frutas, o chefe anota na planilha uma adição de " + frutas.getEmbalagem() + " frutas genéricas da categoria " + categoria + ".");
        System.out.println("Depois de rearranjada a mesa a barraca começa a vender seus produtos");
        System.out.println(" ");
    }

    public void quebrarMesa(Frutas frutas) {
        System.out.println("Parece que o peso a mais de " + frutas.getQuantidade() + " " + frutas.getFruta() + "s gerou uma fadiga excessiva na mesa de frutas grandes e ela cedeu...");
        System.out.println("Que prejuízo! Todas as futas da mesa " + categoria + " caíram no chão!");
        System.out.println("Os funcionários da barraca contornaram a situação, vendendo as frutas no chão, mas o dinheiro extra das " + frutas.getFruta() + "s ficou para o conserto dela mesma.");
    }











}
