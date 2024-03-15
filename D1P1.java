import java.util.Scanner;

public class D1P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Paste input, type 'done' on a new line, then return.\n");

        int totalSum = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("done")) {
                break;
            }

            int firstNumber = -1;
            int lastNumber = -1;
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (Character.isDigit(c)) {
                    int num = Character.getNumericValue(c);
                    if (firstNumber == -1) {
                        firstNumber = num;
                    }
                    lastNumber = num;
                }
            }

            if (firstNumber != -1 && lastNumber != -1) {
                int twoDigitNumber = firstNumber * 10 + lastNumber;
                totalSum += twoDigitNumber;
            }
        }

        System.out.println("\nThe sum of two-digit numbers formed from each line is " + totalSum + ".");
        scanner.close();
    }
}