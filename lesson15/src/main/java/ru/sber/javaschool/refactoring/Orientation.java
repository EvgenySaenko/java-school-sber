package ru.sber.javaschool.refactoring;


public enum Orientation implements Control{
	//!!чтобы работали методы внутри перечислений 2 способа
	//1. объявить абстрактные методы внутри енума
	//2. имплементить интерфейс с такими абстрактными методами

	NORTH("NORTH"){
		public Orientation turn(){
			return EAST;
		}
		public Position move(Position p){
			return p.changeY(1);
		}
	},
	WEST("WEST"){
		public Orientation turn(){
			return NORTH;
		}
		public Position move(Position p){
			return p.changeX(-1);
		}
	},
	SOUTH("SOUTH"){
		public Orientation turn(){
			return WEST;
		}
		public Position move(Position p){
			return p.changeY(-1);
		}
	},
	EAST("EAST"){
		public Orientation turn(){
			return SOUTH;
		}
		public Position move(Position p){
			return p.changeX(1);
		}
	};
//	abstract Orientation turn();
//	abstract Position move(Position p);

	private String orientation;
	Orientation(String orientation) {
		this.orientation = orientation;
	}

	public String toString() {
		return "Orientation: " + orientation;
	}
}
