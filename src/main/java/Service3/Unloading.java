package Service3;

import Service1.Type;
import Service2.ToJSON;
import org.springframework.cglib.beans.BulkBean;

import java.io.IOException;
import static Service2.Global.*;

public class Unloading {
    /*private static AdditionalShipParameters ship;
    //static boolean unloadIsDone;
    /*public static boolean shipArrived(){
        return true;
    }
    public static boolean isUnloaded(){
        return true;
    }*/

    /*public static void startUnloading(Type typeOfShip, double estimatedUnload) { //начинаем разгрузку,
        double delay = ExecutionOfService3.getUnloadDelay();
        double fullUnload=estimatedUnload+delay;
        System.out.println("Unloading report for "+String.valueOf(typeOfShip)+" :");
        System.out.println("Delay: "+ delay+ " hours");
        System.out.println("Penalty: "+ ExecutionOfService3.getPenalty(delay)+ " y. e.");
        System.out.println("Full unload took "+fullUnload+" hours\n");
    }*/

    public static void getUnloadingReports(int amountOfShips) throws IOException {
        for (int i=0; i<amountOfShips; i++){ //Закыдиваем все судна в очередь
            WaitingQueue newShip=new WaitingQueue(); //создаём новое судно на каждой итерации
            shipQueue.add(newShip); //добавляем в очередь
            List2.add(newShip); //для добавления в json файл
            ToJSON.serializeReport();
        }

        System.out.println("Unloading started: ");

        //извлекаем одно судно за другим и получаем отчёт о разгрузке
        while (!(shipQueue.isEmpty())){
            WaitingQueue ship2= shipQueue.peek();
            System.out.println(ship2);
            shipQueue.remove();
            System.out.println("-------------------------------");
        }
    }

    public static void simulate(){
        WaitingQueue unloader1 = new WaitingQueue(Type.CONTAINER);
        WaitingQueue unloader2 = new WaitingQueue(Type.LIQUID);
        WaitingQueue unloader3 = new WaitingQueue(Type.BULK);
        Thread t1 = new Thread(unloader1);
        Thread t2 = new Thread(unloader2);
        Thread t3 = new Thread(unloader3);
        t1.start();
        t2.start();
        t3.start();
    }

}