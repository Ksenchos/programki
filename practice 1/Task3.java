import java.util.Scanner;
 
public class Task3 {
    public static double findMax(double a, double b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static boolean areEqual(double a, double b) {
        return a == b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        System.out.print("Введите первое число: ");
        double a = scanner.nextDouble();
 
        System.out.print("Введите второе число: ");
        double b = scanner.nextDouble();
 
        if (a > b) {
            System.out.println("Большее число: " + a);
        } else if (b > a) {
            System.out.println("Большее число: " + b);
        } else {
            System.out.println("Числа равны: " + a);
        }
    }
}
