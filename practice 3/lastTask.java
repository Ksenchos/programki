import java.util.Scanner;
import java.util.InputMismatchException;

public class Task {
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
        scanner.close();
    }

    static void showMenu() {
        System.out.println("\nГлавное меню");
        System.out.println("1. Выполнить расчёт скорости");
        System.out.println("2. Информация о программе");
        System.out.println("3. Информация о разработчике");
        System.out.println("4. Выход");
        System.out.print("Введите номер: ");
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

        System.out.print("Введите количество объектов: ");
        int count = scanner.nextInt();

        double[] distances = inputDistances(count);
        double[] times = inputTimes(count);
        double[] speeds = calculateSpeeds(distances, times);
        printResults(distances, times, speeds);
    }

    static double[] inputDistances(int count) {
        double[] distances = new double[count];
        System.out.println("Введите расстояния (в метрах):");
        for (int i = 0; i < count; i++) {
            distances[i] = getValidDouble("Объект " + (i + 1) + ": ", false);
        }
        return distances;
    }

    static double[] inputTimes(int count) {
        double[] times = new double[count];
        System.out.println("Введите время (в секундах):");
        for (int i = 0; i < count; i++) {
            times[i] = getValidDouble("Объект " + (i + 1) + ": ", true);
        }
        return times;
    }

    static double[] calculateSpeeds(double[] distances, double[] times) {
        double[] speeds = new double[distances.length];
        for (int i = 0; i < distances.length; i++) {
            speeds[i] = Math.round((distances[i] / times[i]) * 100.0) / 100.0;
        }
        return speeds;
    }

    static void printResults(double[] distances, double[] times, double[] speeds) {
        System.out.println("\nРезультаты расчёта:");
        for (int i = 0; i < distances.length; i++) {
            System.out.println("Объект " + (i + 1) + ": Расстояние = " + distances[i] + " м, Время = " + times[i] + " с, Скорость = " + speeds[i] + " м/с");
        }
    }

    static double getValidDouble(String prompt, boolean strictlyPositive) {
        while (true) {
            System.out.print(prompt);
            try {
                double value = scanner.nextDouble();
                if (strictlyPositive && value <= 0) {
                    System.out.println("Ошибка! Число должно быть строго больше нуля.");
                } else if (!strictlyPositive && value < 0) {
                    System.out.println("Ошибка! Число не может быть отрицательным.");
                } else {
                    return value;
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
        System.out.println("Версия: 2.0 (с использованием массивов)");
    }

    static void showDeveloperInfo() {
        System.out.println("\nО разработчике");
        System.out.println("ФИО: Яганова Ксения Владимировна");
        System.out.println("Группа: РИ-250931");
    }
}
