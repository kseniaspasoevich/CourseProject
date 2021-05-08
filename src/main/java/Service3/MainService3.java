package Service3;

import java.io.IOException;

public class MainService3 {
    public static void main(String[] args) throws IOException {
        /*System.out.println("Data from JSON file: \n");
        FromJSON.deserialize();*/
        //Unloading.unloading(5);
        //Unloading.startUnloading(Type.LIQUID);
        Unloading.getUnloadingReports(10);


    }


}
