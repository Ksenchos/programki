import java.util.Scanner;
import java.util.Arrays;

public class Task3 {
    public static double[] createArraysB(double[] a) {
        int n = a.length;
        double[] b = new double[n];
        double sum = 0;

        for (int k = 0; k < n; k++) {
            sum += a[k];
            b[k] = sum / (k + 1);
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите размер массива N:");
        int n = scanner.nextInt();

        double[] a = new double[n];
        System.out.println("Введите " + n + " элементов массива А");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextDouble();
        }

        double[] b = createArraysB(a);

        System.out.println("Массив А: " + Arrays.toString(a));
        System.out.println("Массив В: " + Arrays.toString(b));
    }
}
