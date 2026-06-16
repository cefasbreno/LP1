package org.example.model;

public class Personagens {
    private int id;
    private String barbeiro;
    private String cliente;

    public Personagens(int id, String barbeiro, String cliente) {
        this.id = id;
        this.barbeiro = barbeiro;
        this.cliente = cliente;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getBarbeiro() { return barbeiro; }
    public void setBarbeiro(String barbeiro) { this.barbeiro = barbeiro; }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }
}