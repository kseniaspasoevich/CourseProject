package Service2;

import Service1.*;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Расписание: ");

        ArrayList<TimeTable> List = new ArrayList<TimeTable>();
        for (int i = 0; i < 3; i++) {
            TimeTable obj=new TimeTable();
            List.add(obj);
            System.out.println(obj);
        }

        //JSON формат рассписания

        for (int i = 0; i < 3; i++) {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectWriter objectWriter=objectMapper.writer(new DefaultPrettyPrinter());
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(List);
            objectWriter.writeValue(Paths.get("timeTable.json").toFile(), List);

        }
    }
}


