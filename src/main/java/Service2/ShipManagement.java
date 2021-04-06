package Service2;

import Service1.RandomFieldsGenerator;
import Service1.TimeTable;
import Service1.Type;
import Service3.AdditionalParameters;
import Service3.ExecutionOfService3;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ShipManagement {

    public static void createShip(int initialAmountOfShips) throws IOException {
        System.out.println("Time table: \n");
        ArrayList<AdditionalParameters> List1 = new ArrayList<AdditionalParameters>();

        for (int i = 1; i <= initialAmountOfShips; i++) {
            AdditionalParameters obj = new AdditionalParameters();
            List1.add(obj);
            System.out.println(i + ":");
            System.out.println(obj);
        }


        while (true) {
            System.out.println("Enter new ship? y/n");
            Scanner input = new Scanner(System.in);
            String answer1 = input.next();

            if (answer1.equals("n")) {
                System.out.println("Time table completed!");
                System.exit(0);}

            else if (answer1.equals("y")){
                AdditionalParameters newShip = new AdditionalParameters();

                System.out.println("Enter the name of the ship:  ");
                String name = input.next();
                newShip.setName(name);

                System.out.println("Enter the time of arrival according to schedule in MILLISECONDS: ");
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

                ShipManagement.checkType(type1, weight1);

                newShip.setWeight(weight1);
                double unload1 = RandomFieldsGenerator.getUnload(type1, weight1);
                newShip.setUnload(unload1);

                System.out.println("-------------------");
                System.out.println(newShip);
                List1.add(newShip);
            }

            else {
                System.out.println("Invalid symbol!");
                System.exit(1);
            }


            //JSON формат рассписания
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(List1);
            objectWriter.writeValue(Paths.get("timeTable.json").toFile(), List1);
        }
    }

    public static void checkType(Type typeCheck, double weightCheck){
        if (typeCheck.toString().equals("BULK") && weightCheck>500000) {
            System.out.println("This type doesn't support more than 500 000 tones!");
            System.exit(2);
        }
        else if (typeCheck.toString().equals("CONTAINER") && weightCheck>20000) {
            System.out.println("This type doesn't support more than 20 000 tones!");
            System.exit(2);
        }
        else if (typeCheck.toString().equals("LIQUID") && weightCheck>320000) {
            System.out.println("This type doesn't support more than 320 000 tones!");
            System.exit(2);
        }
    }
}
