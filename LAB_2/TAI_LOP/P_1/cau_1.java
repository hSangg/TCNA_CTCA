package LAB_2.TAI_LOP.P_1;

class Point {
    public int x;
    public int y;

    Point() {
        this.x = this.y = 0;
    }

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    double distance(Point x) {
        return Math.sqrt(Math.pow((this.x - x.x), 2) + Math.pow((this.y - x.y), 2));
    }
}

public class cau_1 {
    public static void main(String[] args) {
        Point x = new Point(0, 2);
        Point y = new Point(0, 4);

        System.out.println(x.distance(y));
    }
}
