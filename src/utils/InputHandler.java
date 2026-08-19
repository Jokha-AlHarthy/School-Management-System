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

    //A Scanner-based class. Overloaded read methods - range
    public static int readInt(String prompt, int min, int max) {
        while (true) {
            int val = readInt(prompt);
            if (HelperUtils.isInRange(val, min, max)) return val;
            System.out.println("The range must be between " + min + " and " + max);
        }
    }

    //A Scanner-based class. Overloaded read methods - range double
    public static double readDouble(String prompt, double min, double max) {
        while (true) {
            double val = readDouble(prompt);
            if (HelperUtils.isInRange(val, min, max)) return val;
            System.out.println("The range must be between " + min + " and " + max);
        }
    }

    //A Scanner-based class. Overloaded read methods -  confirmation
    public static boolean readConfirmation(String prompt) {
        while (true) {
            String input = readText(prompt + " (y/n): ").toLowerCase();
            if (input.equals("y") || input.equals("yes")) return true;
            if (input.equals("n") || input.equals("no")) return false;
            System.out.println("Please enter the following 'y' or 'n'.");
        }
    }

    //A Scanner-based class. Overloaded read methods - oneOf
    public static String readOneOf(String prompt, String[] allowed) {
        while (true) {
            String input = readText(prompt);
            if (HelperUtils.isOneOf(input, allowed)) return input;
            System.out.println("Invalid choice, the allowed values are: " + String.join(", ", allowed));
        }
    }
}
