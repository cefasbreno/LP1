public class Barraca {

    public static void main (String[]args) {

    Mesa mesa = new Mesa();
    Frutas frutas = new Frutas();

    mesa.setCategoria("grande");
    mesa.setCapacidade(24);
    mesa.setNumero(1);

    frutas.setFruta("laranja");
    frutas.setQuantidade(36);
    frutas.setEmbalagem(0);

    mesa.montarMesas();
    frutas.colocarFrutas();
    frutas.erroCalculo();
    frutas.embalarFrutas(mesa);
    mesa.arrumarMesa(frutas);
    mesa.quebrarMesa(frutas);





    }
}
