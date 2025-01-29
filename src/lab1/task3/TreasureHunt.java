package lab1.task3;

import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int targetX = scanner.nextInt();
        int targetY = scanner.nextInt();

        int currentX = 0;
        int currentY = 0;

        int stepsCount = 0;
        boolean treasureFound = false;

        while (true) {
            String direction = scanner.next();
            if (direction.equals("стоп")) {
                break;
            }

            int steps = scanner.nextInt();

            if (!treasureFound) {

                switch (direction) {
                    case "север":
                        currentY += steps;
                        break;
                    case "юг":
                        currentY -= steps;
                        break;
                    case "восток":
                        currentX += steps;
                        break;
                    case "запад":
                        currentX -= steps;
                        break;
                }
                stepsCount++;

                if (currentX == targetX && currentY == targetY) {
                    treasureFound = true;
                }
            }
        }

        System.out.println(stepsCount);
    }
}