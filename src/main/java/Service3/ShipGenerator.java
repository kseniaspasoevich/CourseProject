package Service3;

public class ShipGenerator implements Runnable{

    ShipQueue shipQueue;

    public ShipGenerator() {
        this.shipQueue = ShipQueue.getInstance();
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++){
            shipQueue.put();
            try
            {
                Thread.sleep(700);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println(".... ГЕНЕРАЦИЯ НОВЫХ СУДОВ ЗАВЕРШЕНА ....");
        shipQueue.setGenerated(false);
    }
}
