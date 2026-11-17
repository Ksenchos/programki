import java.util.Objects;

public class Task3 {
    public static void main(String[] args) {
        MovingObject someObject = new Car("Объект 1", 1500, 60, "Toyota", 8.5);
        System.out.println(someObject.getInfo());
        System.out.println("Скорость: " + someObject.calculateSpeed() + "м/с");

        Car car1 = new Car("Автомобиль 1", 5000, 120, "BMW", 10.0);
        Car car2 = new Car("Автомобиль 1", 5000, 120, "BMW", 10.0);
        Bicycle bike = new Bicycle("Велосипед 1", 2000, 300, "Горный");

        MovingObject[] objects = {car1, car2, bike};
        for (MovingObject obj: objects) {
            System.out.println(obj.getInfo());
            System.out.println("Скорость: " + obj.calculateSpeed() + "м/с\n");

            System.out.println(car1);
            System.out.println(bike);

            System.out.println(car1.equals(car2));
            System.out.println(car1.equals(bike));
            System.out.println(car1.hashCode());
            System.out.println(car2.hashCode());
            System.out.println(bike.hashCode());

            try {
                Car badCar = new Car("", -100, 0, "Audi", 7.0);
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка при создании: " + e.getMessage());
            }
        }
    }
}


class MovingObject {
    private String name;
    private double distance;
    private double time;

    public MovingObject(String name, double distance, double time) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название не может быть пустым");
        }
        if (distance < 0) {
            throw new IllegalArgumentException("Расстояние не может быть отрицательным");
        }
        if (time <= 0) {
            throw new IllegalArgumentException("Время должно быть больше нуля");
        }

        this.name = name;
        this.distance = distance;
        this.time = time;
    }

    public double calculateSpeed() {
        return Math.round((distance / time) * 100.0) / 100.0;
    }

    public String getInfo() {
        return "Объект: " + name + ", Расстояние: " + distance + "м, Время: " + time + "с";
    }

    public String toString() {
        return "MovingObject{name=" + name + ", distance=" + distance + ", time=" + time + "}";
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovingObject that = (MovingObject) o;
        return Double.compare(that.distance, distance) == 0 && Double.compare(that.time, time) == 0 && Objects.equals(that.name, name);
    }

    public int hashCode() {
        return Objects.hash(name, distance, time);
    }
}


class Car extends MovingObject {
    private String brand;
    private double fuelConsumption;

    public Car(String name, double distance, double time, String brand, double fuelConsumption) {
        super(name, distance, time);
        if (brand == null || brand.trim().isEmpty()) {
            throw new IllegalArgumentException("Марка автомобиля не может быть пустой");
        }
        if (fuelConsumption < 0) {
            throw new IllegalArgumentException("Расход топлива не может быть отрицательным");
        }

        this.brand = brand;
        this.fuelConsumption = fuelConsumption;
    }

    public double calculateSpeed() {
        double baseSpeed = super.calculateSpeed();
        return Math.round((baseSpeed * 1.05) * 100.0) / 100.0;
    }

    public String getInfo() {
        return super.getInfo() + ", Марка: " + brand + ", Расход топлива: " + fuelConsumption + "л/100км";
    }

    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.fuelConsumption, fuelConsumption) == 0 && Objects.equals(car.brand, brand);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), brand, fuelConsumption);
    }
}


class Bicycle extends MovingObject {
    private String type;

    public Bicycle(String name, double distance, double time, String type) {
        super(name, distance, time);
        if (type == null || type.trim().isEmpty()) {
            throw new IllegalArgumentException("Тип велосипеда не может быть пустым");
        }

        this.type = type;
    }

    public String getInfo() {
        return super.getInfo() + ", Тип велосипеда: " + type;
    }

    public String toString() {
        return super.toString() + ", Bicycle{type=" + type + "}";
    }

    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bicycle bicycle = (Bicycle) o;
        return Objects.equals(bicycle.type, type);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), type);
    }
}
