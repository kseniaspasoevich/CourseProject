package Service3;

import Service1.RandomFieldsGenerator;

import java.sql.Time;
import java.time.LocalDate;
import java.time.Period;
import java.util.Queue;
import java.util.Random;

public class ExecutionOfService3 {

    public static double getUnloadDelay() { //задержка разгрузки в часах
        // (случайная величина от 0 до 1440 минутах (24 часа))

        return ((double) (Math.random() * 24.0));
    }

    public static double getFullUnloadTime(double unloadTime, double unloadDelayTime) {
        //задержка разгрузки в часах (случайная величина от 0 до 1440 минутах (24 часа))

        return (unloadDelayTime+unloadTime);
    }

    public static double getArrivalDeviation() {  //отклонение в прибытии

        double minimalArrivalEarlier = -168.0; //7 дней (7*24 часов)
        double maximumArrivalLater = 168.0;
        return (minimalArrivalEarlier + ((double) 2*(Math.random() * maximumArrivalLater)));
    }

    public static double getPenalty(double delay) { //с каждым часом задержки, штраф увеличывается за 100
        return delay * 100;
    }

    static Time getRealTimeOfArrival(Time estimatedTime, double deviation){
        //получаем реальное время прибытия корабля расписание+отклонение
        //отклонение преобразуем в время типа Time
        long deviationInMillis= (long) (deviation*86400*1000); //конвертируем отклонение из часов в милисекунды
        long fullTime=estimatedTime.getTime()+deviationInMillis; //конвертитуем время по рассписанию в милисекунды
        long realTime=(long) (fullTime*24 * 60 * 60); //получаем точное время
        //не забываем что отклонение может идти и с минусом, т.к. судно можеть заранее прибыть
        Time timeOfArrival=new Time(realTime);
        return timeOfArrival;
    }

    //здесь есть маленькая нелогичность
    static LocalDate getRealDayOfArrival(LocalDate estimatedDay, Time realArrivalTime, double deviation){
        if (deviation>0.00){ //день позже
            int exactAmountOfDaysLater= (int) (deviation/24.0);
            return estimatedDay.plus(Period.ofDays(exactAmountOfDaysLater));
        }
        else /*if (deviation<-24.00)*/{ //день раньше
            int exactAmountOfDaysEarly= (int) (deviation/24.0);
            return estimatedDay.minus(Period.ofDays(exactAmountOfDaysEarly));

        }
        /*else{
            return estimatedDay; //возвращает ту же дату потому что задержка всего несколько часов ТОГО же дня
        }*/
    }

    //закончи
    static Time getTimeOfWaitingUnload(Time arrivalTime, Queue<WaitingQueue> shipQueue){

        WaitingQueue element = new WaitingQueue();

        /*if (element.equals(shipQueue.peek())) {
            Time arrivalTimeDouble=ExecutionOfService3.getRealTimeOfArrival(RandomFieldsGenerator.getTime(),
                    ExecutionOfService3.getArrivalDeviation());
            double timeToDouble=arrivalTimeDouble.getTime();
        }
        else {
            double time1=0.99999;
        }*/

        double time1=0.99999;
        Time time=new Time((long) time1);
        return time ;
    }

}