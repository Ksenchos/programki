import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task {
    public static void main(String[] args) {
        List<Gadget> gadgets = new ArrayList<>();

        gadgets.add(new Smartphone("iPhone 15", 56000, 256));
        gadgets.add(new Laptop("MacBook Air", 120000, 16));
        gadgets.add(new Smartphone("Samsung Galaxy", 70000, 128));
        gadgets.add(new Laptop("Asus ZenBook", 95000, 32));

        printGadgets(gadgets);
        Collections.sort(gadgets);
        printGadgets(gadgets);
    }

    private static void printGadgets(List<Gadget> list) {
        for (Gadget g: list) {
            System.out.println(g);
        }
    }
}


abstract class Gadget implements Comparable<Gadget> {
    private String name;
    private double price;

    public Gadget(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract int getWarrantyMonths();

    public int compareTo(Gadget other) {
        return Double.compare(this.price, other.price);
    }

    public String toString() {
        return name + " | Цена: " + price + " руб. | Гарантия: " + getWarrantyMonths() + " мес.";
    }
}


class Smartphone extends Gadget {
    private int memoryGB;

    public Smartphone(String name, double price, int memoryGB) {
        super(name, price);
        this.memoryGB = memoryGB;
    }

    public int getWarrantyMonths() {
        return 12;
    }

    public String toString() {
        return super.toString() + "[Смартфон, Память: " + memoryGB + " ГБ]";
    }
}


class Laptop extends Gadget {
    private int ramGB;

    public Laptop(String name, double price, int ramGB) {
        super(name, price);
        this.ramGB = ramGB;
    }

    public int getWarrantyMonths() {
        return 24;
    }

    public String toString() {
        return super.toString() + " [Ноутбук, ОЗУ: " + ramGB + " ГБ]";
    }
}
