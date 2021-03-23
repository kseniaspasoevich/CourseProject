package Service2;

import Service1.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Scanner;


public class WorkWithJSON {
    public static void main(String[] args) throws IOException {

        System.out.println("Внесите колличество судн: ");
        Scanner scan=new Scanner(System.in);
        int input=scan.nextInt();

        System.out.println("JSON файл: ");

        for (int i=0; i<input; i++){
            TimeTable obj=new TimeTable();
            ObjectMapper objectMapper=new ObjectMapper();
            String json=objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            System.out.println(json);
            System.out.println("----------------");
        }
    }

}
