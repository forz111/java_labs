package lab1.task4;

import java.util.Scanner;

public class LogisticMaximin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int roadCount = scanner.nextInt();

        int bestRoad = -1;
        int maxHeight = -1;

        for (int i = 1; i <= roadCount; i++) {
            int tunnelCount = scanner.nextInt();
            int minHeight = Integer.MAX_VALUE;

            for (int j = 0; j < tunnelCount; j++) {
                int height = scanner.nextInt();
                if (height < minHeight) {
                    minHeight = height;
                }
            }

            if (minHeight > maxHeight) {
                maxHeight = minHeight;
                bestRoad = i;
            }
        }

        System.out.println(bestRoad);
        System.out.println(maxHeight);
    }
}