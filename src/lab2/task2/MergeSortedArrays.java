package lab2.task2;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortedArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер первого массива: ");
        int[] arr1 = readArray(scanner);

        System.out.print("Введите размер второго массива: ");
        int[] arr2 = readArray(scanner);

        int[] merged = mergeSortedArrays(arr1, arr2);
        System.out.println("Результат: " + Arrays.toString(merged));
    }

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            result[k++] = (arr1[i] < arr2[j]) ? arr1[i++] : arr2[j++];
        }
        while (i < arr1.length) result[k++] = arr1[i++];
        while (j < arr2.length) result[k++] = arr2[j++];
        return result;
    }

    private static int[] readArray(Scanner scanner) {
        int size = scanner.nextInt();
        int[] arr = new int[size];
        System.out.print("Введите элементы (отсортированные): ");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}