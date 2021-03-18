package Service1;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;
import java.text.DecimalFormat;

public class TimeTable {

    //содержимое расписания
    private String name; //название судна
    private Time time; //время прибытия
    private LocalDate day; //день прибытия
    private typeAndWeight type; //тип груза
    private typeAndWeight weight; //вес груза
    private typeAndWeight unload; //Время разгрузки

    public void generateName() { //случайная генерация имени (String+random int between 1 and 1000)

        String[] listOfNames = {"Aurora", "Aqua", "Neva", "Lusitania2", "MikhailSvetlov", "Olimpic", "Titanic3", "Titan", "Danube",
                "Sava", "BelgradeRiver", "Moscow", "Spb", "Maurithania", "FinlandBay", "Blue", "Ocean", "Anchor",
                "Vltava", "Atlantic", "Pacific", "Indiana", "Artica", "Antartica", "Vessel", "Shark", "Dolphin"};

        int rand = new Random().nextInt(listOfNames.length);
        String randomName1 = (listOfNames[rand]);

        int randomName2 = (int) (Math.random() * 1000);
        var s = String.valueOf(randomName2);
        name = randomName2 + randomName1;
        System.out.println(name);
    }

    public void generateTime() { //случайная генерация времени
        final Random random = new Random();
        final int millisInDay = 24 * 60 * 60 * 1000;
        time=new Time((long) random.nextInt(millisInDay));
        System.out.println(time);
    }

    public void generateDay() { //случайная генерация даты
        final Random random = new Random();
        int firstDay = (int) LocalDate.of(2020, 11, 1).toEpochDay();
        int lastDay = (int) LocalDate.of(2020, 11, 30).toEpochDay();
        long randomDay = firstDay + random.nextInt(lastDay - firstDay);
        System.out.println(day = LocalDate.ofEpochDay(randomDay));
    }

    public typeAndWeight generateType() { //случайная генерация типа
        typeAndWeight[] enumArray = typeAndWeight.values(); //строю массив значении enum-a
        Random rand = new Random();
        type = Arrays.stream(enumArray).
                skip(rand.nextInt(enumArray.length)).
                findFirst().get(); //использую стрим для нахождения случайного значения в массиве
        return type;
    }

    public void generateWeight() { //случайная генерация веса груза на основе типа
        weight = generateType();
        DecimalFormat df2 = new DecimalFormat("#.##");

        switch (weight) {
            case CONTAINER -> {
                System.out.println(df2.format(weight.generateContainerWeight())+" tones");
            }
            case LIQUID -> {
                System.out.println(df2.format(weight.generateTankerWeight())+" tones");
            }
            case BULK -> {
                System.out.println(df2.format(weight.generateBulkerWeight())+" tones");
            }
            default -> throw new IllegalStateException("Unexpected value: " + weight);
        }
    }

    public void generateTimeOfUnloading() {
        unload = generateType();
        DecimalFormat df1 = new DecimalFormat("#.#");
        switch (unload) {
            case CONTAINER -> {
                System.out.println(df1.format(unload.generateContainerTime())+" minutes");
            }
            case LIQUID -> {
                System.out.println(df1.format(unload.generateTankerTime())+" minutes");
            }
            case BULK -> {
                System.out.println(df1.format(unload.generateBulkerTime())+" minutes");
            }
            default -> throw new IllegalStateException("Unexpected value: " + unload);
        }
    }

    public void generateTimeTable(int amountOfShips){
        for(int i=0; i<amountOfShips; i++){
            generateName();
            generateTime();
            generateDay();
            System.out.println(generateType());
            generateWeight();
            generateTimeOfUnloading();
            System.out.println("-----------------------");
        }
    }

}


