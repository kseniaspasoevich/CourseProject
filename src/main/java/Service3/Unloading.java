package Service3;

import Service1.*;

import java.sql.Time;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Queue;

public class Unloading {
    private static AdditionalShipParameters ship;
    static Queue<QueueElements> shipQueue=new LinkedList<>();
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

    //временно, для тестирования
    public static void doSomething(int amountOfShips){
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

            QueueElements newShip=new QueueElements(NAME, ESTIMATEDTIME, DEVIATION, REALTIME, DATE, REALDATE, TYPE,
                    WEIGHT, UNLOADEXPECTED); //создаём новое судно на каждой итерации
            shipQueue.add(newShip); //добавляем в очередь
        }
        System.out.println("QueueElements of Arrived Ships: ");
        System.out.println(shipQueue);

        //тут немножко логику поправь
        QueueElements ship2= shipQueue.peek();
        System.out.println("\n-----------------\n");
        startUnloading(ship2.getTypeOfTheShip());
        System.out.println(ship2);
    }

    public static void unloading(int amountOfShips) //function that is going to be executed in threads
    {
        /*for (int i=0; i<amountOfShips; i++){ //Закыдиваем все судна в очередь

            shipQueue.add(ship);
        }*/

        while (shipQueue.isEmpty()){ //изначально мы генерируем 5 судов, но как-то так
            TimeTable ship1=shipQueue.element(); //достаём первый элемент из очереди и разгружаем
            AdditionalShipParameters ship2= (AdditionalShipParameters) shipQueue.element();
            startUnloading(ship1.getType()); //генерируем тип и разгружаем
            shipQueue.remove(); //удаляем из очереди

            /*if (Unloading.unloadIsDone==isUnloaded()) //correct the logic somehow
            {
                AdditionalShipParameters nextShip=shipQueue.element();
                System.out.println("Next ship: "+ nextShip); //перегрузить метод toString in AdditionalShipParameters
                Type typeOfNextShip=nextShip.getType();
                startUnloading(typeOfNextShip);
                //ExecutionOfService3.getFullUnloadTime(bla bla bla ....)
                //ExecutionOfService3.getTimeOfWaitingForUnload()
                //sout
            }
            else {
                startUnloading(Type.CONTAINER);
                //shipQueue.
            }*/

        }
    }

}
