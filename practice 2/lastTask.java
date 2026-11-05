import java.util.Scanner;
import java.util.InputMismatchException;

public class lastTask {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean isRunning = true;

        while (isRunning) {
            showMenu();
            int choice = getValidMenuChoice();

            switch (choice) {
                case 1:
                    calculateSpeed();
                    break;
                case 2:
                    showProgramInfo();
                    break;
                case 3:
                    showDeveloperInfo();
                    break;
                case 4:
                    System.out.println("Программа завершена");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Неверный пункт меню. Попробуйте снова.");
            }
        }
    }
    static void showMenu() {
        System.out.println("\nГлавное меню");
        System.out.println("1. Выполнить расчёт скорости");
        System.out.println("2. Информация о программе");
        System.out.println("3. Информация о разработчике");
        System.out.println("4. Выход");
        System.out.println("Введите номер:");
    }

    static int getValidMenuChoice() {
        while (true) {
            try {
                int choice = scanner.nextInt();
                if (choice >= 1 && choice <= 4) {
                    return choice;
                } else {
                    System.out.print("Введите число от 1 до 4: ");
                }
            } catch (InputMismatchException e) {
                System.out.print("Ошибка! Введите число от 1 до 4: ");
                scanner.nextLine();
            }
        }
    }

    static void calculateSpeed() {
        System.out.println("\nРасчет средней скорости");
        System.out.println("Формула: Скорость = Расстояние / Время");

        double distance = getValidPositiveDouble("Введите расстояние (в метрах): ");
        double time = getValidStrictlyPositiveDouble("Введите время (в секундах): ");

        double speed = Math.round((distance / time) * 100.0) / 100.0;

        System.out.println("\nРезультаты расчёта:");
        System.out.println("Скорость: " + speed + " м/с");
    }

    static double getValidPositiveDouble(String prompt) {
        double value;
        while (true) {
            System.out.print(prompt);
            try {
                value = scanner.nextDouble();
                if (value >= 0) {
                    return value;
                } else {
                    System.out.println("Ошибка! Число не может быть отрицательным");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка! Введите корректное число");
                scanner.nextLine();
            }
        }
    }

    static double getValidStrictlyPositiveDouble(String prompt) {
        double value;
        while (true) {
            System.out.print(prompt);
            try {
                value = scanner.nextDouble();
                if (value > 0) {
                    return value;
                } else {
                    System.out.println("Ошибка! Число должно быть больше нуля.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка! Введите корректное число.");
                scanner.nextLine();
            }
        }
    }

    static void showProgramInfo() {
        System.out.println("\nО программе");
        System.out.println("Программа вычисляет среднюю скорость движения объекта.");
        System.out.println("Формула: v = S / t");
    }

    static void showDeveloperInfo() {
        System.out.println("\nО разработчике");
        System.out.println("ФИО: Яганова Ксения Владимировна");
        System.out.println("Группа: РИ-250931");
    }
}
