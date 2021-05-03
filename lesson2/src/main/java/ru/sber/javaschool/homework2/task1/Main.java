package ru.sber.javaschool.homework2.task1;

import java.util.*;

public class Main {
    private static final String SEDAN = "sedan";
    private static final String HATCHBACK = "hatchback";
    private static final String CROSSOVER = "crossover";

    public static List<Car> createListCars(){
        List<Car> park = new ArrayList<>();
        park.add(new Car("Lada","sedan"));
        park.add(new Car("Mercedes","sedan"));
        park.add(new Car("Lada","hatchback"));
        park.add(new Car("Audi","crossover"));
        park.add(new Car("Mercedes","crossover"));
        park.add(new Car("Toyota","hatchback"));
        park.add(new Car("Toyota","sedan"));
        park.add(new Car("Ford","hatchback"));
        park.add(new Car("Ford","sedan"));
        park.add(new Car("BMW","crossover"));
        return park;
    }

    public static void showListCars(Collection<Car> park){
        for (Car car : park){
            System.out.println(car);
        }
    }

    private static Map<String,List<Car>> sortByTypes(List<Car> parkCar) {
        //создаются площадки по типам машин
        List<Car> sedanCars = new ArrayList<>();
        List<Car> hatchbackCars = new ArrayList<>();
        List<Car> crossoverCars = new ArrayList<>();

        //создается бокс для всех площадок
        Map<String, List<Car>> boxingPark = new HashMap<>();

        //перебираем заезжающие авто по типам и направляем на нужную площадку
        for (Car car : parkCar){
            if (car.getType().equals(SEDAN)){
                sedanCars.add(car);
            }else if (car.getType().equals(HATCHBACK)){
                hatchbackCars.add(car);
            }else if (car.getType().equals(CROSSOVER)){
                crossoverCars.add(car);
            }else {
                System.out.println("Авто типа: " + car.getType() + " мы не принимаем!");
            }
        }
        //кладем площадки в бокс
        boxingPark.put(SEDAN,sedanCars);
        boxingPark.put(HATCHBACK,hatchbackCars);
        boxingPark.put(CROSSOVER,crossoverCars);
        return  boxingPark;
    }

    public static void showBoxingCars(Map<String,List<Car>>mapCars){
        Set<Map.Entry<String,List<Car>>> set = mapCars.entrySet();
        for(Map.Entry<String,List<Car>> entry : set){
            System.out.println(entry.getKey()+ ":" );
            System.out.println(entry.getValue() + "\n");
        }
    }



    public static void main(String[] args) {
        List<Car> parkCar = new ArrayList<>();
        parkCar = createListCars();
        showListCars(parkCar);
        Map<String,List<Car>> sortBoxing = sortByTypes(parkCar);
        showBoxingCars(sortBoxing);
    }
}
