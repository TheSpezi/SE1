package org.hbrs.se1.ws25.exercises.uebung10;

public class MyPrettyRectangle {

    //Punkte
    private double x1;
    private double y1;
    private double x2;
    private double y2;

    public MyPrettyRectangle(double x1, double y1, double x2, double y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public boolean contains(MyPrettyRectangle anderes){

        return (this.x1 <= anderes.x1 && this.y1 <= anderes.y2) && ( this.x2 >= anderes.x2 && this.y2 >= anderes.y2);
    }

    public MyPoint getCenter(){
        double xMitte = (this.x1 + this.x2) / 2;
        double yMitte = (this.y1 + this.y2) / 2;

        return new MyPoint(xMitte, yMitte);
    }

    public double getArea(){
        return (this.x2 - this.x1) * (this.y2 - this.y1);
    }

    public double getPerimeter(){
        return ((this.x2 - this.x1) + (this.y2 - this.y1)) * 2;

    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;

        MyPrettyRectangle anderes = (MyPrettyRectangle) o;
        if(this.x1 == anderes.x1 && this.y1 == anderes.y1 && this.x2 == anderes.x2 && this.y2 == anderes.y2){
            return true;
        }
        return false;
    }

    public double getX1() {
        return x1;
    }

    public double getY1() {
        return y1;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }
}
