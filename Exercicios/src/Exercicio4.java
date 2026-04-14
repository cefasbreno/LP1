public class Exercicio4 {

    public static void main (String[]args) {

        // Na empresa em que trabalhamos, há tabelas com o gasto de cada mês. Para fechar o balanço do primeiro trimestre, precisamos somar o gasto total.
        // Sabendo que, em janeiro, foram gastos 15 mil reais, em fevereiro, 23 mil reais e, em março, 17 mil reais,
        // faça um programa que calcule e imprima a despesa total no trimestre e a média mensal de gastos.

        int jan = 15000;
        int fev = 23000;
        int mar = 17000;
        double gasto = jan+fev+mar;
        double media = gasto/3;

        System.out.printf("O gasto total do primeiro trimestre foi de: R$%.2f ", gasto);
        System.out.printf("\nA media mensal dos gastos no primeiro trimestre foi de: R$%.2f ", media);

    }
}
