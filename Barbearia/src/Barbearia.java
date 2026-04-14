public class Barbearia {

    public static void main (String[]args) {

        Barbeiro barbeiro = new Barbeiro();
        Cliente cliente = new Cliente();

        barbeiro.setNome("Roberval");
        barbeiro.setDuracao(1);
        barbeiro.setEspecialidade("degradê");

        cliente.setNome("Bruno");
        cliente.setHorario(9);
        cliente.setCorte("degradê");

        cliente.fazerCadastro();
        cliente.marcarHorario(barbeiro);
        cliente.notificarBarbeiro(barbeiro);
        barbeiro.atenderCliente(cliente);
        barbeiro.cortarCabelo(cliente);
        barbeiro.receberPagamento(cliente);

    }
}
