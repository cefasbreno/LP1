public class Funcionarios {

    private String nome;
    private String funcao;
    private int registro;

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    public void setRegistro(int registro) {
        this.registro = registro;
    }
    public String getNome() {
        return nome;
    }
    public String getFuncao() {
        return funcao;
    }
    public int getRegistro() {
        return registro;
    }

    public void clienteNovo() {
        System.out.println("Um cliente entrou na loja.");
        System.out.println("Ele chama um funcionário.");
        System.out.println(" ");
    }

    public void efetuarVenda() {
        System.out.println("O " + funcao + " " + nome + " está atendendo o cliente...");
        System.out.println("Ele efetuou uma venda!");
        System.out.println(" ");
    }

    public void anotarVenda() {
        System.out.println(nome + " está anotando a venda que acabou de fazer no quadro de vendas...");
        System.out.println("Mais um ponto para o registro " + registro + ", certamente ganhará o prêmio ao final do mês!");
        System.out.println(" ");
    }
}
