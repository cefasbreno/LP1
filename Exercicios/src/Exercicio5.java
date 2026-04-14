import static java.util.Collections.max;

public class Exercicio5 {

    public static void main(String[] args) {

        // Programa que leia as notas e calcule a média de LP1 deste semestre, referente a um determinado aluno.
        // max(((P1*0.5+E1*0.2+E2*0.3+X+SUB*0.15)*0.5) + (max(P1*0.5+E1*0.2+E2*0.3+X+(SUB*0.15)-5.9, 0) / (P1*0.5+E1*0.2+E2*0.3+X+(SUB*0.15)-5.9))*API*0.5, EXF)

        double P1 = 7;
        double E1 = 3;
        double E2 = 4;
        double X = 2;
        double SUB = 7;
        double API = 8;
        double EXF = 7;
        double media;

        // Calcula média das entregas
        double entregas = (P1 * 0.5) + (E1 * 0.2) + (E2 * 0.3) + X;

        // Verifica se a média das entregas ativa ou não o acréscimo da API
        if (entregas <= 5.9) {
            API = 0;
            System.out.println("A nota final das entregas P1, E1, E2 e X é de: " + entregas);
            media = (entregas * 0.5) + (API * 0.5);
            System.out.println("A media final, sem o acréscimo da API é: " + media);
            System.out.println("Nesse caso, é ativada a nota do exame final, com valor de: " + EXF);
        } else {
            System.out.println("A nota final das entregas P1, E1, E2 e X é de: " + entregas + ", ativando o acréscimo da API.");
            media = (entregas * 0.5) + (API * 0.5);
            System.out.println("A media final, com o acréscimo da API é: " + media);
        }

    }
}
