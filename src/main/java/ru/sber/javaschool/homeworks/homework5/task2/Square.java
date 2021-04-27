package ru.sber.javaschool.homeworks.homework5.task2;

public class Square extends Figure {

    private float width;
    private float height;

    public Square(float width, float height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void getPerimeter() {
        System.out.println("Периметр квадрата = " + calcPerimeter());
    }

    @Override
    public void getArea() {
        System.out.println("Площадь квадрата = " + calcArea());
    }

    private float calcPerimeter(){
        return 4 * width;
    }

    private float calcArea(){
        return width * height;
    }
}
