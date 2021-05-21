package restcontroller;


import Service1.TimeTable;
import Service3.FromJSON;
import Service3.FromJSON;
import Service3.WaitingQueue;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static Service2.Global.List2;

@RestController
@RequestMapping("/api")
public class TimeTableController {

    //сервис 1
    @GetMapping("/timetable")
    public List<TimeTable> getTimeTable() {
        List<TimeTable> list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            list.add(new TimeTable());
        return list;
    }

    // сервис2
    // ПРИМЕР ССЫЛКИ http://localhost:8080/api/timetable/15
    @GetMapping("/timetable/{nameOfTheFile}")
    public String getTimeTable(@PathVariable String nameOfTheFile) {
        System.out.println("Data: "+ nameOfTheFile);
        try{
            ObjectMapper objectMapper=new ObjectMapper();
            JsonFactory jf=new JsonFactory();
            JsonParser jp = jf.createParser(new File("Report.json"));
            List<WaitingQueue> lst=null;

            TypeReference<List<WaitingQueue>> tRef = new TypeReference<List<WaitingQueue>>() {};
            lst = objectMapper.readValue(jp, tRef);
            for (WaitingQueue user : lst) {
                System.out.println(user.toString());
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }

        if (!nameOfTheFile.equals("Report.json"))
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found!!"
            );
        return nameOfTheFile;
    }

    // ПРИМЕР ССЫЛКИ http://localhost:8080/api/timetable
    // И в BODY пишешь непосредственно JSON обхект
    //{
    //"name": "782FinlandBay",
    //"time": "21:58:16",
    //"day": "12/11/2020",
    //"type": "CONTAINER",
    //"weight": 40399.252990944464,
    //"unload": 6.733208831824077
    //}
    @PostMapping("/timetable")
    public TimeTable postTimeTable(@RequestBody TimeTable timeTable) {
        System.out.println(timeTable);
        return timeTable;
    }

// ПРИМЕР ССЫЛКИ http://localhost:8080/api/timetable/test?name=heeelllooo
    @GetMapping("/timetable/report/json")
    public void testMethod(/*@RequestParam String name*/){
        try{
            ObjectMapper objectMapper=new ObjectMapper();
            JsonFactory jf=new JsonFactory();
            JsonParser jp = jf.createParser(new File("Report.json"));
            List<WaitingQueue> lst=null;

            TypeReference<List<WaitingQueue>> tRef = new TypeReference<List<WaitingQueue>>() {};
            lst = objectMapper.readValue(jp, tRef);
            //здесь уже выводится содержимое джейсона!!!
            for (WaitingQueue user : lst) {
                System.out.println(user.toString());
            }

        }
        catch (IOException e){
            e.printStackTrace();
        }
        //System.out.println(name);
        //return name;
    }


}
