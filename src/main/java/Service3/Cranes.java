package Service3;

import Service1.Type;
import Service2.ToJSON;

import java.io.IOException;

import static Service2.Global.List2;
import static Service2.Global.shipQueue;

public class Cranes implements Runnable{

    WaitingQueue obj = new WaitingQueue();

    public Cranes(Type type) {
       obj.setTypeOfTheShip(type);
    }

    @Override
    public void run() {
        for (int i=0; i<10; i++){ //Закыдиваем все судна в очередь
            WaitingQueue newShip=new WaitingQueue(); //создаём новое судно на каждой итерации
            shipQueue.add(newShip); //добавляем в очередь
            List2.add(newShip); //для добавления в json файл
            try {
                ToJSON.serializeReport();
            } catch (IOException e) {
                e.printStackTrace();
            }
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

}

