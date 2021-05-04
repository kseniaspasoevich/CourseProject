package Service3;

import Service1.*;

import java.sql.Time;
import java.time.LocalDate;
import java.time.Period;

public class Unloading {
    private static AdditionalShipParameters ship;

    public static boolean shipArrived(){
        return true;
    }

    public static void startUnloading(Type typeOfShip){ //начинаем разгрузку,
        /// она зависит от веса и типа, получается и какая-то задержка разгрузки возможно
        //сгенери вес на основе типа, не забудь!!
        double unload=ship.getUnload();
        double unloadDelay=ship.getDelayUnload();
        System.out.println("Unload expected: "+unload);
        System.out.println("Unload delay: "+ unloadDelay);
        System.out.println("Full unloading took "+unload+unloadDelay+" hours");
        System.out.println("Penalty: "+ship.getPenalty());
    }

    public static void unload()
    {
        while (shipArrived()){
            double arriveTimeDeviation=ship.getArrivalDeviation(); //корабль прибыл раньше или позже или вовремя

            if (arriveTimeDeviation==0.00){
                System.out.println("Arrived ON TIME!");
            }
            else {
                System.out.println("Arrival deviation: "+ arriveTimeDeviation);
                System.out.println("RealArrivalTime: "+ ExecutionOfService3.getRealTimeOfArrival(arriveTimeDeviation));
            }

            //print exact date and time of arrival
            startUnloading(Type.CONTAINER);
            startUnloading(Type.LIQUID);
            startUnloading(Type.BULK);

        }
    }

}
