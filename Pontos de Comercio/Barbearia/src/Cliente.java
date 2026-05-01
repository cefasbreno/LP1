public class Cliente {

    private String nome;
    private int horario;
    private String corte;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public void setCorte(String corte) {
        this.corte = corte;
    }

    public String getNome() {
        return nome;
    }

    public double getHorario() {
        return horario;
    }

    public String getCorte() {
        return corte;
    }

    public void fazerCadastro() {
        System.out.println("O cliente " + nome + " está fazendo o cadastro na plataforma.");
        System.out.println("Na plataforma, ele seleciona o nível de barbeiro desejado, escolhe seu tipo de corte e especifica preferências.");
        System.out.println(" ");
    }

    public void marcarHorario(Barbeiro barbeiro) {
        System.out.println("O cliente agora está selecionando um horário para cortar o cabelo...");

        if (horario >= 12 && horario < 18) {
            System.out.println("Feito! Ele escolhe cortar o cabelo às " + horario + ":00 da tarde com o barbeiro " + barbeiro.getNome() + ".");
        }
     else if (horario >= 18) {
            System.out.println("Feito! Ele escolhe cortar o cabelo às " + horario + ":00 da noite com o barbeiro " + barbeiro.getNome() + ".");
        } else {
            System.out.println("Feito! Ele escolhe cortar o cabelo às " + horario + ":00 da manhã com o barbeiro " + barbeiro.getNome() + ".");
        }
    }

    public void notificarBarbeiro(Barbeiro barbeiro) {
        System.out.println(" ");
        System.out.println("Chega a notificação ao barbeiro " + barbeiro.getNome() + ":");
        System.out.println("O cliente " + nome + " marcou um horário às " + horario + ":00.");
        System.out.println("Tipo de corte: " + corte + ".");
        System.out.println(" ");
    }

}
