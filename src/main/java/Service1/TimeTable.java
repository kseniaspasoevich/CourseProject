package Service1;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;
import java.text.DecimalFormat;

public class TimeTable {

    //содержимое расписания, входит json файл
    private String name; //название судна
    private Time time; //время прибытия
    private LocalDate day; //день прибытия
    private typeAndWeight type; //тип груза
    private typeAndWeight weight; //вес груза
    private typeAndWeight unload; //Время разгрузки

    //конструкторы
    public TimeTable(int amountOfShips) {
        for (int i = 0; i < amountOfShips; i++) {
            System.out.println(getName());
            System.out.println(getTime());
            System.out.println(getDay());
            System.out.println(getType());
            System.out.println(getWeight());
            System.out.println(getUnload());
            System.out.println("-------------------------");
        }
    }

    public TimeTable() {}

    //геттеры и сеттеры
    public String getName() {

        String[] listOfNames = {"Aurora", "Aqua", "Neva", "Lusitania2", "MikhailSvetlov", "Olimpic", "Titanic3", "Titan", "Danube",
                "Sava", "BelgradeRiver", "Moscow", "Spb", "Maurithania", "FinlandBay", "Blue", "Ocean", "Anchor",
                "Vltava", "Atlantic", "Pacific", "Indiana", "Artica", "Antartica", "Vessel", "Shark", "Dolphin"};

        int rand = new Random().nextInt(listOfNames.length);
        String randomName1 = (listOfNames[rand]);

        int randomName2 = (int) (Math.random() * 1000);
        var s = String.valueOf(randomName2);
        name = randomName2 + randomName1;
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Time getTime() {

        final Random random = new Random();
        final int millisInDay = 24 * 60 * 60 * 1000;
        time=new Time((long) random.nextInt(millisInDay));
        return time;
    }

    public void setTime(Time time) {

        this.time = time;
    }

    public LocalDate getDay() {
        final Random random = new Random();
        int firstDay = (int) LocalDate.of(2020, 11, 1).toEpochDay();
        int lastDay = (int) LocalDate.of(2020, 11, 30).toEpochDay();
        long randomDay = firstDay + random.nextInt(lastDay - firstDay);
        day = LocalDate.ofEpochDay(randomDay);
        return day;}

    public void setDay(LocalDate day) {

        this.day = day;
    }

    public typeAndWeight getType() {
        typeAndWeight[] enumArray = typeAndWeight.values(); //строю массив значении enum-a
        Random rand = new Random();
        type = Arrays.stream(enumArray).
                skip(rand.nextInt(enumArray.length)).
                findFirst().get(); //использую стрим для нахождения случайного значения в массиве
        return type;
    }

    public void setType(typeAndWeight type) {
        this.type = type;
    }

    public double getWeight() {
        weight=getType();
        DecimalFormat df2 = new DecimalFormat("#.##");

        if (weight==typeAndWeight.CONTAINER) {
            return weight.generateContainerWeight();

        } else if (weight==typeAndWeight.LIQUID){
            return weight.generateTankerWeight();
        } else {
            return weight.generateBulkerWeight();
        }
    }

    public void setWeight(typeAndWeight weight) {

        this.weight = weight;
    }

    public double getUnload() {

        unload = getType();
        DecimalFormat df1 = new DecimalFormat("#.#");
        if (unload==typeAndWeight.CONTAINER) {
            return unload.generateContainerTime();

        } else if (unload==typeAndWeight.LIQUID){
            return unload.generateTankerTime();
        } else {
            return unload.generateBulkerWeight();
        }
    }

    public void setUnload(typeAndWeight unload) {

        this.unload = unload;
    }
}


