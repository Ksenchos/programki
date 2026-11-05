public class Task1 {
    public static void main(String[] args) {
        Vector3D v1 = new Vector3D(1, 2, 3, 4, 5, 6);
        Vector3D v2 = new Vector3D(0, 0, 0, 3, 2, 1);

        System.out.println("Вектор 1: " + v1);
        System.out.println("Вектор 2: " + v2);

        Vector3D v3 = v1.add(v2);
        System.out.println("Сложение v1 + v2: " + v3);

        double dot = v1.dotProduct(v2);
        System.out.println("Скалярное произведение v1 * v2: " + dot);

        Vector3D v4 = v1.multiply(2);
        System.out.println("v1, умноженный на 2: " + v4);

        double len = v1.length();
        System.out.printf("Длина v1: %.2f", len);
    }
}

class Vector3D {
    private double x1, y1, z1;
    private double x2, y2, z2;

    public Vector3D(double x1, double y1, double z1, double x2, double y2, double z2) {
        this.x1 = x1;
        this.y1 = y1;
        this.z1 = z1;
        this.x2 = x2;
        this.y2 = y2;
        this.z2 = z2;
    }

    private double getDx() { return x2 - x1; }
    private double getDy() { return y2 - y1; }
    private double getDz() { return z2 - z1; }

    public Vector3D add(Vector3D other) {
        double newDx = this.getDx() + other.getDx();
        double newDy = this.getDy() + other.getDy();
        double newDz = this.getDz() + other.getDz();

        double endX = this.x1 + newDx;
        double endY = this.y1 + newDy;
        double endZ = this.z1 + newDz;

        return new Vector3D(this.x1, this.y1, this.z1, endX, endY, endZ);
    }

    public double dotProduct(Vector3D other) {
        return this.getDx() * other.getDx() + this.getDy() * other.getDy() + this.getDz() * other.getDz();
    }

    public Vector3D multiply(double scalar) {
        double newDx = this.getDx() * scalar;
        double newDy = this.getDy() * scalar;
        double newDz = this.getDz() * scalar;

        double endX = this.x1 + newDx;
        double endY = this.y1 + newDy;
        double endZ = this.z1 + newDz;

        return new Vector3D(this.x1, this.y1, this.z1, endX, endY, endZ);
    }

    public double length() {
        return Math.sqrt(Math.pow(getDx(), 2) + Math.pow(getDy(), 2) + Math.pow(getDz(), 2));
    }

    public String toString() {
        return "Vector 3D {start = (" + x1 + ", " + y1 + ", " + z1 + "), end = (" + x2 + ", " + y2 + ", " + z2 + ")}";
    }
}
