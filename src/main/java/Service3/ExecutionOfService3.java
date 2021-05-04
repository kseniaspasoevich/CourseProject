package Service3;

import Service1.RandomFieldsGenerator;

import java.sql.Time;
import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

public class ExecutionOfService3 {

    public static double getUnloadDelay() { //задержка разгрузки в часах (случайная величина от 0 до 1440 минутах (24 часа))

        return ((double) (Math.random() * 24.0));
    }

    public static double getArrivalDeviation() {  //отклонение в прибытии

        double minimalArrivalEarlier = -168.0; //7 дней (7*24 часов)
        double maximumArrivalLater = 168.0;
        return (minimalArrivalEarlier + ((double) 2*(Math.random() * maximumArrivalLater)));
    }

    public static double getPenalty(double delay) { //с каждым часом задержки, штраф увеличывается за 100
        return delay * 100;
    }

    static Time getRealTimeOfArrival(double deviation){
        //получаем реальное время прибытия корабля расписание+отклонение
        //отклонение преобразуем в время типа Time
        Time randomTime= RandomFieldsGenerator.getTime(); //время по рассписанию
        long deviationInMillis= (long) (deviation*86_400_000); //86400*1000, конвертируем отклонение из часов в милисекунды
        long timeAccordingToScedule= randomTime.getTime(); //конвертитуем время по рассписанию в милисекунды
        long realTime=(long) ((deviationInMillis+timeAccordingToScedule)*24 * 60 * 60 * 1000); //получаем точное время
        //не забываем что отклонение может идти и с минусом, т.к. судно можеть заранее прибыть
        Time time=new Time(realTime);
        return time;
    }
    static LocalDate getRealDayOfArrival(double deviation){
        LocalDate day1= RandomFieldsGenerator.getDay();
        if (deviation>24.00){ //день позже
            int exactAmountOfDaysLater= (int) (deviation/24);
            return day1.plus(Period.ofDays(exactAmountOfDaysLater));
        }
        else if (deviation<-24.00){ //день раньше
            int exactAmountOfDaysEarly= (int) (deviation/24);
            return day1.minus(Period.ofDays(exactAmountOfDaysEarly));

        }
        else{
            return day1; //возвращает ту же дату потому что задержка всего несколько часов ТОГО же дня
        }
    }

}