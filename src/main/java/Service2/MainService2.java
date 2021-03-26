package Service2;

import Service1.*;
import Service3.*;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class MainService2 {
    public static void main(String[] args) throws IOException {
        System.out.println("Расписание: ");

        ArrayList<TimeTable> List = new ArrayList<TimeTable>();
        for (int i = 0; i < 3; i++) {
            TimeTable obj = new TimeTable();
            List.add(obj);
            System.out.println(obj);
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Enter new ship? y/n");
        input.nextLine();

        if (!input.equals("n")) {

            TimeTable obj = new TimeTable();
            List.add(obj);
            System.out.println(obj);
            System.out.println("Was there Arrival deviation? yes/no");
            input.nextLine();
            if (input.equals("yes")) {
                System.out.println(ExecutionOfService3.getArrivalDeviation());
            }}

            //JSON формат рассписания

            ObjectMapper objectMapper = new ObjectMapper();
            ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(List);
            objectWriter.writeValue(Paths.get("timeTable.json").toFile(), List);
        }


    }