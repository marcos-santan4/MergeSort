package MergeSort;

import java.util.Arrays;

public class PrimeiroMetodo {
    public static void main(String[] args) {
        int[] v = {4, 6, 7, 3, 5, 1, 2, 8};
        int[] w = new int[v.length]; // vetor Auxiliar

        mergeSort(v, w, 0, v.length-1);

        System.out.println(Arrays.toString(v));
    }

    public static void mergeSort(int[] v, int[] w, int inicio, int fim) {
        if (inicio < fim) { // enquanto o inicio for menor que o fim
            int meio = (inicio + fim) / 2; // calcular o elemento do meio do vetor
            mergeSort(v, w, inicio, meio); // ordenar do inicio até o meio
            mergeSort(v, w, meio+1, fim); // ordernar do meio até o fim
            intercalar(v, w, inicio, meio, fim);
        }
    }

    public static void intercalar(int[] v, int[] w, int inicio, int meio, int fim) {
        // o metodo intercalar irá intercalar os subvetores em um subvetor final usando o w como auxiliar
        for (int k = inicio; k <= fim; k++)
            w[k] = v[k]; // vetor w fica como auxiliar

        int i = inicio;
        int j = meio + 1;

        for (int k = inicio; k <= fim; k++) {
            if (i > meio) v[k] = w[j++];
            else if (j > fim) v[k] = w[i++];
            else if (w[i] < w[j]) v[k] = w[i++];
            else v[k] = w[j++];
        }
    }

}
