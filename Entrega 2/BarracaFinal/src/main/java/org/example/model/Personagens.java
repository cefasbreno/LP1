package org.example.model;

public class Personagens {
    private int id;
    private String dona;
    private String ajudante1;
    private String ajudante2;

    public Personagens(int id, String dona, String ajudante1, String ajudante2) {
        this.id = id;
        this.dona = dona;
        this.ajudante1 = ajudante1;
        this.ajudante2 = ajudante2;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDona() { return dona; }
    public void setDona(String dona) { this.dona = dona; }

    public String getAjudante1() { return ajudante1; }
    public void setAjudante1(String ajudante1) { this.ajudante1 = ajudante1; }

    public String getAjudante2() { return ajudante2; }
    public void setAjudante2(String ajudante2) { this.ajudante2 = ajudante2; }
}