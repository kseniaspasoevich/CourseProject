package Service3;

public class Cranes {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread()); //automatically generated  thread

        new Thread(){  //our own thread
            @Override
            public void run(){
                System.out.println(Thread.currentThread());
            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        })

        {  //our own thread
            @Override
            public void run(){
                System.out.println(Thread.currentThread());
            }
        }.start();
    }

}
