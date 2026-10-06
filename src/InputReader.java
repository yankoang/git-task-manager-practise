import java.util.Scanner;

public class InputReader {

    public static Integer readInt(Scanner scanner, String prompt) {
        System.out.print(prompt);

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input format. Please enter a number.");
            scanner.nextLine();
            return null;
        }

        int value = scanner.nextInt();
        scanner.nextLine();

        return value;
    }

}
