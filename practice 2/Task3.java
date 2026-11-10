import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите целое число N (> 0)");
        int n = scanner.nextInt();

        while (n > 0) {
            int lastDigit = n % 10;
            System.out.println(lastDigit);

            n = n / 10;
        }
    }
}
