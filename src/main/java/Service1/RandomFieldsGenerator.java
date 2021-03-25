package Service1;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

public class RandomFieldsGenerator {

    public static String getName() {

        String[] listOfNames = {"Aurora", "Aqua", "Neva", "Lusitania2", "MikhailSvetlov", "Olimpic", "Titanic3", "Titan", "Danube",
                "Sava", "BelgradeRiver", "Moscow", "Spb", "Maurithania", "FinlandBay", "Blue", "Ocean", "Anchor",
                "Vltava", "Atlantic", "Pacific", "Indiana", "Artica", "Antartica", "Vessel", "Shark", "Dolphin"};

        int rand = new Random().nextInt(listOfNames.length);
        String randomName1 = (listOfNames[rand]);

        int randomName2 = (int) (Math.random() * 1000);
        var s = String.valueOf(randomName2);
        return randomName2 + randomName1;
    }


    public static Time getTime() {

        final Random random = new Random();
        final int millisInDay = 24 * 60 * 60 * 1000;
        return new Time((long) random.nextInt(millisInDay));
    }


    public static LocalDate getDay() {
        final Random random = new Random();
        int firstDay = (int) LocalDate.of(2020, 11, 1).toEpochDay();
        int lastDay = (int) LocalDate.of(2020, 11, 30).toEpochDay();
        long randomDay = firstDay + random.nextInt(lastDay - firstDay);
        return LocalDate.ofEpochDay(randomDay);
    }


    public static type getType() {
        type[] enumArray = type.values(); //строю массив значении enum-a
        Random rand = new Random();
        return Arrays.stream(enumArray).
                skip(rand.nextInt(enumArray.length)).
                findFirst().get(); //использую стрим для нахождения случайного значения в массиве
    }

//примерные верхние границы веса груза и грузоподъемности различных видов кранов найдены в интернете,
//ссылки на источники указать в отчёте

    public static double getWeight(type type) {
        double limit = switch (type){
            case CONTAINER -> 20_000.0;
            case LIQUID -> 320_000.0;
            case BULK -> 500_000.0;
        };
        return ((double) (Math.random() * limit));
    }

    public static double getUnload(type type, double weight) {
        double carryingCapacityCrane = switch (type){
            case CONTAINER -> 32.0;
            case LIQUID -> 600.0;
            case BULK -> 1300.0;
        };
        return (weight/carryingCapacityCrane)/60.0; //конвертируем в час
    }
}
