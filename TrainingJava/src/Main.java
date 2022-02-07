
public class Main {

    public static void main(String[] args) {
        Point O = new Point(100, 120);

        System.out.println("Toa do O: x = " + O.getX() + "; y = " + O.getY());

        Circle ht1 = new Circle(O, 100.5);

        Ball ball1 = new Ball(-100, O, 123.4);

        System.out.println(ball1.getArea());
        System.out.println(ball1.getVolume());
    }
}
