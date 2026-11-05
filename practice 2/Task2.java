import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите вещественное число X (|X| < 1):");
        double x = scanner.nextDouble();

        System.out.println("Введите целое число N (> 0):");
        int n = scanner.nextInt();

        double sum = 0;
        int sign = 1;
        for (int k = 0; k <= n; k ++) {
            int power = 2 * k + 1;

            double term = sign * Math.pow(x, power) / power;
            sum += term;
            sign *= -1;
        }
        System.out.println("arctan(" + x + ") ≈ " + sum);
    }
}
