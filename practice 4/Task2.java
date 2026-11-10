import java.util.Objects;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Developer dev = new Developer("Иванов Иван Иванович", 150000, 2020, "Высшее", "Java");
        Teacher teach = new Teacher("Петров Петр Петрович", 80000, 2015, "Высшее", "Программирование");
        Manager men = new Manager("Пупкин Василий Александрович", 100000, 2018, "MBA", "Отдел продаж");

        Employer[] staff = {dev, teach, men};

        System.out.println("Полиморфизм:");
        for (Employer employee: staff) {
            System.out.println(employee.getInfo());
            System.out.println("Бонус: " + employee.calculateBonus() + "руб.\n");
        }

        System.out.println("equals и hashCode:");
        Developer dev2 = new Developer("Иванов Иван Иванович", 150000, 2020, "Высшее", "Java");
        System.out.println("dev.equals(dev2): " + dev.equals(dev2));
        System.out.println("HashCode dev: " + dev.hashCode());
        System.out.println("HashCode dev2: " + dev2.hashCode());
    }
}

class Employer {
    private String fullName;
    private double salary;
    private int hireYear;
    private String education;

    public Employer(String fullName, double salary, int hireYear, String education) {
        this.fullName = fullName;
        this.salary = salary;
        this.hireYear = hireYear;
        this.education = education;
    }

    public String getFullName() { return fullName; }
    public double getSalary() { return salary; }
    public int getHireYear() { return hireYear; }
    public String getEducation() { return education; }

    public int calculateExperience() {
        return 2026 - hireYear;
    }

    public double calculateBonus() {
        return (salary * 0.1) + (calculateExperience() * 1000);
    }

    public String getInfo() {
        return "ФИО: " + fullName + ", Стаж: " + calculateExperience() + " лет";
    }

    public String toString() {
        return "Employer{" + "fullName='" + fullName + '\'' + ", salary=" + salary + ", hireYear=" + hireYear + ", education='" + education + '\'' + '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employer employer = (Employer) o;
        return Double.compare(employer.salary, salary) == 0 && hireYear == employer.hireYear && Objects.equals(fullName, employer.fullName) && Objects.hash(fullName, salary, hireYear, education);
    }

    public int hashCode() {
        return Objects.hash(fullName, salary, hireYear, education);
    }
}


class Developer extends Employer {
    private String programmingLanguage;

    public Developer(String fullName, double salary, int hireYear, String education, String programmingLanguage) {
        super(fullName, salary, hireYear, education);
        this.programmingLanguage = programmingLanguage;
    }

    public double calculateBonus() {
        return super.calculateBonus() + 5000;
    }

    public String toString() {
        return super.toString() + ", Developer{language='" + programmingLanguage + "'}";
    }
    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false; // Сначала проверяем поля родителя
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return Objects.equals(programmingLanguage, developer.programmingLanguage);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), programmingLanguage);
    }
}


class Teacher extends Employer {
    private String subject;

    public Teacher(String fullName, double salary, int hireYear, String education, String subject) {
        super(fullName, salary, hireYear, education);
        this.subject = subject;
    }

    public double calculateBonus() {
        return super.calculateBonus() + (calculateExperience() * 2000);
    }

    public String toString() {
        return super.toString() + ", Teacher{subject='" + subject + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(subject, teacher.subject);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), subject);
    }
}


class Manager extends Employer {
    private String department;

    public Manager(String fullName, double salary, int hireYear, String education, String department) {
        super(fullName, salary, hireYear, education);
        this.department = department;
    }

    public double calculateBonus() {
        return (getSalary() * 0.2) + super.calculateBonus();
    }

    public String toString() {
        return super.toString() + ", Manager{department='" + department + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return Objects.equals(department, manager.department);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), department);
    }
}
