package org.hbrs.se1.ws25.solutions.uebung10.test.rectangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FurtherTestRectangle {

    @Test
    void testGetCenter() {
        MyPrettyRectangle rect1 = new MyPrettyRectangle(0, 0, 2, 4);
        MyPrettyRectangle rect2 = new MyPrettyRectangle(1, 1, 3, 5);
        MyPrettyRectangle rect3 = new MyPrettyRectangle(-1, -1, 1, 1);

        assertEquals(new MyPoint(1.0, 2.0), rect1.getCenter());
        assertEquals(new MyPoint(2.0, 3.0), rect2.getCenter());
        assertEquals(new MyPoint(0.0, 0.0), rect3.getCenter());
    }

    @Test
    void testGetArea() {
        MyPrettyRectangle rect1 = new MyPrettyRectangle(0, 0, 2, 4);
        MyPrettyRectangle rect2 = new MyPrettyRectangle(1, 1, 3, 5);
        MyPrettyRectangle rect3 = new MyPrettyRectangle(-1, -1, 1, 1);

        assertEquals(8.0, rect1.getArea(), 0.0001);
        assertEquals(8.0, rect2.getArea(), 0.0001);
        assertEquals(4.0, rect3.getArea(), 0.0001);
    }

    @Test
    void testGetPerimeter() {
        MyPrettyRectangle rect1 = new MyPrettyRectangle(0, 0, 2, 4);
        MyPrettyRectangle rect2 = new MyPrettyRectangle(1, 1, 3, 5);
        MyPrettyRectangle rect3 = new MyPrettyRectangle(-1, -1, 1, 1);

        assertEquals(12.0, rect1.getPerimeter(), 0.0001);
        assertEquals(12.0, rect2.getPerimeter(), 0.0001);
        assertEquals(8.0, rect3.getPerimeter(), 0.0001);
    }

    @Test
    void testContains() {
        MyPrettyRectangle outer = new MyPrettyRectangle(0, 0, 4, 4);
        MyPrettyRectangle inner = new MyPrettyRectangle(1, 1, 3, 3);
        MyPrettyRectangle notContained = new MyPrettyRectangle(3, 3, 5, 5);

        assertTrue(outer.contains(inner));
        assertFalse(outer.contains(notContained));
    }

    @Test
    void testEquals() {
        MyPrettyRectangle rect1 = new MyPrettyRectangle(0, 0, 2, 4);
        MyPrettyRectangle rect2 = new MyPrettyRectangle(0, 0, 2, 4);
        MyPrettyRectangle rect3 = new MyPrettyRectangle(1, 1, 3, 5);

        assertTrue(rect1.equals(rect2));
        assertFalse(rect1.equals(rect3));
    }

    @Test
void createBoundingBoxHandlesNullInput() {
    MyPrettyRectangle result = BoundingBoxFactory.createBoundingBox(null);
    assertNull(result);
}

@Test
void createBoundingBoxHandlesEmptyArray() {
    MyPrettyRectangle result = BoundingBoxFactory.createBoundingBox(new MyPrettyRectangle[]{});
    assertEquals(new MyPrettyRectangle(0.0, 0.0, 0.0, 0.0), result);
}

@Test
void createBoundingBoxHandlesSingleRectangle() {
    MyPrettyRectangle rect = new MyPrettyRectangle(1.0, 1.0, 2.0, 2.0);
    MyPrettyRectangle result = BoundingBoxFactory.createBoundingBox(new MyPrettyRectangle[]{rect});
    assertEquals(rect, result);
}

@Test
void createBoundingBoxHandlesMultipleRectangles() {
    MyPrettyRectangle rect1 = new MyPrettyRectangle(1.0, 1.0, 2.0, 2.0);
    MyPrettyRectangle rect2 = new MyPrettyRectangle(0.0, 0.0, 3.0, 3.0);
    MyPrettyRectangle result = BoundingBoxFactory.createBoundingBox(new MyPrettyRectangle[]{rect1, rect2});
    assertEquals(new MyPrettyRectangle(0.0, 0.0, 3.0, 3.0), result);
}

@Test
void createBoundingBoxHandlesOverlappingRectangles() {
    MyPrettyRectangle rect1 = new MyPrettyRectangle(1.0, 1.0, 4.0, 4.0);
    MyPrettyRectangle rect2 = new MyPrettyRectangle(2.0, 2.0, 5.0, 5.0);
    MyPrettyRectangle result = BoundingBoxFactory.createBoundingBox(new MyPrettyRectangle[]{rect1, rect2});
    assertEquals(new MyPrettyRectangle(1.0, 1.0, 5.0, 5.0), result);
}

@Test
void createBoundingBoxHandlesNegativeCoordinates() {
    MyPrettyRectangle rect1 = new MyPrettyRectangle(-3.0, -3.0, -1.0, -1.0);
    MyPrettyRectangle rect2 = new MyPrettyRectangle(-2.0, -2.0, 1.0, 1.0);
    MyPrettyRectangle result = BoundingBoxFactory.createBoundingBox(new MyPrettyRectangle[]{rect1, rect2});
    assertEquals(new MyPrettyRectangle(-3.0, -3.0, 1.0, 1.0), result);
}

    @Test
    void createBoundingBoxHandlesNonOverlappingRectangles() {
        MyPrettyRectangle rect1 = new MyPrettyRectangle(0.0, 0.0, 1.0, 1.0);
        MyPrettyRectangle rect2 = new MyPrettyRectangle(2.0, 2.0, 3.0, 3.0);
        MyPrettyRectangle rect3 = new MyPrettyRectangle(4.0, 4.0, 5.0, 5.0);
        MyPrettyRectangle rect4 = new MyPrettyRectangle(6.0, 6.0, 7.0, 7.0);
        MyPrettyRectangle rect5 = new MyPrettyRectangle(8.0, 8.0, 9.0, 9.0);
        MyPrettyRectangle rect6 = new MyPrettyRectangle(10.0, 10.0, 11.0, 11.0);
        MyPrettyRectangle rect7 = new MyPrettyRectangle(12.0, 12.0, 13.0, 13.0);
        MyPrettyRectangle rect8 = new MyPrettyRectangle(14.0, 14.0, 15.0, 15.0);
        MyPrettyRectangle rect9 = new MyPrettyRectangle(16.0, 16.0, 17.0, 17.0);
        MyPrettyRectangle rect10 = new MyPrettyRectangle(18.0, 18.0, 19.0, 19.0);

        MyPrettyRectangle[] rects = {rect1, rect2, rect3, rect4, rect5, rect6, rect7, rect8, rect9, rect10};
        MyPrettyRectangle result = BoundingBoxFactory.createBoundingBox(rects);

        assertEquals(new MyPrettyRectangle(0.0, 0.0, 19.0, 19.0), result);
    }

}