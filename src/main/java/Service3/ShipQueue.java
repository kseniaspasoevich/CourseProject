package Service3;

import Service1.Type;
import Service2.Global;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ShipQueue {

    // статический экземпляр класса
    private static ShipQueue shipQueue;
    //приватный конструктор
    private ShipQueue() {
        generated = true;
    }
    // получение экземпляра
    public static ShipQueue getInstance(){
        // если экземпляр еще ни разу не создавался, то создаём
        if (shipQueue == null)
            shipQueue = new ShipQueue();
        // возвращаем статическое поле хранящее экземпляр этого же класса
        return shipQueue;
    }

    private Queue<Ship> shipQueueBulk = new ConcurrentLinkedQueue<>();
    private Queue<Ship> shipQueueContainer = new ConcurrentLinkedQueue<>();
    private Queue<Ship> shipQueueLiquid = new ConcurrentLinkedQueue<>();
    private boolean generated;


    // к synchronized методу может обращаться только один поток
    public synchronized Ship get(Type type) {
        switch (type) {
            case BULK:
                return shipQueueBulk.poll();
            case CONTAINER:
                return shipQueueContainer.poll();
            case LIQUID:
                return shipQueueLiquid.poll();
        }
        return null;
    }

    public synchronized void put() {
        Ship ship = new Ship();
        System.out.println("Добавлен в очередь корабль  " + ship.getNameOfTheShip() + " с типом " + ship.getTypeOfTheShip());

        Global.List2.add(ship);

        switch (ship.getTypeOfTheShip()) {
            case BULK:
                shipQueueBulk.add(ship);
                break;
            case CONTAINER:
                shipQueueContainer.add(ship);
                break;
            case LIQUID:
                shipQueueLiquid.add(ship);
                break;
        }
    }

    public boolean isGenerated() {
        return generated;
    }
    public void setGenerated(boolean generated) {
        this.generated = generated;
    }
}

