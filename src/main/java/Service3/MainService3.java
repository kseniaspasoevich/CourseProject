package Service3;

import Service1.Type;
import Service2.ToJSON;

import java.io.IOException;

public class MainService3 {
    public static void main(String[] args) throws IOException {
        System.out.println("Data from JSON file: \n");
        ToJSON.serializeReport();
        FromJSON.deserializeReport();
        Unloading.getUnloadingReports(10);
    }
}
