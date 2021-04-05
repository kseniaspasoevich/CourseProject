package Service3;

import Service1.*;
import Service2.*;

public class ExecutionOfService3 {

    public static double getUnloadDelay() { //задержка разгрузки в часах (случайная величина от 0 до 1440 минутах (24 часа))

        return ((double) (Math.random() * 24.0));
    }

    public static double getArrivalDeviation() {  //отклонение в прибытии

        double minimalArrivalEarlier = -168.0; //7 дней (7*24 часов)
        double maximumArrivalLater = 168.0;
        return minimalArrivalEarlier + ((double) 2*(Math.random() * maximumArrivalLater));
    }

    /*public static boolean isThereArrivalDeviation() { //есть отклонение в прибытии
        return true;
    }*/

    public static double getPenalty(double delay) { //с каждым часом задержки, штраф увеличывается за 100
        return delay * 100;
    }

}
