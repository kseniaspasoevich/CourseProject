package Service3;

import Service1.*;
import Service2.*;

public class executionOfService3 {

    public static double getUnloadDelay(){ //задержка разгрузки в часах (случайная величина от 0 до 1440 минутах (24 часа))

        return ((double) (Math.random() * 24.0));
    }

    public static double getArrivalDeviation(){
        double minimalArrivalEarlier=-168.0; //7 дней (7*24 часов)
        double maximumArrivalLater=168.0;
        return minimalArrivalEarlier+((double) (Math.random() * maximumArrivalLater));
    }

    public static boolean isThereArrivalDeviation(){ //есть отклонение в прибытии
        return true;
    }

    public static double getPenalty(){ //с каждым часом задержки, штраф увеличывается за 100 чего-то, валюту уточниь???
       return getUnloadDelay()*100;
    }

}
