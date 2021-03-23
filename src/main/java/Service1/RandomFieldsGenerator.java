package Service1;

import java.sql.Time;
import java.text.DecimalFormat;
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


    public static typeAndWeight getType() {
        typeAndWeight[] enumArray = typeAndWeight.values(); //строю массив значении enum-a
        Random rand = new Random();
        return Arrays.stream(enumArray).
                skip(rand.nextInt(enumArray.length)).
                findFirst().get(); //использую стрим для нахождения случайного значения в массиве
    }


    public static double getWeight(typeAndWeight type) {
        typeAndWeight weight = type;
        DecimalFormat df2 = new DecimalFormat("#.##");

        if (weight==typeAndWeight.CONTAINER) {
            return weight.generateContainerWeight();

        } else if (weight==typeAndWeight.LIQUID){
            return weight.generateTankerWeight();
        } else {
            return weight.generateBulkerWeight();
        }

    }

    public static double getUnload(typeAndWeight type) {

        typeAndWeight unload = type;
        DecimalFormat df1 = new DecimalFormat("#.#");
        if (unload==typeAndWeight.CONTAINER) {
            return unload.generateContainerTime();

        } else if (unload==typeAndWeight.LIQUID){
            return unload.generateTankerTime();
        } else {
            return unload.generateBulkerWeight();
        }
    }

}
