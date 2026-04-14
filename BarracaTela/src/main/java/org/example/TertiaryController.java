package org.example;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import java.io.IOException;

public class TertiaryController {

    @FXML
    private Text texto;

    private int passo = 0;

    private final String[] frases = {
            "Os funcionários chegam cedo à feira e começam a montar a barraca.",
            "Eles montam 3 mesas, uma de cada categoria: Grandes, Médias e Pequenas.",
            "Os funcionários separam as frutas e a distribuição ficou assim:\nMesa 1: Melancia, jaca e melão.\nMesa 2: Maracujá, abacaxi e abacate.\nMesa 3: Laranja, limão e maçã.",
            "Houve um erro de cálculo e parece que vieram laranjas a mais!",
            "Realmente! vieram 36 laranjas a mais, e os funcionários começam a discutir...",
            "O chefe resolve a discussão com a ideia de colocar algumas frutas na bancada de frutas maiores.",
            "Ele decide então colocar 12 unidades de laranja em sacos para igualar com uma fruta grande e colocar na mesa 1.",
            "As 36 laranjas excedentes são colocadas em 3 sacos.",
            "Para manter o controle das frutas, o chefe anota na planilha uma adição de 3 frutas genéricas da categoria grande.",
            "Depois de rearranjada a mesa, a barraca começa a vender seus produtos.",
            "Parece que o peso a mais de 36 laranjas gerou uma fadiga excessiva na mesa de frutas grandes e ela cedeu...",
            "Que prejuízo! Todas as frutas da mesa grande caíram no chão!",
            "Os funcionários contornaram a situação vendendo as frutas no chão, mas o dinheiro extra ficou para o conserto da mesa."
    };

    @FXML
    private void continuarHistoria() throws IOException {
        if (passo < frases.length) {
            texto.setText(frases[passo]);
            passo++;
        }
    }
}