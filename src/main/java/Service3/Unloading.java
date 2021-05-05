package Service3;

import Service1.*;

import java.util.LinkedList;
import java.util.Queue;

public class Unloading {
    private static AdditionalShipParameters ship;
    static Queue<AdditionalShipParameters> shipQueue=new LinkedList<>();
    static boolean unloadIsDone;



    public static boolean shipArrived(){
        return true;
    }
    public static boolean isUnloaded(){
        return true;
    }

    public static void startUnloading(Type typeOfShip) { //начинаем разгрузку,
        /// она зависит от веса и типа, получается и какая-то задержка разгрузки возможно
        //Проверить есть ли задержка разгрузки
        double weightOfCargo = RandomFieldsGenerator.getWeight(typeOfShip);
        double estimatedUnload = RandomFieldsGenerator.getUnload(typeOfShip, weightOfCargo);
        double delay = ExecutionOfService3.getUnloadDelay();
        double fullUnload=estimatedUnload+delay;
        System.out.println(String.valueOf(typeOfShip));
        System.out.println("Estimated: "+ estimatedUnload+" hours");
        System.out.println("Delay: "+ delay+ " hours");
        System.out.println("Penalty: "+ ExecutionOfService3.getPenalty(delay));
        System.out.println("Full unload took "+fullUnload+" hours\n");
    }

    public static void unload()
    {
        while (shipArrived()){
            Unloading.shipQueue.add(ship);
            if (Unloading.unloadIsDone==isUnloaded()) //correct the logic somehow
            {
                AdditionalShipParameters nextShip=shipQueue.element();
                System.out.println("Next ship: "+ nextShip); //перегрузить метод toString in AdditionalShipParameters
                Type typeOfNextShip=nextShip.getType();
                startUnloading(typeOfNextShip);
            }
            else {
                startUnloading(Type.CONTAINER);
            }

        }
    }

}
