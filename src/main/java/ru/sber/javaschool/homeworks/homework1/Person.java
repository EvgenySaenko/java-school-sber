package ru.sber.javaschool.homeworks.homework1;

public class Person {
    private final boolean man;
    private final String name;
    private Person spouse;

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    public boolean isMan() {
        return man;
    }

    public String getName() {
        return name;
    }

    public Person getSpouse() {
        return spouse;
    }

    //метод создал для проверки
    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    //существует ли супруг/а у человека
    public boolean isSpouse() {
        if (this.spouse != null) {
            return true;
        }
        return false;
    }

    /**
     * This method checks gender of persons. If genders are not equal - tries to marry.
     * If one of them has another spouse - execute divorce(sets spouse = null for husband and wife.
     * Example: if both persons have spouses - then divorce will set 4 spouse to null) and then executes marry().
     *
     * @param person - new husband/wife for this person.
     * @return - returns true if this person has another gender than passed person and they are not husband and wife, false otherwise
     */
    public boolean marry(Person person) {
        if (this.man == person.isMan()) {//если пол одинаковый => брака не будет
            System.out.println(this.man + " = " + person.man + " - не будем бракосочетать");
            return false;
        } else {
            if (this.spouse != null && person.spouse != null) {//если у обоих есть супруги то разводим обоих
                if (person.spouse == this) {//проверяем не забили ли они что уже женаты :-)
                    System.out.println(this.name + " = " + person.getName() + " они уже в браке");
                    return false;
                } else {
                    System.out.println("оба в браке " + "предлагает: " + this.getName() + " та кому предлагают: " + person.getName());
                    System.out.println("их супруги " + "предлагает: " + this.spouse.getName() + " та кому предлагают: " + person.spouse.getName());
                    this.divorce();//развели его
                    this.spouse.divorce();//и его супруга

                    person.divorce();//развели ту которой предложили
                    person.spouse.divorce();//и развели супруга той которой предложили

                    this.spouse = person;
                    person.spouse = this;
                    return true;//;женим
                }
                //если выше мы не заходим в if значит женат только один из них
            } else if (this.spouse != null) {//если тот кто предлагает оказался женат
                System.out.println(this.name + " оказался женат на - " + this.spouse.name);

                this.spouse.divorce();//и развели его супруга сначала
                System.out.println(this.spouse.name + " есть ли супруг? - " + this.spouse.isSpouse());

                this.divorce();//развели его
                System.out.println("женат ли: " + this.isSpouse());

                this.spouse = person;
                person.spouse = this;
                return true;//;женим
            } else if (person.spouse != null) {//а если у того кому предлагаем есть супруг то разводим их
                System.out.println(person.getName() + " есть супруг по имени " + person.getSpouse().name);

                person.spouse.divorce();//разводим его супруга
                System.out.println("есть супруг у его супруга? " + person.spouse.isSpouse());

                person.divorce();
                System.out.println("есть ли супруг у него ? " + person.isSpouse());

                this.spouse = person;
                person.spouse = this;
                return true;//;женим
            } else {
                //если же они оказались без супругов оба - женим
                System.out.println("они оба не женаты " + this.name + " " + this.isSpouse() + " " + person.name + " " + person.isSpouse());
                this.spouse = person;
                person.spouse = this;
                return true;
            }
        }
    }

    /**
     * Sets spouse = null if spouse is not null
     *
     * @return true - if person status has been changed
     */
    public boolean divorce() {
        if (this.spouse != null) {
            this.spouse = null;
            return true;
        }
        return false;
    }
}
