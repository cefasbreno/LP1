package org.example.model;

public class Cena {
    private int id;
    private String imagem;
    private String cenario;
    private String texto;
    private int personagens; // Refere-se à contagem ou ID da tabela personagens_barraca

    // Construtor vazio para permitir inicialização via DAO ou instanciamento simples
    public Cena() {
    }

    // Construtor completo
    public Cena(int id, String imagem, String cenario, String texto, int personagens) {
        this.id = id;
        this.imagem = imagem;
        this.cenario = cenario;
        this.texto = texto;
        this.personagens = personagens;
    }

    // Getters e Setters
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