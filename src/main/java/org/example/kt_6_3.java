package org.example;

import java.util.Scanner;

public class kt_6_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Valige teisendustüüp: 'd' - kahendsüsteemist kümnendsüsteemi, 'b' - kümnendsüsteemist kahendsüsteemi, 'v' - välju");
            String choice = scanner.nextLine();

            if (choice.equals("d")) {
                System.out.println("Sisestage kahendsüsteemi arv:");
                String binaryNumber = scanner.nextLine();
                int decimalNumber = binaryToDecimal(binaryNumber);
                System.out.println("Kümnendsüsteemi arv: " + decimalNumber);
            } else if (choice.equals("b")) {
                System.out.println("Sisestage kümnendsüsteemi arv:");
                int decimalNumber = scanner.nextInt();
                String binaryNumber = decimalToBinary(decimalNumber);
                System.out.println("Kahendsüsteemi arv: " + binaryNumber);
                scanner.nextLine(); // Consume newline character
            } else if (choice.equals("v")) {
                break;
            } else {
                System.out.println("Vale käsk! Palun valige 'd', 'b' või 'v'");
            }
        }
    }

    public static int binaryToDecimal(String binaryNumber) {
        int decimalNumber = 0;
        int power = 0;

        boolean isNegative = binaryNumber.charAt(0) == '-';

        for (int i = binaryNumber.length() - 1; i >= (isNegative ? 1 : 0); i--) {
            int digit = Character.getNumericValue(binaryNumber.charAt(i));
            decimalNumber += digit * Math.pow(2, power);
            power++;
        }

        return isNegative ? -decimalNumber : decimalNumber;
    }

    public static String decimalToBinary(int decimalNumber) {
        StringBuilder binaryNumber = new StringBuilder();

        if (decimalNumber < 0) {
            int positiveDecimalNumber = Math.abs(decimalNumber);

            while (positiveDecimalNumber > 0) {
                int remainder = positiveDecimalNumber % 2;
                binaryNumber.insert(0, remainder); // Lisame jäägi stringi algusesse
                positiveDecimalNumber /= 2;
            }
            binaryNumber.insert(0, "-"); // Lisame miinusmärgi stringi algusesse
        } else {
            while (decimalNumber > 0) {
                int remainder = decimalNumber % 2;
                binaryNumber.insert(0, remainder); // Lisame jäägi stringi algusesse
                decimalNumber /= 2;
            }
        }

        return binaryNumber.toString();
    }
}
