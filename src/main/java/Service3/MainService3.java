package Service3;


import java.io.IOException;

public class MainService3 {
    public static void main(String[] args) throws IOException {
        Unloading.simulate();
        //FromJSON.deserializeReport();
        Stats obj=new Stats();
        System.out.println(obj);

    }
}
