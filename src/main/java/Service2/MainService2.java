package Service2;

import Service1.RandomFieldsGenerator;
import Service1.TimeTable;
import Service1.Type;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;


public class MainService2 {
    public static void main(String[] args) throws IOException {

        System.out.println("Time table: ");
        ArrayList<TimeTable> List = new ArrayList<TimeTable>();

        for (int i = 0; i < 4; i++) {
            TimeTable obj = new TimeTable();
            List.add(obj);
            System.out.println(obj);
        }


        System.out.println("Enter new ship? y/n");
        Scanner input = new Scanner(System.in);
        input.nextLine();

        if (input.equals("n")) {
            System.out.println("Time table finished");
            System.exit(0);
        }

        else {
            TimeTable newShip = new TimeTable();

            System.out.println("Enter the name of the ship:  ");
            String name = input.next();
            newShip.setName(name);

            System.out.println("Enter the time of arrival in MILLISECONDS: ");
            long timeInMilliseconds = input.nextLong();
            java.sql.Time time = new java.sql.Time(timeInMilliseconds);
            newShip.setTime(time);

            System.out.println("Enter day (only if arrival is planned in november 2020): ");
            int day = input.nextInt();
            LocalDate date = LocalDate.of(2020, 11, day);
            newShip.setDay(date);

            System.out.println("Enter the type (BULK, LIQUID or CONTAINER !!!): ");
            Type type1 = Type.valueOf(input.next());
            newShip.setType(type1);
            System.out.println("Enter the weight");
            int weight1 = input.nextInt();
            newShip.setWeight(weight1);
            double unload1 = RandomFieldsGenerator.getUnload(type1, weight1);
            newShip.setUnload(unload1);

            System.out.println(newShip);
            List.add(newShip);
        }

        //JSON формат рассписания

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(List);
        objectWriter.writeValue(Paths.get("timeTable.json").toFile(), List);
    }


}