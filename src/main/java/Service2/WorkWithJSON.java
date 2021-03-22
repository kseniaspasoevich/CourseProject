package Service2;
import Service1.*;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.io.StringWriter;
import java.sql.Time;
import java.time.LocalDate;


public class WorkWithJSON {
    public static void main(String[] args) throws IOException {
    TimeTable obj=new TimeTable();
    String someName=obj.generateName();
    Time someTime=obj.generateTime();
    LocalDate someDay=obj.generateDay();
    typeAndWeight someType=obj.generateType();
    double someWeight=obj.generateWeight();
    double someUnload=obj.generateTimeOfUnloading();

    obj.setDay(someDay);
    obj.setName(someName);
    obj.setTime(someTime);
    obj.setType(someType);
    //obj.setWeight(someWeight);
    //obj.setUnload(someUnload);

    ObjectMapper objectMapper=new ObjectMapper();
    StringWriter stringEmp = new StringWriter();
    objectMapper.writeValue(stringEmp, obj);
    System.out.println(stringEmp);

    }

}
