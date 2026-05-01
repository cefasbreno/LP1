public class Produtos {

    private String nome;
    private double valor;
    private int quantidade;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void calcularVenda(Funcionarios func) {
        System.out.println("O funcionário de registro " + func.getRegistro() + " está passando os produtos no caixa...");
        System.out.println("A venda foi de " + quantidade + " unidades de " + nome + " com valor de " + valor + "R$, " + "totalizando " + (quantidade * valor) + "R$");
        System.out.println(" ");
    }

    public void embalarProdutos (Funcionarios func) {
        System.out.println("O " + func.getFuncao() + " coloca os produtos na sacola e entrega ao cliente.");
        System.out.println("A não! A sacola estava furada e os " + quantidade + " " + nome + "s caem no chão!");
        System.out.println(" ");
    }

    public void pegarProdutos (Funcionarios func) {
        System.out.println("O aprendiz vê a situação e rapidamente ajuda " + func.getNome() + " a pegar os produtos!");
        System.out.println("O cliente fica encantado com a agilidade do aprendiz e o parabeniza pela boa ação.");
        System.out.println(" ");
    }

}
