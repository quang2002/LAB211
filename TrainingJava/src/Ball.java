
public class Ball extends Circle {

    private int z;

    public Ball() {
    }

    public Ball(int z, Point O, double r) {
        super(O, r);
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public double getVolume() {
        return 4.0 / 3.0 * Math.PI * getR() * getR() * getR();
    }

    @Override
    public double getArea() {
        return 4 * Math.PI * getR() * getR();
    }
}
