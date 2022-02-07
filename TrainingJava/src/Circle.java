
public class Circle {

    private Point O;
    private double r;

    public Circle() {
    }

    public Circle(Point O, double r) {
        this.O = O;
        this.r = r;
    }

    // ALT + INSERT
    public Point getO() {
        return O;
    }

    public void setO(Point O) {
        this.O = O;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    @Override
    public String toString() {
        return "O = " + O.getX() + ", " + O.getY() + "; r = " + r;
    }

    public double getPerimeter() {
        return 2 * r * Math.PI;
    }

    public double getArea() {
        return r * r * Math.PI;
    }
}
// hinh tron: Toa do O, ban kinh r
// hinh cau: Toa do O, ban kinh r, int z
// hinh cau ke thua hinh tron (co them: getVolume)