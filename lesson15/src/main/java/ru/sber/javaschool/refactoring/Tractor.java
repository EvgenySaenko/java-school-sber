package ru.sber.javaschool.refactoring;

public class Tractor {
	private State state;

	public Tractor() {
		this.state = new State();
	}

	public void move(String command) {
        if (command.equals("F")) {
			state.moveForwards();
		} else if (command.equals("T")) {
			state.turnClockwise();
		}
	}
}
