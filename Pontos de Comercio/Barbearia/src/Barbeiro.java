public class Barbeiro {

    private String nome;
    private int duracao;
    private String especialidade;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void atenderCliente(Cliente cliente) {
        System.out.println("O barbeiro atende à notificação e confirma o agendamento.");
        System.out.println("O tempo passou...");
        System.out.println(nome + " recebe o cliente no horário combinado e prepara-se para cortar o cabelo.");
        System.out.println(" ");
    }

    public void cortarCabelo(Cliente cliente) {
        System.out.println("O cliente " + cliente.getNome() + " pede o corte no estilo " + cliente.getCorte() + ", justamente a especialidade do barbeiro.");
        System.out.println(nome + " é tão experiente no corte " + especialidade + " que é sempre recomendado pela plataforma.");
        duracao += cliente.getHorario();
        System.out.println("O barbeiro começa a cortar o cabelo e termina o serviço às " + duracao + ":00.");
        System.out.println(" ");
    }

    public void receberPagamento(Cliente cliente) {
        System.out.println(cliente.getNome() + " analisa o resultado final e aprova, partindo para o pagamento.");
        System.out.println(nome + " recebe o pagamento no caixa e devolve o troco ao cliente.");
        System.out.println("O cliente ficou tão satisfeito com o corte que deixou o troco de gorjeta e avaliou o barbeiro em 5 estrelas na plataforma.");
        System.out.println(" ");
    }

}
