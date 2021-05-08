package Service3;

import Service1.*;

import java.sql.Time;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Queue;

import static Service2.Global.shipQueue;

public class Unloading {
    /*private static AdditionalShipParameters ship;
    //static boolean unloadIsDone;
    /*public static boolean shipArrived(){
        return true;
    }
    public static boolean isUnloaded(){
        return true;
    }*/

    public static void startUnloading(Type typeOfShip, double estimatedUnload) { //начинаем разгрузку,
        double delay = ExecutionOfService3.getUnloadDelay();
        double fullUnload=estimatedUnload+delay;
        System.out.println("Unloading report for "+String.valueOf(typeOfShip)+" :");
        System.out.println("Delay: "+ delay+ " hours");
        System.out.println("Penalty: "+ ExecutionOfService3.getPenalty(delay)+ " y. e.");
        System.out.println("Full unload took "+fullUnload+" hours\n");
    }

    public static void getUnloadingReports(int amountOfShips){
        for (int i=0; i<amountOfShips; i++){ //Закыдиваем все судна в очередь
            String NAME=RandomFieldsGenerator.getName();
            Time ESTIMATEDTIME=RandomFieldsGenerator.getTime();
            double DEVIATION=ExecutionOfService3.getArrivalDeviation();
            Time REALTIME=ExecutionOfService3.getRealTimeOfArrival(ESTIMATEDTIME, DEVIATION);
            LocalDate DATE=RandomFieldsGenerator.getDay();
            LocalDate REALDATE=ExecutionOfService3.getRealDayOfArrival(DATE, REALTIME, DEVIATION);
            Type TYPE=RandomFieldsGenerator.getType();
            double WEIGHT=RandomFieldsGenerator.getWeight(TYPE);
            double UNLOADEXPECTED=RandomFieldsGenerator.getUnload(TYPE, WEIGHT);

            WaitingQueue newShip=new WaitingQueue(NAME, ESTIMATEDTIME, DEVIATION, REALTIME, DATE, REALDATE, TYPE,
                    WEIGHT, UNLOADEXPECTED); //создаём новое судно на каждой итерации
            shipQueue.add(newShip); //добавляем в очередь
        }
        System.out.println("Unloading started: ");

        //извлекаем одно судно за другим и получаем отчёт о разгрузке
        while (!(shipQueue.isEmpty())){
            WaitingQueue ship2= shipQueue.peek();
            System.out.println(ship2);
            startUnloading(ship2.getTypeOfTheShip(), ship2.estimatedTimeOfUnload);
            shipQueue.remove();
            System.out.println("-------------------------------");
        }
    }
}