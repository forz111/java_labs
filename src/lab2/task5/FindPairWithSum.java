package lab2.task5;

import java.util.HashSet;
import java.util.Scanner;

public class FindPairWithSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();
        int[] nums = new int[size];
        System.out.print("Введите элементы массива: ");
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.print("Введите target: ");
        int target = scanner.nextInt();
        int[] result = findPair(nums, target);
        if (result != null) {
            System.out.println("Пара: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("Пара не найдена.");
        }
    }

    public static int[] findPair(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(target - num)) {
                return new int[]{num, target - num};
            }
            set.add(num);
        }
        return null;
    }
}