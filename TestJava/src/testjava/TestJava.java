package testjava;

class Point {

    int x, y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}

class Circle {

    Point o;
    double r;

    public Circle() {
    }

    public Circle(Point o, double r) {
        this.o = o;
        this.r = r;
    }

    public Point getO() {
        return o;
    }

    public double getR() {
        return r;
    }

    public void setO(Point o) {
        this.o = o;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getArea() {
        return r * r * Math.PI;
    }

    public double getPerimeter() {
        return 2 * r * Math.PI;
    }
}

public class TestJava {

    public static void main(String[] args) throws Exception {
        System.out.println(Integer.toHexString(0x0E));
    }
}
