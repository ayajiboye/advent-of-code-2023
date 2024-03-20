import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D1P1 {
    public static void main(String[] args) {
        File inputFile = new File("D1Input.txt");
        try {
            Scanner scanner = new Scanner(inputFile);
            int totalSum = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

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

            System.out.println("The sum of two-digit numbers formed from each line is " + totalSum + ".");
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: The input file 'input.txt' was not found.");
        }
    }
}
