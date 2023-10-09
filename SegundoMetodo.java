package MergeSort;

import java.util.Arrays;

/**
 Trabalho Complexidade de Algoritmos
 Objetivo: Desenvolver o metodo de ordenação de vetores Merge Sort
 @author Larissa Cardoso
 @author Marcos Santana
 */

public class SegundoMetodo {
    public static void main(String[] args) {
        // o merge sort não verifica se o vetor está organizado, ele irá fazer o seu processo de ordenação
        // vetor que será ordenado
        int[] vetor = {4, 5, 9, 1, 2, 8, 3, 6, 7};
        // vamos criar um vetor auxiliar que ira ajudar nas comparações, quando for preciso, ele será vazio e terá o tamanho do vetor que vamos ordenar
        int[] auxiliar = new int[vetor.length];

        // o mergeSort receberá o vetor, o auxiliar, 0 que representa a posicao inicial, e o vetor.length-1 que reprenseta a posicao final
        mergeSort(vetor, auxiliar, 0, vetor.length-1);

        System.out.println(Arrays.toString(vetor));

    }

    private static void mergeSort(int[] vetor, int[] auxiliar, int inicio, int fim) {

        if (inicio < fim) {
            int meio = (inicio + fim)/2;
            mergeSort(vetor, auxiliar, inicio, meio); // pega a parte da esquerda
            mergeSort(vetor, auxiliar, meio+1, fim); // pega a parte da direita
            intercalar(vetor, auxiliar, inicio, meio, fim); // junta os elementos do vetor, comparando os valores
        }
    }

    private static void intercalar(int[] vetor, int[] auxiliar, int inicio, int meio, int fim) {
        // vamos popular o vetor auxiliar com todos os elementos do vetor principal
        for (int i = inicio; i <= fim; i++) {
            auxiliar[i] = vetor[i];
        }

        // criaremos dois indices para poder trabalhar dentro do vetor auxiliar com as duas partes da esquerda e da direita

        int esquerda = inicio;
        int direita = meio+1;

        for (int i= inicio; i<=fim; i++) {
            if (esquerda > meio) {
              vetor[i] = auxiliar[direita++];
            } else if (direita > fim) {
                vetor[i] = auxiliar[esquerda++];
            } else if (auxiliar[esquerda] > auxiliar[direita]) { // se nessa condiçao for condicionado auxiliar[esquerda] > auxiliar[direita], o metodo sai em ordem decrescente
                vetor[i] = auxiliar[esquerda++];
            } else {
                vetor[i] = auxiliar[direita++];
            }
        }

    }
}
