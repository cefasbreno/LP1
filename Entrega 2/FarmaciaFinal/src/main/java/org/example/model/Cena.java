package org.example.model;

public class Cena {
    private int id;
    private String imagem;
    private String cenario;
    private String texto;
    private int personagens;

    public Cena() {
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getImagem() { return imagem; }
    public void setImagem(String imagem) { this.imagem = imagem; }

    public String getCenario() { return cenario; }
    public void setCenario(String cenario) { this.cenario = cenario; }

    public String getTexto() { return texto; }
    public void setTexto(String texto) { this.texto = texto; }

    public int getPersonagens() { return personagens; }
    public void setPersonagens(int personagens) { this.personagens = personagens; }

}