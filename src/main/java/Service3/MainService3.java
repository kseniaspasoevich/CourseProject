package Service3;

import Service1.Type;
import jdk.swing.interop.SwingInterOpUtils;

import java.io.IOException;

public class MainService3 {
    public static void main(String[] args) throws IOException {
        /*System.out.println("Data from JSON file: \n");
        FromJSON.deserialize();*/
        Unloading.startUnloading(Type.CONTAINER);
        Unloading.startUnloading(Type.BULK);
        Unloading.startUnloading(Type.LIQUID);

    }


}
