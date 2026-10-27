import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        System.out.println("Здравствуйте");
        System.out.println("Эта программа вычисляет среднюю скорость движения объекта");
        System.out.println("Формула: Скорость = Расстояние / Время\n");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите пройденное расстояние (в метрах):");
        double distance = scanner.nextDouble();

        System.out.println("Введите затраченное время (в секундах):");
        double time = scanner.nextDouble();

        if (distance < 0 || time <= 0) {
            System.out.println("Ошибка! Расстояние не может быть отрицательным, а время должно быть строго больше нуля");
            return;
        }

        double speed = Math.round((distance / time) * 100.0) / 100.0;

        System.out.println("Результаты расчетов");
        System.out.println("Скорость объекта равна: " + speed + " м/с");
    }
}
