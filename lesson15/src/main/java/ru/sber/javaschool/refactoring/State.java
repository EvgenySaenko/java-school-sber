package ru.sber.javaschool.refactoring;

public class State {
    private Orientation orientation;
    private Position position;
    private Field field;

    public State(){
        this.orientation = Orientation.NORTH;
        this.position = new Position(0,0);
        this.field = new Field(5,5);
    }

    public void moveForwards() {
        if (position.getX() >= field.getX() || position.getY() >= field.getY()) {
            throw new TractorInDitchException("Трактор покинул пределы поля!!");
        }
        position = orientation.move(position);
        System.out.println("position: " + position);
    }

    public void turnClockwise() {
        orientation = this.orientation.turn();
        System.out.println("orientation: " + orientation);
    }
}
