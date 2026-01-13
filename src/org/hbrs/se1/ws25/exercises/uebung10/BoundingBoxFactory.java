package org.hbrs.se1.ws25.exercises.uebung10;

public class BoundingBoxFactory {


    public static MyPrettyRectangle createBoundingBox(MyPrettyRectangle[] rects){
        if(rects == null) return null;
        if(rects.length == 0){
            return new MyPrettyRectangle(0,0,0,0);
        }

        double minX = rects[0].getX1();
        double minY = rects[0].getY1();
        double maxX = rects[0].getX2();
        double maxY = rects[0].getY2();

        for (MyPrettyRectangle r : rects){
            if(r.getX1() < minX) minX = r.getX1();
            if(r.getY1() < minY) minY = r.getY1();
            if(r.getX2() > maxX) maxX = r.getX2();
            if(r.getY2() > maxY) maxY = r.getY2();
        }

        return new MyPrettyRectangle(minX, minY, maxX, maxY);
    }
}
