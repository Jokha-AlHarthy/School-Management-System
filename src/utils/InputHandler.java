package utils;

import java.util.Scanner;

public class InputHandler {
    private static final Scanner sc = new Scanner(System.in);
    //A Scanner-based class. Overloaded read methods - text
    public static String readText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String text = sc.nextLine().trim();
            if (!HelperUtils.isEmpty(text)) return text;
            System.out.println("Input cannot be empty. Try again.");
        }
    }

    //A Scanner-based class. Overloaded read methods - number
    public static int readInt(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(readText(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Invalid number.. Please enter again");
            }
        }
    }

    //A Scanner-based class. Overloaded read methods - decimal number
    public static double readDouble(String prompt) {
        while (true) {
            try {
                return Double.parseDouble(readText(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Invalid number.. Please enter again");
            }
        }
    }

}
