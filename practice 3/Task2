import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите размер массива N:");
        int n = scanner.nextInt();

        int[] array = new int[n];

        System.out.println("Введите " + n + " элементов массива:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        
        for (int i = 0;  i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[j] == array[i]) {
                    System.out.println("Повторяющийся элемент: " + array[i]);
                }
            }
        }
    }
}
