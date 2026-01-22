package org.hbrs.se1.ws25.exercises.uebung10;

public class MyPoint {

    private double x;
    private double y;

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        MyPoint anderes = (MyPoint) o;
        if (this.x == anderes.x && this.y == anderes.y) {
            return true;
        }
        return false;
    }
}
