import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число N (>2):");
        int n = scanner.nextInt();

        int[] fib = new int[n];
        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 2] + fib[i - 1];
        }

        System.out.println(("Первые " + n + " чисел Фибоначчи:"));
        for (int i = 0; i < n; i++) {
            System.out.println(fib[i]);
        }
    }
}
