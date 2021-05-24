package restcontroller;

import Service1.RandomFieldsGenerator;
import Service1.TimeTable;
import Service1.Type;
import Service2.ToJSON;
import Service3.ExecutionOfService3;
import Service3.WaitingQueue;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static Service2.Global.*;

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

    // сервис2 + сервис 3
    // возвращает json файлы по имени
    @GetMapping("/timetable/report/json")
    public List<? extends Object> getReportDocument(@RequestParam String name) throws IOException {

        final ObjectMapper objectMapper = new ObjectMapper();
        if (name.equals("Report.json")) {
            List<WaitingQueue> element = objectMapper.readValue(
                    new File("Report.json"),
                    new TypeReference<List<WaitingQueue>>() {
                    });
            return element;
        } else if (name.equals("timeTable.json")) {
            List<TimeTable> element1 = objectMapper.readValue(
                    new File("timeTable.json"),
                    new TypeReference<List<TimeTable>>() {
                    });
            return element1;
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "entity not found");
        }
    }

    // отправляет результаты работы сервиса 3 в json файл
    //метод выше возвращает также и Report.json
    @PostMapping("/timetable")
    public void postTimeTable() throws IOException {
        for (int i=0; i<10; i++){ //Закыдиваем все судна в очередь
            WaitingQueue newShip=new WaitingQueue(); //создаём новое судно на каждой итерации
            shipQueue.add(newShip); //добавляем в очередь
            List2.add(newShip); //для добавления в json файл
            ToJSON.serializeReport();
        }
        }
    }
