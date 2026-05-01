public class Farmacia {

    public static void main (String[]args) {

        Funcionarios func = new Funcionarios();
        Produtos prod = new Produtos();

        func.setNome("Jooj da Silva");
        func.setFuncao("gerente operacional");
        func.setRegistro(1);

        prod.setNome("dipirona");
        prod.setValor(3);
        prod.setQuantidade(20);

        func.clienteNovo();
        func.efetuarVenda();
        prod.calcularVenda(func);
        prod.embalarProdutos(func);
        prod.pegarProdutos(func);
        func.anotarVenda();

    }

}
