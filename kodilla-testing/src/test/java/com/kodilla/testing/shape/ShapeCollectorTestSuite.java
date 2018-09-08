package com.kodilla.testing.shape;

import org.junit.*;

public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @Before
    public void before() {
        testCounter++;
        System.out.println("Test Case: begin test no. " + testCounter);
    }

    @After
    public void after() {
        System.out.println("Test Case: finished test no. " + testCounter);
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Test Suite: begin");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Test Suite: end");
    }

    @Test
    public void testAddFigure() {
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(new Circle(2));
        Assert.assertEquals(1, shapeCollector.size());
    }

    @Test
    public void testRemoveFigure() {
        Square testSquare = new Square(1);
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(testSquare);
        Assert.assertTrue(shapeCollector.removeFigure(testSquare));
        Assert.assertEquals(0, shapeCollector.size());
    }

    @Test
    public void testGetFigure() {
        Circle testCircle = new Circle(2);
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(testCircle);
        Assert.assertSame(testCircle, shapeCollector.getFigure(0));

    }

    @Test
    public void testShowFigures() {
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(new Square(1));
        shapeCollector.addFigure(new Triangle(1, 2));
        Assert.assertTrue(shapeCollector.showFigures().contains("square, triangle"));
    }
}
