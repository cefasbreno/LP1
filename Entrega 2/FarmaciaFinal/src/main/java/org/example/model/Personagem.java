package org.example.model;

public class Personagem {
    private int id;
    private String farmaceutico;
    private String aprendiz;
    private String cliente;


    public Personagem(int id, String farmaceutico, String aprendiz, String cliente) {
        this.id = id;
        this.farmaceutico = farmaceutico;
        this.aprendiz = aprendiz;
        this.cliente = cliente;
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFarmaceutico() { return farmaceutico; }
    public void setFarmaceutico(String farmaceutico) { this.farmaceutico = farmaceutico; }

    public String getAprendiz() { return aprendiz; }
    public void setAprendiz(String aprendiz) { this.aprendiz = aprendiz; }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }
}