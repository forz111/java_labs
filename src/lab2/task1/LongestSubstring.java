package lab2.task1;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        System.out.println("Наибольшая подстрока: " + longestUniqueSubstring(input));
    }

    public static String longestUniqueSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        int resultStart = 0;

        for (int end = 0; end < s.length(); end++) {
            char current = s.charAt(end);
            if (map.containsKey(current)) {
                start = Math.max(start, map.get(current) + 1);
            }
            map.put(current, end);
            if (end - start + 1 > maxLength) {
                maxLength = end - start + 1;
                resultStart = start;
            }
        }
        return s.substring(resultStart, resultStart + maxLength);
    }
}