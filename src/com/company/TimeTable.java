package com.company;

import java.util.Arrays;
import java.util.Random;
import java.sql.Time;

public class TimeTable {
    
    // название судна, день прибытия
    private String month;
    private String name;
    private String time;
    private int day;

    public TimeTable(){}

    public String getName() {

        String[] listOfNames ={"Aurora", "Aqua", "Neva", "Lusitania2", "MikhailSvetlov", "Olimpic", "Titanic3", "Titan", "Danube",
                "Sava", "BelgradeRiver", "Moscow", "Spb", "Maurithania", "FinlandBay", "Blue", "Ocean", "Anchor",
                "Vltava", "Atlantic", "Pacific", "Indiana", "Artica", "Antartica", "Vessel", "Shark", "Dolphin"};

        int rand=new Random().nextInt(listOfNames.length);
        String randomName1=(listOfNames[rand]);

        int randomName2 = (int) (Math.random() * 1000);
        var s = String.valueOf(randomName2);
        var name = randomName2 + randomName1;
        return name;
    }

    public Time getTime() { //случайная генерация времени
        final Random random = new Random();
        final int millisInDay = 24*60*60*1000;
        Time time = new Time((long)random.nextInt(millisInDay));
        return time;
    }

    public String getMonth() { //берём месяц у которого ровно 30 дней

        final String month="November";
        return month;
    }

    public int getDay() { //период моделирования 30 дней

        int day = 1+(int) (Math.random() * 30);
        return day;
    }

     public typeAndWeight getWeight() { //генерация веса, типа и времени разгрузки
         typeAndWeight[] enumArray = typeAndWeight.values(); //строю массив значении enum-a
         Random rand = new Random();
         typeAndWeight obj = Arrays.stream(enumArray).
                 skip(rand.nextInt(enumArray.length)).
                 findFirst().get(); //использую стрим для нахождения случайного значения в массиве

         if (obj == typeAndWeight.BULK) {
             obj.generateBulkerData();
             return obj;
         }
         else if (obj == typeAndWeight.CONTAINER) {
             obj.generateContainerData();
             return obj;
         }
         else if (obj == typeAndWeight.LIQUID) {
         obj.generateTankerData();
         return obj;
     }
         else return null;
     }

     public void generateTimeScedule(int amountOfShips){ //главный метод генерации
         final int year=2020;
         for (int i=0; i<amountOfShips; i++){
             System.out.println(getWeight());
             System.out.println("NAME: "+getName());
             System.out.println("DATE: "+getMonth()+" "+getDay()+", "+year);
             System.out.println("TIME: "+getTime());
         }
     }
}


