package utilities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class handleErrors {

    public static String nonEmptyStringInputHandler() {
        Scanner sc = ScannerUtil.scanner();
        String answer = sc.nextLine();
        while (answer.isEmpty()) {
            System.out.println("Input should be non-empty string. Please enter a non-empty string");
            answer = sc.nextLine();
        }
        return answer;
    }

    public static int integerInputHandler(int rangeMin, int rangeMax) {
        Scanner sc = ScannerUtil.scanner();
        int answer = -1;
        while (answer < 0 || answer > rangeMax || answer < rangeMin) {
            try {
                answer = sc.nextInt();
                if (answer < 0) {
                    throw new InputMismatchException();
                }
                if (answer > rangeMax || answer < rangeMin) {
                    throw new InputOutOfRangeException("Input out of range.");
                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Input should not be a negative integer. Try again.");
            } catch (InputOutOfRangeException e) {
                System.out.println(e.getMessage());
                System.out.println("Please enter a number between " + rangeMin + " and " + rangeMax);
            } catch (Exception e) {
                System.out.println("An error occurred. Please try again.");
            } finally {
                sc.nextLine();
            }
        }
        return answer;
    }

}

class InputOutOfRangeException extends RuntimeException {
    public InputOutOfRangeException() {}

    public InputOutOfRangeException(String message) {
        super(message);
    }
}
