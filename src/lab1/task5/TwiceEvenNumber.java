package lab1.task5;

import java.util.Scanner;

public class TwiceEvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        int hundreds = number / 100;
        int tens = (number / 10) % 10;
        int units = number % 10;

        int sum = hundreds + tens + units;
        int product = hundreds * tens * units;

        if (sum % 2 == 0 && product % 2 == 0) {
            System.out.println("Число является дважды четным.");
        } else {
            System.out.println("Число не является дважды четным.");
        }
    }
}